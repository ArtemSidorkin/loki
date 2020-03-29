package loki.endtoend.condition

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class IfTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("condition", "If.test.loki")

		Assertions
			.assertEquals(
				List(
					number(1),

					number(3),
					number(4),

					number(7),

					number(11),
					number(12),
					number(13),
					number(16),

					number(23),
					number(24),
					number(25),
					number(26),
					number(27),
					number(28),
					number(33),
					number(34)
				),
				testValues
			)
	}
}
