package loki.language.generation.bytecode.constant

import assembler.methoddescriptor.TypedMethodDescriptor
import loki.runtime.datatype.LUnit

private[bytecode] object BytecodeContainerMethodDescriptors
{
	val INIT = TypedMethodDescriptor((classOf[Array[LUnit]] :: Nil) -> None)
}
