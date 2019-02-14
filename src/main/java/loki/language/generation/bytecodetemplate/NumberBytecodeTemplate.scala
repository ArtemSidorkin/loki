package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import loki.language.generation.constant.BytecodeMethodDescriptors
import loki.runtime.datatype.number.LNumber

object NumberBytecodeTemplate
{
	implicit class CTemplateNumber(method:MethodBuilder)
	{
		def invokeInitNumber() = method invokeinit
		(
			classOf[LNumber], BytecodeMethodDescriptors.NUMBER__METHOD__INIT
		)
	}
}
