package cloki.language.generation.bytecode.rules

import casm.consts.PUBLIC
import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.consts.{CConstBytecodeLocalVariablesOrParameters, CConstBytecodeMethodDescriptors}
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeContext.CTemplateContext
import cloki.language.generation.bytecode.templates.CTemplateBytecodeModule.CTemplateModule
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.parsing.CLokiParser.ModuleContext
import cloki.system.CSystemSettings

private[bytecode] object CRuleGenerationBytecodeModule extends CRuleGenerationBytecode[ModuleContext]
{
	protected class CCoreBytecodeModule(generationContext:CGenerationContextBytecode, ruleContext:ModuleContext)
		extends CCoreBytecode(generationContext, ruleContext)
	{
		override def enter() =
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

		override def exit() =
		{
			(
				topMethodCall
				aloadthis ()
				aReturn ()
			)

			classLoader.setClassCode(
				topClassFrame.internalName,
				topClassFrame toBytecode (if (CSystemSettings.TRACE_BYTECODE) Some(System.out) else None)
			)

			popFrame()
		}
	}

	override protected def getCore(generationContext:CGenerationContextBytecode, ruleContext:ModuleContext) =
		new CCoreBytecodeModule(generationContext, ruleContext)
}
