package loki.endtoend.inheritance

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.{Assertions, Test}

private[endtoend] class DefaultConstructorInheritanceTest extends EndToEndTest
{
	@Test
	def test():Unit =
	{
		runTest("inheritance", "DefaultConstructorInheritance.test.loki")

		Assertions.assertEquals(List(number(30), number(30)), testValues)
	}
}
