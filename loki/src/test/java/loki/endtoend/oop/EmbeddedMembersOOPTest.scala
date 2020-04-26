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
					number(17), void,


					number(19), number(20),
					void, number(22),
					number(23), void,

					number(25), number(26),
					void, number(28),
					number(29), void,

					number(31), number(32),
					void, number(34),
					number(35), void
				),
				testValues
			)
	}
}
