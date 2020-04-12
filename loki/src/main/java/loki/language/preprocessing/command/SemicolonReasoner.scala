package loki.language.preprocessing.command

import loki.language.preprocessing.CodeLine
import loki.language.preprocessing.command.SemicolonReasoner.{CURRENT_LINE_CONTINUE_TOKENS, NEXT_LINE_CONTINUE_TOKENS}
import loki.language.preprocessing.constant.FixedTokens

private[preprocessing] class SemicolonReasoner(codeLines:collection.Seq[CodeLine])
{
	def apply():collection.Seq[CodeLine] =
	{
		val nonEmptyCodeLinesMergedWithInferredCodeLines =
			codeLines.filter(!_.isEmpty).flatMap(_.mergedWithInferredLines)

		for (i <- nonEmptyCodeLinesMergedWithInferredCodeLines.indices)
		{
			def currentLineContinuePresent =
				CURRENT_LINE_CONTINUE_TOKENS.exists(nonEmptyCodeLinesMergedWithInferredCodeLines(i).cleanedUp.endsWith)

			def nextLineContinuePresent =
				i + 1 < nonEmptyCodeLinesMergedWithInferredCodeLines.length &&
					NEXT_LINE_CONTINUE_TOKENS
						.exists(nonEmptyCodeLinesMergedWithInferredCodeLines(i + 1).cleanedUp.startsWith)

			if (!currentLineContinuePresent && !nextLineContinuePresent)
				nonEmptyCodeLinesMergedWithInferredCodeLines(i).semicolon = true
		}

		codeLines
	}
}

private[preprocessing] object SemicolonReasoner
{
	private val CURRENT_LINE_CONTINUE_TOKENS =
		Array(
			FixedTokens.IF,
			FixedTokens.ELSE,
			FixedTokens.WHILE,
			FixedTokens.PLUS,
			FixedTokens.MINUS,
			FixedTokens.STAR,
			FixedTokens.SLASH,
			FixedTokens.BACKSLASH,
			FixedTokens.EQUALS_EQUALS,
			FixedTokens.BANG_EQUALS,
			FixedTokens.GREATER_THAN_EQUALS,
			FixedTokens.GREATER_THAN,
			FixedTokens.LESS_THAN_EQUALS,
			FixedTokens.LESS_THAN,
			FixedTokens.AMPERSAND_AMPERSAND,
			FixedTokens.PIPE_PIPE,
			FixedTokens.BANG,
			FixedTokens.AMPERSAND,
			FixedTokens.PIPE,
			FixedTokens.EQUALS,
			FixedTokens.DOT,
			FixedTokens.COMMA,
			FixedTokens.DOUBLE_COLON,
			FixedTokens.COLON,
			FixedTokens.RIGHT_THIN_ARROW,
			FixedTokens.RIGHT_THICK_ARROW,
			FixedTokens.SEMICOLON,
			FixedTokens.LEFT_PARENTHESIS,
			FixedTokens.LEFT_BRACKET,
			FixedTokens.LEFT_BRACE,
			FixedTokens.ACUTE
		)

	private val NEXT_LINE_CONTINUE_TOKENS =
		Array(
			FixedTokens.ELSE,
			FixedTokens.PLUS,
			FixedTokens.MINUS,
			FixedTokens.STAR,
			FixedTokens.SLASH,
			FixedTokens.EQUALS_EQUALS,
			FixedTokens.BANG_EQUALS,
			FixedTokens.GREATER_THAN_EQUALS,
			FixedTokens.GREATER_THAN,
			FixedTokens.LESS_THAN_EQUALS,
			FixedTokens.LESS_THAN,
			FixedTokens.AMPERSAND_AMPERSAND,
			FixedTokens.PIPE_PIPE,
			FixedTokens.AMPERSAND,
			FixedTokens.PIPE,
			FixedTokens.EQUALS,
			FixedTokens.DOT,
			FixedTokens.COMMA,
			FixedTokens.DOUBLE_COLON,
			FixedTokens.COLON,
			FixedTokens.RIGHT_THIN_ARROW,
			FixedTokens.RIGHT_THICK_ARROW,
			FixedTokens.RIGHT_PARENTHESIS,
			FixedTokens.RIGHT_BRACKET,
			FixedTokens.LEFT_BRACE,
		)

	def apply(code:collection.Seq[CodeLine]):collection.Seq[CodeLine] = new SemicolonReasoner(code)()
}