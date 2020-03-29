package loki.endtoend.condition

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class IfElseTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("condition", "IfElse.test.loki")

		Assertions
			.assertEquals(
				List(
					number(1),
					number(4),
					number(5),
					number(8),

					number(9),
					number(10),
					number(14),
					number(15),
					number(19),
					number(20),
					number(21),
					number(22),
					number(27),
					number(28),
				),
				testValues
			)
	}
}
