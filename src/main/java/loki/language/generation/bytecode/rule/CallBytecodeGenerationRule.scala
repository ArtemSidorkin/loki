package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.mixin.CallGenerationRuleMixin
import loki.language.parsing.LokiParser.CallContext

class CallBytecodeGenerationRule(generationContext:BytecodeGenerationContext, ruleContext:CallContext)
	extends BytecodeGenerationRule(generationContext, ruleContext) with CallGenerationRuleMixin
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
			generationContext.addPreEnterRuleTask(getCallParameterExpression(i), () =>
				topMethodCall
				dup ()
				ldc i - 1
			)
			generationContext.addPostExitRuleTask(getCallParameterExpression(i), () =>
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

object CallBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:CallContext):Unit =
		new CallBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:CallContext):Unit =
		new CallBytecodeGenerationRule(generationContext, ruleContext).exit()
}