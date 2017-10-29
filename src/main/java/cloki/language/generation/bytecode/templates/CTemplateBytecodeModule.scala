package cloki.language.generation.bytecode.templates

import casm.entities.CAMethod
import cloki.language.generation.bytecode.consts.{CConstBytecodeLocalVariablesOrParameters, CConstBytecodeMethodDescriptors}
import cloki.language.generation.consts.CConstLanguageMembers
import cloki.runtime.datatype.{LModule, LUnit}
import cloki.runtime.context.LUnitContext

private[bytecode] object CTemplateBytecodeModule
{
	implicit class CTemplateModule(method:CAMethod)
	{
		def aloadModuleHeirMethodInitParameterUnitContext() =
		(
			method
			aload CConstBytecodeLocalVariablesOrParameters.MODULE_HEIR__METHOD__INIT__PARAMETER__UNIT_CONTEXT
		)

		def invokeInitModule() = method invokeinit
		(
			classOf[LModule], CConstBytecodeMethodDescriptors.MODULE__METHOD__INIT
		)
	}
}
