// Generated from ./src/main/java/cloki/language/parsing/Loki.grammar by ANTLR 4.5

package cloki.language.parsing;

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
		RIGHT_BRACKET=37, LEFT_BRACE=38, RIGHT_BRACE=39, SKIP=40;
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
		"'.'", "','", "':'", "';'", "'('", "')'", "'['", "']'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BEGIN", "END", "IF", "ELSE", "WHILE", "IDENTIFIER", "LEFT_THIN_ARROW", 
		"DOLLAR", "AT", "CHARACTERS", "FLOAT", "INT", "PLUS", "MINUS", "STAR", 
		"SLASH", "BACKSLASH", "EQUALS_EQUALS", "BANG_EQUALS", "GREATER_THAN_EQUALS", 
		"GREATER_THAN", "LESS_THAN_EQUALS", "LESS_THAN", "AMPERSAND_AMPERSAND", 
		"PIPE_PIPE", "BANG", "AMPERSAND", "PIPE", "EQUALS", "DOT", "COMMA", "COLON", 
		"SEMICOLON", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", "LEFT_BRACKET", 
		"RIGHT_BRACKET", "LEFT_BRACE", "RIGHT_BRACE", "SKIP"
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE))) != 0) );
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
		public TerminalNode LEFT_PARENTHESIS() { return getToken(LokiParser.LEFT_PARENTHESIS, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(LokiParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(LokiParser.IDENTIFIER, i);
		}
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(LokiParser.RIGHT_PARENTHESIS, 0); }
		public TerminalNode COLON() { return getToken(LokiParser.COLON, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public TerminalNode BACKSLASH() { return getToken(LokiParser.BACKSLASH, 0); }
		public TerminalNode DOLLAR() { return getToken(LokiParser.DOLLAR, 0); }
		public List<TerminalNode> BEGIN() { return getTokens(LokiParser.BEGIN); }
		public TerminalNode BEGIN(int i) {
			return getToken(LokiParser.BEGIN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LokiParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LokiParser.COMMA, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(LokiParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(LokiParser.SEMICOLON, i);
		}
		public List<TerminalNode> END() { return getTokens(LokiParser.END); }
		public TerminalNode END(int i) {
			return getToken(LokiParser.END, i);
		}
		public InheritanceContext inheritance() {
			return getRuleContext(InheritanceContext.class,0);
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
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(20);
				match(MINUS);
				setState(21);
				expression(20);
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
				expression(19);
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
				expression(12);
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
				expression(10);
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
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE))) != 0)) {
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
				match(LEFT_BRACE);
				setState(67);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(66);
					match(BEGIN);
					}
				}

				setState(82);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE))) != 0)) {
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

				setState(85);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(84);
					match(SEMICOLON);
					}
				}

				setState(88);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(87);
					match(END);
					}
				}

				setState(90);
				match(RIGHT_BRACE);
				setState(92);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(91);
					match(SEMICOLON);
					}
					break;
				}
				setState(95);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(94);
					match(END);
					}
					break;
				}
				}
				break;
			case 8:
				{
				_localctx = new HostContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				match(DOLLAR);
				}
				break;
			case 9:
				{
				_localctx = new ThisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				match(AT);
				}
				break;
			case 10:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99);
				match(CHARACTERS);
				}
				break;
			case 11:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				match(FLOAT);
				}
				break;
			case 12:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101);
				match(INT);
				}
				break;
			case 13:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(103);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(102);
					match(DOLLAR);
					}
				}

				setState(105);
				((UnitContext)_localctx).head = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==BACKSLASH) ) {
					((UnitContext)_localctx).head = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(106);
				match(LEFT_PARENTHESIS);
				setState(108);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(107);
					match(BEGIN);
					}
				}

				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(110);
						match(IDENTIFIER);
						setState(111);
						match(COMMA);
						}
						} 
					}
					setState(116);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				setState(117);
				match(IDENTIFIER);
				setState(119);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(118);
					match(SEMICOLON);
					}
				}

				setState(122);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(121);
					match(END);
					}
				}

				setState(124);
				match(RIGHT_PARENTHESIS);
				setState(126);
				_la = _input.LA(1);
				if (_la==LEFT_THIN_ARROW) {
					{
					setState(125);
					inheritance();
					}
				}

				setState(128);
				match(COLON);
				setState(129);
				instruction();
				}
				break;
			case 14:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(130);
					match(DOLLAR);
					}
				}

				setState(133);
				((UnitContext)_localctx).head = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==BACKSLASH) ) {
					((UnitContext)_localctx).head = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(134);
				match(LEFT_PARENTHESIS);
				setState(136);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(135);
					match(BEGIN);
					}
				}

				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(138);
						match(IDENTIFIER);
						setState(139);
						match(COMMA);
						}
						} 
					}
					setState(144);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				}
				setState(145);
				match(IDENTIFIER);
				setState(147);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(146);
					match(SEMICOLON);
					}
				}

				setState(150);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(149);
					match(END);
					}
				}

				setState(152);
				match(RIGHT_PARENTHESIS);
				setState(154);
				_la = _input.LA(1);
				if (_la==LEFT_THIN_ARROW) {
					{
					setState(153);
					inheritance();
					}
				}

				setState(156);
				match(COLON);
				setState(157);
				match(BEGIN);
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(158);
					instruction();
					setState(159);
					match(SEMICOLON);
					}
					}
					setState(163); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE))) != 0) );
				setState(165);
				match(END);
				}
				break;
			case 15:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(167);
					match(DOLLAR);
					}
				}

				setState(170);
				((UnitContext)_localctx).head = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==BACKSLASH) ) {
					((UnitContext)_localctx).head = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(171);
					match(IDENTIFIER);
					}
					}
					setState(176);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(178);
				_la = _input.LA(1);
				if (_la==LEFT_THIN_ARROW) {
					{
					setState(177);
					inheritance();
					}
				}

				setState(180);
				match(COLON);
				setState(181);
				instruction();
				}
				break;
			case 16:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(182);
					match(DOLLAR);
					}
				}

				setState(185);
				((UnitContext)_localctx).head = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==BACKSLASH) ) {
					((UnitContext)_localctx).head = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(186);
					match(IDENTIFIER);
					}
					}
					setState(191);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(193);
				_la = _input.LA(1);
				if (_la==LEFT_THIN_ARROW) {
					{
					setState(192);
					inheritance();
					}
				}

				setState(195);
				match(COLON);
				setState(196);
				match(BEGIN);
				setState(200); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(197);
					instruction();
					setState(198);
					match(SEMICOLON);
					}
					}
					setState(202); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE))) != 0) );
				setState(204);
				match(END);
				}
				break;
			case 17:
				{
				_localctx = new SuperHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				match(DOLLAR);
				setState(207);
				match(DOLLAR);
				setState(208);
				match(IDENTIFIER);
				}
				break;
			case 18:
				{
				_localctx = new HostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				match(DOLLAR);
				setState(210);
				match(IDENTIFIER);
				}
				break;
			case 19:
				{
				_localctx = new VariableOrParameterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				match(IDENTIFIER);
				}
				break;
			case 20:
				{
				_localctx = new AssignHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				match(DOLLAR);
				setState(213);
				match(IDENTIFIER);
				setState(214);
				match(EQUALS);
				setState(215);
				match(BEGIN);
				setState(216);
				expression(0);
				setState(217);
				match(SEMICOLON);
				setState(218);
				match(END);
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
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(233);
					match(SEMICOLON);
					}
				}

				setState(237);
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
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
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
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(250);
					match(SEMICOLON);
					}
				}

				setState(254);
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE))) != 0) );
				setState(265);
				match(END);
				setState(267);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
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
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(275);
					match(SEMICOLON);
					}
				}

				setState(279);
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
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(290);
					match(SEMICOLON);
					}
				}

				setState(294);
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE))) != 0) );
				setState(305);
				match(END);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(472);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(470);
					switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(309);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(310);
						((MulDivContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==STAR || _la==SLASH) ) {
							((MulDivContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(311);
						expression(19);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(312);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(313);
						((AddSubContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((AddSubContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(314);
						expression(18);
						}
						break;
					case 3:
						{
						_localctx = new EqNeqContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(315);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(316);
						((EqNeqContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUALS_EQUALS || _la==BANG_EQUALS) ) {
							((EqNeqContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(317);
						expression(17);
						}
						break;
					case 4:
						{
						_localctx = new GteLteGtLtContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(318);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(319);
						((GteLteGtLtContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATER_THAN_EQUALS) | (1L << GREATER_THAN) | (1L << LESS_THAN_EQUALS) | (1L << LESS_THAN))) != 0)) ) {
							((GteLteGtLtContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(320);
						expression(16);
						}
						break;
					case 5:
						{
						_localctx = new AmpersandAmpersandContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(321);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(322);
						((AmpersandAmpersandContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AMPERSAND_AMPERSAND) ) {
							((AmpersandAmpersandContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(323);
						expression(15);
						}
						break;
					case 6:
						{
						_localctx = new PipePipeContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(324);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(325);
						((PipePipeContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PIPE_PIPE) ) {
							((PipePipeContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(326);
						expression(14);
						}
						break;
					case 7:
						{
						_localctx = new AssignMemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(327);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(328);
						match(DOT);
						setState(329);
						match(IDENTIFIER);
						setState(330);
						match(EQUALS);
						setState(331);
						expression(9);
						}
						break;
					case 8:
						{
						_localctx = new AssignIndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(332);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(333);
						match(LEFT_BRACKET);
						setState(335);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(334);
							match(BEGIN);
							}
						}

						setState(345);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE))) != 0)) {
							{
							setState(337);
							expression(0);
							setState(342);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(338);
								match(COMMA);
								setState(339);
								expression(0);
								}
								}
								setState(344);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(348);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(347);
							match(SEMICOLON);
							}
						}

						setState(351);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(350);
							match(END);
							}
						}

						setState(353);
						match(RIGHT_BRACKET);
						setState(354);
						match(EQUALS);
						setState(355);
						expression(7);
						}
						break;
					case 9:
						{
						_localctx = new MemberCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(356);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(357);
						match(DOT);
						setState(358);
						match(IDENTIFIER);
						setState(359);
						match(LEFT_PARENTHESIS);
						setState(360);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 10:
						{
						_localctx = new MemberCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(361);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(362);
						match(DOT);
						setState(363);
						match(IDENTIFIER);
						setState(364);
						match(LEFT_PARENTHESIS);
						setState(366);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(365);
							match(BEGIN);
							}
						}

						setState(368);
						expression(0);
						setState(373);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(369);
							match(COMMA);
							setState(370);
							expression(0);
							}
							}
							setState(375);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(377);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(376);
							match(SEMICOLON);
							}
						}

						setState(380);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(379);
							match(END);
							}
						}

						setState(382);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 11:
						{
						_localctx = new MemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(384);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(385);
						match(DOT);
						setState(386);
						match(IDENTIFIER);
						}
						break;
					case 12:
						{
						_localctx = new IndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(387);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(388);
						match(LEFT_BRACKET);
						setState(390);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(389);
							match(BEGIN);
							}
						}

						setState(400);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE))) != 0)) {
							{
							setState(392);
							expression(0);
							setState(397);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(393);
								match(COMMA);
								setState(394);
								expression(0);
								}
								}
								setState(399);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(403);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(402);
							match(SEMICOLON);
							}
						}

						setState(406);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(405);
							match(END);
							}
						}

						setState(408);
						match(RIGHT_BRACKET);
						}
						break;
					case 13:
						{
						_localctx = new CallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(409);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(410);
						match(LEFT_PARENTHESIS);
						setState(411);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 14:
						{
						_localctx = new CallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(412);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(413);
						match(LEFT_PARENTHESIS);
						setState(415);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(414);
							match(BEGIN);
							}
						}

						setState(417);
						expression(0);
						setState(422);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(418);
							match(COMMA);
							setState(419);
							expression(0);
							}
							}
							setState(424);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(426);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(425);
							match(SEMICOLON);
							}
						}

						setState(429);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(428);
							match(END);
							}
						}

						setState(431);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 15:
						{
						_localctx = new AssignMemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(433);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(434);
						match(DOT);
						setState(435);
						match(IDENTIFIER);
						setState(436);
						match(EQUALS);
						setState(437);
						match(SEMICOLON);
						setState(438);
						match(BEGIN);
						setState(439);
						expression(0);
						setState(440);
						match(END);
						}
						break;
					case 16:
						{
						_localctx = new AssignIndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(442);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(443);
						match(LEFT_BRACKET);
						setState(445);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(444);
							match(BEGIN);
							}
						}

						setState(455);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE))) != 0)) {
							{
							setState(447);
							expression(0);
							setState(452);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(448);
								match(COMMA);
								setState(449);
								expression(0);
								}
								}
								setState(454);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(458);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(457);
							match(SEMICOLON);
							}
						}

						setState(461);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(460);
							match(END);
							}
						}

						setState(463);
						match(RIGHT_BRACKET);
						setState(464);
						match(EQUALS);
						setState(465);
						match(BEGIN);
						setState(466);
						expression(0);
						setState(467);
						match(SEMICOLON);
						setState(468);
						match(END);
						}
						break;
					}
					} 
				}
				setState(474);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
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
			setState(487);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(475);
				match(LEFT_THIN_ARROW);
				setState(476);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(477);
				match(LEFT_THIN_ARROW);
				setState(481); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(478);
						expression(0);
						setState(479);
						match(COMMA);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(483); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(485);
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
			setState(502);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(489);
				match(ELSE);
				setState(490);
				match(BEGIN);
				setState(494); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(491);
					instruction();
					setState(492);
					match(SEMICOLON);
					}
					}
					setState(496); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET) | (1L << LEFT_BRACE))) != 0) );
				setState(498);
				match(END);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(500);
				match(ELSE);
				setState(501);
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
			return precpred(_ctx, 18);
		case 1:
			return precpred(_ctx, 17);
		case 2:
			return precpred(_ctx, 16);
		case 3:
			return precpred(_ctx, 15);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 29);
		case 9:
			return precpred(_ctx, 28);
		case 10:
			return precpred(_ctx, 24);
		case 11:
			return precpred(_ctx, 23);
		case 12:
			return precpred(_ctx, 22);
		case 13:
			return precpred(_ctx, 21);
		case 14:
			return precpred(_ctx, 7);
		case 15:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u01fb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\6\2\20\n\2\r\2\16\2\21\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4$\n\4"+
		"\3\4\3\4\5\4(\n\4\3\4\5\4+\n\4\3\4\3\4\3\4\3\4\5\4\61\n\4\3\4\3\4\3\4"+
		"\7\4\66\n\4\f\4\16\49\13\4\5\4;\n\4\3\4\5\4>\n\4\3\4\5\4A\n\4\3\4\3\4"+
		"\3\4\5\4F\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4P\n\4\f\4\16\4S\13\4"+
		"\5\4U\n\4\3\4\5\4X\n\4\3\4\5\4[\n\4\3\4\3\4\5\4_\n\4\3\4\5\4b\n\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4j\n\4\3\4\3\4\3\4\5\4o\n\4\3\4\3\4\7\4s\n\4\f"+
		"\4\16\4v\13\4\3\4\3\4\5\4z\n\4\3\4\5\4}\n\4\3\4\3\4\5\4\u0081\n\4\3\4"+
		"\3\4\3\4\5\4\u0086\n\4\3\4\3\4\3\4\5\4\u008b\n\4\3\4\3\4\7\4\u008f\n\4"+
		"\f\4\16\4\u0092\13\4\3\4\3\4\5\4\u0096\n\4\3\4\5\4\u0099\n\4\3\4\3\4\5"+
		"\4\u009d\n\4\3\4\3\4\3\4\3\4\3\4\6\4\u00a4\n\4\r\4\16\4\u00a5\3\4\3\4"+
		"\3\4\5\4\u00ab\n\4\3\4\3\4\7\4\u00af\n\4\f\4\16\4\u00b2\13\4\3\4\5\4\u00b5"+
		"\n\4\3\4\3\4\3\4\5\4\u00ba\n\4\3\4\3\4\7\4\u00be\n\4\f\4\16\4\u00c1\13"+
		"\4\3\4\5\4\u00c4\n\4\3\4\3\4\3\4\3\4\3\4\6\4\u00cb\n\4\r\4\16\4\u00cc"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00e9\n\4\3\4\3\4\5\4\u00ed\n\4"+
		"\3\4\5\4\u00f0\n\4\3\4\3\4\3\4\5\4\u00f5\n\4\3\4\3\4\3\4\5\4\u00fa\n\4"+
		"\3\4\3\4\5\4\u00fe\n\4\3\4\5\4\u0101\n\4\3\4\3\4\3\4\3\4\3\4\6\4\u0108"+
		"\n\4\r\4\16\4\u0109\3\4\3\4\5\4\u010e\n\4\3\4\3\4\3\4\5\4\u0113\n\4\3"+
		"\4\3\4\5\4\u0117\n\4\3\4\5\4\u011a\n\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0122"+
		"\n\4\3\4\3\4\5\4\u0126\n\4\3\4\5\4\u0129\n\4\3\4\3\4\3\4\3\4\3\4\6\4\u0130"+
		"\n\4\r\4\16\4\u0131\3\4\3\4\5\4\u0136\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4\u0152\n\4\3\4\3\4\3\4\7\4\u0157\n\4\f\4\16\4\u015a\13\4\5\4"+
		"\u015c\n\4\3\4\5\4\u015f\n\4\3\4\5\4\u0162\n\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0171\n\4\3\4\3\4\3\4\7\4\u0176\n\4\f"+
		"\4\16\4\u0179\13\4\3\4\5\4\u017c\n\4\3\4\5\4\u017f\n\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\5\4\u0189\n\4\3\4\3\4\3\4\7\4\u018e\n\4\f\4\16\4\u0191"+
		"\13\4\5\4\u0193\n\4\3\4\5\4\u0196\n\4\3\4\5\4\u0199\n\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4\u01a2\n\4\3\4\3\4\3\4\7\4\u01a7\n\4\f\4\16\4\u01aa"+
		"\13\4\3\4\5\4\u01ad\n\4\3\4\5\4\u01b0\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u01c0\n\4\3\4\3\4\3\4\7\4\u01c5\n\4\f"+
		"\4\16\4\u01c8\13\4\5\4\u01ca\n\4\3\4\5\4\u01cd\n\4\3\4\5\4\u01d0\n\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u01d9\n\4\f\4\16\4\u01dc\13\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\6\5\u01e4\n\5\r\5\16\5\u01e5\3\5\3\5\5\5\u01ea\n\5\3\6"+
		"\3\6\3\6\3\6\3\6\6\6\u01f1\n\6\r\6\16\6\u01f2\3\6\3\6\3\6\3\6\5\6\u01f9"+
		"\n\6\3\6\2\3\6\7\2\4\6\b\n\2\t\4\2\b\b\23\23\3\2\21\22\3\2\17\20\3\2\24"+
		"\25\3\2\26\31\3\2\32\32\3\2\33\33\u026c\2\17\3\2\2\2\4\23\3\2\2\2\6\u0135"+
		"\3\2\2\2\b\u01e9\3\2\2\2\n\u01f8\3\2\2\2\f\r\5\4\3\2\r\16\7#\2\2\16\20"+
		"\3\2\2\2\17\f\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\3\3"+
		"\2\2\2\23\24\5\6\4\2\24\5\3\2\2\2\25\26\b\4\1\2\26\27\7\20\2\2\27\u0136"+
		"\5\6\4\26\30\31\7\34\2\2\31\u0136\5\6\4\25\32\33\7\n\2\2\33\34\7\b\2\2"+
		"\34\35\7\37\2\2\35\u0136\5\6\4\16\36\37\7\b\2\2\37 \7\37\2\2 \u0136\5"+
		"\6\4\f!#\7$\2\2\"$\7\3\2\2#\"\3\2\2\2#$\3\2\2\2$%\3\2\2\2%\'\5\6\4\2&"+
		"(\7#\2\2\'&\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)+\7\4\2\2*)\3\2\2\2*+\3\2\2\2"+
		"+,\3\2\2\2,-\7%\2\2-\u0136\3\2\2\2.\60\7&\2\2/\61\7\3\2\2\60/\3\2\2\2"+
		"\60\61\3\2\2\2\61:\3\2\2\2\62\67\5\6\4\2\63\64\7!\2\2\64\66\5\6\4\2\65"+
		"\63\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28;\3\2\2\29\67\3\2\2"+
		"\2:\62\3\2\2\2:;\3\2\2\2;=\3\2\2\2<>\7#\2\2=<\3\2\2\2=>\3\2\2\2>@\3\2"+
		"\2\2?A\7\4\2\2@?\3\2\2\2@A\3\2\2\2AB\3\2\2\2B\u0136\7\'\2\2CE\7(\2\2D"+
		"F\7\3\2\2ED\3\2\2\2EF\3\2\2\2FT\3\2\2\2GH\5\6\4\2HI\7\"\2\2IQ\5\6\4\2"+
		"JK\7!\2\2KL\5\6\4\2LM\7\"\2\2MN\5\6\4\2NP\3\2\2\2OJ\3\2\2\2PS\3\2\2\2"+
		"QO\3\2\2\2QR\3\2\2\2RU\3\2\2\2SQ\3\2\2\2TG\3\2\2\2TU\3\2\2\2UW\3\2\2\2"+
		"VX\7#\2\2WV\3\2\2\2WX\3\2\2\2XZ\3\2\2\2Y[\7\4\2\2ZY\3\2\2\2Z[\3\2\2\2"+
		"[\\\3\2\2\2\\^\7)\2\2]_\7#\2\2^]\3\2\2\2^_\3\2\2\2_a\3\2\2\2`b\7\4\2\2"+
		"a`\3\2\2\2ab\3\2\2\2b\u0136\3\2\2\2c\u0136\7\n\2\2d\u0136\7\13\2\2e\u0136"+
		"\7\f\2\2f\u0136\7\r\2\2g\u0136\7\16\2\2hj\7\n\2\2ih\3\2\2\2ij\3\2\2\2"+
		"jk\3\2\2\2kl\t\2\2\2ln\7$\2\2mo\7\3\2\2nm\3\2\2\2no\3\2\2\2ot\3\2\2\2"+
		"pq\7\b\2\2qs\7!\2\2rp\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2"+
		"vt\3\2\2\2wy\7\b\2\2xz\7#\2\2yx\3\2\2\2yz\3\2\2\2z|\3\2\2\2{}\7\4\2\2"+
		"|{\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\u0080\7%\2\2\177\u0081\5\b\5\2\u0080\177"+
		"\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\7\"\2\2\u0083"+
		"\u0136\5\4\3\2\u0084\u0086\7\n\2\2\u0085\u0084\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\u0087\3\2\2\2\u0087\u0088\t\2\2\2\u0088\u008a\7$\2\2\u0089"+
		"\u008b\7\3\2\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0090\3\2"+
		"\2\2\u008c\u008d\7\b\2\2\u008d\u008f\7!\2\2\u008e\u008c\3\2\2\2\u008f"+
		"\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2"+
		"\2\2\u0092\u0090\3\2\2\2\u0093\u0095\7\b\2\2\u0094\u0096\7#\2\2\u0095"+
		"\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\3\2\2\2\u0097\u0099\7\4"+
		"\2\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009c\7%\2\2\u009b\u009d\5\b\5\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2"+
		"\2\2\u009d\u009e\3\2\2\2\u009e\u009f\7\"\2\2\u009f\u00a3\7\3\2\2\u00a0"+
		"\u00a1\5\4\3\2\u00a1\u00a2\7#\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a0\3\2"+
		"\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a8\7\4\2\2\u00a8\u0136\3\2\2\2\u00a9\u00ab\7\n"+
		"\2\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00b0\t\2\2\2\u00ad\u00af\7\b\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2"+
		"\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b3\u00b5\5\b\5\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\7\"\2\2\u00b7\u0136\5\4\3\2\u00b8"+
		"\u00ba\7\n\2\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb\u00bf\t\2\2\2\u00bc\u00be\7\b\2\2\u00bd\u00bc\3\2\2\2\u00be"+
		"\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c3\3\2"+
		"\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c4\5\b\5\2\u00c3\u00c2\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\7\"\2\2\u00c6\u00ca\7\3"+
		"\2\2\u00c7\u00c8\5\4\3\2\u00c8\u00c9\7#\2\2\u00c9\u00cb\3\2\2\2\u00ca"+
		"\u00c7\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\7\4\2\2\u00cf\u0136\3\2\2\2\u00d0"+
		"\u00d1\7\n\2\2\u00d1\u00d2\7\n\2\2\u00d2\u0136\7\b\2\2\u00d3\u00d4\7\n"+
		"\2\2\u00d4\u0136\7\b\2\2\u00d5\u0136\7\b\2\2\u00d6\u00d7\7\n\2\2\u00d7"+
		"\u00d8\7\b\2\2\u00d8\u00d9\7\37\2\2\u00d9\u00da\7\3\2\2\u00da\u00db\5"+
		"\6\4\2\u00db\u00dc\7#\2\2\u00dc\u00dd\7\4\2\2\u00dd\u0136\3\2\2\2\u00de"+
		"\u00df\7\b\2\2\u00df\u00e0\7\37\2\2\u00e0\u00e1\7\3\2\2\u00e1\u00e2\5"+
		"\6\4\2\u00e2\u00e3\7#\2\2\u00e3\u00e4\7\4\2\2\u00e4\u0136\3\2\2\2\u00e5"+
		"\u00e6\7\5\2\2\u00e6\u00e8\7$\2\2\u00e7\u00e9\7\3\2\2\u00e8\u00e7\3\2"+
		"\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\5\6\4\2\u00eb"+
		"\u00ed\7#\2\2\u00ec\u00eb\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef\3\2"+
		"\2\2\u00ee\u00f0\7\4\2\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u00f2\7%\2\2\u00f2\u00f4\5\4\3\2\u00f3\u00f5\5\n"+
		"\6\2\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u0136\3\2\2\2\u00f6"+
		"\u00f7\7\5\2\2\u00f7\u00f9\7$\2\2\u00f8\u00fa\7\3\2\2\u00f9\u00f8\3\2"+
		"\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\5\6\4\2\u00fc"+
		"\u00fe\7#\2\2\u00fd\u00fc\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100\3\2"+
		"\2\2\u00ff\u0101\7\4\2\2\u0100\u00ff\3\2\2\2\u0100\u0101\3\2\2\2\u0101"+
		"\u0102\3\2\2\2\u0102\u0103\7%\2\2\u0103\u0107\7\3\2\2\u0104\u0105\5\4"+
		"\3\2\u0105\u0106\7#\2\2\u0106\u0108\3\2\2\2\u0107\u0104\3\2\2\2\u0108"+
		"\u0109\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\3\2"+
		"\2\2\u010b\u010d\7\4\2\2\u010c\u010e\5\n\6\2\u010d\u010c\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u0136\3\2\2\2\u010f\u0110\7\7\2\2\u0110\u0112\7$"+
		"\2\2\u0111\u0113\7\3\2\2\u0112\u0111\3\2\2\2\u0112\u0113\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0116\5\6\4\2\u0115\u0117\7#\2\2\u0116\u0115\3\2"+
		"\2\2\u0116\u0117\3\2\2\2\u0117\u0119\3\2\2\2\u0118\u011a\7\4\2\2\u0119"+
		"\u0118\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\7%"+
		"\2\2\u011c\u011d\5\4\3\2\u011d\u0136\3\2\2\2\u011e\u011f\7\7\2\2\u011f"+
		"\u0121\7$\2\2\u0120\u0122\7\3\2\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2"+
		"\2\2\u0122\u0123\3\2\2\2\u0123\u0125\5\6\4\2\u0124\u0126\7#\2\2\u0125"+
		"\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0128\3\2\2\2\u0127\u0129\7\4"+
		"\2\2\u0128\u0127\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"\u012b\7%\2\2\u012b\u012f\7\3\2\2\u012c\u012d\5\4\3\2\u012d\u012e\7#\2"+
		"\2\u012e\u0130\3\2\2\2\u012f\u012c\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u012f"+
		"\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\7\4\2\2\u0134"+
		"\u0136\3\2\2\2\u0135\25\3\2\2\2\u0135\30\3\2\2\2\u0135\32\3\2\2\2\u0135"+
		"\36\3\2\2\2\u0135!\3\2\2\2\u0135.\3\2\2\2\u0135C\3\2\2\2\u0135c\3\2\2"+
		"\2\u0135d\3\2\2\2\u0135e\3\2\2\2\u0135f\3\2\2\2\u0135g\3\2\2\2\u0135i"+
		"\3\2\2\2\u0135\u0085\3\2\2\2\u0135\u00aa\3\2\2\2\u0135\u00b9\3\2\2\2\u0135"+
		"\u00d0\3\2\2\2\u0135\u00d3\3\2\2\2\u0135\u00d5\3\2\2\2\u0135\u00d6\3\2"+
		"\2\2\u0135\u00de\3\2\2\2\u0135\u00e5\3\2\2\2\u0135\u00f6\3\2\2\2\u0135"+
		"\u010f\3\2\2\2\u0135\u011e\3\2\2\2\u0136\u01da\3\2\2\2\u0137\u0138\f\24"+
		"\2\2\u0138\u0139\t\3\2\2\u0139\u01d9\5\6\4\25\u013a\u013b\f\23\2\2\u013b"+
		"\u013c\t\4\2\2\u013c\u01d9\5\6\4\24\u013d\u013e\f\22\2\2\u013e\u013f\t"+
		"\5\2\2\u013f\u01d9\5\6\4\23\u0140\u0141\f\21\2\2\u0141\u0142\t\6\2\2\u0142"+
		"\u01d9\5\6\4\22\u0143\u0144\f\20\2\2\u0144\u0145\t\7\2\2\u0145\u01d9\5"+
		"\6\4\21\u0146\u0147\f\17\2\2\u0147\u0148\t\b\2\2\u0148\u01d9\5\6\4\20"+
		"\u0149\u014a\f\n\2\2\u014a\u014b\7 \2\2\u014b\u014c\7\b\2\2\u014c\u014d"+
		"\7\37\2\2\u014d\u01d9\5\6\4\13\u014e\u014f\f\b\2\2\u014f\u0151\7&\2\2"+
		"\u0150\u0152\7\3\2\2\u0151\u0150\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u015b"+
		"\3\2\2\2\u0153\u0158\5\6\4\2\u0154\u0155\7!\2\2\u0155\u0157\5\6\4\2\u0156"+
		"\u0154\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2"+
		"\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u0153\3\2\2\2\u015b"+
		"\u015c\3\2\2\2\u015c\u015e\3\2\2\2\u015d\u015f\7#\2\2\u015e\u015d\3\2"+
		"\2\2\u015e\u015f\3\2\2\2\u015f\u0161\3\2\2\2\u0160\u0162\7\4\2\2\u0161"+
		"\u0160\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0164\7\'"+
		"\2\2\u0164\u0165\7\37\2\2\u0165\u01d9\5\6\4\t\u0166\u0167\f\37\2\2\u0167"+
		"\u0168\7 \2\2\u0168\u0169\7\b\2\2\u0169\u016a\7$\2\2\u016a\u01d9\7%\2"+
		"\2\u016b\u016c\f\36\2\2\u016c\u016d\7 \2\2\u016d\u016e\7\b\2\2\u016e\u0170"+
		"\7$\2\2\u016f\u0171\7\3\2\2\u0170\u016f\3\2\2\2\u0170\u0171\3\2\2\2\u0171"+
		"\u0172\3\2\2\2\u0172\u0177\5\6\4\2\u0173\u0174\7!\2\2\u0174\u0176\5\6"+
		"\4\2\u0175\u0173\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177"+
		"\u0178\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u017c\7#"+
		"\2\2\u017b\u017a\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017e\3\2\2\2\u017d"+
		"\u017f\7\4\2\2\u017e\u017d\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\3\2"+
		"\2\2\u0180\u0181\7%\2\2\u0181\u01d9\3\2\2\2\u0182\u0183\f\32\2\2\u0183"+
		"\u0184\7 \2\2\u0184\u01d9\7\b\2\2\u0185\u0186\f\31\2\2\u0186\u0188\7&"+
		"\2\2\u0187\u0189\7\3\2\2\u0188\u0187\3\2\2\2\u0188\u0189\3\2\2\2\u0189"+
		"\u0192\3\2\2\2\u018a\u018f\5\6\4\2\u018b\u018c\7!\2\2\u018c\u018e\5\6"+
		"\4\2\u018d\u018b\3\2\2\2\u018e\u0191\3\2\2\2\u018f\u018d\3\2\2\2\u018f"+
		"\u0190\3\2\2\2\u0190\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0192\u018a\3\2"+
		"\2\2\u0192\u0193\3\2\2\2\u0193\u0195\3\2\2\2\u0194\u0196\7#\2\2\u0195"+
		"\u0194\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0198\3\2\2\2\u0197\u0199\7\4"+
		"\2\2\u0198\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019a\3\2\2\2\u019a"+
		"\u01d9\7\'\2\2\u019b\u019c\f\30\2\2\u019c\u019d\7$\2\2\u019d\u01d9\7%"+
		"\2\2\u019e\u019f\f\27\2\2\u019f\u01a1\7$\2\2\u01a0\u01a2\7\3\2\2\u01a1"+
		"\u01a0\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a8\5\6"+
		"\4\2\u01a4\u01a5\7!\2\2\u01a5\u01a7\5\6\4\2\u01a6\u01a4\3\2\2\2\u01a7"+
		"\u01aa\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01ac\3\2"+
		"\2\2\u01aa\u01a8\3\2\2\2\u01ab\u01ad\7#\2\2\u01ac\u01ab\3\2\2\2\u01ac"+
		"\u01ad\3\2\2\2\u01ad\u01af\3\2\2\2\u01ae\u01b0\7\4\2\2\u01af\u01ae\3\2"+
		"\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b2\7%\2\2\u01b2"+
		"\u01d9\3\2\2\2\u01b3\u01b4\f\t\2\2\u01b4\u01b5\7 \2\2\u01b5\u01b6\7\b"+
		"\2\2\u01b6\u01b7\7\37\2\2\u01b7\u01b8\7#\2\2\u01b8\u01b9\7\3\2\2\u01b9"+
		"\u01ba\5\6\4\2\u01ba\u01bb\7\4\2\2\u01bb\u01d9\3\2\2\2\u01bc\u01bd\f\7"+
		"\2\2\u01bd\u01bf\7&\2\2\u01be\u01c0\7\3\2\2\u01bf\u01be\3\2\2\2\u01bf"+
		"\u01c0\3\2\2\2\u01c0\u01c9\3\2\2\2\u01c1\u01c6\5\6\4\2\u01c2\u01c3\7!"+
		"\2\2\u01c3\u01c5\5\6\4\2\u01c4\u01c2\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6"+
		"\u01c4\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c6\3\2"+
		"\2\2\u01c9\u01c1\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cc\3\2\2\2\u01cb"+
		"\u01cd\7#\2\2\u01cc\u01cb\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01cf\3\2"+
		"\2\2\u01ce\u01d0\7\4\2\2\u01cf\u01ce\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0"+
		"\u01d1\3\2\2\2\u01d1\u01d2\7\'\2\2\u01d2\u01d3\7\37\2\2\u01d3\u01d4\7"+
		"\3\2\2\u01d4\u01d5\5\6\4\2\u01d5\u01d6\7#\2\2\u01d6\u01d7\7\4\2\2\u01d7"+
		"\u01d9\3\2\2\2\u01d8\u0137\3\2\2\2\u01d8\u013a\3\2\2\2\u01d8\u013d\3\2"+
		"\2\2\u01d8\u0140\3\2\2\2\u01d8\u0143\3\2\2\2\u01d8\u0146\3\2\2\2\u01d8"+
		"\u0149\3\2\2\2\u01d8\u014e\3\2\2\2\u01d8\u0166\3\2\2\2\u01d8\u016b\3\2"+
		"\2\2\u01d8\u0182\3\2\2\2\u01d8\u0185\3\2\2\2\u01d8\u019b\3\2\2\2\u01d8"+
		"\u019e\3\2\2\2\u01d8\u01b3\3\2\2\2\u01d8\u01bc\3\2\2\2\u01d9\u01dc\3\2"+
		"\2\2\u01da\u01d8\3\2\2\2\u01da\u01db\3\2\2\2\u01db\7\3\2\2\2\u01dc\u01da"+
		"\3\2\2\2\u01dd\u01de\7\t\2\2\u01de\u01ea\5\6\4\2\u01df\u01e3\7\t\2\2\u01e0"+
		"\u01e1\5\6\4\2\u01e1\u01e2\7!\2\2\u01e2\u01e4\3\2\2\2\u01e3\u01e0\3\2"+
		"\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6"+
		"\u01e7\3\2\2\2\u01e7\u01e8\5\6\4\2\u01e8\u01ea\3\2\2\2\u01e9\u01dd\3\2"+
		"\2\2\u01e9\u01df\3\2\2\2\u01ea\t\3\2\2\2\u01eb\u01ec\7\6\2\2\u01ec\u01f0"+
		"\7\3\2\2\u01ed\u01ee\5\4\3\2\u01ee\u01ef\7#\2\2\u01ef\u01f1\3\2\2\2\u01f0"+
		"\u01ed\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2"+
		"\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f5\7\4\2\2\u01f5\u01f9\3\2\2\2\u01f6"+
		"\u01f7\7\6\2\2\u01f7\u01f9\5\4\3\2\u01f8\u01eb\3\2\2\2\u01f8\u01f6\3\2"+
		"\2\2\u01f9\13\3\2\2\2T\21#\'*\60\67:=@EQTWZ^ainty|\u0080\u0085\u008a\u0090"+
		"\u0095\u0098\u009c\u00a5\u00aa\u00b0\u00b4\u00b9\u00bf\u00c3\u00cc\u00e8"+
		"\u00ec\u00ef\u00f4\u00f9\u00fd\u0100\u0109\u010d\u0112\u0116\u0119\u0121"+
		"\u0125\u0128\u0131\u0135\u0151\u0158\u015b\u015e\u0161\u0170\u0177\u017b"+
		"\u017e\u0188\u018f\u0192\u0195\u0198\u01a1\u01a8\u01ac\u01af\u01bf\u01c6"+
		"\u01c9\u01cc\u01cf\u01d8\u01da\u01e5\u01e9\u01f2\u01f8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}