package cloki.language.preprocessing.commands

import cloki.language.preprocessing.consts.CConstCompilerTokens

import scala.collection.mutable

private[preprocessing] object CCommandPreprocessingRemoveIgnorableCharacters extends CCommandPreprocessing
{
	private val IGNORABLE_TOKENS:collection.Set[Char] = mutable.HashSet(
		CConstCompilerTokens.NEW_LINE,
		CConstCompilerTokens.NEW_LINE_CARET,
		CConstCompilerTokens.TAB,
		CConstCompilerTokens.SPACE
	)

	override def apply(code:StringBuilder) =
	{
		val cdLns = code split CConstCompilerTokens.NEW_LINE
		val nwCd = new StringBuilder
		cdLns.foldLeft(0)((i, cdLn) =>
		{
			if (cdLn exists (IGNORABLE_TOKENS contains (_) unary_!))
			{
				val ignrblTknsCnt = (cdLn.reverse takeWhile IGNORABLE_TOKENS.contains length)
				nwCd ++= cdLn take cdLn.length - ignrblTknsCnt
				if (i < cdLns.length - 1) nwCd += CConstCompilerTokens.NEW_LINE
			}
			i + 1
		})
		code.clear()
		code ++= nwCd
	}
}
