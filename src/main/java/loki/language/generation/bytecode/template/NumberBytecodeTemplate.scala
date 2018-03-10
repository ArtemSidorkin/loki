package loki.language.generation.bytecode.template

import assembler.builder.MethodBuilder
import loki.language.generation.bytecode.constant.BytecodeMethodDescriptors
import loki.runtime.datatype.number.LNumber

private[bytecode] object NumberBytecodeTemplate
{
	implicit class CTemplateNumber(method:MethodBuilder)
	{
		def invokeInitNumber() = method invokeinit
		(
			classOf[LNumber], BytecodeMethodDescriptors.NUMBER__METHOD__INIT
		)
	}
}
