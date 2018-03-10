package loki.language.generation.rule.mixin

import loki.language.parsing.LokiParser.{ExpressionContext, IndexContext}

private[generation] trait IndexGenerationRuleMixin extends GenerationRuleMixin[IndexContext]
{
	protected val indexExpressionCount:Int = ruleContext.expression.size - 1
	protected val hostExpression:ExpressionContext = ruleContext expression 0

	protected def getIndexExpression(indexExpressionIndex:Int):ExpressionContext =
		ruleContext expression indexExpressionIndex + 1
}
