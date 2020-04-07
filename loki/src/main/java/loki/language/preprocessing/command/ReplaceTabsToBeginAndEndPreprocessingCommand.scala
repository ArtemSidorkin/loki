package loki.language.preprocessing.command

import loki.language.preprocessing.CodeLine
import loki.language.preprocessing.constant.CompilerTokens

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
		val tabStack = mutable.Stack[Int]()

		val lastCodeLine =
			code.filter(!_.isEmpty).foldLeft(new CodeLine(""))((previousLine, codeLine) =>
			{
				val previousLineTabCount = countTabsInCodeLine(previousLine.trimmed)

				val tabCountInCurrentLine = countTabsInCodeLine(codeLine.trimmed)

				if (tabCountInCurrentLine > previousLineTabCount)
				{
					if (previousLine.trimmed.endsWith(":") || previousLine.trimmed.endsWith("else") || previousLine.trimmed.endsWith("\\"))
					{
						for (_ <- 0 until tabCountInCurrentLine - previousLineTabCount)
						{
							tabStack.push(1)
							previousLine.additionalLines += new CodeLine(CompilerTokens.LEFT_BRACE)
						}
					}
					else
					{
						for (_ <- 0 until tabCountInCurrentLine - previousLineTabCount) tabStack.push(0)
					}
				}
				else if (tabCountInCurrentLine < previousLineTabCount)
				{
					for (_ <- 0 until previousLineTabCount - tabCountInCurrentLine)
					{
						if (tabStack.pop() == 1) previousLine.additionalLines += new CodeLine(CompilerTokens.RIGHT_BRACE)
					}
				}

				codeLine
			})

		while (tabStack.nonEmpty)
			if (tabStack.pop() == 1)
				lastCodeLine.additionalLines += new CodeLine(CompilerTokens.RIGHT_BRACE)

		code
	}

	private def countTabsInCodeLine(string:String):Int = string takeWhile (_ == '\t') length
}
