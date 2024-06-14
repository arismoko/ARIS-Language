namespace Arisl
{
    using Antlr4.Runtime;
    using System;
    using System.Collections.Generic;
    using System.IO;
    using Newtonsoft.Json;

    public class CompilationError
    {
        public string Id { get; set; }
        public string Message { get; set; }
        public int Line { get; set; }
        public int Column { get; set; }
    }

    public class CustomErrorListener : BaseErrorListener
    {
        public List<CompilationError> Errors { get; } = new List<CompilationError>();

        public override void SyntaxError(TextWriter output, IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            Errors.Add(new CompilationError
            {
                Id = Guid.NewGuid().ToString(),
                Message = msg,
                Line = line - 2,
                Column = charPositionInLine
            });
        }
    }

    public class CodeProcessor
    {
        public ArislCodeGenerator codeGenerator;
        public string GenerateCode(string finalCode, out bool hasParseErrors)
        {
            //Console.WriteLine("Generating code...");
            var inputStream = new AntlrInputStream(finalCode);
            //Console.WriteLine("Creating lexer...");
            var lexer = new ArislLexer(inputStream);
            //Console.WriteLine("Creating parser...");
            var commonTokenStream = new CommonTokenStream(lexer);
            foreach (var token in commonTokenStream.GetTokens())
            {
                //Console.WriteLine(token);
            }
            //Console.WriteLine("Creating tree...");
            var parser = new ArislParser(commonTokenStream);

            // Add custom error listener
            var errorListener = new CustomErrorListener();
            parser.RemoveErrorListeners(); // Remove default error listeners
            parser.AddErrorListener(errorListener);

            //Console.WriteLine("Parsing program...");
            var tree = parser.program();

            // Get the lines of the code
            var lines = finalCode.Split(new[] { "\r\n", "\r", "\n" }, StringSplitOptions.None);

            // Find the line number of 'public class Csharp'
            int csharpClassLineNumber = 0;
            for (int i = 0; i < lines.Length; i++)
            {
                if (lines[i].Contains("public class Csharp"))
                {
                    csharpClassLineNumber = i + 1; // Line numbers are 1-based
                    break;
                }
            }

            // Find the last line number
            int lastLineNumber = lines.Length;

            // Filter errors
            if (csharpClassLineNumber > 0)
            {
                errorListener.Errors.RemoveAll(e => e.Line < csharpClassLineNumber || e.Line > lastLineNumber);
            }

            if (errorListener.Errors.Count > 0)
            {
                var uniqueErrors = errorListener.Errors.GroupBy(e => new { e.Line, e.Column, e.Message })
                                                       .Select(g => g.First())
                                                       .ToList();

                var errorReport = JsonConvert.SerializeObject(uniqueErrors, Formatting.Indented);
                //Console.WriteLine("Compilation errors encountered:");
                //Console.WriteLine(errorReport);

                // Retrieve the current active filename and save errors to <filename>.arilog
                var currentFilename = ARISLInterpreter.CurrentActiveFilesName; // Ensure this is the correct way to get the filename
                var logFilename = Path.ChangeExtension(currentFilename, ".arilog");

                if (File.Exists(logFilename))
                {
                    File.Delete(logFilename);
                }

                File.WriteAllText(logFilename, errorReport);
                //Console.WriteLine($"Errors have been saved to {logFilename}");
                hasParseErrors = true;
                return errorReport;
            }

            //Console.WriteLine("Generating C# code...");
            codeGenerator = new ArislCodeGenerator();
            //Console.WriteLine("Visiting tree...");
            var generatedCSharpCode = codeGenerator.Visit(tree);
            hasParseErrors = false;
            return generatedCSharpCode;
        }
    }
}
