package loki.endtoend.oop

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class EmbeddedMembersOOPTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("oop", "EmbeddedMembersOOP.test.loki")

		Assertions
			.assertEquals(
				List(
					number(1), number(2),
					void, number(4),
					number(5), void,

					number(7), number(8),
					void, number(10),
					number(11), void,

					number(13), number(14),
					void, number(16),
					number(17), void
				),
				testValues
			)
	}
}
