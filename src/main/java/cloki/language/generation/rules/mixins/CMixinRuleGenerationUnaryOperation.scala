package cloki.language.generation.rules.mixins

import cloki.language.parsing.CLokiParser.UnaryOperationContext
import cloki.language.generation.consts.CConstLanguageMembers._

private[language] trait CMixinRuleGenerationUnaryOperation extends CMixinRuleGeneration[UnaryOperationContext]
{
	protected val operator =
	{
		if (ruleContext.BANG() != null)
			UNARY_OPERATOR_BANG
		else if (ruleContext.MINUS() != null)
			UNARY_OPERATOR_MINUS
		else
			""
	}

	protected val expression = ruleContext.expression
}
