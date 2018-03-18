package loki.language.generation.rule.mixin

import loki.language.parsing.LokiParser.{ExpressionContext, ObjectContext}

private[generation] trait ObjectGenerationRuleMixin extends GenerationRuleMixin[ObjectContext]
{
	protected val memberNameValueCount:Int = ruleContext.expression.size

	protected def getMemberNameValueExpression(itemIndex:Int):ExpressionContext = ruleContext expression itemIndex
}
