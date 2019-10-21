package loki.language.generation.rule

import assembler.constant.PUBLIC
import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecodetemplate.ContextBytecodeTemplate.CTemplateContext
import loki.language.generation.bytecodetemplate.ModuleBytecodeTemplate.CTemplateModule
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.constant.BytecodeMethodDescriptors
import loki.language.parsing.LokiParser.ModuleContext
import loki.system.SystemSettings

private[generation] class ModuleGenerationRule(generationContext:GenerationContext, moduleContext:ModuleContext)
	extends GenerationRule(generationContext, moduleContext)
{
	override protected def enterAction():Unit =
	{
		pushModuleFrame()
		generateInit()
		generateContextInTopMethodCall()

		def generateInit():Unit =
		(
			topClassFrame
				addMethodInit (PUBLIC, BytecodeMethodDescriptors.MODULE_HEIR__METHOD__INIT)
				aloadthis ()
				ldc moduleName
				aloadModuleHeirMethodInitParameterUnitContext ()
				invokeInitModule ()
				`return` ()
		)

		def generateContextInTopMethodCall():Unit =
		(
			topMethodCall
				newModuleContext ()
				dup ()
				aloadthis ()
				aloadUnitMethodCallParameterHost ()
				aloadUnitMethodCallParameterParameters ()
				aloadthis ()
				getUnitFieldUnitContext topClassFrame.internalName
				invokeInitModuleContext ()
				astoreUnitMethodCallVariableUnitContext ()
		)
	}

	override protected def exitAction():Unit =
	{
		(
			topMethodCall
			aloadthis ()
			aReturn ()
		)

		classLoader.setClassCode(
			topClassFrame.internalName,
			topClassFrame toBytecode (if (SystemSettings.TRACE_BYTECODE) Some(System.out) else None)
		)

		popFrame()
	}
}

private[generation] object ModuleGenerationRule
{
	def enter(generationContext:GenerationContext, moduleContext:ModuleContext):Unit =
		new ModuleGenerationRule(generationContext, moduleContext).enter()

	def exit(generationContext:GenerationContext, moduleContext:ModuleContext):Unit =
		new ModuleGenerationRule(generationContext, moduleContext).exit()
}