package loki.language.generation.bytecode.templates

import assembler.builder.MethodBuilder
import loki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import loki.runtime.datatype.LString

private[bytecode] object CTemplateBytecodeString
{
	implicit class CTemplateNumber(method:MethodBuilder)
	{
		def invokeInitString() = method invokeinit
		(
			classOf[LString], CConstBytecodeMethodDescriptors.STRING__METHOD__INIT
		)
	}
}
