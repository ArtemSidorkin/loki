package loki.language.generation.bytecode.template

import assembler.builder.MethodBuilder
import loki.language.generation.bytecode.constant.{BytecodeLocalVariablesOrParameters, BytecodeMethodDescriptors}
import loki.runtime.datatype.LModule

private[bytecode] object ModuleBytecodeTemplate
{
	implicit class CTemplateModule(method:MethodBuilder)
	{
		def aloadModuleHeirMethodInitParameterUnitContext() =
		(
			method
			aload BytecodeLocalVariablesOrParameters.MODULE_HEIR__METHOD__INIT__PARAMETER__UNIT_CONTEXT
		)

		def invokeInitModule() = method invokeinit
		(
			classOf[LModule], BytecodeMethodDescriptors.MODULE__METHOD__INIT
		)
	}
}
