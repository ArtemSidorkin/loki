package loki.endtoend.arithmetic

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class SimpleArithmeticTest extends EndToEndTest
{
	@Test
	def test()
	{
		runTest("arithmetic", "SimpleArithmetic.test.loki")

		Assertions
			.assertEquals(
				List(
					number(30),
					number(60),
					number(100),
					number(10),
					number(0),
					number(-40),
					number(200),
					number(6000),
					number(240000),
					number(2),
					number(0.15),
					number(0.00375),
					number(-3)
				),
				testValues
			)
	}
}
