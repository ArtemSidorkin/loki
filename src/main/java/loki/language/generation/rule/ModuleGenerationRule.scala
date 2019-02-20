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

class ModuleGenerationRule(generationContext:GenerationContext, ruleContext:ModuleContext)
	extends GenerationRule(generationContext, ruleContext)
{
	override protected def enterAction() =
	{
		pushModuleFrame()
//			val init = addAndGenerateMethodInit()


		val init =
		(
			topClassFrame
			addMethodInit (PUBLIC, BytecodeMethodDescriptors.MODULE_HEIR__METHOD__INIT)
			aloadthis ()
			ldc moduleName
			aloadModuleHeirMethodInitParameterUnitContext ()
			invokeInitModule ()
			`return` ()
		)

		generateContextInTopMethodCall()

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

	override protected def exitAction() =
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

object ModuleGenerationRule
{
	def enter(generationContext:GenerationContext, ruleContext:ModuleContext):Unit =
		new ModuleGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:GenerationContext, ruleContext:ModuleContext):Unit =
		new ModuleGenerationRule(generationContext, ruleContext).exit()
}