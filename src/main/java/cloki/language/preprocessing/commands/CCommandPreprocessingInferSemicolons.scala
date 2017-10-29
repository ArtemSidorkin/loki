package cloki.language.preprocessing.commands

import cloki.language.preprocessing.consts.CConstCompilerTokens

import scala.collection.mutable

private[preprocessing] object CCommandPreprocessingInferSemicolons extends CCommandPreprocessing
{
	private val IGNORABLE_TOKENS:collection.Set[Char] = mutable.HashSet(
		CConstCompilerTokens.TAB,
		CConstCompilerTokens.SPACE
	)

	private val LEFT_TOKEN_EXCEPTIONS = Array(
		CConstCompilerTokens.LEFT_THIN_ARROW,
		CConstCompilerTokens.PLUS.toString,
		CConstCompilerTokens.MINUS.toString,
		CConstCompilerTokens.STAR.toString,
		CConstCompilerTokens.SPACE.toString,
		CConstCompilerTokens.BACK_SLASH.toString,
		CConstCompilerTokens.EQUALS.toString,
		CConstCompilerTokens.DOT.toString,
		CConstCompilerTokens.COMA.toString,
		CConstCompilerTokens.COLON.toString,
		CConstCompilerTokens.LEFT_PARENTHESIS.toString,
		CConstCompilerTokens.LEFT_BRACKET.toString,
		CConstCompilerTokens.BEGIN.toString
	)

	private val RIGHT_TOKEN_EXCEPTIONS = Array(
		CConstCompilerTokens.LEFT_THIN_ARROW,
		CConstCompilerTokens.PLUS.toString,
		CConstCompilerTokens.MINUS.toString,
		CConstCompilerTokens.STAR.toString,
		CConstCompilerTokens.SPACE.toString,
		CConstCompilerTokens.BACK_SLASH.toString,
		CConstCompilerTokens.EQUALS.toString,
		CConstCompilerTokens.COMA.toString,
		CConstCompilerTokens.COLON.toString,
		CConstCompilerTokens.RIGHT_PARENTHESIS.toString,
		CConstCompilerTokens.RIGHT_BRACKET.toString,
		CConstCompilerTokens.ELSE.toString,
		CConstCompilerTokens.BEGIN.toString
	)

	override def apply(code:StringBuilder) = if (code.nonEmpty)
	{
		val cdLns = code split CConstCompilerTokens.NEW_LINE
		val nwCd = new StringBuilder
		for (i <- cdLns.indices)
		{
			nwCd ++= cdLns(i)
			val crntCdLnWthtIgnrblTkns = excludeIgnorableTokens(cdLns(i))
			val nxtCdLnWthtIgnrblTkns = if (i + 1 < cdLns.length) Some(excludeIgnorableTokens(cdLns(i + 1))) else None

			if
			(
				(LEFT_TOKEN_EXCEPTIONS exists crntCdLnWthtIgnrblTkns.endsWith unary_!) &&
				(
					RIGHT_TOKEN_EXCEPTIONS exists (rghtTknExcptn =>
						nxtCdLnWthtIgnrblTkns exists (_ startsWith rghtTknExcptn)
					) unary_!
				)
			) nwCd += CConstCompilerTokens.SEMICOLON

			if (i < cdLns.length - 1) nwCd += CConstCompilerTokens.NEW_LINE
		}
		code.clear()
		code ++= nwCd
	}

	private def excludeIgnorableTokens(code:String) = code filter (IGNORABLE_TOKENS contains(_) unary_!)
}
