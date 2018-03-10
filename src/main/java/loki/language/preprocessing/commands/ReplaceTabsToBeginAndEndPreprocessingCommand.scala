package loki.language.preprocessing.commands

import loki.language.preprocessing.consts.ConstCompilerTokens
import loki.util.extension.StringExtensions.StringExtensions

private[preprocessing] object ReplaceTabsToBeginAndEndPreprocessingCommand extends PreprocessingCommand
{
	override def apply(code:StringBuilder):Unit =
	{
		val codeLines = code split ConstCompilerTokens.NEW_LINE
		val newCode = new StringBuilder

		val lastCodeLineTabCount =
			codeLines.foldLeft(0)((previousLineTabCount, codeLine) =>
			{
				val tabCountInCurrentLine = codeLine.tabCount
				val lineWithoutTab = codeLine filter ConstCompilerTokens.TAB.!=

				if (tabCountInCurrentLine > previousLineTabCount)
					newCode ++=
						s"${ConstCompilerTokens.NEW_LINE}${ConstCompilerTokens.BEGIN}" *
						(tabCountInCurrentLine - previousLineTabCount)
				else if (tabCountInCurrentLine < previousLineTabCount)
					newCode ++=
						s"${ConstCompilerTokens.NEW_LINE}${ConstCompilerTokens.END}" *
						(previousLineTabCount - tabCountInCurrentLine)

				if (newCode.nonEmpty) newCode += ConstCompilerTokens.NEW_LINE
				newCode ++= lineWithoutTab
				tabCountInCurrentLine
			})

		newCode ++= s"${ConstCompilerTokens.NEW_LINE}${ConstCompilerTokens.END}" * lastCodeLineTabCount
		code.clear()
		code ++= newCode
	}
}
