package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.mixin.AssignHostMemberGenerationRuleMixin
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