package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CommonBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.{CallContext, ExpressionContext}

private[generation] class CallRule(callContext:CallContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(callContext)
{
	private val callParameterCount:Int = callContext.expression.size - 1
	private val callExpression:ExpressionContext = callContext expression 0

	override protected def enterAction():Unit =
	{
		def loadHostAndCreateParameterArray():Unit =
			generationContext
				.addPostExitRuleTask(
					callExpression,
					() =>
					{
						topMethodCall.aloadHostParameterOfUnitCallMethod()

						if (callParameterCount == 0) topMethodCall.emptyUnitArray()
						else topMethodCall.anewarrayUnit(callParameterCount)
					}
				)

		def storeParametersInParameterArray():Unit =
			for (parameterIndex <- 1 to callParameterCount)
			{
				generationContext
					.addPreEnterRuleTask(
						getCallParameterExpression(parameterIndex),
						() =>
							topMethodCall
								.dup()
								.ldc(parameterIndex - 1)
					)

				generationContext
					.addPostExitRuleTask(
						getCallParameterExpression(parameterIndex),
						() => topMethodCall.aastore()
					)
			}

		loadHostAndCreateParameterArray()
		storeParametersInParameterArray()
	}

	override protected def exitAction():Unit = topMethodCall.invokeVirtualUnitMethodCall()

	private def getCallParameterExpression(parameterIndex:Int) = callContext.expression(parameterIndex)
}