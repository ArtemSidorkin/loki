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
		BEGIN=1, END=2, IF=3, ELSE=4, WHILE=5, IDENTIFIER=6, DOLLAR=7, AT=8, CHARACTERS=9, 
		FLOAT=10, INT=11, PLUS=12, MINUS=13, STAR=14, SLASH=15, BACKSLASH=16, 
		EQUALS_EQUALS=17, BANG_EQUALS=18, GREATER_THAN_EQUALS=19, GREATER_THAN=20, 
		LESS_THAN_EQUALS=21, LESS_THAN=22, AMPERSAND_AMPERSAND=23, PIPE_PIPE=24, 
		BANG=25, AMPERSAND=26, PIPE=27, EQUALS=28, DOT=29, COMMA=30, DOUBLE_COLON=31, 
		COLON=32, RIGHT_THIN_ARROW=33, RIGHT_THICK_ARROW=34, SEMICOLON=35, LEFT_PARENTHESIS=36, 
		RIGHT_PARENTHESIS=37, LEFT_BRACKET=38, RIGHT_BRACKET=39, LEFT_BRACE=40, 
		RIGHT_BRACE=41, ACUTE=42, IGNORE=43;
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
			null, null, null, "'if'", "'else'", "'while'", null, "'$'", "'@'", null, 
			null, null, "'+'", "'-'", "'*'", "'/'", "'\\'", "'=='", "'!='", "'>='", 
			"'>'", "'<='", "'<'", "'&&'", "'||'", "'!'", "'&'", "'|'", "'='", "'.'", 
			"','", "'::'", "':'", "'->'", "'=>'", "';'", "'('", "')'", "'['", "']'", 
			"'{'", "'}'", "'`'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BEGIN", "END", "IF", "ELSE", "WHILE", "IDENTIFIER", "DOLLAR", 
			"AT", "CHARACTERS", "FLOAT", "INT", "PLUS", "MINUS", "STAR", "SLASH", 
			"BACKSLASH", "EQUALS_EQUALS", "BANG_EQUALS", "GREATER_THAN_EQUALS", "GREATER_THAN", 
			"LESS_THAN_EQUALS", "LESS_THAN", "AMPERSAND_AMPERSAND", "PIPE_PIPE", 
			"BANG", "AMPERSAND", "PIPE", "EQUALS", "DOT", "COMMA", "DOUBLE_COLON", 
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0) );
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
		public TerminalNode LEFT_PARENTHESIS() { return getToken(LokiParser.LEFT_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(LokiParser.RIGHT_PARENTHESIS, 0); }
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
		public TerminalNode COLON() { return getToken(LokiParser.COLON, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(LokiParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(LokiParser.IDENTIFIER, i);
		}
		public TerminalNode BACKSLASH() { return getToken(LokiParser.BACKSLASH, 0); }
		public TerminalNode DOLLAR() { return getToken(LokiParser.DOLLAR, 0); }
		public InheritanceContext inheritance() {
			return getRuleContext(InheritanceContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(LokiParser.END, 0); }
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
		public TerminalNode LEFT_PARENTHESIS() { return getToken(LokiParser.LEFT_PARENTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(LokiParser.RIGHT_PARENTHESIS, 0); }
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
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode END() { return getToken(LokiParser.END, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LokiParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LokiParser.COMMA, i);
		}
		public TerminalNode SEMICOLON() { return getToken(LokiParser.SEMICOLON, 0); }
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
			setState(307);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
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
				setState(58);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BEGIN:
					{
					{
					setState(34);
					match(BEGIN);
					setState(35);
					expression(0);
					setState(40);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(36);
						match(COMMA);
						setState(37);
						expression(0);
						}
						}
						setState(42);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(44);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(43);
						match(SEMICOLON);
						}
					}

					setState(46);
					match(END);
					}
					}
					break;
				case IF:
				case WHILE:
				case IDENTIFIER:
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
					setState(56);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0)) {
						{
						setState(48);
						expression(0);
						setState(53);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(49);
							match(COMMA);
							setState(50);
							expression(0);
							}
							}
							setState(55);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(60);
				match(RIGHT_BRACKET);
				}
				break;
			case 3:
				{
				_localctx = new MapContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61);
				match(LEFT_BRACKET);
				setState(98);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					{
					setState(62);
					match(BEGIN);
					setState(63);
					expression(0);
					setState(64);
					match(RIGHT_THIN_ARROW);
					setState(65);
					expression(0);
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(66);
						match(COMMA);
						setState(67);
						expression(0);
						setState(68);
						match(RIGHT_THIN_ARROW);
						setState(69);
						expression(0);
						}
						}
						setState(75);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(76);
						match(SEMICOLON);
						}
					}

					setState(79);
					match(END);
					}
					}
					break;
				case 2:
					{
					{
					setState(81);
					expression(0);
					setState(82);
					match(RIGHT_THIN_ARROW);
					setState(83);
					expression(0);
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(84);
						match(COMMA);
						setState(85);
						expression(0);
						setState(86);
						match(RIGHT_THIN_ARROW);
						setState(87);
						expression(0);
						}
						}
						setState(93);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(94);
						match(SEMICOLON);
						}
					}

					}
					}
					break;
				case 3:
					{
					{
					setState(97);
					match(MINUS);
					}
					}
					break;
				}
				setState(100);
				match(RIGHT_BRACKET);
				setState(102);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(101);
					match(SEMICOLON);
					}
					break;
				}
				setState(105);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(104);
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
				setState(107);
				match(LEFT_BRACKET);
				setState(146);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BEGIN:
					{
					{
					setState(108);
					match(BEGIN);
					setState(109);
					expression(0);
					setState(110);
					match(RIGHT_THICK_ARROW);
					setState(111);
					expression(0);
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(112);
						match(COMMA);
						setState(113);
						expression(0);
						setState(114);
						match(RIGHT_THICK_ARROW);
						setState(115);
						expression(0);
						}
						}
						setState(121);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(122);
						match(SEMICOLON);
						}
					}

					setState(125);
					match(END);
					}
					}
					break;
				case IF:
				case WHILE:
				case IDENTIFIER:
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
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0)) {
						{
						setState(127);
						expression(0);
						setState(128);
						match(RIGHT_THICK_ARROW);
						setState(129);
						expression(0);
						setState(137);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(130);
							match(COMMA);
							setState(131);
							expression(0);
							setState(132);
							match(RIGHT_THICK_ARROW);
							setState(133);
							expression(0);
							}
							}
							setState(139);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(141);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(140);
							match(SEMICOLON);
							}
						}

						}
					}

					}
					break;
				case EQUALS:
					{
					setState(145);
					match(EQUALS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(148);
				match(RIGHT_BRACKET);
				}
				break;
			case 5:
				{
				_localctx = new HostContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				match(DOLLAR);
				}
				break;
			case 6:
				{
				_localctx = new ThisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				match(AT);
				}
				break;
			case 7:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				match(CHARACTERS);
				}
				break;
			case 8:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152);
				match(ACUTE);
				setState(153);
				match(IDENTIFIER);
				}
				break;
			case 9:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154);
				match(FLOAT);
				}
				break;
			case 10:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155);
				match(INT);
				}
				break;
			case 11:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(156);
					match(DOLLAR);
					}
				}

				setState(159);
				((UnitContext)_localctx).head = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==BACKSLASH) ) {
					((UnitContext)_localctx).head = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(160);
					match(IDENTIFIER);
					}
					}
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLE_COLON) {
					{
					setState(166);
					inheritance();
					}
				}

				setState(169);
				match(COLON);
				setState(170);
				instruction();
				}
				break;
			case 12:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(171);
					match(DOLLAR);
					}
				}

				setState(174);
				((UnitContext)_localctx).head = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==BACKSLASH) ) {
					((UnitContext)_localctx).head = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(175);
					match(IDENTIFIER);
					}
					}
					setState(180);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLE_COLON) {
					{
					setState(181);
					inheritance();
					}
				}

				setState(184);
				match(COLON);
				setState(185);
				match(BEGIN);
				setState(189); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(186);
					instruction();
					setState(187);
					match(SEMICOLON);
					}
					}
					setState(191); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0) );
				setState(193);
				match(END);
				}
				break;
			case 13:
				{
				_localctx = new SuperHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(DOLLAR);
				setState(196);
				match(DOLLAR);
				setState(197);
				match(IDENTIFIER);
				}
				break;
			case 14:
				{
				_localctx = new HostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				match(DOLLAR);
				setState(199);
				match(IDENTIFIER);
				}
				break;
			case 15:
				{
				_localctx = new VariableOrParameterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				match(IDENTIFIER);
				}
				break;
			case 16:
				{
				_localctx = new UnaryOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				((UnaryOperationContext)_localctx).operator = match(MINUS);
				setState(202);
				expression(21);
				}
				break;
			case 17:
				{
				_localctx = new UnaryOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				((UnaryOperationContext)_localctx).operator = match(BANG);
				setState(204);
				expression(20);
				}
				break;
			case 18:
				{
				_localctx = new AssignHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205);
				match(DOLLAR);
				setState(206);
				match(IDENTIFIER);
				setState(207);
				match(EQUALS);
				setState(208);
				expression(13);
				}
				break;
			case 19:
				{
				_localctx = new AssignHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				match(DOLLAR);
				setState(210);
				match(IDENTIFIER);
				setState(211);
				match(EQUALS);
				setState(212);
				match(BEGIN);
				setState(213);
				expression(0);
				setState(214);
				match(SEMICOLON);
				setState(215);
				match(END);
				}
				break;
			case 20:
				{
				_localctx = new AssignVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				match(IDENTIFIER);
				setState(218);
				match(EQUALS);
				setState(219);
				expression(11);
				}
				break;
			case 21:
				{
				_localctx = new AssignVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220);
				match(IDENTIFIER);
				setState(221);
				match(EQUALS);
				setState(222);
				match(BEGIN);
				setState(223);
				expression(0);
				setState(224);
				match(SEMICOLON);
				setState(225);
				match(END);
				}
				break;
			case 22:
				{
				_localctx = new IfElseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				match(IF);
				setState(228);
				match(LEFT_PARENTHESIS);
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(229);
					match(BEGIN);
					}
				}

				setState(232);
				expression(0);
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(233);
					match(SEMICOLON);
					}
				}

				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(236);
					match(END);
					}
				}

				setState(239);
				match(RIGHT_PARENTHESIS);
				setState(240);
				instruction();
				setState(242);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(241);
					else_();
					}
					break;
				}
				}
				break;
			case 23:
				{
				_localctx = new IfElseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244);
				match(IF);
				setState(245);
				match(LEFT_PARENTHESIS);
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(246);
					match(BEGIN);
					}
				}

				setState(249);
				expression(0);
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(250);
					match(SEMICOLON);
					}
				}

				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(253);
					match(END);
					}
				}

				setState(256);
				match(RIGHT_PARENTHESIS);
				setState(257);
				match(BEGIN);
				setState(261); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(258);
					instruction();
					setState(259);
					match(SEMICOLON);
					}
					}
					setState(263); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0) );
				setState(265);
				match(END);
				setState(267);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(266);
					else_();
					}
					break;
				}
				}
				break;
			case 24:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(269);
				match(WHILE);
				setState(270);
				match(LEFT_PARENTHESIS);
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(271);
					match(BEGIN);
					}
				}

				setState(274);
				expression(0);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(275);
					match(SEMICOLON);
					}
				}

				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(278);
					match(END);
					}
				}

				setState(281);
				match(RIGHT_PARENTHESIS);
				setState(282);
				instruction();
				}
				break;
			case 25:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(284);
				match(WHILE);
				setState(285);
				match(LEFT_PARENTHESIS);
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(286);
					match(BEGIN);
					}
				}

				setState(289);
				expression(0);
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(290);
					match(SEMICOLON);
					}
				}

				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(293);
					match(END);
					}
				}

				setState(296);
				match(RIGHT_PARENTHESIS);
				setState(297);
				match(BEGIN);
				setState(301); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(298);
					instruction();
					setState(299);
					match(SEMICOLON);
					}
					}
					setState(303); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0) );
				setState(305);
				match(END);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(475);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(473);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(309);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(310);
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
						setState(311);
						expression(20);
						}
						break;
					case 2:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(312);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(313);
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
						setState(314);
						expression(19);
						}
						break;
					case 3:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(315);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(316);
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
						setState(317);
						expression(18);
						}
						break;
					case 4:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(318);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(319);
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
						setState(320);
						expression(17);
						}
						break;
					case 5:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(321);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(322);
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
						setState(323);
						expression(16);
						}
						break;
					case 6:
						{
						_localctx = new BinaryOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(324);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(325);
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
						setState(326);
						expression(15);
						}
						break;
					case 7:
						{
						_localctx = new AssignMemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(327);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(328);
						match(DOT);
						setState(329);
						match(IDENTIFIER);
						setState(330);
						match(EQUALS);
						setState(331);
						expression(10);
						}
						break;
					case 8:
						{
						_localctx = new AssignIndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(332);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(333);
						match(LEFT_BRACKET);
						setState(335);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(334);
							match(BEGIN);
							}
						}

						setState(337);
						expression(0);
						setState(339);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(338);
							match(END);
							}
						}

						setState(341);
						match(RIGHT_BRACKET);
						setState(342);
						match(EQUALS);
						setState(343);
						expression(8);
						}
						break;
					case 9:
						{
						_localctx = new MemberCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(345);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(346);
						match(DOT);
						setState(347);
						match(IDENTIFIER);
						setState(348);
						match(LEFT_PARENTHESIS);
						setState(349);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 10:
						{
						_localctx = new MemberCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(350);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(351);
						match(DOT);
						setState(352);
						match(IDENTIFIER);
						setState(353);
						match(LEFT_PARENTHESIS);
						setState(355);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(354);
							match(BEGIN);
							}
						}

						setState(357);
						expression(0);
						setState(362);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(358);
							match(COMMA);
							setState(359);
							expression(0);
							}
							}
							setState(364);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(366);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(365);
							match(SEMICOLON);
							}
						}

						setState(369);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(368);
							match(END);
							}
						}

						setState(371);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 11:
						{
						_localctx = new MemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(373);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(374);
						match(DOT);
						setState(375);
						match(IDENTIFIER);
						}
						break;
					case 12:
						{
						_localctx = new IndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(376);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(377);
						match(LEFT_BRACKET);
						setState(379);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(378);
							match(BEGIN);
							}
						}

						setState(381);
						expression(0);
						setState(383);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(382);
							match(SEMICOLON);
							}
						}

						setState(386);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(385);
							match(END);
							}
						}

						setState(388);
						match(RIGHT_BRACKET);
						}
						break;
					case 13:
						{
						_localctx = new MemberAccessorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(390);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(391);
						match(DOLLAR);
						setState(392);
						match(LEFT_BRACKET);
						setState(399);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case BEGIN:
							{
							{
							setState(393);
							match(BEGIN);
							setState(394);
							expression(0);
							setState(395);
							match(SEMICOLON);
							setState(396);
							match(END);
							}
							}
							break;
						case IF:
						case WHILE:
						case IDENTIFIER:
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
							setState(398);
							expression(0);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(401);
						match(RIGHT_BRACKET);
						}
						break;
					case 14:
						{
						_localctx = new CallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(403);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(404);
						match(LEFT_PARENTHESIS);
						setState(405);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 15:
						{
						_localctx = new CallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(406);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(407);
						match(LEFT_PARENTHESIS);
						setState(409);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(408);
							match(BEGIN);
							}
						}

						setState(411);
						expression(0);
						setState(416);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(412);
							match(COMMA);
							setState(413);
							expression(0);
							}
							}
							setState(418);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(420);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(419);
							match(SEMICOLON);
							}
						}

						setState(423);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(422);
							match(END);
							}
						}

						setState(425);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 16:
						{
						_localctx = new AssignMemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(427);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(428);
						match(DOT);
						setState(429);
						match(IDENTIFIER);
						setState(430);
						match(EQUALS);
						setState(431);
						match(SEMICOLON);
						setState(432);
						match(BEGIN);
						setState(433);
						expression(0);
						setState(434);
						match(END);
						}
						break;
					case 17:
						{
						_localctx = new AssignIndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(436);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(437);
						match(LEFT_BRACKET);
						setState(439);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(438);
							match(BEGIN);
							}
						}

						setState(441);
						expression(0);
						setState(443);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(442);
							match(END);
							}
						}

						setState(445);
						match(RIGHT_BRACKET);
						setState(446);
						match(EQUALS);
						setState(447);
						match(BEGIN);
						setState(448);
						expression(0);
						setState(449);
						match(SEMICOLON);
						setState(450);
						match(END);
						}
						break;
					case 18:
						{
						_localctx = new AssignMemberAccessorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(452);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(453);
						match(DOLLAR);
						setState(454);
						match(LEFT_BRACKET);
						setState(461);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case BEGIN:
							{
							{
							setState(455);
							match(BEGIN);
							setState(456);
							expression(0);
							setState(457);
							match(SEMICOLON);
							setState(458);
							match(END);
							}
							}
							break;
						case IF:
						case WHILE:
						case IDENTIFIER:
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
							setState(460);
							expression(0);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(463);
						match(RIGHT_BRACKET);
						setState(464);
						match(EQUALS);
						setState(471);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
						case 1:
							{
							{
							setState(465);
							match(BEGIN);
							setState(466);
							expression(0);
							setState(467);
							match(SEMICOLON);
							setState(468);
							match(END);
							}
							}
							break;
						case 2:
							{
							setState(470);
							expression(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(477);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
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
			setState(490);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(478);
				match(DOUBLE_COLON);
				setState(479);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(480);
				match(DOUBLE_COLON);
				setState(484); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(481);
						expression(0);
						setState(482);
						match(COMMA);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(486); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(488);
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
			setState(505);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(492);
				match(ELSE);
				setState(493);
				match(BEGIN);
				setState(497); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(494);
					instruction();
					setState(495);
					match(SEMICOLON);
					}
					}
					setState(499); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << ACUTE))) != 0) );
				setState(501);
				match(END);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(503);
				match(ELSE);
				setState(504);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u01fe\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\6\2\20\n\2\r\2\16\2\21\3\3"+
		"\3\3\3\4\3\4\3\4\5\4\31\n\4\3\4\3\4\5\4\35\n\4\3\4\5\4 \n\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\7\4)\n\4\f\4\16\4,\13\4\3\4\5\4/\n\4\3\4\3\4\3\4\3"+
		"\4\3\4\7\4\66\n\4\f\4\16\49\13\4\5\4;\n\4\5\4=\n\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\7\4J\n\4\f\4\16\4M\13\4\3\4\5\4P\n\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\\\n\4\f\4\16\4_\13\4\3\4\5\4b\n\4"+
		"\3\4\5\4e\n\4\3\4\3\4\5\4i\n\4\3\4\5\4l\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\7\4x\n\4\f\4\16\4{\13\4\3\4\5\4~\n\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\7\4\u008a\n\4\f\4\16\4\u008d\13\4\3\4\5\4\u0090"+
		"\n\4\5\4\u0092\n\4\3\4\5\4\u0095\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4\u00a0\n\4\3\4\3\4\7\4\u00a4\n\4\f\4\16\4\u00a7\13\4\3\4\5\4\u00aa"+
		"\n\4\3\4\3\4\3\4\5\4\u00af\n\4\3\4\3\4\7\4\u00b3\n\4\f\4\16\4\u00b6\13"+
		"\4\3\4\5\4\u00b9\n\4\3\4\3\4\3\4\3\4\3\4\6\4\u00c0\n\4\r\4\16\4\u00c1"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4\u00e9\n\4\3\4\3\4\5\4\u00ed\n\4\3\4\5\4\u00f0\n\4\3\4\3\4"+
		"\3\4\5\4\u00f5\n\4\3\4\3\4\3\4\5\4\u00fa\n\4\3\4\3\4\5\4\u00fe\n\4\3\4"+
		"\5\4\u0101\n\4\3\4\3\4\3\4\3\4\3\4\6\4\u0108\n\4\r\4\16\4\u0109\3\4\3"+
		"\4\5\4\u010e\n\4\3\4\3\4\3\4\5\4\u0113\n\4\3\4\3\4\5\4\u0117\n\4\3\4\5"+
		"\4\u011a\n\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0122\n\4\3\4\3\4\5\4\u0126\n"+
		"\4\3\4\5\4\u0129\n\4\3\4\3\4\3\4\3\4\3\4\6\4\u0130\n\4\r\4\16\4\u0131"+
		"\3\4\3\4\5\4\u0136\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0152\n\4"+
		"\3\4\3\4\5\4\u0156\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4\u0166\n\4\3\4\3\4\3\4\7\4\u016b\n\4\f\4\16\4\u016e\13\4\3"+
		"\4\5\4\u0171\n\4\3\4\5\4\u0174\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"\u017e\n\4\3\4\3\4\5\4\u0182\n\4\3\4\5\4\u0185\n\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0192\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\5\4\u019c\n\4\3\4\3\4\3\4\7\4\u01a1\n\4\f\4\16\4\u01a4\13\4\3\4\5\4\u01a7"+
		"\n\4\3\4\5\4\u01aa\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4\u01ba\n\4\3\4\3\4\5\4\u01be\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u01d0\n\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4\u01da\n\4\7\4\u01dc\n\4\f\4\16\4\u01df\13\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\6\5\u01e7\n\5\r\5\16\5\u01e8\3\5\3\5\5\5\u01ed\n\5\3"+
		"\6\3\6\3\6\3\6\3\6\6\6\u01f4\n\6\r\6\16\6\u01f5\3\6\3\6\3\6\3\6\5\6\u01fc"+
		"\n\6\3\6\2\3\6\7\2\4\6\b\n\2\t\4\2\b\b\22\22\3\2\20\21\3\2\16\17\3\2\23"+
		"\24\3\2\25\30\3\2\31\31\3\2\32\32\2\u0268\2\17\3\2\2\2\4\23\3\2\2\2\6"+
		"\u0135\3\2\2\2\b\u01ec\3\2\2\2\n\u01fb\3\2\2\2\f\r\5\4\3\2\r\16\7%\2\2"+
		"\16\20\3\2\2\2\17\f\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2"+
		"\22\3\3\2\2\2\23\24\5\6\4\2\24\5\3\2\2\2\25\26\b\4\1\2\26\30\7&\2\2\27"+
		"\31\7\3\2\2\30\27\3\2\2\2\30\31\3\2\2\2\31\32\3\2\2\2\32\34\5\6\4\2\33"+
		"\35\7%\2\2\34\33\3\2\2\2\34\35\3\2\2\2\35\37\3\2\2\2\36 \7\4\2\2\37\36"+
		"\3\2\2\2\37 \3\2\2\2 !\3\2\2\2!\"\7\'\2\2\"\u0136\3\2\2\2#<\7(\2\2$%\7"+
		"\3\2\2%*\5\6\4\2&\'\7 \2\2\')\5\6\4\2(&\3\2\2\2),\3\2\2\2*(\3\2\2\2*+"+
		"\3\2\2\2+.\3\2\2\2,*\3\2\2\2-/\7%\2\2.-\3\2\2\2./\3\2\2\2/\60\3\2\2\2"+
		"\60\61\7\4\2\2\61=\3\2\2\2\62\67\5\6\4\2\63\64\7 \2\2\64\66\5\6\4\2\65"+
		"\63\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28;\3\2\2\29\67\3\2\2"+
		"\2:\62\3\2\2\2:;\3\2\2\2;=\3\2\2\2<$\3\2\2\2<:\3\2\2\2=>\3\2\2\2>\u0136"+
		"\7)\2\2?d\7(\2\2@A\7\3\2\2AB\5\6\4\2BC\7#\2\2CK\5\6\4\2DE\7 \2\2EF\5\6"+
		"\4\2FG\7#\2\2GH\5\6\4\2HJ\3\2\2\2ID\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2"+
		"\2\2LO\3\2\2\2MK\3\2\2\2NP\7%\2\2ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\7\4"+
		"\2\2Re\3\2\2\2ST\5\6\4\2TU\7#\2\2U]\5\6\4\2VW\7 \2\2WX\5\6\4\2XY\7#\2"+
		"\2YZ\5\6\4\2Z\\\3\2\2\2[V\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^a\3\2"+
		"\2\2_]\3\2\2\2`b\7%\2\2a`\3\2\2\2ab\3\2\2\2be\3\2\2\2ce\7\17\2\2d@\3\2"+
		"\2\2dS\3\2\2\2dc\3\2\2\2ef\3\2\2\2fh\7)\2\2gi\7%\2\2hg\3\2\2\2hi\3\2\2"+
		"\2ik\3\2\2\2jl\7\4\2\2kj\3\2\2\2kl\3\2\2\2l\u0136\3\2\2\2m\u0094\7(\2"+
		"\2no\7\3\2\2op\5\6\4\2pq\7$\2\2qy\5\6\4\2rs\7 \2\2st\5\6\4\2tu\7$\2\2"+
		"uv\5\6\4\2vx\3\2\2\2wr\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z}\3\2\2\2"+
		"{y\3\2\2\2|~\7%\2\2}|\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080\7\4\2\2"+
		"\u0080\u0095\3\2\2\2\u0081\u0082\5\6\4\2\u0082\u0083\7$\2\2\u0083\u008b"+
		"\5\6\4\2\u0084\u0085\7 \2\2\u0085\u0086\5\6\4\2\u0086\u0087\7$\2\2\u0087"+
		"\u0088\5\6\4\2\u0088\u008a\3\2\2\2\u0089\u0084\3\2\2\2\u008a\u008d\3\2"+
		"\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008e\u0090\7%\2\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0092\3\2\2\2\u0091\u0081\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0095\3\2\2\2\u0093\u0095\7\36\2\2\u0094n\3\2\2\2\u0094\u0091\3\2\2\2"+
		"\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0136\7)\2\2\u0097\u0136"+
		"\7\t\2\2\u0098\u0136\7\n\2\2\u0099\u0136\7\13\2\2\u009a\u009b\7,\2\2\u009b"+
		"\u0136\7\b\2\2\u009c\u0136\7\f\2\2\u009d\u0136\7\r\2\2\u009e\u00a0\7\t"+
		"\2\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u00a5\t\2\2\2\u00a2\u00a4\7\b\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a8\u00aa\5\b\5\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2"+
		"\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7\"\2\2\u00ac\u0136\5\4\3\2\u00ad"+
		"\u00af\7\t\2\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\u00b4\t\2\2\2\u00b1\u00b3\7\b\2\2\u00b2\u00b1\3\2\2\2\u00b3"+
		"\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b8\3\2"+
		"\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b9\5\b\5\2\u00b8\u00b7\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\7\"\2\2\u00bb\u00bf\7\3"+
		"\2\2\u00bc\u00bd\5\4\3\2\u00bd\u00be\7%\2\2\u00be\u00c0\3\2\2\2\u00bf"+
		"\u00bc\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\7\4\2\2\u00c4\u0136\3\2\2\2\u00c5"+
		"\u00c6\7\t\2\2\u00c6\u00c7\7\t\2\2\u00c7\u0136\7\b\2\2\u00c8\u00c9\7\t"+
		"\2\2\u00c9\u0136\7\b\2\2\u00ca\u0136\7\b\2\2\u00cb\u00cc\7\17\2\2\u00cc"+
		"\u0136\5\6\4\27\u00cd\u00ce\7\33\2\2\u00ce\u0136\5\6\4\26\u00cf\u00d0"+
		"\7\t\2\2\u00d0\u00d1\7\b\2\2\u00d1\u00d2\7\36\2\2\u00d2\u0136\5\6\4\17"+
		"\u00d3\u00d4\7\t\2\2\u00d4\u00d5\7\b\2\2\u00d5\u00d6\7\36\2\2\u00d6\u00d7"+
		"\7\3\2\2\u00d7\u00d8\5\6\4\2\u00d8\u00d9\7%\2\2\u00d9\u00da\7\4\2\2\u00da"+
		"\u0136\3\2\2\2\u00db\u00dc\7\b\2\2\u00dc\u00dd\7\36\2\2\u00dd\u0136\5"+
		"\6\4\r\u00de\u00df\7\b\2\2\u00df\u00e0\7\36\2\2\u00e0\u00e1\7\3\2\2\u00e1"+
		"\u00e2\5\6\4\2\u00e2\u00e3\7%\2\2\u00e3\u00e4\7\4\2\2\u00e4\u0136\3\2"+
		"\2\2\u00e5\u00e6\7\5\2\2\u00e6\u00e8\7&\2\2\u00e7\u00e9\7\3\2\2\u00e8"+
		"\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\5\6"+
		"\4\2\u00eb\u00ed\7%\2\2\u00ec\u00eb\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u00ef\3\2\2\2\u00ee\u00f0\7\4\2\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2"+
		"\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\7\'\2\2\u00f2\u00f4\5\4\3\2\u00f3"+
		"\u00f5\5\n\6\2\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u0136\3\2"+
		"\2\2\u00f6\u00f7\7\5\2\2\u00f7\u00f9\7&\2\2\u00f8\u00fa\7\3\2\2\u00f9"+
		"\u00f8\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\5\6"+
		"\4\2\u00fc\u00fe\7%\2\2\u00fd\u00fc\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe"+
		"\u0100\3\2\2\2\u00ff\u0101\7\4\2\2\u0100\u00ff\3\2\2\2\u0100\u0101\3\2"+
		"\2\2\u0101\u0102\3\2\2\2\u0102\u0103\7\'\2\2\u0103\u0107\7\3\2\2\u0104"+
		"\u0105\5\4\3\2\u0105\u0106\7%\2\2\u0106\u0108\3\2\2\2\u0107\u0104\3\2"+
		"\2\2\u0108\u0109\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u010d\7\4\2\2\u010c\u010e\5\n\6\2\u010d\u010c\3\2"+
		"\2\2\u010d\u010e\3\2\2\2\u010e\u0136\3\2\2\2\u010f\u0110\7\7\2\2\u0110"+
		"\u0112\7&\2\2\u0111\u0113\7\3\2\2\u0112\u0111\3\2\2\2\u0112\u0113\3\2"+
		"\2\2\u0113\u0114\3\2\2\2\u0114\u0116\5\6\4\2\u0115\u0117\7%\2\2\u0116"+
		"\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0119\3\2\2\2\u0118\u011a\7\4"+
		"\2\2\u0119\u0118\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\3\2\2\2\u011b"+
		"\u011c\7\'\2\2\u011c\u011d\5\4\3\2\u011d\u0136\3\2\2\2\u011e\u011f\7\7"+
		"\2\2\u011f\u0121\7&\2\2\u0120\u0122\7\3\2\2\u0121\u0120\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0125\5\6\4\2\u0124\u0126\7%"+
		"\2\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0128\3\2\2\2\u0127"+
		"\u0129\7\4\2\2\u0128\u0127\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\3\2"+
		"\2\2\u012a\u012b\7\'\2\2\u012b\u012f\7\3\2\2\u012c\u012d\5\4\3\2\u012d"+
		"\u012e\7%\2\2\u012e\u0130\3\2\2\2\u012f\u012c\3\2\2\2\u0130\u0131\3\2"+
		"\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\3\2\2\2\u0133"+
		"\u0134\7\4\2\2\u0134\u0136\3\2\2\2\u0135\25\3\2\2\2\u0135#\3\2\2\2\u0135"+
		"?\3\2\2\2\u0135m\3\2\2\2\u0135\u0097\3\2\2\2\u0135\u0098\3\2\2\2\u0135"+
		"\u0099\3\2\2\2\u0135\u009a\3\2\2\2\u0135\u009c\3\2\2\2\u0135\u009d\3\2"+
		"\2\2\u0135\u009f\3\2\2\2\u0135\u00ae\3\2\2\2\u0135\u00c5\3\2\2\2\u0135"+
		"\u00c8\3\2\2\2\u0135\u00ca\3\2\2\2\u0135\u00cb\3\2\2\2\u0135\u00cd\3\2"+
		"\2\2\u0135\u00cf\3\2\2\2\u0135\u00d3\3\2\2\2\u0135\u00db\3\2\2\2\u0135"+
		"\u00de\3\2\2\2\u0135\u00e5\3\2\2\2\u0135\u00f6\3\2\2\2\u0135\u010f\3\2"+
		"\2\2\u0135\u011e\3\2\2\2\u0136\u01dd\3\2\2\2\u0137\u0138\f\25\2\2\u0138"+
		"\u0139\t\3\2\2\u0139\u01dc\5\6\4\26\u013a\u013b\f\24\2\2\u013b\u013c\t"+
		"\4\2\2\u013c\u01dc\5\6\4\25\u013d\u013e\f\23\2\2\u013e\u013f\t\5\2\2\u013f"+
		"\u01dc\5\6\4\24\u0140\u0141\f\22\2\2\u0141\u0142\t\6\2\2\u0142\u01dc\5"+
		"\6\4\23\u0143\u0144\f\21\2\2\u0144\u0145\t\7\2\2\u0145\u01dc\5\6\4\22"+
		"\u0146\u0147\f\20\2\2\u0147\u0148\t\b\2\2\u0148\u01dc\5\6\4\21\u0149\u014a"+
		"\f\13\2\2\u014a\u014b\7\37\2\2\u014b\u014c\7\b\2\2\u014c\u014d\7\36\2"+
		"\2\u014d\u01dc\5\6\4\f\u014e\u014f\f\t\2\2\u014f\u0151\7(\2\2\u0150\u0152"+
		"\7\3\2\2\u0151\u0150\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0153\3\2\2\2\u0153"+
		"\u0155\5\6\4\2\u0154\u0156\7\4\2\2\u0155\u0154\3\2\2\2\u0155\u0156\3\2"+
		"\2\2\u0156\u0157\3\2\2\2\u0157\u0158\7)\2\2\u0158\u0159\7\36\2\2\u0159"+
		"\u015a\5\6\4\n\u015a\u01dc\3\2\2\2\u015b\u015c\f!\2\2\u015c\u015d\7\37"+
		"\2\2\u015d\u015e\7\b\2\2\u015e\u015f\7&\2\2\u015f\u01dc\7\'\2\2\u0160"+
		"\u0161\f \2\2\u0161\u0162\7\37\2\2\u0162\u0163\7\b\2\2\u0163\u0165\7&"+
		"\2\2\u0164\u0166\7\3\2\2\u0165\u0164\3\2\2\2\u0165\u0166\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\u016c\5\6\4\2\u0168\u0169\7 \2\2\u0169\u016b\5\6"+
		"\4\2\u016a\u0168\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c"+
		"\u016d\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0171\7%"+
		"\2\2\u0170\u016f\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0173\3\2\2\2\u0172"+
		"\u0174\7\4\2\2\u0173\u0172\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\3\2"+
		"\2\2\u0175\u0176\7\'\2\2\u0176\u01dc\3\2\2\2\u0177\u0178\f\34\2\2\u0178"+
		"\u0179\7\37\2\2\u0179\u01dc\7\b\2\2\u017a\u017b\f\33\2\2\u017b\u017d\7"+
		"(\2\2\u017c\u017e\7\3\2\2\u017d\u017c\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"\u017f\3\2\2\2\u017f\u0181\5\6\4\2\u0180\u0182\7%\2\2\u0181\u0180\3\2"+
		"\2\2\u0181\u0182\3\2\2\2\u0182\u0184\3\2\2\2\u0183\u0185\7\4\2\2\u0184"+
		"\u0183\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\7)"+
		"\2\2\u0187\u01dc\3\2\2\2\u0188\u0189\f\32\2\2\u0189\u018a\7\t\2\2\u018a"+
		"\u0191\7(\2\2\u018b\u018c\7\3\2\2\u018c\u018d\5\6\4\2\u018d\u018e\7%\2"+
		"\2\u018e\u018f\7\4\2\2\u018f\u0192\3\2\2\2\u0190\u0192\5\6\4\2\u0191\u018b"+
		"\3\2\2\2\u0191\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0194\7)\2\2\u0194"+
		"\u01dc\3\2\2\2\u0195\u0196\f\31\2\2\u0196\u0197\7&\2\2\u0197\u01dc\7\'"+
		"\2\2\u0198\u0199\f\30\2\2\u0199\u019b\7&\2\2\u019a\u019c\7\3\2\2\u019b"+
		"\u019a\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u01a2\5\6"+
		"\4\2\u019e\u019f\7 \2\2\u019f\u01a1\5\6\4\2\u01a0\u019e\3\2\2\2\u01a1"+
		"\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a6\3\2"+
		"\2\2\u01a4\u01a2\3\2\2\2\u01a5\u01a7\7%\2\2\u01a6\u01a5\3\2\2\2\u01a6"+
		"\u01a7\3\2\2\2\u01a7\u01a9\3\2\2\2\u01a8\u01aa\7\4\2\2\u01a9\u01a8\3\2"+
		"\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ac\7\'\2\2\u01ac"+
		"\u01dc\3\2\2\2\u01ad\u01ae\f\n\2\2\u01ae\u01af\7\37\2\2\u01af\u01b0\7"+
		"\b\2\2\u01b0\u01b1\7\36\2\2\u01b1\u01b2\7%\2\2\u01b2\u01b3\7\3\2\2\u01b3"+
		"\u01b4\5\6\4\2\u01b4\u01b5\7\4\2\2\u01b5\u01dc\3\2\2\2\u01b6\u01b7\f\b"+
		"\2\2\u01b7\u01b9\7(\2\2\u01b8\u01ba\7\3\2\2\u01b9\u01b8\3\2\2\2\u01b9"+
		"\u01ba\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bd\5\6\4\2\u01bc\u01be\7\4"+
		"\2\2\u01bd\u01bc\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf"+
		"\u01c0\7)\2\2\u01c0\u01c1\7\36\2\2\u01c1\u01c2\7\3\2\2\u01c2\u01c3\5\6"+
		"\4\2\u01c3\u01c4\7%\2\2\u01c4\u01c5\7\4\2\2\u01c5\u01dc\3\2\2\2\u01c6"+
		"\u01c7\f\7\2\2\u01c7\u01c8\7\t\2\2\u01c8\u01cf\7(\2\2\u01c9\u01ca\7\3"+
		"\2\2\u01ca\u01cb\5\6\4\2\u01cb\u01cc\7%\2\2\u01cc\u01cd\7\4\2\2\u01cd"+
		"\u01d0\3\2\2\2\u01ce\u01d0\5\6\4\2\u01cf\u01c9\3\2\2\2\u01cf\u01ce\3\2"+
		"\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2\7)\2\2\u01d2\u01d9\7\36\2\2\u01d3"+
		"\u01d4\7\3\2\2\u01d4\u01d5\5\6\4\2\u01d5\u01d6\7%\2\2\u01d6\u01d7\7\4"+
		"\2\2\u01d7\u01da\3\2\2\2\u01d8\u01da\5\6\4\2\u01d9\u01d3\3\2\2\2\u01d9"+
		"\u01d8\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01dc\3\2\2\2\u01db\u0137\3\2"+
		"\2\2\u01db\u013a\3\2\2\2\u01db\u013d\3\2\2\2\u01db\u0140\3\2\2\2\u01db"+
		"\u0143\3\2\2\2\u01db\u0146\3\2\2\2\u01db\u0149\3\2\2\2\u01db\u014e\3\2"+
		"\2\2\u01db\u015b\3\2\2\2\u01db\u0160\3\2\2\2\u01db\u0177\3\2\2\2\u01db"+
		"\u017a\3\2\2\2\u01db\u0188\3\2\2\2\u01db\u0195\3\2\2\2\u01db\u0198\3\2"+
		"\2\2\u01db\u01ad\3\2\2\2\u01db\u01b6\3\2\2\2\u01db\u01c6\3\2\2\2\u01dc"+
		"\u01df\3\2\2\2\u01dd\u01db\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\7\3\2\2\2"+
		"\u01df\u01dd\3\2\2\2\u01e0\u01e1\7!\2\2\u01e1\u01ed\5\6\4\2\u01e2\u01e6"+
		"\7!\2\2\u01e3\u01e4\5\6\4\2\u01e4\u01e5\7 \2\2\u01e5\u01e7\3\2\2\2\u01e6"+
		"\u01e3\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e9\3\2"+
		"\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01eb\5\6\4\2\u01eb\u01ed\3\2\2\2\u01ec"+
		"\u01e0\3\2\2\2\u01ec\u01e2\3\2\2\2\u01ed\t\3\2\2\2\u01ee\u01ef\7\6\2\2"+
		"\u01ef\u01f3\7\3\2\2\u01f0\u01f1\5\4\3\2\u01f1\u01f2\7%\2\2\u01f2\u01f4"+
		"\3\2\2\2\u01f3\u01f0\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f5"+
		"\u01f6\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f8\7\4\2\2\u01f8\u01fc\3\2"+
		"\2\2\u01f9\u01fa\7\6\2\2\u01fa\u01fc\5\4\3\2\u01fb\u01ee\3\2\2\2\u01fb"+
		"\u01f9\3\2\2\2\u01fc\13\3\2\2\2H\21\30\34\37*.\67:<KO]adhky}\u008b\u008f"+
		"\u0091\u0094\u009f\u00a5\u00a9\u00ae\u00b4\u00b8\u00c1\u00e8\u00ec\u00ef"+
		"\u00f4\u00f9\u00fd\u0100\u0109\u010d\u0112\u0116\u0119\u0121\u0125\u0128"+
		"\u0131\u0135\u0151\u0155\u0165\u016c\u0170\u0173\u017d\u0181\u0184\u0191"+
		"\u019b\u01a2\u01a6\u01a9\u01b9\u01bd\u01cf\u01d9\u01db\u01dd\u01e8\u01ec"+
		"\u01f5\u01fb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}