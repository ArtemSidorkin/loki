package loki.endtoend.map

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class FunctionMapTest extends EndToEndTest
{
	@Test
	def test()
	{
		runTest("map", "FunctionMap.test.loki")

		Assertions
			.assertEquals(List(number(1), number(1), number(1), number(1), number(3), number(1), number(2)), testValues)
	}
}
