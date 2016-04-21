package cloki.language.generation.rules.mixins

import cloki.language.parsing.CLokiParser.MemberCallContext

private[language] trait CMixinRuleGenerationMemberCall extends CMixinRuleGeneration[MemberCallContext]
{
	protected val memberExpression = ruleContext expression 0
	protected val memberName = ruleContext.IDENTIFIER.getText
	protected val callParameterCount = ruleContext.expression.size - 1

	protected def getCallParameterExpression(parameterIndex:Int) = ruleContext expression parameterIndex
}
