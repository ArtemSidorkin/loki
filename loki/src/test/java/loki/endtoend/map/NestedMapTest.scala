package loki.endtoend.map

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class NestedMapTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("map", "NestedMap.test.loki")

		Assertions
			.assertEquals(
				List(
					map(string("map1level1"), map()),
					map(string("map1level1"), map(string("map1level2"), map())),
					map(string("map1level1"), map(), string("map2level1"), map()),
					map(
						string("map1level1"),
						map(string("map1level2"), map()),
						string("map2level1"),
						map(string("map2level2"), map())
					)
				),
				testValues
			)
	}
}
