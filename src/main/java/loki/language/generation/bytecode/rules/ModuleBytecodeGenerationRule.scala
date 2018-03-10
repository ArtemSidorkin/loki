package loki.language.generation.bytecode.rules

import assembler.const.PUBLIC
import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import loki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import loki.language.generation.bytecode.templates.CTemplateBytecodeContext.CTemplateContext
import loki.language.generation.bytecode.templates.CTemplateBytecodeModule.CTemplateModule
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
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
			addMethodInit (PUBLIC, CConstBytecodeMethodDescriptors.MODULE_HEIR__METHOD__INIT)
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