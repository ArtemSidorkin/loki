package loki.endtoend.oop

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class DefaultMembersOOPTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("oop", "DefaultMembersOOP.test.loki")

		Assertions
			.assertEquals(
				List(
					number(0), number(0), number(0),
					number(1), number(2), number(3),
					number(1), void, number(3),
					number(10), void, number(3),
					number(10), number(20), number(3)
				),
				testValues
			)
	}
}
