package loki.language.generation.constant

import assembler.methoddescriptor.MethodDescriptor
import loki.runtime.context.LUnitContext
import loki.runtime.unit.unit.LUnit

object BytecodeMethodDescriptors
{
	val MODULE_HEIR__METHOD__INIT =
		MethodDescriptor((Nil) -> None)

	def UNIT_HEIR__METHOD__INIT_2 =
		MethodDescriptor((classOf[LUnitContext] :: classOf[Array[LUnit]] :: Nil) -> None)

	val JAVA_OBJECT__METHOD__GET_CLASS = MethodDescriptor(Nil -> Some(classOf[Class[_]]), "getClass")
}
