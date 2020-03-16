package loki.endtoend.`object`

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class SimpleObjectTest extends EndToEndTest
{
	@Test
	def test()
	{
		runTest("object", "SimpleObject.test.loki")

		Assertions.assertEquals(number(666), testValues.head)
	}
}
