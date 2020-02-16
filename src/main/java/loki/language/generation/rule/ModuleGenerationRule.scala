package loki.language.generation.rule

import assembler.constant.PUBLIC
import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CommonBytecodeTemplate
import loki.language.generation.bytecodetemplate.ContextBytecodeTemplate.ContextBytecodeTemplate
import loki.language.generation.bytecodetemplate.ModuleBytecodeTemplate.ModuleBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.generation.constant.BytecodeMethodDescriptors
import loki.language.parsing.LokiParser.ModuleContext
import loki.system.SystemSettings

private[generation] class ModuleGenerationRule
	(moduleContext:ModuleContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(moduleContext)
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
	def enter(moduleContext:ModuleContext)(implicit generationContext:GenerationContext):Unit =
		new ModuleGenerationRule(moduleContext).enter()

	def exit(moduleContext:ModuleContext)(implicit generationContext:GenerationContext):Unit =
		new ModuleGenerationRule(moduleContext).exit()
}