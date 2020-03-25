// Generated from ./loki/src/main/java/loki/language/parsing/Loki.grammar by ANTLR 4.8

package loki.language.parsing;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LokiLexer extends Lexer {
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
		COLON=32, RIGHT_THIN_ARROW=33, SEMICOLON=34, LEFT_PARENTHESIS=35, RIGHT_PARENTHESIS=36, 
		LEFT_BRACKET=37, RIGHT_BRACKET=38, LEFT_BRACE=39, RIGHT_BRACE=40, ACUTE=41, 
		IGNORE=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"BEGIN", "END", "IF", "ELSE", "WHILE", "IDENTIFIER", "DOLLAR", "AT", 
			"CHARACTERS", "FLOAT", "INT", "PLUS", "MINUS", "STAR", "SLASH", "BACKSLASH", 
			"EQUALS_EQUALS", "BANG_EQUALS", "GREATER_THAN_EQUALS", "GREATER_THAN", 
			"LESS_THAN_EQUALS", "LESS_THAN", "AMPERSAND_AMPERSAND", "PIPE_PIPE", 
			"BANG", "AMPERSAND", "PIPE", "EQUALS", "DOT", "COMMA", "DOUBLE_COLON", 
			"COLON", "RIGHT_THIN_ARROW", "SEMICOLON", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_BRACE", "RIGHT_BRACE", "ACUTE", 
			"IGNORE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'~{'", "'~}'", "'if'", "'else'", "'while'", null, "'$'", "'@'", 
			null, null, null, "'+'", "'-'", "'*'", "'/'", "'\\'", "'=='", "'!='", 
			"'>='", "'>'", "'<='", "'<'", "'&&'", "'||'", "'!'", "'&'", "'|'", "'='", 
			"'.'", "','", "'::'", "':'", "'->'", "';'", "'('", "')'", "'['", "']'", 
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
			"COLON", "RIGHT_THIN_ARROW", "SEMICOLON", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_BRACE", "RIGHT_BRACE", "ACUTE", 
			"IGNORE"
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


	public LokiLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Loki.grammar"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u00e6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\7\7m\n\7\f\7\16\7p\13\7\3\7\6\7s\n\7\r\7\16\7t\3\7\7\7x\n"+
		"\7\f\7\16\7{\13\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\7\n\u0085\n\n\f\n\16"+
		"\n\u0088\13\n\3\n\3\n\3\13\6\13\u008d\n\13\r\13\16\13\u008e\3\13\3\13"+
		"\6\13\u0093\n\13\r\13\16\13\u0094\3\f\6\f\u0098\n\f\r\f\16\f\u0099\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37"+
		"\3\37\3 \3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3"+
		"(\3)\3)\3*\3*\3+\6+\u00e1\n+\r+\16+\u00e2\3+\3+\3\u0086\2,\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,\3\2\5\4\2C\\c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u00ee"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\3W\3\2\2\2\5Z\3\2\2\2\7]\3\2\2\2\t`\3\2\2\2\13e\3\2\2\2\rn\3"+
		"\2\2\2\17|\3\2\2\2\21~\3\2\2\2\23\u0080\3\2\2\2\25\u008c\3\2\2\2\27\u0097"+
		"\3\2\2\2\31\u009b\3\2\2\2\33\u009d\3\2\2\2\35\u009f\3\2\2\2\37\u00a1\3"+
		"\2\2\2!\u00a3\3\2\2\2#\u00a5\3\2\2\2%\u00a8\3\2\2\2\'\u00ab\3\2\2\2)\u00ae"+
		"\3\2\2\2+\u00b0\3\2\2\2-\u00b3\3\2\2\2/\u00b5\3\2\2\2\61\u00b8\3\2\2\2"+
		"\63\u00bb\3\2\2\2\65\u00bd\3\2\2\2\67\u00bf\3\2\2\29\u00c1\3\2\2\2;\u00c3"+
		"\3\2\2\2=\u00c5\3\2\2\2?\u00c7\3\2\2\2A\u00ca\3\2\2\2C\u00cc\3\2\2\2E"+
		"\u00cf\3\2\2\2G\u00d1\3\2\2\2I\u00d3\3\2\2\2K\u00d5\3\2\2\2M\u00d7\3\2"+
		"\2\2O\u00d9\3\2\2\2Q\u00db\3\2\2\2S\u00dd\3\2\2\2U\u00e0\3\2\2\2WX\7\u0080"+
		"\2\2XY\7}\2\2Y\4\3\2\2\2Z[\7\u0080\2\2[\\\7\177\2\2\\\6\3\2\2\2]^\7k\2"+
		"\2^_\7h\2\2_\b\3\2\2\2`a\7g\2\2ab\7n\2\2bc\7u\2\2cd\7g\2\2d\n\3\2\2\2"+
		"ef\7y\2\2fg\7j\2\2gh\7k\2\2hi\7n\2\2ij\7g\2\2j\f\3\2\2\2km\7a\2\2lk\3"+
		"\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2or\3\2\2\2pn\3\2\2\2qs\t\2\2\2rq\3"+
		"\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2uy\3\2\2\2vx\t\3\2\2wv\3\2\2\2x{\3"+
		"\2\2\2yw\3\2\2\2yz\3\2\2\2z\16\3\2\2\2{y\3\2\2\2|}\7&\2\2}\20\3\2\2\2"+
		"~\177\7B\2\2\177\22\3\2\2\2\u0080\u0086\7$\2\2\u0081\u0082\7^\2\2\u0082"+
		"\u0085\7$\2\2\u0083\u0085\13\2\2\2\u0084\u0081\3\2\2\2\u0084\u0083\3\2"+
		"\2\2\u0085\u0088\3\2\2\2\u0086\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087"+
		"\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7$\2\2\u008a\24\3\2\2\2"+
		"\u008b\u008d\4\62;\2\u008c\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c"+
		"\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\7\60\2\2"+
		"\u0091\u0093\4\62;\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0095\26\3\2\2\2\u0096\u0098\4\62;\2\u0097"+
		"\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\30\3\2\2\2\u009b\u009c\7-\2\2\u009c\32\3\2\2\2\u009d\u009e"+
		"\7/\2\2\u009e\34\3\2\2\2\u009f\u00a0\7,\2\2\u00a0\36\3\2\2\2\u00a1\u00a2"+
		"\7\61\2\2\u00a2 \3\2\2\2\u00a3\u00a4\7^\2\2\u00a4\"\3\2\2\2\u00a5\u00a6"+
		"\7?\2\2\u00a6\u00a7\7?\2\2\u00a7$\3\2\2\2\u00a8\u00a9\7#\2\2\u00a9\u00aa"+
		"\7?\2\2\u00aa&\3\2\2\2\u00ab\u00ac\7@\2\2\u00ac\u00ad\7?\2\2\u00ad(\3"+
		"\2\2\2\u00ae\u00af\7@\2\2\u00af*\3\2\2\2\u00b0\u00b1\7>\2\2\u00b1\u00b2"+
		"\7?\2\2\u00b2,\3\2\2\2\u00b3\u00b4\7>\2\2\u00b4.\3\2\2\2\u00b5\u00b6\7"+
		"(\2\2\u00b6\u00b7\7(\2\2\u00b7\60\3\2\2\2\u00b8\u00b9\7~\2\2\u00b9\u00ba"+
		"\7~\2\2\u00ba\62\3\2\2\2\u00bb\u00bc\7#\2\2\u00bc\64\3\2\2\2\u00bd\u00be"+
		"\7(\2\2\u00be\66\3\2\2\2\u00bf\u00c0\7~\2\2\u00c08\3\2\2\2\u00c1\u00c2"+
		"\7?\2\2\u00c2:\3\2\2\2\u00c3\u00c4\7\60\2\2\u00c4<\3\2\2\2\u00c5\u00c6"+
		"\7.\2\2\u00c6>\3\2\2\2\u00c7\u00c8\7<\2\2\u00c8\u00c9\7<\2\2\u00c9@\3"+
		"\2\2\2\u00ca\u00cb\7<\2\2\u00cbB\3\2\2\2\u00cc\u00cd\7/\2\2\u00cd\u00ce"+
		"\7@\2\2\u00ceD\3\2\2\2\u00cf\u00d0\7=\2\2\u00d0F\3\2\2\2\u00d1\u00d2\7"+
		"*\2\2\u00d2H\3\2\2\2\u00d3\u00d4\7+\2\2\u00d4J\3\2\2\2\u00d5\u00d6\7]"+
		"\2\2\u00d6L\3\2\2\2\u00d7\u00d8\7_\2\2\u00d8N\3\2\2\2\u00d9\u00da\7}\2"+
		"\2\u00daP\3\2\2\2\u00db\u00dc\7\177\2\2\u00dcR\3\2\2\2\u00dd\u00de\7b"+
		"\2\2\u00deT\3\2\2\2\u00df\u00e1\t\4\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e2"+
		"\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		"\u00e5\b+\2\2\u00e5V\3\2\2\2\f\2nty\u0084\u0086\u008e\u0094\u0099\u00e2"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}