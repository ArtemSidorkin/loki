package loki.language.preprocessing.command

import loki.language.preprocessing.CodeLine
import loki.language.preprocessing.command.CodeBlockReasoner.CODE_BLOCK_INDICATOR_TOKENS
import loki.language.preprocessing.constant.CompilerTokens

import scala.collection.mutable

private[preprocessing] class CodeBlockReasoner(codeLines:collection.Seq[CodeLine])
{
	private val indentationToCodeLineReplacements = mutable.Stack[CodeLine]()

	def apply():collection.Seq[CodeLine] =
	{
		val lastCodeLine = codeLines.filter(!_.isEmpty).foldLeft(new CodeLine)(inferBeginAndEndBetweenCodeLines)

		while (indentationToCodeLineReplacements.nonEmpty)
			lastCodeLine.inferredLines += indentationToCodeLineReplacements.pop()

		codeLines
	}

	def inferBeginAndEndBetweenCodeLines(previousCodeLine:CodeLine, currentCodeLine:CodeLine):CodeLine =
	{
		val currentAndPreviousCodeLineIndentationDifference = currentCodeLine.indentCount - previousCodeLine.indentCount

		if (currentAndPreviousCodeLineIndentationDifference > 0)
			inferBegin(previousCodeLine, currentAndPreviousCodeLineIndentationDifference)
		else if (currentAndPreviousCodeLineIndentationDifference < 0)
			inferEnd(previousCodeLine, currentAndPreviousCodeLineIndentationDifference)

		currentCodeLine
	}

	def inferBegin(previousCodeLine:CodeLine, currentAndPreviousCodeLineIndentationDifference:Int):Unit =
	{
		val previousCodeLineEndsWithCodeBlockIndicatorToken =
			CODE_BLOCK_INDICATOR_TOKENS.exists(previousCodeLine.trimmedRight.endsWith)

		for (_ <- 0 until currentAndPreviousCodeLineIndentationDifference)
		{
			if (previousCodeLineEndsWithCodeBlockIndicatorToken)
			{
				previousCodeLine.inferredLines += new CodeLine(CompilerTokens.LEFT_BRACE)

				indentationToCodeLineReplacements.push(new CodeLine(CompilerTokens.RIGHT_BRACE))
			}

			indentationToCodeLineReplacements.push(new CodeLine())
		}
	}

	def inferEnd(previousCodeLine:CodeLine, currentAndPreviousCodeLineIndentationDifference:Int):Unit =
	{
		for (_ <- 0 until Math.abs(currentAndPreviousCodeLineIndentationDifference))
			previousCodeLine.inferredLines += indentationToCodeLineReplacements.pop()
	}
}

private[preprocessing] object CodeBlockReasoner
{
	final val CODE_BLOCK_INDICATOR_TOKENS:collection.Seq[String] =
		Array(CompilerTokens.ELSE, CompilerTokens.COLON, CompilerTokens.BACKSLASH)

	def apply(codeLines:collection.Seq[CodeLine]):collection.Seq[CodeLine] = new CodeBlockReasoner(codeLines)()
}