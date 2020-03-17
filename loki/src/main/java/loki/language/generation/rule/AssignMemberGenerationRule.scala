package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.{AssignMemberContext, ExpressionContext}

private[generation] class AssignMemberGenerationRule
	(assignMemberContext:AssignMemberContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(assignMemberContext)
{
	private def memberName:String = assignMemberContext.IDENTIFIER.getText
	private def expressionContextToAssign:ExpressionContext = assignMemberContext expression 0

	override protected def enterAction():Unit =
		generationContext.addPostExitRuleTask(expressionContextToAssign, () => topMethodCall ldc memberName)

	override protected def exitAction():Unit =
		topMethodCall
			.invokeVirtualUnitMethodSetMember()
			.decrementObjectCounter()
}

private[generation] object AssignMemberGenerationRule
{
	def enter(assignMemberContext:AssignMemberContext)(implicit generationContext:GenerationContext):Unit =
		new AssignMemberGenerationRule(assignMemberContext).enter()

	def exit(assignMemberContext:AssignMemberContext)(implicit generationContext:GenerationContext):Unit =
		new AssignMemberGenerationRule(assignMemberContext).exit()
}