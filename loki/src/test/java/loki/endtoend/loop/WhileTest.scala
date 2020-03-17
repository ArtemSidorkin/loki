package loki.endtoend.loop

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class WhileTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("loop", "While.test.loki")

		Assertions.assertEquals(List(void, void, number(4950)), testValues)
	}
}
