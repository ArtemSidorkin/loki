// Generated from ./src/main/java/loki/language/parsing/Loki.grammar by ANTLR 4.5

package loki.language.parsing;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LokiLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BEGIN", "END", "IF", "ELSE", "WHILE", "IDENTIFIER", "LEFT_THIN_ARROW", 
		"DOLLAR", "AT", "CHARACTERS", "FLOAT", "INT", "PLUS", "MINUS", "STAR", 
		"SLASH", "BACKSLASH", "EQUALS_EQUALS", "BANG_EQUALS", "GREATER_THAN_EQUALS", 
		"GREATER_THAN", "LESS_THAN_EQUALS", "LESS_THAN", "AMPERSAND_AMPERSAND", 
		"PIPE_PIPE", "BANG", "AMPERSAND", "PIPE", "EQUALS", "DOT", "COMMA", "COLON", 
		"SEMICOLON", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", "LEFT_BRACKET", 
		"RIGHT_BRACKET", "LEFT_BRACE", "RIGHT_BRACE", "ACUTE", "SKIP"
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
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2+\u00e1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\7\7k\n\7\f\7\16\7n\13\7\3\7\6\7q\n\7\r\7\16\7r\3\7\7\7v\n\7\f\7"+
		"\16\7y\13\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\7\13\u0086"+
		"\n\13\f\13\16\13\u0089\13\13\3\13\3\13\3\f\6\f\u008e\n\f\r\f\16\f\u008f"+
		"\3\f\3\f\6\f\u0094\n\f\r\f\16\f\u0095\3\r\6\r\u0099\n\r\r\r\16\r\u009a"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\6"+
		"*\u00dc\n*\r*\16*\u00dd\3*\3*\3\u0087\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+\3\2"+
		"\5\4\2C\\c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\u00e9\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"+
		"\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3U\3\2\2\2\5X\3\2\2"+
		"\2\7[\3\2\2\2\t^\3\2\2\2\13c\3\2\2\2\rl\3\2\2\2\17z\3\2\2\2\21}\3\2\2"+
		"\2\23\177\3\2\2\2\25\u0081\3\2\2\2\27\u008d\3\2\2\2\31\u0098\3\2\2\2\33"+
		"\u009c\3\2\2\2\35\u009e\3\2\2\2\37\u00a0\3\2\2\2!\u00a2\3\2\2\2#\u00a4"+
		"\3\2\2\2%\u00a6\3\2\2\2\'\u00a9\3\2\2\2)\u00ac\3\2\2\2+\u00af\3\2\2\2"+
		"-\u00b1\3\2\2\2/\u00b4\3\2\2\2\61\u00b6\3\2\2\2\63\u00b9\3\2\2\2\65\u00bc"+
		"\3\2\2\2\67\u00be\3\2\2\29\u00c0\3\2\2\2;\u00c2\3\2\2\2=\u00c4\3\2\2\2"+
		"?\u00c6\3\2\2\2A\u00c8\3\2\2\2C\u00ca\3\2\2\2E\u00cc\3\2\2\2G\u00ce\3"+
		"\2\2\2I\u00d0\3\2\2\2K\u00d2\3\2\2\2M\u00d4\3\2\2\2O\u00d6\3\2\2\2Q\u00d8"+
		"\3\2\2\2S\u00db\3\2\2\2UV\7\u0080\2\2VW\7}\2\2W\4\3\2\2\2XY\7\u0080\2"+
		"\2YZ\7\177\2\2Z\6\3\2\2\2[\\\7k\2\2\\]\7h\2\2]\b\3\2\2\2^_\7g\2\2_`\7"+
		"n\2\2`a\7u\2\2ab\7g\2\2b\n\3\2\2\2cd\7y\2\2de\7j\2\2ef\7k\2\2fg\7n\2\2"+
		"gh\7g\2\2h\f\3\2\2\2ik\7a\2\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2"+
		"mp\3\2\2\2nl\3\2\2\2oq\t\2\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2"+
		"sw\3\2\2\2tv\t\3\2\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\16\3\2\2"+
		"\2yw\3\2\2\2z{\7>\2\2{|\7/\2\2|\20\3\2\2\2}~\7&\2\2~\22\3\2\2\2\177\u0080"+
		"\7B\2\2\u0080\24\3\2\2\2\u0081\u0087\7$\2\2\u0082\u0083\7^\2\2\u0083\u0086"+
		"\7$\2\2\u0084\u0086\13\2\2\2\u0085\u0082\3\2\2\2\u0085\u0084\3\2\2\2\u0086"+
		"\u0089\3\2\2\2\u0087\u0088\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008a\3\2"+
		"\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7$\2\2\u008b\26\3\2\2\2\u008c\u008e"+
		"\4\62;\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\7\60\2\2\u0092\u0094\4"+
		"\62;\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\30\3\2\2\2\u0097\u0099\4\62;\2\u0098\u0097\3\2\2"+
		"\2\u0099\u009a\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\32"+
		"\3\2\2\2\u009c\u009d\7-\2\2\u009d\34\3\2\2\2\u009e\u009f\7/\2\2\u009f"+
		"\36\3\2\2\2\u00a0\u00a1\7,\2\2\u00a1 \3\2\2\2\u00a2\u00a3\7\61\2\2\u00a3"+
		"\"\3\2\2\2\u00a4\u00a5\7^\2\2\u00a5$\3\2\2\2\u00a6\u00a7\7?\2\2\u00a7"+
		"\u00a8\7?\2\2\u00a8&\3\2\2\2\u00a9\u00aa\7#\2\2\u00aa\u00ab\7?\2\2\u00ab"+
		"(\3\2\2\2\u00ac\u00ad\7@\2\2\u00ad\u00ae\7?\2\2\u00ae*\3\2\2\2\u00af\u00b0"+
		"\7@\2\2\u00b0,\3\2\2\2\u00b1\u00b2\7>\2\2\u00b2\u00b3\7?\2\2\u00b3.\3"+
		"\2\2\2\u00b4\u00b5\7>\2\2\u00b5\60\3\2\2\2\u00b6\u00b7\7(\2\2\u00b7\u00b8"+
		"\7(\2\2\u00b8\62\3\2\2\2\u00b9\u00ba\7~\2\2\u00ba\u00bb\7~\2\2\u00bb\64"+
		"\3\2\2\2\u00bc\u00bd\7#\2\2\u00bd\66\3\2\2\2\u00be\u00bf\7(\2\2\u00bf"+
		"8\3\2\2\2\u00c0\u00c1\7~\2\2\u00c1:\3\2\2\2\u00c2\u00c3\7?\2\2\u00c3<"+
		"\3\2\2\2\u00c4\u00c5\7\60\2\2\u00c5>\3\2\2\2\u00c6\u00c7\7.\2\2\u00c7"+
		"@\3\2\2\2\u00c8\u00c9\7<\2\2\u00c9B\3\2\2\2\u00ca\u00cb\7=\2\2\u00cbD"+
		"\3\2\2\2\u00cc\u00cd\7*\2\2\u00cdF\3\2\2\2\u00ce\u00cf\7+\2\2\u00cfH\3"+
		"\2\2\2\u00d0\u00d1\7]\2\2\u00d1J\3\2\2\2\u00d2\u00d3\7_\2\2\u00d3L\3\2"+
		"\2\2\u00d4\u00d5\7}\2\2\u00d5N\3\2\2\2\u00d6\u00d7\7\177\2\2\u00d7P\3"+
		"\2\2\2\u00d8\u00d9\7b\2\2\u00d9R\3\2\2\2\u00da\u00dc\t\4\2\2\u00db\u00da"+
		"\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e0\b*\2\2\u00e0T\3\2\2\2\f\2lrw\u0085\u0087\u008f"+
		"\u0095\u009a\u00dd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}