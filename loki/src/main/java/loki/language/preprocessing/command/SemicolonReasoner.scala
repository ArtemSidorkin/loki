package loki.language.preprocessing.command

import loki.language.preprocessing.CodeLine
import loki.language.preprocessing.command.SemicolonReasoner.{LEFT_TOKEN_EXCEPTIONS, RIGHT_TOKEN_EXCEPTIONS}
import loki.language.preprocessing.constant.CompilerTokens

private[preprocessing] class SemicolonReasoner(code:collection.Seq[CodeLine])
{
	def apply():collection.Seq[CodeLine] =
	{
		val codeLines = code.filter(!_.isEmpty).flatMap(_.mergeWithInferredLines)

		for (i <- codeLines.indices)
		{
			def leftTokenException = !LEFT_TOKEN_EXCEPTIONS.exists(codeLines(i).cleanedUp.endsWith)
			def rightTokenException = i + 1 >= codeLines.length || !RIGHT_TOKEN_EXCEPTIONS.exists(codeLines(i + 1).cleanedUp.startsWith)

			if (leftTokenException && rightTokenException) codeLines(i).semicolon = true
		}

		code
	}
}

private[preprocessing] object SemicolonReasoner
{
	private val LEFT_TOKEN_EXCEPTIONS =
		Array(
			CompilerTokens.IF,
			CompilerTokens.ELSE,
			CompilerTokens.WHILE,
			CompilerTokens.PLUS,
			CompilerTokens.MINUS,
			CompilerTokens.STAR,
			CompilerTokens.SLASH,
			CompilerTokens.BACKSLASH,
			CompilerTokens.EQUALS_EQUALS,
			CompilerTokens.BANG_EQUALS,
			CompilerTokens.GREATER_THAN_EQUALS,
			CompilerTokens.GREATER_THAN,
			CompilerTokens.LESS_THAN_EQUALS,
			CompilerTokens.LESS_THAN,
			CompilerTokens.AMPERSAND_AMPERSAND,
			CompilerTokens.PIPE_PIPE,
			CompilerTokens.BANG,
			CompilerTokens.AMPERSAND,
			CompilerTokens.PIPE,
			CompilerTokens.EQUALS,
			CompilerTokens.DOT,
			CompilerTokens.COMMA,
			CompilerTokens.DOUBLE_COLON,
			CompilerTokens.COLON,
			CompilerTokens.RIGHT_THIN_ARROW,
			CompilerTokens.RIGHT_THICK_ARROW,
			CompilerTokens.SEMICOLON,
			CompilerTokens.LEFT_PARENTHESIS,
			CompilerTokens.LEFT_BRACKET,
			CompilerTokens.LEFT_BRACE,
			CompilerTokens.ACUTE
		)

	private val RIGHT_TOKEN_EXCEPTIONS =
		Array(
			CompilerTokens.ELSE,
			CompilerTokens.PLUS,
			CompilerTokens.MINUS,
			CompilerTokens.STAR,
			CompilerTokens.SLASH,
			CompilerTokens.EQUALS_EQUALS,
			CompilerTokens.BANG_EQUALS,
			CompilerTokens.GREATER_THAN_EQUALS,
			CompilerTokens.GREATER_THAN,
			CompilerTokens.LESS_THAN_EQUALS,
			CompilerTokens.LESS_THAN,
			CompilerTokens.AMPERSAND_AMPERSAND,
			CompilerTokens.PIPE_PIPE,
			CompilerTokens.AMPERSAND,
			CompilerTokens.PIPE,
			CompilerTokens.EQUALS,
			CompilerTokens.DOT,
			CompilerTokens.COMMA,
			CompilerTokens.DOUBLE_COLON,
			CompilerTokens.COLON,
			CompilerTokens.RIGHT_THIN_ARROW,
			CompilerTokens.RIGHT_THICK_ARROW,
			CompilerTokens.RIGHT_PARENTHESIS,
			CompilerTokens.RIGHT_BRACKET,
			CompilerTokens.LEFT_BRACE,
		)

	def apply(code:collection.Seq[CodeLine]):collection.Seq[CodeLine] = new SemicolonReasoner(code)()
}