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
		RULE_else_ = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"module", "instruction", "expression", "inheritance", "else_"
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
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				instruction();
				setState(11);
				match(SEMICOLON);
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << UNDERSCORE) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0) );
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
			setState(17);
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
		public List<TerminalNode> BEGIN() { return getTokens(LokiParser.BEGIN); }
		public TerminalNode BEGIN(int i) {
			return getToken(LokiParser.BEGIN, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(LokiParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LokiParser.SEMICOLON, i);
		}
		public List<TerminalNode> END() { return getTokens(LokiParser.END); }
		public TerminalNode END(int i) {
			return getToken(LokiParser.END, i);
		}
		public Else_Context else_() {
			return getRuleContext(Else_Context.class,0);
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
		public Token head;
		public TerminalNode BACKSLASH() { return getToken(LokiParser.BACKSLASH, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public TerminalNode COLON() { return getToken(LokiParser.COLON, 0); }
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(LokiParser.END, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(LokiParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(LokiParser.IDENTIFIER, i);
		}
		public TerminalNode UNDERSCORE() { return getToken(LokiParser.UNDERSCORE, 0); }
		public TerminalNode DOLLAR() { return getToken(LokiParser.DOLLAR, 0); }
		public InheritanceContext inheritance() {
			return getRuleContext(InheritanceContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(LokiParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LokiParser.SEMICOLON, i);
		}
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
		public TerminalNode SEMICOLON() { return getToken(LokiParser.SEMICOLON, 0); }
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(LokiParser.END, 0); }
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
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LokiParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LokiParser.COMMA, i);
		}
		public TerminalNode SEMICOLON() { return getToken(LokiParser.SEMICOLON, 0); }
		public TerminalNode END() { return getToken(LokiParser.END, 0); }
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
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LokiParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LokiParser.COMMA, i);
		}
		public TerminalNode SEMICOLON() { return getToken(LokiParser.SEMICOLON, 0); }
		public TerminalNode END() { return getToken(LokiParser.END, 0); }
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
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public TerminalNode SEMICOLON() { return getToken(LokiParser.SEMICOLON, 0); }
		public TerminalNode END() { return getToken(LokiParser.END, 0); }
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
		public List<TerminalNode> BEGIN() { return getTokens(LokiParser.BEGIN); }
		public TerminalNode BEGIN(int i) {
			return getToken(LokiParser.BEGIN, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(LokiParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LokiParser.SEMICOLON, i);
		}
		public List<TerminalNode> END() { return getTokens(LokiParser.END); }
		public TerminalNode END(int i) {
			return getToken(LokiParser.END, i);
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
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public TerminalNode SEMICOLON() { return getToken(LokiParser.SEMICOLON, 0); }
		public TerminalNode END() { return getToken(LokiParser.END, 0); }
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
		public List<TerminalNode> BEGIN() { return getTokens(LokiParser.BEGIN); }
		public TerminalNode BEGIN(int i) {
			return getToken(LokiParser.BEGIN, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(LokiParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LokiParser.SEMICOLON, i);
		}
		public List<TerminalNode> END() { return getTokens(LokiParser.END); }
		public TerminalNode END(int i) {
			return getToken(LokiParser.END, i);
		}
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
		public List<TerminalNode> BEGIN() { return getTokens(LokiParser.BEGIN); }
		public TerminalNode BEGIN(int i) {
			return getToken(LokiParser.BEGIN, i);
		}
		public List<TerminalNode> END() { return getTokens(LokiParser.END); }
		public TerminalNode END(int i) {
			return getToken(LokiParser.END, i);
		}
		public TerminalNode SEMICOLON() { return getToken(LokiParser.SEMICOLON, 0); }
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
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
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
		public TerminalNode END() { return getToken(LokiParser.END, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LokiParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LokiParser.COMMA, i);
		}
		public TerminalNode SEMICOLON() { return getToken(LokiParser.SEMICOLON, 0); }
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
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public TerminalNode SEMICOLON() { return getToken(LokiParser.SEMICOLON, 0); }
		public TerminalNode END() { return getToken(LokiParser.END, 0); }
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
		public List<TerminalNode> SEMICOLON() { return getTokens(LokiParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LokiParser.SEMICOLON, i);
		}
		public List<TerminalNode> END() { return getTokens(LokiParser.END); }
		public TerminalNode END(int i) {
			return getToken(LokiParser.END, i);
		}
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
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
		public TerminalNode MINUS() { return getToken(LokiParser.MINUS, 0); }
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
			setState(278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				_localctx = new ExpressionGroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(20);
				match(LEFT_PARENTHESIS);
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(21);
					match(BEGIN);
					}
				}

				setState(24);
				expression(0);
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(25);
					match(SEMICOLON);
					}
				}

				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(28);
					match(END);
					}
				}

				setState(31);
				match(RIGHT_PARENTHESIS);
				}
				break;
			case 2:
				{
				_localctx = new ArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(33);
				match(LEFT_BRACKET);
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << UNDERSCORE) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0)) {
					{
					setState(34);
					expression(0);
					setState(39);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(35);
						match(COMMA);
						setState(36);
						expression(0);
						}
						}
						setState(41);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(44);
				match(RIGHT_BRACKET);
				}
				break;
			case 3:
				{
				_localctx = new MapContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45);
				match(LEFT_BRACKET);
				setState(82);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					{
					setState(46);
					match(BEGIN);
					setState(47);
					expression(0);
					setState(48);
					match(RIGHT_THIN_ARROW);
					setState(49);
					expression(0);
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(50);
						match(COMMA);
						setState(51);
						expression(0);
						setState(52);
						match(RIGHT_THIN_ARROW);
						setState(53);
						expression(0);
						}
						}
						setState(59);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(60);
						match(SEMICOLON);
						}
					}

					setState(63);
					match(END);
					}
					}
					break;
				case 2:
					{
					{
					setState(65);
					expression(0);
					setState(66);
					match(RIGHT_THIN_ARROW);
					setState(67);
					expression(0);
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(68);
						match(COMMA);
						setState(69);
						expression(0);
						setState(70);
						match(RIGHT_THIN_ARROW);
						setState(71);
						expression(0);
						}
						}
						setState(77);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(78);
						match(SEMICOLON);
						}
					}

					}
					}
					break;
				case 3:
					{
					{
					setState(81);
					match(MINUS);
					}
					}
					break;
				}
				setState(84);
				match(RIGHT_BRACKET);
				setState(86);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(85);
					match(SEMICOLON);
					}
					break;
				}
				setState(89);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(88);
					match(END);
					}
					break;
				}
				}
				break;
			case 4:
				{
				_localctx = new ObjectContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				match(LEFT_BRACKET);
				setState(130);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BEGIN:
					{
					{
					setState(92);
					match(BEGIN);
					setState(93);
					expression(0);
					setState(94);
					match(RIGHT_THICK_ARROW);
					setState(95);
					expression(0);
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(96);
						match(COMMA);
						setState(97);
						expression(0);
						setState(98);
						match(RIGHT_THICK_ARROW);
						setState(99);
						expression(0);
						}
						}
						setState(105);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(106);
						match(SEMICOLON);
						}
					}

					setState(109);
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
				case LEFT_PARENTHESIS:
				case LEFT_BRACKET:
				case RIGHT_BRACKET:
				case ACUTE:
					{
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << UNDERSCORE) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0)) {
						{
						setState(111);
						expression(0);
						setState(112);
						match(RIGHT_THICK_ARROW);
						setState(113);
						expression(0);
						setState(121);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(114);
							match(COMMA);
							setState(115);
							expression(0);
							setState(116);
							match(RIGHT_THICK_ARROW);
							setState(117);
							expression(0);
							}
							}
							setState(123);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(125);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(124);
							match(SEMICOLON);
							}
						}

						}
					}

					}
					break;
				case EQUALS:
					{
					setState(129);
					match(EQUALS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(132);
				match(RIGHT_BRACKET);
				}
				break;
			case 5:
				{
				_localctx = new HostContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
				match(DOLLAR);
				}
				break;
			case 6:
				{
				_localctx = new ThisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
				match(AT);
				}
				break;
			case 7:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				match(CHARACTERS);
				}
				break;
			case 8:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				match(ACUTE);
				setState(137);
				match(IDENTIFIER);
				}
				break;
			case 9:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(138);
				match(FLOAT);
				}
				break;
			case 10:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				match(INT);
				}
				break;
			case 11:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
				case UNDERSCORE:
				case DOLLAR:
					{
					{
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==DOLLAR) {
						{
						setState(140);
						match(DOLLAR);
						}
					}

					setState(143);
					((UnitContext)_localctx).head = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==IDENTIFIER || _la==UNDERSCORE) ) {
						((UnitContext)_localctx).head = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==IDENTIFIER) {
						{
						{
						setState(144);
						match(IDENTIFIER);
						}
						}
						setState(149);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==DOUBLE_COLON) {
						{
						setState(150);
						inheritance();
						}
					}

					setState(153);
					match(COLON);
					}
					}
					break;
				case BACKSLASH:
					{
					setState(154);
					match(BACKSLASH);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(168);
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
				case LEFT_PARENTHESIS:
				case LEFT_BRACKET:
				case ACUTE:
					{
					setState(157);
					instruction();
					}
					break;
				case BEGIN:
					{
					{
					setState(158);
					match(BEGIN);
					setState(162); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(159);
						instruction();
						setState(160);
						match(SEMICOLON);
						}
						}
						setState(164); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << UNDERSCORE) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0) );
					setState(166);
					match(END);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 12:
				{
				_localctx = new SuperHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(170);
				match(DOLLAR);
				setState(171);
				match(DOLLAR);
				setState(172);
				match(IDENTIFIER);
				}
				break;
			case 13:
				{
				_localctx = new HostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(173);
				match(DOLLAR);
				setState(174);
				match(IDENTIFIER);
				}
				break;
			case 14:
				{
				_localctx = new VariableOrParameterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175);
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
				setState(176);
				((UnaryOperationContext)_localctx).operator = match(MINUS);
				setState(177);
				expression(21);
				}
				break;
			case 16:
				{
				_localctx = new UnaryOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				((UnaryOperationContext)_localctx).operator = match(BANG);
				setState(179);
				expression(20);
				}
				break;
			case 17:
				{
				_localctx = new AssignHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				match(DOLLAR);
				setState(181);
				match(IDENTIFIER);
				setState(182);
				match(EQUALS);
				setState(183);
				expression(13);
				}
				break;
			case 18:
				{
				_localctx = new AssignHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				match(DOLLAR);
				setState(185);
				match(IDENTIFIER);
				setState(186);
				match(EQUALS);
				setState(187);
				match(BEGIN);
				setState(188);
				expression(0);
				setState(189);
				match(SEMICOLON);
				setState(190);
				match(END);
				}
				break;
			case 19:
				{
				_localctx = new AssignVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(IDENTIFIER);
				setState(193);
				match(EQUALS);
				setState(194);
				expression(11);
				}
				break;
			case 20:
				{
				_localctx = new AssignVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(IDENTIFIER);
				setState(196);
				match(EQUALS);
				setState(197);
				match(BEGIN);
				setState(198);
				expression(0);
				setState(199);
				match(SEMICOLON);
				setState(200);
				match(END);
				}
				break;
			case 21:
				{
				_localctx = new IfElseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				match(IF);
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(203);
					match(BEGIN);
					}
				}

				setState(206);
				expression(0);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(207);
					match(SEMICOLON);
					}
				}

				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(210);
					match(END);
					}
				}

				setState(213);
				match(COLON);
				setState(214);
				instruction();
				setState(216);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(215);
					else_();
					}
					break;
				}
				}
				break;
			case 22:
				{
				_localctx = new IfElseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218);
				match(IF);
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(219);
					match(BEGIN);
					}
				}

				setState(222);
				expression(0);
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(223);
					match(SEMICOLON);
					}
				}

				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(226);
					match(END);
					}
				}

				setState(229);
				match(COLON);
				setState(230);
				match(BEGIN);
				setState(234); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(231);
					instruction();
					setState(232);
					match(SEMICOLON);
					}
					}
					setState(236); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << UNDERSCORE) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0) );
				setState(238);
				match(END);
				setState(240);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(239);
					else_();
					}
					break;
				}
				}
				break;
			case 23:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(242);
				match(WHILE);
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(243);
					match(BEGIN);
					}
				}

				setState(246);
				expression(0);
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(247);
					match(SEMICOLON);
					}
				}

				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(250);
					match(END);
					}
				}

				setState(253);
				match(COLON);
				setState(254);
				instruction();
				}
				break;
			case 24:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(256);
				match(WHILE);
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(257);
					match(BEGIN);
					}
				}

				setState(260);
				expression(0);
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(261);
					match(SEMICOLON);
					}
				}

				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(264);
					match(END);
					}
				}

				setState(267);
				match(COLON);
				setState(268);
				match(BEGIN);
				setState(272); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(269);
					instruction();
					setState(270);
					match(SEMICOLON);
					}
					}
					setState(274); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << UNDERSCORE) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0) );
				setState(276);
				match(END);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(446);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(444);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(280);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(281);
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
						setState(282);
						expression(20);
						}
						break;
					case 2:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(283);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(284);
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
						setState(285);
						expression(19);
						}
						break;
					case 3:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(286);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(287);
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
						setState(288);
						expression(18);
						}
						break;
					case 4:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(289);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(290);
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
						setState(291);
						expression(17);
						}
						break;
					case 5:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(292);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(293);
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
						setState(294);
						expression(16);
						}
						break;
					case 6:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(295);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(296);
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
						setState(297);
						expression(15);
						}
						break;
					case 7:
						{
						_localctx = new AssignMemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(298);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(299);
						match(DOT);
						setState(300);
						match(IDENTIFIER);
						setState(301);
						match(EQUALS);
						setState(302);
						expression(10);
						}
						break;
					case 8:
						{
						_localctx = new AssignIndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(303);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(304);
						match(LEFT_BRACKET);
						setState(306);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(305);
							match(BEGIN);
							}
						}

						setState(308);
						expression(0);
						setState(310);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(309);
							match(END);
							}
						}

						setState(312);
						match(RIGHT_BRACKET);
						setState(313);
						match(EQUALS);
						setState(314);
						expression(8);
						}
						break;
					case 9:
						{
						_localctx = new MemberCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(316);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(317);
						match(DOT);
						setState(318);
						match(IDENTIFIER);
						setState(319);
						match(LEFT_PARENTHESIS);
						setState(320);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 10:
						{
						_localctx = new MemberCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(321);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(322);
						match(DOT);
						setState(323);
						match(IDENTIFIER);
						setState(324);
						match(LEFT_PARENTHESIS);
						setState(326);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(325);
							match(BEGIN);
							}
						}

						setState(328);
						expression(0);
						setState(333);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(329);
							match(COMMA);
							setState(330);
							expression(0);
							}
							}
							setState(335);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(337);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(336);
							match(SEMICOLON);
							}
						}

						setState(340);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(339);
							match(END);
							}
						}

						setState(342);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 11:
						{
						_localctx = new MemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(344);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(345);
						match(DOT);
						setState(346);
						match(IDENTIFIER);
						}
						break;
					case 12:
						{
						_localctx = new IndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(347);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(348);
						match(LEFT_BRACKET);
						setState(350);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(349);
							match(BEGIN);
							}
						}

						setState(352);
						expression(0);
						setState(354);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(353);
							match(SEMICOLON);
							}
						}

						setState(357);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(356);
							match(END);
							}
						}

						setState(359);
						match(RIGHT_BRACKET);
						}
						break;
					case 13:
						{
						_localctx = new MemberAccessorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(361);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(362);
						match(DOLLAR);
						setState(363);
						match(LEFT_BRACKET);
						setState(370);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case BEGIN:
							{
							{
							setState(364);
							match(BEGIN);
							setState(365);
							expression(0);
							setState(366);
							match(SEMICOLON);
							setState(367);
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
						case LEFT_PARENTHESIS:
						case LEFT_BRACKET:
						case ACUTE:
							{
							setState(369);
							expression(0);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(372);
						match(RIGHT_BRACKET);
						}
						break;
					case 14:
						{
						_localctx = new CallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(374);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(375);
						match(LEFT_PARENTHESIS);
						setState(376);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 15:
						{
						_localctx = new CallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(377);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(378);
						match(LEFT_PARENTHESIS);
						setState(380);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(379);
							match(BEGIN);
							}
						}

						setState(382);
						expression(0);
						setState(387);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(383);
							match(COMMA);
							setState(384);
							expression(0);
							}
							}
							setState(389);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(391);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(390);
							match(SEMICOLON);
							}
						}

						setState(394);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(393);
							match(END);
							}
						}

						setState(396);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 16:
						{
						_localctx = new AssignMemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(398);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(399);
						match(DOT);
						setState(400);
						match(IDENTIFIER);
						setState(401);
						match(EQUALS);
						setState(402);
						match(SEMICOLON);
						setState(403);
						match(BEGIN);
						setState(404);
						expression(0);
						setState(405);
						match(END);
						}
						break;
					case 17:
						{
						_localctx = new AssignIndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(407);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(408);
						match(LEFT_BRACKET);
						setState(410);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(409);
							match(BEGIN);
							}
						}

						setState(412);
						expression(0);
						setState(414);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(413);
							match(END);
							}
						}

						setState(416);
						match(RIGHT_BRACKET);
						setState(417);
						match(EQUALS);
						setState(418);
						match(BEGIN);
						setState(419);
						expression(0);
						setState(420);
						match(SEMICOLON);
						setState(421);
						match(END);
						}
						break;
					case 18:
						{
						_localctx = new AssignMemberAccessorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(423);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(424);
						match(DOLLAR);
						setState(425);
						match(LEFT_BRACKET);
						setState(432);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case BEGIN:
							{
							{
							setState(426);
							match(BEGIN);
							setState(427);
							expression(0);
							setState(428);
							match(SEMICOLON);
							setState(429);
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
						case LEFT_PARENTHESIS:
						case LEFT_BRACKET:
						case ACUTE:
							{
							setState(431);
							expression(0);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(434);
						match(RIGHT_BRACKET);
						setState(435);
						match(EQUALS);
						setState(442);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
						case 1:
							{
							{
							setState(436);
							match(BEGIN);
							setState(437);
							expression(0);
							setState(438);
							match(SEMICOLON);
							setState(439);
							match(END);
							}
							}
							break;
						case 2:
							{
							setState(441);
							expression(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(448);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
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
			setState(461);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(449);
				match(DOUBLE_COLON);
				setState(450);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(451);
				match(DOUBLE_COLON);
				setState(455); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(452);
						expression(0);
						setState(453);
						match(COMMA);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(457); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(459);
				expression(0);
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
			setState(476);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(463);
				match(ELSE);
				setState(464);
				match(BEGIN);
				setState(468); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(465);
					instruction();
					setState(466);
					match(SEMICOLON);
					}
					}
					setState(470); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << UNDERSCORE) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0) );
				setState(472);
				match(END);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(474);
				match(ELSE);
				setState(475);
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
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 18);
		case 2:
			return precpred(_ctx, 17);
		case 3:
			return precpred(_ctx, 16);
		case 4:
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 31);
		case 9:
			return precpred(_ctx, 30);
		case 10:
			return precpred(_ctx, 26);
		case 11:
			return precpred(_ctx, 25);
		case 12:
			return precpred(_ctx, 24);
		case 13:
			return precpred(_ctx, 23);
		case 14:
			return precpred(_ctx, 22);
		case 15:
			return precpred(_ctx, 8);
		case 16:
			return precpred(_ctx, 6);
		case 17:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u01e1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\6\2\20\n\2\r\2\16\2\21\3\3"+
		"\3\3\3\4\3\4\3\4\5\4\31\n\4\3\4\3\4\5\4\35\n\4\3\4\5\4 \n\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\7\4(\n\4\f\4\16\4+\13\4\5\4-\n\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\7\4:\n\4\f\4\16\4=\13\4\3\4\5\4@\n\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4L\n\4\f\4\16\4O\13\4\3\4\5\4R\n\4\3"+
		"\4\5\4U\n\4\3\4\3\4\5\4Y\n\4\3\4\5\4\\\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\7\4h\n\4\f\4\16\4k\13\4\3\4\5\4n\n\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\7\4z\n\4\f\4\16\4}\13\4\3\4\5\4\u0080\n\4\5\4\u0082"+
		"\n\4\3\4\5\4\u0085\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0090\n"+
		"\4\3\4\3\4\7\4\u0094\n\4\f\4\16\4\u0097\13\4\3\4\5\4\u009a\n\4\3\4\3\4"+
		"\5\4\u009e\n\4\3\4\3\4\3\4\3\4\3\4\6\4\u00a5\n\4\r\4\16\4\u00a6\3\4\3"+
		"\4\5\4\u00ab\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4\u00cf\n\4\3\4\3\4\5\4\u00d3\n\4\3\4\5\4\u00d6\n\4\3\4"+
		"\3\4\3\4\5\4\u00db\n\4\3\4\3\4\5\4\u00df\n\4\3\4\3\4\5\4\u00e3\n\4\3\4"+
		"\5\4\u00e6\n\4\3\4\3\4\3\4\3\4\3\4\6\4\u00ed\n\4\r\4\16\4\u00ee\3\4\3"+
		"\4\5\4\u00f3\n\4\3\4\3\4\5\4\u00f7\n\4\3\4\3\4\5\4\u00fb\n\4\3\4\5\4\u00fe"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\5\4\u0105\n\4\3\4\3\4\5\4\u0109\n\4\3\4\5\4\u010c"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\6\4\u0113\n\4\r\4\16\4\u0114\3\4\3\4\5\4\u0119"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0135\n\4\3\4\3\4\5\4\u0139"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0149"+
		"\n\4\3\4\3\4\3\4\7\4\u014e\n\4\f\4\16\4\u0151\13\4\3\4\5\4\u0154\n\4\3"+
		"\4\5\4\u0157\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0161\n\4\3\4\3\4"+
		"\5\4\u0165\n\4\3\4\5\4\u0168\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4\u0175\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u017f\n\4\3\4"+
		"\3\4\3\4\7\4\u0184\n\4\f\4\16\4\u0187\13\4\3\4\5\4\u018a\n\4\3\4\5\4\u018d"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u019d"+
		"\n\4\3\4\3\4\5\4\u01a1\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4\u01b3\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"\u01bd\n\4\7\4\u01bf\n\4\f\4\16\4\u01c2\13\4\3\5\3\5\3\5\3\5\3\5\3\5\6"+
		"\5\u01ca\n\5\r\5\16\5\u01cb\3\5\3\5\5\5\u01d0\n\5\3\6\3\6\3\6\3\6\3\6"+
		"\6\6\u01d7\n\6\r\6\16\6\u01d8\3\6\3\6\3\6\3\6\5\6\u01df\n\6\3\6\2\3\6"+
		"\7\2\4\6\b\n\2\t\3\2\b\t\3\2\21\22\3\2\17\20\3\2\24\25\3\2\26\31\3\2\32"+
		"\32\3\2\33\33\2\u0246\2\17\3\2\2\2\4\23\3\2\2\2\6\u0118\3\2\2\2\b\u01cf"+
		"\3\2\2\2\n\u01de\3\2\2\2\f\r\5\4\3\2\r\16\7&\2\2\16\20\3\2\2\2\17\f\3"+
		"\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\3\3\2\2\2\23\24\5"+
		"\6\4\2\24\5\3\2\2\2\25\26\b\4\1\2\26\30\7\'\2\2\27\31\7\3\2\2\30\27\3"+
		"\2\2\2\30\31\3\2\2\2\31\32\3\2\2\2\32\34\5\6\4\2\33\35\7&\2\2\34\33\3"+
		"\2\2\2\34\35\3\2\2\2\35\37\3\2\2\2\36 \7\4\2\2\37\36\3\2\2\2\37 \3\2\2"+
		"\2 !\3\2\2\2!\"\7(\2\2\"\u0119\3\2\2\2#,\7)\2\2$)\5\6\4\2%&\7!\2\2&(\5"+
		"\6\4\2\'%\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*-\3\2\2\2+)\3\2\2\2,"+
		"$\3\2\2\2,-\3\2\2\2-.\3\2\2\2.\u0119\7*\2\2/T\7)\2\2\60\61\7\3\2\2\61"+
		"\62\5\6\4\2\62\63\7$\2\2\63;\5\6\4\2\64\65\7!\2\2\65\66\5\6\4\2\66\67"+
		"\7$\2\2\678\5\6\4\28:\3\2\2\29\64\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2"+
		"\2<?\3\2\2\2=;\3\2\2\2>@\7&\2\2?>\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7\4\2"+
		"\2BU\3\2\2\2CD\5\6\4\2DE\7$\2\2EM\5\6\4\2FG\7!\2\2GH\5\6\4\2HI\7$\2\2"+
		"IJ\5\6\4\2JL\3\2\2\2KF\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NQ\3\2\2\2"+
		"OM\3\2\2\2PR\7&\2\2QP\3\2\2\2QR\3\2\2\2RU\3\2\2\2SU\7\20\2\2T\60\3\2\2"+
		"\2TC\3\2\2\2TS\3\2\2\2UV\3\2\2\2VX\7*\2\2WY\7&\2\2XW\3\2\2\2XY\3\2\2\2"+
		"Y[\3\2\2\2Z\\\7\4\2\2[Z\3\2\2\2[\\\3\2\2\2\\\u0119\3\2\2\2]\u0084\7)\2"+
		"\2^_\7\3\2\2_`\5\6\4\2`a\7%\2\2ai\5\6\4\2bc\7!\2\2cd\5\6\4\2de\7%\2\2"+
		"ef\5\6\4\2fh\3\2\2\2gb\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jm\3\2\2\2"+
		"ki\3\2\2\2ln\7&\2\2ml\3\2\2\2mn\3\2\2\2no\3\2\2\2op\7\4\2\2p\u0085\3\2"+
		"\2\2qr\5\6\4\2rs\7%\2\2s{\5\6\4\2tu\7!\2\2uv\5\6\4\2vw\7%\2\2wx\5\6\4"+
		"\2xz\3\2\2\2yt\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\177\3\2\2\2}{\3"+
		"\2\2\2~\u0080\7&\2\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2"+
		"\2\u0081q\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0085"+
		"\7\37\2\2\u0084^\3\2\2\2\u0084\u0081\3\2\2\2\u0084\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0119\7*\2\2\u0087\u0119\7\n\2\2\u0088\u0119\7\13"+
		"\2\2\u0089\u0119\7\f\2\2\u008a\u008b\7-\2\2\u008b\u0119\7\b\2\2\u008c"+
		"\u0119\7\r\2\2\u008d\u0119\7\16\2\2\u008e\u0090\7\n\2\2\u008f\u008e\3"+
		"\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0095\t\2\2\2\u0092"+
		"\u0094\7\b\2\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0098"+
		"\u009a\5\b\5\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2"+
		"\2\2\u009b\u009e\7#\2\2\u009c\u009e\7\23\2\2\u009d\u008f\3\2\2\2\u009d"+
		"\u009c\3\2\2\2\u009e\u00aa\3\2\2\2\u009f\u00ab\5\4\3\2\u00a0\u00a4\7\3"+
		"\2\2\u00a1\u00a2\5\4\3\2\u00a2\u00a3\7&\2\2\u00a3\u00a5\3\2\2\2\u00a4"+
		"\u00a1\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\7\4\2\2\u00a9\u00ab\3\2\2\2\u00aa"+
		"\u009f\3\2\2\2\u00aa\u00a0\3\2\2\2\u00ab\u0119\3\2\2\2\u00ac\u00ad\7\n"+
		"\2\2\u00ad\u00ae\7\n\2\2\u00ae\u0119\7\b\2\2\u00af\u00b0\7\n\2\2\u00b0"+
		"\u0119\7\b\2\2\u00b1\u0119\t\2\2\2\u00b2\u00b3\7\20\2\2\u00b3\u0119\5"+
		"\6\4\27\u00b4\u00b5\7\34\2\2\u00b5\u0119\5\6\4\26\u00b6\u00b7\7\n\2\2"+
		"\u00b7\u00b8\7\b\2\2\u00b8\u00b9\7\37\2\2\u00b9\u0119\5\6\4\17\u00ba\u00bb"+
		"\7\n\2\2\u00bb\u00bc\7\b\2\2\u00bc\u00bd\7\37\2\2\u00bd\u00be\7\3\2\2"+
		"\u00be\u00bf\5\6\4\2\u00bf\u00c0\7&\2\2\u00c0\u00c1\7\4\2\2\u00c1\u0119"+
		"\3\2\2\2\u00c2\u00c3\7\b\2\2\u00c3\u00c4\7\37\2\2\u00c4\u0119\5\6\4\r"+
		"\u00c5\u00c6\7\b\2\2\u00c6\u00c7\7\37\2\2\u00c7\u00c8\7\3\2\2\u00c8\u00c9"+
		"\5\6\4\2\u00c9\u00ca\7&\2\2\u00ca\u00cb\7\4\2\2\u00cb\u0119\3\2\2\2\u00cc"+
		"\u00ce\7\5\2\2\u00cd\u00cf\7\3\2\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2"+
		"\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\5\6\4\2\u00d1\u00d3\7&\2\2\u00d2"+
		"\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d6\7\4"+
		"\2\2\u00d5\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7"+
		"\u00d8\7#\2\2\u00d8\u00da\5\4\3\2\u00d9\u00db\5\n\6\2\u00da\u00d9\3\2"+
		"\2\2\u00da\u00db\3\2\2\2\u00db\u0119\3\2\2\2\u00dc\u00de\7\5\2\2\u00dd"+
		"\u00df\7\3\2\2\u00de\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\3\2"+
		"\2\2\u00e0\u00e2\5\6\4\2\u00e1\u00e3\7&\2\2\u00e2\u00e1\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e6\7\4\2\2\u00e5\u00e4\3\2"+
		"\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\7#\2\2\u00e8"+
		"\u00ec\7\3\2\2\u00e9\u00ea\5\4\3\2\u00ea\u00eb\7&\2\2\u00eb\u00ed\3\2"+
		"\2\2\u00ec\u00e9\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\7\4\2\2\u00f1\u00f3\5\n"+
		"\6\2\u00f2\u00f1\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u0119\3\2\2\2\u00f4"+
		"\u00f6\7\7\2\2\u00f5\u00f7\7\3\2\2\u00f6\u00f5\3\2\2\2\u00f6\u00f7\3\2"+
		"\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\5\6\4\2\u00f9\u00fb\7&\2\2\u00fa"+
		"\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fe\7\4"+
		"\2\2\u00fd\u00fc\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff"+
		"\u0100\7#\2\2\u0100\u0101\5\4\3\2\u0101\u0119\3\2\2\2\u0102\u0104\7\7"+
		"\2\2\u0103\u0105\7\3\2\2\u0104\u0103\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\u0108\5\6\4\2\u0107\u0109\7&\2\2\u0108\u0107\3\2"+
		"\2\2\u0108\u0109\3\2\2\2\u0109\u010b\3\2\2\2\u010a\u010c\7\4\2\2\u010b"+
		"\u010a\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\7#"+
		"\2\2\u010e\u0112\7\3\2\2\u010f\u0110\5\4\3\2\u0110\u0111\7&\2\2\u0111"+
		"\u0113\3\2\2\2\u0112\u010f\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0112\3\2"+
		"\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\7\4\2\2\u0117"+
		"\u0119\3\2\2\2\u0118\25\3\2\2\2\u0118#\3\2\2\2\u0118/\3\2\2\2\u0118]\3"+
		"\2\2\2\u0118\u0087\3\2\2\2\u0118\u0088\3\2\2\2\u0118\u0089\3\2\2\2\u0118"+
		"\u008a\3\2\2\2\u0118\u008c\3\2\2\2\u0118\u008d\3\2\2\2\u0118\u009d\3\2"+
		"\2\2\u0118\u00ac\3\2\2\2\u0118\u00af\3\2\2\2\u0118\u00b1\3\2\2\2\u0118"+
		"\u00b2\3\2\2\2\u0118\u00b4\3\2\2\2\u0118\u00b6\3\2\2\2\u0118\u00ba\3\2"+
		"\2\2\u0118\u00c2\3\2\2\2\u0118\u00c5\3\2\2\2\u0118\u00cc\3\2\2\2\u0118"+
		"\u00dc\3\2\2\2\u0118\u00f4\3\2\2\2\u0118\u0102\3\2\2\2\u0119\u01c0\3\2"+
		"\2\2\u011a\u011b\f\25\2\2\u011b\u011c\t\3\2\2\u011c\u01bf\5\6\4\26\u011d"+
		"\u011e\f\24\2\2\u011e\u011f\t\4\2\2\u011f\u01bf\5\6\4\25\u0120\u0121\f"+
		"\23\2\2\u0121\u0122\t\5\2\2\u0122\u01bf\5\6\4\24\u0123\u0124\f\22\2\2"+
		"\u0124\u0125\t\6\2\2\u0125\u01bf\5\6\4\23\u0126\u0127\f\21\2\2\u0127\u0128"+
		"\t\7\2\2\u0128\u01bf\5\6\4\22\u0129\u012a\f\20\2\2\u012a\u012b\t\b\2\2"+
		"\u012b\u01bf\5\6\4\21\u012c\u012d\f\13\2\2\u012d\u012e\7 \2\2\u012e\u012f"+
		"\7\b\2\2\u012f\u0130\7\37\2\2\u0130\u01bf\5\6\4\f\u0131\u0132\f\t\2\2"+
		"\u0132\u0134\7)\2\2\u0133\u0135\7\3\2\2\u0134\u0133\3\2\2\2\u0134\u0135"+
		"\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0138\5\6\4\2\u0137\u0139\7\4\2\2\u0138"+
		"\u0137\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013b\7*"+
		"\2\2\u013b\u013c\7\37\2\2\u013c\u013d\5\6\4\n\u013d\u01bf\3\2\2\2\u013e"+
		"\u013f\f!\2\2\u013f\u0140\7 \2\2\u0140\u0141\7\b\2\2\u0141\u0142\7\'\2"+
		"\2\u0142\u01bf\7(\2\2\u0143\u0144\f \2\2\u0144\u0145\7 \2\2\u0145\u0146"+
		"\7\b\2\2\u0146\u0148\7\'\2\2\u0147\u0149\7\3\2\2\u0148\u0147\3\2\2\2\u0148"+
		"\u0149\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014f\5\6\4\2\u014b\u014c\7!"+
		"\2\2\u014c\u014e\5\6\4\2\u014d\u014b\3\2\2\2\u014e\u0151\3\2\2\2\u014f"+
		"\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2"+
		"\2\2\u0152\u0154\7&\2\2\u0153\u0152\3\2\2\2\u0153\u0154\3\2\2\2\u0154"+
		"\u0156\3\2\2\2\u0155\u0157\7\4\2\2\u0156\u0155\3\2\2\2\u0156\u0157\3\2"+
		"\2\2\u0157\u0158\3\2\2\2\u0158\u0159\7(\2\2\u0159\u01bf\3\2\2\2\u015a"+
		"\u015b\f\34\2\2\u015b\u015c\7 \2\2\u015c\u01bf\7\b\2\2\u015d\u015e\f\33"+
		"\2\2\u015e\u0160\7)\2\2\u015f\u0161\7\3\2\2\u0160\u015f\3\2\2\2\u0160"+
		"\u0161\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0164\5\6\4\2\u0163\u0165\7&"+
		"\2\2\u0164\u0163\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0167\3\2\2\2\u0166"+
		"\u0168\7\4\2\2\u0167\u0166\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0169\3\2"+
		"\2\2\u0169\u016a\7*\2\2\u016a\u01bf\3\2\2\2\u016b\u016c\f\32\2\2\u016c"+
		"\u016d\7\n\2\2\u016d\u0174\7)\2\2\u016e\u016f\7\3\2\2\u016f\u0170\5\6"+
		"\4\2\u0170\u0171\7&\2\2\u0171\u0172\7\4\2\2\u0172\u0175\3\2\2\2\u0173"+
		"\u0175\5\6\4\2\u0174\u016e\3\2\2\2\u0174\u0173\3\2\2\2\u0175\u0176\3\2"+
		"\2\2\u0176\u0177\7*\2\2\u0177\u01bf\3\2\2\2\u0178\u0179\f\31\2\2\u0179"+
		"\u017a\7\'\2\2\u017a\u01bf\7(\2\2\u017b\u017c\f\30\2\2\u017c\u017e\7\'"+
		"\2\2\u017d\u017f\7\3\2\2\u017e\u017d\3\2\2\2\u017e\u017f\3\2\2\2\u017f"+
		"\u0180\3\2\2\2\u0180\u0185\5\6\4\2\u0181\u0182\7!\2\2\u0182\u0184\5\6"+
		"\4\2\u0183\u0181\3\2\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185"+
		"\u0186\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u018a\7&"+
		"\2\2\u0189\u0188\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018c\3\2\2\2\u018b"+
		"\u018d\7\4\2\2\u018c\u018b\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018e\3\2"+
		"\2\2\u018e\u018f\7(\2\2\u018f\u01bf\3\2\2\2\u0190\u0191\f\n\2\2\u0191"+
		"\u0192\7 \2\2\u0192\u0193\7\b\2\2\u0193\u0194\7\37\2\2\u0194\u0195\7&"+
		"\2\2\u0195\u0196\7\3\2\2\u0196\u0197\5\6\4\2\u0197\u0198\7\4\2\2\u0198"+
		"\u01bf\3\2\2\2\u0199\u019a\f\b\2\2\u019a\u019c\7)\2\2\u019b\u019d\7\3"+
		"\2\2\u019c\u019b\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\3\2\2\2\u019e"+
		"\u01a0\5\6\4\2\u019f\u01a1\7\4\2\2\u01a0\u019f\3\2\2\2\u01a0\u01a1\3\2"+
		"\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3\7*\2\2\u01a3\u01a4\7\37\2\2\u01a4"+
		"\u01a5\7\3\2\2\u01a5\u01a6\5\6\4\2\u01a6\u01a7\7&\2\2\u01a7\u01a8\7\4"+
		"\2\2\u01a8\u01bf\3\2\2\2\u01a9\u01aa\f\7\2\2\u01aa\u01ab\7\n\2\2\u01ab"+
		"\u01b2\7)\2\2\u01ac\u01ad\7\3\2\2\u01ad\u01ae\5\6\4\2\u01ae\u01af\7&\2"+
		"\2\u01af\u01b0\7\4\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01b3\5\6\4\2\u01b2\u01ac"+
		"\3\2\2\2\u01b2\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\7*\2\2\u01b5"+
		"\u01bc\7\37\2\2\u01b6\u01b7\7\3\2\2\u01b7\u01b8\5\6\4\2\u01b8\u01b9\7"+
		"&\2\2\u01b9\u01ba\7\4\2\2\u01ba\u01bd\3\2\2\2\u01bb\u01bd\5\6\4\2\u01bc"+
		"\u01b6\3\2\2\2\u01bc\u01bb\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01bf\3\2"+
		"\2\2\u01be\u011a\3\2\2\2\u01be\u011d\3\2\2\2\u01be\u0120\3\2\2\2\u01be"+
		"\u0123\3\2\2\2\u01be\u0126\3\2\2\2\u01be\u0129\3\2\2\2\u01be\u012c\3\2"+
		"\2\2\u01be\u0131\3\2\2\2\u01be\u013e\3\2\2\2\u01be\u0143\3\2\2\2\u01be"+
		"\u015a\3\2\2\2\u01be\u015d\3\2\2\2\u01be\u016b\3\2\2\2\u01be\u0178\3\2"+
		"\2\2\u01be\u017b\3\2\2\2\u01be\u0190\3\2\2\2\u01be\u0199\3\2\2\2\u01be"+
		"\u01a9\3\2\2\2\u01bf\u01c2\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2"+
		"\2\2\u01c1\7\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c3\u01c4\7\"\2\2\u01c4\u01d0"+
		"\5\6\4\2\u01c5\u01c9\7\"\2\2\u01c6\u01c7\5\6\4\2\u01c7\u01c8\7!\2\2\u01c8"+
		"\u01ca\3\2\2\2\u01c9\u01c6\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01c9\3\2"+
		"\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01ce\5\6\4\2\u01ce"+
		"\u01d0\3\2\2\2\u01cf\u01c3\3\2\2\2\u01cf\u01c5\3\2\2\2\u01d0\t\3\2\2\2"+
		"\u01d1\u01d2\7\6\2\2\u01d2\u01d6\7\3\2\2\u01d3\u01d4\5\4\3\2\u01d4\u01d5"+
		"\7&\2\2\u01d5\u01d7\3\2\2\2\u01d6\u01d3\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8"+
		"\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\7\4"+
		"\2\2\u01db\u01df\3\2\2\2\u01dc\u01dd\7\6\2\2\u01dd\u01df\5\4\3\2\u01de"+
		"\u01d1\3\2\2\2\u01de\u01dc\3\2\2\2\u01df\13\3\2\2\2D\21\30\34\37),;?M"+
		"QTX[im{\177\u0081\u0084\u008f\u0095\u0099\u009d\u00a6\u00aa\u00ce\u00d2"+
		"\u00d5\u00da\u00de\u00e2\u00e5\u00ee\u00f2\u00f6\u00fa\u00fd\u0104\u0108"+
		"\u010b\u0114\u0118\u0134\u0138\u0148\u014f\u0153\u0156\u0160\u0164\u0167"+
		"\u0174\u017e\u0185\u0189\u018c\u019c\u01a0\u01b2\u01bc\u01be\u01c0\u01cb"+
		"\u01cf\u01d8\u01de";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}