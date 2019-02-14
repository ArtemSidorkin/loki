package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import loki.language.generation.constant.BytecodeMethodDescriptors
import loki.language.generation.constant.LanguageMembers
import loki.runtime.context.{LModuleContext, LUnitContext}

object ContextBytecodeTemplate
{
	implicit class CTemplateContext(method:MethodBuilder)
	{
		def invokeVirtualUnitContextMethodGetVariable() = method invokevirtual
		(
			classOf[LUnitContext],
			LanguageMembers.UNIT_CONTEXT__METHOD__GET_VARIABLE,
			BytecodeMethodDescriptors.UNIT_CONTEXT__METHOD__GET_VARIABLE
		)

		def invokeVirtualUnitContextMethodSetVariable() = method invokevirtual
		(
			classOf[LUnitContext],
			LanguageMembers.UNIT_CONTEXT__METHOD__SET_VARIABLE,
			BytecodeMethodDescriptors.UNIT_CONTEXT__METHOD__SET_VARIABLE
		)

		def invokeInitUnitContext() = method invokeinit
		(
			classOf[LUnitContext], BytecodeMethodDescriptors.UNIT_CONTEXT__METHOD__INIT
		)

		def invokeInitModuleContext() = method invokeinit
		(
			classOf[LModuleContext], BytecodeMethodDescriptors.MODULE_CONTEXT__METHOD__INIT
		)
	}
}
