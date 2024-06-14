using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Threading;
using System.Threading.Tasks;
using NuGet.Common;
using NuGet.Configuration;
using NuGet.Frameworks;
using NuGet.Packaging;
using NuGet.Packaging.Core;
using NuGet.Packaging.Signing;
using NuGet.Protocol;
using NuGet.Protocol.Core.Types;
using NuGet.Versioning;

public class DependencyResolver
{
    private readonly SourceCacheContext _cacheContext;
    private readonly ILogger _logger;
    private readonly List<SourceRepository> _repositories;

    public DependencyResolver()
    {
        _cacheContext = new SourceCacheContext();
        _logger = NullLogger.Instance;
        _repositories = new List<SourceRepository>
        {
            Repository.Factory.GetCoreV3("https://api.nuget.org/v3/index.json")
        };

    }

    public async Task<IEnumerable<string>> ResolveDependencies(string packageId, string version)
    {
        Console.WriteLine($"Resolving dependencies for package {packageId}, version {version}.");

        NuGetVersion nuGetVersion;
        if (version == "latest")
        {
            nuGetVersion = await GetLatestVersionAsync(packageId);
            Console.WriteLine($"Resolved latest version for package {packageId}: {nuGetVersion}");
        }
        else
        {
            nuGetVersion = NuGetVersion.Parse(version);
            Console.WriteLine($"Using specified version {nuGetVersion} for package {packageId}");
        }

        var packageIdentity = new PackageIdentity(packageId, nuGetVersion);
        var framework = NuGetFramework.Parse(".NETCoreApp,Version=v8.0");
        var downloadTasks = new List<Task<IEnumerable<string>>>();

        foreach (var repo in _repositories)
        {
            Console.WriteLine($"Checking repository {repo.PackageSource.Source} for package {packageId}.");
            var resource = await repo.GetResourceAsync<DependencyInfoResource>();
            var dependencyInfo = await resource.ResolvePackage(
                packageIdentity,
                framework,
                _cacheContext,
                _logger,
                CancellationToken.None
            );

            if (dependencyInfo != null)
            {
                Console.WriteLine($"Found package {packageId} in repository {repo.PackageSource.Source}.");
                downloadTasks.Add(DownloadPackage(repo, dependencyInfo));
            }
            else
            {
                Console.WriteLine($"Package {packageId} not found in repository {repo.PackageSource.Source}.");
            }
        }

        var results = await Task.WhenAll(downloadTasks);
        Console.WriteLine($"Resolved dependencies for package {packageId}: {string.Join(", ", results.SelectMany(r => r))}");
        return results.SelectMany(r => r);
    }

    private async Task<NuGetVersion> GetLatestVersionAsync(string packageId)
    {
        Console.WriteLine($"Fetching latest version for package {packageId}.");
        foreach (var repo in _repositories)
        {
            var findPackageByIdResource = await repo.GetResourceAsync<FindPackageByIdResource>();
            var versions = await findPackageByIdResource.GetAllVersionsAsync(packageId, _cacheContext, _logger, CancellationToken.None);
            if (versions != null && versions.Any())
            {
                var latestVersion = versions.Max();
                Console.WriteLine($"Found latest version {latestVersion} for package {packageId} in repository {repo.PackageSource.Source}.");
                return latestVersion;
            }
        }
        throw new InvalidOperationException($"Unable to find package '{packageId}'");
    }

    private async Task<IEnumerable<string>> DownloadPackage(SourceRepository repository, SourcePackageDependencyInfo package)
    {
        Console.WriteLine($"Downloading package {package.Id} version {package.Version} from repository {repository.PackageSource.Source}.");

        var baseDirectory = AppContext.BaseDirectory;
        var userDllsDirectory = Path.Combine(baseDirectory, "userdlls");

        if (!Directory.Exists(userDllsDirectory))
        {
            Directory.CreateDirectory(userDllsDirectory);
        }

        var packagePathResolver = new PackagePathResolver(userDllsDirectory);
        var clientPolicyContext = ClientPolicyContext.GetClientPolicy(NullSettings.Instance, _logger);
        var packageExtractionContext = new PackageExtractionContext(
            PackageSaveMode.Defaultv3,
            XmlDocFileSaveMode.Skip,
            clientPolicyContext,
            _logger
        );

        var downloadResource = await repository.GetResourceAsync<DownloadResource>();
        var downloadResult = await downloadResource.GetDownloadResourceResultAsync(
            package,
            new PackageDownloadContext(_cacheContext),
            SettingsUtility.GetGlobalPackagesFolder(NullSettings.Instance),
            _logger,
            CancellationToken.None
        );

        if (downloadResult.Status == DownloadResourceResultStatus.Available)
        {
            Console.WriteLine($"Package {package.Id} version {package.Version} downloaded successfully.");
            var packageReader = downloadResult.PackageReader;
            var libItems = await packageReader.GetLibItemsAsync(CancellationToken.None);
            var assemblies = new List<string>();

            foreach (var itemGroup in libItems)
            {
                foreach (var item in itemGroup.Items)
                {
                    if (item.EndsWith(".dll", StringComparison.OrdinalIgnoreCase))
                    {
                        var targetFilePath = Path.Combine(userDllsDirectory, Path.GetFileName(item));
                        if (File.Exists(targetFilePath))
                        {
                            Console.WriteLine($"Assembly {Path.GetFileName(item)} already exists. Skipping download.");
                            assemblies.Add(targetFilePath);
                        }
                        else
                        {
                            using (var stream = packageReader.GetStream(item))
                            using (var fileStream = File.Create(targetFilePath))
                            {
                                await stream.CopyToAsync(fileStream);
                            }
                            assemblies.Add(targetFilePath);
                            var assemblyVersion = AssemblyName.GetAssemblyName(targetFilePath).Version;
                            Console.WriteLine($"Extracted {item} to {targetFilePath} (Assembly Version: {assemblyVersion})");
                        }
                    }
                }
            }

            return assemblies;
        }

        Console.WriteLine($"Package {package.Id} version {package.Version} is not available for download.");
        return Enumerable.Empty<string>();
    }

}

