package loki.language.preprocessing

import loki.language.preprocessing.constant.CompilerTokens

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class CodeLine(val raw:String)
{
	private val IGNORABLE_TOKENS:collection.Set[Char] =
		mutable.HashSet(
			CompilerTokens.NEW_LINE,
			CompilerTokens.NEW_LINE_CARET,
			CompilerTokens.TAB,
			CompilerTokens.SPACE
		)

	var semicolon:Boolean = false
	val additionalLines:ArrayBuffer[CodeLine] = ArrayBuffer()

	val trimmed:String =
		if (raw.exists(!IGNORABLE_TOKENS.contains(_)))
		{
			val ignorableTokenCount = raw.reverse.takeWhile(IGNORABLE_TOKENS.contains).length
			raw.take(raw.length - ignorableTokenCount)
		}
		else ""

	def ignore:Boolean = trimmed.isEmpty
}