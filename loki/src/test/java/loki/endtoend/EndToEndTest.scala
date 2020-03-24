package loki.endtoend

import java.io.File

import loki.Executor
import loki.runtime.unit.data.bool.LBoolean
import loki.runtime.unit.data.number.LNumber
import loki.runtime.unit.data.singleton.LVoid
import loki.runtime.unit.data.{LArray, LMap, LString}
import loki.runtime.unit.function.LTest
import loki.runtime.unit.unit.LUnit
import org.junit.jupiter.api.BeforeEach

import scala.collection.mutable
import scala.jdk.CollectionConverters._

private[endtoend] abstract class EndToEndTest
{
	import EndToEndTest._

	@BeforeEach
	def clear():Unit = LTest.clear()

	protected def testValues:mutable.Seq[LUnit] = LTest.getValues.asScala

	protected def runTest(testSubfolder:String, testFileName:String):Unit =
	{
		Executor(s"$TEST_FOLDER_PATHNAME/$testSubfolder/$testFileName")
	}

	protected def void:LVoid = LVoid.DESCRIPTOR.getInstance
	protected def boolean(value:Boolean) = LBoolean.valueOf(value)
	protected def number(value:Double) = new LNumber(value)
	protected def string(value:String) = new LString(value)
	protected def array(values:LUnit*) = new LArray(values.toArray)
	protected def map(values:LUnit*) = new LMap(values.toArray)
}

object EndToEndTest
{
	private final val TEST_FOLDER_PATHNAME:String = "src/test/resources/tests"
}