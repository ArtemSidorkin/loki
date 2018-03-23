package loki.language.preprocessing.command

import loki.language.preprocessing.constant.CompilerTokens
import loki.util.extension.StringExtension.StringExtension

private[preprocessing] object ReplaceTabsToBeginAndEndPreprocessingCommand extends PreprocessingCommand
{
	override def apply(code:StringBuilder):Unit =
	{
		val codeLines = code split CompilerTokens.NEW_LINE
		val newCode = new StringBuilder

		val lastCodeLineTabCount =
			codeLines.foldLeft(0)((previousLineTabCount, codeLine) =>
			{
				val tabCountInCurrentLine = codeLine.tabCount
				val lineWithoutTab = codeLine filter CompilerTokens.TAB.!=

				if (tabCountInCurrentLine > previousLineTabCount)
					newCode ++=
						s"${CompilerTokens.NEW_LINE}${CompilerTokens.BEGIN}" *
						(tabCountInCurrentLine - previousLineTabCount)
				else if (tabCountInCurrentLine < previousLineTabCount)
					newCode ++=
						s"${CompilerTokens.NEW_LINE}${CompilerTokens.END}" *
						(previousLineTabCount - tabCountInCurrentLine)

				if (newCode.nonEmpty) newCode += CompilerTokens.NEW_LINE
				newCode ++= lineWithoutTab
				tabCountInCurrentLine
			})

		newCode ++= s"${CompilerTokens.NEW_LINE}${CompilerTokens.END}" * lastCodeLineTabCount
		code.clear()
		code ++= newCode
	}
}