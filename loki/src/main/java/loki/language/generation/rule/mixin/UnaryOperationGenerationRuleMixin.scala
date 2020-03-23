package loki.language.generation.rule.mixin

import loki.language.generation.rule.mixin.template.MemberCallGenerationRuleMixinTemplate
import loki.language.parsing.LokiParser.{ExpressionContext, UnaryOperationContext}

private[generation] trait UnaryOperationGenerationRuleMixin
	extends GenerationRuleMixin[UnaryOperationContext] with MemberCallGenerationRuleMixinTemplate
{
	override protected val memberName:String = s"${ruleContext.operator.getText}_"

	override protected val hostExpressionContext:ExpressionContext = ruleContext.expression

	override protected val callParameterExpressionContexts:Seq[ExpressionContext] = Nil
}

