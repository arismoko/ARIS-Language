namespace Arisl
{
    using System;
    using System.IO;
    using System.Threading.Tasks;
    using System.Text.Json;
    using System.Reflection;
    using System.Collections.Generic;
    using System.Runtime.InteropServices;

    public class ARISLInterpreter
    {
        private static List<string> priorREPLInputs = new List<string>();
        private static string usings = @"";
        private static FileProcessor fileProcessor = new FileProcessor();
        private static DependencyProcessor dependencyProcessor = new DependencyProcessor();
        private static CodeOrganizer codeOrganizer = new CodeOrganizer();
        public static CodeProcessor codeProcessor = new CodeProcessor();
        private static CodeExecutor codeExecutor = new CodeExecutor();

        public static string CurrentActiveFilesName { get; set; }
        public static string userDllsPath = Path.Combine(AppContext.BaseDirectory, "userdlls");

        public static async Task Main(string[] args)
        {
            if (args.Length == 0)
            {
                Console.WriteLine("Entering REPL mode...");
                await REPL();
                return;
            }

            string filename = null;
            string directory = null;
            bool errorCheck = false;
            string memberName = null;
            string pkgname = null;
            string version = null;
            bool listPackages = false;
            bool deletePackage = false;
            bool downloadPackage = false;
            bool displayHelp = false;

            ParseArguments(args, ref filename, ref directory, ref errorCheck, ref memberName, ref pkgname, ref version, ref listPackages, ref deletePackage, ref downloadPackage, ref displayHelp);

            if (displayHelp)
            {
                DisplayHelp();
            }
            else if (listPackages)
            {
                await ListPkgs();
            }
            else if (deletePackage)
            {
                await DeletePkg(pkgname);
            }
            else if (downloadPackage)
            {
                await DownloadPkg(pkgname, version);
            }
            else if (directory != null)
            {
                await ProcessDirectory(directory);
            }
            else if (filename != null)
            {
                CurrentActiveFilesName = filename;
                if (memberName != null)
                {
                    await GetMethodInformation(filename, memberName);
                }
                else if (errorCheck)
                {
                    await RunErrorCheck(filename);
                }
                else
                {
                    await ProcessFile(filename);
                }
            }
            else
            {
                Console.WriteLine("No valid filename or directory specified.");
            }
        }

        private static void ParseArguments(string[] args, ref string filename, ref string directory, ref bool errorCheck, ref string memberName, ref string pkgname, ref string version, ref bool listPackages, ref bool deletePackage, ref bool downloadPackage, ref bool displayHelp)
        {
            for (int i = 0; i < args.Length; i++)
            {
                if (args[i] == "--help")
                {
                    displayHelp = true;
                }
                else if (args[i] == "--dir" && i + 1 < args.Length)
                {
                    directory = args[i + 1];
                    i++;
                }
                else if (args[i] == "--file" && i + 1 < args.Length)
                {
                    filename = args[i + 1];
                    i++;
                }
                else if (args[i] == "--errorcheck")
                {
                    errorCheck = true;
                }
                else if (args[i] == "--method" && i + 1 < args.Length)
                {
                    memberName = args[i + 1];
                    i++;
                }
                else if (args[i] == "--download" && i + 1 < args.Length)
                {
                    downloadPackage = true;
                    pkgname = args[i + 1];
                    if (i + 2 < args.Length && !args[i + 2].StartsWith("--"))
                    {
                        version = args[i + 2];
                        i++;
                    }
                    else
                    {
                        version = null; // Default to latest version if not provided
                    }
                    i++;
                }
                else if (args[i] == "--delete" && i + 1 < args.Length)
                {
                    deletePackage = true;
                    pkgname = args[i + 1];
                    i++;
                }
                else if (args[i] == "--list")
                {
                    listPackages = true;
                }
                else
                {
                    filename = args[i];
                }
            }
        }

        private static void DisplayHelp()
        {
            Console.WriteLine("Usage:");
            Console.WriteLine("  ARISLInterpreter [options] [file]");
            Console.WriteLine();
            Console.WriteLine("Options:");
            Console.WriteLine("  --help             Display this help message.");
            Console.WriteLine("  --dir <directory>  Process all .ari files in the specified directory.");
            Console.WriteLine("  --file <file>      Process the specified .ari file.");
            Console.WriteLine("  --errorcheck       Perform a syntax and basic error check on the specified file.");
            Console.WriteLine("  --method <name>    Get method information for the specified member name in the file.");
            Console.WriteLine("  --download <pkg>   Download the specified package (optionally specify version).");
            Console.WriteLine("  --delete <pkg>     Delete the specified package.");
            Console.WriteLine("  --list             List all downloaded packages.");
            Console.WriteLine();
            Console.WriteLine("Examples:");
            Console.WriteLine("--file example.ari");
            Console.WriteLine("--dir examples");
            Console.WriteLine("--file example.ari --errorcheck");
            Console.WriteLine("--download Newtonsoft.Json 13.0.1");
        }

        private static async Task ProcessDirectory(string directory)
        {
            var files = Directory.GetFiles(directory, "*.ari", SearchOption.AllDirectories);
            foreach (var file in files)
            {
                await ProcessFile(file);
            }
        }

        private static async Task ProcessFile(string filename)
        {
            if (!File.Exists(filename))
            {
                Console.WriteLine($"File not found: {filename}");
                return;
            }

            string cleanCode;
            var (combinedCode, _) = await fileProcessor.ProcessFileAsync(filename);
            var codeWithDependenciesRemoved = await dependencyProcessor.ProcessDependenciesAsync(combinedCode);
            usings = codeOrganizer.ExtractUsings(codeWithDependenciesRemoved, out cleanCode);
            bool hasParseErrors = false;
            var generatedCode = codeProcessor.GenerateCode(cleanCode, out hasParseErrors);
            if (hasParseErrors)
            {
                Console.WriteLine("Failed to generate C# code.");
                return;
            }
            var organizedCode = codeOrganizer.OrganizeCode(generatedCode, usings);
            Console.WriteLine(organizedCode);
            var executionSuccess = await codeExecutor.ExecuteCodeAsync(organizedCode);
            if (!executionSuccess)
            {
                Console.WriteLine("Failed to execute C# code.");
            }
        }

        private static async Task RunErrorCheck(string filename)
        {
            if (!File.Exists(filename))
            {
                Console.WriteLine($"File not found: {filename}");
                return;
            }

            string cleanCode;
            var (combinedCode, _) = await fileProcessor.ProcessFileAsync(filename);
            var codeWithDependenciesRemoved = await dependencyProcessor.ProcessDependenciesAsync(combinedCode);
            usings = codeOrganizer.ExtractUsings(codeWithDependenciesRemoved, out cleanCode);
            bool hasParseErrors;
            var generatedCode = codeProcessor.GenerateCode(cleanCode, out hasParseErrors);
            if (hasParseErrors)
            {
                Console.WriteLine("Failed to generate C# code.");
                return;
            }
            var organizedCode = codeOrganizer.OrganizeCode(generatedCode, usings);

            CSharpCompiler compiler = new CSharpCompiler(codeProcessor.codeGenerator._sourceMap);
            await compiler.CheckSyntaxAndBasicErrorsAsync(organizedCode);
        }

        private static async Task GetMethodInformation(string filename, string memberName)
        {
            if (!File.Exists(filename))
            {
                Console.WriteLine($"File not found: {filename}");
                return;
            }

            var (combinedCode, _) = await fileProcessor.ProcessFileAsync(filename);
            var codeWithDependenciesRemoved = await dependencyProcessor.ProcessDependenciesAsync(combinedCode);
            string cleanCode;
            usings = codeOrganizer.ExtractUsings(codeWithDependenciesRemoved, out cleanCode);
            var memberInfo = await dependencyProcessor._compiler.GetMethodInfoAsync(memberName);
            var methodInfo = JsonSerializer.Deserialize<CSharpCompiler.MethodInfoResult>(memberInfo);

            var json = JsonSerializer.Serialize(methodInfo, new JsonSerializerOptions { WriteIndented = true });
            var hoverFileName = filename + ".hover";
            await File.WriteAllTextAsync(hoverFileName, json);
            Console.WriteLine(json);
        }

        private static async Task DownloadPkg(string pkgname, string version)
        {
            CSharpCompiler compiler = new CSharpCompiler();
            await compiler.DownloadDotNetAssembly(pkgname, version);
            if (Directory.Exists(userDllsPath))
            {
                string[] files = Directory.GetFiles(userDllsPath);
                foreach (string file in files)
                {
                    if (file.Contains(pkgname))
                    {
                        Console.WriteLine("Downloaded package: " + pkgname + " " + (version ?? "latest"));
                        return;
                    }
                }
            }
            Console.WriteLine("Downloaded package: " + pkgname + " " + (version ?? "latest"));
        }

        private static async Task DeletePkg(string pkgname)
        {
            if (Directory.Exists(userDllsPath))
            {
                string[] files = Directory.GetFiles(userDllsPath);
                foreach (string file in files)
                {
                    if (file.Contains(pkgname))
                    {
                        File.Delete(file);
                        Console.WriteLine("Deleted package: " + pkgname);
                        return;
                    }
                }
            }
            Console.WriteLine("Package not found: " + pkgname);
        }

        private static async Task ListPkgs()
        {
            if (Directory.Exists(userDllsPath))
            {
                string[] files = Directory.GetFiles(userDllsPath);
                if (files.Length == 0)
                {
                    Console.WriteLine("No packages found in the userdlls directory.");
                }
                else
                {
                    Console.WriteLine("Packages in userdlls directory:");
                    for (int i = 0; i < files.Length; i++)
                    {
                        var file = files[i];
                        var assembly = Assembly.LoadFile(file);
                        var name = assembly.GetName();
                        Console.WriteLine($"{i + 1}. Name: {name.Name}");
                        Console.WriteLine($"   Version: {name.Version}");
                        Console.WriteLine($"   Path: {file}");
                    }
                }
            }
            else
            {
                Console.WriteLine("The userdlls directory does not exist.");
            }
        }


        private static string REPLMain()
        {
            var mainFunc = "func Main(){";
            foreach (var input in priorREPLInputs)
            {
                mainFunc += input + "\n";
            }
            mainFunc += "}";
            return mainFunc;
        }

        private static async Task REPL()
        {
            //create a temp .ari file
            if (!Directory.Exists("temp"))
            {
                Directory.CreateDirectory("temp");
            }
            string tempFile = Path.Combine("temp", "temp.ari");
            File.WriteAllText(tempFile, "");

            while (true)
            {
                Console.Write("ARISL> ");
                string input = Console.ReadLine();

                if (input == "exit")
                {
                    break;
                }

                // Handle commands within REPL
                if (input.StartsWith("--"))
                {
                    var args = input.Split(' ');
                    string filename = null;
                    string directory = null;
                    bool errorCheck = false;
                    string memberName = null;
                    string pkgname = null;
                    string version = null;
                    bool listPackages = false;
                    bool deletePackage = false;
                    bool downloadPackage = false;
                    bool displayHelp = false;

                    ParseArguments(args, ref filename, ref directory, ref errorCheck, ref memberName, ref pkgname, ref version, ref listPackages, ref deletePackage, ref downloadPackage, ref displayHelp);

                    if (displayHelp)
                    {
                        DisplayHelp();
                    }
                    else if (listPackages)
                    {
                        await ListPkgs();
                    }
                    else if (deletePackage)
                    {
                        await DeletePkg(pkgname);
                    }
                    else if (downloadPackage)
                    {
                        await DownloadPkg(pkgname, version);
                    }
                    else if (directory != null)
                    {
                        await ProcessDirectory(directory);
                    }
                    else if (filename != null)
                    {
                        CurrentActiveFilesName = filename;
                        if (memberName != null)
                        {
                            await GetMethodInformation(filename, memberName);
                        }
                        else if (errorCheck)
                        {
                            await RunErrorCheck(filename);
                        }
                        else
                        {
                            await ProcessFile(filename);
                        }
                    }
                }
                else
                {
                    // Add input to REPL history and process as ARISL code
                    priorREPLInputs.Add(input);
                    File.WriteAllText(tempFile, REPLMain());
                    await ProcessFile(tempFile);
                }
            }
        }
    }
}
