namespace Arisl;

public class FileProcessor
{
    public async Task<(string combinedCode, HashSet<string> processedFiles)> ProcessFileAsync(string filename)
    {
        HashSet<string> processedFiles = new HashSet<string>();
        string combinedCode = "";

        try
        {
            string code = await File.ReadAllTextAsync(filename);
            combinedCode = await PostProcessing.ProcessImports(Path.GetDirectoryName(filename), filename, code, processedFiles);
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error processing file: {ex.Message}");
        }

        return (combinedCode, processedFiles);
    }
}
