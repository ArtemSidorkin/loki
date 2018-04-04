// Generated from ./src/main/java/loki/language/parsing/Loki.grammar by ANTLR 4.5

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
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

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
		RIGHT_BRACKET=37, LEFT_BRACE=38, RIGHT_BRACE=39, ACUTE=40, SKIP=41;
	public static final int
		RULE_module = 0, RULE_instruction = 1, RULE_expression = 2, RULE_inheritance = 3, 
		RULE_else_ = 4;
	public static final String[] ruleNames = {
		"module", "instruction", "expression", "inheritance", "else_"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'~{'", "'~}'", "'if'", "'else'", "'while'", null, "'<-'", "'$'", 
		"'@'", null, null, null, "'+'", "'-'", "'*'", "'/'", "'\\'", "'=='", "'!='", 
		"'>='", "'>'", "'<='", "'<'", "'&&'", "'||'", "'!'", "'&'", "'|'", "'='", 
		"'.'", "','", "':'", "';'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
		"'`'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BEGIN", "END", "IF", "ELSE", "WHILE", "IDENTIFIER", "LEFT_THIN_ARROW", 
		"DOLLAR", "AT", "CHARACTERS", "FLOAT", "INT", "PLUS", "MINUS", "STAR", 
		"SLASH", "BACKSLASH", "EQUALS_EQUALS", "BANG_EQUALS", "GREATER_THAN_EQUALS", 
		"GREATER_THAN", "LESS_THAN_EQUALS", "LESS_THAN", "AMPERSAND_AMPERSAND", 
		"PIPE_PIPE", "BANG", "AMPERSAND", "PIPE", "EQUALS", "DOT", "COMMA", "COLON", 
		"SEMICOLON", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", "LEFT_BRACKET", 
		"RIGHT_BRACKET", "LEFT_BRACE", "RIGHT_BRACE", "ACUTE", "SKIP"
	};
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
		public TerminalNode MINUS() { return getToken(LokiParser.MINUS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		public List<TerminalNode> COMMA() { return getTokens(LokiParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LokiParser.COMMA, i);
		}
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
		public List<TerminalNode> AMPERSAND_AMPERSAND() { return getTokens(LokiParser.AMPERSAND_AMPERSAND); }
		public TerminalNode AMPERSAND_AMPERSAND(int i) {
			return getToken(LokiParser.AMPERSAND_AMPERSAND, i);
		}
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
		public List<TerminalNode> SEMICOLON() { return getTokens(LokiParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LokiParser.SEMICOLON, i);
		}
		public List<TerminalNode> END() { return getTokens(LokiParser.END); }
		public TerminalNode END(int i) {
			return getToken(LokiParser.END, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LokiParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LokiParser.COMMA, i);
		}
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
		public List<TerminalNode> PIPE_PIPE() { return getTokens(LokiParser.PIPE_PIPE); }
		public TerminalNode PIPE_PIPE(int i) {
			return getToken(LokiParser.PIPE_PIPE, i);
		}
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
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(20);
				match(MINUS);
				setState(21);
				expression(21);
				}
				break;
			case 2:
				{
				_localctx = new UnaryOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				match(BANG);
				setState(23);
				expression(20);
				}
				break;
			case 3:
				{
				_localctx = new AssignHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(DOLLAR);
				setState(25);
				match(IDENTIFIER);
				setState(26);
				match(EQUALS);
				setState(27);
				expression(13);
				}
				break;
			case 4:
				{
				_localctx = new AssignVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				match(IDENTIFIER);
				setState(29);
				match(EQUALS);
				setState(30);
				expression(11);
				}
				break;
			case 5:
				{
				_localctx = new ExpressionGroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(31);
				match(LEFT_PARENTHESIS);
				setState(33);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(32);
					match(BEGIN);
					}
				}

				setState(35);
				expression(0);
				setState(37);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(36);
					match(SEMICOLON);
					}
				}

				setState(40);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(39);
					match(END);
					}
				}

				setState(42);
				match(RIGHT_PARENTHESIS);
				}
				break;
			case 6:
				{
				_localctx = new ArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44);
				match(LEFT_BRACKET);
				setState(72);
				switch (_input.LA(1)) {
				case BEGIN:
					{
					{
					setState(45);
					match(BEGIN);
					setState(46);
					expression(0);
					setState(51);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(47);
						match(COMMA);
						setState(48);
						expression(0);
						}
						}
						setState(53);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(55);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(54);
						match(SEMICOLON);
						}
					}

					setState(57);
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
					setState(70);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0)) {
						{
						setState(59);
						expression(0);
						setState(64);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(60);
							match(COMMA);
							setState(61);
							expression(0);
							}
							}
							setState(66);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(68);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(67);
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
				setState(74);
				match(RIGHT_BRACKET);
				setState(76);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(75);
					match(SEMICOLON);
					}
					break;
				}
				setState(79);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(78);
					match(END);
					}
					break;
				}
				}
				break;
			case 7:
				{
				_localctx = new MapContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81);
				match(LEFT_BRACKET);
				setState(118);
				switch (_input.LA(1)) {
				case BEGIN:
					{
					{
					setState(82);
					match(BEGIN);
					setState(83);
					expression(0);
					setState(84);
					match(COLON);
					setState(85);
					expression(0);
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(86);
						match(COMMA);
						setState(87);
						expression(0);
						setState(88);
						match(COLON);
						setState(89);
						expression(0);
						}
						}
						setState(95);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(97);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(96);
						match(SEMICOLON);
						}
					}

					setState(99);
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
					setState(101);
					expression(0);
					setState(102);
					match(COLON);
					setState(103);
					expression(0);
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(104);
						match(COMMA);
						setState(105);
						expression(0);
						setState(106);
						match(COLON);
						setState(107);
						expression(0);
						}
						}
						setState(113);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(115);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(114);
						match(SEMICOLON);
						}
					}

					}
					}
					break;
				case COLON:
					{
					{
					setState(117);
					match(COLON);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(120);
				match(RIGHT_BRACKET);
				setState(122);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(121);
					match(SEMICOLON);
					}
					break;
				}
				setState(125);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(124);
					match(END);
					}
					break;
				}
				}
				break;
			case 8:
				{
				_localctx = new ObjectContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				match(LEFT_BRACE);
				setState(165);
				switch (_input.LA(1)) {
				case BEGIN:
					{
					{
					setState(128);
					match(BEGIN);
					setState(129);
					expression(0);
					setState(130);
					match(COLON);
					setState(131);
					expression(0);
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(132);
						match(COMMA);
						setState(133);
						expression(0);
						setState(134);
						match(COLON);
						setState(135);
						expression(0);
						}
						}
						setState(141);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(143);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(142);
						match(SEMICOLON);
						}
					}

					setState(145);
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
					setState(163);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0)) {
						{
						setState(147);
						expression(0);
						setState(148);
						match(COLON);
						setState(149);
						expression(0);
						setState(157);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(150);
							match(COMMA);
							setState(151);
							expression(0);
							setState(152);
							match(COLON);
							setState(153);
							expression(0);
							}
							}
							setState(159);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(161);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(160);
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
				setState(167);
				match(RIGHT_BRACE);
				}
				break;
			case 9:
				{
				_localctx = new HostContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				match(DOLLAR);
				}
				break;
			case 10:
				{
				_localctx = new ThisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(AT);
				}
				break;
			case 11:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(170);
				match(CHARACTERS);
				}
				break;
			case 12:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171);
				match(ACUTE);
				setState(172);
				match(IDENTIFIER);
				}
				break;
			case 13:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(173);
				match(FLOAT);
				}
				break;
			case 14:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				match(INT);
				}
				break;
			case 15:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(176);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(175);
					match(DOLLAR);
					}
				}

				setState(178);
				((UnitContext)_localctx).head = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==BACKSLASH) ) {
					((UnitContext)_localctx).head = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(179);
					match(IDENTIFIER);
					}
					}
					setState(184);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(186);
				_la = _input.LA(1);
				if (_la==LEFT_THIN_ARROW) {
					{
					setState(185);
					inheritance();
					}
				}

				setState(188);
				match(COLON);
				setState(189);
				instruction();
				}
				break;
			case 16:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(190);
					match(DOLLAR);
					}
				}

				setState(193);
				((UnitContext)_localctx).head = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==BACKSLASH) ) {
					((UnitContext)_localctx).head = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(194);
					match(IDENTIFIER);
					}
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(201);
				_la = _input.LA(1);
				if (_la==LEFT_THIN_ARROW) {
					{
					setState(200);
					inheritance();
					}
				}

				setState(203);
				match(COLON);
				setState(204);
				match(BEGIN);
				setState(208); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(205);
					instruction();
					setState(206);
					match(SEMICOLON);
					}
					}
					setState(210); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0) );
				setState(212);
				match(END);
				}
				break;
			case 17:
				{
				_localctx = new SuperHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				match(DOLLAR);
				setState(215);
				match(DOLLAR);
				setState(216);
				match(IDENTIFIER);
				}
				break;
			case 18:
				{
				_localctx = new HostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				match(DOLLAR);
				setState(218);
				match(IDENTIFIER);
				}
				break;
			case 19:
				{
				_localctx = new VariableOrParameterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219);
				match(IDENTIFIER);
				}
				break;
			case 20:
				{
				_localctx = new AssignHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220);
				match(DOLLAR);
				setState(221);
				match(IDENTIFIER);
				setState(222);
				match(EQUALS);
				setState(223);
				match(BEGIN);
				setState(224);
				expression(0);
				setState(225);
				match(SEMICOLON);
				setState(226);
				match(END);
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
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(241);
					match(SEMICOLON);
					}
				}

				setState(245);
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
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(258);
					match(SEMICOLON);
					}
				}

				setState(262);
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
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(283);
					match(SEMICOLON);
					}
				}

				setState(287);
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
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(298);
					match(SEMICOLON);
					}
				}

				setState(302);
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
			setState(512);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(510);
					switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
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
						} else {
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
						} else {
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
						} else {
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
						} else {
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
						} else {
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
						} else {
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
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(342);
							match(BEGIN);
							}
						}

						setState(353);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0)) {
							{
							setState(345);
							expression(0);
							setState(350);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(346);
								match(COMMA);
								setState(347);
								expression(0);
								}
								}
								setState(352);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(356);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(355);
							match(SEMICOLON);
							}
						}

						setState(359);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(358);
							match(END);
							}
						}

						setState(361);
						match(RIGHT_BRACKET);
						setState(362);
						match(EQUALS);
						setState(363);
						expression(8);
						}
						break;
					case 9:
						{
						_localctx = new MemberCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(364);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(365);
						match(DOT);
						setState(366);
						match(IDENTIFIER);
						setState(367);
						match(LEFT_PARENTHESIS);
						setState(368);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 10:
						{
						_localctx = new MemberCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(369);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(370);
						match(DOT);
						setState(371);
						match(IDENTIFIER);
						setState(372);
						match(LEFT_PARENTHESIS);
						setState(374);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(373);
							match(BEGIN);
							}
						}

						setState(376);
						expression(0);
						setState(381);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(377);
							match(COMMA);
							setState(378);
							expression(0);
							}
							}
							setState(383);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(385);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(384);
							match(SEMICOLON);
							}
						}

						setState(388);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(387);
							match(END);
							}
						}

						setState(390);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 11:
						{
						_localctx = new MemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(392);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(393);
						match(DOT);
						setState(394);
						match(IDENTIFIER);
						}
						break;
					case 12:
						{
						_localctx = new IndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(395);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(396);
						match(LEFT_BRACKET);
						setState(398);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(397);
							match(BEGIN);
							}
						}

						setState(408);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0)) {
							{
							setState(400);
							expression(0);
							setState(405);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(401);
								match(COMMA);
								setState(402);
								expression(0);
								}
								}
								setState(407);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(411);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(410);
							match(SEMICOLON);
							}
						}

						setState(414);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(413);
							match(END);
							}
						}

						setState(416);
						match(RIGHT_BRACKET);
						}
						break;
					case 13:
						{
						_localctx = new MemberAccessorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(417);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(418);
						match(LEFT_BRACE);
						setState(425);
						switch (_input.LA(1)) {
						case BEGIN:
							{
							{
							setState(419);
							match(BEGIN);
							setState(420);
							expression(0);
							setState(421);
							match(SEMICOLON);
							setState(422);
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
							setState(424);
							expression(0);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(427);
						match(RIGHT_BRACE);
						}
						break;
					case 14:
						{
						_localctx = new CallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(429);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(430);
						match(LEFT_PARENTHESIS);
						setState(431);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 15:
						{
						_localctx = new CallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(432);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(433);
						match(LEFT_PARENTHESIS);
						setState(435);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(434);
							match(BEGIN);
							}
						}

						setState(437);
						expression(0);
						setState(442);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(438);
							match(COMMA);
							setState(439);
							expression(0);
							}
							}
							setState(444);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(446);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(445);
							match(SEMICOLON);
							}
						}

						setState(449);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(448);
							match(END);
							}
						}

						setState(451);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 16:
						{
						_localctx = new AssignMemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(453);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(454);
						match(DOT);
						setState(455);
						match(IDENTIFIER);
						setState(456);
						match(EQUALS);
						setState(457);
						match(SEMICOLON);
						setState(458);
						match(BEGIN);
						setState(459);
						expression(0);
						setState(460);
						match(END);
						}
						break;
					case 17:
						{
						_localctx = new AssignIndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(462);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(463);
						match(LEFT_BRACKET);
						setState(465);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(464);
							match(BEGIN);
							}
						}

						setState(475);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0)) {
							{
							setState(467);
							expression(0);
							setState(472);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(468);
								match(COMMA);
								setState(469);
								expression(0);
								}
								}
								setState(474);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(478);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(477);
							match(SEMICOLON);
							}
						}

						setState(481);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(480);
							match(END);
							}
						}

						setState(483);
						match(RIGHT_BRACKET);
						setState(484);
						match(EQUALS);
						setState(485);
						match(BEGIN);
						setState(486);
						expression(0);
						setState(487);
						match(SEMICOLON);
						setState(488);
						match(END);
						}
						break;
					case 18:
						{
						_localctx = new AssignMemberAccessorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(490);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(491);
						match(LEFT_BRACE);
						setState(498);
						switch (_input.LA(1)) {
						case BEGIN:
							{
							{
							setState(492);
							match(BEGIN);
							setState(493);
							expression(0);
							setState(494);
							match(SEMICOLON);
							setState(495);
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
							setState(497);
							expression(0);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(500);
						match(RIGHT_BRACE);
						setState(501);
						match(EQUALS);
						setState(508);
						switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
						case 1:
							{
							{
							setState(502);
							match(BEGIN);
							setState(503);
							expression(0);
							setState(504);
							match(SEMICOLON);
							setState(505);
							match(END);
							}
							}
							break;
						case 2:
							{
							setState(507);
							expression(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(514);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
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
			setState(527);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(515);
				match(LEFT_THIN_ARROW);
				setState(516);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(517);
				match(LEFT_THIN_ARROW);
				setState(521); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(518);
						expression(0);
						setState(519);
						match(COMMA);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(523); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(525);
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
			setState(542);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(529);
				match(ELSE);
				setState(530);
				match(BEGIN);
				setState(534); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(531);
					instruction();
					setState(532);
					match(SEMICOLON);
					}
					}
					setState(536); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0) );
				setState(538);
				match(END);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(540);
				match(ELSE);
				setState(541);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u0223\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\6\2\20\n\2\r\2\16\2\21\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4$\n\4"+
		"\3\4\3\4\5\4(\n\4\3\4\5\4+\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\64\n\4"+
		"\f\4\16\4\67\13\4\3\4\5\4:\n\4\3\4\3\4\3\4\3\4\3\4\7\4A\n\4\f\4\16\4D"+
		"\13\4\3\4\5\4G\n\4\5\4I\n\4\5\4K\n\4\3\4\3\4\5\4O\n\4\3\4\5\4R\n\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4^\n\4\f\4\16\4a\13\4\3\4\5\4d"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4p\n\4\f\4\16\4s\13\4\3"+
		"\4\5\4v\n\4\3\4\5\4y\n\4\3\4\3\4\5\4}\n\4\3\4\5\4\u0080\n\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u008c\n\4\f\4\16\4\u008f\13\4\3\4\5"+
		"\4\u0092\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u009e\n\4\f\4"+
		"\16\4\u00a1\13\4\3\4\5\4\u00a4\n\4\5\4\u00a6\n\4\5\4\u00a8\n\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00b3\n\4\3\4\3\4\7\4\u00b7\n\4\f\4\16"+
		"\4\u00ba\13\4\3\4\5\4\u00bd\n\4\3\4\3\4\3\4\5\4\u00c2\n\4\3\4\3\4\7\4"+
		"\u00c6\n\4\f\4\16\4\u00c9\13\4\3\4\5\4\u00cc\n\4\3\4\3\4\3\4\3\4\3\4\6"+
		"\4\u00d3\n\4\r\4\16\4\u00d4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00f1"+
		"\n\4\3\4\3\4\5\4\u00f5\n\4\3\4\5\4\u00f8\n\4\3\4\3\4\3\4\5\4\u00fd\n\4"+
		"\3\4\3\4\3\4\5\4\u0102\n\4\3\4\3\4\5\4\u0106\n\4\3\4\5\4\u0109\n\4\3\4"+
		"\3\4\3\4\3\4\3\4\6\4\u0110\n\4\r\4\16\4\u0111\3\4\3\4\5\4\u0116\n\4\3"+
		"\4\3\4\3\4\5\4\u011b\n\4\3\4\3\4\5\4\u011f\n\4\3\4\5\4\u0122\n\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4\u012a\n\4\3\4\3\4\5\4\u012e\n\4\3\4\5\4\u0131\n"+
		"\4\3\4\3\4\3\4\3\4\3\4\6\4\u0138\n\4\r\4\16\4\u0139\3\4\3\4\5\4\u013e"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u015a\n\4\3\4\3\4\3\4\7\4\u015f"+
		"\n\4\f\4\16\4\u0162\13\4\5\4\u0164\n\4\3\4\5\4\u0167\n\4\3\4\5\4\u016a"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0179\n\4"+
		"\3\4\3\4\3\4\7\4\u017e\n\4\f\4\16\4\u0181\13\4\3\4\5\4\u0184\n\4\3\4\5"+
		"\4\u0187\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0191\n\4\3\4\3\4\3\4"+
		"\7\4\u0196\n\4\f\4\16\4\u0199\13\4\5\4\u019b\n\4\3\4\5\4\u019e\n\4\3\4"+
		"\5\4\u01a1\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u01ac\n\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u01b6\n\4\3\4\3\4\3\4\7\4\u01bb\n\4\f\4"+
		"\16\4\u01be\13\4\3\4\5\4\u01c1\n\4\3\4\5\4\u01c4\n\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u01d4\n\4\3\4\3\4\3\4\7\4\u01d9"+
		"\n\4\f\4\16\4\u01dc\13\4\5\4\u01de\n\4\3\4\5\4\u01e1\n\4\3\4\5\4\u01e4"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u01f5"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u01ff\n\4\7\4\u0201\n\4\f\4\16"+
		"\4\u0204\13\4\3\5\3\5\3\5\3\5\3\5\3\5\6\5\u020c\n\5\r\5\16\5\u020d\3\5"+
		"\3\5\5\5\u0212\n\5\3\6\3\6\3\6\3\6\3\6\6\6\u0219\n\6\r\6\16\6\u021a\3"+
		"\6\3\6\3\6\3\6\5\6\u0221\n\6\3\6\2\3\6\7\2\4\6\b\n\2\t\4\2\b\b\23\23\3"+
		"\2\21\22\3\2\17\20\3\2\24\25\3\2\26\31\3\2\32\32\3\2\33\33\u0297\2\17"+
		"\3\2\2\2\4\23\3\2\2\2\6\u013d\3\2\2\2\b\u0211\3\2\2\2\n\u0220\3\2\2\2"+
		"\f\r\5\4\3\2\r\16\7#\2\2\16\20\3\2\2\2\17\f\3\2\2\2\20\21\3\2\2\2\21\17"+
		"\3\2\2\2\21\22\3\2\2\2\22\3\3\2\2\2\23\24\5\6\4\2\24\5\3\2\2\2\25\26\b"+
		"\4\1\2\26\27\7\20\2\2\27\u013e\5\6\4\27\30\31\7\34\2\2\31\u013e\5\6\4"+
		"\26\32\33\7\n\2\2\33\34\7\b\2\2\34\35\7\37\2\2\35\u013e\5\6\4\17\36\37"+
		"\7\b\2\2\37 \7\37\2\2 \u013e\5\6\4\r!#\7$\2\2\"$\7\3\2\2#\"\3\2\2\2#$"+
		"\3\2\2\2$%\3\2\2\2%\'\5\6\4\2&(\7#\2\2\'&\3\2\2\2\'(\3\2\2\2(*\3\2\2\2"+
		")+\7\4\2\2*)\3\2\2\2*+\3\2\2\2+,\3\2\2\2,-\7%\2\2-\u013e\3\2\2\2.J\7&"+
		"\2\2/\60\7\3\2\2\60\65\5\6\4\2\61\62\7!\2\2\62\64\5\6\4\2\63\61\3\2\2"+
		"\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2"+
		"8:\7#\2\298\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\7\4\2\2<K\3\2\2\2=B\5\6\4\2"+
		">?\7!\2\2?A\5\6\4\2@>\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CF\3\2\2\2"+
		"DB\3\2\2\2EG\7#\2\2FE\3\2\2\2FG\3\2\2\2GI\3\2\2\2H=\3\2\2\2HI\3\2\2\2"+
		"IK\3\2\2\2J/\3\2\2\2JH\3\2\2\2KL\3\2\2\2LN\7\'\2\2MO\7#\2\2NM\3\2\2\2"+
		"NO\3\2\2\2OQ\3\2\2\2PR\7\4\2\2QP\3\2\2\2QR\3\2\2\2R\u013e\3\2\2\2Sx\7"+
		"&\2\2TU\7\3\2\2UV\5\6\4\2VW\7\"\2\2W_\5\6\4\2XY\7!\2\2YZ\5\6\4\2Z[\7\""+
		"\2\2[\\\5\6\4\2\\^\3\2\2\2]X\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`c\3"+
		"\2\2\2a_\3\2\2\2bd\7#\2\2cb\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\7\4\2\2fy\3"+
		"\2\2\2gh\5\6\4\2hi\7\"\2\2iq\5\6\4\2jk\7!\2\2kl\5\6\4\2lm\7\"\2\2mn\5"+
		"\6\4\2np\3\2\2\2oj\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2ru\3\2\2\2sq\3"+
		"\2\2\2tv\7#\2\2ut\3\2\2\2uv\3\2\2\2vy\3\2\2\2wy\7\"\2\2xT\3\2\2\2xg\3"+
		"\2\2\2xw\3\2\2\2yz\3\2\2\2z|\7\'\2\2{}\7#\2\2|{\3\2\2\2|}\3\2\2\2}\177"+
		"\3\2\2\2~\u0080\7\4\2\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u013e\3\2"+
		"\2\2\u0081\u00a7\7(\2\2\u0082\u0083\7\3\2\2\u0083\u0084\5\6\4\2\u0084"+
		"\u0085\7\"\2\2\u0085\u008d\5\6\4\2\u0086\u0087\7!\2\2\u0087\u0088\5\6"+
		"\4\2\u0088\u0089\7\"\2\2\u0089\u008a\5\6\4\2\u008a\u008c\3\2\2\2\u008b"+
		"\u0086\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0092\7#\2\2\u0091"+
		"\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\7\4"+
		"\2\2\u0094\u00a8\3\2\2\2\u0095\u0096\5\6\4\2\u0096\u0097\7\"\2\2\u0097"+
		"\u009f\5\6\4\2\u0098\u0099\7!\2\2\u0099\u009a\5\6\4\2\u009a\u009b\7\""+
		"\2\2\u009b\u009c\5\6\4\2\u009c\u009e\3\2\2\2\u009d\u0098\3\2\2\2\u009e"+
		"\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a3\3\2"+
		"\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\7#\2\2\u00a3\u00a2\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u0095\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6\u00a8\3\2\2\2\u00a7\u0082\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u013e\7)\2\2\u00aa\u013e\7\n\2\2\u00ab\u013e\7\13"+
		"\2\2\u00ac\u013e\7\f\2\2\u00ad\u00ae\7*\2\2\u00ae\u013e\7\b\2\2\u00af"+
		"\u013e\7\r\2\2\u00b0\u013e\7\16\2\2\u00b1\u00b3\7\n\2\2\u00b2\u00b1\3"+
		"\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b8\t\2\2\2\u00b5"+
		"\u00b7\7\b\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2"+
		"\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb"+
		"\u00bd\5\b\5\2\u00bc\u00bb\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2"+
		"\2\2\u00be\u00bf\7\"\2\2\u00bf\u013e\5\4\3\2\u00c0\u00c2\7\n\2\2\u00c1"+
		"\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c7\t\2"+
		"\2\2\u00c4\u00c6\7\b\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2"+
		"\2\2\u00ca\u00cc\5\b\5\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00ce\7\"\2\2\u00ce\u00d2\7\3\2\2\u00cf\u00d0\5\4"+
		"\3\2\u00d0\u00d1\7#\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00cf\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2"+
		"\2\2\u00d6\u00d7\7\4\2\2\u00d7\u013e\3\2\2\2\u00d8\u00d9\7\n\2\2\u00d9"+
		"\u00da\7\n\2\2\u00da\u013e\7\b\2\2\u00db\u00dc\7\n\2\2\u00dc\u013e\7\b"+
		"\2\2\u00dd\u013e\7\b\2\2\u00de\u00df\7\n\2\2\u00df\u00e0\7\b\2\2\u00e0"+
		"\u00e1\7\37\2\2\u00e1\u00e2\7\3\2\2\u00e2\u00e3\5\6\4\2\u00e3\u00e4\7"+
		"#\2\2\u00e4\u00e5\7\4\2\2\u00e5\u013e\3\2\2\2\u00e6\u00e7\7\b\2\2\u00e7"+
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
		"\25\3\2\2\2\u013d\30\3\2\2\2\u013d\32\3\2\2\2\u013d\36\3\2\2\2\u013d!"+
		"\3\2\2\2\u013d.\3\2\2\2\u013dS\3\2\2\2\u013d\u0081\3\2\2\2\u013d\u00aa"+
		"\3\2\2\2\u013d\u00ab\3\2\2\2\u013d\u00ac\3\2\2\2\u013d\u00ad\3\2\2\2\u013d"+
		"\u00af\3\2\2\2\u013d\u00b0\3\2\2\2\u013d\u00b2\3\2\2\2\u013d\u00c1\3\2"+
		"\2\2\u013d\u00d8\3\2\2\2\u013d\u00db\3\2\2\2\u013d\u00dd\3\2\2\2\u013d"+
		"\u00de\3\2\2\2\u013d\u00e6\3\2\2\2\u013d\u00ed\3\2\2\2\u013d\u00fe\3\2"+
		"\2\2\u013d\u0117\3\2\2\2\u013d\u0126\3\2\2\2\u013e\u0202\3\2\2\2\u013f"+
		"\u0140\f\25\2\2\u0140\u0141\t\3\2\2\u0141\u0201\5\6\4\26\u0142\u0143\f"+
		"\24\2\2\u0143\u0144\t\4\2\2\u0144\u0201\5\6\4\25\u0145\u0146\f\23\2\2"+
		"\u0146\u0147\t\5\2\2\u0147\u0201\5\6\4\24\u0148\u0149\f\22\2\2\u0149\u014a"+
		"\t\6\2\2\u014a\u0201\5\6\4\23\u014b\u014c\f\21\2\2\u014c\u014d\t\7\2\2"+
		"\u014d\u0201\5\6\4\22\u014e\u014f\f\20\2\2\u014f\u0150\t\b\2\2\u0150\u0201"+
		"\5\6\4\21\u0151\u0152\f\13\2\2\u0152\u0153\7 \2\2\u0153\u0154\7\b\2\2"+
		"\u0154\u0155\7\37\2\2\u0155\u0201\5\6\4\f\u0156\u0157\f\t\2\2\u0157\u0159"+
		"\7&\2\2\u0158\u015a\7\3\2\2\u0159\u0158\3\2\2\2\u0159\u015a\3\2\2\2\u015a"+
		"\u0163\3\2\2\2\u015b\u0160\5\6\4\2\u015c\u015d\7!\2\2\u015d\u015f\5\6"+
		"\4\2\u015e\u015c\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0160"+
		"\u0161\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u015b\3\2"+
		"\2\2\u0163\u0164\3\2\2\2\u0164\u0166\3\2\2\2\u0165\u0167\7#\2\2\u0166"+
		"\u0165\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0169\3\2\2\2\u0168\u016a\7\4"+
		"\2\2\u0169\u0168\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b\3\2\2\2\u016b"+
		"\u016c\7\'\2\2\u016c\u016d\7\37\2\2\u016d\u0201\5\6\4\n\u016e\u016f\f"+
		"!\2\2\u016f\u0170\7 \2\2\u0170\u0171\7\b\2\2\u0171\u0172\7$\2\2\u0172"+
		"\u0201\7%\2\2\u0173\u0174\f \2\2\u0174\u0175\7 \2\2\u0175\u0176\7\b\2"+
		"\2\u0176\u0178\7$\2\2\u0177\u0179\7\3\2\2\u0178\u0177\3\2\2\2\u0178\u0179"+
		"\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017f\5\6\4\2\u017b\u017c\7!\2\2\u017c"+
		"\u017e\5\6\4\2\u017d\u017b\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u017d\3\2"+
		"\2\2\u017f\u0180\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0182"+
		"\u0184\7#\2\2\u0183\u0182\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0186\3\2"+
		"\2\2\u0185\u0187\7\4\2\2\u0186\u0185\3\2\2\2\u0186\u0187\3\2\2\2\u0187"+
		"\u0188\3\2\2\2\u0188\u0189\7%\2\2\u0189\u0201\3\2\2\2\u018a\u018b\f\34"+
		"\2\2\u018b\u018c\7 \2\2\u018c\u0201\7\b\2\2\u018d\u018e\f\33\2\2\u018e"+
		"\u0190\7&\2\2\u018f\u0191\7\3\2\2\u0190\u018f\3\2\2\2\u0190\u0191\3\2"+
		"\2\2\u0191\u019a\3\2\2\2\u0192\u0197\5\6\4\2\u0193\u0194\7!\2\2\u0194"+
		"\u0196\5\6\4\2\u0195\u0193\3\2\2\2\u0196\u0199\3\2\2\2\u0197\u0195\3\2"+
		"\2\2\u0197\u0198\3\2\2\2\u0198\u019b\3\2\2\2\u0199\u0197\3\2\2\2\u019a"+
		"\u0192\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019d\3\2\2\2\u019c\u019e\7#"+
		"\2\2\u019d\u019c\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u01a0\3\2\2\2\u019f"+
		"\u01a1\7\4\2\2\u01a0\u019f\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a2\3\2"+
		"\2\2\u01a2\u0201\7\'\2\2\u01a3\u01a4\f\32\2\2\u01a4\u01ab\7(\2\2\u01a5"+
		"\u01a6\7\3\2\2\u01a6\u01a7\5\6\4\2\u01a7\u01a8\7#\2\2\u01a8\u01a9\7\4"+
		"\2\2\u01a9\u01ac\3\2\2\2\u01aa\u01ac\5\6\4\2\u01ab\u01a5\3\2\2\2\u01ab"+
		"\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae\7)\2\2\u01ae\u0201\3\2"+
		"\2\2\u01af\u01b0\f\31\2\2\u01b0\u01b1\7$\2\2\u01b1\u0201\7%\2\2\u01b2"+
		"\u01b3\f\30\2\2\u01b3\u01b5\7$\2\2\u01b4\u01b6\7\3\2\2\u01b5\u01b4\3\2"+
		"\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01bc\5\6\4\2\u01b8"+
		"\u01b9\7!\2\2\u01b9\u01bb\5\6\4\2\u01ba\u01b8\3\2\2\2\u01bb\u01be\3\2"+
		"\2\2\u01bc\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01c0\3\2\2\2\u01be"+
		"\u01bc\3\2\2\2\u01bf\u01c1\7#\2\2\u01c0\u01bf\3\2\2\2\u01c0\u01c1\3\2"+
		"\2\2\u01c1\u01c3\3\2\2\2\u01c2\u01c4\7\4\2\2\u01c3\u01c2\3\2\2\2\u01c3"+
		"\u01c4\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\7%\2\2\u01c6\u0201\3\2"+
		"\2\2\u01c7\u01c8\f\n\2\2\u01c8\u01c9\7 \2\2\u01c9\u01ca\7\b\2\2\u01ca"+
		"\u01cb\7\37\2\2\u01cb\u01cc\7#\2\2\u01cc\u01cd\7\3\2\2\u01cd\u01ce\5\6"+
		"\4\2\u01ce\u01cf\7\4\2\2\u01cf\u0201\3\2\2\2\u01d0\u01d1\f\b\2\2\u01d1"+
		"\u01d3\7&\2\2\u01d2\u01d4\7\3\2\2\u01d3\u01d2\3\2\2\2\u01d3\u01d4\3\2"+
		"\2\2\u01d4\u01dd\3\2\2\2\u01d5\u01da\5\6\4\2\u01d6\u01d7\7!\2\2\u01d7"+
		"\u01d9\5\6\4\2\u01d8\u01d6\3\2\2\2\u01d9\u01dc\3\2\2\2\u01da\u01d8\3\2"+
		"\2\2\u01da\u01db\3\2\2\2\u01db\u01de\3\2\2\2\u01dc\u01da\3\2\2\2\u01dd"+
		"\u01d5\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01e0\3\2\2\2\u01df\u01e1\7#"+
		"\2\2\u01e0\u01df\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e3\3\2\2\2\u01e2"+
		"\u01e4\7\4\2\2\u01e3\u01e2\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\3\2"+
		"\2\2\u01e5\u01e6\7\'\2\2\u01e6\u01e7\7\37\2\2\u01e7\u01e8\7\3\2\2\u01e8"+
		"\u01e9\5\6\4\2\u01e9\u01ea\7#\2\2\u01ea\u01eb\7\4\2\2\u01eb\u0201\3\2"+
		"\2\2\u01ec\u01ed\f\7\2\2\u01ed\u01f4\7(\2\2\u01ee\u01ef\7\3\2\2\u01ef"+
		"\u01f0\5\6\4\2\u01f0\u01f1\7#\2\2\u01f1\u01f2\7\4\2\2\u01f2\u01f5\3\2"+
		"\2\2\u01f3\u01f5\5\6\4\2\u01f4\u01ee\3\2\2\2\u01f4\u01f3\3\2\2\2\u01f5"+
		"\u01f6\3\2\2\2\u01f6\u01f7\7)\2\2\u01f7\u01fe\7\37\2\2\u01f8\u01f9\7\3"+
		"\2\2\u01f9\u01fa\5\6\4\2\u01fa\u01fb\7#\2\2\u01fb\u01fc\7\4\2\2\u01fc"+
		"\u01ff\3\2\2\2\u01fd\u01ff\5\6\4\2\u01fe\u01f8\3\2\2\2\u01fe\u01fd\3\2"+
		"\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0201\3\2\2\2\u0200\u013f\3\2\2\2\u0200"+
		"\u0142\3\2\2\2\u0200\u0145\3\2\2\2\u0200\u0148\3\2\2\2\u0200\u014b\3\2"+
		"\2\2\u0200\u014e\3\2\2\2\u0200\u0151\3\2\2\2\u0200\u0156\3\2\2\2\u0200"+
		"\u016e\3\2\2\2\u0200\u0173\3\2\2\2\u0200\u018a\3\2\2\2\u0200\u018d\3\2"+
		"\2\2\u0200\u01a3\3\2\2\2\u0200\u01af\3\2\2\2\u0200\u01b2\3\2\2\2\u0200"+
		"\u01c7\3\2\2\2\u0200\u01d0\3\2\2\2\u0200\u01ec\3\2\2\2\u0201\u0204\3\2"+
		"\2\2\u0202\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203\7\3\2\2\2\u0204\u0202"+
		"\3\2\2\2\u0205\u0206\7\t\2\2\u0206\u0212\5\6\4\2\u0207\u020b\7\t\2\2\u0208"+
		"\u0209\5\6\4\2\u0209\u020a\7!\2\2\u020a\u020c\3\2\2\2\u020b\u0208\3\2"+
		"\2\2\u020c\u020d\3\2\2\2\u020d\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e"+
		"\u020f\3\2\2\2\u020f\u0210\5\6\4\2\u0210\u0212\3\2\2\2\u0211\u0205\3\2"+
		"\2\2\u0211\u0207\3\2\2\2\u0212\t\3\2\2\2\u0213\u0214\7\6\2\2\u0214\u0218"+
		"\7\3\2\2\u0215\u0216\5\4\3\2\u0216\u0217\7#\2\2\u0217\u0219\3\2\2\2\u0218"+
		"\u0215\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u0218\3\2\2\2\u021a\u021b\3\2"+
		"\2\2\u021b\u021c\3\2\2\2\u021c\u021d\7\4\2\2\u021d\u0221\3\2\2\2\u021e"+
		"\u021f\7\6\2\2\u021f\u0221\5\4\3\2\u0220\u0213\3\2\2\2\u0220\u021e\3\2"+
		"\2\2\u0221\13\3\2\2\2S\21#\'*\659BFHJNQ_cqux|\177\u008d\u0091\u009f\u00a3"+
		"\u00a5\u00a7\u00b2\u00b8\u00bc\u00c1\u00c7\u00cb\u00d4\u00f0\u00f4\u00f7"+
		"\u00fc\u0101\u0105\u0108\u0111\u0115\u011a\u011e\u0121\u0129\u012d\u0130"+
		"\u0139\u013d\u0159\u0160\u0163\u0166\u0169\u0178\u017f\u0183\u0186\u0190"+
		"\u0197\u019a\u019d\u01a0\u01ab\u01b5\u01bc\u01c0\u01c3\u01d3\u01da\u01dd"+
		"\u01e0\u01e3\u01f4\u01fe\u0200\u0202\u020d\u0211\u021a\u0220";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}