package cloki.language.preprocessing.commands

import cloki.language.preprocessing.consts.ConstCompilerTokens

import scala.collection.mutable

private[preprocessing] object InferSemicolonsPreprocessingCommand extends PreprocessingCommand
{
	private val IGNORABLE_TOKENS:collection.Set[Char] =
		mutable.HashSet(
			ConstCompilerTokens.TAB,
			ConstCompilerTokens.SPACE
		)

	private val LEFT_TOKEN_EXCEPTIONS =
		Array(
			ConstCompilerTokens.LEFT_THIN_ARROW,
			ConstCompilerTokens.PLUS.toString,
			ConstCompilerTokens.MINUS.toString,
			ConstCompilerTokens.STAR.toString,
			ConstCompilerTokens.SPACE.toString,
			ConstCompilerTokens.BACK_SLASH.toString,
			ConstCompilerTokens.EQUALS.toString,
			ConstCompilerTokens.DOT.toString,
			ConstCompilerTokens.COMA.toString,
			ConstCompilerTokens.COLON.toString,
			ConstCompilerTokens.LEFT_PARENTHESIS.toString,
			ConstCompilerTokens.LEFT_BRACKET.toString,
			ConstCompilerTokens.LEFT_BRACE.toString,
			ConstCompilerTokens.BEGIN.toString
		)

	private val RIGHT_TOKEN_EXCEPTIONS =
		Array(
			ConstCompilerTokens.LEFT_THIN_ARROW,
			ConstCompilerTokens.PLUS.toString,
			ConstCompilerTokens.MINUS.toString,
			ConstCompilerTokens.STAR.toString,
			ConstCompilerTokens.SPACE.toString,
			ConstCompilerTokens.BACK_SLASH.toString,
			ConstCompilerTokens.EQUALS.toString,
			ConstCompilerTokens.COMA.toString,
			ConstCompilerTokens.COLON.toString,
			ConstCompilerTokens.RIGHT_PARENTHESIS.toString,
			ConstCompilerTokens.RIGHT_BRACKET.toString,
			ConstCompilerTokens.RIGHT_BRACE.toString,
			ConstCompilerTokens.ELSE.toString,
			ConstCompilerTokens.BEGIN.toString
		)

	override def apply(code:StringBuilder):Unit =
		if (code.nonEmpty)
		{
			val codeLines = code split ConstCompilerTokens.NEW_LINE
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
				) newCode += ConstCompilerTokens.SEMICOLON

				if (i < codeLines.length - 1) newCode += ConstCompilerTokens.NEW_LINE
			}

			code.clear()
			code ++= newCode
		}

	private def excludeIgnorableTokens(code:String) = code filter (IGNORABLE_TOKENS contains _ unary_!)
}
