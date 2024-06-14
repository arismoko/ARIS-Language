using System;
using System.Text;
using Antlr4.Runtime.Misc;
using System.Threading.Tasks;
using System.Collections.Generic;
using System.ComponentModel;

public class ArislCodeGenerator : ArislBaseVisitor<string>
{
    private string currentConstructorName;
    private Stack<KeyValuePair<string, string>> scopeStack = new Stack<KeyValuePair<string, string>>();
    public SourceMap _sourceMap;
    private int _currentGeneratedLine;
    private int _currentGeneratedColumn;

    private void PushScope(string scope, string identifier)
    {
        scopeStack.Push(new KeyValuePair<string, string>(scope, identifier));
    }

    private void PopScope()
    {
        if (scopeStack.Count > 0)
        {
            scopeStack.Pop();
        }
    }

    private KeyValuePair<string, string> CurrentScope()
    {
        return scopeStack.Count > 0 ? scopeStack.Peek() : new KeyValuePair<string, string>(string.Empty, string.Empty);
    }

    private bool isDynamic = false;
    private bool varTokenPlaced = false;
    private Variable? currentVar;
    bool containsReturnStatement = false;

    class Variable
    {
        public string name;
        public bool beingAssignedValue = false;
        public bool hastype = false;
        public string scope;
        public string scopeIdentifier;

        public string uniqueModifiers;
        public int binaryIterations;
        public bool shouldAssignVarType()
        {
            return !hastype && beingAssignedValue;
        }
    }

    private Dictionary<string, Variable> globalVariables = new Dictionary<string, Variable>();
    private StringBuilder _sb;
    private int _indentLevel;
    private bool _debug;

    public ArislCodeGenerator()
    {
        _sb = new StringBuilder();
        _indentLevel = 0;
        _debug = false;
        _sourceMap = new SourceMap();
        _currentGeneratedLine = 1;
        _currentGeneratedColumn = 0;
    }

    private void AppendIndented(string value, int originalLine, int originalColumn)
    {
        _sb.Append(new string(' ', _indentLevel * 4));
        _sb.Append(value);
        _currentGeneratedColumn += _indentLevel * 4 + value.Length;
        _sourceMap.AddMapping(_currentGeneratedLine, _currentGeneratedColumn, originalLine, originalColumn);
        DebugPrint();
    }

    private void AppendIndentedLine(string value, int originalLine, int originalColumn)
    {
        AppendIndented(value, originalLine, originalColumn);
        _sb.AppendLine();
        _currentGeneratedLine++;
        _currentGeneratedColumn = 0;
        DebugPrint();
    }

    private void AppendIndentedLineAndStayOnLine(string value, int originalLine, int originalColumn)
    {
        AppendIndented(value, originalLine, originalColumn);
        DebugPrint();
    }
    private void Append(string value, int originalLine, int originalColumn)
    {
        //Console.WriteLine($"Appending: {value} Line: {originalLine} Column: {originalColumn}");
        _sb.Append(value);
        _currentGeneratedColumn += value.Length;
        _sourceMap.AddMapping(_currentGeneratedLine, _currentGeneratedColumn, originalLine, originalColumn);
        DebugPrint();
    }
    private void AddToSourceMap(string value, int originalLine, int originalColumn)
    {
        _sourceMap.AddMapping(_currentGeneratedLine, _currentGeneratedColumn, originalLine, originalColumn);
    }
    public SourceMap GetSourceMap()
    {
        return _sourceMap;
    }

    private void DebugPrint()
    {
        if (_debug)
        {
            //Console.WriteLine(_sb.ToString());
        }
    }

