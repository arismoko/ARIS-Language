// Generated from c:/Users/ari/Desktop/C# Projects/ARISL/antlrfiles/Arisl.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArislParser}.
 */
public interface ArislListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ArislParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ArislParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ArislParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ArislParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ArislParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#asyncFunctionDecl}.
	 * @param ctx the parse tree
	 */
	void enterAsyncFunctionDecl(ArislParser.AsyncFunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#asyncFunctionDecl}.
	 * @param ctx the parse tree
	 */
	void exitAsyncFunctionDecl(ArislParser.AsyncFunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#repeatUntilStatement}.
	 * @param ctx the parse tree
	 */
	void enterRepeatUntilStatement(ArislParser.RepeatUntilStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#repeatUntilStatement}.
	 * @param ctx the parse tree
	 */
	void exitRepeatUntilStatement(ArislParser.RepeatUntilStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(ArislParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(ArislParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#structDecl}.
	 * @param ctx the parse tree
	 */
	void enterStructDecl(ArislParser.StructDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#structDecl}.
	 * @param ctx the parse tree
	 */
	void exitStructDecl(ArislParser.StructDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(ArislParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(ArislParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(ArislParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(ArislParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(ArislParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(ArislParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(ArislParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(ArislParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#forEachStatement}.
	 * @param ctx the parse tree
	 */
	void enterForEachStatement(ArislParser.ForEachStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#forEachStatement}.
	 * @param ctx the parse tree
	 */
	void exitForEachStatement(ArislParser.ForEachStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(ArislParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(ArislParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#awaitStatement}.
	 * @param ctx the parse tree
	 */
	void enterAwaitStatement(ArislParser.AwaitStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#awaitStatement}.
	 * @param ctx the parse tree
	 */
	void exitAwaitStatement(ArislParser.AwaitStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#objectCreation}.
	 * @param ctx the parse tree
	 */
	void enterObjectCreation(ArislParser.ObjectCreationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#objectCreation}.
	 * @param ctx the parse tree
	 */
	void exitObjectCreation(ArislParser.ObjectCreationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#classProperties}.
	 * @param ctx the parse tree
	 */
	void enterClassProperties(ArislParser.ClassPropertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#classProperties}.
	 * @param ctx the parse tree
	 */
	void exitClassProperties(ArislParser.ClassPropertiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#classProperty}.
	 * @param ctx the parse tree
	 */
	void enterClassProperty(ArislParser.ClassPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#classProperty}.
	 * @param ctx the parse tree
	 */
	void exitClassProperty(ArislParser.ClassPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#classBlock}.
	 * @param ctx the parse tree
	 */
	void enterClassBlock(ArislParser.ClassBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#classBlock}.
	 * @param ctx the parse tree
	 */
	void exitClassBlock(ArislParser.ClassBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#structBlock}.
	 * @param ctx the parse tree
	 */
	void enterStructBlock(ArislParser.StructBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#structBlock}.
	 * @param ctx the parse tree
	 */
	void exitStructBlock(ArislParser.StructBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#classMember}.
	 * @param ctx the parse tree
	 */
	void enterClassMember(ArislParser.ClassMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#classMember}.
	 * @param ctx the parse tree
	 */
	void exitClassMember(ArislParser.ClassMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#structMember}.
	 * @param ctx the parse tree
	 */
	void enterStructMember(ArislParser.StructMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#structMember}.
	 * @param ctx the parse tree
	 */
	void exitStructMember(ArislParser.StructMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ArislParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ArislParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(ArislParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(ArislParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(ArislParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(ArislParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(ArislParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(ArislParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ArislParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ArislParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(ArislParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(ArislParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(ArislParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(ArislParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#postfixOp}.
	 * @param ctx the parse tree
	 */
	void enterPostfixOp(ArislParser.PostfixOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#postfixOp}.
	 * @param ctx the parse tree
	 */
	void exitPostfixOp(ArislParser.PostfixOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(ArislParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(ArislParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ArislParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ArislParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(ArislParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(ArislParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(ArislParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(ArislParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#tableEntry}.
	 * @param ctx the parse tree
	 */
	void enterTableEntry(ArislParser.TableEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#tableEntry}.
	 * @param ctx the parse tree
	 */
	void exitTableEntry(ArislParser.TableEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOp(ArislParser.BinaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOp(ArislParser.BinaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#tryCatchStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryCatchStatement(ArislParser.TryCatchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#tryCatchStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryCatchStatement(ArislParser.TryCatchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(ArislParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(ArislParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void enterCaseBlock(ArislParser.CaseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void exitCaseBlock(ArislParser.CaseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void enterDefaultBlock(ArislParser.DefaultBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void exitDefaultBlock(ArislParser.DefaultBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(ArislParser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(ArislParser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(ArislParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(ArislParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArislParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(ArislParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArislParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(ArislParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarType}
	 * labeled alternative in {@link ArislParser#type}.
	 * @param ctx the parse tree
	 */
	void enterVarType(ArislParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarType}
	 * labeled alternative in {@link ArislParser#type}.
	 * @param ctx the parse tree
	 */
	void exitVarType(ArislParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleType}
	 * labeled alternative in {@link ArislParser#type}.
	 * @param ctx the parse tree
	 */
	void enterSimpleType(ArislParser.SimpleTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleType}
	 * labeled alternative in {@link ArislParser#type}.
	 * @param ctx the parse tree
	 */
	void exitSimpleType(ArislParser.SimpleTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NestedType}
	 * labeled alternative in {@link ArislParser#type}.
	 * @param ctx the parse tree
	 */
	void enterNestedType(ArislParser.NestedTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NestedType}
	 * labeled alternative in {@link ArislParser#type}.
	 * @param ctx the parse tree
	 */
	void exitNestedType(ArislParser.NestedTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TupleType}
	 * labeled alternative in {@link ArislParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTupleType(ArislParser.TupleTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TupleType}
	 * labeled alternative in {@link ArislParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTupleType(ArislParser.TupleTypeContext ctx);
}