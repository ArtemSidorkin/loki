package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import loki.language.generation.constant.BytecodeMethodDescriptors
import loki.runtime.datatype.number.LNumber

private[generation] object NumberBytecodeTemplate
{
	implicit class NumberBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def invokeInitNumber():methodBuilder.type = methodBuilder invokeinit (
			classOf[LNumber], BytecodeMethodDescriptors.NUMBER__METHOD__INIT
		)
	}
}
