package loki.language.generation.rule.mixin.template

import loki.language.parsing.LokiParser.ExpressionContext

private[generation] trait MemberCallGenerationRuleMixinTemplate
{
	protected val memberName:String

	protected val hostExpressionContext:ExpressionContext

	protected val callParameterExpressionContexts:Seq[ExpressionContext]
}
