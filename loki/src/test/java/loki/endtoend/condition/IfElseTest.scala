package loki.endtoend.condition

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class IfElseTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("condition", "IfElse.test.loki")

		Assertions.assertEquals(List(number(1), number(-1)), testValues)
	}
}
