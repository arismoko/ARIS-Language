grammar Arisl;

program: statement*;

statement:
	functionDecl			# functionDeclID
	| delegateDecl			# delegateDeclID
	| constructorDecl		# constructorDeclID
	| classDecl				# classDeclID
	| structDecl			# structDeclID
	| recordDecl			# recordDeclID
	| enumDecl				# enumDeclID
	| interfaceDecl			# interfaceDeclID
	| ifStatement			# ifStatementID
	| whileStatement		# whileStatementID
	| forStatement			# forStatementID
	| forEachStatement		# forEachStatementID
	| returnStatement		# returnStatementID
	| objectCreation		# objectCreationStatementID
	| tryCatchStatement		# tryCatchStatementID
	| repeatUntilStatement	# repeatUntilStatementID
	| switchStatement		# switchStatementID
	| expressionStatement	# expressionStatementID;
delegateDecl:
	visibility? modifier* type? 'delegate' genericType? IDENTIFIER arguments? end;
recordDecl:
	visibility? modifier* type? 'record' IDENTIFIER arguments? block? end?;
functionDecl:
	visibility? modifier* type? 'func' IDENTIFIER genericType? arguments? block?;
repeatUntilStatement: 'repeat' block 'until' expression;

classDecl:
	visibility? modifier* 'class' IDENTIFIER (':' type)? block? end?;

constructorDecl:
	visibility? modifier* '@' arguments? block? end?;

structDecl:
	visibility? modifier* 'struct' IDENTIFIER block end?;

enumDecl: visibility? 'enum' IDENTIFIER list end?;

interfaceDecl:
	visibility? 'interface' IDENTIFIER interfaceBlock;

ifStatement:
	'if' expression block ('else if' expression block)* (
		'else' block
	)?;

whileStatement: 'while' expression block;

forStatement:
	'for' type? expression end expression end expression end block;

forEachStatement:
	'foreach' type? IDENTIFIER 'in' expression block;

returnStatement: 'return' expression? end+;

operatorOverloadStatement:
	visibility? modifier* type? 'operator' binaryOp arguments? block;
objectCreation:
	'create' visibility? modifier* type IDENTIFIER tuple? list? end+;

interfaceBlock: '{' interfaceMember* '}';

interfaceMember: functionSignature;
functionSignature: type? IDENTIFIER arguments? end+;

block: '{' statement* '}';

list: '|' expression '|';
expressionStatement: visibility? modifier* expression end+;

expression:
	modifier* type? primary							# PrimaryExpression
	| expression (binaryOp expression)+				# BinaryExpression
	| PARENTHESISOPEN expression PARENTHESISCLOSE	# ParenthesisExpression
	| expression unaryOP+							# UnaryExpression
	| prefix+ expression							# PrefixExpression;

primary:
	literal			# literalPrimary
	| tuple			# tuplePrimary
	| IDENTIFIER	# identifierPrimary
	| methodCall	# methodCallPrimary
	| tableCall		# tableCallPrimary
	| block			# blockPrimary
	| list			# listPrimary
	| genericType	# genericTypePrimary
	| type			# typePrimary;

tuple:
	PARENTHESISOPEN expression? (COMMA expression)* PARENTHESISCLOSE;
arguments:
	PARENTHESISOPEN '...' PARENTHESISCLOSE		# varArgs
	| PARENTHESISOPEN (param)* PARENTHESISCLOSE	# args;
param: modifier* type? IDENTIFIER COMMA?;
prefix: '!' | '-';
unaryOP: '++' | '--';

methodCall: IDENTIFIER genericType? tuple;

tableCall: IDENTIFIER '[' expression ']';

literal: 'true' | 'false' | 'null' | NUMBER | STRING;

binaryOp:
	'^='
	| '^'
	| '*='
	| '*'
	| '/='
	| '/'
	| '%='
	| '%'
	| '+='
	| '+'
	| '-='
	| '-'
	| '=='
	| '!='
	| '<='
	| '<'
	| '>='
	| '>'
	| '='
	| 'not'
	| '&&'
	| 'and'
	| '||'
	| 'or'
	| '|||'
	| '::'
	| ','
	| '.'
	| '??'
	| '=>'
	| '->'
	| '<-'
	| '<<'
	| '>>'
	| '>>>'
	| '<<='
	| '>>='
	| '>>>='
	| 'is';

tryCatchStatement:
	'try' block ('catch' (type IDENTIFIER)? block)* 'finally'? block?;

switchStatement:
	'switch' expression '{' caseBlock* defaultBlock? '}';

caseBlock: 'case' expression ':' statement*;
defaultBlock: 'default' ':' statement*;

modifier:
	'static'
	| 'instantiated'
	| 'abstract'
	| 'final'
	| 'override'
	| 'virtual'
	| 'sealed'
	| 'volatile'
	| 'readonly'
	| 'const'
	| 'new'
	| 'ref'
	| 'out'
	| 'in'
	| 'tbl'
	| 'async'
	| 'let'
	| 'select'
	| 'where'
	| 'group'
	| 'into'
	| 'orderby'
	| 'join'
	| 'equals'
	| 'on'
	| 'from'
	| 'ascending'
	| 'descending'
	| 'fixed'
	| 'unsafe'
	| 'checked'
	| 'unchecked'
	| 'await';
visibility: (PRIVATE | PUBLIC | GLOBAL);
type:
	simpleType
	| genericType
	| tupleType
	| nestedType
	| castType
	| varType;

varType: '~~';

simpleType: TYPETOKEN IDENTIFIER;

tupleType: TYPETOKEN tuple '@';
genericType: TYPETOKEN IDENTIFIER (COMMA IDENTIFIER)* '@';

nestedType: simpleType genericType;

castType: PARENTHESISOPEN type PARENTHESISCLOSE '<~';
end: ';' | '~*~' | '<*~' | '~*>';
PRIVATE: 'private';
PUBLIC: 'public';
GLOBAL: 'global';
IDENTIFIER: LETTER+ (LETTER | DIGIT)*;

NUMBER: DIGIT+ 'f'?;
COMMA: ',';
TYPETOKEN: '~';
PARENTHESISOPEN: '(';
PARENTHESISCLOSE: ')';
fragment LETTER: [a-zA-Z_-];
fragment DIGIT: [0-9];
fragment DOLLAR: '$';
fragment AT: '@';

STRING:
	'"' (~["\\] | '\\' .)* '"'
	| '\'' ( ~['\\] | '\\' .)* '\''
	| DOLLAR? AT? '"' ( ~["\\] | '\\' .)* '"'
	| DOLLAR? AT? '\'' ( ~['\\] | '\\' .)* '\''
	| '"""' ( ~["\\] | '\\' .)* '"""'
	| (DOLLAR AT | AT DOLLAR) '"""' (~["\\] | '\\' .)* '"""';

LINE_COMMENT: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;

WS: [ \t\r\n]+ -> skip;