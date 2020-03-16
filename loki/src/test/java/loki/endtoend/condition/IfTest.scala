package loki.endtoend.condition

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class IfTest extends EndToEndTest
{
	@Test
	def test()
	{
		runTest("condition", "If.test.loki")

		Assertions
			.assertEquals(
				List(number(1), number(0), number(2), number(0), number(1), number(0), number(0), number(0)), testValues
			)
	}
}
