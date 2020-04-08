package loki.language.preprocessing.command

import loki.language.preprocessing.CodeLine
import loki.language.preprocessing.command.CodeBlockInference.BLOCK_INDICATOR_TOKENS
import loki.language.preprocessing.constant.CompilerTokens

import scala.collection.mutable

private[preprocessing] object CodeBlockInference
{
	final val BLOCK_INDICATOR_TOKENS:collection.Seq[String] =
		Array(CompilerTokens.ELSE, CompilerTokens.COLON, CompilerTokens.BACKSLASH)

	def apply(codeLines:collection.Seq[CodeLine]):collection.Seq[CodeLine] = new CodeBlockInference(codeLines)()
}

private[preprocessing] class CodeBlockInference(codeLines:collection.Seq[CodeLine])
{
	private val indentationToCodeLineReplacements = mutable.Stack[CodeLine]()

	def apply():collection.Seq[CodeLine] =
	{
		val lastCodeLine = codeLines.filter(!_.isEmpty).foldLeft(new CodeLine)(inferCodeBlockBetweenLines)

		while (indentationToCodeLineReplacements.nonEmpty)
			lastCodeLine.additionalLines += indentationToCodeLineReplacements.pop()

		codeLines
	}

	def inferCodeBlockBetweenLines(previousCodeLine:CodeLine, currentCodeLine:CodeLine):CodeLine =
	{
		val currentAndPreviousCodeLineIndentationDifference =
			currentCodeLine.indentCount - previousCodeLine.indentCount

		if (currentAndPreviousCodeLineIndentationDifference > 0)
			inferBegin(previousCodeLine, currentAndPreviousCodeLineIndentationDifference)
		else if (currentAndPreviousCodeLineIndentationDifference < 0)
			inferEnd(previousCodeLine, currentAndPreviousCodeLineIndentationDifference)

		currentCodeLine
	}

	def inferBegin(previousCodeLine:CodeLine, currentAndPreviousCodeLineIndentationDifference:Int):Unit =
	{
		val beginDetected = BLOCK_INDICATOR_TOKENS.exists(previousCodeLine.trimmed.endsWith)

		for (_ <- 0 until currentAndPreviousCodeLineIndentationDifference)
		{
			if (beginDetected) previousCodeLine.additionalLines += new CodeLine(CompilerTokens.LEFT_BRACE)

			indentationToCodeLineReplacements.push(new CodeLine(if (beginDetected) CompilerTokens.RIGHT_BRACE else ""))
		}
	}

	def inferEnd(previousCodeLine:CodeLine, currentAndPreviousCodeLineIndentationDifference:Int):Unit =
	{
		for (_ <- 0 until Math.abs(currentAndPreviousCodeLineIndentationDifference))
			previousCodeLine.additionalLines += indentationToCodeLineReplacements.pop()
	}
}
