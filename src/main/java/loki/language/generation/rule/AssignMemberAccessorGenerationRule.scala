package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.{AssignMemberAccessorContext, ExpressionContext}

class AssignMemberAccessorGenerationRule(
													bytecodeGenerationContext:GenerationContext, assignMemberAccessorContext:AssignMemberAccessorContext
)
	extends GenerationRule(bytecodeGenerationContext, assignMemberAccessorContext)
{

	override protected def enterAction():Unit =
		bytecodeGenerationContext
			.addPostExitRuleTask(memberNameExpression, () => topMethodCall invokeVirtualUnitMethodToString ())

	override protected def exitAction():Unit =
	(
		topMethodCall
		invokeVirtualUnitMethodSetMember ()
		decreaseObjectCounter 2
	)

	private def memberNameExpression:ExpressionContext = ruleContext expression 1
}

object AssignMemberAccessorGenerationRule
{
	def enter(
				 bytecodeGenerationContext:GenerationContext, assignMemberAccessorContext:AssignMemberAccessorContext
	):Unit =
		new AssignMemberAccessorGenerationRule(bytecodeGenerationContext, assignMemberAccessorContext).enter()

	def exit(
				bytecodeGenerationContext:GenerationContext, assignMemberAccessorContext:AssignMemberAccessorContext
	):Unit =
		new AssignMemberAccessorGenerationRule(bytecodeGenerationContext, assignMemberAccessorContext).exit()
}