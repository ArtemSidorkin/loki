package loki.endtoend.map

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class CreationMapTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("map", "CreationMap.test.loki")

		Assertions
			.assertEquals(
				List(
					map(),
					map(string("a"), number(1)),
					map(string("a"), number(1), string("b"), number(2)),
					map(string("a"), number(1), string("b"), number(2), string("c"), number(3))
				),
				testValues
			)
	}
}
