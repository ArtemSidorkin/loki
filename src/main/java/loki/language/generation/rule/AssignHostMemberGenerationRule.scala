package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.AssignHostMemberContext

class AssignHostMemberGenerationRule
(
	generationContext:GenerationContext, ruleContext:AssignHostMemberContext
) extends GenerationRule(generationContext, ruleContext)
{
	protected val hostMemberName = ruleContext.IDENTIFIER.getText

	override protected def enterAction() =
	(
		topMethodCall aloadUnitMethodCallParameterHost ()
		ldc hostMemberName
	)

	override protected def exitAction() = topMethodCall invokeVirtualUnitMethodSetMember ()
}


object AssignHostMemberGenerationRule
{
	def enter(generationContext:GenerationContext, ruleContext:AssignHostMemberContext):Unit =
		new AssignHostMemberGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:GenerationContext, ruleContext:AssignHostMemberContext):Unit =
		new AssignHostMemberGenerationRule(generationContext, ruleContext).exit()
}