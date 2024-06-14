// Generated from c:/Users/ari/Desktop/C# Projects/ARISL/antlrfiles/Arisl.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ArislParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, T__78=79, T__79=80, 
		T__80=81, T__81=82, T__82=83, T__83=84, T__84=85, T__85=86, T__86=87, 
		T__87=88, T__88=89, T__89=90, T__90=91, T__91=92, T__92=93, T__93=94, 
		T__94=95, T__95=96, T__96=97, T__97=98, T__98=99, T__99=100, T__100=101, 
		T__101=102, T__102=103, T__103=104, T__104=105, T__105=106, T__106=107, 
		T__107=108, T__108=109, T__109=110, T__110=111, T__111=112, T__112=113, 
		T__113=114, T__114=115, PRIVATE=116, PUBLIC=117, GLOBAL=118, IDENTIFIER=119, 
		NUMBER=120, COMMA=121, TYPETOKEN=122, PARENTHESISOPEN=123, PARENTHESISCLOSE=124, 
		STRING=125, LINE_COMMENT=126, BLOCK_COMMENT=127, WS=128;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_delegateDecl = 2, RULE_recordDecl = 3, 
		RULE_functionDecl = 4, RULE_repeatUntilStatement = 5, RULE_classDecl = 6, 
		RULE_constructorDecl = 7, RULE_structDecl = 8, RULE_enumDecl = 9, RULE_interfaceDecl = 10, 
		RULE_ifStatement = 11, RULE_whileStatement = 12, RULE_forStatement = 13, 
		RULE_forEachStatement = 14, RULE_returnStatement = 15, RULE_operatorOverloadStatement = 16, 
		RULE_objectCreation = 17, RULE_interfaceBlock = 18, RULE_interfaceMember = 19, 
		RULE_functionSignature = 20, RULE_block = 21, RULE_list = 22, RULE_expressionStatement = 23, 
		RULE_expression = 24, RULE_primary = 25, RULE_tuple = 26, RULE_arguments = 27, 
		RULE_param = 28, RULE_prefix = 29, RULE_unaryOP = 30, RULE_methodCall = 31, 
		RULE_tableCall = 32, RULE_literal = 33, RULE_binaryOp = 34, RULE_tryCatchStatement = 35, 
		RULE_switchStatement = 36, RULE_caseBlock = 37, RULE_defaultBlock = 38, 
		RULE_modifier = 39, RULE_visibility = 40, RULE_type = 41, RULE_varType = 42, 
		RULE_simpleType = 43, RULE_tupleType = 44, RULE_genericType = 45, RULE_nestedType = 46, 
		RULE_castType = 47, RULE_end = 48;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "delegateDecl", "recordDecl", "functionDecl", 
			"repeatUntilStatement", "classDecl", "constructorDecl", "structDecl", 
			"enumDecl", "interfaceDecl", "ifStatement", "whileStatement", "forStatement", 
			"forEachStatement", "returnStatement", "operatorOverloadStatement", "objectCreation", 
			"interfaceBlock", "interfaceMember", "functionSignature", "block", "list", 
			"expressionStatement", "expression", "primary", "tuple", "arguments", 
			"param", "prefix", "unaryOP", "methodCall", "tableCall", "literal", "binaryOp", 
			"tryCatchStatement", "switchStatement", "caseBlock", "defaultBlock", 
			"modifier", "visibility", "type", "varType", "simpleType", "tupleType", 
			"genericType", "nestedType", "castType", "end"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'delegate'", "'record'", "'func'", "'repeat'", "'until'", "'class'", 
			"':'", "'@'", "'struct'", "'enum'", "'interface'", "'if'", "'else if'", 
			"'else'", "'while'", "'for'", "'foreach'", "'in'", "'return'", "'operator'", 
			"'create'", "'{'", "'}'", "'|'", "'...'", "'!'", "'-'", "'++'", "'--'", 
			"'['", "']'", "'true'", "'false'", "'null'", "'^='", "'^'", "'*='", "'*'", 
			"'/='", "'/'", "'%='", "'%'", "'+='", "'+'", "'-='", "'=='", "'!='", 
			"'<='", "'<'", "'>='", "'>'", "'='", "'not'", "'&&'", "'and'", "'||'", 
			"'or'", "'|||'", "'::'", "'.'", "'??'", "'=>'", "'->'", "'<-'", "'<<'", 
			"'>>'", "'>>>'", "'<<='", "'>>='", "'>>>='", "'is'", "'try'", "'catch'", 
			"'finally'", "'switch'", "'case'", "'default'", "'static'", "'instantiated'", 
			"'abstract'", "'final'", "'override'", "'virtual'", "'sealed'", "'volatile'", 
			"'readonly'", "'const'", "'new'", "'ref'", "'out'", "'tbl'", "'async'", 
			"'let'", "'select'", "'where'", "'group'", "'into'", "'orderby'", "'join'", 
			"'equals'", "'on'", "'from'", "'ascending'", "'descending'", "'fixed'", 
			"'unsafe'", "'checked'", "'unchecked'", "'await'", "'~~'", "'<~'", "';'", 
			"'~*~'", "'<*~'", "'~*>'", "'private'", "'public'", "'global'", null, 
			null, "','", "'~'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "PRIVATE", "PUBLIC", 
			"GLOBAL", "IDENTIFIER", "NUMBER", "COMMA", "TYPETOKEN", "PARENTHESISOPEN", 
			"PARENTHESISCLOSE", "STRING", "LINE_COMMENT", "BLOCK_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Arisl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ArislParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30290190174L) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & 12930806498459593L) != 0)) {
				{
				{
				setState(98);
				statement();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructDeclIDContext extends StatementContext {
		public StructDeclContext structDecl() {
			return getRuleContext(StructDeclContext.class,0);
		}
		public StructDeclIDContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectCreationStatementIDContext extends StatementContext {
		public ObjectCreationContext objectCreation() {
			return getRuleContext(ObjectCreationContext.class,0);
		}
		public ObjectCreationStatementIDContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceDeclIDContext extends StatementContext {
		public InterfaceDeclContext interfaceDecl() {
			return getRuleContext(InterfaceDeclContext.class,0);
		}
		public InterfaceDeclIDContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementIDContext extends StatementContext {
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public ForStatementIDContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DelegateDeclIDContext extends StatementContext {
		public DelegateDeclContext delegateDecl() {
			return getRuleContext(DelegateDeclContext.class,0);
		}
		public DelegateDeclIDContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclIDContext extends StatementContext {
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public FunctionDeclIDContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclIDContext extends StatementContext {
		public ClassDeclContext classDecl() {
			return getRuleContext(ClassDeclContext.class,0);
		}
		public ClassDeclIDContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RepeatUntilStatementIDContext extends StatementContext {
		public RepeatUntilStatementContext repeatUntilStatement() {
			return getRuleContext(RepeatUntilStatementContext.class,0);
		}
		public RepeatUntilStatementIDContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementIDContext extends StatementContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public IfStatementIDContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorDeclIDContext extends StatementContext {
		public ConstructorDeclContext constructorDecl() {
			return getRuleContext(ConstructorDeclContext.class,0);
		}
		public ConstructorDeclIDContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RecordDeclIDContext extends StatementContext {
		public RecordDeclContext recordDecl() {
			return getRuleContext(RecordDeclContext.class,0);
		}
		public RecordDeclIDContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementIDContext extends StatementContext {
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public ExpressionStatementIDContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementIDContext extends StatementContext {
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public WhileStatementIDContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStatementIDContext extends StatementContext {
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public SwitchStatementIDContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForEachStatementIDContext extends StatementContext {
		public ForEachStatementContext forEachStatement() {
			return getRuleContext(ForEachStatementContext.class,0);
		}
		public ForEachStatementIDContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TryCatchStatementIDContext extends StatementContext {
		public TryCatchStatementContext tryCatchStatement() {
			return getRuleContext(TryCatchStatementContext.class,0);
		}
		public TryCatchStatementIDContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementIDContext extends StatementContext {
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ReturnStatementIDContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EnumDeclIDContext extends StatementContext {
		public EnumDeclContext enumDecl() {
			return getRuleContext(EnumDeclContext.class,0);
		}
		public EnumDeclIDContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new FunctionDeclIDContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				functionDecl();
				}
				break;
			case 2:
				_localctx = new DelegateDeclIDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				delegateDecl();
				}
				break;
			case 3:
				_localctx = new ConstructorDeclIDContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				constructorDecl();
				}
				break;
			case 4:
				_localctx = new ClassDeclIDContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(107);
				classDecl();
				}
				break;
			case 5:
				_localctx = new StructDeclIDContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(108);
				structDecl();
				}
				break;
			case 6:
				_localctx = new RecordDeclIDContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(109);
				recordDecl();
				}
				break;
			case 7:
				_localctx = new EnumDeclIDContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(110);
				enumDecl();
				}
				break;
			case 8:
				_localctx = new InterfaceDeclIDContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(111);
				interfaceDecl();
				}
				break;
			case 9:
				_localctx = new IfStatementIDContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(112);
				ifStatement();
				}
				break;
			case 10:
				_localctx = new WhileStatementIDContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(113);
				whileStatement();
				}
				break;
			case 11:
				_localctx = new ForStatementIDContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(114);
				forStatement();
				}
				break;
			case 12:
				_localctx = new ForEachStatementIDContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(115);
				forEachStatement();
				}
				break;
			case 13:
				_localctx = new ReturnStatementIDContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(116);
				returnStatement();
				}
				break;
			case 14:
				_localctx = new ObjectCreationStatementIDContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(117);
				objectCreation();
				}
				break;
			case 15:
				_localctx = new TryCatchStatementIDContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(118);
				tryCatchStatement();
				}
				break;
			case 16:
				_localctx = new RepeatUntilStatementIDContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(119);
				repeatUntilStatement();
				}
				break;
			case 17:
				_localctx = new SwitchStatementIDContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(120);
				switchStatement();
				}
				break;
			case 18:
				_localctx = new ExpressionStatementIDContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(121);
				expressionStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DelegateDeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ArislParser.IDENTIFIER, 0); }
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public VisibilityContext visibility() {
			return getRuleContext(VisibilityContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public GenericTypeContext genericType() {
			return getRuleContext(GenericTypeContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public DelegateDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delegateDecl; }
	}

	public final DelegateDeclContext delegateDecl() throws RecognitionException {
		DelegateDeclContext _localctx = new DelegateDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_delegateDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & 7L) != 0)) {
				{
				setState(124);
				visibility();
				}
			}

			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17 || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 4294967295L) != 0)) {
				{
				{
				setState(127);
				modifier();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & 12289L) != 0)) {
				{
				setState(133);
				type();
				}
			}

			setState(136);
			match(T__0);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPETOKEN) {
				{
				setState(137);
				genericType();
				}
			}

			setState(140);
			match(IDENTIFIER);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTHESISOPEN) {
				{
				setState(141);
				arguments();
				}
			}

			setState(144);
			end();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RecordDeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ArislParser.IDENTIFIER, 0); }
		public VisibilityContext visibility() {
			return getRuleContext(VisibilityContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public RecordDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordDecl; }
	}

	public final RecordDeclContext recordDecl() throws RecognitionException {
		RecordDeclContext _localctx = new RecordDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_recordDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & 7L) != 0)) {
				{
				setState(146);
				visibility();
				}
			}

			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17 || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 4294967295L) != 0)) {
				{
				{
				setState(149);
				modifier();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & 12289L) != 0)) {
				{
				setState(155);
				type();
				}
			}

			setState(158);
			match(T__1);
			setState(159);
			match(IDENTIFIER);
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(160);
				arguments();
				}
				break;
			}
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(163);
				block();
				}
				break;
			}
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 112)) & ~0x3f) == 0 && ((1L << (_la - 112)) & 15L) != 0)) {
				{
				setState(166);
				end();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ArislParser.IDENTIFIER, 0); }
		public VisibilityContext visibility() {
			return getRuleContext(VisibilityContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public GenericTypeContext genericType() {
			return getRuleContext(GenericTypeContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & 7L) != 0)) {
				{
				setState(169);
				visibility();
				}
			}

			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17 || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 4294967295L) != 0)) {
				{
				{
				setState(172);
				modifier();
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & 12289L) != 0)) {
				{
				setState(178);
				type();
				}
			}

			setState(181);
			match(T__2);
			setState(182);
			match(IDENTIFIER);
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(183);
				genericType();
				}
				break;
			}
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(186);
				arguments();
				}
				break;
			}
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(189);
				block();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RepeatUntilStatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RepeatUntilStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatUntilStatement; }
	}

	public final RepeatUntilStatementContext repeatUntilStatement() throws RecognitionException {
		RepeatUntilStatementContext _localctx = new RepeatUntilStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_repeatUntilStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(T__3);
			setState(193);
			block();
			setState(194);
			match(T__4);
			setState(195);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ArislParser.IDENTIFIER, 0); }
		public VisibilityContext visibility() {
			return getRuleContext(VisibilityContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & 7L) != 0)) {
				{
				setState(197);
				visibility();
				}
			}

			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17 || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 4294967295L) != 0)) {
				{
				{
				setState(200);
				modifier();
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(206);
			match(T__5);
			setState(207);
			match(IDENTIFIER);
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(208);
				match(T__6);
				setState(209);
				type();
				}
			}

			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(212);
				block();
				}
				break;
			}
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 112)) & ~0x3f) == 0 && ((1L << (_la - 112)) & 15L) != 0)) {
				{
				setState(215);
				end();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorDeclContext extends ParserRuleContext {
		public VisibilityContext visibility() {
			return getRuleContext(VisibilityContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public ConstructorDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDecl; }
	}

	public final ConstructorDeclContext constructorDecl() throws RecognitionException {
		ConstructorDeclContext _localctx = new ConstructorDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constructorDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & 7L) != 0)) {
				{
				setState(218);
				visibility();
				}
			}

			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17 || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 4294967295L) != 0)) {
				{
				{
				setState(221);
				modifier();
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(227);
			match(T__7);
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(228);
				arguments();
				}
				break;
			}
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(231);
				block();
				}
				break;
			}
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 112)) & ~0x3f) == 0 && ((1L << (_la - 112)) & 15L) != 0)) {
				{
				setState(234);
				end();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructDeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ArislParser.IDENTIFIER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public VisibilityContext visibility() {
			return getRuleContext(VisibilityContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public StructDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDecl; }
	}

	public final StructDeclContext structDecl() throws RecognitionException {
		StructDeclContext _localctx = new StructDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_structDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & 7L) != 0)) {
				{
				setState(237);
				visibility();
				}
			}

			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17 || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 4294967295L) != 0)) {
				{
				{
				setState(240);
				modifier();
				}
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(246);
			match(T__8);
			setState(247);
			match(IDENTIFIER);
			setState(248);
			block();
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 112)) & ~0x3f) == 0 && ((1L << (_la - 112)) & 15L) != 0)) {
				{
				setState(249);
				end();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumDeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ArislParser.IDENTIFIER, 0); }
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public VisibilityContext visibility() {
			return getRuleContext(VisibilityContext.class,0);
		}
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public EnumDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDecl; }
	}

	public final EnumDeclContext enumDecl() throws RecognitionException {
		EnumDeclContext _localctx = new EnumDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_enumDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & 7L) != 0)) {
				{
				setState(252);
				visibility();
				}
			}

			setState(255);
			match(T__9);
			setState(256);
			match(IDENTIFIER);
			setState(257);
			list();
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 112)) & ~0x3f) == 0 && ((1L << (_la - 112)) & 15L) != 0)) {
				{
				setState(258);
				end();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceDeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ArislParser.IDENTIFIER, 0); }
		public InterfaceBlockContext interfaceBlock() {
			return getRuleContext(InterfaceBlockContext.class,0);
		}
		public VisibilityContext visibility() {
			return getRuleContext(VisibilityContext.class,0);
		}
		public InterfaceDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDecl; }
	}

	public final InterfaceDeclContext interfaceDecl() throws RecognitionException {
		InterfaceDeclContext _localctx = new InterfaceDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_interfaceDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & 7L) != 0)) {
				{
				setState(261);
				visibility();
				}
			}

			setState(264);
			match(T__10);
			setState(265);
			match(IDENTIFIER);
			setState(266);
			interfaceBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(T__11);
			setState(269);
			expression(0);
			setState(270);
			block();
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(271);
				match(T__12);
				setState(272);
				expression(0);
				setState(273);
				block();
				}
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(280);
				match(T__13);
				setState(281);
				block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(T__14);
			setState(285);
			expression(0);
			setState(286);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<EndContext> end() {
			return getRuleContexts(EndContext.class);
		}
		public EndContext end(int i) {
			return getRuleContext(EndContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(T__15);
			setState(290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(289);
				type();
				}
				break;
			}
			setState(292);
			expression(0);
			setState(293);
			end();
			setState(294);
			expression(0);
			setState(295);
			end();
			setState(296);
			expression(0);
			setState(297);
			end();
			setState(298);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForEachStatementContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ArislParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ForEachStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forEachStatement; }
	}

	public final ForEachStatementContext forEachStatement() throws RecognitionException {
		ForEachStatementContext _localctx = new ForEachStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forEachStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(T__16);
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & 12289L) != 0)) {
				{
				setState(301);
				type();
				}
			}

			setState(304);
			match(IDENTIFIER);
			setState(305);
			match(T__17);
			setState(306);
			expression(0);
			setState(307);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<EndContext> end() {
			return getRuleContexts(EndContext.class);
		}
		public EndContext end(int i) {
			return getRuleContext(EndContext.class,i);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(T__18);
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30287331328L) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 200119706189823L) != 0)) {
				{
				setState(310);
				expression(0);
				}
			}

			setState(314); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(313);
				end();
				}
				}
				setState(316); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 112)) & ~0x3f) == 0 && ((1L << (_la - 112)) & 15L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorOverloadStatementContext extends ParserRuleContext {
		public BinaryOpContext binaryOp() {
			return getRuleContext(BinaryOpContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public VisibilityContext visibility() {
			return getRuleContext(VisibilityContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public OperatorOverloadStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorOverloadStatement; }
	}

	public final OperatorOverloadStatementContext operatorOverloadStatement() throws RecognitionException {
		OperatorOverloadStatementContext _localctx = new OperatorOverloadStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_operatorOverloadStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & 7L) != 0)) {
				{
				setState(318);
				visibility();
				}
			}

			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17 || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 4294967295L) != 0)) {
				{
				{
				setState(321);
				modifier();
				}
				}
				setState(326);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & 12289L) != 0)) {
				{
				setState(327);
				type();
				}
			}

			setState(330);
			match(T__19);
			setState(331);
			binaryOp();
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTHESISOPEN) {
				{
				setState(332);
				arguments();
				}
			}

			setState(335);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectCreationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ArislParser.IDENTIFIER, 0); }
		public VisibilityContext visibility() {
			return getRuleContext(VisibilityContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public List<EndContext> end() {
			return getRuleContexts(EndContext.class);
		}
		public EndContext end(int i) {
			return getRuleContext(EndContext.class,i);
		}
		public ObjectCreationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectCreation; }
	}

	public final ObjectCreationContext objectCreation() throws RecognitionException {
		ObjectCreationContext _localctx = new ObjectCreationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_objectCreation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(T__20);
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & 7L) != 0)) {
				{
				setState(338);
				visibility();
				}
			}

			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17 || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 4294967295L) != 0)) {
				{
				{
				setState(341);
				modifier();
				}
				}
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(347);
			type();
			setState(348);
			match(IDENTIFIER);
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTHESISOPEN) {
				{
				setState(349);
				tuple();
				}
			}

			setState(353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(352);
				list();
				}
			}

			setState(356); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(355);
				end();
				}
				}
				setState(358); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 112)) & ~0x3f) == 0 && ((1L << (_la - 112)) & 15L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceBlockContext extends ParserRuleContext {
		public List<InterfaceMemberContext> interfaceMember() {
			return getRuleContexts(InterfaceMemberContext.class);
		}
		public InterfaceMemberContext interfaceMember(int i) {
			return getRuleContext(InterfaceMemberContext.class,i);
		}
		public InterfaceBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBlock; }
	}

	public final InterfaceBlockContext interfaceBlock() throws RecognitionException {
		InterfaceBlockContext _localctx = new InterfaceBlockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_interfaceBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(T__21);
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & 12801L) != 0)) {
				{
				{
				setState(361);
				interfaceMember();
				}
				}
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(367);
			match(T__22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceMemberContext extends ParserRuleContext {
		public FunctionSignatureContext functionSignature() {
			return getRuleContext(FunctionSignatureContext.class,0);
		}
		public InterfaceMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMember; }
	}

	public final InterfaceMemberContext interfaceMember() throws RecognitionException {
		InterfaceMemberContext _localctx = new InterfaceMemberContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_interfaceMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			functionSignature();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionSignatureContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ArislParser.IDENTIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public List<EndContext> end() {
			return getRuleContexts(EndContext.class);
		}
		public EndContext end(int i) {
			return getRuleContext(EndContext.class,i);
		}
		public FunctionSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionSignature; }
	}

	public final FunctionSignatureContext functionSignature() throws RecognitionException {
		FunctionSignatureContext _localctx = new FunctionSignatureContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_functionSignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & 12289L) != 0)) {
				{
				setState(371);
				type();
				}
			}

			setState(374);
			match(IDENTIFIER);
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTHESISOPEN) {
				{
				setState(375);
				arguments();
				}
			}

			setState(379); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(378);
				end();
				}
				}
				setState(381); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 112)) & ~0x3f) == 0 && ((1L << (_la - 112)) & 15L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			match(T__21);
			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30290190174L) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & 12930806498459593L) != 0)) {
				{
				{
				setState(384);
				statement();
				}
				}
				setState(389);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(390);
			match(T__22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			match(T__23);
			setState(393);
			expression(0);
			setState(394);
			match(T__23);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VisibilityContext visibility() {
			return getRuleContext(VisibilityContext.class,0);
		}
		public List<EndContext> end() {
			return getRuleContexts(EndContext.class);
		}
		public EndContext end(int i) {
			return getRuleContext(EndContext.class,i);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & 7L) != 0)) {
				{
				setState(396);
				visibility();
				}
			}

			setState(399);
			expression(0);
			setState(401); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(400);
				end();
				}
				}
				setState(403); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 112)) & ~0x3f) == 0 && ((1L << (_la - 112)) & 15L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpressionContext extends ExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public PrimaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BinaryOpContext> binaryOp() {
			return getRuleContexts(BinaryOpContext.class);
		}
		public BinaryOpContext binaryOp(int i) {
			return getRuleContext(BinaryOpContext.class,i);
		}
		public BinaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesisExpressionContext extends ExpressionContext {
		public TerminalNode PARENTHESISOPEN() { return getToken(ArislParser.PARENTHESISOPEN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PARENTHESISCLOSE() { return getToken(ArislParser.PARENTHESISCLOSE, 0); }
		public ParenthesisExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrefixExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<PrefixContext> prefix() {
			return getRuleContexts(PrefixContext.class);
		}
		public PrefixContext prefix(int i) {
			return getRuleContext(PrefixContext.class,i);
		}
		public PrefixExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<UnaryOPContext> unaryOP() {
			return getRuleContexts(UnaryOPContext.class);
		}
		public UnaryOPContext unaryOP(int i) {
			return getRuleContext(UnaryOPContext.class,i);
		}
		public UnaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				_localctx = new PrimaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(409);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__17 || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 4294967295L) != 0)) {
					{
					{
					setState(406);
					modifier();
					}
					}
					setState(411);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(413);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
				case 1:
					{
					setState(412);
					type();
					}
					break;
				}
				setState(415);
				primary();
				}
				break;
			case 2:
				{
				_localctx = new ParenthesisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(416);
				match(PARENTHESISOPEN);
				setState(417);
				expression(0);
				setState(418);
				match(PARENTHESISCLOSE);
				}
				break;
			case 3:
				{
				_localctx = new PrefixExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(421); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(420);
						prefix();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(423); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(425);
				expression(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(445);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(443);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(429);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(433); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(430);
								binaryOp();
								setState(431);
								expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(435); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 2:
						{
						_localctx = new UnaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(437);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(439); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(438);
								unaryOP();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(441); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(447);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListPrimaryContext extends PrimaryContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ListPrimaryContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierPrimaryContext extends PrimaryContext {
		public TerminalNode IDENTIFIER() { return getToken(ArislParser.IDENTIFIER, 0); }
		public IdentifierPrimaryContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TableCallPrimaryContext extends PrimaryContext {
		public TableCallContext tableCall() {
			return getRuleContext(TableCallContext.class,0);
		}
		public TableCallPrimaryContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GenericTypePrimaryContext extends PrimaryContext {
		public GenericTypeContext genericType() {
			return getRuleContext(GenericTypeContext.class,0);
		}
		public GenericTypePrimaryContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockPrimaryContext extends PrimaryContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockPrimaryContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TuplePrimaryContext extends PrimaryContext {
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public TuplePrimaryContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralPrimaryContext extends PrimaryContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralPrimaryContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypePrimaryContext extends PrimaryContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypePrimaryContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallPrimaryContext extends PrimaryContext {
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public MethodCallPrimaryContext(PrimaryContext ctx) { copyFrom(ctx); }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_primary);
		try {
			setState(457);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				_localctx = new LiteralPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(448);
				literal();
				}
				break;
			case 2:
				_localctx = new TuplePrimaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(449);
				tuple();
				}
				break;
			case 3:
				_localctx = new IdentifierPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(450);
				match(IDENTIFIER);
				}
				break;
			case 4:
				_localctx = new MethodCallPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(451);
				methodCall();
				}
				break;
			case 5:
				_localctx = new TableCallPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(452);
				tableCall();
				}
				break;
			case 6:
				_localctx = new BlockPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(453);
				block();
				}
				break;
			case 7:
				_localctx = new ListPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(454);
				list();
				}
				break;
			case 8:
				_localctx = new GenericTypePrimaryContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(455);
				genericType();
				}
				break;
			case 9:
				_localctx = new TypePrimaryContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(456);
				type();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleContext extends ParserRuleContext {
		public TerminalNode PARENTHESISOPEN() { return getToken(ArislParser.PARENTHESISOPEN, 0); }
		public TerminalNode PARENTHESISCLOSE() { return getToken(ArislParser.PARENTHESISCLOSE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ArislParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ArislParser.COMMA, i);
		}
		public TupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple; }
	}

	public final TupleContext tuple() throws RecognitionException {
		TupleContext _localctx = new TupleContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_tuple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			match(PARENTHESISOPEN);
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30287331328L) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 200119706189823L) != 0)) {
				{
				setState(460);
				expression(0);
				}
			}

			setState(467);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(463);
				match(COMMA);
				setState(464);
				expression(0);
				}
				}
				setState(469);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(470);
			match(PARENTHESISCLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	 
		public ArgumentsContext() { }
		public void copyFrom(ArgumentsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ArgumentsContext {
		public TerminalNode PARENTHESISOPEN() { return getToken(ArislParser.PARENTHESISOPEN, 0); }
		public TerminalNode PARENTHESISCLOSE() { return getToken(ArislParser.PARENTHESISCLOSE, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ArgsContext(ArgumentsContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarArgsContext extends ArgumentsContext {
		public TerminalNode PARENTHESISOPEN() { return getToken(ArislParser.PARENTHESISOPEN, 0); }
		public TerminalNode PARENTHESISCLOSE() { return getToken(ArislParser.PARENTHESISCLOSE, 0); }
		public VarArgsContext(ArgumentsContext ctx) { copyFrom(ctx); }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_arguments);
		int _la;
		try {
			setState(483);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				_localctx = new VarArgsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(472);
				match(PARENTHESISOPEN);
				setState(473);
				match(T__24);
				setState(474);
				match(PARENTHESISCLOSE);
				}
				break;
			case 2:
				_localctx = new ArgsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(475);
				match(PARENTHESISOPEN);
				setState(479);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__17 || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 54984171323391L) != 0)) {
					{
					{
					setState(476);
					param();
					}
					}
					setState(481);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(482);
				match(PARENTHESISCLOSE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ArislParser.IDENTIFIER, 0); }
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ArislParser.COMMA, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17 || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 4294967295L) != 0)) {
				{
				{
				setState(485);
				modifier();
				}
				}
				setState(490);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & 12289L) != 0)) {
				{
				setState(491);
				type();
				}
			}

			setState(494);
			match(IDENTIFIER);
			setState(496);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(495);
				match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrefixContext extends ParserRuleContext {
		public PrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix; }
	}

	public final PrefixContext prefix() throws RecognitionException {
		PrefixContext _localctx = new PrefixContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_prefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			_la = _input.LA(1);
			if ( !(_la==T__25 || _la==T__26) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOPContext extends ParserRuleContext {
		public UnaryOPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOP; }
	}

	public final UnaryOPContext unaryOP() throws RecognitionException {
		UnaryOPContext _localctx = new UnaryOPContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_unaryOP);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			_la = _input.LA(1);
			if ( !(_la==T__27 || _la==T__28) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ArislParser.IDENTIFIER, 0); }
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public GenericTypeContext genericType() {
			return getRuleContext(GenericTypeContext.class,0);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			match(IDENTIFIER);
			setState(504);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPETOKEN) {
				{
				setState(503);
				genericType();
				}
			}

			setState(506);
			tuple();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ArislParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TableCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableCall; }
	}

	public final TableCallContext tableCall() throws RecognitionException {
		TableCallContext _localctx = new TableCallContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_tableCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			match(IDENTIFIER);
			setState(509);
			match(T__29);
			setState(510);
			expression(0);
			setState(511);
			match(T__30);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ArislParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(ArislParser.STRING, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30064771072L) != 0) || _la==NUMBER || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BinaryOpContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(ArislParser.COMMA, 0); }
		public BinaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOp; }
	}

	public final BinaryOpContext binaryOp() throws RecognitionException {
		BinaryOpContext _localctx = new BinaryOpContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_binaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -34225520640L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 144115188075856127L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TryCatchStatementContext extends ParserRuleContext {
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(ArislParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ArislParser.IDENTIFIER, i);
		}
		public TryCatchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryCatchStatement; }
	}

	public final TryCatchStatementContext tryCatchStatement() throws RecognitionException {
		TryCatchStatementContext _localctx = new TryCatchStatementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_tryCatchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
			match(T__71);
			setState(518);
			block();
			setState(528);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__72) {
				{
				{
				setState(519);
				match(T__72);
				setState(523);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & 12289L) != 0)) {
					{
					setState(520);
					type();
					setState(521);
					match(IDENTIFIER);
					}
				}

				setState(525);
				block();
				}
				}
				setState(530);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(532);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__73) {
				{
				setState(531);
				match(T__73);
				}
			}

			setState(535);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				{
				setState(534);
				block();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<CaseBlockContext> caseBlock() {
			return getRuleContexts(CaseBlockContext.class);
		}
		public CaseBlockContext caseBlock(int i) {
			return getRuleContext(CaseBlockContext.class,i);
		}
		public DefaultBlockContext defaultBlock() {
			return getRuleContext(DefaultBlockContext.class,0);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_switchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			match(T__74);
			setState(538);
			expression(0);
			setState(539);
			match(T__21);
			setState(543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__75) {
				{
				{
				setState(540);
				caseBlock();
				}
				}
				setState(545);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(547);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__76) {
				{
				setState(546);
				defaultBlock();
				}
			}

			setState(549);
			match(T__22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseBlockContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CaseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseBlock; }
	}

	public final CaseBlockContext caseBlock() throws RecognitionException {
		CaseBlockContext _localctx = new CaseBlockContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_caseBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			match(T__75);
			setState(552);
			expression(0);
			setState(553);
			match(T__6);
			setState(557);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30290190174L) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & 12930806498459593L) != 0)) {
				{
				{
				setState(554);
				statement();
				}
				}
				setState(559);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultBlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public DefaultBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultBlock; }
	}

	public final DefaultBlockContext defaultBlock() throws RecognitionException {
		DefaultBlockContext _localctx = new DefaultBlockContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_defaultBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			match(T__76);
			setState(561);
			match(T__6);
			setState(565);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30290190174L) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & 12930806498459593L) != 0)) {
				{
				{
				setState(562);
				statement();
				}
				}
				setState(567);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModifierContext extends ParserRuleContext {
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			_la = _input.LA(1);
			if ( !(_la==T__17 || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 4294967295L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VisibilityContext extends ParserRuleContext {
		public TerminalNode PRIVATE() { return getToken(ArislParser.PRIVATE, 0); }
		public TerminalNode PUBLIC() { return getToken(ArislParser.PUBLIC, 0); }
		public TerminalNode GLOBAL() { return getToken(ArislParser.GLOBAL, 0); }
		public VisibilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_visibility; }
	}

	public final VisibilityContext visibility() throws RecognitionException {
		VisibilityContext _localctx = new VisibilityContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_visibility);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			_la = _input.LA(1);
			if ( !(((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & 7L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public GenericTypeContext genericType() {
			return getRuleContext(GenericTypeContext.class,0);
		}
		public TupleTypeContext tupleType() {
			return getRuleContext(TupleTypeContext.class,0);
		}
		public NestedTypeContext nestedType() {
			return getRuleContext(NestedTypeContext.class,0);
		}
		public CastTypeContext castType() {
			return getRuleContext(CastTypeContext.class,0);
		}
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_type);
		try {
			setState(578);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(572);
				simpleType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(573);
				genericType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(574);
				tupleType();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(575);
				nestedType();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(576);
				castType();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(577);
				varType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarTypeContext extends ParserRuleContext {
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_varType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(580);
			match(T__109);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleTypeContext extends ParserRuleContext {
		public TerminalNode TYPETOKEN() { return getToken(ArislParser.TYPETOKEN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ArislParser.IDENTIFIER, 0); }
		public SimpleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleType; }
	}

	public final SimpleTypeContext simpleType() throws RecognitionException {
		SimpleTypeContext _localctx = new SimpleTypeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_simpleType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
			match(TYPETOKEN);
			setState(583);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleTypeContext extends ParserRuleContext {
		public TerminalNode TYPETOKEN() { return getToken(ArislParser.TYPETOKEN, 0); }
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public TupleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleType; }
	}

	public final TupleTypeContext tupleType() throws RecognitionException {
		TupleTypeContext _localctx = new TupleTypeContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_tupleType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585);
			match(TYPETOKEN);
			setState(586);
			tuple();
			setState(587);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GenericTypeContext extends ParserRuleContext {
		public TerminalNode TYPETOKEN() { return getToken(ArislParser.TYPETOKEN, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(ArislParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ArislParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ArislParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ArislParser.COMMA, i);
		}
		public GenericTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericType; }
	}

	public final GenericTypeContext genericType() throws RecognitionException {
		GenericTypeContext _localctx = new GenericTypeContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_genericType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			match(TYPETOKEN);
			setState(590);
			match(IDENTIFIER);
			setState(595);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(591);
				match(COMMA);
				setState(592);
				match(IDENTIFIER);
				}
				}
				setState(597);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(598);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NestedTypeContext extends ParserRuleContext {
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public GenericTypeContext genericType() {
			return getRuleContext(GenericTypeContext.class,0);
		}
		public NestedTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nestedType; }
	}

	public final NestedTypeContext nestedType() throws RecognitionException {
		NestedTypeContext _localctx = new NestedTypeContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_nestedType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			simpleType();
			setState(601);
			genericType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CastTypeContext extends ParserRuleContext {
		public TerminalNode PARENTHESISOPEN() { return getToken(ArislParser.PARENTHESISOPEN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode PARENTHESISCLOSE() { return getToken(ArislParser.PARENTHESISCLOSE, 0); }
		public CastTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castType; }
	}

	public final CastTypeContext castType() throws RecognitionException {
		CastTypeContext _localctx = new CastTypeContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_castType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			match(PARENTHESISOPEN);
			setState(604);
			type();
			setState(605);
			match(PARENTHESISCLOSE);
			setState(606);
			match(T__110);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EndContext extends ParserRuleContext {
		public EndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end; }
	}

	public final EndContext end() throws RecognitionException {
		EndContext _localctx = new EndContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_end);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			_la = _input.LA(1);
			if ( !(((((_la - 112)) & ~0x3f) == 0 && ((1L << (_la - 112)) & 15L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 24:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0080\u0263\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u0001\u0000"+
		"\u0005\u0000d\b\u0000\n\u0000\f\u0000g\t\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001{\b\u0001"+
		"\u0001\u0002\u0003\u0002~\b\u0002\u0001\u0002\u0005\u0002\u0081\b\u0002"+
		"\n\u0002\f\u0002\u0084\t\u0002\u0001\u0002\u0003\u0002\u0087\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002\u008b\b\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002\u008f\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0003\u0003\u0094"+
		"\b\u0003\u0001\u0003\u0005\u0003\u0097\b\u0003\n\u0003\f\u0003\u009a\t"+
		"\u0003\u0001\u0003\u0003\u0003\u009d\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003\u00a2\b\u0003\u0001\u0003\u0003\u0003\u00a5\b\u0003"+
		"\u0001\u0003\u0003\u0003\u00a8\b\u0003\u0001\u0004\u0003\u0004\u00ab\b"+
		"\u0004\u0001\u0004\u0005\u0004\u00ae\b\u0004\n\u0004\f\u0004\u00b1\t\u0004"+
		"\u0001\u0004\u0003\u0004\u00b4\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u00b9\b\u0004\u0001\u0004\u0003\u0004\u00bc\b\u0004\u0001"+
		"\u0004\u0003\u0004\u00bf\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0003\u0006\u00c7\b\u0006\u0001\u0006\u0005"+
		"\u0006\u00ca\b\u0006\n\u0006\f\u0006\u00cd\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u00d3\b\u0006\u0001\u0006\u0003\u0006"+
		"\u00d6\b\u0006\u0001\u0006\u0003\u0006\u00d9\b\u0006\u0001\u0007\u0003"+
		"\u0007\u00dc\b\u0007\u0001\u0007\u0005\u0007\u00df\b\u0007\n\u0007\f\u0007"+
		"\u00e2\t\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00e6\b\u0007\u0001"+
		"\u0007\u0003\u0007\u00e9\b\u0007\u0001\u0007\u0003\u0007\u00ec\b\u0007"+
		"\u0001\b\u0003\b\u00ef\b\b\u0001\b\u0005\b\u00f2\b\b\n\b\f\b\u00f5\t\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00fb\b\b\u0001\t\u0003\t\u00fe"+
		"\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0104\b\t\u0001\n\u0003\n"+
		"\u0107\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0114"+
		"\b\u000b\n\u000b\f\u000b\u0117\t\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u011b\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0003\r"+
		"\u0123\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0003\u000e\u012f\b\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u0138\b\u000f\u0001\u000f\u0004\u000f\u013b\b\u000f\u000b\u000f"+
		"\f\u000f\u013c\u0001\u0010\u0003\u0010\u0140\b\u0010\u0001\u0010\u0005"+
		"\u0010\u0143\b\u0010\n\u0010\f\u0010\u0146\t\u0010\u0001\u0010\u0003\u0010"+
		"\u0149\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u014e\b"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0003\u0011\u0154"+
		"\b\u0011\u0001\u0011\u0005\u0011\u0157\b\u0011\n\u0011\f\u0011\u015a\t"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u015f\b\u0011\u0001"+
		"\u0011\u0003\u0011\u0162\b\u0011\u0001\u0011\u0004\u0011\u0165\b\u0011"+
		"\u000b\u0011\f\u0011\u0166\u0001\u0012\u0001\u0012\u0005\u0012\u016b\b"+
		"\u0012\n\u0012\f\u0012\u016e\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0003\u0014\u0175\b\u0014\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u0179\b\u0014\u0001\u0014\u0004\u0014\u017c\b\u0014\u000b"+
		"\u0014\f\u0014\u017d\u0001\u0015\u0001\u0015\u0005\u0015\u0182\b\u0015"+
		"\n\u0015\f\u0015\u0185\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0003\u0017\u018e\b\u0017\u0001"+
		"\u0017\u0001\u0017\u0004\u0017\u0192\b\u0017\u000b\u0017\f\u0017\u0193"+
		"\u0001\u0018\u0001\u0018\u0005\u0018\u0198\b\u0018\n\u0018\f\u0018\u019b"+
		"\t\u0018\u0001\u0018\u0003\u0018\u019e\b\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0004\u0018\u01a6\b\u0018"+
		"\u000b\u0018\f\u0018\u01a7\u0001\u0018\u0001\u0018\u0003\u0018\u01ac\b"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0004\u0018\u01b2"+
		"\b\u0018\u000b\u0018\f\u0018\u01b3\u0001\u0018\u0001\u0018\u0004\u0018"+
		"\u01b8\b\u0018\u000b\u0018\f\u0018\u01b9\u0005\u0018\u01bc\b\u0018\n\u0018"+
		"\f\u0018\u01bf\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019"+
		"\u01ca\b\u0019\u0001\u001a\u0001\u001a\u0003\u001a\u01ce\b\u001a\u0001"+
		"\u001a\u0001\u001a\u0005\u001a\u01d2\b\u001a\n\u001a\f\u001a\u01d5\t\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0005\u001b\u01de\b\u001b\n\u001b\f\u001b\u01e1\t\u001b\u0001"+
		"\u001b\u0003\u001b\u01e4\b\u001b\u0001\u001c\u0005\u001c\u01e7\b\u001c"+
		"\n\u001c\f\u001c\u01ea\t\u001c\u0001\u001c\u0003\u001c\u01ed\b\u001c\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u01f1\b\u001c\u0001\u001d\u0001\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0003\u001f\u01f9\b\u001f\u0001"+
		"\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003#\u020c\b#\u0001"+
		"#\u0005#\u020f\b#\n#\f#\u0212\t#\u0001#\u0003#\u0215\b#\u0001#\u0003#"+
		"\u0218\b#\u0001$\u0001$\u0001$\u0001$\u0005$\u021e\b$\n$\f$\u0221\t$\u0001"+
		"$\u0003$\u0224\b$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0005%\u022c"+
		"\b%\n%\f%\u022f\t%\u0001&\u0001&\u0001&\u0005&\u0234\b&\n&\f&\u0237\t"+
		"&\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0003)\u0243\b)\u0001*\u0001*\u0001+\u0001+\u0001+\u0001,\u0001,\u0001"+
		",\u0001,\u0001-\u0001-\u0001-\u0001-\u0005-\u0252\b-\n-\f-\u0255\t-\u0001"+
		"-\u0001-\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"0\u00010\u00010\u0000\u000101\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPR"+
		"TVXZ\\^`\u0000\u0007\u0001\u0000\u001a\u001b\u0001\u0000\u001c\u001d\u0003"+
		"\u0000 \"xx}}\u0003\u0000\u001b\u001b#Gyy\u0002\u0000\u0012\u0012Nm\u0001"+
		"\u0000tv\u0001\u0000ps\u02a1\u0000e\u0001\u0000\u0000\u0000\u0002z\u0001"+
		"\u0000\u0000\u0000\u0004}\u0001\u0000\u0000\u0000\u0006\u0093\u0001\u0000"+
		"\u0000\u0000\b\u00aa\u0001\u0000\u0000\u0000\n\u00c0\u0001\u0000\u0000"+
		"\u0000\f\u00c6\u0001\u0000\u0000\u0000\u000e\u00db\u0001\u0000\u0000\u0000"+
		"\u0010\u00ee\u0001\u0000\u0000\u0000\u0012\u00fd\u0001\u0000\u0000\u0000"+
		"\u0014\u0106\u0001\u0000\u0000\u0000\u0016\u010c\u0001\u0000\u0000\u0000"+
		"\u0018\u011c\u0001\u0000\u0000\u0000\u001a\u0120\u0001\u0000\u0000\u0000"+
		"\u001c\u012c\u0001\u0000\u0000\u0000\u001e\u0135\u0001\u0000\u0000\u0000"+
		" \u013f\u0001\u0000\u0000\u0000\"\u0151\u0001\u0000\u0000\u0000$\u0168"+
		"\u0001\u0000\u0000\u0000&\u0171\u0001\u0000\u0000\u0000(\u0174\u0001\u0000"+
		"\u0000\u0000*\u017f\u0001\u0000\u0000\u0000,\u0188\u0001\u0000\u0000\u0000"+
		".\u018d\u0001\u0000\u0000\u00000\u01ab\u0001\u0000\u0000\u00002\u01c9"+
		"\u0001\u0000\u0000\u00004\u01cb\u0001\u0000\u0000\u00006\u01e3\u0001\u0000"+
		"\u0000\u00008\u01e8\u0001\u0000\u0000\u0000:\u01f2\u0001\u0000\u0000\u0000"+
		"<\u01f4\u0001\u0000\u0000\u0000>\u01f6\u0001\u0000\u0000\u0000@\u01fc"+
		"\u0001\u0000\u0000\u0000B\u0201\u0001\u0000\u0000\u0000D\u0203\u0001\u0000"+
		"\u0000\u0000F\u0205\u0001\u0000\u0000\u0000H\u0219\u0001\u0000\u0000\u0000"+
		"J\u0227\u0001\u0000\u0000\u0000L\u0230\u0001\u0000\u0000\u0000N\u0238"+
		"\u0001\u0000\u0000\u0000P\u023a\u0001\u0000\u0000\u0000R\u0242\u0001\u0000"+
		"\u0000\u0000T\u0244\u0001\u0000\u0000\u0000V\u0246\u0001\u0000\u0000\u0000"+
		"X\u0249\u0001\u0000\u0000\u0000Z\u024d\u0001\u0000\u0000\u0000\\\u0258"+
		"\u0001\u0000\u0000\u0000^\u025b\u0001\u0000\u0000\u0000`\u0260\u0001\u0000"+
		"\u0000\u0000bd\u0003\u0002\u0001\u0000cb\u0001\u0000\u0000\u0000dg\u0001"+
		"\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000"+
		"f\u0001\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000h{\u0003\b\u0004"+
		"\u0000i{\u0003\u0004\u0002\u0000j{\u0003\u000e\u0007\u0000k{\u0003\f\u0006"+
		"\u0000l{\u0003\u0010\b\u0000m{\u0003\u0006\u0003\u0000n{\u0003\u0012\t"+
		"\u0000o{\u0003\u0014\n\u0000p{\u0003\u0016\u000b\u0000q{\u0003\u0018\f"+
		"\u0000r{\u0003\u001a\r\u0000s{\u0003\u001c\u000e\u0000t{\u0003\u001e\u000f"+
		"\u0000u{\u0003\"\u0011\u0000v{\u0003F#\u0000w{\u0003\n\u0005\u0000x{\u0003"+
		"H$\u0000y{\u0003.\u0017\u0000zh\u0001\u0000\u0000\u0000zi\u0001\u0000"+
		"\u0000\u0000zj\u0001\u0000\u0000\u0000zk\u0001\u0000\u0000\u0000zl\u0001"+
		"\u0000\u0000\u0000zm\u0001\u0000\u0000\u0000zn\u0001\u0000\u0000\u0000"+
		"zo\u0001\u0000\u0000\u0000zp\u0001\u0000\u0000\u0000zq\u0001\u0000\u0000"+
		"\u0000zr\u0001\u0000\u0000\u0000zs\u0001\u0000\u0000\u0000zt\u0001\u0000"+
		"\u0000\u0000zu\u0001\u0000\u0000\u0000zv\u0001\u0000\u0000\u0000zw\u0001"+
		"\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000zy\u0001\u0000\u0000\u0000"+
		"{\u0003\u0001\u0000\u0000\u0000|~\u0003P(\u0000}|\u0001\u0000\u0000\u0000"+
		"}~\u0001\u0000\u0000\u0000~\u0082\u0001\u0000\u0000\u0000\u007f\u0081"+
		"\u0003N\'\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0084\u0001"+
		"\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001"+
		"\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0082\u0001"+
		"\u0000\u0000\u0000\u0085\u0087\u0003R)\u0000\u0086\u0085\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000"+
		"\u0000\u0088\u008a\u0005\u0001\u0000\u0000\u0089\u008b\u0003Z-\u0000\u008a"+
		"\u0089\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0001\u0000\u0000\u0000\u008c\u008e\u0005w\u0000\u0000\u008d\u008f"+
		"\u00036\u001b\u0000\u008e\u008d\u0001\u0000\u0000\u0000\u008e\u008f\u0001"+
		"\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0003"+
		"`0\u0000\u0091\u0005\u0001\u0000\u0000\u0000\u0092\u0094\u0003P(\u0000"+
		"\u0093\u0092\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000"+
		"\u0094\u0098\u0001\u0000\u0000\u0000\u0095\u0097\u0003N\'\u0000\u0096"+
		"\u0095\u0001\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000\u0098"+
		"\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099"+
		"\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009b"+
		"\u009d\u0003R)\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009c\u009d\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f\u0005"+
		"\u0002\u0000\u0000\u009f\u00a1\u0005w\u0000\u0000\u00a0\u00a2\u00036\u001b"+
		"\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000\u00a3\u00a5\u0003*\u0015\u0000"+
		"\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a7\u0001\u0000\u0000\u0000\u00a6\u00a8\u0003`0\u0000\u00a7\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u0007"+
		"\u0001\u0000\u0000\u0000\u00a9\u00ab\u0003P(\u0000\u00aa\u00a9\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00af\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ae\u0003N\'\u0000\u00ad\u00ac\u0001\u0000\u0000"+
		"\u0000\u00ae\u00b1\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b2\u00b4\u0003R)\u0000\u00b3"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005\u0003\u0000\u0000\u00b6"+
		"\u00b8\u0005w\u0000\u0000\u00b7\u00b9\u0003Z-\u0000\u00b8\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00bb\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bc\u00036\u001b\u0000\u00bb\u00ba\u0001\u0000"+
		"\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u00be\u0001\u0000"+
		"\u0000\u0000\u00bd\u00bf\u0003*\u0015\u0000\u00be\u00bd\u0001\u0000\u0000"+
		"\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\t\u0001\u0000\u0000\u0000"+
		"\u00c0\u00c1\u0005\u0004\u0000\u0000\u00c1\u00c2\u0003*\u0015\u0000\u00c2"+
		"\u00c3\u0005\u0005\u0000\u0000\u00c3\u00c4\u00030\u0018\u0000\u00c4\u000b"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c7\u0003P(\u0000\u00c6\u00c5\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00cb\u0001\u0000"+
		"\u0000\u0000\u00c8\u00ca\u0003N\'\u0000\u00c9\u00c8\u0001\u0000\u0000"+
		"\u0000\u00ca\u00cd\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000"+
		"\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00ce\u0001\u0000\u0000"+
		"\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005\u0006\u0000"+
		"\u0000\u00cf\u00d2\u0005w\u0000\u0000\u00d0\u00d1\u0005\u0007\u0000\u0000"+
		"\u00d1\u00d3\u0003R)\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d3\u00d5\u0001\u0000\u0000\u0000\u00d4\u00d6"+
		"\u0003*\u0015\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d8\u0001\u0000\u0000\u0000\u00d7\u00d9\u0003"+
		"`0\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000"+
		"\u0000\u00d9\r\u0001\u0000\u0000\u0000\u00da\u00dc\u0003P(\u0000\u00db"+
		"\u00da\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc"+
		"\u00e0\u0001\u0000\u0000\u0000\u00dd\u00df\u0003N\'\u0000\u00de\u00dd"+
		"\u0001\u0000\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000\u00e0\u00de"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e3\u00e5"+
		"\u0005\b\u0000\u0000\u00e4\u00e6\u00036\u001b\u0000\u00e5\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e8\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e9\u0003*\u0015\u0000\u00e8\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00eb\u0001\u0000"+
		"\u0000\u0000\u00ea\u00ec\u0003`0\u0000\u00eb\u00ea\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u000f\u0001\u0000\u0000\u0000"+
		"\u00ed\u00ef\u0003P(\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000\u00ee\u00ef"+
		"\u0001\u0000\u0000\u0000\u00ef\u00f3\u0001\u0000\u0000\u0000\u00f0\u00f2"+
		"\u0003N\'\u0000\u00f1\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f6\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f7\u0005\t\u0000\u0000\u00f7\u00f8\u0005w"+
		"\u0000\u0000\u00f8\u00fa\u0003*\u0015\u0000\u00f9\u00fb\u0003`0\u0000"+
		"\u00fa\u00f9\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000"+
		"\u00fb\u0011\u0001\u0000\u0000\u0000\u00fc\u00fe\u0003P(\u0000\u00fd\u00fc"+
		"\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe\u00ff"+
		"\u0001\u0000\u0000\u0000\u00ff\u0100\u0005\n\u0000\u0000\u0100\u0101\u0005"+
		"w\u0000\u0000\u0101\u0103\u0003,\u0016\u0000\u0102\u0104\u0003`0\u0000"+
		"\u0103\u0102\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000"+
		"\u0104\u0013\u0001\u0000\u0000\u0000\u0105\u0107\u0003P(\u0000\u0106\u0105"+
		"\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u0108"+
		"\u0001\u0000\u0000\u0000\u0108\u0109\u0005\u000b\u0000\u0000\u0109\u010a"+
		"\u0005w\u0000\u0000\u010a\u010b\u0003$\u0012\u0000\u010b\u0015\u0001\u0000"+
		"\u0000\u0000\u010c\u010d\u0005\f\u0000\u0000\u010d\u010e\u00030\u0018"+
		"\u0000\u010e\u0115\u0003*\u0015\u0000\u010f\u0110\u0005\r\u0000\u0000"+
		"\u0110\u0111\u00030\u0018\u0000\u0111\u0112\u0003*\u0015\u0000\u0112\u0114"+
		"\u0001\u0000\u0000\u0000\u0113\u010f\u0001\u0000\u0000\u0000\u0114\u0117"+
		"\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0116"+
		"\u0001\u0000\u0000\u0000\u0116\u011a\u0001\u0000\u0000\u0000\u0117\u0115"+
		"\u0001\u0000\u0000\u0000\u0118\u0119\u0005\u000e\u0000\u0000\u0119\u011b"+
		"\u0003*\u0015\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011a\u011b\u0001"+
		"\u0000\u0000\u0000\u011b\u0017\u0001\u0000\u0000\u0000\u011c\u011d\u0005"+
		"\u000f\u0000\u0000\u011d\u011e\u00030\u0018\u0000\u011e\u011f\u0003*\u0015"+
		"\u0000\u011f\u0019\u0001\u0000\u0000\u0000\u0120\u0122\u0005\u0010\u0000"+
		"\u0000\u0121\u0123\u0003R)\u0000\u0122\u0121\u0001\u0000\u0000\u0000\u0122"+
		"\u0123\u0001\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000\u0124"+
		"\u0125\u00030\u0018\u0000\u0125\u0126\u0003`0\u0000\u0126\u0127\u0003"+
		"0\u0018\u0000\u0127\u0128\u0003`0\u0000\u0128\u0129\u00030\u0018\u0000"+
		"\u0129\u012a\u0003`0\u0000\u012a\u012b\u0003*\u0015\u0000\u012b\u001b"+
		"\u0001\u0000\u0000\u0000\u012c\u012e\u0005\u0011\u0000\u0000\u012d\u012f"+
		"\u0003R)\u0000\u012e\u012d\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000"+
		"\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u0131\u0005w\u0000"+
		"\u0000\u0131\u0132\u0005\u0012\u0000\u0000\u0132\u0133\u00030\u0018\u0000"+
		"\u0133\u0134\u0003*\u0015\u0000\u0134\u001d\u0001\u0000\u0000\u0000\u0135"+
		"\u0137\u0005\u0013\u0000\u0000\u0136\u0138\u00030\u0018\u0000\u0137\u0136"+
		"\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u013a"+
		"\u0001\u0000\u0000\u0000\u0139\u013b\u0003`0\u0000\u013a\u0139\u0001\u0000"+
		"\u0000\u0000\u013b\u013c\u0001\u0000\u0000\u0000\u013c\u013a\u0001\u0000"+
		"\u0000\u0000\u013c\u013d\u0001\u0000\u0000\u0000\u013d\u001f\u0001\u0000"+
		"\u0000\u0000\u013e\u0140\u0003P(\u0000\u013f\u013e\u0001\u0000\u0000\u0000"+
		"\u013f\u0140\u0001\u0000\u0000\u0000\u0140\u0144\u0001\u0000\u0000\u0000"+
		"\u0141\u0143\u0003N\'\u0000\u0142\u0141\u0001\u0000\u0000\u0000\u0143"+
		"\u0146\u0001\u0000\u0000\u0000\u0144\u0142\u0001\u0000\u0000\u0000\u0144"+
		"\u0145\u0001\u0000\u0000\u0000\u0145\u0148\u0001\u0000\u0000\u0000\u0146"+
		"\u0144\u0001\u0000\u0000\u0000\u0147\u0149\u0003R)\u0000\u0148\u0147\u0001"+
		"\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u014a\u0001"+
		"\u0000\u0000\u0000\u014a\u014b\u0005\u0014\u0000\u0000\u014b\u014d\u0003"+
		"D\"\u0000\u014c\u014e\u00036\u001b\u0000\u014d\u014c\u0001\u0000\u0000"+
		"\u0000\u014d\u014e\u0001\u0000\u0000\u0000\u014e\u014f\u0001\u0000\u0000"+
		"\u0000\u014f\u0150\u0003*\u0015\u0000\u0150!\u0001\u0000\u0000\u0000\u0151"+
		"\u0153\u0005\u0015\u0000\u0000\u0152\u0154\u0003P(\u0000\u0153\u0152\u0001"+
		"\u0000\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0158\u0001"+
		"\u0000\u0000\u0000\u0155\u0157\u0003N\'\u0000\u0156\u0155\u0001\u0000"+
		"\u0000\u0000\u0157\u015a\u0001\u0000\u0000\u0000\u0158\u0156\u0001\u0000"+
		"\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000\u0159\u015b\u0001\u0000"+
		"\u0000\u0000\u015a\u0158\u0001\u0000\u0000\u0000\u015b\u015c\u0003R)\u0000"+
		"\u015c\u015e\u0005w\u0000\u0000\u015d\u015f\u00034\u001a\u0000\u015e\u015d"+
		"\u0001\u0000\u0000\u0000\u015e\u015f\u0001\u0000\u0000\u0000\u015f\u0161"+
		"\u0001\u0000\u0000\u0000\u0160\u0162\u0003,\u0016\u0000\u0161\u0160\u0001"+
		"\u0000\u0000\u0000\u0161\u0162\u0001\u0000\u0000\u0000\u0162\u0164\u0001"+
		"\u0000\u0000\u0000\u0163\u0165\u0003`0\u0000\u0164\u0163\u0001\u0000\u0000"+
		"\u0000\u0165\u0166\u0001\u0000\u0000\u0000\u0166\u0164\u0001\u0000\u0000"+
		"\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167#\u0001\u0000\u0000\u0000"+
		"\u0168\u016c\u0005\u0016\u0000\u0000\u0169\u016b\u0003&\u0013\u0000\u016a"+
		"\u0169\u0001\u0000\u0000\u0000\u016b\u016e\u0001\u0000\u0000\u0000\u016c"+
		"\u016a\u0001\u0000\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d"+
		"\u016f\u0001\u0000\u0000\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016f"+
		"\u0170\u0005\u0017\u0000\u0000\u0170%\u0001\u0000\u0000\u0000\u0171\u0172"+
		"\u0003(\u0014\u0000\u0172\'\u0001\u0000\u0000\u0000\u0173\u0175\u0003"+
		"R)\u0000\u0174\u0173\u0001\u0000\u0000\u0000\u0174\u0175\u0001\u0000\u0000"+
		"\u0000\u0175\u0176\u0001\u0000\u0000\u0000\u0176\u0178\u0005w\u0000\u0000"+
		"\u0177\u0179\u00036\u001b\u0000\u0178\u0177\u0001\u0000\u0000\u0000\u0178"+
		"\u0179\u0001\u0000\u0000\u0000\u0179\u017b\u0001\u0000\u0000\u0000\u017a"+
		"\u017c\u0003`0\u0000\u017b\u017a\u0001\u0000\u0000\u0000\u017c\u017d\u0001"+
		"\u0000\u0000\u0000\u017d\u017b\u0001\u0000\u0000\u0000\u017d\u017e\u0001"+
		"\u0000\u0000\u0000\u017e)\u0001\u0000\u0000\u0000\u017f\u0183\u0005\u0016"+
		"\u0000\u0000\u0180\u0182\u0003\u0002\u0001\u0000\u0181\u0180\u0001\u0000"+
		"\u0000\u0000\u0182\u0185\u0001\u0000\u0000\u0000\u0183\u0181\u0001\u0000"+
		"\u0000\u0000\u0183\u0184\u0001\u0000\u0000\u0000\u0184\u0186\u0001\u0000"+
		"\u0000\u0000\u0185\u0183\u0001\u0000\u0000\u0000\u0186\u0187\u0005\u0017"+
		"\u0000\u0000\u0187+\u0001\u0000\u0000\u0000\u0188\u0189\u0005\u0018\u0000"+
		"\u0000\u0189\u018a\u00030\u0018\u0000\u018a\u018b\u0005\u0018\u0000\u0000"+
		"\u018b-\u0001\u0000\u0000\u0000\u018c\u018e\u0003P(\u0000\u018d\u018c"+
		"\u0001\u0000\u0000\u0000\u018d\u018e\u0001\u0000\u0000\u0000\u018e\u018f"+
		"\u0001\u0000\u0000\u0000\u018f\u0191\u00030\u0018\u0000\u0190\u0192\u0003"+
		"`0\u0000\u0191\u0190\u0001\u0000\u0000\u0000\u0192\u0193\u0001\u0000\u0000"+
		"\u0000\u0193\u0191\u0001\u0000\u0000\u0000\u0193\u0194\u0001\u0000\u0000"+
		"\u0000\u0194/\u0001\u0000\u0000\u0000\u0195\u0199\u0006\u0018\uffff\uffff"+
		"\u0000\u0196\u0198\u0003N\'\u0000\u0197\u0196\u0001\u0000\u0000\u0000"+
		"\u0198\u019b\u0001\u0000\u0000\u0000\u0199\u0197\u0001\u0000\u0000\u0000"+
		"\u0199\u019a\u0001\u0000\u0000\u0000\u019a\u019d\u0001\u0000\u0000\u0000"+
		"\u019b\u0199\u0001\u0000\u0000\u0000\u019c\u019e\u0003R)\u0000\u019d\u019c"+
		"\u0001\u0000\u0000\u0000\u019d\u019e\u0001\u0000\u0000\u0000\u019e\u019f"+
		"\u0001\u0000\u0000\u0000\u019f\u01ac\u00032\u0019\u0000\u01a0\u01a1\u0005"+
		"{\u0000\u0000\u01a1\u01a2\u00030\u0018\u0000\u01a2\u01a3\u0005|\u0000"+
		"\u0000\u01a3\u01ac\u0001\u0000\u0000\u0000\u01a4\u01a6\u0003:\u001d\u0000"+
		"\u01a5\u01a4\u0001\u0000\u0000\u0000\u01a6\u01a7\u0001\u0000\u0000\u0000"+
		"\u01a7\u01a5\u0001\u0000\u0000\u0000\u01a7\u01a8\u0001\u0000\u0000\u0000"+
		"\u01a8\u01a9\u0001\u0000\u0000\u0000\u01a9\u01aa\u00030\u0018\u0001\u01aa"+
		"\u01ac\u0001\u0000\u0000\u0000\u01ab\u0195\u0001\u0000\u0000\u0000\u01ab"+
		"\u01a0\u0001\u0000\u0000\u0000\u01ab\u01a5\u0001\u0000\u0000\u0000\u01ac"+
		"\u01bd\u0001\u0000\u0000\u0000\u01ad\u01b1\n\u0004\u0000\u0000\u01ae\u01af"+
		"\u0003D\"\u0000\u01af\u01b0\u00030\u0018\u0000\u01b0\u01b2\u0001\u0000"+
		"\u0000\u0000\u01b1\u01ae\u0001\u0000\u0000\u0000\u01b2\u01b3\u0001\u0000"+
		"\u0000\u0000\u01b3\u01b1\u0001\u0000\u0000\u0000\u01b3\u01b4\u0001\u0000"+
		"\u0000\u0000\u01b4\u01bc\u0001\u0000\u0000\u0000\u01b5\u01b7\n\u0002\u0000"+
		"\u0000\u01b6\u01b8\u0003<\u001e\u0000\u01b7\u01b6\u0001\u0000\u0000\u0000"+
		"\u01b8\u01b9\u0001\u0000\u0000\u0000\u01b9\u01b7\u0001\u0000\u0000\u0000"+
		"\u01b9\u01ba\u0001\u0000\u0000\u0000\u01ba\u01bc\u0001\u0000\u0000\u0000"+
		"\u01bb\u01ad\u0001\u0000\u0000\u0000\u01bb\u01b5\u0001\u0000\u0000\u0000"+
		"\u01bc\u01bf\u0001\u0000\u0000\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000"+
		"\u01bd\u01be\u0001\u0000\u0000\u0000\u01be1\u0001\u0000\u0000\u0000\u01bf"+
		"\u01bd\u0001\u0000\u0000\u0000\u01c0\u01ca\u0003B!\u0000\u01c1\u01ca\u0003"+
		"4\u001a\u0000\u01c2\u01ca\u0005w\u0000\u0000\u01c3\u01ca\u0003>\u001f"+
		"\u0000\u01c4\u01ca\u0003@ \u0000\u01c5\u01ca\u0003*\u0015\u0000\u01c6"+
		"\u01ca\u0003,\u0016\u0000\u01c7\u01ca\u0003Z-\u0000\u01c8\u01ca\u0003"+
		"R)\u0000\u01c9\u01c0\u0001\u0000\u0000\u0000\u01c9\u01c1\u0001\u0000\u0000"+
		"\u0000\u01c9\u01c2\u0001\u0000\u0000\u0000\u01c9\u01c3\u0001\u0000\u0000"+
		"\u0000\u01c9\u01c4\u0001\u0000\u0000\u0000\u01c9\u01c5\u0001\u0000\u0000"+
		"\u0000\u01c9\u01c6\u0001\u0000\u0000\u0000\u01c9\u01c7\u0001\u0000\u0000"+
		"\u0000\u01c9\u01c8\u0001\u0000\u0000\u0000\u01ca3\u0001\u0000\u0000\u0000"+
		"\u01cb\u01cd\u0005{\u0000\u0000\u01cc\u01ce\u00030\u0018\u0000\u01cd\u01cc"+
		"\u0001\u0000\u0000\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000\u01ce\u01d3"+
		"\u0001\u0000\u0000\u0000\u01cf\u01d0\u0005y\u0000\u0000\u01d0\u01d2\u0003"+
		"0\u0018\u0000\u01d1\u01cf\u0001\u0000\u0000\u0000\u01d2\u01d5\u0001\u0000"+
		"\u0000\u0000\u01d3\u01d1\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000"+
		"\u0000\u0000\u01d4\u01d6\u0001\u0000\u0000\u0000\u01d5\u01d3\u0001\u0000"+
		"\u0000\u0000\u01d6\u01d7\u0005|\u0000\u0000\u01d75\u0001\u0000\u0000\u0000"+
		"\u01d8\u01d9\u0005{\u0000\u0000\u01d9\u01da\u0005\u0019\u0000\u0000\u01da"+
		"\u01e4\u0005|\u0000\u0000\u01db\u01df\u0005{\u0000\u0000\u01dc\u01de\u0003"+
		"8\u001c\u0000\u01dd\u01dc\u0001\u0000\u0000\u0000\u01de\u01e1\u0001\u0000"+
		"\u0000\u0000\u01df\u01dd\u0001\u0000\u0000\u0000\u01df\u01e0\u0001\u0000"+
		"\u0000\u0000\u01e0\u01e2\u0001\u0000\u0000\u0000\u01e1\u01df\u0001\u0000"+
		"\u0000\u0000\u01e2\u01e4\u0005|\u0000\u0000\u01e3\u01d8\u0001\u0000\u0000"+
		"\u0000\u01e3\u01db\u0001\u0000\u0000\u0000\u01e47\u0001\u0000\u0000\u0000"+
		"\u01e5\u01e7\u0003N\'\u0000\u01e6\u01e5\u0001\u0000\u0000\u0000\u01e7"+
		"\u01ea\u0001\u0000\u0000\u0000\u01e8\u01e6\u0001\u0000\u0000\u0000\u01e8"+
		"\u01e9\u0001\u0000\u0000\u0000\u01e9\u01ec\u0001\u0000\u0000\u0000\u01ea"+
		"\u01e8\u0001\u0000\u0000\u0000\u01eb\u01ed\u0003R)\u0000\u01ec\u01eb\u0001"+
		"\u0000\u0000\u0000\u01ec\u01ed\u0001\u0000\u0000\u0000\u01ed\u01ee\u0001"+
		"\u0000\u0000\u0000\u01ee\u01f0\u0005w\u0000\u0000\u01ef\u01f1\u0005y\u0000"+
		"\u0000\u01f0\u01ef\u0001\u0000\u0000\u0000\u01f0\u01f1\u0001\u0000\u0000"+
		"\u0000\u01f19\u0001\u0000\u0000\u0000\u01f2\u01f3\u0007\u0000\u0000\u0000"+
		"\u01f3;\u0001\u0000\u0000\u0000\u01f4\u01f5\u0007\u0001\u0000\u0000\u01f5"+
		"=\u0001\u0000\u0000\u0000\u01f6\u01f8\u0005w\u0000\u0000\u01f7\u01f9\u0003"+
		"Z-\u0000\u01f8\u01f7\u0001\u0000\u0000\u0000\u01f8\u01f9\u0001\u0000\u0000"+
		"\u0000\u01f9\u01fa\u0001\u0000\u0000\u0000\u01fa\u01fb\u00034\u001a\u0000"+
		"\u01fb?\u0001\u0000\u0000\u0000\u01fc\u01fd\u0005w\u0000\u0000\u01fd\u01fe"+
		"\u0005\u001e\u0000\u0000\u01fe\u01ff\u00030\u0018\u0000\u01ff\u0200\u0005"+
		"\u001f\u0000\u0000\u0200A\u0001\u0000\u0000\u0000\u0201\u0202\u0007\u0002"+
		"\u0000\u0000\u0202C\u0001\u0000\u0000\u0000\u0203\u0204\u0007\u0003\u0000"+
		"\u0000\u0204E\u0001\u0000\u0000\u0000\u0205\u0206\u0005H\u0000\u0000\u0206"+
		"\u0210\u0003*\u0015\u0000\u0207\u020b\u0005I\u0000\u0000\u0208\u0209\u0003"+
		"R)\u0000\u0209\u020a\u0005w\u0000\u0000\u020a\u020c\u0001\u0000\u0000"+
		"\u0000\u020b\u0208\u0001\u0000\u0000\u0000\u020b\u020c\u0001\u0000\u0000"+
		"\u0000\u020c\u020d\u0001\u0000\u0000\u0000\u020d\u020f\u0003*\u0015\u0000"+
		"\u020e\u0207\u0001\u0000\u0000\u0000\u020f\u0212\u0001\u0000\u0000\u0000"+
		"\u0210\u020e\u0001\u0000\u0000\u0000\u0210\u0211\u0001\u0000\u0000\u0000"+
		"\u0211\u0214\u0001\u0000\u0000\u0000\u0212\u0210\u0001\u0000\u0000\u0000"+
		"\u0213\u0215\u0005J\u0000\u0000\u0214\u0213\u0001\u0000\u0000\u0000\u0214"+
		"\u0215\u0001\u0000\u0000\u0000\u0215\u0217\u0001\u0000\u0000\u0000\u0216"+
		"\u0218\u0003*\u0015\u0000\u0217\u0216\u0001\u0000\u0000\u0000\u0217\u0218"+
		"\u0001\u0000\u0000\u0000\u0218G\u0001\u0000\u0000\u0000\u0219\u021a\u0005"+
		"K\u0000\u0000\u021a\u021b\u00030\u0018\u0000\u021b\u021f\u0005\u0016\u0000"+
		"\u0000\u021c\u021e\u0003J%\u0000\u021d\u021c\u0001\u0000\u0000\u0000\u021e"+
		"\u0221\u0001\u0000\u0000\u0000\u021f\u021d\u0001\u0000\u0000\u0000\u021f"+
		"\u0220\u0001\u0000\u0000\u0000\u0220\u0223\u0001\u0000\u0000\u0000\u0221"+
		"\u021f\u0001\u0000\u0000\u0000\u0222\u0224\u0003L&\u0000\u0223\u0222\u0001"+
		"\u0000\u0000\u0000\u0223\u0224\u0001\u0000\u0000\u0000\u0224\u0225\u0001"+
		"\u0000\u0000\u0000\u0225\u0226\u0005\u0017\u0000\u0000\u0226I\u0001\u0000"+
		"\u0000\u0000\u0227\u0228\u0005L\u0000\u0000\u0228\u0229\u00030\u0018\u0000"+
		"\u0229\u022d\u0005\u0007\u0000\u0000\u022a\u022c\u0003\u0002\u0001\u0000"+
		"\u022b\u022a\u0001\u0000\u0000\u0000\u022c\u022f\u0001\u0000\u0000\u0000"+
		"\u022d\u022b\u0001\u0000\u0000\u0000\u022d\u022e\u0001\u0000\u0000\u0000"+
		"\u022eK\u0001\u0000\u0000\u0000\u022f\u022d\u0001\u0000\u0000\u0000\u0230"+
		"\u0231\u0005M\u0000\u0000\u0231\u0235\u0005\u0007\u0000\u0000\u0232\u0234"+
		"\u0003\u0002\u0001\u0000\u0233\u0232\u0001\u0000\u0000\u0000\u0234\u0237"+
		"\u0001\u0000\u0000\u0000\u0235\u0233\u0001\u0000\u0000\u0000\u0235\u0236"+
		"\u0001\u0000\u0000\u0000\u0236M\u0001\u0000\u0000\u0000\u0237\u0235\u0001"+
		"\u0000\u0000\u0000\u0238\u0239\u0007\u0004\u0000\u0000\u0239O\u0001\u0000"+
		"\u0000\u0000\u023a\u023b\u0007\u0005\u0000\u0000\u023bQ\u0001\u0000\u0000"+
		"\u0000\u023c\u0243\u0003V+\u0000\u023d\u0243\u0003Z-\u0000\u023e\u0243"+
		"\u0003X,\u0000\u023f\u0243\u0003\\.\u0000\u0240\u0243\u0003^/\u0000\u0241"+
		"\u0243\u0003T*\u0000\u0242\u023c\u0001\u0000\u0000\u0000\u0242\u023d\u0001"+
		"\u0000\u0000\u0000\u0242\u023e\u0001\u0000\u0000\u0000\u0242\u023f\u0001"+
		"\u0000\u0000\u0000\u0242\u0240\u0001\u0000\u0000\u0000\u0242\u0241\u0001"+
		"\u0000\u0000\u0000\u0243S\u0001\u0000\u0000\u0000\u0244\u0245\u0005n\u0000"+
		"\u0000\u0245U\u0001\u0000\u0000\u0000\u0246\u0247\u0005z\u0000\u0000\u0247"+
		"\u0248\u0005w\u0000\u0000\u0248W\u0001\u0000\u0000\u0000\u0249\u024a\u0005"+
		"z\u0000\u0000\u024a\u024b\u00034\u001a\u0000\u024b\u024c\u0005\b\u0000"+
		"\u0000\u024cY\u0001\u0000\u0000\u0000\u024d\u024e\u0005z\u0000\u0000\u024e"+
		"\u0253\u0005w\u0000\u0000\u024f\u0250\u0005y\u0000\u0000\u0250\u0252\u0005"+
		"w\u0000\u0000\u0251\u024f\u0001\u0000\u0000\u0000\u0252\u0255\u0001\u0000"+
		"\u0000\u0000\u0253\u0251\u0001\u0000\u0000\u0000\u0253\u0254\u0001\u0000"+
		"\u0000\u0000\u0254\u0256\u0001\u0000\u0000\u0000\u0255\u0253\u0001\u0000"+
		"\u0000\u0000\u0256\u0257\u0005\b\u0000\u0000\u0257[\u0001\u0000\u0000"+
		"\u0000\u0258\u0259\u0003V+\u0000\u0259\u025a\u0003Z-\u0000\u025a]\u0001"+
		"\u0000\u0000\u0000\u025b\u025c\u0005{\u0000\u0000\u025c\u025d\u0003R)"+
		"\u0000\u025d\u025e\u0005|\u0000\u0000\u025e\u025f\u0005o\u0000\u0000\u025f"+
		"_\u0001\u0000\u0000\u0000\u0260\u0261\u0007\u0006\u0000\u0000\u0261a\u0001"+
		"\u0000\u0000\u0000Tez}\u0082\u0086\u008a\u008e\u0093\u0098\u009c\u00a1"+
		"\u00a4\u00a7\u00aa\u00af\u00b3\u00b8\u00bb\u00be\u00c6\u00cb\u00d2\u00d5"+
		"\u00d8\u00db\u00e0\u00e5\u00e8\u00eb\u00ee\u00f3\u00fa\u00fd\u0103\u0106"+
		"\u0115\u011a\u0122\u012e\u0137\u013c\u013f\u0144\u0148\u014d\u0153\u0158"+
		"\u015e\u0161\u0166\u016c\u0174\u0178\u017d\u0183\u018d\u0193\u0199\u019d"+
		"\u01a7\u01ab\u01b3\u01b9\u01bb\u01bd\u01c9\u01cd\u01d3\u01df\u01e3\u01e8"+
		"\u01ec\u01f0\u01f8\u020b\u0210\u0214\u0217\u021f\u0223\u022d\u0235\u0242"+
		"\u0253";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}