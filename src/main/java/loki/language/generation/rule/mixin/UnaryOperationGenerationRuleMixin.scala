package loki.language.generation.rule.mixin

import loki.language.generation.constant.LanguageMembers._
import loki.language.parsing.LokiParser.{ExpressionContext, UnaryOperationContext}

private[generation] trait UnaryOperationGenerationRuleMixin extends GenerationRuleMixin[UnaryOperationContext]
{
	protected val operator:String =
	{
		if (ruleContext.BANG() != null) UNARY_OPERATOR_BANG
		else if (ruleContext.MINUS() != null) UNARY_OPERATOR_MINUS
		else throw new IllegalArgumentException(ruleContext.toString)
	}

	protected val expression:ExpressionContext = ruleContext.expression
}
