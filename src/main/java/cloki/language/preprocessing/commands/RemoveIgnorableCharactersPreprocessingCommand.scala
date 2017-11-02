package cloki.language.preprocessing.commands

import cloki.language.preprocessing.consts.ConstCompilerTokens

import scala.collection.mutable

private[preprocessing] object RemoveIgnorableCharactersPreprocessingCommand extends PreprocessingCommand
{
	private val IGNORABLE_TOKENS:collection.Set[Char] =
		mutable.HashSet(
			ConstCompilerTokens.NEW_LINE,
			ConstCompilerTokens.NEW_LINE_CARET,
			ConstCompilerTokens.TAB,
			ConstCompilerTokens.SPACE
		)

	override def apply(code:StringBuilder):Unit =
	{
		val codeLines = code split ConstCompilerTokens.NEW_LINE
		val newCode = new StringBuilder

		codeLines
			.foldLeft(0)((i, codeLine) =>
			{
				if (codeLine exists (IGNORABLE_TOKENS contains _ unary_!))
				{
					val ignorableTokenCount = (codeLine.reverse takeWhile IGNORABLE_TOKENS.contains length)
					newCode ++= codeLine take codeLine.length - ignorableTokenCount

					if (i < codeLines.length - 1) newCode += ConstCompilerTokens.NEW_LINE
				}

				i + 1
			})

		code.clear()
		code ++= newCode
	}
}
