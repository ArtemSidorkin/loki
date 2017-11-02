package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.InheritanceContext

private[language] trait CMixinRuleGenerationInheritance extends CMixinRuleGeneration[InheritanceContext]
{
	protected val parentCount = ruleContext.expression.size

	protected def getParentExpression(parentIndex:Int) = ruleContext expression parentIndex
}
