package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.{AssignMemberAccessorContext, ExpressionContext}

private[generation] class AssignMemberAccessorGenerationRule(
	generationContext:GenerationContext, assignMemberAccessorContext:AssignMemberAccessorContext
)
	extends GenerationRule(generationContext, assignMemberAccessorContext)
{
	private def memberNameExpressionContext:ExpressionContext = ruleContext expression 1

	override protected def enterAction():Unit =
		generationContext
			.addPostExitRuleTask(memberNameExpressionContext, () => topMethodCall invokeVirtualUnitMethodToString ())

	override protected def exitAction():Unit = (
		topMethodCall
			invokeVirtualUnitMethodSetMember ()
			decreaseObjectCounter 2
	)
}

private[generation] object AssignMemberAccessorGenerationRule
{
	def enter(generationContext:GenerationContext, assignMemberAccessorContext:AssignMemberAccessorContext):Unit =
		new AssignMemberAccessorGenerationRule(generationContext, assignMemberAccessorContext).enter()

	def exit(generationContext:GenerationContext, assignMemberAccessorContext:AssignMemberAccessorContext):Unit =
		new AssignMemberAccessorGenerationRule(generationContext, assignMemberAccessorContext).exit()
}