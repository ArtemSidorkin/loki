package cloki.language.generation.bytecode.templates

import assembler.builder.MethodBuilder
import cloki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import cloki.language.generation.consts.CConstLanguageMembers
import cloki.runtime.datatype.LType

private[bytecode] object CTemplateBytecodeType
{
	implicit class CTemplateType(method:MethodBuilder)
	{
		def invokeInitType() = method invokeinit(classOf[LType], CConstBytecodeMethodDescriptors.TYPE__METHOD__INIT)

		def invokestaticTypeMethodCreateAnonymous = method invokestatic
		(
			classOf[LType],
			CConstLanguageMembers.TYPE__METHOD__CREATE_ANONYMOUS,
			CConstBytecodeMethodDescriptors.TYPE__METHOD__CREATE_ANONYMOUS
		)
	}
}
