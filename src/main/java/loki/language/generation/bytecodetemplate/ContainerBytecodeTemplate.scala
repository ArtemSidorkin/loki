package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import loki.language.generation.constant.BytecodeContainerMethodDescriptors
import loki.runtime.datatype.unit.LUnit

object ContainerBytecodeTemplate
{
	implicit class Template(method:MethodBuilder)
	{
		def invokeInitContainer(containerClass:Class[_ <: LUnit]):MethodBuilder =
			method invokeinit (containerClass, BytecodeContainerMethodDescriptors.INIT)
	}
}
