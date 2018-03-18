package loki.language.generation.rule.mixin

import loki.language.parsing.LokiParser.{AssignMemberAccessorContext, ExpressionContext}

private[generation] trait AssignMemberAccessorGenerationRuleMixin extends GenerationRuleMixin[AssignMemberAccessorContext]
{
	protected def memberNameExpression:ExpressionContext = ruleContext expression 1
}
