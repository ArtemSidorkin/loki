package loki.language.generation.rules.mixins

import loki.language.parsing.LokiParser.{AssignIndexContext, ExpressionContext}

private[generation] trait AssignIndexGenerationRuleMixin extends GenerationRuleMixin[AssignIndexContext]
{
	protected val parametersCount:Int = ruleContext.expression.size - 1
	protected val hostExpression:ExpressionContext = ruleContext expression 0

	protected def getParameterExpression(expressionIndex:Int):ExpressionContext =
		ruleContext expression expressionIndex + 1
}
