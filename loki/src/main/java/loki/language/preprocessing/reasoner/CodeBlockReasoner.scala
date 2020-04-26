package loki.language.preprocessing.reasoner

import loki.language.preprocessing.CodeLine
import loki.language.preprocessing.constant.FixedTokens
import loki.language.preprocessing.reasoner.CodeBlockReasoner.CODE_BLOCK_INDICATOR_TOKENS

import scala.collection.mutable

private[preprocessing] class CodeBlockReasoner(codeLines:collection.Seq[CodeLine]) extends Reasoner
{
	private val indentationReplacementStack = mutable.Stack[CodeLine]()

	def apply():collection.Seq[CodeLine] =
	{
		val lastCodeLine = codeLines.filter(!_.isEmpty).foldLeft(new CodeLine)(inferBeginAndEndBetweenCodeLines)

		while (indentationReplacementStack.nonEmpty) replaceIndent(lastCodeLine)

		codeLines
	}

	private def inferBeginAndEndBetweenCodeLines(previousCodeLine:CodeLine, currentCodeLine:CodeLine):CodeLine =
	{
		val currentAndPreviousCodeLineIndentationDifference = currentCodeLine.indentCount - previousCodeLine.indentCount

		if (currentAndPreviousCodeLineIndentationDifference > 0)
			inferBegin(previousCodeLine, currentAndPreviousCodeLineIndentationDifference)
		else if (currentAndPreviousCodeLineIndentationDifference < 0)
			inferEnd(previousCodeLine, Math.abs(currentAndPreviousCodeLineIndentationDifference))

		currentCodeLine
	}

	private def inferBegin(previousCodeLine:CodeLine, currentAndPreviousCodeLineIndentationDifference:Int):Unit =
	{
		val previousCodeLineEndsWithCodeBlockIndicatorToken =
			CODE_BLOCK_INDICATOR_TOKENS.exists(previousCodeLine.trimmedRight.endsWith)

		for (_ <- 0 until currentAndPreviousCodeLineIndentationDifference)
			if (previousCodeLineEndsWithCodeBlockIndicatorToken)
			{
				previousCodeLine.inferredLines += new CodeLine(FixedTokens.LEFT_BRACE)

				indentationReplacementStack.push(new CodeLine(FixedTokens.RIGHT_BRACE))
			}
			else indentationReplacementStack.push(new CodeLine)
	}

	private def inferEnd(previousCodeLine:CodeLine, currentAndPreviousCodeLineIndentationDifference:Int):Unit =
		for (_ <- 0 until currentAndPreviousCodeLineIndentationDifference) replaceIndent(previousCodeLine)

	private def replaceIndent(codeLine:CodeLine):Unit =
	{
		val indentReplacement = indentationReplacementStack.pop()

		if (indentReplacement.nonEmpty) codeLine.inferredLines += indentReplacement
	}
}

private[preprocessing] object CodeBlockReasoner
{
	private final val CODE_BLOCK_INDICATOR_TOKENS:collection.Seq[String] =
		Array(FixedTokens.ELSE, FixedTokens.COLON, FixedTokens.BACKSLASH)

	def apply(codeLines:collection.Seq[CodeLine]):collection.Seq[CodeLine] = new CodeBlockReasoner(codeLines)()
}