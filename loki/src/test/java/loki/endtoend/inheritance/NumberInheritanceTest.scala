package loki.endtoend.inheritance

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class NumberInheritanceTest extends EndToEndTest
{
	@Test
	def test()
	{
		runTest("inheritance", "NumberInheritance.test.loki")

		Assertions.assertEquals(List(number(3), number(3), number(3)), testValues)
	}
}
