package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import assembler.methoddescriptor.MethodDescriptorResolver
import loki.runtime.marker.compilerapi.string.StringConstructor

private[generation] object StringBytecodeTemplate
{
	implicit class StringBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def invokeInitString():methodBuilder.type =
			methodBuilder.invokeinit(MethodDescriptorResolver(classOf[StringConstructor]))
	}
}
