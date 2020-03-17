package loki.endtoend.array

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class ArrayCreationTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("array", "ArrayCreation.test.loki")

		Assertions
			.assertEquals(
				List(array(), array(number(1)), array(number(1), number(2)), array(number(1), number(2), number(3))),
				testValues
			)
	}
}
