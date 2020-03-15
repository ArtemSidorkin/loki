package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import loki.language.generation.constant.BytecodeMethodDescriptors
import loki.runtime.unit.data.LString

private[generation] object StringBytecodeTemplate
{
	implicit class StringBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def invokeInitString():methodBuilder.type = methodBuilder invokeinit (
			classOf[LString], BytecodeMethodDescriptors.STRING__METHOD__INIT
		)
	}
}
