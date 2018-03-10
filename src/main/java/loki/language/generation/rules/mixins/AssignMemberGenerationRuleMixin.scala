package loki.language.generation.rules.mixins

import loki.language.parsing.LokiParser.{AssignMemberContext, ExpressionContext}

private[generation] trait AssignMemberGenerationRuleMixin extends GenerationRuleMixin[AssignMemberContext]
{
	protected val memberName:String = ruleContext.IDENTIFIER.getText
	protected val expressionToAssign:ExpressionContext = ruleContext expression 0
}
