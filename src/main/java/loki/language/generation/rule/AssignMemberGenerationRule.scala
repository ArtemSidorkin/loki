package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.{AssignMemberContext, ExpressionContext}

class AssignMemberGenerationRule
(
	generationContext:GenerationContext, ruleContext:AssignMemberContext
) extends GenerationRule(generationContext, ruleContext)
{
	private val memberName:String = ruleContext.IDENTIFIER.getText
	private val expressionToAssign:ExpressionContext = ruleContext expression 0

	override protected def enterAction() =
		generationContext.addPostExitRuleTask(expressionToAssign, () => topMethodCall ldc memberName)

	override protected def exitAction() =
	(
		topMethodCall invokeVirtualUnitMethodSetMember ()
		decrementObjectCounter ()
	)
}

object AssignMemberGenerationRule
{
	def enter(generationContext:GenerationContext, ruleContext:AssignMemberContext):Unit =
		new AssignMemberGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:GenerationContext, ruleContext:AssignMemberContext):Unit =
		new AssignMemberGenerationRule(generationContext, ruleContext).exit()
}