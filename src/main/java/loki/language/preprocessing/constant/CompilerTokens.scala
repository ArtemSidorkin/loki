package loki.language.preprocessing.constant

private[preprocessing] object CompilerTokens
{
	val BEGIN = "~{"
	val END = "~}"

	val LEFT_THIN_ARROW = "<-"
	val PLUS = '+'
	val MINUS = '-'
	val STAR = '*'
	val SLASH = '/'
	val BACK_SLASH = '\\'
	val EQUALS = '='
	val DOT = '.'
	val COMA = ','
	val COLON = ':'
	val SEMICOLON = ';'
	val LEFT_PARENTHESIS = '('
	val RIGHT_PARENTHESIS = ')'
	val LEFT_BRACKET = '['
	val RIGHT_BRACKET = ']'
	val LEFT_BRACE = '{'
	val RIGHT_BRACE = '}'
	val ELSE = "else"

	val NEW_LINE = '\n'
	val NEW_LINE_CARET = '\r'
	val TAB = '\t'
	val SPACE = ' '
}
