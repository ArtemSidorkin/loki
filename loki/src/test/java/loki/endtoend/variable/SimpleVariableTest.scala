package loki.endtoend.variable

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class SimpleVariableTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("variable", "SimpleVariable.test.loki")

		Assertions
			.assertEquals(
				List(
					number(1),
					number(2),
					number(3),
					number(1),
					number(1),
					number(2),
					number(2),
					number(2),
					number(3),
					number(3),
					number(3),
					number(3)
				),
				testValues
			)
	}
}
