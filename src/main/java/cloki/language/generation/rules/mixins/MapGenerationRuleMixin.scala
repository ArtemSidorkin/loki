package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.{ExpressionContext, MapContext}

private[generation] trait MapGenerationRuleMixin extends GenerationRuleMixin[MapContext]
{
	protected val itemCount:Int = ruleContext.expression.size

	protected def getItemExpression(itemIndex:Int):ExpressionContext = ruleContext expression itemIndex
}
