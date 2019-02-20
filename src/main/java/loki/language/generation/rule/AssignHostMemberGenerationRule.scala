package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.AssignHostMemberContext

private[generation] class AssignHostMemberGenerationRule(
	generationContext:GenerationContext, assignHostMemberContext:AssignHostMemberContext
)
	extends GenerationRule(generationContext, assignHostMemberContext)
{
	private val hostMemberName = assignHostMemberContext.IDENTIFIER.getText

	override protected def enterAction():Unit = (
		topMethodCall aloadUnitMethodCallParameterHost ()
		ldc hostMemberName
	)

	override protected def exitAction():Unit = topMethodCall invokeVirtualUnitMethodSetMember ()
}


private[generation] object AssignHostMemberGenerationRule
{
	def enter(generationContext:GenerationContext, assignHostMemberContext:AssignHostMemberContext):Unit =
		new AssignHostMemberGenerationRule(generationContext, assignHostMemberContext).enter()

	def exit(generationContext:GenerationContext, assignHostMemberContext:AssignHostMemberContext):Unit =
		new AssignHostMemberGenerationRule(generationContext, assignHostMemberContext).exit()
}