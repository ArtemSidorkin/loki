package loki.endtoend.inheritance

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class PolymorphicInheritanceTest extends EndToEndTest
{
	@Test
	def test()
	{
		runTest("inheritance", "PolymorphicInheritance.test.loki")

		Assertions.assertEquals(List(number(100), number(1), number(2), number(3)),	testValues)
	}
}
