package loki.language.preprocessing.command

import loki.language.preprocessing.CodeLine
import loki.language.preprocessing.constant.CompilerTokens

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.language.postfixOps

private[preprocessing] object InferSemicolonsPreprocessingCommand
{
	private val IGNORABLE_TOKENS:collection.Set[Char] =
		mutable.HashSet(
			CompilerTokens.TAB,
			CompilerTokens.SPACE
		)

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

	def apply(code:collection.Seq[CodeLine]):collection.Seq[CodeLine] =
	{
		val codeLines = ArrayBuffer[CodeLine]()

		code.filter(!_.ignore).foreach(cl =>
		{
			codeLines += cl

			cl.additionalLines.foreach(al => codeLines += al)
		})

		for (i <- codeLines.indices)
		{
			val currentCodeLineWithoutIgnorableTokens = excludeIgnorableTokens(codeLines(i).trimmed)
			val nextCodeLineWithoutIgnorableTokens =
				if (i + 1 < codeLines.length) Some(excludeIgnorableTokens(codeLines(i + 1).trimmed)) else None

			if
			(
				(LEFT_TOKEN_EXCEPTIONS exists currentCodeLineWithoutIgnorableTokens.endsWith unary_!) &&
				(
					RIGHT_TOKEN_EXCEPTIONS
						exists (rghtTknExcptn =>
							nextCodeLineWithoutIgnorableTokens exists (_ startsWith rghtTknExcptn)
						)
						unary_!
				)
			) codeLines(i).semicolon = true
		}

		code
	}

	private def excludeIgnorableTokens(code:String) = code filter (IGNORABLE_TOKENS contains _ unary_!)
}
