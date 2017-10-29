package cloki.language.preprocessing.commands

import cloki.language.preprocessing.consts.CConstCompilerTokens
import cloki.utils.extensions.StringExtensions.StringExtensions

private[preprocessing] object CCommandPreprocessingReplaceTabsToBeginAndEnd extends CCommandPreprocessing
{
	override def apply(code:StringBuilder) =
	{
		val cdLns = code split CConstCompilerTokens.NEW_LINE
		val nwCd = new StringBuilder
		val lstCdLnTbCnt = cdLns.foldLeft(0)((prvsTbCnt, cdLn) =>
		{
			val tbCntInCrntLn = cdLn.tabCount
			val lnWthtTb = cdLn filter CConstCompilerTokens.TAB.!=

			if (tbCntInCrntLn > prvsTbCnt)
				nwCd ++= s"${CConstCompilerTokens.NEW_LINE}${CConstCompilerTokens.BEGIN}" * (tbCntInCrntLn - prvsTbCnt)
			else if (tbCntInCrntLn < prvsTbCnt)
				nwCd ++= s"${CConstCompilerTokens.NEW_LINE}${CConstCompilerTokens.END}" * (prvsTbCnt - tbCntInCrntLn)

			if (nwCd.nonEmpty) nwCd += CConstCompilerTokens.NEW_LINE
			nwCd ++= lnWthtTb
			tbCntInCrntLn
		})
		nwCd ++= s"${CConstCompilerTokens.NEW_LINE}${CConstCompilerTokens.END}" * lstCdLnTbCnt
		code.clear()
		code ++= nwCd
	}
}
