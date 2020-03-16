package loki.endtoend.algorithm

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class LinkedListTest extends EndToEndTest
{
	@Test
	def test()
	{
		runTest("algorithm", "LinkedList.test.loki")

		Assertions
			.assertEquals(
				List(number(0), number(2), number(10), number(20), number(30), number(30), number(1)),
				testValues
			)
	}
}
