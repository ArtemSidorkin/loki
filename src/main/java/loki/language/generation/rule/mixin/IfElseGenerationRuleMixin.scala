package loki.language.generation.rule.mixin

import loki.language.parsing.LokiParser.{ExpressionContext, IfElseContext, InstructionContext}

private[generation] trait IfElseGenerationRuleMixin extends GenerationRuleMixin[IfElseContext]
{
	protected def logicalExpression:ExpressionContext = ruleContext expression

	protected def lastIfExpression:ExpressionContext =
		ruleContext instruction ruleContext.instruction.size - 1 expression

	protected def lastIfInstruction:InstructionContext = ruleContext instruction ruleContext.instruction.size - 1

	protected def isElsePresent:Boolean = ruleContext.else_ != null

	protected def firstElseExpression:ExpressionContext = ruleContext.else_ instruction 0 expression

	protected def lastElseExpression:ExpressionContext =
		ruleContext.else_ instruction (ruleContext.else_.instruction.size - 1) expression

	protected def lastElseInstruction:InstructionContext =
		ruleContext.else_ instruction (ruleContext.else_.instruction.size - 1)
}