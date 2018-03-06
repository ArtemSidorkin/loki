package cloki.language.generation.bytecode.templates

import assembler.builder.MethodBuilder
import cloki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import cloki.runtime.datatype.number.LNumber

private[bytecode] object CTemplateBytecodeNumber
{
	implicit class CTemplateNumber(method:MethodBuilder)
	{
		def invokeInitNumber() = method invokeinit
		(
			classOf[LNumber], CConstBytecodeMethodDescriptors.NUMBER__METHOD__INIT
		)
	}
}
