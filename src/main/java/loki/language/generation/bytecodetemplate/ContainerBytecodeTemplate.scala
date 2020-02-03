package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import loki.language.generation.constant.BytecodeContainerMethodDescriptors
import loki.runtime.datatype.unit.LUnit

private[generation] object ContainerBytecodeTemplate
{
	implicit class ContainerBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def invokeInitContainer(containerClass:Class[_ <: LUnit]):methodBuilder.type =
			methodBuilder invokeinit (containerClass, BytecodeContainerMethodDescriptors.INIT)
	}
}
