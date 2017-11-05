package cloki.language.generation.bytecode.rules

import casm.consts.PUBLIC
import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeContext.CTemplateContext
import cloki.language.generation.bytecode.templates.CTemplateBytecodeModule.CTemplateModule
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.parsing.LokiParser.ModuleContext
import cloki.system.SystemSettings

class GenerationRuleBytecodeModule(generationContext:CGenerationContextBytecode, ruleContext:ModuleContext)
	extends GenerationRuleBytecode(generationContext, ruleContext)
{
	override def __enter() =
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

	override def __exit() =
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
