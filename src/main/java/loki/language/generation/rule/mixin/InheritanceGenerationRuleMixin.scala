package loki.language.generation.rule.mixin

import loki.language.parsing.LokiParser.{ExpressionContext, InheritanceContext}

private[generation] trait InheritanceGenerationRuleMixin extends GenerationRuleMixin[InheritanceContext]
{
	protected val parentCount:Int = ruleContext.expression.size

	protected def getParentExpression(parentIndex:Int):ExpressionContext = ruleContext expression parentIndex
}