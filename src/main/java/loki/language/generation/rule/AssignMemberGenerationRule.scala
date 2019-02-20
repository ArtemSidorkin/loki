package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.{AssignMemberContext, ExpressionContext}

private[generation] class AssignMemberGenerationRule(
	generationContext:GenerationContext, assignMemberContext:AssignMemberContext
)
	extends GenerationRule(generationContext, assignMemberContext)
{
	private val memberName:String = assignMemberContext.IDENTIFIER.getText
	private val expressionContextToAssign:ExpressionContext = assignMemberContext expression 0

	override protected def enterAction():Unit =
		generationContext.addPostExitRuleTask(expressionContextToAssign, () => topMethodCall ldc memberName)

	override protected def exitAction():Unit = (
		topMethodCall
			invokeVirtualUnitMethodSetMember ()
			decrementObjectCounter ()
	)
}

private[generation] object AssignMemberGenerationRule
{
	def enter(generationContext:GenerationContext, assignMemberContext:AssignMemberContext):Unit =
		new AssignMemberGenerationRule(generationContext, assignMemberContext).enter()

	def exit(generationContext:GenerationContext, assignMemberContext:AssignMemberContext):Unit =
		new AssignMemberGenerationRule(generationContext, assignMemberContext).exit()
}