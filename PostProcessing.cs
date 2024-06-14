namespace Arisl;
using System.Text.RegularExpressions;
public static class PostProcessing
{
    public static async Task<string> ProcessImports(string directory, string filename, string code, HashSet<string> processedFiles)
    {
        if (processedFiles.Contains(filename))
        {
            return ""; // Prevent circular imports
        }

        processedFiles.Add(filename);
        var lines = code.Split('\n');
        string mainCode = "";
        string importedCode = "";

        foreach (var line in lines)
        {
            if (line.Trim().StartsWith("import(") && line.Trim().EndsWith(")"))
            {
                var importedFilename = line.Trim().Substring(7, line.Trim().Length - 8).Trim();
                var importedFilePath = Path.Combine(directory, importedFilename);

                if (File.Exists(importedFilePath) && importedFilePath.EndsWith(".ari"))
                {
                    string importedFileCode = await File.ReadAllTextAsync(importedFilePath);
                    var importedClassName = Path.GetFileNameWithoutExtension(importedFilePath);
                    var processedImportedCode = await ProcessImports(directory, importedFilePath, importedFileCode, processedFiles);
                    importedCode += processedImportedCode;
                }
                else if (!importedFilePath.EndsWith(".ari"))
                {
                    Console.WriteLine($"Skipped non-.ari file: {importedFilePath}");
                }
                else
                {
                    Console.WriteLine($"Imported file not found: {importedFilePath}");
                }
            }
            else
            {
                mainCode += line + "\n";
            }
        }

        // Append the imported code to the main code
        return mainCode + importedCode;
    }

    public static async Task<string> ProcessDownloadStatements(string code, CSharpCompiler compiler)
    {
        // Pattern for dotnet(pkgname[, version]);
        string downloadPattern = @"dotnet\(([^,()]+)(?:,([^,()]+))?\);";

        var matches = Regex.Matches(code, downloadPattern);
        foreach (Match match in matches)
        {
            string pkgname = match.Groups[1].Value.Trim();
            string version = match.Groups[2].Success ? match.Groups[2].Value.Trim() : null;

            if (version != null)
            {
                //Console.WriteLine($"Pkg: {pkgname}, Version: {version}");
                await compiler.DownloadDotNetAssembly(pkgname, version);
            }
            else
            {
                //Console.WriteLine($"PkgNoVersion: {pkgname}");
                await compiler.DownloadDotNetAssembly(pkgname);
            }

            //replace the match with a new lien
            code = code.Replace(match.Value, "\n");
        }

        return code;
    }
}
