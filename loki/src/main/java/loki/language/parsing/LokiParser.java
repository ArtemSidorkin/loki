// Generated from ./loki/src/main/java/loki/language/parsing/Loki.grammar by ANTLR 4.8

package loki.language.parsing;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LokiParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BEGIN=1, END=2, IF=3, ELSE=4, WHILE=5, IDENTIFIER=6, UNDERSCORE=7, DOLLAR=8, 
		AT=9, CHARACTERS=10, FLOAT=11, INT=12, PLUS=13, MINUS=14, STAR=15, SLASH=16, 
		BACKSLASH=17, EQUALS_EQUALS=18, BANG_EQUALS=19, GREATER_THAN_EQUALS=20, 
		GREATER_THAN=21, LESS_THAN_EQUALS=22, LESS_THAN=23, AMPERSAND_AMPERSAND=24, 
		PIPE_PIPE=25, BANG=26, AMPERSAND=27, PIPE=28, EQUALS=29, DOT=30, COMMA=31, 
		DOUBLE_COLON=32, COLON=33, RIGHT_THIN_ARROW=34, RIGHT_THICK_ARROW=35, 
		SEMICOLON=36, LEFT_PARENTHESIS=37, RIGHT_PARENTHESIS=38, LEFT_BRACKET=39, 
		RIGHT_BRACKET=40, LEFT_BRACE=41, RIGHT_BRACE=42, ACUTE=43, IGNORE=44;
	public static final int
		RULE_module = 0, RULE_instruction = 1, RULE_expression = 2, RULE_inheritance = 3, 
		RULE_else_ = 4, RULE_unitParameter = 5, RULE_unitBody = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"module", "instruction", "expression", "inheritance", "else_", "unitParameter", 
			"unitBody"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'if'", "'else'", "'while'", null, "'_'", "'$'", "'@'", 
			null, null, null, "'+'", "'-'", "'*'", "'/'", "'\\'", "'=='", "'!='", 
			"'>='", "'>'", "'<='", "'<'", "'&&'", "'||'", "'!'", "'&'", "'|'", "'='", 
			"'.'", "','", "'::'", "':'", "'->'", "'=>'", "';'", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "'`'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BEGIN", "END", "IF", "ELSE", "WHILE", "IDENTIFIER", "UNDERSCORE", 
			"DOLLAR", "AT", "CHARACTERS", "FLOAT", "INT", "PLUS", "MINUS", "STAR", 
			"SLASH", "BACKSLASH", "EQUALS_EQUALS", "BANG_EQUALS", "GREATER_THAN_EQUALS", 
			"GREATER_THAN", "LESS_THAN_EQUALS", "LESS_THAN", "AMPERSAND_AMPERSAND", 
			"PIPE_PIPE", "BANG", "AMPERSAND", "PIPE", "EQUALS", "DOT", "COMMA", "DOUBLE_COLON", 
			"COLON", "RIGHT_THIN_ARROW", "RIGHT_THICK_ARROW", "SEMICOLON", "LEFT_PARENTHESIS", 
			"RIGHT_PARENTHESIS", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_BRACE", "RIGHT_BRACE", 
			"ACUTE", "IGNORE"
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
	public String getGrammarFileName() { return "Loki.grammar"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LokiParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ModuleContext extends ParserRuleContext {
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(LokiParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LokiParser.SEMICOLON, i);
		}
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterModule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitModule(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14);
				instruction();
				setState(15);
				match(SEMICOLON);
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << UNDERSCORE) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << COLON) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0) );
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

	public static class InstructionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
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
	public static class UnaryOperationContext extends ExpressionContext {
		public Token operator;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(LokiParser.MINUS, 0); }
		public TerminalNode BANG() { return getToken(LokiParser.BANG, 0); }
		public UnaryOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterUnaryOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitUnaryOperation(this);
		}
	}
	public static class IfElseContext extends ExpressionContext {
		public TerminalNode IF() { return getToken(LokiParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(LokiParser.COLON, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public Else_Context else_() {
			return getRuleContext(Else_Context.class,0);
		}
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(LokiParser.END, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(LokiParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LokiParser.SEMICOLON, i);
		}
		public IfElseContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitIfElse(this);
		}
	}
	public static class BinaryOperationContext extends ExpressionContext {
		public Token operator;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode STAR() { return getToken(LokiParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(LokiParser.SLASH, 0); }
		public TerminalNode PLUS() { return getToken(LokiParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(LokiParser.MINUS, 0); }
		public TerminalNode EQUALS_EQUALS() { return getToken(LokiParser.EQUALS_EQUALS, 0); }
		public TerminalNode BANG_EQUALS() { return getToken(LokiParser.BANG_EQUALS, 0); }
		public TerminalNode GREATER_THAN_EQUALS() { return getToken(LokiParser.GREATER_THAN_EQUALS, 0); }
		public TerminalNode LESS_THAN_EQUALS() { return getToken(LokiParser.LESS_THAN_EQUALS, 0); }
		public TerminalNode GREATER_THAN() { return getToken(LokiParser.GREATER_THAN, 0); }
		public TerminalNode LESS_THAN() { return getToken(LokiParser.LESS_THAN, 0); }
		public TerminalNode AMPERSAND_AMPERSAND() { return getToken(LokiParser.AMPERSAND_AMPERSAND, 0); }
		public TerminalNode PIPE_PIPE() { return getToken(LokiParser.PIPE_PIPE, 0); }
		public BinaryOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterBinaryOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitBinaryOperation(this);
		}
	}
	public static class IndexContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(LokiParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LokiParser.RIGHT_BRACKET, 0); }
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public TerminalNode SEMICOLON() { return getToken(LokiParser.SEMICOLON, 0); }
		public TerminalNode END() { return getToken(LokiParser.END, 0); }
		public IndexContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitIndex(this);
		}
	}
	public static class StringContext extends ExpressionContext {
		public TerminalNode CHARACTERS() { return getToken(LokiParser.CHARACTERS, 0); }
		public TerminalNode ACUTE() { return getToken(LokiParser.ACUTE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LokiParser.IDENTIFIER, 0); }
		public StringContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitString(this);
		}
	}
	public static class UnitContext extends ExpressionContext {
		public Token member;
		public Token name;
		public TerminalNode COLON() { return getToken(LokiParser.COLON, 0); }
		public List<UnitParameterContext> unitParameter() {
			return getRuleContexts(UnitParameterContext.class);
		}
		public UnitParameterContext unitParameter(int i) {
			return getRuleContext(UnitParameterContext.class,i);
		}
		public InheritanceContext inheritance() {
			return getRuleContext(InheritanceContext.class,0);
		}
		public TerminalNode UNDERSCORE() { return getToken(LokiParser.UNDERSCORE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LokiParser.IDENTIFIER, 0); }
		public TerminalNode DOLLAR() { return getToken(LokiParser.DOLLAR, 0); }
		public UnitBodyContext unitBody() {
			return getRuleContext(UnitBodyContext.class,0);
		}
		public TerminalNode BACKSLASH() { return getToken(LokiParser.BACKSLASH, 0); }
		public UnitContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitUnit(this);
		}
	}
	public static class NumberContext extends ExpressionContext {
		public TerminalNode FLOAT() { return getToken(LokiParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(LokiParser.INT, 0); }
		public NumberContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitNumber(this);
		}
	}
	public static class MemberAccessorContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DOLLAR() { return getToken(LokiParser.DOLLAR, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(LokiParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LokiParser.RIGHT_BRACKET, 0); }
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public TerminalNode SEMICOLON() { return getToken(LokiParser.SEMICOLON, 0); }
		public TerminalNode END() { return getToken(LokiParser.END, 0); }
		public MemberAccessorContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterMemberAccessor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitMemberAccessor(this);
		}
	}
	public static class VariableOrParameterContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(LokiParser.IDENTIFIER, 0); }
		public TerminalNode UNDERSCORE() { return getToken(LokiParser.UNDERSCORE, 0); }
		public VariableOrParameterContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterVariableOrParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitVariableOrParameter(this);
		}
	}
	public static class ThisContext extends ExpressionContext {
		public TerminalNode AT() { return getToken(LokiParser.AT, 0); }
		public ThisContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterThis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitThis(this);
		}
	}
	public static class AssignMemberContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DOT() { return getToken(LokiParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LokiParser.IDENTIFIER, 0); }
		public TerminalNode EQUALS() { return getToken(LokiParser.EQUALS, 0); }
		public AssignMemberContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterAssignMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitAssignMember(this);
		}
	}
	public static class MemberContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(LokiParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LokiParser.IDENTIFIER, 0); }
		public MemberContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitMember(this);
		}
	}
	public static class MemberCallContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DOT() { return getToken(LokiParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LokiParser.IDENTIFIER, 0); }
		public TerminalNode LEFT_PARENTHESIS() { return getToken(LokiParser.LEFT_PARENTHESIS, 0); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(LokiParser.RIGHT_PARENTHESIS, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LokiParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LokiParser.COMMA, i);
		}
		public MemberCallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterMemberCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitMemberCall(this);
		}
	}
	public static class CallContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LEFT_PARENTHESIS() { return getToken(LokiParser.LEFT_PARENTHESIS, 0); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(LokiParser.RIGHT_PARENTHESIS, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LokiParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LokiParser.COMMA, i);
		}
		public CallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitCall(this);
		}
	}
	public static class ExpressionGroupContext extends ExpressionContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(LokiParser.LEFT_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(LokiParser.RIGHT_PARENTHESIS, 0); }
		public ExpressionGroupContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterExpressionGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitExpressionGroup(this);
		}
	}
	public static class HostContext extends ExpressionContext {
		public TerminalNode DOLLAR() { return getToken(LokiParser.DOLLAR, 0); }
		public HostContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterHost(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitHost(this);
		}
	}
	public static class SuperHostMemberContext extends ExpressionContext {
		public List<TerminalNode> DOLLAR() { return getTokens(LokiParser.DOLLAR); }
		public TerminalNode DOLLAR(int i) {
			return getToken(LokiParser.DOLLAR, i);
		}
		public TerminalNode IDENTIFIER() { return getToken(LokiParser.IDENTIFIER, 0); }
		public SuperHostMemberContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterSuperHostMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitSuperHostMember(this);
		}
	}
	public static class WhileContext extends ExpressionContext {
		public TerminalNode WHILE() { return getToken(LokiParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(LokiParser.COLON, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(LokiParser.END, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(LokiParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LokiParser.SEMICOLON, i);
		}
		public WhileContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitWhile(this);
		}
	}
	public static class ArrayContext extends ExpressionContext {
		public TerminalNode LEFT_BRACKET() { return getToken(LokiParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LokiParser.RIGHT_BRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LokiParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LokiParser.COMMA, i);
		}
		public ArrayContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitArray(this);
		}
	}
	public static class AssignVariableContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(LokiParser.IDENTIFIER, 0); }
		public TerminalNode EQUALS() { return getToken(LokiParser.EQUALS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignVariableContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterAssignVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitAssignVariable(this);
		}
	}
	public static class AssignMemberAccessorContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DOLLAR() { return getToken(LokiParser.DOLLAR, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(LokiParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LokiParser.RIGHT_BRACKET, 0); }
		public TerminalNode EQUALS() { return getToken(LokiParser.EQUALS, 0); }
		public AssignMemberAccessorContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterAssignMemberAccessor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitAssignMemberAccessor(this);
		}
	}
	public static class AssignIndexContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(LokiParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LokiParser.RIGHT_BRACKET, 0); }
		public TerminalNode EQUALS() { return getToken(LokiParser.EQUALS, 0); }
		public AssignIndexContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterAssignIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitAssignIndex(this);
		}
	}
	public static class HostMemberContext extends ExpressionContext {
		public TerminalNode DOLLAR() { return getToken(LokiParser.DOLLAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LokiParser.IDENTIFIER, 0); }
		public HostMemberContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterHostMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitHostMember(this);
		}
	}
	public static class ObjectContext extends ExpressionContext {
		public TerminalNode LEFT_BRACKET() { return getToken(LokiParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LokiParser.RIGHT_BRACKET, 0); }
		public TerminalNode EQUALS() { return getToken(LokiParser.EQUALS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RIGHT_THICK_ARROW() { return getTokens(LokiParser.RIGHT_THICK_ARROW); }
		public TerminalNode RIGHT_THICK_ARROW(int i) {
			return getToken(LokiParser.RIGHT_THICK_ARROW, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LokiParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LokiParser.COMMA, i);
		}
		public ObjectContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitObject(this);
		}
	}
	public static class AssignHostMemberContext extends ExpressionContext {
		public TerminalNode DOLLAR() { return getToken(LokiParser.DOLLAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LokiParser.IDENTIFIER, 0); }
		public TerminalNode EQUALS() { return getToken(LokiParser.EQUALS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignHostMemberContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterAssignHostMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitAssignHostMember(this);
		}
	}
	public static class MapContext extends ExpressionContext {
		public TerminalNode LEFT_BRACKET() { return getToken(LokiParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LokiParser.RIGHT_BRACKET, 0); }
		public TerminalNode MINUS() { return getToken(LokiParser.MINUS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RIGHT_THIN_ARROW() { return getTokens(LokiParser.RIGHT_THIN_ARROW); }
		public TerminalNode RIGHT_THIN_ARROW(int i) {
			return getToken(LokiParser.RIGHT_THIN_ARROW, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LokiParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LokiParser.COMMA, i);
		}
		public MapContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitMap(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				_localctx = new ExpressionGroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(24);
				match(LEFT_PARENTHESIS);
				setState(25);
				expression(0);
				setState(26);
				match(RIGHT_PARENTHESIS);
				}
				break;
			case 2:
				{
				_localctx = new ArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				match(LEFT_BRACKET);
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << UNDERSCORE) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << COLON) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0)) {
					{
					setState(29);
					expression(0);
					setState(34);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(30);
						match(COMMA);
						setState(31);
						expression(0);
						}
						}
						setState(36);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(39);
				match(RIGHT_BRACKET);
				}
				break;
			case 3:
				{
				_localctx = new MapContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(40);
				match(LEFT_BRACKET);
				setState(55);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					{
					setState(41);
					expression(0);
					setState(42);
					match(RIGHT_THIN_ARROW);
					setState(43);
					expression(0);
					setState(51);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(44);
						match(COMMA);
						setState(45);
						expression(0);
						setState(46);
						match(RIGHT_THIN_ARROW);
						setState(47);
						expression(0);
						}
						}
						setState(53);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case 2:
					{
					setState(54);
					match(MINUS);
					}
					break;
				}
				setState(57);
				match(RIGHT_BRACKET);
				}
				break;
			case 4:
				{
				_localctx = new ObjectContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(58);
				match(LEFT_BRACKET);
				setState(73);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IF:
				case WHILE:
				case IDENTIFIER:
				case UNDERSCORE:
				case DOLLAR:
				case AT:
				case CHARACTERS:
				case FLOAT:
				case INT:
				case MINUS:
				case BACKSLASH:
				case BANG:
				case COLON:
				case LEFT_PARENTHESIS:
				case LEFT_BRACKET:
				case ACUTE:
					{
					{
					setState(59);
					expression(0);
					setState(60);
					match(RIGHT_THICK_ARROW);
					setState(61);
					expression(0);
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(62);
						match(COMMA);
						setState(63);
						expression(0);
						setState(64);
						match(RIGHT_THICK_ARROW);
						setState(65);
						expression(0);
						}
						}
						setState(71);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case EQUALS:
					{
					setState(72);
					match(EQUALS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(75);
				match(RIGHT_BRACKET);
				}
				break;
			case 5:
				{
				_localctx = new HostContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				match(DOLLAR);
				}
				break;
			case 6:
				{
				_localctx = new ThisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				match(AT);
				}
				break;
			case 7:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CHARACTERS:
					{
					setState(78);
					match(CHARACTERS);
					}
					break;
				case ACUTE:
					{
					setState(79);
					match(ACUTE);
					setState(80);
					match(IDENTIFIER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 8:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83);
				match(FLOAT);
				}
				break;
			case 9:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84);
				match(INT);
				}
				break;
			case 10:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(85);
				match(COLON);
				setState(91);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
				case DOLLAR:
					{
					{
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==DOLLAR) {
						{
						setState(86);
						((UnitContext)_localctx).member = match(DOLLAR);
						}
					}

					setState(89);
					((UnitContext)_localctx).name = match(IDENTIFIER);
					}
					}
					break;
				case UNDERSCORE:
					{
					{
					setState(90);
					match(UNDERSCORE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(93);
						unitParameter();
						}
						} 
					}
					setState(98);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(100);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(99);
					inheritance();
					}
					break;
				}
				}
				break;
			case 11:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
				case UNDERSCORE:
				case DOLLAR:
					{
					{
					{
					setState(107);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case IDENTIFIER:
					case DOLLAR:
						{
						{
						setState(103);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==DOLLAR) {
							{
							setState(102);
							((UnitContext)_localctx).member = match(DOLLAR);
							}
						}

						setState(105);
						((UnitContext)_localctx).name = match(IDENTIFIER);
						}
						}
						break;
					case UNDERSCORE:
						{
						{
						setState(106);
						match(UNDERSCORE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==IDENTIFIER || _la==DOLLAR) {
						{
						{
						setState(109);
						unitParameter();
						}
						}
						setState(114);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==DOUBLE_COLON) {
						{
						setState(115);
						inheritance();
						}
					}

					setState(118);
					match(COLON);
					}
					}
					}
					break;
				case BACKSLASH:
					{
					setState(119);
					match(BACKSLASH);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(122);
				unitBody();
				}
				break;
			case 12:
				{
				_localctx = new SuperHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				match(DOLLAR);
				setState(124);
				match(DOLLAR);
				setState(125);
				match(IDENTIFIER);
				}
				break;
			case 13:
				{
				_localctx = new HostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(126);
				match(DOLLAR);
				setState(127);
				match(IDENTIFIER);
				}
				break;
			case 14:
				{
				_localctx = new VariableOrParameterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==UNDERSCORE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 15:
				{
				_localctx = new UnaryOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				((UnaryOperationContext)_localctx).operator = match(MINUS);
				setState(130);
				expression(15);
				}
				break;
			case 16:
				{
				_localctx = new UnaryOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				((UnaryOperationContext)_localctx).operator = match(BANG);
				setState(132);
				expression(14);
				}
				break;
			case 17:
				{
				_localctx = new AssignHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
				match(DOLLAR);
				setState(134);
				match(IDENTIFIER);
				setState(135);
				match(EQUALS);
				setState(136);
				expression(7);
				}
				break;
			case 18:
				{
				_localctx = new AssignVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				match(IDENTIFIER);
				setState(138);
				match(EQUALS);
				setState(139);
				expression(6);
				}
				break;
			case 19:
				{
				_localctx = new IfElseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(IF);
				setState(141);
				expression(0);
				setState(142);
				match(COLON);
				setState(154);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IF:
				case WHILE:
				case IDENTIFIER:
				case UNDERSCORE:
				case DOLLAR:
				case AT:
				case CHARACTERS:
				case FLOAT:
				case INT:
				case MINUS:
				case BACKSLASH:
				case BANG:
				case COLON:
				case LEFT_PARENTHESIS:
				case LEFT_BRACKET:
				case ACUTE:
					{
					setState(143);
					instruction();
					}
					break;
				case BEGIN:
					{
					{
					setState(144);
					match(BEGIN);
					setState(148); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(145);
						instruction();
						setState(146);
						match(SEMICOLON);
						}
						}
						setState(150); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << UNDERSCORE) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << COLON) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0) );
					setState(152);
					match(END);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(157);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(156);
					else_();
					}
					break;
				}
				}
				break;
			case 20:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				match(WHILE);
				setState(160);
				expression(0);
				setState(161);
				match(COLON);
				setState(173);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IF:
				case WHILE:
				case IDENTIFIER:
				case UNDERSCORE:
				case DOLLAR:
				case AT:
				case CHARACTERS:
				case FLOAT:
				case INT:
				case MINUS:
				case BACKSLASH:
				case BANG:
				case COLON:
				case LEFT_PARENTHESIS:
				case LEFT_BRACKET:
				case ACUTE:
					{
					setState(162);
					instruction();
					}
					break;
				case BEGIN:
					{
					{
					setState(163);
					match(BEGIN);
					setState(167); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(164);
						instruction();
						setState(165);
						match(SEMICOLON);
						}
						}
						setState(169); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << UNDERSCORE) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << COLON) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0) );
					setState(171);
					match(END);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(275);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(273);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(177);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(178);
						((BinaryOperationContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==STAR || _la==SLASH) ) {
							((BinaryOperationContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(179);
						expression(14);
						}
						break;
					case 2:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(180);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(181);
						((BinaryOperationContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((BinaryOperationContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(182);
						expression(13);
						}
						break;
					case 3:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(183);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(184);
						((BinaryOperationContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUALS_EQUALS || _la==BANG_EQUALS) ) {
							((BinaryOperationContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(185);
						expression(12);
						}
						break;
					case 4:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(186);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(187);
						((BinaryOperationContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATER_THAN_EQUALS) | (1L << GREATER_THAN) | (1L << LESS_THAN_EQUALS) | (1L << LESS_THAN))) != 0)) ) {
							((BinaryOperationContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(188);
						expression(11);
						}
						break;
					case 5:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(189);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(190);
						((BinaryOperationContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AMPERSAND_AMPERSAND) ) {
							((BinaryOperationContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(191);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(192);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(193);
						((BinaryOperationContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PIPE_PIPE) ) {
							((BinaryOperationContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(194);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new AssignMemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(195);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(196);
						match(DOT);
						setState(197);
						match(IDENTIFIER);
						setState(198);
						match(EQUALS);
						setState(199);
						expression(6);
						}
						break;
					case 8:
						{
						_localctx = new AssignIndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(200);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(201);
						match(LEFT_BRACKET);
						setState(202);
						expression(0);
						setState(203);
						match(RIGHT_BRACKET);
						setState(204);
						match(EQUALS);
						setState(205);
						expression(5);
						}
						break;
					case 9:
						{
						_localctx = new AssignMemberAccessorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(207);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(208);
						match(DOLLAR);
						setState(209);
						match(LEFT_BRACKET);
						setState(210);
						expression(0);
						setState(211);
						match(RIGHT_BRACKET);
						setState(212);
						match(EQUALS);
						setState(213);
						expression(4);
						}
						break;
					case 10:
						{
						_localctx = new MemberCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(215);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(216);
						match(DOT);
						setState(217);
						match(IDENTIFIER);
						setState(218);
						match(LEFT_PARENTHESIS);
						setState(227);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << UNDERSCORE) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << COLON) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0)) {
							{
							setState(219);
							expression(0);
							setState(224);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(220);
								match(COMMA);
								setState(221);
								expression(0);
								}
								}
								setState(226);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(229);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 11:
						{
						_localctx = new MemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(230);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(231);
						match(DOT);
						setState(232);
						match(IDENTIFIER);
						}
						break;
					case 12:
						{
						_localctx = new IndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(233);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(234);
						match(LEFT_BRACKET);
						setState(236);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(235);
							match(BEGIN);
							}
						}

						setState(238);
						expression(0);
						setState(240);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(239);
							match(SEMICOLON);
							}
						}

						setState(243);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(242);
							match(END);
							}
						}

						setState(245);
						match(RIGHT_BRACKET);
						}
						break;
					case 13:
						{
						_localctx = new MemberAccessorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(247);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(248);
						match(DOLLAR);
						setState(249);
						match(LEFT_BRACKET);
						setState(256);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case BEGIN:
							{
							{
							setState(250);
							match(BEGIN);
							setState(251);
							expression(0);
							setState(252);
							match(SEMICOLON);
							setState(253);
							match(END);
							}
							}
							break;
						case IF:
						case WHILE:
						case IDENTIFIER:
						case UNDERSCORE:
						case DOLLAR:
						case AT:
						case CHARACTERS:
						case FLOAT:
						case INT:
						case MINUS:
						case BACKSLASH:
						case BANG:
						case COLON:
						case LEFT_PARENTHESIS:
						case LEFT_BRACKET:
						case ACUTE:
							{
							setState(255);
							expression(0);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(258);
						match(RIGHT_BRACKET);
						}
						break;
					case 14:
						{
						_localctx = new CallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(260);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(261);
						match(LEFT_PARENTHESIS);
						setState(270);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << UNDERSCORE) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << COLON) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0)) {
							{
							setState(262);
							expression(0);
							setState(267);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(263);
								match(COMMA);
								setState(264);
								expression(0);
								}
								}
								setState(269);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(272);
						match(RIGHT_PARENTHESIS);
						}
						break;
					}
					} 
				}
				setState(277);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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

	public static class InheritanceContext extends ParserRuleContext {
		public TerminalNode DOUBLE_COLON() { return getToken(LokiParser.DOUBLE_COLON, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LokiParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LokiParser.COMMA, i);
		}
		public InheritanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritance; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterInheritance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitInheritance(this);
		}
	}

	public final InheritanceContext inheritance() throws RecognitionException {
		InheritanceContext _localctx = new InheritanceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_inheritance);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(DOUBLE_COLON);
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(279);
				expression(0);
				setState(284);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(280);
						match(COMMA);
						setState(281);
						expression(0);
						}
						} 
					}
					setState(286);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				}
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

	public static class Else_Context extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(LokiParser.ELSE, 0); }
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(LokiParser.END, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(LokiParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LokiParser.SEMICOLON, i);
		}
		public Else_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterElse_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitElse_(this);
		}
	}

	public final Else_Context else_() throws RecognitionException {
		Else_Context _localctx = new Else_Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_else_);
		int _la;
		try {
			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				match(ELSE);
				setState(290);
				match(BEGIN);
				setState(294); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(291);
					instruction();
					setState(292);
					match(SEMICOLON);
					}
					}
					setState(296); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << UNDERSCORE) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << COLON) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0) );
				setState(298);
				match(END);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				match(ELSE);
				setState(301);
				instruction();
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

	public static class UnitParameterContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(LokiParser.IDENTIFIER, 0); }
		public TerminalNode DOLLAR() { return getToken(LokiParser.DOLLAR, 0); }
		public UnitParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unitParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterUnitParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitUnitParameter(this);
		}
	}

	public final UnitParameterContext unitParameter() throws RecognitionException {
		UnitParameterContext _localctx = new UnitParameterContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_unitParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOLLAR) {
				{
				setState(304);
				match(DOLLAR);
				}
			}

			setState(307);
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

	public static class UnitBodyContext extends ParserRuleContext {
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(LokiParser.END, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(LokiParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LokiParser.SEMICOLON, i);
		}
		public UnitBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unitBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterUnitBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitUnitBody(this);
		}
	}

	public final UnitBodyContext unitBody() throws RecognitionException {
		UnitBodyContext _localctx = new UnitBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_unitBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
			case WHILE:
			case IDENTIFIER:
			case UNDERSCORE:
			case DOLLAR:
			case AT:
			case CHARACTERS:
			case FLOAT:
			case INT:
			case MINUS:
			case BACKSLASH:
			case BANG:
			case COLON:
			case LEFT_PARENTHESIS:
			case LEFT_BRACKET:
			case ACUTE:
				{
				setState(309);
				instruction();
				}
				break;
			case BEGIN:
				{
				{
				setState(310);
				match(BEGIN);
				setState(314); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(311);
					instruction();
					setState(312);
					match(SEMICOLON);
					}
					}
					setState(316); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << UNDERSCORE) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << COLON) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0) );
				setState(318);
				match(END);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 23);
		case 10:
			return precpred(_ctx, 19);
		case 11:
			return precpred(_ctx, 18);
		case 12:
			return precpred(_ctx, 17);
		case 13:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0145\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\6\2\24\n\2"+
		"\r\2\16\2\25\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4#\n\4\f\4"+
		"\16\4&\13\4\5\4(\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\64\n"+
		"\4\f\4\16\4\67\13\4\3\4\5\4:\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\7\4F\n\4\f\4\16\4I\13\4\3\4\5\4L\n\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4T\n"+
		"\4\3\4\3\4\3\4\3\4\5\4Z\n\4\3\4\3\4\5\4^\n\4\3\4\7\4a\n\4\f\4\16\4d\13"+
		"\4\3\4\5\4g\n\4\3\4\5\4j\n\4\3\4\3\4\5\4n\n\4\3\4\7\4q\n\4\f\4\16\4t\13"+
		"\4\3\4\5\4w\n\4\3\4\3\4\5\4{\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4"+
		"\u0097\n\4\r\4\16\4\u0098\3\4\3\4\5\4\u009d\n\4\3\4\5\4\u00a0\n\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4\u00aa\n\4\r\4\16\4\u00ab\3\4\3\4\5\4"+
		"\u00b0\n\4\5\4\u00b2\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u00e1"+
		"\n\4\f\4\16\4\u00e4\13\4\5\4\u00e6\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"\u00ef\n\4\3\4\3\4\5\4\u00f3\n\4\3\4\5\4\u00f6\n\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0103\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4"+
		"\u010c\n\4\f\4\16\4\u010f\13\4\5\4\u0111\n\4\3\4\7\4\u0114\n\4\f\4\16"+
		"\4\u0117\13\4\3\5\3\5\3\5\3\5\7\5\u011d\n\5\f\5\16\5\u0120\13\5\5\5\u0122"+
		"\n\5\3\6\3\6\3\6\3\6\3\6\6\6\u0129\n\6\r\6\16\6\u012a\3\6\3\6\3\6\3\6"+
		"\5\6\u0131\n\6\3\7\5\7\u0134\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\6\b\u013d"+
		"\n\b\r\b\16\b\u013e\3\b\3\b\5\b\u0143\n\b\3\b\2\3\6\t\2\4\6\b\n\f\16\2"+
		"\t\3\2\b\t\3\2\21\22\3\2\17\20\3\2\24\25\3\2\26\31\3\2\32\32\3\2\33\33"+
		"\2\u0183\2\23\3\2\2\2\4\27\3\2\2\2\6\u00b1\3\2\2\2\b\u0118\3\2\2\2\n\u0130"+
		"\3\2\2\2\f\u0133\3\2\2\2\16\u0142\3\2\2\2\20\21\5\4\3\2\21\22\7&\2\2\22"+
		"\24\3\2\2\2\23\20\3\2\2\2\24\25\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26"+
		"\3\3\2\2\2\27\30\5\6\4\2\30\5\3\2\2\2\31\32\b\4\1\2\32\33\7\'\2\2\33\34"+
		"\5\6\4\2\34\35\7(\2\2\35\u00b2\3\2\2\2\36\'\7)\2\2\37$\5\6\4\2 !\7!\2"+
		"\2!#\5\6\4\2\" \3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%(\3\2\2\2&$\3\2"+
		"\2\2\'\37\3\2\2\2\'(\3\2\2\2()\3\2\2\2)\u00b2\7*\2\2*9\7)\2\2+,\5\6\4"+
		"\2,-\7$\2\2-\65\5\6\4\2./\7!\2\2/\60\5\6\4\2\60\61\7$\2\2\61\62\5\6\4"+
		"\2\62\64\3\2\2\2\63.\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2"+
		"\66:\3\2\2\2\67\65\3\2\2\28:\7\20\2\29+\3\2\2\298\3\2\2\2:;\3\2\2\2;\u00b2"+
		"\7*\2\2<K\7)\2\2=>\5\6\4\2>?\7%\2\2?G\5\6\4\2@A\7!\2\2AB\5\6\4\2BC\7%"+
		"\2\2CD\5\6\4\2DF\3\2\2\2E@\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HL\3\2"+
		"\2\2IG\3\2\2\2JL\7\37\2\2K=\3\2\2\2KJ\3\2\2\2LM\3\2\2\2M\u00b2\7*\2\2"+
		"N\u00b2\7\n\2\2O\u00b2\7\13\2\2PT\7\f\2\2QR\7-\2\2RT\7\b\2\2SP\3\2\2\2"+
		"SQ\3\2\2\2T\u00b2\3\2\2\2U\u00b2\7\r\2\2V\u00b2\7\16\2\2W]\7#\2\2XZ\7"+
		"\n\2\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[^\7\b\2\2\\^\7\t\2\2]Y\3\2\2\2]\\"+
		"\3\2\2\2^b\3\2\2\2_a\5\f\7\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c"+
		"f\3\2\2\2db\3\2\2\2eg\5\b\5\2fe\3\2\2\2fg\3\2\2\2g\u00b2\3\2\2\2hj\7\n"+
		"\2\2ih\3\2\2\2ij\3\2\2\2jk\3\2\2\2kn\7\b\2\2ln\7\t\2\2mi\3\2\2\2ml\3\2"+
		"\2\2nr\3\2\2\2oq\5\f\7\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2sv\3\2"+
		"\2\2tr\3\2\2\2uw\5\b\5\2vu\3\2\2\2vw\3\2\2\2wx\3\2\2\2x{\7#\2\2y{\7\23"+
		"\2\2zm\3\2\2\2zy\3\2\2\2{|\3\2\2\2|\u00b2\5\16\b\2}~\7\n\2\2~\177\7\n"+
		"\2\2\177\u00b2\7\b\2\2\u0080\u0081\7\n\2\2\u0081\u00b2\7\b\2\2\u0082\u00b2"+
		"\t\2\2\2\u0083\u0084\7\20\2\2\u0084\u00b2\5\6\4\21\u0085\u0086\7\34\2"+
		"\2\u0086\u00b2\5\6\4\20\u0087\u0088\7\n\2\2\u0088\u0089\7\b\2\2\u0089"+
		"\u008a\7\37\2\2\u008a\u00b2\5\6\4\t\u008b\u008c\7\b\2\2\u008c\u008d\7"+
		"\37\2\2\u008d\u00b2\5\6\4\b\u008e\u008f\7\5\2\2\u008f\u0090\5\6\4\2\u0090"+
		"\u009c\7#\2\2\u0091\u009d\5\4\3\2\u0092\u0096\7\3\2\2\u0093\u0094\5\4"+
		"\3\2\u0094\u0095\7&\2\2\u0095\u0097\3\2\2\2\u0096\u0093\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u009b\7\4\2\2\u009b\u009d\3\2\2\2\u009c\u0091\3\2\2\2\u009c"+
		"\u0092\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u00a0\5\n\6\2\u009f\u009e\3\2"+
		"\2\2\u009f\u00a0\3\2\2\2\u00a0\u00b2\3\2\2\2\u00a1\u00a2\7\7\2\2\u00a2"+
		"\u00a3\5\6\4\2\u00a3\u00af\7#\2\2\u00a4\u00b0\5\4\3\2\u00a5\u00a9\7\3"+
		"\2\2\u00a6\u00a7\5\4\3\2\u00a7\u00a8\7&\2\2\u00a8\u00aa\3\2\2\2\u00a9"+
		"\u00a6\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7\4\2\2\u00ae\u00b0\3\2\2\2\u00af"+
		"\u00a4\3\2\2\2\u00af\u00a5\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\31\3\2\2"+
		"\2\u00b1\36\3\2\2\2\u00b1*\3\2\2\2\u00b1<\3\2\2\2\u00b1N\3\2\2\2\u00b1"+
		"O\3\2\2\2\u00b1S\3\2\2\2\u00b1U\3\2\2\2\u00b1V\3\2\2\2\u00b1W\3\2\2\2"+
		"\u00b1z\3\2\2\2\u00b1}\3\2\2\2\u00b1\u0080\3\2\2\2\u00b1\u0082\3\2\2\2"+
		"\u00b1\u0083\3\2\2\2\u00b1\u0085\3\2\2\2\u00b1\u0087\3\2\2\2\u00b1\u008b"+
		"\3\2\2\2\u00b1\u008e\3\2\2\2\u00b1\u00a1\3\2\2\2\u00b2\u0115\3\2\2\2\u00b3"+
		"\u00b4\f\17\2\2\u00b4\u00b5\t\3\2\2\u00b5\u0114\5\6\4\20\u00b6\u00b7\f"+
		"\16\2\2\u00b7\u00b8\t\4\2\2\u00b8\u0114\5\6\4\17\u00b9\u00ba\f\r\2\2\u00ba"+
		"\u00bb\t\5\2\2\u00bb\u0114\5\6\4\16\u00bc\u00bd\f\f\2\2\u00bd\u00be\t"+
		"\6\2\2\u00be\u0114\5\6\4\r\u00bf\u00c0\f\13\2\2\u00c0\u00c1\t\7\2\2\u00c1"+
		"\u0114\5\6\4\f\u00c2\u00c3\f\n\2\2\u00c3\u00c4\t\b\2\2\u00c4\u0114\5\6"+
		"\4\13\u00c5\u00c6\f\7\2\2\u00c6\u00c7\7 \2\2\u00c7\u00c8\7\b\2\2\u00c8"+
		"\u00c9\7\37\2\2\u00c9\u0114\5\6\4\b\u00ca\u00cb\f\6\2\2\u00cb\u00cc\7"+
		")\2\2\u00cc\u00cd\5\6\4\2\u00cd\u00ce\7*\2\2\u00ce\u00cf\7\37\2\2\u00cf"+
		"\u00d0\5\6\4\7\u00d0\u0114\3\2\2\2\u00d1\u00d2\f\5\2\2\u00d2\u00d3\7\n"+
		"\2\2\u00d3\u00d4\7)\2\2\u00d4\u00d5\5\6\4\2\u00d5\u00d6\7*\2\2\u00d6\u00d7"+
		"\7\37\2\2\u00d7\u00d8\5\6\4\6\u00d8\u0114\3\2\2\2\u00d9\u00da\f\31\2\2"+
		"\u00da\u00db\7 \2\2\u00db\u00dc\7\b\2\2\u00dc\u00e5\7\'\2\2\u00dd\u00e2"+
		"\5\6\4\2\u00de\u00df\7!\2\2\u00df\u00e1\5\6\4\2\u00e0\u00de\3\2\2\2\u00e1"+
		"\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e6\3\2"+
		"\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00dd\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7\u0114\7(\2\2\u00e8\u00e9\f\25\2\2\u00e9\u00ea\7 "+
		"\2\2\u00ea\u0114\7\b\2\2\u00eb\u00ec\f\24\2\2\u00ec\u00ee\7)\2\2\u00ed"+
		"\u00ef\7\3\2\2\u00ee\u00ed\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2"+
		"\2\2\u00f0\u00f2\5\6\4\2\u00f1\u00f3\7&\2\2\u00f2\u00f1\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00f6\7\4\2\2\u00f5\u00f4\3\2"+
		"\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\7*\2\2\u00f8"+
		"\u0114\3\2\2\2\u00f9\u00fa\f\23\2\2\u00fa\u00fb\7\n\2\2\u00fb\u0102\7"+
		")\2\2\u00fc\u00fd\7\3\2\2\u00fd\u00fe\5\6\4\2\u00fe\u00ff\7&\2\2\u00ff"+
		"\u0100\7\4\2\2\u0100\u0103\3\2\2\2\u0101\u0103\5\6\4\2\u0102\u00fc\3\2"+
		"\2\2\u0102\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\7*\2\2\u0105"+
		"\u0114\3\2\2\2\u0106\u0107\f\22\2\2\u0107\u0110\7\'\2\2\u0108\u010d\5"+
		"\6\4\2\u0109\u010a\7!\2\2\u010a\u010c\5\6\4\2\u010b\u0109\3\2\2\2\u010c"+
		"\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0111\3\2"+
		"\2\2\u010f\u010d\3\2\2\2\u0110\u0108\3\2\2\2\u0110\u0111\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\u0114\7(\2\2\u0113\u00b3\3\2\2\2\u0113\u00b6\3\2"+
		"\2\2\u0113\u00b9\3\2\2\2\u0113\u00bc\3\2\2\2\u0113\u00bf\3\2\2\2\u0113"+
		"\u00c2\3\2\2\2\u0113\u00c5\3\2\2\2\u0113\u00ca\3\2\2\2\u0113\u00d1\3\2"+
		"\2\2\u0113\u00d9\3\2\2\2\u0113\u00e8\3\2\2\2\u0113\u00eb\3\2\2\2\u0113"+
		"\u00f9\3\2\2\2\u0113\u0106\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2"+
		"\2\2\u0115\u0116\3\2\2\2\u0116\7\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u0121"+
		"\7\"\2\2\u0119\u011e\5\6\4\2\u011a\u011b\7!\2\2\u011b\u011d\5\6\4\2\u011c"+
		"\u011a\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2"+
		"\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0119\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\t\3\2\2\2\u0123\u0124\7\6\2\2\u0124\u0128\7\3\2\2"+
		"\u0125\u0126\5\4\3\2\u0126\u0127\7&\2\2\u0127\u0129\3\2\2\2\u0128\u0125"+
		"\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\u012d\7\4\2\2\u012d\u0131\3\2\2\2\u012e\u012f\7\6"+
		"\2\2\u012f\u0131\5\4\3\2\u0130\u0123\3\2\2\2\u0130\u012e\3\2\2\2\u0131"+
		"\13\3\2\2\2\u0132\u0134\7\n\2\2\u0133\u0132\3\2\2\2\u0133\u0134\3\2\2"+
		"\2\u0134\u0135\3\2\2\2\u0135\u0136\7\b\2\2\u0136\r\3\2\2\2\u0137\u0143"+
		"\5\4\3\2\u0138\u013c\7\3\2\2\u0139\u013a\5\4\3\2\u013a\u013b\7&\2\2\u013b"+
		"\u013d\3\2\2\2\u013c\u0139\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013c\3\2"+
		"\2\2\u013e\u013f\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141\7\4\2\2\u0141"+
		"\u0143\3\2\2\2\u0142\u0137\3\2\2\2\u0142\u0138\3\2\2\2\u0143\17\3\2\2"+
		"\2*\25$\'\659GKSY]bfimrvz\u0098\u009c\u009f\u00ab\u00af\u00b1\u00e2\u00e5"+
		"\u00ee\u00f2\u00f5\u0102\u010d\u0110\u0113\u0115\u011e\u0121\u012a\u0130"+
		"\u0133\u013e\u0142";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}