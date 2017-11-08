package cloki.language.generation.bytecode.templates

import assembler.builder.MethodBuilder
import cloki.language.generation.bytecode.consts.{CConstBytecodeLocalVariablesOrParameters, CConstBytecodeMethodDescriptors}
import cloki.runtime.datatype.LModule

private[bytecode] object CTemplateBytecodeModule
{
	implicit class CTemplateModule(method:MethodBuilder)
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
