package loki.language.preprocessing.command

import loki.language.preprocessing.constant.CompilerTokens

import scala.collection.mutable
import scala.language.postfixOps

private[preprocessing] object ReplaceTabsToBeginAndEndPreprocessingCommand extends PreprocessingCommand
{
	override def apply(code:StringBuilder):Unit =
	{
		val tabStack = mutable.Stack[Int]()

		val codeLines = code.toString.split(CompilerTokens.NEW_LINE)
		val newCode = new StringBuilder

		val lastCodeLine =
			codeLines.foldLeft("")((previousLine, codeLine) =>
			{
				val previousLineTabCount = countTabsInCodeLine(previousLine)

				val tabCountInCurrentLine = countTabsInCodeLine(codeLine)
				val lineWithoutTab = codeLine filter CompilerTokens.TAB.!=

				if (tabCountInCurrentLine > previousLineTabCount)
				{
					if (previousLine.endsWith(":") || previousLine.endsWith("else") || previousLine.endsWith("\\"))
					{
						for (_ <- 0 until tabCountInCurrentLine - previousLineTabCount) tabStack.push(1)

						newCode ++=
							s"${CompilerTokens.NEW_LINE}${CompilerTokens.LEFT_BRACE}" *
								(tabCountInCurrentLine - previousLineTabCount)
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
						if (tabStack.pop() == 1) newCode ++= s"${CompilerTokens.NEW_LINE}${CompilerTokens.RIGHT_BRACE}"
					}
				}

				if (newCode.nonEmpty) newCode += CompilerTokens.NEW_LINE
				newCode ++= lineWithoutTab

				codeLine
			})

		val lastCodeLineTabCount = countTabsInCodeLine(lastCodeLine)

		newCode ++= s"${CompilerTokens.NEW_LINE}${CompilerTokens.RIGHT_BRACE}" * lastCodeLineTabCount
		code.clear()
		code ++= newCode
	}

	private def countTabsInCodeLine(string:String):Int = string takeWhile (_ == '\t') length
}
