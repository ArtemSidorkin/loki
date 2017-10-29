package cloki.utils.extensions

object StringExtensions
{
	implicit class CString(string:String)
	{
		def withoutSideLines = (string split '\n').init.tail mkString "\n"

		def tabulate(tabCount:Int, forward:Boolean = true, firstLineAsContinuation:Boolean = false) =
		{
			val strngBldr = new StringBuilder
			val lns = string filter '\r'.!= split '\n'
			val bsTbCnt = if (forward) string.tabCount else lns.last.tabCount

			lns.foldLeft(0)((i, ln) =>
			{
				val nwTbCnt = ln.tabCount - bsTbCnt + tabCount
				val strngWthtTbs = ln takeRight ln.length - ln.tabCount
				strngBldr ++=
				(
					if (i == 0 && firstLineAsContinuation) strngWthtTbs
					else "\t" * nwTbCnt + strngWthtTbs
				)
				if (lns.length > 1) strngBldr += '\n'
				i + 1
			})

			strngBldr.toString
		}

		def tabCount:Int = string.foldLeft(0)((cntClctr, chr) => if (chr == '\t') cntClctr + 1 else return cntClctr)
	}
}
