namespace Arisl;
using System.Text.RegularExpressions;

public class CodeOrganizer
{
    public string OrganizeCode(string generatedCSharpCode, string usings = "")
    {
        List<string> cSharpCodeBlocks = new List<string> { generatedCSharpCode };
        string organizedCode = usings + @"
        using System;
        using System.Collections.Generic;
        public class Csharp
        {
            " + string.Join("\n", cSharpCodeBlocks) + @"
        }
        ";

        return organizedCode;
    }

    public string ExtractUsings(string code, out string codeWithoutUsings)
    {
        string usings = "";
        string usingPattern = @"using\s+\S+;\s*";
        var matches = Regex.Matches(code, usingPattern);

        foreach (Match match in matches)
        {
            usings += match.Value + "\n";
        }

        codeWithoutUsings = Regex.Replace(code, usingPattern, "\n");

        return usings;
    }
}
