package loki.endtoend.algorithm

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class FactorialTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("algorithm", "Factorial.test.loki")

		Assertions.assertEquals(List(number(3628800), number(3628800)), testValues)
	}
}
