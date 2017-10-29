package cloki.language.generation.rules.mixins

import cloki.language.parsing.CLokiParser.{IndexContext, ArrayContext}

private[language] trait CMixinRuleGenerationIndex extends CMixinRuleGeneration[IndexContext]
{
	protected val indexExpressionCount = ruleContext.expression.size - 1
	protected val hostExpression = ruleContext expression 0

	protected def getIndexExpression(indexExpressionIndex:Int) = ruleContext expression indexExpressionIndex + 1
}
