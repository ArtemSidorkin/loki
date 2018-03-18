// Generated from ./src/main/java/loki/language/parsing/Loki.grammar by ANTLR 4.5

package loki.language.parsing;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

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
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(LokiParser.SEMICOLON, 0); }
		public TerminalNode END() { return getToken(LokiParser.END, 0); }
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
		public List<TerminalNode> COLON() { return getTokens(LokiParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(LokiParser.COLON, i);
		}
		public TerminalNode BEGIN() { return getToken(LokiParser.BEGIN, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(LokiParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LokiParser.SEMICOLON, i);
		}
		public List<TerminalNode> END() { return getTokens(LokiParser.END); }
		public TerminalNode END(int i) {
			return getToken(LokiParser.END, i);
		}
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
			setState(286);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
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
				setState(46);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(45);
					match(BEGIN);
					}
				}

				setState(56);
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
					}
				}

				setState(59);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(58);
					match(SEMICOLON);
					}
				}

				setState(62);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(61);
					match(END);
					}
				}

				setState(64);
				match(RIGHT_BRACKET);
				}
				break;
			case 7:
				{
				_localctx = new MapContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
				match(LEFT_BRACKET);
				setState(67);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(66);
					match(BEGIN);
					}
				}

				setState(83);
				switch (_input.LA(1)) {
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
					setState(69);
					expression(0);
					setState(70);
					match(COLON);
					setState(71);
					expression(0);
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(72);
						match(COMMA);
						setState(73);
						expression(0);
						setState(74);
						match(COLON);
						setState(75);
						expression(0);
						}
						}
						setState(81);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case COLON:
					{
					setState(82);
					match(COLON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(86);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(85);
					match(SEMICOLON);
					}
				}

				setState(89);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(88);
					match(END);
					}
				}

				setState(91);
				match(RIGHT_BRACKET);
				setState(93);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(92);
					match(SEMICOLON);
					}
					break;
				}
				setState(96);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(95);
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
				setState(98);
				match(LEFT_BRACE);
				setState(136);
				switch (_input.LA(1)) {
				case BEGIN:
					{
					{
					setState(99);
					match(BEGIN);
					setState(100);
					expression(0);
					setState(101);
					match(COLON);
					setState(102);
					expression(0);
					setState(110);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(103);
						match(COMMA);
						setState(104);
						expression(0);
						setState(105);
						match(COLON);
						setState(106);
						expression(0);
						}
						}
						setState(112);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(114);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(113);
						match(SEMICOLON);
						}
					}

					setState(116);
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
					setState(134);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0)) {
						{
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
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(131);
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
				setState(138);
				match(RIGHT_BRACE);
				}
				break;
			case 9:
				{
				_localctx = new HostContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				match(DOLLAR);
				}
				break;
			case 10:
				{
				_localctx = new ThisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(AT);
				}
				break;
			case 11:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				match(CHARACTERS);
				}
				break;
			case 12:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				match(ACUTE);
				setState(143);
				match(IDENTIFIER);
				}
				break;
			case 13:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				match(FLOAT);
				}
				break;
			case 14:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				match(INT);
				}
				break;
			case 15:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(146);
					match(DOLLAR);
					}
				}

				setState(149);
				((UnitContext)_localctx).head = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==BACKSLASH) ) {
					((UnitContext)_localctx).head = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(150);
					match(IDENTIFIER);
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(157);
				_la = _input.LA(1);
				if (_la==LEFT_THIN_ARROW) {
					{
					setState(156);
					inheritance();
					}
				}

				setState(159);
				match(COLON);
				setState(160);
				instruction();
				}
				break;
			case 16:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(161);
					match(DOLLAR);
					}
				}

				setState(164);
				((UnitContext)_localctx).head = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==BACKSLASH) ) {
					((UnitContext)_localctx).head = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(165);
					match(IDENTIFIER);
					}
					}
					setState(170);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(172);
				_la = _input.LA(1);
				if (_la==LEFT_THIN_ARROW) {
					{
					setState(171);
					inheritance();
					}
				}

				setState(174);
				match(COLON);
				setState(175);
				match(BEGIN);
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(176);
					instruction();
					setState(177);
					match(SEMICOLON);
					}
					}
					setState(181); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0) );
				setState(183);
				match(END);
				}
				break;
			case 17:
				{
				_localctx = new SuperHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
				match(DOLLAR);
				setState(186);
				match(DOLLAR);
				setState(187);
				match(IDENTIFIER);
				}
				break;
			case 18:
				{
				_localctx = new HostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				match(DOLLAR);
				setState(189);
				match(IDENTIFIER);
				}
				break;
			case 19:
				{
				_localctx = new VariableOrParameterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				match(IDENTIFIER);
				}
				break;
			case 20:
				{
				_localctx = new AssignHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				match(DOLLAR);
				setState(192);
				match(IDENTIFIER);
				setState(193);
				match(EQUALS);
				setState(194);
				match(BEGIN);
				setState(195);
				expression(0);
				setState(196);
				match(SEMICOLON);
				setState(197);
				match(END);
				}
				break;
			case 21:
				{
				_localctx = new AssignVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				match(IDENTIFIER);
				setState(200);
				match(EQUALS);
				setState(201);
				match(BEGIN);
				setState(202);
				expression(0);
				setState(203);
				match(SEMICOLON);
				setState(204);
				match(END);
				}
				break;
			case 22:
				{
				_localctx = new IfElseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				match(IF);
				setState(207);
				match(LEFT_PARENTHESIS);
				setState(209);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(208);
					match(BEGIN);
					}
				}

				setState(211);
				expression(0);
				setState(213);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(212);
					match(SEMICOLON);
					}
				}

				setState(216);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(215);
					match(END);
					}
				}

				setState(218);
				match(RIGHT_PARENTHESIS);
				setState(219);
				instruction();
				setState(221);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(220);
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
				setState(223);
				match(IF);
				setState(224);
				match(LEFT_PARENTHESIS);
				setState(226);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(225);
					match(BEGIN);
					}
				}

				setState(228);
				expression(0);
				setState(230);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(229);
					match(SEMICOLON);
					}
				}

				setState(233);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(232);
					match(END);
					}
				}

				setState(235);
				match(RIGHT_PARENTHESIS);
				setState(236);
				match(BEGIN);
				setState(240); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(237);
					instruction();
					setState(238);
					match(SEMICOLON);
					}
					}
					setState(242); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0) );
				setState(244);
				match(END);
				setState(246);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(245);
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
				setState(248);
				match(WHILE);
				setState(249);
				match(LEFT_PARENTHESIS);
				setState(251);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(250);
					match(BEGIN);
					}
				}

				setState(253);
				expression(0);
				setState(255);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(254);
					match(SEMICOLON);
					}
				}

				setState(258);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(257);
					match(END);
					}
				}

				setState(260);
				match(RIGHT_PARENTHESIS);
				setState(261);
				instruction();
				}
				break;
			case 25:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(263);
				match(WHILE);
				setState(264);
				match(LEFT_PARENTHESIS);
				setState(266);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(265);
					match(BEGIN);
					}
				}

				setState(268);
				expression(0);
				setState(270);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(269);
					match(SEMICOLON);
					}
				}

				setState(273);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(272);
					match(END);
					}
				}

				setState(275);
				match(RIGHT_PARENTHESIS);
				setState(276);
				match(BEGIN);
				setState(280); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(277);
					instruction();
					setState(278);
					match(SEMICOLON);
					}
					}
					setState(282); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0) );
				setState(284);
				match(END);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(483);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(481);
					switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(288);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(289);
						((MulDivContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==STAR || _la==SLASH) ) {
							((MulDivContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(290);
						expression(20);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(291);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(292);
						((AddSubContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((AddSubContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(293);
						expression(19);
						}
						break;
					case 3:
						{
						_localctx = new EqNeqContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(294);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(295);
						((EqNeqContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUALS_EQUALS || _la==BANG_EQUALS) ) {
							((EqNeqContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(296);
						expression(18);
						}
						break;
					case 4:
						{
						_localctx = new GteLteGtLtContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(297);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(298);
						((GteLteGtLtContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATER_THAN_EQUALS) | (1L << GREATER_THAN) | (1L << LESS_THAN_EQUALS) | (1L << LESS_THAN))) != 0)) ) {
							((GteLteGtLtContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(299);
						expression(17);
						}
						break;
					case 5:
						{
						_localctx = new AmpersandAmpersandContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(300);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(301);
						((AmpersandAmpersandContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AMPERSAND_AMPERSAND) ) {
							((AmpersandAmpersandContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(302);
						expression(16);
						}
						break;
					case 6:
						{
						_localctx = new PipePipeContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(303);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(304);
						((PipePipeContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PIPE_PIPE) ) {
							((PipePipeContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(305);
						expression(15);
						}
						break;
					case 7:
						{
						_localctx = new AssignMemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(306);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(307);
						match(DOT);
						setState(308);
						match(IDENTIFIER);
						setState(309);
						match(EQUALS);
						setState(310);
						expression(10);
						}
						break;
					case 8:
						{
						_localctx = new AssignIndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(311);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(312);
						match(LEFT_BRACKET);
						setState(314);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(313);
							match(BEGIN);
							}
						}

						setState(324);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0)) {
							{
							setState(316);
							expression(0);
							setState(321);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(317);
								match(COMMA);
								setState(318);
								expression(0);
								}
								}
								setState(323);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(327);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(326);
							match(SEMICOLON);
							}
						}

						setState(330);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(329);
							match(END);
							}
						}

						setState(332);
						match(RIGHT_BRACKET);
						setState(333);
						match(EQUALS);
						setState(334);
						expression(8);
						}
						break;
					case 9:
						{
						_localctx = new MemberCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(335);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(336);
						match(DOT);
						setState(337);
						match(IDENTIFIER);
						setState(338);
						match(LEFT_PARENTHESIS);
						setState(339);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 10:
						{
						_localctx = new MemberCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(340);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(341);
						match(DOT);
						setState(342);
						match(IDENTIFIER);
						setState(343);
						match(LEFT_PARENTHESIS);
						setState(345);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(344);
							match(BEGIN);
							}
						}

						setState(347);
						expression(0);
						setState(352);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(348);
							match(COMMA);
							setState(349);
							expression(0);
							}
							}
							setState(354);
							_errHandler.sync(this);
							_la = _input.LA(1);
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
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 11:
						{
						_localctx = new MemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(363);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(364);
						match(DOT);
						setState(365);
						match(IDENTIFIER);
						}
						break;
					case 12:
						{
						_localctx = new IndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(366);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(367);
						match(LEFT_BRACKET);
						setState(369);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(368);
							match(BEGIN);
							}
						}

						setState(379);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0)) {
							{
							setState(371);
							expression(0);
							setState(376);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(372);
								match(COMMA);
								setState(373);
								expression(0);
								}
								}
								setState(378);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(382);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(381);
							match(SEMICOLON);
							}
						}

						setState(385);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(384);
							match(END);
							}
						}

						setState(387);
						match(RIGHT_BRACKET);
						}
						break;
					case 13:
						{
						_localctx = new MemberAccessorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(388);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(389);
						match(LEFT_BRACE);
						setState(396);
						switch (_input.LA(1)) {
						case BEGIN:
							{
							{
							setState(390);
							match(BEGIN);
							setState(391);
							expression(0);
							setState(392);
							match(SEMICOLON);
							setState(393);
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
							setState(395);
							expression(0);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(398);
						match(RIGHT_BRACE);
						}
						break;
					case 14:
						{
						_localctx = new CallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(400);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(401);
						match(LEFT_PARENTHESIS);
						setState(402);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 15:
						{
						_localctx = new CallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(403);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(404);
						match(LEFT_PARENTHESIS);
						setState(406);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(405);
							match(BEGIN);
							}
						}

						setState(408);
						expression(0);
						setState(413);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(409);
							match(COMMA);
							setState(410);
							expression(0);
							}
							}
							setState(415);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(417);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(416);
							match(SEMICOLON);
							}
						}

						setState(420);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(419);
							match(END);
							}
						}

						setState(422);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 16:
						{
						_localctx = new AssignMemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(424);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(425);
						match(DOT);
						setState(426);
						match(IDENTIFIER);
						setState(427);
						match(EQUALS);
						setState(428);
						match(SEMICOLON);
						setState(429);
						match(BEGIN);
						setState(430);
						expression(0);
						setState(431);
						match(END);
						}
						break;
					case 17:
						{
						_localctx = new AssignIndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(433);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(434);
						match(LEFT_BRACKET);
						setState(436);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(435);
							match(BEGIN);
							}
						}

						setState(446);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0)) {
							{
							setState(438);
							expression(0);
							setState(443);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(439);
								match(COMMA);
								setState(440);
								expression(0);
								}
								}
								setState(445);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(449);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(448);
							match(SEMICOLON);
							}
						}

						setState(452);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(451);
							match(END);
							}
						}

						setState(454);
						match(RIGHT_BRACKET);
						setState(455);
						match(EQUALS);
						setState(456);
						match(BEGIN);
						setState(457);
						expression(0);
						setState(458);
						match(SEMICOLON);
						setState(459);
						match(END);
						}
						break;
					case 18:
						{
						_localctx = new AssignMemberAccessorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(461);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(462);
						match(LEFT_BRACE);
						setState(469);
						switch (_input.LA(1)) {
						case BEGIN:
							{
							{
							setState(463);
							match(BEGIN);
							setState(464);
							expression(0);
							setState(465);
							match(SEMICOLON);
							setState(466);
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
							setState(468);
							expression(0);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(471);
						match(RIGHT_BRACE);
						setState(472);
						match(EQUALS);
						setState(479);
						switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
						case 1:
							{
							{
							setState(473);
							match(BEGIN);
							setState(474);
							expression(0);
							setState(475);
							match(SEMICOLON);
							setState(476);
							match(END);
							}
							}
							break;
						case 2:
							{
							setState(478);
							expression(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(485);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
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
			setState(498);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(486);
				match(LEFT_THIN_ARROW);
				setState(487);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(488);
				match(LEFT_THIN_ARROW);
				setState(492); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(489);
						expression(0);
						setState(490);
						match(COMMA);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(494); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(496);
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
			setState(513);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(500);
				match(ELSE);
				setState(501);
				match(BEGIN);
				setState(505); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(502);
					instruction();
					setState(503);
					match(SEMICOLON);
					}
					}
					setState(507); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE) | (1L << ACUTE))) != 0) );
				setState(509);
				match(END);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(511);
				match(ELSE);
				setState(512);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u0206\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\6\2\20\n\2\r\2\16\2\21\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4$\n\4"+
		"\3\4\3\4\5\4(\n\4\3\4\5\4+\n\4\3\4\3\4\3\4\3\4\5\4\61\n\4\3\4\3\4\3\4"+
		"\7\4\66\n\4\f\4\16\49\13\4\5\4;\n\4\3\4\5\4>\n\4\3\4\5\4A\n\4\3\4\3\4"+
		"\3\4\5\4F\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4P\n\4\f\4\16\4S\13\4"+
		"\3\4\5\4V\n\4\3\4\5\4Y\n\4\3\4\5\4\\\n\4\3\4\3\4\5\4`\n\4\3\4\5\4c\n\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4o\n\4\f\4\16\4r\13\4\3\4\5"+
		"\4u\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0081\n\4\f\4\16\4"+
		"\u0084\13\4\3\4\5\4\u0087\n\4\5\4\u0089\n\4\5\4\u008b\n\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0096\n\4\3\4\3\4\7\4\u009a\n\4\f\4\16\4"+
		"\u009d\13\4\3\4\5\4\u00a0\n\4\3\4\3\4\3\4\5\4\u00a5\n\4\3\4\3\4\7\4\u00a9"+
		"\n\4\f\4\16\4\u00ac\13\4\3\4\5\4\u00af\n\4\3\4\3\4\3\4\3\4\3\4\6\4\u00b6"+
		"\n\4\r\4\16\4\u00b7\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00d4\n\4\3"+
		"\4\3\4\5\4\u00d8\n\4\3\4\5\4\u00db\n\4\3\4\3\4\3\4\5\4\u00e0\n\4\3\4\3"+
		"\4\3\4\5\4\u00e5\n\4\3\4\3\4\5\4\u00e9\n\4\3\4\5\4\u00ec\n\4\3\4\3\4\3"+
		"\4\3\4\3\4\6\4\u00f3\n\4\r\4\16\4\u00f4\3\4\3\4\5\4\u00f9\n\4\3\4\3\4"+
		"\3\4\5\4\u00fe\n\4\3\4\3\4\5\4\u0102\n\4\3\4\5\4\u0105\n\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4\u010d\n\4\3\4\3\4\5\4\u0111\n\4\3\4\5\4\u0114\n\4\3\4"+
		"\3\4\3\4\3\4\3\4\6\4\u011b\n\4\r\4\16\4\u011c\3\4\3\4\5\4\u0121\n\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u013d\n\4\3\4\3\4\3\4\7\4\u0142\n"+
		"\4\f\4\16\4\u0145\13\4\5\4\u0147\n\4\3\4\5\4\u014a\n\4\3\4\5\4\u014d\n"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u015c\n\4\3"+
		"\4\3\4\3\4\7\4\u0161\n\4\f\4\16\4\u0164\13\4\3\4\5\4\u0167\n\4\3\4\5\4"+
		"\u016a\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0174\n\4\3\4\3\4\3\4\7"+
		"\4\u0179\n\4\f\4\16\4\u017c\13\4\5\4\u017e\n\4\3\4\5\4\u0181\n\4\3\4\5"+
		"\4\u0184\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u018f\n\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0199\n\4\3\4\3\4\3\4\7\4\u019e\n\4\f\4\16"+
		"\4\u01a1\13\4\3\4\5\4\u01a4\n\4\3\4\5\4\u01a7\n\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u01b7\n\4\3\4\3\4\3\4\7\4\u01bc"+
		"\n\4\f\4\16\4\u01bf\13\4\5\4\u01c1\n\4\3\4\5\4\u01c4\n\4\3\4\5\4\u01c7"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u01d8"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u01e2\n\4\7\4\u01e4\n\4\f\4\16"+
		"\4\u01e7\13\4\3\5\3\5\3\5\3\5\3\5\3\5\6\5\u01ef\n\5\r\5\16\5\u01f0\3\5"+
		"\3\5\5\5\u01f5\n\5\3\6\3\6\3\6\3\6\3\6\6\6\u01fc\n\6\r\6\16\6\u01fd\3"+
		"\6\3\6\3\6\3\6\5\6\u0204\n\6\3\6\2\3\6\7\2\4\6\b\n\2\t\4\2\b\b\23\23\3"+
		"\2\21\22\3\2\17\20\3\2\24\25\3\2\26\31\3\2\32\32\3\2\33\33\u0276\2\17"+
		"\3\2\2\2\4\23\3\2\2\2\6\u0120\3\2\2\2\b\u01f4\3\2\2\2\n\u0203\3\2\2\2"+
		"\f\r\5\4\3\2\r\16\7#\2\2\16\20\3\2\2\2\17\f\3\2\2\2\20\21\3\2\2\2\21\17"+
		"\3\2\2\2\21\22\3\2\2\2\22\3\3\2\2\2\23\24\5\6\4\2\24\5\3\2\2\2\25\26\b"+
		"\4\1\2\26\27\7\20\2\2\27\u0121\5\6\4\27\30\31\7\34\2\2\31\u0121\5\6\4"+
		"\26\32\33\7\n\2\2\33\34\7\b\2\2\34\35\7\37\2\2\35\u0121\5\6\4\17\36\37"+
		"\7\b\2\2\37 \7\37\2\2 \u0121\5\6\4\r!#\7$\2\2\"$\7\3\2\2#\"\3\2\2\2#$"+
		"\3\2\2\2$%\3\2\2\2%\'\5\6\4\2&(\7#\2\2\'&\3\2\2\2\'(\3\2\2\2(*\3\2\2\2"+
		")+\7\4\2\2*)\3\2\2\2*+\3\2\2\2+,\3\2\2\2,-\7%\2\2-\u0121\3\2\2\2.\60\7"+
		"&\2\2/\61\7\3\2\2\60/\3\2\2\2\60\61\3\2\2\2\61:\3\2\2\2\62\67\5\6\4\2"+
		"\63\64\7!\2\2\64\66\5\6\4\2\65\63\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\67"+
		"8\3\2\2\28;\3\2\2\29\67\3\2\2\2:\62\3\2\2\2:;\3\2\2\2;=\3\2\2\2<>\7#\2"+
		"\2=<\3\2\2\2=>\3\2\2\2>@\3\2\2\2?A\7\4\2\2@?\3\2\2\2@A\3\2\2\2AB\3\2\2"+
		"\2B\u0121\7\'\2\2CE\7&\2\2DF\7\3\2\2ED\3\2\2\2EF\3\2\2\2FU\3\2\2\2GH\5"+
		"\6\4\2HI\7\"\2\2IQ\5\6\4\2JK\7!\2\2KL\5\6\4\2LM\7\"\2\2MN\5\6\4\2NP\3"+
		"\2\2\2OJ\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RV\3\2\2\2SQ\3\2\2\2TV\7"+
		"\"\2\2UG\3\2\2\2UT\3\2\2\2VX\3\2\2\2WY\7#\2\2XW\3\2\2\2XY\3\2\2\2Y[\3"+
		"\2\2\2Z\\\7\4\2\2[Z\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]_\7\'\2\2^`\7#\2\2_"+
		"^\3\2\2\2_`\3\2\2\2`b\3\2\2\2ac\7\4\2\2ba\3\2\2\2bc\3\2\2\2c\u0121\3\2"+
		"\2\2d\u008a\7(\2\2ef\7\3\2\2fg\5\6\4\2gh\7\"\2\2hp\5\6\4\2ij\7!\2\2jk"+
		"\5\6\4\2kl\7\"\2\2lm\5\6\4\2mo\3\2\2\2ni\3\2\2\2or\3\2\2\2pn\3\2\2\2p"+
		"q\3\2\2\2qt\3\2\2\2rp\3\2\2\2su\7#\2\2ts\3\2\2\2tu\3\2\2\2uv\3\2\2\2v"+
		"w\7\4\2\2w\u008b\3\2\2\2xy\5\6\4\2yz\7\"\2\2z\u0082\5\6\4\2{|\7!\2\2|"+
		"}\5\6\4\2}~\7\"\2\2~\177\5\6\4\2\177\u0081\3\2\2\2\u0080{\3\2\2\2\u0081"+
		"\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0086\3\2"+
		"\2\2\u0084\u0082\3\2\2\2\u0085\u0087\7#\2\2\u0086\u0085\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088x\3\2\2\2\u0088\u0089\3\2\2\2"+
		"\u0089\u008b\3\2\2\2\u008ae\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\3"+
		"\2\2\2\u008c\u0121\7)\2\2\u008d\u0121\7\n\2\2\u008e\u0121\7\13\2\2\u008f"+
		"\u0121\7\f\2\2\u0090\u0091\7*\2\2\u0091\u0121\7\b\2\2\u0092\u0121\7\r"+
		"\2\2\u0093\u0121\7\16\2\2\u0094\u0096\7\n\2\2\u0095\u0094\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u009b\t\2\2\2\u0098\u009a\7\b"+
		"\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\5\b"+
		"\5\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u00a2\7\"\2\2\u00a2\u0121\5\4\3\2\u00a3\u00a5\7\n\2\2\u00a4\u00a3\3\2"+
		"\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00aa\t\2\2\2\u00a7"+
		"\u00a9\7\b\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2"+
		"\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad"+
		"\u00af\5\b\5\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\u00b1\7\"\2\2\u00b1\u00b5\7\3\2\2\u00b2\u00b3\5\4\3\2\u00b3"+
		"\u00b4\7#\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b2\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00ba\7\4\2\2\u00ba\u0121\3\2\2\2\u00bb\u00bc\7\n\2\2\u00bc\u00bd\7\n"+
		"\2\2\u00bd\u0121\7\b\2\2\u00be\u00bf\7\n\2\2\u00bf\u0121\7\b\2\2\u00c0"+
		"\u0121\7\b\2\2\u00c1\u00c2\7\n\2\2\u00c2\u00c3\7\b\2\2\u00c3\u00c4\7\37"+
		"\2\2\u00c4\u00c5\7\3\2\2\u00c5\u00c6\5\6\4\2\u00c6\u00c7\7#\2\2\u00c7"+
		"\u00c8\7\4\2\2\u00c8\u0121\3\2\2\2\u00c9\u00ca\7\b\2\2\u00ca\u00cb\7\37"+
		"\2\2\u00cb\u00cc\7\3\2\2\u00cc\u00cd\5\6\4\2\u00cd\u00ce\7#\2\2\u00ce"+
		"\u00cf\7\4\2\2\u00cf\u0121\3\2\2\2\u00d0\u00d1\7\5\2\2\u00d1\u00d3\7$"+
		"\2\2\u00d2\u00d4\7\3\2\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d7\5\6\4\2\u00d6\u00d8\7#\2\2\u00d7\u00d6\3\2"+
		"\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9\u00db\7\4\2\2\u00da"+
		"\u00d9\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\7%"+
		"\2\2\u00dd\u00df\5\4\3\2\u00de\u00e0\5\n\6\2\u00df\u00de\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u0121\3\2\2\2\u00e1\u00e2\7\5\2\2\u00e2\u00e4\7$"+
		"\2\2\u00e3\u00e5\7\3\2\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\u00e6\3\2\2\2\u00e6\u00e8\5\6\4\2\u00e7\u00e9\7#\2\2\u00e8\u00e7\3\2"+
		"\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00ec\7\4\2\2\u00eb"+
		"\u00ea\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\7%"+
		"\2\2\u00ee\u00f2\7\3\2\2\u00ef\u00f0\5\4\3\2\u00f0\u00f1\7#\2\2\u00f1"+
		"\u00f3\3\2\2\2\u00f2\u00ef\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2\3\2"+
		"\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\7\4\2\2\u00f7"+
		"\u00f9\5\n\6\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u0121\3\2"+
		"\2\2\u00fa\u00fb\7\7\2\2\u00fb\u00fd\7$\2\2\u00fc\u00fe\7\3\2\2\u00fd"+
		"\u00fc\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\5\6"+
		"\4\2\u0100\u0102\7#\2\2\u0101\u0100\3\2\2\2\u0101\u0102\3\2\2\2\u0102"+
		"\u0104\3\2\2\2\u0103\u0105\7\4\2\2\u0104\u0103\3\2\2\2\u0104\u0105\3\2"+
		"\2\2\u0105\u0106\3\2\2\2\u0106\u0107\7%\2\2\u0107\u0108\5\4\3\2\u0108"+
		"\u0121\3\2\2\2\u0109\u010a\7\7\2\2\u010a\u010c\7$\2\2\u010b\u010d\7\3"+
		"\2\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\u0110\5\6\4\2\u010f\u0111\7#\2\2\u0110\u010f\3\2\2\2\u0110\u0111\3\2"+
		"\2\2\u0111\u0113\3\2\2\2\u0112\u0114\7\4\2\2\u0113\u0112\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\7%\2\2\u0116\u011a\7\3"+
		"\2\2\u0117\u0118\5\4\3\2\u0118\u0119\7#\2\2\u0119\u011b\3\2\2\2\u011a"+
		"\u0117\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2"+
		"\2\2\u011d\u011e\3\2\2\2\u011e\u011f\7\4\2\2\u011f\u0121\3\2\2\2\u0120"+
		"\25\3\2\2\2\u0120\30\3\2\2\2\u0120\32\3\2\2\2\u0120\36\3\2\2\2\u0120!"+
		"\3\2\2\2\u0120.\3\2\2\2\u0120C\3\2\2\2\u0120d\3\2\2\2\u0120\u008d\3\2"+
		"\2\2\u0120\u008e\3\2\2\2\u0120\u008f\3\2\2\2\u0120\u0090\3\2\2\2\u0120"+
		"\u0092\3\2\2\2\u0120\u0093\3\2\2\2\u0120\u0095\3\2\2\2\u0120\u00a4\3\2"+
		"\2\2\u0120\u00bb\3\2\2\2\u0120\u00be\3\2\2\2\u0120\u00c0\3\2\2\2\u0120"+
		"\u00c1\3\2\2\2\u0120\u00c9\3\2\2\2\u0120\u00d0\3\2\2\2\u0120\u00e1\3\2"+
		"\2\2\u0120\u00fa\3\2\2\2\u0120\u0109\3\2\2\2\u0121\u01e5\3\2\2\2\u0122"+
		"\u0123\f\25\2\2\u0123\u0124\t\3\2\2\u0124\u01e4\5\6\4\26\u0125\u0126\f"+
		"\24\2\2\u0126\u0127\t\4\2\2\u0127\u01e4\5\6\4\25\u0128\u0129\f\23\2\2"+
		"\u0129\u012a\t\5\2\2\u012a\u01e4\5\6\4\24\u012b\u012c\f\22\2\2\u012c\u012d"+
		"\t\6\2\2\u012d\u01e4\5\6\4\23\u012e\u012f\f\21\2\2\u012f\u0130\t\7\2\2"+
		"\u0130\u01e4\5\6\4\22\u0131\u0132\f\20\2\2\u0132\u0133\t\b\2\2\u0133\u01e4"+
		"\5\6\4\21\u0134\u0135\f\13\2\2\u0135\u0136\7 \2\2\u0136\u0137\7\b\2\2"+
		"\u0137\u0138\7\37\2\2\u0138\u01e4\5\6\4\f\u0139\u013a\f\t\2\2\u013a\u013c"+
		"\7&\2\2\u013b\u013d\7\3\2\2\u013c\u013b\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"\u0146\3\2\2\2\u013e\u0143\5\6\4\2\u013f\u0140\7!\2\2\u0140\u0142\5\6"+
		"\4\2\u0141\u013f\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143"+
		"\u0144\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u013e\3\2"+
		"\2\2\u0146\u0147\3\2\2\2\u0147\u0149\3\2\2\2\u0148\u014a\7#\2\2\u0149"+
		"\u0148\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c\3\2\2\2\u014b\u014d\7\4"+
		"\2\2\u014c\u014b\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		"\u014f\7\'\2\2\u014f\u0150\7\37\2\2\u0150\u01e4\5\6\4\n\u0151\u0152\f"+
		"!\2\2\u0152\u0153\7 \2\2\u0153\u0154\7\b\2\2\u0154\u0155\7$\2\2\u0155"+
		"\u01e4\7%\2\2\u0156\u0157\f \2\2\u0157\u0158\7 \2\2\u0158\u0159\7\b\2"+
		"\2\u0159\u015b\7$\2\2\u015a\u015c\7\3\2\2\u015b\u015a\3\2\2\2\u015b\u015c"+
		"\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u0162\5\6\4\2\u015e\u015f\7!\2\2\u015f"+
		"\u0161\5\6\4\2\u0160\u015e\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2"+
		"\2\2\u0162\u0163\3\2\2\2\u0163\u0166\3\2\2\2\u0164\u0162\3\2\2\2\u0165"+
		"\u0167\7#\2\2\u0166\u0165\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0169\3\2"+
		"\2\2\u0168\u016a\7\4\2\2\u0169\u0168\3\2\2\2\u0169\u016a\3\2\2\2\u016a"+
		"\u016b\3\2\2\2\u016b\u016c\7%\2\2\u016c\u01e4\3\2\2\2\u016d\u016e\f\34"+
		"\2\2\u016e\u016f\7 \2\2\u016f\u01e4\7\b\2\2\u0170\u0171\f\33\2\2\u0171"+
		"\u0173\7&\2\2\u0172\u0174\7\3\2\2\u0173\u0172\3\2\2\2\u0173\u0174\3\2"+
		"\2\2\u0174\u017d\3\2\2\2\u0175\u017a\5\6\4\2\u0176\u0177\7!\2\2\u0177"+
		"\u0179\5\6\4\2\u0178\u0176\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2"+
		"\2\2\u017a\u017b\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017d"+
		"\u0175\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0180\3\2\2\2\u017f\u0181\7#"+
		"\2\2\u0180\u017f\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0183\3\2\2\2\u0182"+
		"\u0184\7\4\2\2\u0183\u0182\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0185\3\2"+
		"\2\2\u0185\u01e4\7\'\2\2\u0186\u0187\f\32\2\2\u0187\u018e\7(\2\2\u0188"+
		"\u0189\7\3\2\2\u0189\u018a\5\6\4\2\u018a\u018b\7#\2\2\u018b\u018c\7\4"+
		"\2\2\u018c\u018f\3\2\2\2\u018d\u018f\5\6\4\2\u018e\u0188\3\2\2\2\u018e"+
		"\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\7)\2\2\u0191\u01e4\3\2"+
		"\2\2\u0192\u0193\f\31\2\2\u0193\u0194\7$\2\2\u0194\u01e4\7%\2\2\u0195"+
		"\u0196\f\30\2\2\u0196\u0198\7$\2\2\u0197\u0199\7\3\2\2\u0198\u0197\3\2"+
		"\2\2\u0198\u0199\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019f\5\6\4\2\u019b"+
		"\u019c\7!\2\2\u019c\u019e\5\6\4\2\u019d\u019b\3\2\2\2\u019e\u01a1\3\2"+
		"\2\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1"+
		"\u019f\3\2\2\2\u01a2\u01a4\7#\2\2\u01a3\u01a2\3\2\2\2\u01a3\u01a4\3\2"+
		"\2\2\u01a4\u01a6\3\2\2\2\u01a5\u01a7\7\4\2\2\u01a6\u01a5\3\2\2\2\u01a6"+
		"\u01a7\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\7%\2\2\u01a9\u01e4\3\2"+
		"\2\2\u01aa\u01ab\f\n\2\2\u01ab\u01ac\7 \2\2\u01ac\u01ad\7\b\2\2\u01ad"+
		"\u01ae\7\37\2\2\u01ae\u01af\7#\2\2\u01af\u01b0\7\3\2\2\u01b0\u01b1\5\6"+
		"\4\2\u01b1\u01b2\7\4\2\2\u01b2\u01e4\3\2\2\2\u01b3\u01b4\f\b\2\2\u01b4"+
		"\u01b6\7&\2\2\u01b5\u01b7\7\3\2\2\u01b6\u01b5\3\2\2\2\u01b6\u01b7\3\2"+
		"\2\2\u01b7\u01c0\3\2\2\2\u01b8\u01bd\5\6\4\2\u01b9\u01ba\7!\2\2\u01ba"+
		"\u01bc\5\6\4\2\u01bb\u01b9\3\2\2\2\u01bc\u01bf\3\2\2\2\u01bd\u01bb\3\2"+
		"\2\2\u01bd\u01be\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01c0"+
		"\u01b8\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c3\3\2\2\2\u01c2\u01c4\7#"+
		"\2\2\u01c3\u01c2\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c6\3\2\2\2\u01c5"+
		"\u01c7\7\4\2\2\u01c6\u01c5\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c8\3\2"+
		"\2\2\u01c8\u01c9\7\'\2\2\u01c9\u01ca\7\37\2\2\u01ca\u01cb\7\3\2\2\u01cb"+
		"\u01cc\5\6\4\2\u01cc\u01cd\7#\2\2\u01cd\u01ce\7\4\2\2\u01ce\u01e4\3\2"+
		"\2\2\u01cf\u01d0\f\7\2\2\u01d0\u01d7\7(\2\2\u01d1\u01d2\7\3\2\2\u01d2"+
		"\u01d3\5\6\4\2\u01d3\u01d4\7#\2\2\u01d4\u01d5\7\4\2\2\u01d5\u01d8\3\2"+
		"\2\2\u01d6\u01d8\5\6\4\2\u01d7\u01d1\3\2\2\2\u01d7\u01d6\3\2\2\2\u01d8"+
		"\u01d9\3\2\2\2\u01d9\u01da\7)\2\2\u01da\u01e1\7\37\2\2\u01db\u01dc\7\3"+
		"\2\2\u01dc\u01dd\5\6\4\2\u01dd\u01de\7#\2\2\u01de\u01df\7\4\2\2\u01df"+
		"\u01e2\3\2\2\2\u01e0\u01e2\5\6\4\2\u01e1\u01db\3\2\2\2\u01e1\u01e0\3\2"+
		"\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e4\3\2\2\2\u01e3\u0122\3\2\2\2\u01e3"+
		"\u0125\3\2\2\2\u01e3\u0128\3\2\2\2\u01e3\u012b\3\2\2\2\u01e3\u012e\3\2"+
		"\2\2\u01e3\u0131\3\2\2\2\u01e3\u0134\3\2\2\2\u01e3\u0139\3\2\2\2\u01e3"+
		"\u0151\3\2\2\2\u01e3\u0156\3\2\2\2\u01e3\u016d\3\2\2\2\u01e3\u0170\3\2"+
		"\2\2\u01e3\u0186\3\2\2\2\u01e3\u0192\3\2\2\2\u01e3\u0195\3\2\2\2\u01e3"+
		"\u01aa\3\2\2\2\u01e3\u01b3\3\2\2\2\u01e3\u01cf\3\2\2\2\u01e4\u01e7\3\2"+
		"\2\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\7\3\2\2\2\u01e7\u01e5"+
		"\3\2\2\2\u01e8\u01e9\7\t\2\2\u01e9\u01f5\5\6\4\2\u01ea\u01ee\7\t\2\2\u01eb"+
		"\u01ec\5\6\4\2\u01ec\u01ed\7!\2\2\u01ed\u01ef\3\2\2\2\u01ee\u01eb\3\2"+
		"\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1"+
		"\u01f2\3\2\2\2\u01f2\u01f3\5\6\4\2\u01f3\u01f5\3\2\2\2\u01f4\u01e8\3\2"+
		"\2\2\u01f4\u01ea\3\2\2\2\u01f5\t\3\2\2\2\u01f6\u01f7\7\6\2\2\u01f7\u01fb"+
		"\7\3\2\2\u01f8\u01f9\5\4\3\2\u01f9\u01fa\7#\2\2\u01fa\u01fc\3\2\2\2\u01fb"+
		"\u01f8\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2"+
		"\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0200\7\4\2\2\u0200\u0204\3\2\2\2\u0201"+
		"\u0202\7\6\2\2\u0202\u0204\5\4\3\2\u0203\u01f6\3\2\2\2\u0203\u0201\3\2"+
		"\2\2\u0204\13\3\2\2\2P\21#\'*\60\67:=@EQUX[_bpt\u0082\u0086\u0088\u008a"+
		"\u0095\u009b\u009f\u00a4\u00aa\u00ae\u00b7\u00d3\u00d7\u00da\u00df\u00e4"+
		"\u00e8\u00eb\u00f4\u00f8\u00fd\u0101\u0104\u010c\u0110\u0113\u011c\u0120"+
		"\u013c\u0143\u0146\u0149\u014c\u015b\u0162\u0166\u0169\u0173\u017a\u017d"+
		"\u0180\u0183\u018e\u0198\u019f\u01a3\u01a6\u01b6\u01bd\u01c0\u01c3\u01c6"+
		"\u01d7\u01e1\u01e3\u01e5\u01f0\u01f4\u01fd\u0203";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}