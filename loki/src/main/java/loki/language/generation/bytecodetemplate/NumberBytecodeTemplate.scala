package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import assembler.methoddescriptor.MethodDescriptorResolver
import loki.runtime.compilerapi.number.NumberConstructor
import loki.runtime.unit.data.number.LNumber

private[generation] object NumberBytecodeTemplate
{
	implicit class NumberBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def invokeInitNumber():methodBuilder.type =
			methodBuilder.invokeinit(classOf[LNumber], MethodDescriptorResolver(classOf[NumberConstructor]))
	}
}
