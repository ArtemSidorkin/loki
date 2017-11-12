package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.{ExpressionContext, MemberCallContext}

private[generation] trait MemberCallGenerationRuleMixin extends GenerationRuleMixin[MemberCallContext]
{
	protected val callParameterCount:Int = ruleContext.expression.size - 1
	protected val memberExpression:ExpressionContext = ruleContext expression 0
	protected val memberName:String = ruleContext.IDENTIFIER.getText

	protected def getCallParameterExpression(parameterIndex:Int):ExpressionContext =
		ruleContext expression parameterIndex
}
