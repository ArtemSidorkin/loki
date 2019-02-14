package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import loki.language.generation.constant.BytecodeMethodDescriptors
import loki.runtime.datatype.LString

object StringBytecodeTemplate
{
	implicit class CTemplateNumber(method:MethodBuilder)
	{
		def invokeInitString() = method invokeinit
		(
			classOf[LString], BytecodeMethodDescriptors.STRING__METHOD__INIT
		)
	}
}
