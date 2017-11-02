package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.IfElseContext

private[language] trait CMixinRuleGenerationIfElse extends CMixinRuleGeneration[IfElseContext]
{
	protected def logicalExpression = ruleContext expression
	protected def lastIfExpression = ruleContext instruction ruleContext.instruction.size - 1 expression
	protected def lastIfInstruction = ruleContext instruction ruleContext.instruction.size - 1

	protected def isElsePresent = ruleContext.else_ != null
	protected def firstElseExpression = ruleContext.else_ instruction 0 expression
	protected def lastElseExpression = ruleContext.else_ instruction (ruleContext.else_.instruction.size - 1) expression
	protected def lastElseInstruction = ruleContext.else_ instruction (ruleContext.else_.instruction.size - 1)
}