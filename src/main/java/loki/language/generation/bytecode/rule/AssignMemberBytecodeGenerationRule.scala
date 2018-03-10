package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.mixin.AssignMemberGenerationRuleMixin
import loki.language.parsing.LokiParser.AssignMemberContext

class AssignMemberBytecodeGenerationRule
(
	generationContext:BytecodeGenerationContext, ruleContext:AssignMemberContext
) extends BytecodeGenerationRule(generationContext, ruleContext) with AssignMemberGenerationRuleMixin
{
	override protected def enterAction() =
		generationContext.addPostExitRuleTask(expressionToAssign, () => topMethodCall ldc memberName)

	override protected def exitAction() =
	(
		topMethodCall invokeVirtualUnitMethodSetMember ()
		decrementObjectCounter ()
	)
}

object AssignMemberBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:AssignMemberContext):Unit =
		new AssignMemberBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:AssignMemberContext):Unit =
		new AssignMemberBytecodeGenerationRule(generationContext, ruleContext).exit()
}