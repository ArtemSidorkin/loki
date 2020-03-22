package loki.language.generation.constant

import assembler.methoddescriptor.TypedMethodDescriptor
import loki.runtime.context.LUnitContext
import loki.runtime.unit.unit.LUnit

object BytecodeMethodDescriptors
{
	val MODULE_HEIR__METHOD__INIT =
		TypedMethodDescriptor((Nil) -> None)

	def UNIT_HEIR__METHOD__INIT_2 =
		TypedMethodDescriptor(
			(
				classOf[LUnitContext] ::
				classOf[Array[LUnit]] ::
				Nil
			) -> None
		)

	val JAVA_OBJECT__METHOD__GET_CLASS = TypedMethodDescriptor(Nil -> Some(classOf[Class[_]]))
}
