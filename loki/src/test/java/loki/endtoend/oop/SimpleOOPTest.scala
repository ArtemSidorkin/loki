package loki.endtoend.oop

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class SimpleOOPTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("oop", "SimpleOOP.test.loki")

		Assertions
			.assertEquals(
				List(
					number(11), number(22),

					number(0), number(5), number(10)
				),
				testValues
			)
	}
}
