package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationCall
import cloki.language.parsing.CLokiParser.CallContext

private[bytecode] object CRuleGenerationBytecodeCall extends CRuleGenerationBytecode[CallContext]
{
	protected class CCoreBytecodeCall(generationContext:CGenerationContextBytecode, ruleContext:CallContext)
		extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationCall
	{
		override def enter()
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

		override def exit() =
		(
			topMethodCall
			aloadUnitMethodCallVariableUnitContext ()
			invokeVirtualUnitMethodCall ()
		)
	}

	override protected def getCore(generationContext:CGenerationContextBytecode, ruleContext:CallContext) =
		new CCoreBytecodeCall(generationContext, ruleContext)
}
