package loki.language.preprocessing.command

import loki.language.preprocessing.constant.CompilerTokens

import scala.collection.mutable

private[preprocessing] object InferSemicolonsPreprocessingCommand extends PreprocessingCommand
{
	private val IGNORABLE_TOKENS:collection.Set[Char] =
		mutable.HashSet(
			CompilerTokens.TAB,
			CompilerTokens.SPACE
		)

	private val LEFT_TOKEN_EXCEPTIONS =
		Array(
			CompilerTokens.LEFT_THIN_ARROW,
			CompilerTokens.PLUS.toString,
			CompilerTokens.MINUS.toString,
			CompilerTokens.STAR.toString,
			CompilerTokens.SPACE.toString,
			CompilerTokens.BACK_SLASH.toString,
			CompilerTokens.EQUALS.toString,
			CompilerTokens.DOT.toString,
			CompilerTokens.COMA.toString,
			CompilerTokens.COLON.toString,
			CompilerTokens.LEFT_PARENTHESIS.toString,
			CompilerTokens.LEFT_BRACKET.toString,
			CompilerTokens.LEFT_BRACE.toString,
			CompilerTokens.BEGIN.toString
		)

	private val RIGHT_TOKEN_EXCEPTIONS =
		Array(
			CompilerTokens.LEFT_THIN_ARROW,
			CompilerTokens.PLUS.toString,
			CompilerTokens.MINUS.toString,
			CompilerTokens.STAR.toString,
			CompilerTokens.SPACE.toString,
			CompilerTokens.BACK_SLASH.toString,
			CompilerTokens.EQUALS.toString,
			CompilerTokens.COMA.toString,
			CompilerTokens.COLON.toString,
			CompilerTokens.RIGHT_PARENTHESIS.toString,
			CompilerTokens.RIGHT_BRACKET.toString,
			CompilerTokens.RIGHT_BRACE.toString,
			CompilerTokens.ELSE.toString,
			CompilerTokens.BEGIN.toString
		)

	override def apply(code:StringBuilder):Unit =
		if (code.nonEmpty)
		{
			val codeLines = code split CompilerTokens.NEW_LINE
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
				) newCode += CompilerTokens.SEMICOLON

				if (i < codeLines.length - 1) newCode += CompilerTokens.NEW_LINE
			}

			code.clear()
			code ++= newCode
		}

	private def excludeIgnorableTokens(code:String) = code filter (IGNORABLE_TOKENS contains _ unary_!)
}
