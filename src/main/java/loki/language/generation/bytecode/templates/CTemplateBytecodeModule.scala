package loki.language.generation.bytecode.templates

import assembler.builder.MethodBuilder
import loki.language.generation.bytecode.consts.{CConstBytecodeLocalVariablesOrParameters, CConstBytecodeMethodDescriptors}
import loki.runtime.datatype.LModule

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
