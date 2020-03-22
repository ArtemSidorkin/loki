package loki.language.generation.constant

import assembler.methoddescriptor.MethodDescriptor
import loki.runtime.unit.unit.LUnit

object BytecodeContainerMethodDescriptors
{
	val INIT = MethodDescriptor((classOf[Array[LUnit]] :: Nil) -> None)
}
