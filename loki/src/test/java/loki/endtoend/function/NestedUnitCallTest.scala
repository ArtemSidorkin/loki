package loki.endtoend.function

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class NestedUnitCallTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("function", "NestedUnitCall.test.loki")

		Assertions.assertEquals(number(3), testValues.head)
	}
}
