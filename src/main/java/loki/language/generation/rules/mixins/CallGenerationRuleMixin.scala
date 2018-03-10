package loki.language.generation.rules.mixins

import loki.language.parsing.LokiParser.{CallContext, ExpressionContext}

private[generation] trait CallGenerationRuleMixin extends GenerationRuleMixin[CallContext]
{
	protected val callParameterCount:Int = ruleContext.expression.size - 1
	protected val callExpression:ExpressionContext = ruleContext expression 0

	protected def getCallParameterExpression(parameterIndex:Int):ExpressionContext =
		ruleContext expression parameterIndex
}
