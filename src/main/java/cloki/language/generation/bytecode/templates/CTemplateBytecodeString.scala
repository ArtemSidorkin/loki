package cloki.language.generation.bytecode.templates

import casm.entities.CAMethod
import cloki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import cloki.runtime.datatype.LString

private[bytecode] object CTemplateBytecodeString
{
	implicit class CTemplateNumber(method:CAMethod)
	{
		def invokeInitString() = method invokeinit
		(
			classOf[LString], CConstBytecodeMethodDescriptors.STRING__METHOD__INIT
		)
	}
}
