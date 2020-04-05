package loki.language.preprocessing.command

import loki.language.preprocessing.constant.CompilerTokens

import scala.language.postfixOps

private[preprocessing] object ReplaceTabsToBeginAndEndPreprocessingCommand extends PreprocessingCommand
{
	override def apply(code:StringBuilder):Unit =
	{
		val codeLines = code.toString split CompilerTokens.NEW_LINE
		val newCode = new StringBuilder

		val lastCodeLineTabCount =
			codeLines.foldLeft(0)((previousLineTabCount, codeLine) =>
			{
				val tabCountInCurrentLine = countTabsInCodeLine(codeLine)
				val lineWithoutTab = codeLine filter CompilerTokens.TAB.!=

				if (tabCountInCurrentLine > previousLineTabCount)
					newCode ++=
						s"${CompilerTokens.NEW_LINE}${CompilerTokens.LEFT_BRACE}" *
						(tabCountInCurrentLine - previousLineTabCount)
				else if (tabCountInCurrentLine < previousLineTabCount)
					newCode ++=
						s"${CompilerTokens.NEW_LINE}${CompilerTokens.RIGHT_BRACE}" *
						(previousLineTabCount - tabCountInCurrentLine)

				if (newCode.nonEmpty) newCode += CompilerTokens.NEW_LINE
				newCode ++= lineWithoutTab
				tabCountInCurrentLine
			})

		newCode ++= s"${CompilerTokens.NEW_LINE}${CompilerTokens.RIGHT_BRACE}" * lastCodeLineTabCount
		code.clear()
		code ++= newCode
	}

	private def countTabsInCodeLine(string:String):Int = string takeWhile (_ == '\t') length
}
