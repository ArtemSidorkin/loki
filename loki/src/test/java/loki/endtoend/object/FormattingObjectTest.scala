package loki.endtoend.`object`

import loki.endtoend.EndToEndTest
import org.junit.jupiter.api.Test

private[endtoend] class FormattingObjectTest extends EndToEndTest
{
	@Test
	def test()
	{
		runTest("object", "FormattingObject.test.loki")
	}
}
