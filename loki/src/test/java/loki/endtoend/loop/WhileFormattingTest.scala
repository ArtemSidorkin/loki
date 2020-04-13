package loki.endtoend.loop

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class WhileFormattingTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("loop", "WhileFormatting.test.loki")
	}
}
