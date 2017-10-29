package cloki.util.extensions

object StringExtensions
{
	implicit class StringExtensions(string:String)
	{
		def withoutSideLines:String = (string split '\n').init.tail mkString "\n"

		def tabulate(tabCount:Int, forward:Boolean = true, firstLineAsContinuation:Boolean = false):String =
		{
			val stringBuilder = new StringBuilder
			val lines = string filter '\r'.!= split '\n'
			val baseTabCount = if (forward) string.tabCount else lines.last.tabCount

			lines.foldLeft(0)((i, line) =>
			{
				val newTabCount = line.tabCount - baseTabCount + tabCount
				val stringWithoutTabs = line takeRight line.length - line.tabCount
				stringBuilder ++=
				(
					if (i == 0 && firstLineAsContinuation) stringWithoutTabs
					else "\t" * newTabCount + stringWithoutTabs
				)
				if (lines.length > 1) stringBuilder += '\n'
				i + 1
			})

			stringBuilder.toString
		}

		def tabCount:Int =
			string
				.foldLeft(0)((countCollector, character) =>
					if (character == '\t') countCollector + 1 else return countCollector
				)
	}
}
