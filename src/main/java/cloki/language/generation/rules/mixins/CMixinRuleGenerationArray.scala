package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.ArrayContext

private[language] trait CMixinRuleGenerationArray extends CMixinRuleGeneration[ArrayContext]
{
	protected val arrayItemCount = ruleContext.expression.size

	protected def getArrayItemExpression(parameterIndex:Int) = ruleContext expression parameterIndex
}
