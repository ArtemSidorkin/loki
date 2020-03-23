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
		BEGIN=1, END=2, IF=3, ELSE=4, WHILE=5, IDENTIFIER=6, LEFT_THIN_ARROW=7, 
		DOLLAR=8, AT=9, CHARACTERS=10, FLOAT=11, INT=12, PLUS=13, MINUS=14, STAR=15, 
		SLASH=16, BACKSLASH=17, EQUALS_EQUALS=18, BANG_EQUALS=19, GREATER_THAN_EQUALS=20, 
		GREATER_THAN=21, LESS_THAN_EQUALS=22, LESS_THAN=23, AMPERSAND_AMPERSAND=24, 
		PIPE_PIPE=25, BANG=26, AMPERSAND=27, PIPE=28, EQUALS=29, DOT=30, COMMA=31, 
		COLON=32, SEMICOLON=33, LEFT_PARENTHESIS=34, RIGHT_PARENTHESIS=35, LEFT_BRACKET=36, 
		RIGHT_BRACKET=37, LEFT_BRACE=38, RIGHT_BRACE=39, ACUTE=40, IGNORE=41;
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
			null, "'~{'", "'~}'", "'if'", "'else'", "'while'", null, "'<-'", "'$'", 
			"'@'", null, null, null, "'+'", "'-'", "'*'", "'/'", "'\\'", "'=='", 
			"'!='", "'>='", "'>'", "'<='", "'<'", "'&&'", "'||'", "'!'", "'&'", "'|'", 
			"'='", "'.'", "','", "':'", "';'", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "'`'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BEGIN", "END", "IF", "ELSE", "WHILE", "IDENTIFIER", "LEFT_THIN_ARROW", 
			"DOLLAR", "AT", "CHARACTERS", "FLOAT", "INT", "PLUS", "MINUS", "STAR", 
			"SLASH", "BACKSLASH", "EQUALS_EQUALS", "BANG_EQUALS", "GREATER_THAN_EQUALS", 
			"GREATER_THAN", "LESS_THAN_EQUALS", "LESS_THAN", "AMPERSAND_AMPERSAND", 
			"PIPE_PIPE", "BANG", "AMPERSAND", "PIPE", "EQUALS", "DOT", "COMMA", "COLON", 
			"SEMICOLON", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", "LEFT_BRACKET", 
			"RIGHT_BRACKET", "LEFT_BRACE", "RIGHT_BRACE", "ACUTE", "IGNORE"
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0) );
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
	public static class MulDivContext extends ExpressionContext {
		public Token operator;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode STAR() { return getToken(LokiParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(LokiParser.SLASH, 0); }
		public MulDivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitMulDiv(this);
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
	public static class GteLteGtLtContext extends ExpressionContext {
		public Token operator;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GREATER_THAN_EQUALS() { return getToken(LokiParser.GREATER_THAN_EQUALS, 0); }
		public TerminalNode LESS_THAN_EQUALS() { return getToken(LokiParser.LESS_THAN_EQUALS, 0); }
		public TerminalNode GREATER_THAN() { return getToken(LokiParser.GREATER_THAN, 0); }
		public TerminalNode LESS_THAN() { return getToken(LokiParser.LESS_THAN, 0); }
		public GteLteGtLtContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterGteLteGtLt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitGteLteGtLt(this);
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
	public static class AmpersandAmpersandContext extends ExpressionContext {
		public Token operator;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AMPERSAND_AMPERSAND() { return getToken(LokiParser.AMPERSAND_AMPERSAND, 0); }
		public AmpersandAmpersandContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterAmpersandAmpersand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitAmpersandAmpersand(this);
		}
	}
	public static class MemberAccessorContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LEFT_BRACE() { return getToken(LokiParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(LokiParser.RIGHT_BRACE, 0); }
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
	public static class AddSubContext extends ExpressionContext {
		public Token operator;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(LokiParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(LokiParser.MINUS, 0); }
		public AddSubContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitAddSub(this);
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
	public static class EqNeqContext extends ExpressionContext {
		public Token operator;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUALS_EQUALS() { return getToken(LokiParser.EQUALS_EQUALS, 0); }
		public TerminalNode BANG_EQUALS() { return getToken(LokiParser.BANG_EQUALS, 0); }
		public EqNeqContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterEqNeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitEqNeq(this);
		}
	}
	public static class ArrayContext extends ExpressionContext {
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
		public TerminalNode LEFT_BRACE() { return getToken(LokiParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(LokiParser.RIGHT_BRACE, 0); }
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
		public TerminalNode LEFT_BRACE() { return getToken(LokiParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(LokiParser.RIGHT_BRACE, 0); }
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(LokiParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(LokiParser.COLON, i);
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
	public static class PipePipeContext extends ExpressionContext {
		public Token operator;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PIPE_PIPE() { return getToken(LokiParser.PIPE_PIPE, 0); }
		public PipePipeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).enterPipePipe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LokiListener ) ((LokiListener)listener).exitPipePipe(this);
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
		public List<TerminalNode> COLON() { return getTokens(LokiParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(LokiParser.COLON, i);
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
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
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
				setState(61);
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
				case LEFT_BRACE:
				case ACUTE:
					{
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0)) {
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
						setState(57);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(56);
							match(SEMICOLON);
							}
						}

						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(63);
				match(RIGHT_BRACKET);
				setState(65);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(64);
					match(SEMICOLON);
					}
					break;
				}
				setState(68);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(67);
					match(END);
					}
					break;
				}
				}
				break;
			case 3:
				{
				_localctx = new MapContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70);
				match(LEFT_BRACKET);
				setState(107);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BEGIN:
					{
					{
					setState(71);
					match(BEGIN);
					setState(72);
					expression(0);
					setState(73);
					match(COLON);
					setState(74);
					expression(0);
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(75);
						match(COMMA);
						setState(76);
						expression(0);
						setState(77);
						match(COLON);
						setState(78);
						expression(0);
						}
						}
						setState(84);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(85);
						match(SEMICOLON);
						}
					}

					setState(88);
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
				case LEFT_BRACE:
				case ACUTE:
					{
					{
					setState(90);
					expression(0);
					setState(91);
					match(COLON);
					setState(92);
					expression(0);
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(93);
						match(COMMA);
						setState(94);
						expression(0);
						setState(95);
						match(COLON);
						setState(96);
						expression(0);
						}
						}
						setState(102);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(103);
						match(SEMICOLON);
						}
					}

					}
					}
					break;
				case COLON:
					{
					{
					setState(106);
					match(COLON);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(109);
				match(RIGHT_BRACKET);
				setState(111);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(110);
					match(SEMICOLON);
					}
					break;
				}
				setState(114);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(113);
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
				setState(116);
				match(LEFT_BRACE);
				setState(154);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BEGIN:
					{
					{
					setState(117);
					match(BEGIN);
					setState(118);
					expression(0);
					setState(119);
					match(COLON);
					setState(120);
					expression(0);
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(121);
						match(COMMA);
						setState(122);
						expression(0);
						setState(123);
						match(COLON);
						setState(124);
						expression(0);
						}
						}
						setState(130);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(131);
						match(SEMICOLON);
						}
					}

					setState(134);
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
				case LEFT_BRACE:
				case RIGHT_BRACE:
				case ACUTE:
					{
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0)) {
						{
						setState(136);
						expression(0);
						setState(137);
						match(COLON);
						setState(138);
						expression(0);
						setState(146);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(139);
							match(COMMA);
							setState(140);
							expression(0);
							setState(141);
							match(COLON);
							setState(142);
							expression(0);
							}
							}
							setState(148);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(150);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(149);
							match(SEMICOLON);
							}
						}

						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(156);
				match(RIGHT_BRACE);
				}
				break;
			case 5:
				{
				_localctx = new HostContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157);
				match(DOLLAR);
				}
				break;
			case 6:
				{
				_localctx = new ThisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158);
				match(AT);
				}
				break;
			case 7:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				match(CHARACTERS);
				}
				break;
			case 8:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160);
				match(ACUTE);
				setState(161);
				match(IDENTIFIER);
				}
				break;
			case 9:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				match(FLOAT);
				}
				break;
			case 10:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				match(INT);
				}
				break;
			case 11:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(164);
					match(DOLLAR);
					}
				}

				setState(167);
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
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(168);
					match(IDENTIFIER);
					}
					}
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_THIN_ARROW) {
					{
					setState(174);
					inheritance();
					}
				}

				setState(177);
				match(COLON);
				setState(178);
				instruction();
				}
				break;
			case 12:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(179);
					match(DOLLAR);
					}
				}

				setState(182);
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
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(183);
					match(IDENTIFIER);
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_THIN_ARROW) {
					{
					setState(189);
					inheritance();
					}
				}

				setState(192);
				match(COLON);
				setState(193);
				match(BEGIN);
				setState(197); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(194);
					instruction();
					setState(195);
					match(SEMICOLON);
					}
					}
					setState(199); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0) );
				setState(201);
				match(END);
				}
				break;
			case 13:
				{
				_localctx = new SuperHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				match(DOLLAR);
				setState(204);
				match(DOLLAR);
				setState(205);
				match(IDENTIFIER);
				}
				break;
			case 14:
				{
				_localctx = new HostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				match(DOLLAR);
				setState(207);
				match(IDENTIFIER);
				}
				break;
			case 15:
				{
				_localctx = new VariableOrParameterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
				match(IDENTIFIER);
				}
				break;
			case 16:
				{
				_localctx = new UnaryOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				((UnaryOperationContext)_localctx).operator = match(MINUS);
				setState(210);
				expression(21);
				}
				break;
			case 17:
				{
				_localctx = new UnaryOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				((UnaryOperationContext)_localctx).operator = match(BANG);
				setState(212);
				expression(20);
				}
				break;
			case 18:
				{
				_localctx = new AssignHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213);
				match(DOLLAR);
				setState(214);
				match(IDENTIFIER);
				setState(215);
				match(EQUALS);
				setState(216);
				expression(13);
				}
				break;
			case 19:
				{
				_localctx = new AssignHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				match(DOLLAR);
				setState(218);
				match(IDENTIFIER);
				setState(219);
				match(EQUALS);
				setState(220);
				match(BEGIN);
				setState(221);
				expression(0);
				setState(222);
				match(SEMICOLON);
				setState(223);
				match(END);
				}
				break;
			case 20:
				{
				_localctx = new AssignVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				match(IDENTIFIER);
				setState(226);
				match(EQUALS);
				setState(227);
				expression(11);
				}
				break;
			case 21:
				{
				_localctx = new AssignVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				match(IDENTIFIER);
				setState(229);
				match(EQUALS);
				setState(230);
				match(BEGIN);
				setState(231);
				expression(0);
				setState(232);
				match(SEMICOLON);
				setState(233);
				match(END);
				}
				break;
			case 22:
				{
				_localctx = new IfElseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(235);
				match(IF);
				setState(236);
				match(LEFT_PARENTHESIS);
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(237);
					match(BEGIN);
					}
				}

				setState(240);
				expression(0);
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(241);
					match(SEMICOLON);
					}
				}

				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(244);
					match(END);
					}
				}

				setState(247);
				match(RIGHT_PARENTHESIS);
				setState(248);
				instruction();
				setState(250);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(249);
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
				setState(252);
				match(IF);
				setState(253);
				match(LEFT_PARENTHESIS);
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(254);
					match(BEGIN);
					}
				}

				setState(257);
				expression(0);
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(258);
					match(SEMICOLON);
					}
				}

				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(261);
					match(END);
					}
				}

				setState(264);
				match(RIGHT_PARENTHESIS);
				setState(265);
				match(BEGIN);
				setState(269); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(266);
					instruction();
					setState(267);
					match(SEMICOLON);
					}
					}
					setState(271); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0) );
				setState(273);
				match(END);
				setState(275);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(274);
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
				setState(277);
				match(WHILE);
				setState(278);
				match(LEFT_PARENTHESIS);
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(279);
					match(BEGIN);
					}
				}

				setState(282);
				expression(0);
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(283);
					match(SEMICOLON);
					}
				}

				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(286);
					match(END);
					}
				}

				setState(289);
				match(RIGHT_PARENTHESIS);
				setState(290);
				instruction();
				}
				break;
			case 25:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(292);
				match(WHILE);
				setState(293);
				match(LEFT_PARENTHESIS);
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(294);
					match(BEGIN);
					}
				}

				setState(297);
				expression(0);
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(298);
					match(SEMICOLON);
					}
				}

				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(301);
					match(END);
					}
				}

				setState(304);
				match(RIGHT_PARENTHESIS);
				setState(305);
				match(BEGIN);
				setState(309); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(306);
					instruction();
					setState(307);
					match(SEMICOLON);
					}
					}
					setState(311); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0) );
				setState(313);
				match(END);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(481);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(479);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(317);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(318);
						((MulDivContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==STAR || _la==SLASH) ) {
							((MulDivContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(319);
						expression(20);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(320);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(321);
						((AddSubContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((AddSubContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(322);
						expression(19);
						}
						break;
					case 3:
						{
						_localctx = new EqNeqContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(323);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(324);
						((EqNeqContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUALS_EQUALS || _la==BANG_EQUALS) ) {
							((EqNeqContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(325);
						expression(18);
						}
						break;
					case 4:
						{
						_localctx = new GteLteGtLtContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(326);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(327);
						((GteLteGtLtContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATER_THAN_EQUALS) | (1L << GREATER_THAN) | (1L << LESS_THAN_EQUALS) | (1L << LESS_THAN))) != 0)) ) {
							((GteLteGtLtContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(328);
						expression(17);
						}
						break;
					case 5:
						{
						_localctx = new AmpersandAmpersandContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(329);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(330);
						((AmpersandAmpersandContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AMPERSAND_AMPERSAND) ) {
							((AmpersandAmpersandContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(331);
						expression(16);
						}
						break;
					case 6:
						{
						_localctx = new PipePipeContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(332);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(333);
						((PipePipeContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PIPE_PIPE) ) {
							((PipePipeContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(334);
						expression(15);
						}
						break;
					case 7:
						{
						_localctx = new AssignMemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(335);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(336);
						match(DOT);
						setState(337);
						match(IDENTIFIER);
						setState(338);
						match(EQUALS);
						setState(339);
						expression(10);
						}
						break;
					case 8:
						{
						_localctx = new AssignIndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(340);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(341);
						match(LEFT_BRACKET);
						setState(343);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(342);
							match(BEGIN);
							}
						}

						setState(345);
						expression(0);
						setState(347);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(346);
							match(END);
							}
						}

						setState(349);
						match(RIGHT_BRACKET);
						setState(350);
						match(EQUALS);
						setState(351);
						expression(8);
						}
						break;
					case 9:
						{
						_localctx = new MemberCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(353);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(354);
						match(DOT);
						setState(355);
						match(IDENTIFIER);
						setState(356);
						match(LEFT_PARENTHESIS);
						setState(357);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 10:
						{
						_localctx = new MemberCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(358);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(359);
						match(DOT);
						setState(360);
						match(IDENTIFIER);
						setState(361);
						match(LEFT_PARENTHESIS);
						setState(363);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(362);
							match(BEGIN);
							}
						}

						setState(365);
						expression(0);
						setState(370);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(366);
							match(COMMA);
							setState(367);
							expression(0);
							}
							}
							setState(372);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(374);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(373);
							match(SEMICOLON);
							}
						}

						setState(377);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(376);
							match(END);
							}
						}

						setState(379);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 11:
						{
						_localctx = new MemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(381);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(382);
						match(DOT);
						setState(383);
						match(IDENTIFIER);
						}
						break;
					case 12:
						{
						_localctx = new IndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(384);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(385);
						match(LEFT_BRACKET);
						setState(387);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(386);
							match(BEGIN);
							}
						}

						setState(389);
						expression(0);
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
						match(RIGHT_BRACKET);
						}
						break;
					case 13:
						{
						_localctx = new MemberAccessorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(398);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(399);
						match(LEFT_BRACE);
						setState(406);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case BEGIN:
							{
							{
							setState(400);
							match(BEGIN);
							setState(401);
							expression(0);
							setState(402);
							match(SEMICOLON);
							setState(403);
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
						case LEFT_BRACE:
						case ACUTE:
							{
							setState(405);
							expression(0);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(408);
						match(RIGHT_BRACE);
						}
						break;
					case 14:
						{
						_localctx = new CallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(410);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(411);
						match(LEFT_PARENTHESIS);
						setState(412);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 15:
						{
						_localctx = new CallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(413);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(414);
						match(LEFT_PARENTHESIS);
						setState(416);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(415);
							match(BEGIN);
							}
						}

						setState(418);
						expression(0);
						setState(423);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(419);
							match(COMMA);
							setState(420);
							expression(0);
							}
							}
							setState(425);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(427);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(426);
							match(SEMICOLON);
							}
						}

						setState(430);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(429);
							match(END);
							}
						}

						setState(432);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 16:
						{
						_localctx = new AssignMemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(434);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(435);
						match(DOT);
						setState(436);
						match(IDENTIFIER);
						setState(437);
						match(EQUALS);
						setState(438);
						match(SEMICOLON);
						setState(439);
						match(BEGIN);
						setState(440);
						expression(0);
						setState(441);
						match(END);
						}
						break;
					case 17:
						{
						_localctx = new AssignIndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(443);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(444);
						match(LEFT_BRACKET);
						setState(446);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(445);
							match(BEGIN);
							}
						}

						setState(448);
						expression(0);
						setState(450);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(449);
							match(END);
							}
						}

						setState(452);
						match(RIGHT_BRACKET);
						setState(453);
						match(EQUALS);
						setState(454);
						match(BEGIN);
						setState(455);
						expression(0);
						setState(456);
						match(SEMICOLON);
						setState(457);
						match(END);
						}
						break;
					case 18:
						{
						_localctx = new AssignMemberAccessorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(459);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(460);
						match(LEFT_BRACE);
						setState(467);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case BEGIN:
							{
							{
							setState(461);
							match(BEGIN);
							setState(462);
							expression(0);
							setState(463);
							match(SEMICOLON);
							setState(464);
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
						case LEFT_BRACE:
						case ACUTE:
							{
							setState(466);
							expression(0);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(469);
						match(RIGHT_BRACE);
						setState(470);
						match(EQUALS);
						setState(477);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
						case 1:
							{
							{
							setState(471);
							match(BEGIN);
							setState(472);
							expression(0);
							setState(473);
							match(SEMICOLON);
							setState(474);
							match(END);
							}
							}
							break;
						case 2:
							{
							setState(476);
							expression(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(483);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
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
		public TerminalNode LEFT_THIN_ARROW() { return getToken(LokiParser.LEFT_THIN_ARROW, 0); }
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
			setState(496);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(484);
				match(LEFT_THIN_ARROW);
				setState(485);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(486);
				match(LEFT_THIN_ARROW);
				setState(490); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(487);
						expression(0);
						setState(488);
						match(COMMA);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(492); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(494);
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
			setState(511);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(498);
				match(ELSE);
				setState(499);
				match(BEGIN);
				setState(503); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(500);
					instruction();
					setState(501);
					match(SEMICOLON);
					}
					}
					setState(505); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0) );
				setState(507);
				match(END);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(509);
				match(ELSE);
				setState(510);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u0204\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\6\2\20\n\2\r\2\16\2\21\3\3"+
		"\3\3\3\4\3\4\3\4\5\4\31\n\4\3\4\3\4\5\4\35\n\4\3\4\5\4 \n\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\7\4)\n\4\f\4\16\4,\13\4\3\4\5\4/\n\4\3\4\3\4\3\4\3"+
		"\4\3\4\7\4\66\n\4\f\4\16\49\13\4\3\4\5\4<\n\4\5\4>\n\4\5\4@\n\4\3\4\3"+
		"\4\5\4D\n\4\3\4\5\4G\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4S"+
		"\n\4\f\4\16\4V\13\4\3\4\5\4Y\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\7\4e\n\4\f\4\16\4h\13\4\3\4\5\4k\n\4\3\4\5\4n\n\4\3\4\3\4\5\4r\n\4"+
		"\3\4\5\4u\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0081\n\4\f"+
		"\4\16\4\u0084\13\4\3\4\5\4\u0087\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\7\4\u0093\n\4\f\4\16\4\u0096\13\4\3\4\5\4\u0099\n\4\5\4\u009b\n"+
		"\4\5\4\u009d\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00a8\n\4\3\4"+
		"\3\4\7\4\u00ac\n\4\f\4\16\4\u00af\13\4\3\4\5\4\u00b2\n\4\3\4\3\4\3\4\5"+
		"\4\u00b7\n\4\3\4\3\4\7\4\u00bb\n\4\f\4\16\4\u00be\13\4\3\4\5\4\u00c1\n"+
		"\4\3\4\3\4\3\4\3\4\3\4\6\4\u00c8\n\4\r\4\16\4\u00c9\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00f1"+
		"\n\4\3\4\3\4\5\4\u00f5\n\4\3\4\5\4\u00f8\n\4\3\4\3\4\3\4\5\4\u00fd\n\4"+
		"\3\4\3\4\3\4\5\4\u0102\n\4\3\4\3\4\5\4\u0106\n\4\3\4\5\4\u0109\n\4\3\4"+
		"\3\4\3\4\3\4\3\4\6\4\u0110\n\4\r\4\16\4\u0111\3\4\3\4\5\4\u0116\n\4\3"+
		"\4\3\4\3\4\5\4\u011b\n\4\3\4\3\4\5\4\u011f\n\4\3\4\5\4\u0122\n\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4\u012a\n\4\3\4\3\4\5\4\u012e\n\4\3\4\5\4\u0131\n"+
		"\4\3\4\3\4\3\4\3\4\3\4\6\4\u0138\n\4\r\4\16\4\u0139\3\4\3\4\5\4\u013e"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u015a\n\4\3\4\3\4\5\4\u015e"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u016e"+
		"\n\4\3\4\3\4\3\4\7\4\u0173\n\4\f\4\16\4\u0176\13\4\3\4\5\4\u0179\n\4\3"+
		"\4\5\4\u017c\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0186\n\4\3\4\3\4"+
		"\5\4\u018a\n\4\3\4\5\4\u018d\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4\u0199\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u01a3\n\4\3\4\3\4"+
		"\3\4\7\4\u01a8\n\4\f\4\16\4\u01ab\13\4\3\4\5\4\u01ae\n\4\3\4\5\4\u01b1"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u01c1"+
		"\n\4\3\4\3\4\5\4\u01c5\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\5\4\u01d6\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u01e0"+
		"\n\4\7\4\u01e2\n\4\f\4\16\4\u01e5\13\4\3\5\3\5\3\5\3\5\3\5\3\5\6\5\u01ed"+
		"\n\5\r\5\16\5\u01ee\3\5\3\5\5\5\u01f3\n\5\3\6\3\6\3\6\3\6\3\6\6\6\u01fa"+
		"\n\6\r\6\16\6\u01fb\3\6\3\6\3\6\3\6\5\6\u0202\n\6\3\6\2\3\6\7\2\4\6\b"+
		"\n\2\t\4\2\b\b\23\23\3\2\21\22\3\2\17\20\3\2\24\25\3\2\26\31\3\2\32\32"+
		"\3\2\33\33\2\u0270\2\17\3\2\2\2\4\23\3\2\2\2\6\u013d\3\2\2\2\b\u01f2\3"+
		"\2\2\2\n\u0201\3\2\2\2\f\r\5\4\3\2\r\16\7#\2\2\16\20\3\2\2\2\17\f\3\2"+
		"\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\3\3\2\2\2\23\24\5\6"+
		"\4\2\24\5\3\2\2\2\25\26\b\4\1\2\26\30\7$\2\2\27\31\7\3\2\2\30\27\3\2\2"+
		"\2\30\31\3\2\2\2\31\32\3\2\2\2\32\34\5\6\4\2\33\35\7#\2\2\34\33\3\2\2"+
		"\2\34\35\3\2\2\2\35\37\3\2\2\2\36 \7\4\2\2\37\36\3\2\2\2\37 \3\2\2\2 "+
		"!\3\2\2\2!\"\7%\2\2\"\u013e\3\2\2\2#?\7&\2\2$%\7\3\2\2%*\5\6\4\2&\'\7"+
		"!\2\2\')\5\6\4\2(&\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+.\3\2\2\2,*\3"+
		"\2\2\2-/\7#\2\2.-\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60\61\7\4\2\2\61@\3\2"+
		"\2\2\62\67\5\6\4\2\63\64\7!\2\2\64\66\5\6\4\2\65\63\3\2\2\2\669\3\2\2"+
		"\2\67\65\3\2\2\2\678\3\2\2\28;\3\2\2\29\67\3\2\2\2:<\7#\2\2;:\3\2\2\2"+
		";<\3\2\2\2<>\3\2\2\2=\62\3\2\2\2=>\3\2\2\2>@\3\2\2\2?$\3\2\2\2?=\3\2\2"+
		"\2@A\3\2\2\2AC\7\'\2\2BD\7#\2\2CB\3\2\2\2CD\3\2\2\2DF\3\2\2\2EG\7\4\2"+
		"\2FE\3\2\2\2FG\3\2\2\2G\u013e\3\2\2\2Hm\7&\2\2IJ\7\3\2\2JK\5\6\4\2KL\7"+
		"\"\2\2LT\5\6\4\2MN\7!\2\2NO\5\6\4\2OP\7\"\2\2PQ\5\6\4\2QS\3\2\2\2RM\3"+
		"\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UX\3\2\2\2VT\3\2\2\2WY\7#\2\2XW\3"+
		"\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\7\4\2\2[n\3\2\2\2\\]\5\6\4\2]^\7\"\2\2^f"+
		"\5\6\4\2_`\7!\2\2`a\5\6\4\2ab\7\"\2\2bc\5\6\4\2ce\3\2\2\2d_\3\2\2\2eh"+
		"\3\2\2\2fd\3\2\2\2fg\3\2\2\2gj\3\2\2\2hf\3\2\2\2ik\7#\2\2ji\3\2\2\2jk"+
		"\3\2\2\2kn\3\2\2\2ln\7\"\2\2mI\3\2\2\2m\\\3\2\2\2ml\3\2\2\2no\3\2\2\2"+
		"oq\7\'\2\2pr\7#\2\2qp\3\2\2\2qr\3\2\2\2rt\3\2\2\2su\7\4\2\2ts\3\2\2\2"+
		"tu\3\2\2\2u\u013e\3\2\2\2v\u009c\7(\2\2wx\7\3\2\2xy\5\6\4\2yz\7\"\2\2"+
		"z\u0082\5\6\4\2{|\7!\2\2|}\5\6\4\2}~\7\"\2\2~\177\5\6\4\2\177\u0081\3"+
		"\2\2\2\u0080{\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0087\7#\2\2\u0086"+
		"\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7\4"+
		"\2\2\u0089\u009d\3\2\2\2\u008a\u008b\5\6\4\2\u008b\u008c\7\"\2\2\u008c"+
		"\u0094\5\6\4\2\u008d\u008e\7!\2\2\u008e\u008f\5\6\4\2\u008f\u0090\7\""+
		"\2\2\u0090\u0091\5\6\4\2\u0091\u0093\3\2\2\2\u0092\u008d\3\2\2\2\u0093"+
		"\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0098\3\2"+
		"\2\2\u0096\u0094\3\2\2\2\u0097\u0099\7#\2\2\u0098\u0097\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a\u008a\3\2\2\2\u009a\u009b\3\2"+
		"\2\2\u009b\u009d\3\2\2\2\u009cw\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009e"+
		"\3\2\2\2\u009e\u013e\7)\2\2\u009f\u013e\7\n\2\2\u00a0\u013e\7\13\2\2\u00a1"+
		"\u013e\7\f\2\2\u00a2\u00a3\7*\2\2\u00a3\u013e\7\b\2\2\u00a4\u013e\7\r"+
		"\2\2\u00a5\u013e\7\16\2\2\u00a6\u00a8\7\n\2\2\u00a7\u00a6\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ad\t\2\2\2\u00aa\u00ac\7\b"+
		"\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b2\5\b"+
		"\5\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b4\7\"\2\2\u00b4\u013e\5\4\3\2\u00b5\u00b7\7\n\2\2\u00b6\u00b5\3\2"+
		"\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00bc\t\2\2\2\u00b9"+
		"\u00bb\7\b\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2"+
		"\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf"+
		"\u00c1\5\b\5\2\u00c0\u00bf\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c3\7\"\2\2\u00c3\u00c7\7\3\2\2\u00c4\u00c5\5\4\3\2\u00c5"+
		"\u00c6\7#\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c4\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00cc\7\4\2\2\u00cc\u013e\3\2\2\2\u00cd\u00ce\7\n\2\2\u00ce\u00cf\7\n"+
		"\2\2\u00cf\u013e\7\b\2\2\u00d0\u00d1\7\n\2\2\u00d1\u013e\7\b\2\2\u00d2"+
		"\u013e\7\b\2\2\u00d3\u00d4\7\20\2\2\u00d4\u013e\5\6\4\27\u00d5\u00d6\7"+
		"\34\2\2\u00d6\u013e\5\6\4\26\u00d7\u00d8\7\n\2\2\u00d8\u00d9\7\b\2\2\u00d9"+
		"\u00da\7\37\2\2\u00da\u013e\5\6\4\17\u00db\u00dc\7\n\2\2\u00dc\u00dd\7"+
		"\b\2\2\u00dd\u00de\7\37\2\2\u00de\u00df\7\3\2\2\u00df\u00e0\5\6\4\2\u00e0"+
		"\u00e1\7#\2\2\u00e1\u00e2\7\4\2\2\u00e2\u013e\3\2\2\2\u00e3\u00e4\7\b"+
		"\2\2\u00e4\u00e5\7\37\2\2\u00e5\u013e\5\6\4\r\u00e6\u00e7\7\b\2\2\u00e7"+
		"\u00e8\7\37\2\2\u00e8\u00e9\7\3\2\2\u00e9\u00ea\5\6\4\2\u00ea\u00eb\7"+
		"#\2\2\u00eb\u00ec\7\4\2\2\u00ec\u013e\3\2\2\2\u00ed\u00ee\7\5\2\2\u00ee"+
		"\u00f0\7$\2\2\u00ef\u00f1\7\3\2\2\u00f0\u00ef\3\2\2\2\u00f0\u00f1\3\2"+
		"\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\5\6\4\2\u00f3\u00f5\7#\2\2\u00f4"+
		"\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00f8\7\4"+
		"\2\2\u00f7\u00f6\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9"+
		"\u00fa\7%\2\2\u00fa\u00fc\5\4\3\2\u00fb\u00fd\5\n\6\2\u00fc\u00fb\3\2"+
		"\2\2\u00fc\u00fd\3\2\2\2\u00fd\u013e\3\2\2\2\u00fe\u00ff\7\5\2\2\u00ff"+
		"\u0101\7$\2\2\u0100\u0102\7\3\2\2\u0101\u0100\3\2\2\2\u0101\u0102\3\2"+
		"\2\2\u0102\u0103\3\2\2\2\u0103\u0105\5\6\4\2\u0104\u0106\7#\2\2\u0105"+
		"\u0104\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\3\2\2\2\u0107\u0109\7\4"+
		"\2\2\u0108\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a"+
		"\u010b\7%\2\2\u010b\u010f\7\3\2\2\u010c\u010d\5\4\3\2\u010d\u010e\7#\2"+
		"\2\u010e\u0110\3\2\2\2\u010f\u010c\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u010f"+
		"\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0115\7\4\2\2\u0114"+
		"\u0116\5\n\6\2\u0115\u0114\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u013e\3\2"+
		"\2\2\u0117\u0118\7\7\2\2\u0118\u011a\7$\2\2\u0119\u011b\7\3\2\2\u011a"+
		"\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011e\5\6"+
		"\4\2\u011d\u011f\7#\2\2\u011e\u011d\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\u0121\3\2\2\2\u0120\u0122\7\4\2\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2"+
		"\2\2\u0122\u0123\3\2\2\2\u0123\u0124\7%\2\2\u0124\u0125\5\4\3\2\u0125"+
		"\u013e\3\2\2\2\u0126\u0127\7\7\2\2\u0127\u0129\7$\2\2\u0128\u012a\7\3"+
		"\2\2\u0129\u0128\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"\u012d\5\6\4\2\u012c\u012e\7#\2\2\u012d\u012c\3\2\2\2\u012d\u012e\3\2"+
		"\2\2\u012e\u0130\3\2\2\2\u012f\u0131\7\4\2\2\u0130\u012f\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\7%\2\2\u0133\u0137\7\3"+
		"\2\2\u0134\u0135\5\4\3\2\u0135\u0136\7#\2\2\u0136\u0138\3\2\2\2\u0137"+
		"\u0134\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2"+
		"\2\2\u013a\u013b\3\2\2\2\u013b\u013c\7\4\2\2\u013c\u013e\3\2\2\2\u013d"+
		"\25\3\2\2\2\u013d#\3\2\2\2\u013dH\3\2\2\2\u013dv\3\2\2\2\u013d\u009f\3"+
		"\2\2\2\u013d\u00a0\3\2\2\2\u013d\u00a1\3\2\2\2\u013d\u00a2\3\2\2\2\u013d"+
		"\u00a4\3\2\2\2\u013d\u00a5\3\2\2\2\u013d\u00a7\3\2\2\2\u013d\u00b6\3\2"+
		"\2\2\u013d\u00cd\3\2\2\2\u013d\u00d0\3\2\2\2\u013d\u00d2\3\2\2\2\u013d"+
		"\u00d3\3\2\2\2\u013d\u00d5\3\2\2\2\u013d\u00d7\3\2\2\2\u013d\u00db\3\2"+
		"\2\2\u013d\u00e3\3\2\2\2\u013d\u00e6\3\2\2\2\u013d\u00ed\3\2\2\2\u013d"+
		"\u00fe\3\2\2\2\u013d\u0117\3\2\2\2\u013d\u0126\3\2\2\2\u013e\u01e3\3\2"+
		"\2\2\u013f\u0140\f\25\2\2\u0140\u0141\t\3\2\2\u0141\u01e2\5\6\4\26\u0142"+
		"\u0143\f\24\2\2\u0143\u0144\t\4\2\2\u0144\u01e2\5\6\4\25\u0145\u0146\f"+
		"\23\2\2\u0146\u0147\t\5\2\2\u0147\u01e2\5\6\4\24\u0148\u0149\f\22\2\2"+
		"\u0149\u014a\t\6\2\2\u014a\u01e2\5\6\4\23\u014b\u014c\f\21\2\2\u014c\u014d"+
		"\t\7\2\2\u014d\u01e2\5\6\4\22\u014e\u014f\f\20\2\2\u014f\u0150\t\b\2\2"+
		"\u0150\u01e2\5\6\4\21\u0151\u0152\f\13\2\2\u0152\u0153\7 \2\2\u0153\u0154"+
		"\7\b\2\2\u0154\u0155\7\37\2\2\u0155\u01e2\5\6\4\f\u0156\u0157\f\t\2\2"+
		"\u0157\u0159\7&\2\2\u0158\u015a\7\3\2\2\u0159\u0158\3\2\2\2\u0159\u015a"+
		"\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015d\5\6\4\2\u015c\u015e\7\4\2\2\u015d"+
		"\u015c\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\7\'"+
		"\2\2\u0160\u0161\7\37\2\2\u0161\u0162\5\6\4\n\u0162\u01e2\3\2\2\2\u0163"+
		"\u0164\f!\2\2\u0164\u0165\7 \2\2\u0165\u0166\7\b\2\2\u0166\u0167\7$\2"+
		"\2\u0167\u01e2\7%\2\2\u0168\u0169\f \2\2\u0169\u016a\7 \2\2\u016a\u016b"+
		"\7\b\2\2\u016b\u016d\7$\2\2\u016c\u016e\7\3\2\2\u016d\u016c\3\2\2\2\u016d"+
		"\u016e\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0174\5\6\4\2\u0170\u0171\7!"+
		"\2\2\u0171\u0173\5\6\4\2\u0172\u0170\3\2\2\2\u0173\u0176\3\2\2\2\u0174"+
		"\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0178\3\2\2\2\u0176\u0174\3\2"+
		"\2\2\u0177\u0179\7#\2\2\u0178\u0177\3\2\2\2\u0178\u0179\3\2\2\2\u0179"+
		"\u017b\3\2\2\2\u017a\u017c\7\4\2\2\u017b\u017a\3\2\2\2\u017b\u017c\3\2"+
		"\2\2\u017c\u017d\3\2\2\2\u017d\u017e\7%\2\2\u017e\u01e2\3\2\2\2\u017f"+
		"\u0180\f\34\2\2\u0180\u0181\7 \2\2\u0181\u01e2\7\b\2\2\u0182\u0183\f\33"+
		"\2\2\u0183\u0185\7&\2\2\u0184\u0186\7\3\2\2\u0185\u0184\3\2\2\2\u0185"+
		"\u0186\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0189\5\6\4\2\u0188\u018a\7#"+
		"\2\2\u0189\u0188\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018c\3\2\2\2\u018b"+
		"\u018d\7\4\2\2\u018c\u018b\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018e\3\2"+
		"\2\2\u018e\u018f\7\'\2\2\u018f\u01e2\3\2\2\2\u0190\u0191\f\32\2\2\u0191"+
		"\u0198\7(\2\2\u0192\u0193\7\3\2\2\u0193\u0194\5\6\4\2\u0194\u0195\7#\2"+
		"\2\u0195\u0196\7\4\2\2\u0196\u0199\3\2\2\2\u0197\u0199\5\6\4\2\u0198\u0192"+
		"\3\2\2\2\u0198\u0197\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\7)\2\2\u019b"+
		"\u01e2\3\2\2\2\u019c\u019d\f\31\2\2\u019d\u019e\7$\2\2\u019e\u01e2\7%"+
		"\2\2\u019f\u01a0\f\30\2\2\u01a0\u01a2\7$\2\2\u01a1\u01a3\7\3\2\2\u01a2"+
		"\u01a1\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a9\5\6"+
		"\4\2\u01a5\u01a6\7!\2\2\u01a6\u01a8\5\6\4\2\u01a7\u01a5\3\2\2\2\u01a8"+
		"\u01ab\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ad\3\2"+
		"\2\2\u01ab\u01a9\3\2\2\2\u01ac\u01ae\7#\2\2\u01ad\u01ac\3\2\2\2\u01ad"+
		"\u01ae\3\2\2\2\u01ae\u01b0\3\2\2\2\u01af\u01b1\7\4\2\2\u01b0\u01af\3\2"+
		"\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\7%\2\2\u01b3"+
		"\u01e2\3\2\2\2\u01b4\u01b5\f\n\2\2\u01b5\u01b6\7 \2\2\u01b6\u01b7\7\b"+
		"\2\2\u01b7\u01b8\7\37\2\2\u01b8\u01b9\7#\2\2\u01b9\u01ba\7\3\2\2\u01ba"+
		"\u01bb\5\6\4\2\u01bb\u01bc\7\4\2\2\u01bc\u01e2\3\2\2\2\u01bd\u01be\f\b"+
		"\2\2\u01be\u01c0\7&\2\2\u01bf\u01c1\7\3\2\2\u01c0\u01bf\3\2\2\2\u01c0"+
		"\u01c1\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c4\5\6\4\2\u01c3\u01c5\7\4"+
		"\2\2\u01c4\u01c3\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6"+
		"\u01c7\7\'\2\2\u01c7\u01c8\7\37\2\2\u01c8\u01c9\7\3\2\2\u01c9\u01ca\5"+
		"\6\4\2\u01ca\u01cb\7#\2\2\u01cb\u01cc\7\4\2\2\u01cc\u01e2\3\2\2\2\u01cd"+
		"\u01ce\f\7\2\2\u01ce\u01d5\7(\2\2\u01cf\u01d0\7\3\2\2\u01d0\u01d1\5\6"+
		"\4\2\u01d1\u01d2\7#\2\2\u01d2\u01d3\7\4\2\2\u01d3\u01d6\3\2\2\2\u01d4"+
		"\u01d6\5\6\4\2\u01d5\u01cf\3\2\2\2\u01d5\u01d4\3\2\2\2\u01d6\u01d7\3\2"+
		"\2\2\u01d7\u01d8\7)\2\2\u01d8\u01df\7\37\2\2\u01d9\u01da\7\3\2\2\u01da"+
		"\u01db\5\6\4\2\u01db\u01dc\7#\2\2\u01dc\u01dd\7\4\2\2\u01dd\u01e0\3\2"+
		"\2\2\u01de\u01e0\5\6\4\2\u01df\u01d9\3\2\2\2\u01df\u01de\3\2\2\2\u01df"+
		"\u01e0\3\2\2\2\u01e0\u01e2\3\2\2\2\u01e1\u013f\3\2\2\2\u01e1\u0142\3\2"+
		"\2\2\u01e1\u0145\3\2\2\2\u01e1\u0148\3\2\2\2\u01e1\u014b\3\2\2\2\u01e1"+
		"\u014e\3\2\2\2\u01e1\u0151\3\2\2\2\u01e1\u0156\3\2\2\2\u01e1\u0163\3\2"+
		"\2\2\u01e1\u0168\3\2\2\2\u01e1\u017f\3\2\2\2\u01e1\u0182\3\2\2\2\u01e1"+
		"\u0190\3\2\2\2\u01e1\u019c\3\2\2\2\u01e1\u019f\3\2\2\2\u01e1\u01b4\3\2"+
		"\2\2\u01e1\u01bd\3\2\2\2\u01e1\u01cd\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3"+
		"\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\7\3\2\2\2\u01e5\u01e3\3\2\2\2"+
		"\u01e6\u01e7\7\t\2\2\u01e7\u01f3\5\6\4\2\u01e8\u01ec\7\t\2\2\u01e9\u01ea"+
		"\5\6\4\2\u01ea\u01eb\7!\2\2\u01eb\u01ed\3\2\2\2\u01ec\u01e9\3\2\2\2\u01ed"+
		"\u01ee\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f0\3\2"+
		"\2\2\u01f0\u01f1\5\6\4\2\u01f1\u01f3\3\2\2\2\u01f2\u01e6\3\2\2\2\u01f2"+
		"\u01e8\3\2\2\2\u01f3\t\3\2\2\2\u01f4\u01f5\7\6\2\2\u01f5\u01f9\7\3\2\2"+
		"\u01f6\u01f7\5\4\3\2\u01f7\u01f8\7#\2\2\u01f8\u01fa\3\2\2\2\u01f9\u01f6"+
		"\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc"+
		"\u01fd\3\2\2\2\u01fd\u01fe\7\4\2\2\u01fe\u0202\3\2\2\2\u01ff\u0200\7\6"+
		"\2\2\u0200\u0202\5\4\3\2\u0201\u01f4\3\2\2\2\u0201\u01ff\3\2\2\2\u0202"+
		"\13\3\2\2\2K\21\30\34\37*.\67;=?CFTXfjmqt\u0082\u0086\u0094\u0098\u009a"+
		"\u009c\u00a7\u00ad\u00b1\u00b6\u00bc\u00c0\u00c9\u00f0\u00f4\u00f7\u00fc"+
		"\u0101\u0105\u0108\u0111\u0115\u011a\u011e\u0121\u0129\u012d\u0130\u0139"+
		"\u013d\u0159\u015d\u016d\u0174\u0178\u017b\u0185\u0189\u018c\u0198\u01a2"+
		"\u01a9\u01ad\u01b0\u01c0\u01c4\u01d5\u01df\u01e1\u01e3\u01ee\u01f2\u01fb"+
		"\u0201";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}