package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.rules.mixins.AssignHostMemberGenerationRuleMixin
import loki.language.parsing.LokiParser.AssignHostMemberContext

class AssignHostMemberBytecodeGenerationRule
(
	generationContext:BytecodeGenerationContext, ruleContext:AssignHostMemberContext
) extends BytecodeGenerationRule(generationContext, ruleContext) with AssignHostMemberGenerationRuleMixin
{
	override protected def enterAction() =
	(
		topMethodCall aloadUnitMethodCallParameterHost ()
		ldc hostMemberName
	)

	override protected def exitAction() = topMethodCall invokeVirtualUnitMethodSetMember ()
}


object AssignHostMemberBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:AssignHostMemberContext):Unit =
		new AssignHostMemberBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:AssignHostMemberContext):Unit =
		new AssignHostMemberBytecodeGenerationRule(generationContext, ruleContext).exit()
}