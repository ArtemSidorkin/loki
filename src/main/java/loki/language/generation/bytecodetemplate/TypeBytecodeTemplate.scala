package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import loki.language.generation.constant.BytecodeMethodDescriptors
import loki.language.generation.constant.LanguageMembers
import loki.runtime.datatype.`type`.LType

object TypeBytecodeTemplate
{
	implicit class CTemplateType(method:MethodBuilder)
	{
		def invokeInitType() = method invokeinit(classOf[LType], BytecodeMethodDescriptors.TYPE__METHOD__INIT)

		def invokestaticTypeMethodCreateAnonymous = method invokestatic
		(
			classOf[LType],
			LanguageMembers.TYPE__METHOD__CREATE_ANONYMOUS,
			BytecodeMethodDescriptors.TYPE__METHOD__CREATE_ANONYMOUS
		)
	}
}