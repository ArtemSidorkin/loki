package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.WhileContext

private[language] trait CMixinRuleGenerationWhile extends CMixinRuleGeneration[WhileContext]
{
	protected def logicalExpression = ruleContext expression
	protected def lastExpression = ruleContext instruction ruleContext.instruction.size - 1 expression
	protected def lastInstruction = ruleContext instruction ruleContext.instruction.size - 1
}