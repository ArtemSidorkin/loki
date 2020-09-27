package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import assembler.methoddescriptor.MethodDescriptorResolver
import loki.runtime.marker.compilerapi.number.NumberConstructor

private[generation] object NumberBytecodeTemplate
{
	implicit class NumberBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def invokeInitNumber():methodBuilder.type =
			methodBuilder.invokeinit(MethodDescriptorResolver(classOf[NumberConstructor]))
	}
}
