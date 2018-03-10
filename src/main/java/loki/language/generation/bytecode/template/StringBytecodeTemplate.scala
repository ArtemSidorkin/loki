package loki.language.generation.bytecode.template

import assembler.builder.MethodBuilder
import loki.language.generation.bytecode.constant.BytecodeMethodDescriptors
import loki.runtime.datatype.LString

private[bytecode] object StringBytecodeTemplate
{
	implicit class CTemplateNumber(method:MethodBuilder)
	{
		def invokeInitString() = method invokeinit
		(
			classOf[LString], BytecodeMethodDescriptors.STRING__METHOD__INIT
		)
	}
}
