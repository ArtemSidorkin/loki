package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.AssignHostMemberContext

private[generation] class AssignHostMemberGenerationRule
	(assignHostMemberContext:AssignHostMemberContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(assignHostMemberContext)
{
	private def hostMemberName = assignHostMemberContext.IDENTIFIER.getText

	override protected def enterAction():Unit = (
		topMethodCall
			aloadUnitMethodCallParameterHost ()
			ldc hostMemberName
	)

	override protected def exitAction():Unit = topMethodCall invokeVirtualUnitMethodSetMember ()
}

private[generation] object AssignHostMemberGenerationRule
{
	def enter(assignHostMemberContext:AssignHostMemberContext)(implicit generationContext:GenerationContext):Unit =
		new AssignHostMemberGenerationRule(assignHostMemberContext).enter()

	def exit(assignHostMemberContext:AssignHostMemberContext)(implicit generationContext:GenerationContext):Unit =
		new AssignHostMemberGenerationRule(assignHostMemberContext).exit()
}