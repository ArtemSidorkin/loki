package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.{CallContext, ExpressionContext}


private[generation] class CallGenerationRule(generationContext:GenerationContext, callContext:CallContext)
	extends GenerationRule(generationContext, callContext)
{
	private def callParameterCount:Int = ruleContext.expression.size - 1
	private def callExpression:ExpressionContext = ruleContext expression 0

	override protected def enterAction()
	{
		loadHostAndCreateParameterArray()
		storeParametersInParameterArray()

		def loadHostAndCreateParameterArray():Unit =
			generationContext
				.addPostExitRuleTask(
					callExpression,
					() =>
						topMethodCall
							aloadUnitMethodCallParameterHost ()
							anewarrayUnit callParameterCount
				)

		def storeParametersInParameterArray():Unit =
			for (parameterIndex <- 1 to callParameterCount)
			{
				generationContext
					.addPreEnterRuleTask(
						getCallParameterExpression(parameterIndex),
						() =>
							topMethodCall
								dup ()
								ldc parameterIndex - 1
					)

				generationContext
					.addPostExitRuleTask(
						getCallParameterExpression(parameterIndex),
						() =>
							topMethodCall
								aastore ()
								decrementObjectCounter ()

					)
			}
	}

	override protected def exitAction():Unit = (
		topMethodCall
			aloadUnitMethodCallVariableUnitContext ()
			invokeVirtualUnitMethodCall ()
	)

	private def getCallParameterExpression(parameterIndex:Int):ExpressionContext =
		ruleContext expression parameterIndex
}

private[generation] object CallGenerationRule
{
	def enter(generationContext:GenerationContext, ruleContext:CallContext):Unit =
		new CallGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:GenerationContext, ruleContext:CallContext):Unit =
		new CallGenerationRule(generationContext, ruleContext).exit()
}