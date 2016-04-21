package cloki.language.generation.bytecode.templates

import casm.entities.CAMethod
import cloki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import cloki.language.generation.consts.CConstLanguageMembers
import cloki.runtime.datatypes.CType

private[bytecode] object CTemplateBytecodeType
{
	implicit class CTemplateType(method:CAMethod)
	{
		def invokeInitType() = method invokeinit(classOf[CType], CConstBytecodeMethodDescriptors.TYPE__METHOD__INIT)

		def invokestaticTypeMethodCreateAnonymous = method invokestatic
		(
			classOf[CType],
			CConstLanguageMembers.TYPE__METHOD__CREATE_ANONYMOUS,
			CConstBytecodeMethodDescriptors.TYPE__METHOD__CREATE_ANONYMOUS
		)
	}
}
