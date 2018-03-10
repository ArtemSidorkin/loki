package loki.language.generation.rule.mixin

import loki.language.parsing.LokiParser.{ArrayContext, ExpressionContext}

private[generation] trait ArrayGenerationRuleMixin extends GenerationRuleMixin[ArrayContext]
{
	protected val arrayItemCount:Int = ruleContext.expression.size

	protected def getArrayItemExpression(parameterIndex:Int):ExpressionContext = ruleContext expression parameterIndex
}
