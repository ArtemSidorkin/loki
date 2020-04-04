package loki.endtoend.array

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class ArrayFormattingTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("array", "ArrayFormatting.test.loki")
	}
}
