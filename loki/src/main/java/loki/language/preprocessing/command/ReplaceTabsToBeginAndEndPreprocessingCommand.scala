package loki.language.preprocessing.command

import loki.language.preprocessing.CodeLine
import loki.language.preprocessing.constant.{CompilerTokens, IgnoredCharacters}

import scala.collection.mutable
import scala.language.postfixOps

private[preprocessing] object ReplaceTabsToBeginAndEndPreprocessingCommand
{
	final val BLOCK_TOKENS:collection.Seq[String] =
		Array(
			CompilerTokens.ELSE,
			CompilerTokens.COLON,
			CompilerTokens.BACKSLASH
		)

	def apply(code:collection.Seq[CodeLine]):collection.Seq[CodeLine] =
	{
		val tabStack = mutable.Stack[CodeLine]()

		val lastCodeLine =
			code
				.filter(!_.isEmpty)
				.foldLeft(new CodeLine)((previousCodeLine, currentCodeLine) =>
				{
					val previousCodeLineIndentCount = previousCodeLine.indentCount
					val currentCodeLineIndentCount = currentCodeLine.indentCount

					if (currentCodeLineIndentCount > previousCodeLineIndentCount)
					{
						if (BLOCK_TOKENS.exists(previousCodeLine.trimmed.endsWith))
							for (_ <- 0 until currentCodeLineIndentCount - previousCodeLineIndentCount)
							{
								tabStack.push(new CodeLine(CompilerTokens.RIGHT_BRACE))
								previousCodeLine.additionalLines += new CodeLine(CompilerTokens.LEFT_BRACE)
							}
						else for (_ <- 0 until currentCodeLineIndentCount - previousCodeLineIndentCount)
							tabStack.push(new CodeLine)
					}
					else if (currentCodeLineIndentCount < previousCodeLineIndentCount)
						for (_ <- 0 until previousCodeLineIndentCount - currentCodeLineIndentCount)
							previousCodeLine.additionalLines += tabStack.pop()

					currentCodeLine
				})

		while (tabStack.nonEmpty) lastCodeLine.additionalLines += tabStack.pop()

		code
	}
}
