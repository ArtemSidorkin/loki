package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.AssignIndexContext

private[language] trait CMixinRuleGenerationAssignIndex extends CMixinRuleGeneration[AssignIndexContext]
{
	protected val parametersCount = ruleContext.expression.size - 1
	protected val hostExpression = ruleContext expression 0

	protected def getParameterExpression(indexExpressionIndex:Int) = ruleContext expression indexExpressionIndex + 1
}
