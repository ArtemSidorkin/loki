package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.{CallContext, ExpressionContext}

class CallGenerationRule(generationContext:GenerationContext, ruleContext:CallContext)
	extends GenerationRule(generationContext, ruleContext)
{
	private val callParameterCount:Int = ruleContext.expression.size - 1
	private val callExpression:ExpressionContext = ruleContext expression 0

	override protected def enterAction()
	{
		generateCallHostAndCallParameterArray()
		generateCallParameters()

		def generateCallHostAndCallParameterArray():Unit =
			generationContext.addPostExitRuleTask(callExpression, () =>
			(
				topMethodCall
				aloadUnitMethodCallParameterHost ()
				anewarrayUnit callParameterCount
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

	override protected def exitAction():Unit =
	(
		topMethodCall
		aloadUnitMethodCallVariableUnitContext ()
		invokeVirtualUnitMethodCall ()
	)

	private def getCallParameterExpression(parameterIndex:Int):ExpressionContext =
		ruleContext expression parameterIndex
}

object CallGenerationRule
{
	def enter(generationContext:GenerationContext, ruleContext:CallContext):Unit =
		new CallGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:GenerationContext, ruleContext:CallContext):Unit =
		new CallGenerationRule(generationContext, ruleContext).exit()
}