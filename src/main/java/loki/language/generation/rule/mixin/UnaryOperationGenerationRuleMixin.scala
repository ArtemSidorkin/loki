package loki.language.generation.rule.mixin

import loki.language.generation.constant.LanguageMembers._
import loki.language.generation.rule.mixin.template.MemberCallGenerationRuleMixinTemplate
import loki.language.parsing.LokiParser.{ExpressionContext, UnaryOperationContext}

private[generation] trait UnaryOperationGenerationRuleMixin
	extends GenerationRuleMixin[UnaryOperationContext] with MemberCallGenerationRuleMixinTemplate
{
	override protected val memberName:String =
	{
		if (ruleContext.BANG() != null) UNARY_OPERATOR_BANG
		else if (ruleContext.MINUS() != null) UNARY_OPERATOR_MINUS
		else throw new IllegalArgumentException(ruleContext.toString)
	}

	override protected val memberExpressionContext:ExpressionContext = ruleContext.expression
	override protected val parameterExpressionContexts:Seq[ExpressionContext] = Nil
}

