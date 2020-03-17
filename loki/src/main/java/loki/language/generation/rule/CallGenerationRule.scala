package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CommonBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.{CallContext, ExpressionContext}

import scala.language.postfixOps

private[generation] class CallGenerationRule(callContext:CallContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(callContext)
{
	private def callParameterCount:Int = callContext.expression.size - 1 //TODO: think is it worth to declare field for this, or maybe cast to scala and save thecollection
	private def callExpression:ExpressionContext = callContext expression 0

	override protected def enterAction():Unit =
	{
		loadHostAndCreateParameterArray()
		storeParametersInParameterArray()

		def loadHostAndCreateParameterArray():Unit =
			generationContext
				.addPostExitRuleTask(
					callExpression,
					() =>
					{
						topMethodCall aloadUnitMethodCallParameterHost

						if (callParameterCount == 0) topMethodCall emptyUnitArray
						else topMethodCall anewarrayUnit callParameterCount
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
						() =>
							topMethodCall
								.aastore()
								.decrementObjectCounter()

					)
			}
	}

	override protected def exitAction():Unit = topMethodCall.invokeVirtualUnitMethodCall()

	private def getCallParameterExpression(parameterIndex:Int) = callContext expression parameterIndex
}

private[generation] object CallGenerationRule
{
	def enter(callContext:CallContext)(implicit generationContext:GenerationContext):Unit =
		new CallGenerationRule(callContext).enter()

	def exit(callContext:CallContext)(implicit generationContext:GenerationContext):Unit =
		new CallGenerationRule(callContext).exit()
}