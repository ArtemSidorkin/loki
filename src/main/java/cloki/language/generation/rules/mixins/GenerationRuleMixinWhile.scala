package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.{ExpressionContext, InstructionContext, WhileContext}

private[generation] trait GenerationRuleMixinWhile extends GenerationRuleMixin[WhileContext]
{
	protected def logicalExpression:ExpressionContext = ruleContext expression
	protected def lastExpression:ExpressionContext = ruleContext instruction ruleContext.instruction.size - 1 expression
	protected def lastInstruction:InstructionContext = ruleContext instruction ruleContext.instruction.size - 1
}