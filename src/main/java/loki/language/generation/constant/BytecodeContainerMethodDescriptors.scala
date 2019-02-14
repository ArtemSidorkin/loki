package loki.language.generation.constant

import assembler.methoddescriptor.TypedMethodDescriptor
import loki.runtime.datatype.unit.LUnit

object BytecodeContainerMethodDescriptors
{
	val INIT = TypedMethodDescriptor((classOf[Array[LUnit]] :: Nil) -> None)
}
