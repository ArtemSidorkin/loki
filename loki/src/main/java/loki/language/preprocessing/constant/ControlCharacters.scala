package loki.language.preprocessing.constant

private[preprocessing] object ControlCharacters
{
	final val NEW_LINE = '\n'
	final val NEW_LINE_CARET = '\r'
	final val TAB = '\t'
	final val SPACE = ' '

	final val VALUES:collection.Seq[Char] = Array(NEW_LINE, NEW_LINE_CARET, TAB, SPACE)
}