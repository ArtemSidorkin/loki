package loki.language.generation.bytecode.rule

import assembler.constant.PUBLIC
import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.constant.BytecodeMethodDescriptors
import loki.language.generation.bytecode.template.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecode.template.ContextBytecodeTemplate.CTemplateContext
import loki.language.generation.bytecode.template.ModuleBytecodeTemplate.CTemplateModule
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.ModuleContext
import loki.system.SystemSettings

class ModuleBytecodeGenerationRule(generationContext:BytecodeGenerationContext, ruleContext:ModuleContext)
	extends BytecodeGenerationRule(generationContext, ruleContext)
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

object ModuleBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:ModuleContext):Unit =
		new ModuleBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:ModuleContext):Unit =
		new ModuleBytecodeGenerationRule(generationContext, ruleContext).exit()
}