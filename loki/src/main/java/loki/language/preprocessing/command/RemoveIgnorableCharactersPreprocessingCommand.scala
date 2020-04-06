package loki.language.preprocessing.command

import loki.language.preprocessing.CodeLine
import loki.language.preprocessing.constant.CompilerTokens

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.language.postfixOps

private[preprocessing] object RemoveIgnorableCharactersPreprocessingCommand
{
	private val IGNORABLE_TOKENS:collection.Set[Char] =
		mutable.HashSet(
			CompilerTokens.NEW_LINE,
			CompilerTokens.NEW_LINE_CARET,
			CompilerTokens.TAB,
			CompilerTokens.SPACE
		)

	def apply(code:String):collection.Seq[CodeLine] =
	{
		val codeLines = code.toString split CompilerTokens.NEW_LINE
		val newCode = new ArrayBuffer[CodeLine]

		codeLines
			.foldLeft(0)((i, codeLine) =>
			{
				if (codeLine.exists(!IGNORABLE_TOKENS.contains(_)))
				{
					val ignorableTokenCount = (codeLine.reverse takeWhile IGNORABLE_TOKENS.contains length)
					newCode += new CodeLine(codeLine, codeLine take codeLine.length - ignorableTokenCount, false, ArrayBuffer())
				}
				else newCode += new CodeLine(codeLine, "", true, ArrayBuffer())

				i + 1
			})

		newCode
	}
}
