package loki.language.preprocessing.command

import loki.language.preprocessing.constant.CompilerTokens

import scala.collection.mutable
import scala.language.postfixOps

private[preprocessing] object RemoveIgnorableCharactersPreprocessingCommand extends PreprocessingCommand
{
	private val IGNORABLE_TOKENS:collection.Set[Char] =
		mutable.HashSet(
			CompilerTokens.NEW_LINE,
			CompilerTokens.NEW_LINE_CARET,
			CompilerTokens.TAB,
			CompilerTokens.SPACE
		)

	override def apply(code:StringBuilder):Unit =
	{
		val codeLines = code.toString split CompilerTokens.NEW_LINE
		val newCode = new StringBuilder

		codeLines
			.foldLeft(0)((i, codeLine) =>
			{
				if (codeLine exists (IGNORABLE_TOKENS contains _ unary_!))
				{
					val ignorableTokenCount = (codeLine.reverse takeWhile IGNORABLE_TOKENS.contains length)
					newCode ++= codeLine take codeLine.length - ignorableTokenCount

					if (i < codeLines.length - 1) newCode += CompilerTokens.NEW_LINE
				}

				i + 1
			})

		code.clear()
		code ++= newCode
	}
}
