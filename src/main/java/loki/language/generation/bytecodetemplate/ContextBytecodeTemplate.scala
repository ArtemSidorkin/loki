package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import loki.language.generation.constant.{BytecodeMethodDescriptors, LanguageMembers}
import loki.runtime.context.{LModuleContext, LUnitContext}

private[generation] object ContextBytecodeTemplate
{
	implicit class ContextBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def invokeVirtualUnitContextMethodGetVariable():methodBuilder.type = methodBuilder invokevirtual (
			classOf[LUnitContext],
			LanguageMembers.UNIT_CONTEXT__METHOD__GET_VARIABLE,
			BytecodeMethodDescriptors.UNIT_CONTEXT__METHOD__GET_VARIABLE
		)

		def invokeVirtualUnitContextMethodSetVariable():methodBuilder.type = methodBuilder invokevirtual (
			classOf[LUnitContext],
			LanguageMembers.UNIT_CONTEXT__METHOD__SET_VARIABLE,
			BytecodeMethodDescriptors.UNIT_CONTEXT__METHOD__SET_VARIABLE
		)

		def invokeInitUnitContext():methodBuilder.type = methodBuilder invokeinit (
			classOf[LUnitContext], BytecodeMethodDescriptors.UNIT_CONTEXT__METHOD__INIT
		)

		def invokeInitModuleContext():methodBuilder.type = methodBuilder invokeinit (
			classOf[LModuleContext], BytecodeMethodDescriptors.MODULE_CONTEXT__METHOD__INIT
		)
	}
}
