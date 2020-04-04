package loki.endtoend.array

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class ArrayMembersTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("array", "ArrayMembers.test.loki")

		Assertions
			.assertEquals(
				List(
					array(number(1), number(2)),
					array(number(1), number(2)),
					array(number(1), number(2)),
					array(number(1), number(2)),
					array(number(10000), number(100000), number(1000000))
				),
				testValues
			)
	}
}
