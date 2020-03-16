package loki.endtoend.algorithm

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class FactorialTest extends EndToEndTest
{
	@Test
	def test()
	{
		runTest("algorithm", "Factorial.test.loki")

		Assertions.assertEquals(number(3628800), testValues.head)
	}
}
