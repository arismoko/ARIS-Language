using System.Collections.Concurrent;
using System.Reflection;
using System.Security.Cryptography;
using System.Text;
using Microsoft.CodeAnalysis;
using Microsoft.CodeAnalysis.CSharp;
using Newtonsoft.Json;
using Microsoft.CodeAnalysis.Emit;
using System.Text.RegularExpressions;
using System.Linq;
using System.Threading.Tasks;
using System.Runtime.Loader;

namespace Arisl
{
    public class CustomAssemblyLoadContext : AssemblyLoadContext
    {
        public CustomAssemblyLoadContext() : base(isCollectible: true)
        {
        }

        protected override Assembly Load(AssemblyName assemblyName)
        {
            // Provide custom logic here if needed, otherwise return null
            // to allow the default load context to load the assembly.
            return null;
        }

        public new Assembly LoadFromAssemblyPath(string assemblyPath)
        {
            return base.LoadFromAssemblyPath(assemblyPath);
        }

        public Assembly LoadFromStream(Stream assemblyStream)
        {
            return base.LoadFromStream(assemblyStream);
        }
    }

    public class CSharpCompiler
    {
        private static ConcurrentDictionary<string, Assembly> _cache = new ConcurrentDictionary<string, Assembly>();
        private static List<MetadataReference> _references = new List<MetadataReference>();
        private readonly DependencyResolver _dependencyResolver = new DependencyResolver();
        private CustomAssemblyLoadContext _loadContext = new CustomAssemblyLoadContext();
        private ArislCodeGenerator.SourceMap _sourceMap;

        public CSharpCompiler(ArislCodeGenerator.SourceMap sourceMap = null)
        {
            _sourceMap = sourceMap;
            //Console.WriteLine("Initializing C# compiler");
            InitializeDefaultReferences();
        }

        private void InitializeDefaultReferences()
        {
            // Add references for essential assemblies
            _references.Add(MetadataReference.CreateFromFile(GetAssemblyPath(typeof(object).Assembly.GetName().Name)));
            _references.Add(MetadataReference.CreateFromFile(GetAssemblyPath(typeof(Console).Assembly.GetName().Name)));
            _references.Add(MetadataReference.CreateFromFile(GetAssemblyPath(typeof(System.Dynamic.DynamicObject).Assembly.GetName().Name)));
            _references.Add(MetadataReference.CreateFromFile(GetAssemblyPath(typeof(Microsoft.CSharp.RuntimeBinder.Binder).Assembly.GetName().Name)));
            _references.Add(MetadataReference.CreateFromFile(GetAssemblyPath("System.Console")));
            _references.Add(MetadataReference.CreateFromFile(GetAssemblyPath("System.Runtime")));
            _references.Add(MetadataReference.CreateFromFile(GetAssemblyPath("System.Linq")));
            _references.Add(MetadataReference.CreateFromFile(GetAssemblyPath("System.Collections")));
            _references.Add(MetadataReference.CreateFromFile(GetAssemblyPath("netstandard")));
            _references.Add(MetadataReference.CreateFromFile(GetAssemblyPath("System.Private.Uri")));
        }

        private string GetAssemblyPath(string assemblyName)
        {
            return Path.Combine(AppContext.BaseDirectory, assemblyName + ".dll");
        }

        public async Task<Assembly> CompileAndCacheAsync(string code)
        {
            string cacheKey = ComputeHash(code);
            if (_cache.TryGetValue(cacheKey, out var cachedAssembly))
            {
                return cachedAssembly;
            }

            var syntaxTree = CSharpSyntaxTree.ParseText(code);

            var references = new List<MetadataReference>(_references);

            var compilation = CSharpCompilation.Create(
                "EmbeddedScriptAssembly",
                new[] { syntaxTree },
                references,
                new CSharpCompilationOptions(OutputKind.ConsoleApplication)
            );

            using (var ms = new MemoryStream())
            {
                var result = compilation.Emit(ms);
                if (result.Success)
                {
                    var assemblyBytes = ms.ToArray();
                    var assembly = Assembly.Load(assemblyBytes);
                    _cache.TryAdd(cacheKey, assembly);
                    return assembly;
                }
                else
                {
                    //find the line number of class Csharp
                    var lines = code.Split(new[] { "\r\n", "\r", "\n" }, StringSplitOptions.None);
                    int line = 0;
                    for (int i = 0; i < lines.Length; i++)
                    {
                        if (lines[i].Contains("public class Csharp"))
                        {
                            line = i + 1;
                            break;
                        }
                    }
                    var usings = ExtractNamespaces(code);
                    //Console.WriteLine("Compilation failed.");
                    await LogCompilationErrors(result, line - usings.Count);
                    return null;
                }
            }
        }

