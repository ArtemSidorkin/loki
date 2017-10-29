package cloki.language.generation.bytecode.templates

import casm.entities.CAMethod
import cloki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import cloki.language.generation.consts.CConstLanguageMembers
import cloki.runtime.context.{LModuleContext, LUnitContext}

private[bytecode] object CTemplateBytecodeContext
{
	implicit class CTemplateContext(method:CAMethod)
	{
		def invokeVirtualUnitContextMethodGetVariable() = method invokevirtual
		(
			classOf[LUnitContext],
			CConstLanguageMembers.UNIT_CONTEXT__METHOD__GET_VARIABLE,
			CConstBytecodeMethodDescriptors.UNIT_CONTEXT__METHOD__GET_VARIABLE
		)

		def invokeVirtualUnitContextMethodSetVariable() = method invokevirtual
		(
			classOf[LUnitContext],
			CConstLanguageMembers.UNIT_CONTEXT__METHOD__SET_VARIABLE,
			CConstBytecodeMethodDescriptors.UNIT_CONTEXT__METHOD__SET_VARIABLE
		)

		def invokeInitUnitContext() = method invokeinit
		(
			classOf[LUnitContext], CConstBytecodeMethodDescriptors.UNIT_CONTEXT__METHOD__INIT
		)

		def invokeInitModuleContext() = method invokeinit
		(
			classOf[LModuleContext], CConstBytecodeMethodDescriptors.MODULE_CONTEXT__METHOD__INIT
		)
	}
}
