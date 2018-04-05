package loki.language.generation.bytecode.template

import assembler.builder.MethodBuilder
import loki.language.generation.bytecode.constant.BytecodeContainerMethodDescriptors
import loki.runtime.datatype.unit.LUnit

private[bytecode] object ContainerBytecodeTemplate
{
	implicit class Template(method:MethodBuilder)
	{
		def invokeInitContainer(containerClass:Class[_ <: LUnit]):MethodBuilder =
			method invokeinit (containerClass, BytecodeContainerMethodDescriptors.INIT)
	}
}