        public async Task CheckSyntaxAndBasicErrorsAsync(string code)
        {
            var syntaxTree = CSharpSyntaxTree.ParseText(code);

            var references = new List<MetadataReference>(_references);

            var compilation = CSharpCompilation.Create(
                "SyntaxCheckAssembly",
                new[] { syntaxTree },
                references,
                new CSharpCompilationOptions(OutputKind.DynamicallyLinkedLibrary)
            );

            var diagnostics = compilation.GetDiagnostics();

            if (diagnostics.Length > 0)
            {
                await LogDiagnostics(diagnostics);
            }
        }

        private async Task LogCompilationErrors(EmitResult result, int skipCount)
        {
            List<CompilationError> compilationErrors = new List<CompilationError>();

            foreach (var diagnostic in result.Diagnostics)
            {
                var lineSpan = diagnostic.Location.GetLineSpan();
                var line = lineSpan.StartLinePosition.Line + skipCount;
                var column = lineSpan.StartLinePosition.Character;
                //Console.WriteLine($"Error at line {line}, column {column}: {diagnostic.GetMessage()}");
                //Console.WriteLine($"SourceMap is null? {_sourceMap == null}");
                // Map the generated line and column to the original source line and column if source map is available
                if (_sourceMap != null)
                {
                    var originalPosition = _sourceMap.GetOriginalPosition(line + 1, column + 1);
                    if (originalPosition != null)
                    {
                        line = originalPosition.OriginalLine - 1;
                        column = originalPosition.OriginalColumn - 1;
                    }
                }

                var error = new CompilationError
                {
                    Id = diagnostic.Id,
                    Message = diagnostic.GetMessage(),
                    Line = line,
                    Column = column
                };
                compilationErrors.Add(error);
            }

            var uniqueErrors = compilationErrors.GroupBy(e => new { e.Line, e.Column, e.Message })
                                                .Select(g => g.First())
                                                .ToList();

            var jsonErrors = JsonConvert.SerializeObject(uniqueErrors, Formatting.Indented);

            Console.WriteLine("Errors:" + jsonErrors);
            var file = ARISLInterpreter.CurrentActiveFilesName;
            var errorFileName = Path.ChangeExtension(file, ".arilog");
            if (File.Exists(errorFileName))
            {
                File.Delete(errorFileName);
            }
            await File.WriteAllTextAsync($"{ARISLInterpreter.CurrentActiveFilesName}.arilog", jsonErrors);
            Console.WriteLine($"Error log generated at compilation.arilog");
        }

        private async Task LogDiagnostics(IEnumerable<Diagnostic> diagnostics, int skipCount = 0)
        {
            List<CompilationError> compilationErrors = new List<CompilationError>();

            foreach (var diagnostic in diagnostics.Skip(skipCount))
            {
                var lineSpan = diagnostic.Location.GetLineSpan();
                var line = lineSpan.StartLinePosition.Line;
                var column = lineSpan.StartLinePosition.Character;

                // Map the generated line and column to the original source line and column if source map is available
                if (_sourceMap != null)
                {
                    var originalPosition = _sourceMap.GetOriginalPosition(line + 1, column + 1);
                    if (originalPosition != null)
                    {
                        line = originalPosition.OriginalLine - 1;
                        column = originalPosition.OriginalColumn - 1;
                    }
                }

                var error = new CompilationError
                {
                    Id = diagnostic.Id,
                    Message = diagnostic.GetMessage(),
                    Line = line,
                    Column = column
                };
                compilationErrors.Add(error);
            }

            var uniqueErrors = compilationErrors.GroupBy(e => new { e.Line, e.Column, e.Message })
                                                .Select(g => g.First())
                                                .ToList();

            var jsonErrors = JsonConvert.SerializeObject(uniqueErrors, Formatting.Indented);

            Console.WriteLine("Errors:" + jsonErrors);
            var file = ARISLInterpreter.CurrentActiveFilesName;
            var errorFileName = Path.ChangeExtension(file, ".arilog");
            if (File.Exists(errorFileName))
            {
                File.Delete(errorFileName);
            }
            await File.WriteAllTextAsync(errorFileName, jsonErrors);
            Console.WriteLine($"Error log generated at {errorFileName}");
        }

