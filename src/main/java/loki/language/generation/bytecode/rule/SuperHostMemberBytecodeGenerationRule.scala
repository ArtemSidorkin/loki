package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.mixin.SuperHostMemberGenerationRuleMixin
import loki.language.parsing.LokiParser.SuperHostMemberContext

class SuperHostMemberBytecodeGenerationRule
(
	generationContext:BytecodeGenerationContext, ruleContext:SuperHostMemberContext
) extends BytecodeGenerationRule(generationContext, ruleContext) with SuperHostMemberGenerationRuleMixin
{
	override protected def enterAction() =
	(
		topMethodCall
		aloadUnitMethodCallParameterHost ()
		ldc superMemberName
		invokeVirtualUnitMethodGetSuperMember ()
		incrementObjectCounter ()
	)
}

object SuperHostMemberBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:SuperHostMemberContext):Unit =
		new SuperHostMemberBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:SuperHostMemberContext):Unit =
		new SuperHostMemberBytecodeGenerationRule(generationContext, ruleContext).exit()
}