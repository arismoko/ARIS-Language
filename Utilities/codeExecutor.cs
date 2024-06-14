
namespace Arisl;
using System.Reflection;

public class CodeExecutor
{

    private Assembly _assembly = null;

    public async Task<bool> ExecuteCodeAsync(string code)
    {
        try
        {
            CSharpCompiler _compiler = new CSharpCompiler(ARISLInterpreter.codeProcessor.codeGenerator._sourceMap);
            _assembly = await _compiler.CompileAndCacheAsync(code);
            if (_assembly == null)
            {
                Console.WriteLine("Compilation produced no output.");
                return false;
            }

            var scriptRunnerType = _assembly.GetType("Csharp");
            var runMethod = scriptRunnerType?.GetMethod("Main", BindingFlags.Public | BindingFlags.Static);

            if (runMethod != null)
            {
                if (runMethod.ReturnType == typeof(Task))
                {
                    var task = (Task)runMethod.Invoke(null, null);
                    await task;
                }
                else
                {
                    var csharpTask = Task.Run(() =>
                    {
                        Thread csharpThread = new Thread(() => runMethod.Invoke(null, null));
                        csharpThread.Start();
                        csharpThread.Join();
                    });

                    await csharpTask;
                }

                return true;
            }
            else
            {
                Console.WriteLine("No main method found in the Program class.");
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine("An error occurred while executing the code.");
            Console.WriteLine(ex.ToString());

        }

        return false;
    }
    public static async Task GenerateErrorLog(string errorlog, string filename)
    {
        //overwrite/erase the file if it exists
        using (System.IO.StreamWriter file = new System.IO.StreamWriter(filename))
        {
            await file.WriteAsync(errorlog);
        }

    }
}
