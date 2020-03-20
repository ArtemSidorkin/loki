package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.{AssignMemberAccessorContext, ExpressionContext}

private[generation] class AssignMemberAccessorGenerationRule
	(assignMemberAccessorContext:AssignMemberAccessorContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(assignMemberAccessorContext)
{
	private def memberNameExpressionContext:ExpressionContext = assignMemberAccessorContext expression 1

	override protected def enterAction():Unit =
		generationContext
			.addPostExitRuleTask(memberNameExpressionContext, () => topMethodCall.invokeVirtualUnitMethodToString())

	override protected def exitAction():Unit =
		topMethodCall
			.invokeVirtualUnitMethodSetMember()
			.decreaseObjectStackCounter(2)
}

private[generation] object AssignMemberAccessorGenerationRule
{
	def enter
		(assignMemberAccessorContext:AssignMemberAccessorContext)(implicit generationContext:GenerationContext):Unit =
		new AssignMemberAccessorGenerationRule(assignMemberAccessorContext).enter()

	def exit
		(assignMemberAccessorContext:AssignMemberAccessorContext)(implicit generationContext:GenerationContext):Unit =
		new AssignMemberAccessorGenerationRule(assignMemberAccessorContext).exit()
}