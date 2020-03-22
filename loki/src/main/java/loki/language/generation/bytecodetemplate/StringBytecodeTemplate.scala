package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import assembler.methoddescriptor.MethodDescriptorResolver
import loki.runtime.compilerapi.string.StringConstructor
import loki.runtime.unit.data.LString

private[generation] object StringBytecodeTemplate
{
	implicit class StringBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def invokeInitString():methodBuilder.type =
			methodBuilder.invokeinit(classOf[LString], MethodDescriptorResolver(classOf[StringConstructor]))
	}
}
