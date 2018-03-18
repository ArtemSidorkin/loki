package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.mixin.AssignMemberAccessorGenerationRuleMixin
import loki.language.parsing.LokiParser.AssignMemberAccessorContext

class AssignMemberAccessorBytecodeGenerationRule(
	bytecodeGenerationContext:BytecodeGenerationContext, assignMemberAccessorContext:AssignMemberAccessorContext
)
	extends BytecodeGenerationRule(bytecodeGenerationContext, assignMemberAccessorContext)
		with AssignMemberAccessorGenerationRuleMixin
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
}