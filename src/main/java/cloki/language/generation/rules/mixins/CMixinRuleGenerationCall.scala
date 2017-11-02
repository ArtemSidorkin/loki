package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.CallContext

private[language] trait CMixinRuleGenerationCall extends CMixinRuleGeneration[CallContext]
{
	protected val callExpression = ruleContext expression 0
	protected val callParameterCount = ruleContext.expression.size - 1

	protected def getCalledParameterExpression(parameterIndex:Int) = ruleContext expression parameterIndex
}
