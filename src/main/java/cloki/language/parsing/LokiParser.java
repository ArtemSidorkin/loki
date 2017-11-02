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
		RIGHT_BRACKET=37, SKIP=38;
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
		"'.'", "','", "':'", "';'", "'('", "')'", "'['", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BEGIN", "END", "IF", "ELSE", "WHILE", "IDENTIFIER", "LEFT_THIN_ARROW", 
		"DOLLAR", "AT", "CHARACTERS", "FLOAT", "INT", "PLUS", "MINUS", "STAR", 
		"SLASH", "BACKSLASH", "EQUALS_EQUALS", "BANG_EQUALS", "GREATER_THAN_EQUALS", 
		"GREATER_THAN", "LESS_THAN_EQUALS", "LESS_THAN", "AMPERSAND_AMPERSAND", 
		"PIPE_PIPE", "BANG", "AMPERSAND", "PIPE", "EQUALS", "DOT", "COMMA", "COLON", 
		"SEMICOLON", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", "LEFT_BRACKET", 
		"RIGHT_BRACKET", "SKIP"
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET))) != 0) );
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
			setState(275);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
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
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET))) != 0)) {
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
				_localctx = new HostContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
				match(DOLLAR);
				}
				break;
			case 8:
				{
				_localctx = new ThisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66);
				match(AT);
				}
				break;
			case 9:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67);
				match(CHARACTERS);
				}
				break;
			case 10:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				match(FLOAT);
				}
				break;
			case 11:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69);
				match(INT);
				}
				break;
			case 12:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(70);
					match(DOLLAR);
					}
				}

				setState(73);
				((UnitContext)_localctx).head = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==BACKSLASH) ) {
					((UnitContext)_localctx).head = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(74);
				match(LEFT_PARENTHESIS);
				setState(76);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(75);
					match(BEGIN);
					}
				}

				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(78);
						match(IDENTIFIER);
						setState(79);
						match(COMMA);
						}
						} 
					}
					setState(84);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				setState(85);
				match(IDENTIFIER);
				setState(87);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(86);
					match(SEMICOLON);
					}
				}

				setState(90);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(89);
					match(END);
					}
				}

				setState(92);
				match(RIGHT_PARENTHESIS);
				setState(94);
				_la = _input.LA(1);
				if (_la==LEFT_THIN_ARROW) {
					{
					setState(93);
					inheritance();
					}
				}

				setState(96);
				match(COLON);
				setState(97);
				instruction();
				}
				break;
			case 13:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(98);
					match(DOLLAR);
					}
				}

				setState(101);
				((UnitContext)_localctx).head = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==BACKSLASH) ) {
					((UnitContext)_localctx).head = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(102);
				match(LEFT_PARENTHESIS);
				setState(104);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(103);
					match(BEGIN);
					}
				}

				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(106);
						match(IDENTIFIER);
						setState(107);
						match(COMMA);
						}
						} 
					}
					setState(112);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				setState(113);
				match(IDENTIFIER);
				setState(115);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(114);
					match(SEMICOLON);
					}
				}

				setState(118);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(117);
					match(END);
					}
				}

				setState(120);
				match(RIGHT_PARENTHESIS);
				setState(122);
				_la = _input.LA(1);
				if (_la==LEFT_THIN_ARROW) {
					{
					setState(121);
					inheritance();
					}
				}

				setState(124);
				match(COLON);
				setState(125);
				match(BEGIN);
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(126);
					instruction();
					setState(127);
					match(SEMICOLON);
					}
					}
					setState(131); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET))) != 0) );
				setState(133);
				match(END);
				}
				break;
			case 14:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(135);
					match(DOLLAR);
					}
				}

				setState(138);
				((UnitContext)_localctx).head = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==BACKSLASH) ) {
					((UnitContext)_localctx).head = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(139);
					match(IDENTIFIER);
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(146);
				_la = _input.LA(1);
				if (_la==LEFT_THIN_ARROW) {
					{
					setState(145);
					inheritance();
					}
				}

				setState(148);
				match(COLON);
				setState(149);
				instruction();
				}
				break;
			case 15:
				{
				_localctx = new UnitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(150);
					match(DOLLAR);
					}
				}

				setState(153);
				((UnitContext)_localctx).head = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==BACKSLASH) ) {
					((UnitContext)_localctx).head = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(154);
					match(IDENTIFIER);
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(161);
				_la = _input.LA(1);
				if (_la==LEFT_THIN_ARROW) {
					{
					setState(160);
					inheritance();
					}
				}

				setState(163);
				match(COLON);
				setState(164);
				match(BEGIN);
				setState(168); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(165);
					instruction();
					setState(166);
					match(SEMICOLON);
					}
					}
					setState(170); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET))) != 0) );
				setState(172);
				match(END);
				}
				break;
			case 16:
				{
				_localctx = new SuperHostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				match(DOLLAR);
				setState(175);
				match(DOLLAR);
				setState(176);
				match(IDENTIFIER);
				}
				break;
			case 17:
				{
				_localctx = new HostMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
				match(DOLLAR);
				setState(178);
				match(IDENTIFIER);
				}
				break;
			case 18:
				{
				_localctx = new VariableOrParameterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179);
				match(IDENTIFIER);
				}
				break;
			case 19:
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
				match(BEGIN);
				setState(184);
				expression(0);
				setState(185);
				match(SEMICOLON);
				setState(186);
				match(END);
				}
				break;
			case 20:
				{
				_localctx = new AssignVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				match(IDENTIFIER);
				setState(189);
				match(EQUALS);
				setState(190);
				match(BEGIN);
				setState(191);
				expression(0);
				setState(192);
				match(SEMICOLON);
				setState(193);
				match(END);
				}
				break;
			case 21:
				{
				_localctx = new IfElseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(IF);
				setState(196);
				match(LEFT_PARENTHESIS);
				setState(198);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(197);
					match(BEGIN);
					}
				}

				setState(200);
				expression(0);
				setState(202);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(201);
					match(SEMICOLON);
					}
				}

				setState(205);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(204);
					match(END);
					}
				}

				setState(207);
				match(RIGHT_PARENTHESIS);
				setState(208);
				instruction();
				setState(210);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(209);
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
				setState(212);
				match(IF);
				setState(213);
				match(LEFT_PARENTHESIS);
				setState(215);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(214);
					match(BEGIN);
					}
				}

				setState(217);
				expression(0);
				setState(219);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(218);
					match(SEMICOLON);
					}
				}

				setState(222);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(221);
					match(END);
					}
				}

				setState(224);
				match(RIGHT_PARENTHESIS);
				setState(225);
				match(BEGIN);
				setState(229); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(226);
					instruction();
					setState(227);
					match(SEMICOLON);
					}
					}
					setState(231); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET))) != 0) );
				setState(233);
				match(END);
				setState(235);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(234);
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
				setState(237);
				match(WHILE);
				setState(238);
				match(LEFT_PARENTHESIS);
				setState(240);
				_la = _input.LA(1);
				if (_la==BEGIN) {
					{
					setState(239);
					match(BEGIN);
					}
				}

				setState(242);
				expression(0);
				setState(244);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(243);
					match(SEMICOLON);
					}
				}

				setState(247);
				_la = _input.LA(1);
				if (_la==END) {
					{
					setState(246);
					match(END);
					}
				}

				setState(249);
				match(RIGHT_PARENTHESIS);
				setState(250);
				instruction();
				}
				break;
			case 24:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(252);
				match(WHILE);
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET))) != 0) );
				setState(273);
				match(END);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(440);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(438);
					switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(277);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(278);
						((MulDivContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==STAR || _la==SLASH) ) {
							((MulDivContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(279);
						expression(19);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(280);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(281);
						((AddSubContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((AddSubContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(282);
						expression(18);
						}
						break;
					case 3:
						{
						_localctx = new EqNeqContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(283);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(284);
						((EqNeqContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUALS_EQUALS || _la==BANG_EQUALS) ) {
							((EqNeqContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(285);
						expression(17);
						}
						break;
					case 4:
						{
						_localctx = new GteLteGtLtContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(286);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(287);
						((GteLteGtLtContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATER_THAN_EQUALS) | (1L << GREATER_THAN) | (1L << LESS_THAN_EQUALS) | (1L << LESS_THAN))) != 0)) ) {
							((GteLteGtLtContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(288);
						expression(16);
						}
						break;
					case 5:
						{
						_localctx = new AmpersandAmpersandContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(289);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(290);
						((AmpersandAmpersandContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AMPERSAND_AMPERSAND) ) {
							((AmpersandAmpersandContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(291);
						expression(15);
						}
						break;
					case 6:
						{
						_localctx = new PipePipeContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(292);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(293);
						((PipePipeContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PIPE_PIPE) ) {
							((PipePipeContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(294);
						expression(14);
						}
						break;
					case 7:
						{
						_localctx = new AssignMemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(295);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(296);
						match(DOT);
						setState(297);
						match(IDENTIFIER);
						setState(298);
						match(EQUALS);
						setState(299);
						expression(9);
						}
						break;
					case 8:
						{
						_localctx = new AssignIndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(300);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(301);
						match(LEFT_BRACKET);
						setState(303);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(302);
							match(BEGIN);
							}
						}

						setState(313);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET))) != 0)) {
							{
							setState(305);
							expression(0);
							setState(310);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(306);
								match(COMMA);
								setState(307);
								expression(0);
								}
								}
								setState(312);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(316);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(315);
							match(SEMICOLON);
							}
						}

						setState(319);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(318);
							match(END);
							}
						}

						setState(321);
						match(RIGHT_BRACKET);
						setState(322);
						match(EQUALS);
						setState(323);
						expression(7);
						}
						break;
					case 9:
						{
						_localctx = new MemberCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(324);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(325);
						match(DOT);
						setState(326);
						match(IDENTIFIER);
						setState(327);
						match(LEFT_PARENTHESIS);
						setState(328);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 10:
						{
						_localctx = new MemberCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(329);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(330);
						match(DOT);
						setState(331);
						match(IDENTIFIER);
						setState(332);
						match(LEFT_PARENTHESIS);
						setState(334);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(333);
							match(BEGIN);
							}
						}

						setState(336);
						expression(0);
						setState(341);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(337);
							match(COMMA);
							setState(338);
							expression(0);
							}
							}
							setState(343);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(345);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(344);
							match(SEMICOLON);
							}
						}

						setState(348);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(347);
							match(END);
							}
						}

						setState(350);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 11:
						{
						_localctx = new MemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(352);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(353);
						match(DOT);
						setState(354);
						match(IDENTIFIER);
						}
						break;
					case 12:
						{
						_localctx = new IndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(355);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(356);
						match(LEFT_BRACKET);
						setState(358);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(357);
							match(BEGIN);
							}
						}

						setState(368);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET))) != 0)) {
							{
							setState(360);
							expression(0);
							setState(365);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(361);
								match(COMMA);
								setState(362);
								expression(0);
								}
								}
								setState(367);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(371);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(370);
							match(SEMICOLON);
							}
						}

						setState(374);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(373);
							match(END);
							}
						}

						setState(376);
						match(RIGHT_BRACKET);
						}
						break;
					case 13:
						{
						_localctx = new CallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(377);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(378);
						match(LEFT_PARENTHESIS);
						setState(379);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 14:
						{
						_localctx = new CallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(380);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(381);
						match(LEFT_PARENTHESIS);
						setState(383);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(382);
							match(BEGIN);
							}
						}

						setState(385);
						expression(0);
						setState(390);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(386);
							match(COMMA);
							setState(387);
							expression(0);
							}
							}
							setState(392);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(394);
						_la = _input.LA(1);
						if (_la==SEMICOLON) {
							{
							setState(393);
							match(SEMICOLON);
							}
						}

						setState(397);
						_la = _input.LA(1);
						if (_la==END) {
							{
							setState(396);
							match(END);
							}
						}

						setState(399);
						match(RIGHT_PARENTHESIS);
						}
						break;
					case 15:
						{
						_localctx = new AssignMemberContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(401);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(402);
						match(DOT);
						setState(403);
						match(IDENTIFIER);
						setState(404);
						match(EQUALS);
						setState(405);
						match(SEMICOLON);
						setState(406);
						match(BEGIN);
						setState(407);
						expression(0);
						setState(408);
						match(END);
						}
						break;
					case 16:
						{
						_localctx = new AssignIndexContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(410);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(411);
						match(LEFT_BRACKET);
						setState(413);
						_la = _input.LA(1);
						if (_la==BEGIN) {
							{
							setState(412);
							match(BEGIN);
							}
						}

						setState(423);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET))) != 0)) {
							{
							setState(415);
							expression(0);
							setState(420);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(416);
								match(COMMA);
								setState(417);
								expression(0);
								}
								}
								setState(422);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
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
						match(RIGHT_BRACKET);
						setState(432);
						match(EQUALS);
						setState(433);
						match(BEGIN);
						setState(434);
						expression(0);
						setState(435);
						match(SEMICOLON);
						setState(436);
						match(END);
						}
						break;
					}
					} 
				}
				setState(442);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
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
			setState(455);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(443);
				match(LEFT_THIN_ARROW);
				setState(444);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(445);
				match(LEFT_THIN_ARROW);
				setState(449); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(446);
						expression(0);
						setState(447);
						match(COMMA);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(451); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(453);
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
			setState(470);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(457);
				match(ELSE);
				setState(458);
				match(BEGIN);
				setState(462); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(459);
					instruction();
					setState(460);
					match(SEMICOLON);
					}
					}
					setState(464); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << IDENTIFIER) | (1L << DOLLAR) | (1L << AT) | (1L << CHARACTERS) | (1L << FLOAT) | (1L << INT) | (1L << MINUS) | (1L << BACKSLASH) | (1L << BANG) | (1L << LEFT_PARENTHESIS) | (1L << LEFT_BRACKET))) != 0) );
				setState(466);
				match(END);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(468);
				match(ELSE);
				setState(469);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3(\u01db\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\6\2\20\n\2\r\2\16\2\21\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4$\n\4"+
		"\3\4\3\4\5\4(\n\4\3\4\5\4+\n\4\3\4\3\4\3\4\3\4\5\4\61\n\4\3\4\3\4\3\4"+
		"\7\4\66\n\4\f\4\16\49\13\4\5\4;\n\4\3\4\5\4>\n\4\3\4\5\4A\n\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4J\n\4\3\4\3\4\3\4\5\4O\n\4\3\4\3\4\7\4S\n\4\f"+
		"\4\16\4V\13\4\3\4\3\4\5\4Z\n\4\3\4\5\4]\n\4\3\4\3\4\5\4a\n\4\3\4\3\4\3"+
		"\4\5\4f\n\4\3\4\3\4\3\4\5\4k\n\4\3\4\3\4\7\4o\n\4\f\4\16\4r\13\4\3\4\3"+
		"\4\5\4v\n\4\3\4\5\4y\n\4\3\4\3\4\5\4}\n\4\3\4\3\4\3\4\3\4\3\4\6\4\u0084"+
		"\n\4\r\4\16\4\u0085\3\4\3\4\3\4\5\4\u008b\n\4\3\4\3\4\7\4\u008f\n\4\f"+
		"\4\16\4\u0092\13\4\3\4\5\4\u0095\n\4\3\4\3\4\3\4\5\4\u009a\n\4\3\4\3\4"+
		"\7\4\u009e\n\4\f\4\16\4\u00a1\13\4\3\4\5\4\u00a4\n\4\3\4\3\4\3\4\3\4\3"+
		"\4\6\4\u00ab\n\4\r\4\16\4\u00ac\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"\u00c9\n\4\3\4\3\4\5\4\u00cd\n\4\3\4\5\4\u00d0\n\4\3\4\3\4\3\4\5\4\u00d5"+
		"\n\4\3\4\3\4\3\4\5\4\u00da\n\4\3\4\3\4\5\4\u00de\n\4\3\4\5\4\u00e1\n\4"+
		"\3\4\3\4\3\4\3\4\3\4\6\4\u00e8\n\4\r\4\16\4\u00e9\3\4\3\4\5\4\u00ee\n"+
		"\4\3\4\3\4\3\4\5\4\u00f3\n\4\3\4\3\4\5\4\u00f7\n\4\3\4\5\4\u00fa\n\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4\u0102\n\4\3\4\3\4\5\4\u0106\n\4\3\4\5\4\u0109"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\6\4\u0110\n\4\r\4\16\4\u0111\3\4\3\4\5\4\u0116"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0132\n\4\3\4\3\4\3\4\7\4\u0137"+
		"\n\4\f\4\16\4\u013a\13\4\5\4\u013c\n\4\3\4\5\4\u013f\n\4\3\4\5\4\u0142"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0151\n\4"+
		"\3\4\3\4\3\4\7\4\u0156\n\4\f\4\16\4\u0159\13\4\3\4\5\4\u015c\n\4\3\4\5"+
		"\4\u015f\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0169\n\4\3\4\3\4\3\4"+
		"\7\4\u016e\n\4\f\4\16\4\u0171\13\4\5\4\u0173\n\4\3\4\5\4\u0176\n\4\3\4"+
		"\5\4\u0179\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0182\n\4\3\4\3\4\3\4\7"+
		"\4\u0187\n\4\f\4\16\4\u018a\13\4\3\4\5\4\u018d\n\4\3\4\5\4\u0190\n\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u01a0\n\4\3"+
		"\4\3\4\3\4\7\4\u01a5\n\4\f\4\16\4\u01a8\13\4\5\4\u01aa\n\4\3\4\5\4\u01ad"+
		"\n\4\3\4\5\4\u01b0\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u01b9\n\4\f\4\16"+
		"\4\u01bc\13\4\3\5\3\5\3\5\3\5\3\5\3\5\6\5\u01c4\n\5\r\5\16\5\u01c5\3\5"+
		"\3\5\5\5\u01ca\n\5\3\6\3\6\3\6\3\6\3\6\6\6\u01d1\n\6\r\6\16\6\u01d2\3"+
		"\6\3\6\3\6\3\6\5\6\u01d9\n\6\3\6\2\3\6\7\2\4\6\b\n\2\t\4\2\b\b\23\23\3"+
		"\2\21\22\3\2\17\20\3\2\24\25\3\2\26\31\3\2\32\32\3\2\33\33\u0244\2\17"+
		"\3\2\2\2\4\23\3\2\2\2\6\u0115\3\2\2\2\b\u01c9\3\2\2\2\n\u01d8\3\2\2\2"+
		"\f\r\5\4\3\2\r\16\7#\2\2\16\20\3\2\2\2\17\f\3\2\2\2\20\21\3\2\2\2\21\17"+
		"\3\2\2\2\21\22\3\2\2\2\22\3\3\2\2\2\23\24\5\6\4\2\24\5\3\2\2\2\25\26\b"+
		"\4\1\2\26\27\7\20\2\2\27\u0116\5\6\4\26\30\31\7\34\2\2\31\u0116\5\6\4"+
		"\25\32\33\7\n\2\2\33\34\7\b\2\2\34\35\7\37\2\2\35\u0116\5\6\4\16\36\37"+
		"\7\b\2\2\37 \7\37\2\2 \u0116\5\6\4\f!#\7$\2\2\"$\7\3\2\2#\"\3\2\2\2#$"+
		"\3\2\2\2$%\3\2\2\2%\'\5\6\4\2&(\7#\2\2\'&\3\2\2\2\'(\3\2\2\2(*\3\2\2\2"+
		")+\7\4\2\2*)\3\2\2\2*+\3\2\2\2+,\3\2\2\2,-\7%\2\2-\u0116\3\2\2\2.\60\7"+
		"&\2\2/\61\7\3\2\2\60/\3\2\2\2\60\61\3\2\2\2\61:\3\2\2\2\62\67\5\6\4\2"+
		"\63\64\7!\2\2\64\66\5\6\4\2\65\63\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\67"+
		"8\3\2\2\28;\3\2\2\29\67\3\2\2\2:\62\3\2\2\2:;\3\2\2\2;=\3\2\2\2<>\7#\2"+
		"\2=<\3\2\2\2=>\3\2\2\2>@\3\2\2\2?A\7\4\2\2@?\3\2\2\2@A\3\2\2\2AB\3\2\2"+
		"\2B\u0116\7\'\2\2C\u0116\7\n\2\2D\u0116\7\13\2\2E\u0116\7\f\2\2F\u0116"+
		"\7\r\2\2G\u0116\7\16\2\2HJ\7\n\2\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\t\2"+
		"\2\2LN\7$\2\2MO\7\3\2\2NM\3\2\2\2NO\3\2\2\2OT\3\2\2\2PQ\7\b\2\2QS\7!\2"+
		"\2RP\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WY\7\b\2"+
		"\2XZ\7#\2\2YX\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[]\7\4\2\2\\[\3\2\2\2\\]\3\2"+
		"\2\2]^\3\2\2\2^`\7%\2\2_a\5\b\5\2`_\3\2\2\2`a\3\2\2\2ab\3\2\2\2bc\7\""+
		"\2\2c\u0116\5\4\3\2df\7\n\2\2ed\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\t\2\2\2"+
		"hj\7$\2\2ik\7\3\2\2ji\3\2\2\2jk\3\2\2\2kp\3\2\2\2lm\7\b\2\2mo\7!\2\2n"+
		"l\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qs\3\2\2\2rp\3\2\2\2su\7\b\2\2"+
		"tv\7#\2\2ut\3\2\2\2uv\3\2\2\2vx\3\2\2\2wy\7\4\2\2xw\3\2\2\2xy\3\2\2\2"+
		"yz\3\2\2\2z|\7%\2\2{}\5\b\5\2|{\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\177\7\"\2"+
		"\2\177\u0083\7\3\2\2\u0080\u0081\5\4\3\2\u0081\u0082\7#\2\2\u0082\u0084"+
		"\3\2\2\2\u0083\u0080\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7\4\2\2\u0088\u0116\3\2"+
		"\2\2\u0089\u008b\7\n\2\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u0090\t\2\2\2\u008d\u008f\7\b\2\2\u008e\u008d\3\2"+
		"\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0095\5\b\5\2\u0094\u0093\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\7\"\2\2\u0097"+
		"\u0116\5\4\3\2\u0098\u009a\7\n\2\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u009b\3\2\2\2\u009b\u009f\t\2\2\2\u009c\u009e\7\b\2\2\u009d"+
		"\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\5\b\5\2\u00a3"+
		"\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\7\""+
		"\2\2\u00a6\u00aa\7\3\2\2\u00a7\u00a8\5\4\3\2\u00a8\u00a9\7#\2\2\u00a9"+
		"\u00ab\3\2\2\2\u00aa\u00a7\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7\4\2\2\u00af"+
		"\u0116\3\2\2\2\u00b0\u00b1\7\n\2\2\u00b1\u00b2\7\n\2\2\u00b2\u0116\7\b"+
		"\2\2\u00b3\u00b4\7\n\2\2\u00b4\u0116\7\b\2\2\u00b5\u0116\7\b\2\2\u00b6"+
		"\u00b7\7\n\2\2\u00b7\u00b8\7\b\2\2\u00b8\u00b9\7\37\2\2\u00b9\u00ba\7"+
		"\3\2\2\u00ba\u00bb\5\6\4\2\u00bb\u00bc\7#\2\2\u00bc\u00bd\7\4\2\2\u00bd"+
		"\u0116\3\2\2\2\u00be\u00bf\7\b\2\2\u00bf\u00c0\7\37\2\2\u00c0\u00c1\7"+
		"\3\2\2\u00c1\u00c2\5\6\4\2\u00c2\u00c3\7#\2\2\u00c3\u00c4\7\4\2\2\u00c4"+
		"\u0116\3\2\2\2\u00c5\u00c6\7\5\2\2\u00c6\u00c8\7$\2\2\u00c7\u00c9\7\3"+
		"\2\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\u00cc\5\6\4\2\u00cb\u00cd\7#\2\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00d0\7\4\2\2\u00cf\u00ce\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\7%\2\2\u00d2\u00d4\5\4"+
		"\3\2\u00d3\u00d5\5\n\6\2\u00d4\u00d3\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u0116\3\2\2\2\u00d6\u00d7\7\5\2\2\u00d7\u00d9\7$\2\2\u00d8\u00da\7\3"+
		"\2\2\u00d9\u00d8\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00dd\5\6\4\2\u00dc\u00de\7#\2\2\u00dd\u00dc\3\2\2\2\u00dd\u00de\3\2"+
		"\2\2\u00de\u00e0\3\2\2\2\u00df\u00e1\7\4\2\2\u00e0\u00df\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\7%\2\2\u00e3\u00e7\7\3"+
		"\2\2\u00e4\u00e5\5\4\3\2\u00e5\u00e6\7#\2\2\u00e6\u00e8\3\2\2\2\u00e7"+
		"\u00e4\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2"+
		"\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed\7\4\2\2\u00ec\u00ee\5\n\6\2\u00ed"+
		"\u00ec\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u0116\3\2\2\2\u00ef\u00f0\7\7"+
		"\2\2\u00f0\u00f2\7$\2\2\u00f1\u00f3\7\3\2\2\u00f2\u00f1\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\5\6\4\2\u00f5\u00f7\7#"+
		"\2\2\u00f6\u00f5\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8"+
		"\u00fa\7\4\2\2\u00f9\u00f8\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\3\2"+
		"\2\2\u00fb\u00fc\7%\2\2\u00fc\u00fd\5\4\3\2\u00fd\u0116\3\2\2\2\u00fe"+
		"\u00ff\7\7\2\2\u00ff\u0101\7$\2\2\u0100\u0102\7\3\2\2\u0101\u0100\3\2"+
		"\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0105\5\6\4\2\u0104"+
		"\u0106\7#\2\2\u0105\u0104\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\3\2"+
		"\2\2\u0107\u0109\7\4\2\2\u0108\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a\u010b\7%\2\2\u010b\u010f\7\3\2\2\u010c\u010d\5\4"+
		"\3\2\u010d\u010e\7#\2\2\u010e\u0110\3\2\2\2\u010f\u010c\3\2\2\2\u0110"+
		"\u0111\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2"+
		"\2\2\u0113\u0114\7\4\2\2\u0114\u0116\3\2\2\2\u0115\25\3\2\2\2\u0115\30"+
		"\3\2\2\2\u0115\32\3\2\2\2\u0115\36\3\2\2\2\u0115!\3\2\2\2\u0115.\3\2\2"+
		"\2\u0115C\3\2\2\2\u0115D\3\2\2\2\u0115E\3\2\2\2\u0115F\3\2\2\2\u0115G"+
		"\3\2\2\2\u0115I\3\2\2\2\u0115e\3\2\2\2\u0115\u008a\3\2\2\2\u0115\u0099"+
		"\3\2\2\2\u0115\u00b0\3\2\2\2\u0115\u00b3\3\2\2\2\u0115\u00b5\3\2\2\2\u0115"+
		"\u00b6\3\2\2\2\u0115\u00be\3\2\2\2\u0115\u00c5\3\2\2\2\u0115\u00d6\3\2"+
		"\2\2\u0115\u00ef\3\2\2\2\u0115\u00fe\3\2\2\2\u0116\u01ba\3\2\2\2\u0117"+
		"\u0118\f\24\2\2\u0118\u0119\t\3\2\2\u0119\u01b9\5\6\4\25\u011a\u011b\f"+
		"\23\2\2\u011b\u011c\t\4\2\2\u011c\u01b9\5\6\4\24\u011d\u011e\f\22\2\2"+
		"\u011e\u011f\t\5\2\2\u011f\u01b9\5\6\4\23\u0120\u0121\f\21\2\2\u0121\u0122"+
		"\t\6\2\2\u0122\u01b9\5\6\4\22\u0123\u0124\f\20\2\2\u0124\u0125\t\7\2\2"+
		"\u0125\u01b9\5\6\4\21\u0126\u0127\f\17\2\2\u0127\u0128\t\b\2\2\u0128\u01b9"+
		"\5\6\4\20\u0129\u012a\f\n\2\2\u012a\u012b\7 \2\2\u012b\u012c\7\b\2\2\u012c"+
		"\u012d\7\37\2\2\u012d\u01b9\5\6\4\13\u012e\u012f\f\b\2\2\u012f\u0131\7"+
		"&\2\2\u0130\u0132\7\3\2\2\u0131\u0130\3\2\2\2\u0131\u0132\3\2\2\2\u0132"+
		"\u013b\3\2\2\2\u0133\u0138\5\6\4\2\u0134\u0135\7!\2\2\u0135\u0137\5\6"+
		"\4\2\u0136\u0134\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138"+
		"\u0139\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u0133\3\2"+
		"\2\2\u013b\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u013f\7#\2\2\u013e"+
		"\u013d\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0141\3\2\2\2\u0140\u0142\7\4"+
		"\2\2\u0141\u0140\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\3\2\2\2\u0143"+
		"\u0144\7\'\2\2\u0144\u0145\7\37\2\2\u0145\u01b9\5\6\4\t\u0146\u0147\f"+
		"\37\2\2\u0147\u0148\7 \2\2\u0148\u0149\7\b\2\2\u0149\u014a\7$\2\2\u014a"+
		"\u01b9\7%\2\2\u014b\u014c\f\36\2\2\u014c\u014d\7 \2\2\u014d\u014e\7\b"+
		"\2\2\u014e\u0150\7$\2\2\u014f\u0151\7\3\2\2\u0150\u014f\3\2\2\2\u0150"+
		"\u0151\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0157\5\6\4\2\u0153\u0154\7!"+
		"\2\2\u0154\u0156\5\6\4\2\u0155\u0153\3\2\2\2\u0156\u0159\3\2\2\2\u0157"+
		"\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2"+
		"\2\2\u015a\u015c\7#\2\2\u015b\u015a\3\2\2\2\u015b\u015c\3\2\2\2\u015c"+
		"\u015e\3\2\2\2\u015d\u015f\7\4\2\2\u015e\u015d\3\2\2\2\u015e\u015f\3\2"+
		"\2\2\u015f\u0160\3\2\2\2\u0160\u0161\7%\2\2\u0161\u01b9\3\2\2\2\u0162"+
		"\u0163\f\32\2\2\u0163\u0164\7 \2\2\u0164\u01b9\7\b\2\2\u0165\u0166\f\31"+
		"\2\2\u0166\u0168\7&\2\2\u0167\u0169\7\3\2\2\u0168\u0167\3\2\2\2\u0168"+
		"\u0169\3\2\2\2\u0169\u0172\3\2\2\2\u016a\u016f\5\6\4\2\u016b\u016c\7!"+
		"\2\2\u016c\u016e\5\6\4\2\u016d\u016b\3\2\2\2\u016e\u0171\3\2\2\2\u016f"+
		"\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0173\3\2\2\2\u0171\u016f\3\2"+
		"\2\2\u0172\u016a\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0175\3\2\2\2\u0174"+
		"\u0176\7#\2\2\u0175\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178\3\2"+
		"\2\2\u0177\u0179\7\4\2\2\u0178\u0177\3\2\2\2\u0178\u0179\3\2\2\2\u0179"+
		"\u017a\3\2\2\2\u017a\u01b9\7\'\2\2\u017b\u017c\f\30\2\2\u017c\u017d\7"+
		"$\2\2\u017d\u01b9\7%\2\2\u017e\u017f\f\27\2\2\u017f\u0181\7$\2\2\u0180"+
		"\u0182\7\3\2\2\u0181\u0180\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0183\3\2"+
		"\2\2\u0183\u0188\5\6\4\2\u0184\u0185\7!\2\2\u0185\u0187\5\6\4\2\u0186"+
		"\u0184\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0189\3\2"+
		"\2\2\u0189\u018c\3\2\2\2\u018a\u0188\3\2\2\2\u018b\u018d\7#\2\2\u018c"+
		"\u018b\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018f\3\2\2\2\u018e\u0190\7\4"+
		"\2\2\u018f\u018e\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\3\2\2\2\u0191"+
		"\u0192\7%\2\2\u0192\u01b9\3\2\2\2\u0193\u0194\f\t\2\2\u0194\u0195\7 \2"+
		"\2\u0195\u0196\7\b\2\2\u0196\u0197\7\37\2\2\u0197\u0198\7#\2\2\u0198\u0199"+
		"\7\3\2\2\u0199\u019a\5\6\4\2\u019a\u019b\7\4\2\2\u019b\u01b9\3\2\2\2\u019c"+
		"\u019d\f\7\2\2\u019d\u019f\7&\2\2\u019e\u01a0\7\3\2\2\u019f\u019e\3\2"+
		"\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a9\3\2\2\2\u01a1\u01a6\5\6\4\2\u01a2"+
		"\u01a3\7!\2\2\u01a3\u01a5\5\6\4\2\u01a4\u01a2\3\2\2\2\u01a5\u01a8\3\2"+
		"\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8"+
		"\u01a6\3\2\2\2\u01a9\u01a1\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ac\3\2"+
		"\2\2\u01ab\u01ad\7#\2\2\u01ac\u01ab\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad"+
		"\u01af\3\2\2\2\u01ae\u01b0\7\4\2\2\u01af\u01ae\3\2\2\2\u01af\u01b0\3\2"+
		"\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b2\7\'\2\2\u01b2\u01b3\7\37\2\2\u01b3"+
		"\u01b4\7\3\2\2\u01b4\u01b5\5\6\4\2\u01b5\u01b6\7#\2\2\u01b6\u01b7\7\4"+
		"\2\2\u01b7\u01b9\3\2\2\2\u01b8\u0117\3\2\2\2\u01b8\u011a\3\2\2\2\u01b8"+
		"\u011d\3\2\2\2\u01b8\u0120\3\2\2\2\u01b8\u0123\3\2\2\2\u01b8\u0126\3\2"+
		"\2\2\u01b8\u0129\3\2\2\2\u01b8\u012e\3\2\2\2\u01b8\u0146\3\2\2\2\u01b8"+
		"\u014b\3\2\2\2\u01b8\u0162\3\2\2\2\u01b8\u0165\3\2\2\2\u01b8\u017b\3\2"+
		"\2\2\u01b8\u017e\3\2\2\2\u01b8\u0193\3\2\2\2\u01b8\u019c\3\2\2\2\u01b9"+
		"\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\7\3\2\2\2"+
		"\u01bc\u01ba\3\2\2\2\u01bd\u01be\7\t\2\2\u01be\u01ca\5\6\4\2\u01bf\u01c3"+
		"\7\t\2\2\u01c0\u01c1\5\6\4\2\u01c1\u01c2\7!\2\2\u01c2\u01c4\3\2\2\2\u01c3"+
		"\u01c0\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c5\u01c6\3\2"+
		"\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c8\5\6\4\2\u01c8\u01ca\3\2\2\2\u01c9"+
		"\u01bd\3\2\2\2\u01c9\u01bf\3\2\2\2\u01ca\t\3\2\2\2\u01cb\u01cc\7\6\2\2"+
		"\u01cc\u01d0\7\3\2\2\u01cd\u01ce\5\4\3\2\u01ce\u01cf\7#\2\2\u01cf\u01d1"+
		"\3\2\2\2\u01d0\u01cd\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d2"+
		"\u01d3\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d5\7\4\2\2\u01d5\u01d9\3\2"+
		"\2\2\u01d6\u01d7\7\6\2\2\u01d7\u01d9\5\4\3\2\u01d8\u01cb\3\2\2\2\u01d8"+
		"\u01d6\3\2\2\2\u01d9\13\3\2\2\2M\21#\'*\60\67:=@INTY\\`ejpux|\u0085\u008a"+
		"\u0090\u0094\u0099\u009f\u00a3\u00ac\u00c8\u00cc\u00cf\u00d4\u00d9\u00dd"+
		"\u00e0\u00e9\u00ed\u00f2\u00f6\u00f9\u0101\u0105\u0108\u0111\u0115\u0131"+
		"\u0138\u013b\u013e\u0141\u0150\u0157\u015b\u015e\u0168\u016f\u0172\u0175"+
		"\u0178\u0181\u0188\u018c\u018f\u019f\u01a6\u01a9\u01ac\u01af\u01b8\u01ba"+
		"\u01c5\u01c9\u01d2\u01d8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}