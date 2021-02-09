package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import loki.language.generation.constant.DynamicallyUnresolvableMethodDescriptors
import loki.runtime.unit.unit.LUnit

private[generation] object ContainerBytecodeTemplate
{
	implicit class ContainerBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def invokeInitContainer(containerClass:Class[_ <: LUnit]):methodBuilder.type =
			methodBuilder.invokeinit(DynamicallyUnresolvableMethodDescriptors.CONTAINER_INIT_METHOD_INVOCATION_DESCRIPTOR(Right(containerClass)))
	}
}
