package loki.endtoend.map

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.Test

private[endtoend] class FormattingMapTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("map", "FormattingMap.test.loki")
	}
}
