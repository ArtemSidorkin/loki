package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationCall
import cloki.language.parsing.LokiParser.CallContext

class GenerationRuleBytecodeCall(generationContext:CGenerationContextBytecode, ruleContext:CallContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with CMixinRuleGenerationCall
{
	override protected def enterAction()
	{
		generateCallHostAndCallParameterArray()
		generateCallParameters()

		def generateCallHostAndCallParameterArray():Unit =
			generationContext.addPostExitRuleTask(callExpression, () =>
			(
				topMethodCall
				aloadUnitMethodCallParameterHost ()
				ldc callParameterCount
				anewarrayUnit ()
			))

		def generateCallParameters():Unit = for (i <- 1 to callParameterCount)
		{
			generationContext.addPreEnterRuleTask(getCalledParameterExpression(i), () =>
				topMethodCall
				dup ()
				ldc i - 1
			)
			generationContext.addPostExitRuleTask(getCalledParameterExpression(i), () =>
			(
				topMethodCall
				aastore ()
				decrementObjectCounter ()
			))
		}
	}

	override protected def exitAction() =
	(
		topMethodCall
		aloadUnitMethodCallVariableUnitContext ()
		invokeVirtualUnitMethodCall ()
	)
}

object GenerationRuleBytecodeCall
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:CallContext):Unit =
		new GenerationRuleBytecodeCall(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:CallContext):Unit =
		new GenerationRuleBytecodeCall(generationContext, ruleContext).exit()
}