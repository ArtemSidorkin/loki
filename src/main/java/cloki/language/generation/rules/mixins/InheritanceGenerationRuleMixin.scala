package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.{ExpressionContext, InheritanceContext}

private[generation] trait InheritanceGenerationRuleMixin extends GenerationRuleMixin[InheritanceContext]
{
	protected val parentCount:Int = ruleContext.expression.size

	protected def getParentExpression(parentIndex:Int):ExpressionContext = ruleContext expression parentIndex
}
