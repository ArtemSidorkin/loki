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
		BEGIN=1, END=2, IF=3, ELSE=4, WHILE=5, IDENTIFIER=6, UNDERSCORE=7, DOLLAR=8, 
		AT=9, CHARACTERS=10, FLOAT=11, INT=12, PLUS=13, MINUS=14, STAR=15, SLASH=16, 
		BACKSLASH=17, EQUALS_EQUALS=18, BANG_EQUALS=19, GREATER_THAN_EQUALS=20, 
		GREATER_THAN=21, LESS_THAN_EQUALS=22, LESS_THAN=23, AMPERSAND_AMPERSAND=24, 
		PIPE_PIPE=25, BANG=26, AMPERSAND=27, PIPE=28, EQUALS=29, DOT=30, COMMA=31, 
		DOUBLE_COLON=32, COLON=33, RIGHT_THIN_ARROW=34, RIGHT_THICK_ARROW=35, 
		SEMICOLON=36, LEFT_PARENTHESIS=37, RIGHT_PARENTHESIS=38, LEFT_BRACKET=39, 
		RIGHT_BRACKET=40, LEFT_BRACE=41, RIGHT_BRACE=42, ACUTE=43, IGNORE=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"BEGIN", "END", "IF", "ELSE", "WHILE", "IDENTIFIER", "UNDERSCORE", "DOLLAR", 
			"AT", "CHARACTERS", "FLOAT", "INT", "PLUS", "MINUS", "STAR", "SLASH", 
			"BACKSLASH", "EQUALS_EQUALS", "BANG_EQUALS", "GREATER_THAN_EQUALS", "GREATER_THAN", 
			"LESS_THAN_EQUALS", "LESS_THAN", "AMPERSAND_AMPERSAND", "PIPE_PIPE", 
			"BANG", "AMPERSAND", "PIPE", "EQUALS", "DOT", "COMMA", "DOUBLE_COLON", 
			"COLON", "RIGHT_THIN_ARROW", "RIGHT_THICK_ARROW", "SEMICOLON", "LEFT_PARENTHESIS", 
			"RIGHT_PARENTHESIS", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_BRACE", "RIGHT_BRACE", 
			"ACUTE", "IGNORE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u00ed\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\7\7o\n\7\f\7\16\7r\13\7\3\7\6\7u\n\7\r\7\16\7v\3\7\7"+
		"\7z\n\7\f\7\16\7}\13\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\7\13"+
		"\u0089\n\13\f\13\16\13\u008c\13\13\3\13\3\13\3\f\6\f\u0091\n\f\r\f\16"+
		"\f\u0092\3\f\3\f\6\f\u0097\n\f\r\f\16\f\u0098\3\r\6\r\u009c\n\r\r\r\16"+
		"\r\u009d\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3"+
		"\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3&\3&\3\'\3\'"+
		"\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\6-\u00e8\n-\r-\16-\u00e9\3-\3-\3\u008a"+
		"\2.\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.\3\2\5\4\2C\\c|\6\2\62;C\\aac|\5\2"+
		"\13\f\17\17\"\"\2\u00f5\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3[\3\2\2\2\5]\3"+
		"\2\2\2\7_\3\2\2\2\tb\3\2\2\2\13g\3\2\2\2\rp\3\2\2\2\17~\3\2\2\2\21\u0080"+
		"\3\2\2\2\23\u0082\3\2\2\2\25\u0084\3\2\2\2\27\u0090\3\2\2\2\31\u009b\3"+
		"\2\2\2\33\u009f\3\2\2\2\35\u00a1\3\2\2\2\37\u00a3\3\2\2\2!\u00a5\3\2\2"+
		"\2#\u00a7\3\2\2\2%\u00a9\3\2\2\2\'\u00ac\3\2\2\2)\u00af\3\2\2\2+\u00b2"+
		"\3\2\2\2-\u00b4\3\2\2\2/\u00b7\3\2\2\2\61\u00b9\3\2\2\2\63\u00bc\3\2\2"+
		"\2\65\u00bf\3\2\2\2\67\u00c1\3\2\2\29\u00c3\3\2\2\2;\u00c5\3\2\2\2=\u00c7"+
		"\3\2\2\2?\u00c9\3\2\2\2A\u00cb\3\2\2\2C\u00ce\3\2\2\2E\u00d0\3\2\2\2G"+
		"\u00d3\3\2\2\2I\u00d6\3\2\2\2K\u00d8\3\2\2\2M\u00da\3\2\2\2O\u00dc\3\2"+
		"\2\2Q\u00de\3\2\2\2S\u00e0\3\2\2\2U\u00e2\3\2\2\2W\u00e4\3\2\2\2Y\u00e7"+
		"\3\2\2\2[\\\5S*\2\\\4\3\2\2\2]^\5U+\2^\6\3\2\2\2_`\7k\2\2`a\7h\2\2a\b"+
		"\3\2\2\2bc\7g\2\2cd\7n\2\2de\7u\2\2ef\7g\2\2f\n\3\2\2\2gh\7y\2\2hi\7j"+
		"\2\2ij\7k\2\2jk\7n\2\2kl\7g\2\2l\f\3\2\2\2mo\7a\2\2nm\3\2\2\2or\3\2\2"+
		"\2pn\3\2\2\2pq\3\2\2\2qt\3\2\2\2rp\3\2\2\2su\t\2\2\2ts\3\2\2\2uv\3\2\2"+
		"\2vt\3\2\2\2vw\3\2\2\2w{\3\2\2\2xz\t\3\2\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2"+
		"\2{|\3\2\2\2|\16\3\2\2\2}{\3\2\2\2~\177\7a\2\2\177\20\3\2\2\2\u0080\u0081"+
		"\7&\2\2\u0081\22\3\2\2\2\u0082\u0083\7B\2\2\u0083\24\3\2\2\2\u0084\u008a"+
		"\7$\2\2\u0085\u0086\7^\2\2\u0086\u0089\7$\2\2\u0087\u0089\13\2\2\2\u0088"+
		"\u0085\3\2\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u008b\3\2"+
		"\2\2\u008a\u0088\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d"+
		"\u008e\7$\2\2\u008e\26\3\2\2\2\u008f\u0091\4\62;\2\u0090\u008f\3\2\2\2"+
		"\u0091\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094"+
		"\3\2\2\2\u0094\u0096\7\60\2\2\u0095\u0097\4\62;\2\u0096\u0095\3\2\2\2"+
		"\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\30"+
		"\3\2\2\2\u009a\u009c\4\62;\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\32\3\2\2\2\u009f\u00a0\7-\2\2"+
		"\u00a0\34\3\2\2\2\u00a1\u00a2\7/\2\2\u00a2\36\3\2\2\2\u00a3\u00a4\7,\2"+
		"\2\u00a4 \3\2\2\2\u00a5\u00a6\7\61\2\2\u00a6\"\3\2\2\2\u00a7\u00a8\7^"+
		"\2\2\u00a8$\3\2\2\2\u00a9\u00aa\7?\2\2\u00aa\u00ab\7?\2\2\u00ab&\3\2\2"+
		"\2\u00ac\u00ad\7#\2\2\u00ad\u00ae\7?\2\2\u00ae(\3\2\2\2\u00af\u00b0\7"+
		"@\2\2\u00b0\u00b1\7?\2\2\u00b1*\3\2\2\2\u00b2\u00b3\7@\2\2\u00b3,\3\2"+
		"\2\2\u00b4\u00b5\7>\2\2\u00b5\u00b6\7?\2\2\u00b6.\3\2\2\2\u00b7\u00b8"+
		"\7>\2\2\u00b8\60\3\2\2\2\u00b9\u00ba\7(\2\2\u00ba\u00bb\7(\2\2\u00bb\62"+
		"\3\2\2\2\u00bc\u00bd\7~\2\2\u00bd\u00be\7~\2\2\u00be\64\3\2\2\2\u00bf"+
		"\u00c0\7#\2\2\u00c0\66\3\2\2\2\u00c1\u00c2\7(\2\2\u00c28\3\2\2\2\u00c3"+
		"\u00c4\7~\2\2\u00c4:\3\2\2\2\u00c5\u00c6\7?\2\2\u00c6<\3\2\2\2\u00c7\u00c8"+
		"\7\60\2\2\u00c8>\3\2\2\2\u00c9\u00ca\7.\2\2\u00ca@\3\2\2\2\u00cb\u00cc"+
		"\7<\2\2\u00cc\u00cd\7<\2\2\u00cdB\3\2\2\2\u00ce\u00cf\7<\2\2\u00cfD\3"+
		"\2\2\2\u00d0\u00d1\7/\2\2\u00d1\u00d2\7@\2\2\u00d2F\3\2\2\2\u00d3\u00d4"+
		"\7?\2\2\u00d4\u00d5\7@\2\2\u00d5H\3\2\2\2\u00d6\u00d7\7=\2\2\u00d7J\3"+
		"\2\2\2\u00d8\u00d9\7*\2\2\u00d9L\3\2\2\2\u00da\u00db\7+\2\2\u00dbN\3\2"+
		"\2\2\u00dc\u00dd\7]\2\2\u00ddP\3\2\2\2\u00de\u00df\7_\2\2\u00dfR\3\2\2"+
		"\2\u00e0\u00e1\7}\2\2\u00e1T\3\2\2\2\u00e2\u00e3\7\177\2\2\u00e3V\3\2"+
		"\2\2\u00e4\u00e5\7b\2\2\u00e5X\3\2\2\2\u00e6\u00e8\t\4\2\2\u00e7\u00e6"+
		"\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb\u00ec\b-\2\2\u00ecZ\3\2\2\2\f\2pv{\u0088\u008a\u0092"+
		"\u0098\u009d\u00e9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}