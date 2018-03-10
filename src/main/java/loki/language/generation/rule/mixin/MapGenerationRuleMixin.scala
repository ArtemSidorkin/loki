package loki.language.generation.rule.mixin

import loki.language.parsing.LokiParser.{ExpressionContext, MapContext}

private[generation] trait MapGenerationRuleMixin extends GenerationRuleMixin[MapContext]
{
	protected val itemCount:Int = ruleContext.expression.size

	protected def getItemExpression(itemIndex:Int):ExpressionContext = ruleContext expression itemIndex
}
