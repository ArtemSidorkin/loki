package cloki.language.generation.bytecode.templates

import casm.entities.CAMethod
import cloki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import cloki.runtime.datatypes.CNumber

private[bytecode] object CTemplateBytecodeNumber
{
	implicit class CTemplateNumber(method:CAMethod)
	{
		def invokeInitNumber() = method invokeinit
		(
			classOf[CNumber], CConstBytecodeMethodDescriptors.NUMBER__METHOD__INIT
		)
	}
}