        public async Task DownloadDotNetAssemblies(IEnumerable<string> packageIds, string version = null)
        {
            foreach (var packageId in packageIds)
            {
                var assemblies = await _dependencyResolver.ResolveDependencies(packageId, version ?? "latest");
                foreach (var assemblyPath in assemblies)
                {
                    var assembly = _loadContext.LoadFromAssemblyPath(assemblyPath);
                    var assemblyName = AssemblyName.GetAssemblyName(assemblyPath).Name;
                    //Console.WriteLine($"Adding assembly reference: {assemblyName} from {assemblyPath}");
                    _references.Add(MetadataReference.CreateFromFile(assemblyPath));
                }
            }
        }

        public async Task DownloadDotNetAssembly(string packageId, string version = null)
        {
            var assemblies = await _dependencyResolver.ResolveDependencies(packageId, version ?? "latest");
            foreach (var assemblyPath in assemblies)
            {
                var assembly = _loadContext.LoadFromAssemblyPath(assemblyPath);
                var assemblyName = AssemblyName.GetAssemblyName(assemblyPath).Name;
                //Console.WriteLine($"Adding reference: {assemblyName} from {assemblyPath}");
                _references.Add(MetadataReference.CreateFromFile(assemblyPath));
            }
        }

        private string ComputeHash(string input)
        {
            using (var sha256 = SHA256.Create())
            {
                var bytes = Encoding.UTF8.GetBytes(input);
                var hash = sha256.ComputeHash(bytes);
                return Convert.ToBase64String(hash);
            }
        }

        public class CompilationError
        {
            public string Id { get; set; }
            public string Message { get; set; }
            public int Line { get; set; }
            public int Column { get; set; }
        }

        public async Task<string> GetMethodInfoAsync(string name, Assembly dynamicAssembly = null)
        {
            // Search in the default references
            foreach (var reference in _references)
            {
                try
                {
                    var assembly = Assembly.Load(Path.GetFileNameWithoutExtension(reference.Display));
                    //Console.WriteLine($"Inspecting assembly: {assembly.FullName}");
                    var types = assembly.GetTypes();
                    foreach (var type in types)
                    {
                        var methods = type.GetMethods(BindingFlags.Public | BindingFlags.NonPublic | BindingFlags.Instance | BindingFlags.Static);
                        foreach (var method in methods)
                        {
                            if (method.Name == name)
                            {
                                var result = new MethodInfoResult
                                {
                                    MethodName = method.Name,
                                    ReturnType = method.ReturnType.FullName,
                                    Parameters = method.GetParameters().Select(p => p.ParameterType.Name + " " + p.Name).ToArray(),
                                    Message = "Method found"
                                };
                                return JsonConvert.SerializeObject(result);
                            }
                        }
                    }
                }
                catch (Exception ex)
                {
                    Console.WriteLine($"Failed to load assembly: {reference.Display}. Exception: {ex.Message}");
                }
            }

            // Search in the dynamic assembly if provided
            if (dynamicAssembly != null)
            {
                try
                {
                    var types = dynamicAssembly.GetTypes();
                    foreach (var type in types)
                    {
                        var methods = type.GetMethods(BindingFlags.Public | BindingFlags.NonPublic | BindingFlags.Instance | BindingFlags.Static);
                        foreach (var method in methods)
                        {
                            if (method.Name == name)
                            {
                                var result = new MethodInfoResult
                                {
                                    MethodName = method.Name,
                                    ReturnType = method.ReturnType.FullName,
                                    Parameters = method.GetParameters().Select(p => p.ParameterType.Name + " " + p.Name).ToArray(),
                                    Message = "Method found in dynamic assembly"
                                };
                                return JsonConvert.SerializeObject(result);
                            }
                        }
                    }
                }
                catch (Exception ex)
                {
                    Console.WriteLine($"Failed to load types from dynamic assembly. Exception: {ex.Message}");
                }
            }

            var notFoundResult = new MethodInfoResult
            {
                MethodName = name,
                Message = $"Method {name} not found."
            };
            return JsonConvert.SerializeObject(notFoundResult);
        }

        public static List<string> ExtractNamespaces(string usingStatements)
        {
            var namespaces = new List<string>();
            var usingRegex = new Regex(@"\busing\s+([a-zA-Z0-9\.]+)\s*;", RegexOptions.Compiled);

            var matches = usingRegex.Matches(usingStatements);
            foreach (Match match in matches)
            {
                if (match.Groups.Count > 1)
                {
                    namespaces.Add(match.Groups[1].Value);
                }
            }

            return namespaces;
        }

        public class MethodInfoResult
        {
            public string MethodName { get; set; }
            public string ReturnType { get; set; }
            public string[] Parameters { get; set; }
            public string Message { get; set; }
        }
    }
}