    public override string VisitProgram(ArislParser.ProgramContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));
        // set the scope to program
        PushScope("program", "mainProgram");

        foreach (var stmt in context.statement())
        {
            Visit(stmt);
        }
        PopScope();
        return _sb.ToString();
    }

    public override string VisitEnumDecl(ArislParser.EnumDeclContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        //Console.WriteLine($"// Parsing Enum Declaration: {context.IDENTIFIER().GetText()}");
        PushScope("enum", context.IDENTIFIER().GetText());

        string visibilityModifier = context.visibility() != null ? Visit(context.visibility()) ?? "" : "";

        if (!string.IsNullOrEmpty(visibilityModifier))
        {
            AppendIndented($"{visibilityModifier} ", originalLine, originalColumn);
        }

        AppendIndented($"enum {context.IDENTIFIER().GetText()}", originalLine, originalColumn);
        AppendIndentedLine("", originalLine, originalColumn);
        _indentLevel++;
        if (context.list() != null)
        {
            Visit(context.list());
        }
        _indentLevel--;
        AppendIndentedLine("", originalLine, originalColumn);
        AppendIndentedLine("", originalLine, originalColumn);
        PopScope();
        return null;
    }

    public override string VisitConstructorDecl(ArislParser.ConstructorDeclContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        // Announcing parsing a Constructor Declaration
        //Console.WriteLine($"// Parsing Constructor Declaration: {currentConstructorName}");
        PushScope("constructor", currentConstructorName);
        string visibilityModifier = "";
        if (context.visibility() != null)
        {
            visibilityModifier = Visit(context.visibility()) ?? "";
        }
        else
        {
            visibilityModifier = "public";
        }
        if (!string.IsNullOrEmpty(visibilityModifier))
        {
            AppendIndented($"{visibilityModifier} ", originalLine, originalColumn);
        }
        else
        {
            AppendIndented("", originalLine, originalColumn);
        }
        foreach (var modifier in context.modifier())
        {
            AppendIndented(Visit(modifier), originalLine, originalColumn);
        }
        AppendIndented(currentConstructorName, originalLine, originalColumn);
        if (context.arguments() != null)
        {
            Visit(context.arguments());
        }
        if (context.block() != null)
        {
            Visit(context.block());
        }
        else
        {
            AppendIndented(";", originalLine, originalColumn);
            AppendIndentedLine("", originalLine, originalColumn);
        }
        AppendIndentedLine("", originalLine, originalColumn);
        PopScope();
        return null;
    }

    public override string VisitInterfaceDecl(ArislParser.InterfaceDeclContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        //Console.WriteLine($"// Parsing Interface Declaration: {context.IDENTIFIER().GetText()}");
        PushScope("interface", context.IDENTIFIER().GetText());

        string visibilityModifier = context.visibility() != null ? Visit(context.visibility()) ?? "" : "";

        if (!string.IsNullOrEmpty(visibilityModifier))
        {
            AppendIndented($"{visibilityModifier} ", originalLine, originalColumn);
        }

        AppendIndented($"interface {context.IDENTIFIER().GetText()}", originalLine, originalColumn);
        AppendIndentedLine("{", originalLine, originalColumn);
        _indentLevel++;
        foreach (var member in context.interfaceBlock().interfaceMember())
        {
            Visit(member);
        }
        _indentLevel--;
        AppendIndentedLine("}", originalLine, originalColumn);
        AppendIndentedLine("", originalLine, originalColumn);
        PopScope();
        return null;
    }

    public override string VisitInterfaceMember(ArislParser.InterfaceMemberContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        // Announcing parsing an Interface Member
        //Console.WriteLine($"// Parsing Interface Member: {context.GetText()}");

        Visit(context.functionSignature());
        AppendIndentedLine(";", originalLine, originalColumn);
        return null;
    }

    public override string VisitFunctionDecl(ArislParser.FunctionDeclContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        //Console.WriteLine($"// Parsing Function Declaration: {context.IDENTIFIER().GetText()}");
        PushScope("function", context.IDENTIFIER().GetText());

        string visibilityModifier = "";
        if (context.visibility() != null)
        {
            visibilityModifier = Visit(context.visibility()) ?? "";
        }
        else
        {
            visibilityModifier = "public";
        }

        string functionName = context.IDENTIFIER().GetText();
        string modifiers = "";
        string type = "";
        isDynamic = false;
        foreach (var modifier in context.modifier())
        {
            modifiers += " ";
            modifiers += Visit(modifier);
        }
        if (functionName == "main" || functionName == "Main")
        {
            if (modifiers.Contains("async"))
            {
                modifiers = "static async";
                type = "Task";
            }
            else
            {
                modifiers = "static";
                type = "void";
            }
            functionName = "Main";
        }
        else
        {

            if (modifiers.Contains("instantiated"))
            {
                modifiers = modifiers.Replace("instantiated", "").Replace("static", "");
            }
            else if (!modifiers.Contains("static"))
            {
                modifiers += " static ";
            }
            if (context.type() != null)
            {
                type = Visit(context.type());
            }
            else
            {
                type = "dynamic";
            }
        }

        if (type == "dynamic")
        {
            isDynamic = true;
        }

        if (!string.IsNullOrEmpty(visibilityModifier))
        {
            AppendIndented($"{visibilityModifier} ", originalLine, originalColumn);
            AppendIndented($"{modifiers} {type} {functionName}", originalLine, originalColumn);
        }
        else
        {
            AppendIndented($"{modifiers} {type} {functionName}", originalLine, originalColumn);
        }
        if (context.genericType() != null)
        {
            AppendIndented(Visit(context.genericType()), originalLine, originalColumn);
        }
        if (context.arguments() != null)
        {
            Visit(context.arguments());
        }

        if (context.block() != null)
        {
            Visit(context.block());
        }

        AppendIndentedLine("", originalLine, originalColumn);
        PopScope();
        return null;
    }

    public override string VisitClassDecl(ArislParser.ClassDeclContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        //Console.WriteLine($"// Parsing Class Declaration: {context.IDENTIFIER().GetText()}");
        PushScope("class", context.IDENTIFIER().GetText());

        string visibilityModifier = "";
        if (context.visibility() != null)
        {
            visibilityModifier = Visit(context.visibility()) ?? "";
        }
        else
        {
            visibilityModifier = "public";
        }
        if (!string.IsNullOrEmpty(visibilityModifier))
        {
            AppendIndented($"{visibilityModifier} ", originalLine, originalColumn);
        }
        foreach (var modifier in context.modifier())
        {
            AppendIndented(Visit(modifier), originalLine, originalColumn);
        }
        AppendIndented(" ", originalLine, originalColumn);
        string className = context.IDENTIFIER().GetText();
        currentConstructorName = className;
        AppendIndented($"class {className}", originalLine, originalColumn);
        if (context.type() != null)
        {
            AppendIndented($" : ", originalLine, originalColumn);
            AppendIndented(Visit(context.type()), originalLine, originalColumn);
        }

        _indentLevel++;
        if (context.block != null)
        {
            Visit(context.block());
        }
        _indentLevel--;
        AppendIndentedLine("", originalLine, originalColumn);
        currentConstructorName = "";
        PopScope();
        return null;
    }

    public override string VisitModifier(ArislParser.ModifierContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing a Modifier
        //Console.WriteLine($"// Parsing Modifier: {context.GetText()}");
        var text = context.GetText();

        text += " ";
        return text;
    }

    public override string VisitVisibility(ArislParser.VisibilityContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));
        // Announcing parsing a Visibility
        //Console.WriteLine($"// Parsing Visibility: {context.GetText()}");

        if (context.PUBLIC() != null)
        {
            return "public";
        }
        else if (context.PRIVATE() != null)
        {
            return "private";
        }
        /* else if (context.PROTECTED() != null)
        {
            return "protected";
        }
        else if (context.INTERNAL() != null)
        {
            return "internal";
        }
        else if (context.EXTERNAL() != null)
        {
            return "external";
        }
        else if (context.INTERNAL() != null)
        {
            return "internal";
        }
        */
        return "";
    }

    public string VisitStatement(ArislParser.StatementContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        if (context is ArislParser.FunctionDeclIDContext)
        {
            Visit(context as ArislParser.FunctionDeclIDContext);
        }

        else if (context is ArislParser.DelegateDeclIDContext)
        {
            Visit(context as ArislParser.DelegateDeclIDContext);
        }
        else if (context is ArislParser.ConstructorDeclIDContext)
        {
            Visit(context as ArislParser.ConstructorDeclIDContext);
        }
        else if (context is ArislParser.ClassDeclIDContext)
        {
            Visit(context as ArislParser.ClassDeclIDContext);
        }
        else if (context is ArislParser.StructDeclIDContext)
        {
            Visit(context as ArislParser.StructDeclIDContext);
        }
        else if (context is ArislParser.RecordDeclIDContext)
        {
            Visit(context as ArislParser.RecordDeclIDContext);
        }
        else if (context is ArislParser.EnumDeclIDContext)
        {
            Visit(context as ArislParser.EnumDeclIDContext);
        }
        else if (context is ArislParser.InterfaceDeclIDContext)
        {
            Visit(context as ArislParser.InterfaceDeclIDContext);
        }
        else if (context is ArislParser.IfStatementIDContext)
        {
            Visit(context as ArislParser.IfStatementIDContext);
        }
        else if (context is ArislParser.WhileStatementIDContext)
        {
            Visit(context as ArislParser.WhileStatementIDContext);
        }
        else if (context is ArislParser.ForStatementIDContext)
        {
            Visit(context as ArislParser.ForStatementIDContext);
        }
        else if (context is ArislParser.ForEachStatementIDContext)
        {
            Visit(context as ArislParser.ForEachStatementIDContext);
        }
        else if (context is ArislParser.ReturnStatementIDContext)
        {
            Visit(context as ArislParser.ReturnStatementIDContext);
        }

        else if (context is ArislParser.ObjectCreationStatementIDContext)
        {
            Visit(context as ArislParser.ObjectCreationStatementIDContext);
        }
        else if (context is ArislParser.TryCatchStatementIDContext)
        {
            Visit(context as ArislParser.TryCatchStatementIDContext);
        }
        else if (context is ArislParser.RepeatUntilStatementIDContext)
        {
            Visit(context as ArislParser.RepeatUntilStatementIDContext);
        }
        else if (context is ArislParser.SwitchStatementIDContext)
        {
            Visit(context as ArislParser.SwitchStatementIDContext);
        }
        else if (context is ArislParser.ExpressionStatementIDContext)
        {
            Visit(context as ArislParser.ExpressionStatementIDContext);
        }

        return null;
    }

    public override string VisitStructDecl(ArislParser.StructDeclContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        // Announcing parsing a Struct Declaration
        //Console.WriteLine($"// Parsing Struct Declaration: {context.IDENTIFIER().GetText()}");
        string visibilityModifier = "";
        if (context.visibility() != null)
        {
            visibilityModifier = Visit(context.visibility()) ?? "";
        }

        foreach (var modifier in context.modifier())
        {
            AppendIndented(Visit(modifier), originalLine, originalColumn);
        }
        AppendIndented(" ", originalLine, originalColumn);
        AppendIndented("struct ", originalLine, originalColumn);
        AppendIndented(context.IDENTIFIER().GetText(), originalLine, originalColumn);
        currentConstructorName = context.IDENTIFIER().GetText();
        if (context.block() != null)
        {
            Visit(context.block());
        }
        AppendIndentedLine("", originalLine, originalColumn);
        currentConstructorName = "";
        return null;
    }

    public override string VisitObjectCreation(ArislParser.ObjectCreationContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        // Announcing parsing Object Creation
        //Console.WriteLine("// Parsing Object Creation");
        string visibilityModifier = "";
        if (context.visibility() != null)
        {
            visibilityModifier = Visit(context.visibility()) ?? "";
        }

        if (!string.IsNullOrEmpty(visibilityModifier))
        {
            AppendIndented($"{visibilityModifier} ", originalLine, originalColumn);
        }
        else
        {
            AppendIndented("", originalLine, originalColumn);
        }
        string modifiers = "";
        foreach (var modifier in context.modifier())
        {
            modifiers += Visit(modifier);
        }
        if (!string.IsNullOrEmpty(modifiers))
        {
            Append($"{modifiers} ", originalLine, originalColumn);
        }

        if (context.type() != null)
        {
            Append(Visit(context.type()), originalLine, originalColumn);
            AppendIndented(" ", originalLine, originalColumn);
        }
        if (context.IDENTIFIER() != null)
        {
            Append(context.IDENTIFIER().GetText(), originalLine, originalColumn);
        }
        Append(" = new ", originalLine, originalColumn);
        if (context.type() != null)
        {
            Append(Visit(context.type()), originalLine, originalColumn);
        }
        if (context.tuple() != null)
        {
            Visit(context.tuple());
        }
        else if (context.list() != null)
        {
            Visit(context.list());
        }
        Append(";", originalLine, originalColumn);
        AppendIndentedLine("", originalLine, originalColumn);

        return null;
    }

    public override string VisitVarType(ArislParser.VarTypeContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing a VarType
        //Console.WriteLine("// Parsing VarType");

        string text = "dynamic";
        return text;
    }

    public override string VisitSimpleType(ArislParser.SimpleTypeContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing a Simple Type
        //Console.WriteLine($"// Parsing Simple Type: {context.IDENTIFIER().GetText()}");

        var text = context.IDENTIFIER().GetText();
        text = text.Replace("~", "");
        return text;
    }

    public override string VisitGenericType(ArislParser.GenericTypeContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing a Tuple Type
        //Console.WriteLine($"// Parsing Tuple Type: {context.GetText()}");
        var text = "";
        text += "<";
        for (int i = 0; i < context.IDENTIFIER().Length; i++)
        {
            text += context.IDENTIFIER(i).GetText();

            if (i < context.IDENTIFIER().Length - 1)
            {
                text += ", ";
            }
        }
        text += ">";
        return text;
    }

    public override string VisitTupleType(ArislParser.TupleTypeContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing a Tuple Type
        //Console.WriteLine($"// Parsing Tuple Type: {context.GetText()}");
        var text = "";
        Visit(context.tuple());
        return text;
    }

    public override string VisitType(ArislParser.TypeContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));
        if (context.simpleType() != null)
        {
            return Visit(context.simpleType());
        }
        else if (context.varType() != null)
        {
            return Visit(context.varType());
        }
        else if (context.genericType() != null)
        {
            return Visit(context.genericType());
        }
        else if (context.tupleType() != null)
        {
            return Visit(context.tupleType());
        }
        else if (context.nestedType() != null)
        {
            return Visit(context.nestedType());
        }
        else if (context.castType() != null)
        {
            return Visit(context.castType());
        }
        return null;
    }

    public override string VisitCastType(ArislParser.CastTypeContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing a Cast Type
        //Console.WriteLine($"// Parsing Cast Type: {context.type().GetText()}");
        var text = "";
        text += "(";
        text += Visit(context.type());
        text += ")";
        return text;
    }

    public override string VisitNestedType(ArislParser.NestedTypeContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing a Tuple Type
        //Console.WriteLine($"// Parsing Nested Type: {context.GetText()}");

        var type1 = Visit(context.simpleType());
        type1 = type1.Replace("~", "").Replace("~", "");
        var text = "";
        text += type1;
        text += Visit(context.genericType());
        return text;
    }

    public override string VisitIfStatement(ArislParser.IfStatementContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        //Console.WriteLine("// Parsing If Statement");
        PushScope("if", "ifStatement");

        AppendIndented("if (", originalLine, originalColumn);
        Visit(context.expression(0));
        AppendIndentedLine(")", originalLine, originalColumn);
        _indentLevel++;
        Visit(context.block(0));
        _indentLevel--;
        for (int i = 1; i < context.expression().Length; i++)
        {
            AppendIndented("else if (", originalLine, originalColumn);
            Visit(context.expression(i));
            AppendIndentedLine(")", originalLine, originalColumn);
            _indentLevel++;
            Visit(context.block(i));
            _indentLevel--;
        }

        if (context.block().Length > context.expression().Length)
        {
            AppendIndentedLine("else", originalLine, originalColumn);

            _indentLevel++;
            Visit(context.block(context.block().Length - 1));
            _indentLevel--;
        }
        PopScope();
        return null;
    }

    public override string VisitWhileStatement(ArislParser.WhileStatementContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        //Console.WriteLine("// Parsing While Statement");
        PushScope("while", "whileStatement");

        AppendIndented("while (", originalLine, originalColumn);
        Visit(context.expression());
        AppendIndentedLine(")", originalLine, originalColumn);

        Visit(context.block());
        AppendIndentedLine("", originalLine, originalColumn);
        PopScope();
        return null;
    }

    public override string VisitForStatement(ArislParser.ForStatementContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        //Console.WriteLine("// Parsing For Statement");
        PushScope("for", "forStatement");

        AppendIndented("for (", originalLine, originalColumn);
        if (context.type() != null)
        {
            AppendIndented(Visit(context.type()), originalLine, originalColumn);
            AppendIndented(" ", originalLine, originalColumn);
        }
        Visit(context.expression(0));
        AppendIndented("; ", originalLine, originalColumn);
        Visit(context.expression(1));
        AppendIndented("; ", originalLine, originalColumn);
        Visit(context.expression(2));

        AppendIndentedLine(")", originalLine, originalColumn);
        Visit(context.block());
        AppendIndentedLine("", originalLine, originalColumn);
        PopScope();
        return null;
    }

    public override string VisitFunctionSignature(ArislParser.FunctionSignatureContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing a Function Signature
        //Console.WriteLine($"// Parsing Function Signature: {context.IDENTIFIER().GetText()}");
        if (context.type() != null)
        {
            AppendIndented(Visit(context.type()), context.Start.Line, context.Start.Column);
            AppendIndented(" ", context.Start.Line, context.Start.Column);
        }
        else
        {
            AppendIndented("void ", context.Start.Line, context.Start.Column);
        }
        Append(context.IDENTIFIER().GetText(), context.Start.Line, context.Start.Column);

        if (context.arguments() != null)
        {
            Visit(context.arguments());
        }
        return null;
    }

    public override string VisitForEachStatement(ArislParser.ForEachStatementContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        //Console.WriteLine("// Parsing ForEach Statement");
        PushScope("foreach", "foreachStatement");

        AppendIndented("foreach (", originalLine, originalColumn);
        if (context.type() != null)
        {
            AppendIndented(Visit(context.type()), originalLine, originalColumn);
            AppendIndented(" ", originalLine, originalColumn);
        }
        else
        {
            Append("var ", originalLine, originalColumn);
        }
        Append(context.IDENTIFIER().GetText(), originalLine, originalColumn);
        Append(" in ", originalLine, originalColumn);
        Visit(context.expression());
        Append(")", originalLine, originalColumn);

        Visit(context.block());
        AppendIndentedLine("", originalLine, originalColumn);
        PopScope();
        return null;
    }

    public override string VisitRepeatUntilStatement(ArislParser.RepeatUntilStatementContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        //Console.WriteLine("// Parsing Repeat-Until Statement");
        PushScope("repeat-until", "repeatUntilStatement");

        AppendIndentedLine("do", originalLine, originalColumn);

        Visit(context.block());

        AppendIndented("} while (!(", originalLine, originalColumn);
        Visit(context.expression());
        AppendIndentedLine("));", originalLine, originalColumn);
        PopScope();
        return null;
    }

    public override string VisitRecordDecl(ArislParser.RecordDeclContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        // Announcing parsing a Record Declaration
        //Console.WriteLine($"// Parsing Record Declaration: {context.IDENTIFIER().GetText()}");
        string visibilityModifier = context.visibility() != null ? Visit(context.visibility()) ?? "" : "";

        if (!string.IsNullOrEmpty(visibilityModifier))
        {
            AppendIndented($"{visibilityModifier} ", originalLine, originalColumn);
        }
        string recordName = context.IDENTIFIER().GetText();
        string type;
        if (context.type() != null)
        {
            type = Visit(context.type());
        }
        else
        {
            type = "";
        }
        string modifiers = "";
        foreach (var modifier in context.modifier())
        {
            AppendIndented(modifier.GetText(), originalLine, originalColumn);
        }
        AppendIndentedLine("", originalLine, originalColumn);
        if (!string.IsNullOrEmpty(visibilityModifier))
        {
            AppendIndented($"{visibilityModifier} ", originalLine, originalColumn);
        }
        AppendIndented($"{modifiers} record {type} {recordName}", originalLine, originalColumn);
        if (context.arguments() != null)
        {
            Visit(context.arguments());
        }
        if (context.block() != null)
        {
            Visit(context.block());
        }
        else
        {
            AppendIndented(";", originalLine, originalColumn);
            AppendIndentedLine("", originalLine, originalColumn);
        }
        return null;
    }

    public override string VisitDelegateDecl(ArislParser.DelegateDeclContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        // Announcing parsing a Delegate Declaration
        //Console.WriteLine($"// Parsing Delegate Declaration: {context.IDENTIFIER().GetText()}");
        string visibilityModifier = context.visibility() != null ? Visit(context.visibility()) ?? "" : "";

        if (!string.IsNullOrEmpty(visibilityModifier))
        {
            AppendIndented($"{visibilityModifier} ", originalLine, originalColumn);
        }
        string delegateName = context.IDENTIFIER().GetText();
        string type;
        if (context.type() != null)
        {
            type = Visit(context.type());
        }
        else
        {
            type = "void";
        }
        string modifiers = "";
        foreach (var modifier in context.modifier())
        {
            AppendIndented(modifier.GetText(), originalLine, originalColumn);
        }
        AppendIndentedLine("", originalLine, originalColumn);
        if (!string.IsNullOrEmpty(visibilityModifier))
        {
            AppendIndented($"{visibilityModifier} ", originalLine, originalColumn);
        }
        AppendIndented($"{modifiers} delegate {type} {delegateName}", originalLine, originalColumn);
        if (context.genericType() != null)
        {
            AppendIndented(Visit(context.genericType()), originalLine, originalColumn);
        }
        if (context.arguments() != null)
        {
            Visit(context.arguments());
        }
        AppendIndented(";", originalLine, originalColumn);
        AppendIndentedLine("", originalLine, originalColumn);

        return null;
    }



    public override string VisitSwitchStatement(ArislParser.SwitchStatementContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        //Console.WriteLine("// Parsing Switch Statement");
        PushScope("switch", "switchStatement");

        AppendIndented("switch (", originalLine, originalColumn);
        Visit(context.expression());
        AppendIndentedLine(")", originalLine, originalColumn);
        AppendIndentedLine("{", originalLine, originalColumn);

        _indentLevel++;
        foreach (var caseBlk in context.caseBlock())
        {
            Visit(caseBlk);
        }

        if (context.defaultBlock() != null)
        {
            Visit(context.defaultBlock());
        }
        _indentLevel--;
        AppendIndentedLine("}", originalLine, originalColumn);
        PopScope();
        return null;
    }

    public override string VisitCaseBlock(ArislParser.CaseBlockContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        //Console.WriteLine("// Parsing Case Block");
        PushScope("case", "caseBlock");

        AppendIndented("case ", originalLine, originalColumn);
        Visit(context.expression());
        AppendIndentedLine(":", originalLine, originalColumn);

        _indentLevel++;
        foreach (var stmt in context.statement())
        {
            Visit(stmt);
        }
        _indentLevel--;
        PopScope();
        return null;
    }

    public override string VisitDefaultBlock(ArislParser.DefaultBlockContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        //Console.WriteLine("// Parsing Default Block");
        PushScope("default", "defaultBlock");

        AppendIndentedLine("default:", originalLine, originalColumn);

        _indentLevel++;
        foreach (var stmt in context.statement())
        {
            Visit(stmt);
        }
        _indentLevel--;
        PopScope();
        return null;
    }

    public override string VisitTryCatchStatement(ArislParser.TryCatchStatementContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        //Console.WriteLine("// Parsing Try-Catch Statement");
        PushScope("try-catch", "tryCatchStatement");

        AppendIndentedLine("try", originalLine, originalColumn);
        _indentLevel++;
        Visit(context.block(0));
        _indentLevel--;
        AppendIndentedLine("", originalLine, originalColumn);

        if (context.GetText().Contains("finally"))
        {
            _indentLevel++;
            // go through every block except the 0 and last block
            for (int i = 1; i < context.block().Length - 2; i++)
            {
                if (context.type(i) != null && context.IDENTIFIER(i) != null)
                {
                    AppendIndented("catch (", originalLine, originalColumn);
                    AppendIndented(Visit(context.type(i)), originalLine, originalColumn);
                    AppendIndented(" ", originalLine, originalColumn);
                    AppendIndented(context.IDENTIFIER(i).GetText(), originalLine, originalColumn);
                    AppendIndentedLine(")", originalLine, originalColumn);
                }
                else
                {
                    AppendIndentedLine("catch (Exception e)", originalLine, originalColumn);
                }
                Visit(context.block(i));
            }
            _indentLevel--;
            AppendIndentedLine("", originalLine, originalColumn);
            AppendIndentedLine("finally", originalLine, originalColumn);
            _indentLevel++;
            // visit the last block
            Visit(context.block(context.block().Length - 1));
            _indentLevel--;
        }
        else
        {
            for (int i = 1; i < context.block().Length; i++)
            {
                if (context.type(i) != null && context.IDENTIFIER(i) != null)
                {
                    AppendIndented("catch (", originalLine, originalColumn);
                    AppendIndented(Visit(context.type(i)), originalLine, originalColumn);
                    AppendIndented(" ", originalLine, originalColumn);
                    AppendIndented(context.IDENTIFIER(i).GetText(), originalLine, originalColumn);
                    AppendIndentedLine(")", originalLine, originalColumn);
                }
                else
                {
                    AppendIndentedLine("catch (Exception e)", originalLine, originalColumn);
                }
                Visit(context.block(i));
            }
        }
        PopScope();
        return null;
    }

    public override string VisitTuple(ArislParser.TupleContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing a Tuple
        //Console.WriteLine("// Parsing Tuple");

        Append("(", context.Start.Line, context.Start.Column);
        if (context.expression().Length > 0)
        {
            Visit(context.expression(0));
            for (int i = 1; i < context.expression().Length; i++)
            {
                Append(", ", context.Start.Line, context.Start.Column);
                Visit(context.expression(i));
            }
        }
        Append(")", context.Start.Line, context.Start.Column);
        return null;
    }

    public override string VisitArgs(ArislParser.ArgsContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing Args
        //Console.WriteLine("// Parsing Args");

        Append("(", context.Start.Line, context.Start.Column);
        for (int i = 0; i < context.param().Length; i++)
        {
            if (context.param(i) != null)
            {
                Visit(context.param(i));
            }
        }
        Append(")", context.Start.Line, context.Start.Column);
        return null;
    }

    public override string VisitVarArgs(ArislParser.VarArgsContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing VarArgs
        //Console.WriteLine("// Parsing VarArgs");

        Append("(", context.Start.Line, context.Start.Column);
        Append("params dynamic[] args", context.Start.Line, context.Start.Column);
        Append(")", context.Start.Line, context.Start.Column);
        return null;
    }

    public override string VisitParam(ArislParser.ParamContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing a Param
        //Console.WriteLine("// Parsing Param");
        foreach (var modifier in context.modifier())
        {
            Append(Visit(modifier), context.Start.Line, context.Start.Column);
        }
        if (context.type() != null)
        {
            Append(Visit(context.type()), context.Start.Line, context.Start.Column);
            Append(" ", context.Start.Line, context.Start.Column);
        }
        Append(context.IDENTIFIER().GetText(), context.Start.Line, context.Start.Column);
        if (context.COMMA() != null)
        {
            Append(", ", context.Start.Line, context.Start.Column);
        }
        return null;
    }

    public override string VisitReturnStatement(ArislParser.ReturnStatementContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        // Announcing parsing a Return Statement
        //Console.WriteLine("// Parsing Return Statement");

        Append("return", originalLine, originalColumn);
        if (context.expression() != null)
        {
            Append(" ", originalLine, originalColumn);
            Visit(context.expression());
        }

        // Check if parsing scope is a function
        var currentScope = CurrentScope();
        if (currentScope.Key == "function")
        {
            containsReturnStatement = true;
        }

        Visit(context.end(0));
        DebugPrint();
        return null;
    }

    public override string VisitEnd(ArislParser.EndContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        // Announcing parsing an End
        //Console.WriteLine("// Parsing End");
        if (context.GetText() == "~*~")
        {
            Append(" { get; set; }", originalLine, originalColumn);
            AppendIndentedLine("", originalLine, originalColumn);
        }
        else if (context.GetText() == "<*~")
        {
            Append(" { set; }", originalLine, originalColumn);
            AppendIndentedLine("", originalLine, originalColumn);
        }
        else if (context.GetText() == "~*>")
        {
            Append(" { get; }", originalLine, originalColumn);
            AppendIndentedLine("", originalLine, originalColumn);
        }
        else
        {
            Append(";", originalLine, originalColumn);
            AppendIndentedLine("", originalLine, originalColumn);
        }
        return null;
    }

    public override string VisitBlock(ArislParser.BlockContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        var currentScope = CurrentScope();
        //Console.WriteLine($"// Parsing Block. Is Dynamic? {isDynamic} current scope? {currentScope.Key}");

        AppendIndentedLine("{", originalLine, originalColumn);
        _indentLevel++;

        containsReturnStatement = false;

        foreach (var stmt in context.statement())
        {
            VisitStatement(stmt);
        }

        //Console.WriteLine($"// Finished Block statements. Is Dynamic? {isDynamic} current scope? {currentScope.Key}");

        if (currentScope.Key == "function" && isDynamic && !containsReturnStatement)
        {
            AppendIndentedLine("return default;", originalLine, originalColumn);
        }

        _indentLevel--;
        AppendIndentedLineAndStayOnLine("}", originalLine, originalColumn);

        DebugPrint();
        return null;
    }

    public override string VisitList(ArislParser.ListContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        int originalLine = context.Start.Line;
        int originalColumn = context.Start.Column;

        // Announcing parsing a list
        //Console.WriteLine("// Parsing list.");
        PushScope("list", "list");

        Append("{", originalLine, originalColumn);
        if (context.expression() != null)
        {
            Visit(context.expression());
        }
        PopScope();
        Append("}", originalLine, originalColumn);
        return null;
    }

    public override string VisitPrimaryExpression(ArislParser.PrimaryExpressionContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));
        // Announcing parsing a Primary Expression
        //Console.WriteLine("// Parsing Primary Expression");
        string modifiers = "";
        if (context.modifier(0) != null)
        {
            foreach (var modifier in context.modifier())
            {
                modifiers += Visit(modifier);
            }
        }

        if (context.type() != null)
        {
            if (currentVar != null && !currentVar.hastype)
            {
                //Console.WriteLine("VAR HAS TYPE");
                currentVar.hastype = true;
            }
            Append(modifiers, context.Start.Line, context.Start.Column);
            Append(Visit(context.type()), context.Start.Line, context.Start.Column);
            Append(" ", context.Start.Line, context.Start.Column);
        }
        else if (context.primary != null && context.primary() is ArislParser.ListPrimaryContext)
        {
            if (modifiers.Contains("tbl"))
            {
                if (currentVar != null) currentVar.uniqueModifiers += "tbl ";
                //Console.WriteLine("TABLE");
                Append("new Dictionary<dynamic, dynamic>", context.Start.Line, context.Start.Column);
            }
            else
            {
                Append("new List<dynamic>", context.Start.Line, context.Start.Column);
            }
        }
        if (context.primary() != null && context.primary() is ArislParser.IdentifierPrimaryContext && !varTokenPlaced)
        {
            if (currentVar != null)
            {
                currentVar.name = context.primary().GetText();
                var currentScope = CurrentScope();
                currentVar.scope = currentScope.Key;
                currentVar.scopeIdentifier = currentScope.Value;
                //Console.WriteLine("VAR NAME: " + currentVar.name);
            }
            if (currentVar != null && !string.IsNullOrEmpty(currentVar.name))
            {
                // check if in global dictionary
                string globalKey = $"{currentVar.scope}_{currentVar.scopeIdentifier}_{currentVar.name}";
                if (!globalVariables.ContainsKey(globalKey))
                {
                    var key = CurrentScope().Key;

                    if (currentVar.shouldAssignVarType() && key != "list" && key != "constructor")
                    {
                        if (key == "function")
                        {
                            Append("var ", context.Start.Line, context.Start.Column);
                        }
                        else
                        {
                            // check if the variable is static
                            if (currentVar.uniqueModifiers != null && !currentVar.uniqueModifiers.Contains("instantiated"))
                            {
                                Append("", context.Start.Line, context.Start.Column);
                            }
                            else if (currentVar.uniqueModifiers == null)
                            {
                                Append("static ", context.Start.Line, context.Start.Column);
                            }
                            Append("dynamic ", context.Start.Line, context.Start.Column);
                        }
                        globalVariables.Add(globalKey, currentVar);
                        varTokenPlaced = true;
                    }
                    else
                    {
                        globalVariables.Add(globalKey, currentVar);
                    }
                }
            }
        }

        // check if context.primary is a list
        VisitPrimary(context.primary());
        return null;
    }

    public override string VisitExpressionStatement(ArislParser.ExpressionStatementContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));
        if (currentVar == null) { currentVar = new Variable(); }
        // Announcing parsing an Expression Statement
        //Console.WriteLine("// Parsing Expression Statement");
        string visibilityModifier = "";
        if (context.visibility() != null && context.visibility().GLOBAL() == null)
        {
            visibilityModifier = Visit(context.visibility()) ?? "";
        }

        Append("", context.Start.Line, context.Start.Column);

        if (!string.IsNullOrEmpty(visibilityModifier))
        {
            Append($"{visibilityModifier} ", context.Start.Line, context.Start.Column);
        }
        if (context.modifier().Length > 0)
        {
            foreach (var modifier in context.modifier())
            {
                var text = Visit(modifier);
                if (text.Contains("instantiated") && currentVar != null)
                {
                    currentVar.uniqueModifiers += "instantiated ";
                    text = text.Replace("instantiated", "");
                }
                Append(text, context.Start.Line, context.Start.Column);
            }
        }
        if (context.expression() != null)
        {
            Visit(context.expression());
        }
        if (context.end(0) != null)
        {
            Visit(context.end(0));
        }
        else
        {
            //Console.WriteLine("NO END");
        }
        varTokenPlaced = false;
        currentVar = null;
        return null;
    }

    public override string VisitParenthesisExpression(ArislParser.ParenthesisExpressionContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing a Parenthesis Expression
        //Console.WriteLine("// Parsing Parenthesis Expression");

        Append("(", context.Start.Line, context.Start.Column);
        Visit(context.expression());
        Append(")", context.Start.Line, context.Start.Column);
        return null;
    }

    public override string VisitPrefixExpression(ArislParser.PrefixExpressionContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing a Prefix Expression
        //Console.WriteLine("// Parsing Prefix Expression");

        var text = context.prefix(0).GetText();
        Append(text, context.Start.Line, context.Start.Column);
        Visit(context.expression());
        return null;
    }

    public override string VisitUnaryExpression(ArislParser.UnaryExpressionContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing a Unary Expression
        //Console.WriteLine("// Parsing Unary Expression");

        var text = context.unaryOP(0).GetText();
        Visit(context.expression());
        Append(text, context.Start.Line, context.Start.Column);
        return null;
    }

    public override string VisitBinaryExpression(ArislParser.BinaryExpressionContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));
        var table = false;
        if (currentVar != null && !string.IsNullOrEmpty(currentVar.uniqueModifiers)) table = currentVar.uniqueModifiers.Contains("tbl");
        // Announcing parsing an Expression
        //Console.WriteLine("// Parsing Binary Expression " + "binary op count: " + context.binaryOp().Length);

        // Check if the binary operator is an = sign and if the left-hand side is an identifier
        if (context.binaryOp(0).GetText() == "=")
        {
            if (currentVar != null)
            {
                currentVar.beingAssignedValue = true;
                //Console.WriteLine("VAR BEING ASSIGNED VALUE");
            }
        }
        bool key = currentVar?.binaryIterations % 2 != 0;
        var leftExpr = context.expression(0);
        if (table && key) { Append("[", context.Start.Line, context.Start.Column); }
        Visit(leftExpr); // Access the first primary context
        if (table && key) { Append("]", context.Start.Line, context.Start.Column); }
        if (currentVar != null) currentVar.binaryIterations++;
        for (int i = 0; i < context.binaryOp().Length; i++)
        {
            var text = context.binaryOp(i).GetText(); // Accessing the individual binaryOp context
            text = MapBinaryOp(text);
            //Console.WriteLine("BINARY OP: " + text + "IS AN EQUAL SIGNS:" + text == "=");
            if (text != "." && text != ":" && text != ",")
            {
                Append(" ", context.Start.Line, context.Start.Column);
            }

            Append(text, context.Start.Line, context.Start.Column);
            if (text != "." && text != ":")
            {
                Append(" ", context.Start.Line, context.Start.Column);
            }
            Visit(context.expression(i + 1)); // Access the next primary context
        }
        return null;
    }

    // Helper method to map binary operators
    private string MapBinaryOp(string text)
    {
        return text switch
        {
            "::" => ":",
            "??" => "?",
            "|||" => "|",
            "and" => "&&",
            "or" => "||",
            "not" => "!",
            _ => text
        };
    }

    public override string VisitMethodCall(ArislParser.MethodCallContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing a Method Call
        //Console.WriteLine($"// Parsing Method Call: {context.IDENTIFIER().GetText()}");

        var methodName = context.IDENTIFIER().GetText();
        Append(methodName, context.Start.Line, context.Start.Column);

        if (context.genericType() != null)
        {
            Append(Visit(context.genericType()), context.Start.Line, context.Start.Column);
        }
        if (context.tuple() != null)
        {
            Visit(context.tuple());
        }
        return null;
    }

    public override string VisitTableCall(ArislParser.TableCallContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing a Table Call
        //Console.WriteLine($"// Parsing Table Call: {context.IDENTIFIER().GetText()}");

        var methodName = context.IDENTIFIER().GetText();
        Append(methodName, context.Start.Line, context.Start.Column);
        Append("[", context.Start.Line, context.Start.Column);

        var expression = context.expression();
        if (expression != null)
        {
            Visit(expression);
        }

        Append("]", context.Start.Line, context.Start.Column);
        return null;
    }

    public string VisitPrimary(ArislParser.PrimaryContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing a Primary
        //Console.WriteLine($"// Parsing Primary: {context.GetText()}");

        if (context is ArislParser.LiteralPrimaryContext literalContext)
        {
            Visit(literalContext);
        }
        else if (context is ArislParser.TuplePrimaryContext tupleContext)
        {
            Visit(tupleContext);
        }
        else if (context is ArislParser.IdentifierPrimaryContext identifierContext)
        {
            string id = identifierContext.IDENTIFIER().GetText();

            Append(id, context.Start.Line, context.Start.Column);
        }
        else if (context is ArislParser.MethodCallPrimaryContext methodCallContext)
        {
            Visit(methodCallContext);
        }
        else if (context is ArislParser.TableCallPrimaryContext tableCallContext)
        {
            Visit(tableCallContext);
        }
        else if (context is ArislParser.BlockPrimaryContext blockContext)
        {
            Visit(blockContext);
        }
        else if (context is ArislParser.ListPrimaryContext listContext)
        {
            Visit(listContext);
        }
        else if (context is ArislParser.GenericTypePrimaryContext genericTypeContext)
        {
            Visit(genericTypeContext);
        }
        else if (context is ArislParser.TypePrimaryContext typeContext)
        {
            Visit(typeContext);
        }

        return null;
    }

    public override string VisitLiteral(ArislParser.LiteralContext context)
    {
        if (context == null) throw new ArgumentNullException(nameof(context));

        // Announcing parsing a Literal
        //Console.WriteLine($"// Parsing Literal: {context.GetText()}");

        if (context.NUMBER() != null)
        {
            Append(context.NUMBER().GetText(), context.Start.Line, context.Start.Column);
        }
        else if (context.STRING() != null)
        {
            string str = context.STRING().GetText();

            if (str.StartsWith("\"") && str.EndsWith("\""))
            {
                str = ProcessRegularString(str);
            }
            else if (str.StartsWith("'") && str.EndsWith("'"))
            {
                str = ProcessSingleQuotedString(str);
            }
            else if (str.StartsWith("$\"") && str.EndsWith("\""))
            {
                str = ProcessInterpolatedString(str);
            }
            else if (str.StartsWith("$'") && str.EndsWith("'"))
            {
                str = ProcessInterpolatedString(str);
            }
            else if (str.StartsWith("@\"") && str.EndsWith("\""))
            {
                str = ProcessVerbatimString(str);
            }
            else if (str.StartsWith("@'") && str.EndsWith("'"))
            {
                str = ProcessVerbatimString(str);
            }
            else if (str.StartsWith("\"\"\"") && str.EndsWith("\"\"\""))
            {
                str = ProcessRawString(str);
            }
            else if (str.StartsWith("$@\"\"\"") && str.EndsWith("\"\"\""))
            {
                str = ProcessRawInterpolatedString(str);
            }

            Append(str, context.Start.Line, context.Start.Column);
        }
        else if (context.GetText() == "true" || context.GetText() == "false")
        {
            Append(context.GetText(), context.Start.Line, context.Start.Column);
        }
        else if (context.GetText() == "null")
        {
            Append("null", context.Start.Line, context.Start.Column);
        }

        return null;
    }

    private string ProcessRegularString(string str)
    {
        str = str.Substring(1, str.Length - 2);
        str = str.Replace("\\", "\\\\").Replace("\"", "\\\"");
        return "\"" + str + "\"";
    }

    private string ProcessSingleQuotedString(string str)
    {
        str = str.Substring(1, str.Length - 2);
        str = str.Replace("\\", "\\\\").Replace("\"", "\\\"");
        return "\"" + str + "\"";
    }

    private string ProcessInterpolatedString(string str)
    {
        str = str.Substring(2, str.Length - 3);
        str = str.Replace("\\", "\\\\").Replace("\"", "\\\"");
        return "$\"" + str + "\"";
    }

    private string ProcessVerbatimString(string str)
    {
        str = str.Substring(2, str.Length - 3);
        str = str.Replace("\"", "\"\"");
        return "@\"" + str + "\"";
    }

    private string ProcessRawString(string str)
    {
        str = str.Substring(3, str.Length - 6);
        return "\"\"\"" + str + "\"\"\"";
    }

    private string ProcessRawInterpolatedString(string str)
    {
        str = str.Substring(5, str.Length - 10);
        return "$@\"\"\"" + str + "\"\"\"";
    }

    public class SourceMap
    {
        public List<MappingEntry> Mappings { get; private set; } = new List<MappingEntry>();

        public void AddMapping(int generatedLine, int generatedColumn, int originalLine, int originalColumn)
        {
            Mappings.Add(new MappingEntry
            {
                GeneratedLine = generatedLine,
                GeneratedColumn = generatedColumn,
                OriginalLine = originalLine,
                OriginalColumn = originalColumn
            });
        }

        public MappingEntry? GetOriginalPosition(int generatedLine, int generatedColumn)
        {
            return Mappings.FirstOrDefault(m => m.GeneratedLine == generatedLine && m.GeneratedColumn == generatedColumn);
        }

        public class MappingEntry
        {
            public int GeneratedLine { get; set; }
            public int GeneratedColumn { get; set; }
            public int OriginalLine { get; set; }
            public int OriginalColumn { get; set; }
        }
    }
}
