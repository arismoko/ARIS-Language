namespace Arisl;
public class DependencyProcessor
{

    public CSharpCompiler _compiler = new CSharpCompiler();

    public async Task<string> ProcessDependenciesAsync(string combinedCode)
    {
        return await PostProcessing.ProcessDownloadStatements(combinedCode, _compiler);
    }
}