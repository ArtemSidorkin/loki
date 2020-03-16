package loki.endtoend.function

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class UnitWithoutParametersCallTest extends EndToEndTest
{
	@Test
	def test()
	{
		runTest("function", "UnitWithoutParametersCall.test.loki")

		Assertions.assertEquals(number(100), testValues.head)
	}
}
