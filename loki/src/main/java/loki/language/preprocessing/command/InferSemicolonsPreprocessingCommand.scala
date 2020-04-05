package loki.language.preprocessing.command

import loki.language.preprocessing.constant.CompilerTokens

import scala.collection.mutable
import scala.language.postfixOps

private[preprocessing] object InferSemicolonsPreprocessingCommand extends PreprocessingCommand
{
	private val IGNORABLE_TOKENS:collection.Set[Char] =
		mutable.HashSet(
			CompilerTokens.TAB,
			CompilerTokens.SPACE
		)

	private val LEFT_TOKEN_EXCEPTIONS =
		Array(
			CompilerTokens.PLUS.toString,
			CompilerTokens.MINUS.toString,
			CompilerTokens.STAR.toString,
			CompilerTokens.SLASH.toString,
			CompilerTokens.BACKSLASH.toString,
			CompilerTokens.EQUALS.toString,
			CompilerTokens.DOT.toString,
			CompilerTokens.COMMA.toString,
			CompilerTokens.COLON.toString,
			CompilerTokens.DOUBLE_COLON,
			CompilerTokens.RIGHT_THIN_ARROW,
			CompilerTokens.RIGHT_THICK_ARROW,
			CompilerTokens.LEFT_PARENTHESIS.toString,
			CompilerTokens.LEFT_BRACKET.toString,
			CompilerTokens.LEFT_BRACE.toString
		)

	private val RIGHT_TOKEN_EXCEPTIONS =
		Array(
			CompilerTokens.DOUBLE_COLON,
			CompilerTokens.PLUS.toString,
			CompilerTokens.MINUS.toString,
			CompilerTokens.STAR.toString,
			CompilerTokens.SLASH.toString,
			CompilerTokens.BACKSLASH.toString,
			CompilerTokens.EQUALS.toString,
			CompilerTokens.COMMA.toString,
			CompilerTokens.COLON.toString,
			CompilerTokens.DOUBLE_COLON,
			CompilerTokens.RIGHT_THICK_ARROW,
			CompilerTokens.RIGHT_PARENTHESIS.toString,
			CompilerTokens.RIGHT_BRACKET.toString,
			CompilerTokens.ELSE.toString,
			CompilerTokens.LEFT_BRACE.toString,
			CompilerTokens.DOT.toString
	)

	override def apply(code:StringBuilder):Unit =
		if (code.nonEmpty)
		{
			val codeLines = code.toString split CompilerTokens.NEW_LINE
			val newCode = new StringBuilder

			for (i <- codeLines.indices)
			{
				newCode ++= codeLines(i)
				val currentCodeLineWithoutIgnorableTokens = excludeIgnorableTokens(codeLines(i))
				val nextCodeLineWithoutIgnorableTokens =
					if (i + 1 < codeLines.length) Some(excludeIgnorableTokens(codeLines(i + 1))) else None

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
				) newCode ++= CompilerTokens.SEMICOLON

				if (i < codeLines.length - 1) newCode += CompilerTokens.NEW_LINE
			}

			code.clear()
			code ++= newCode
		}

	private def excludeIgnorableTokens(code:String) = code filter (IGNORABLE_TOKENS contains _ unary_!)
}
