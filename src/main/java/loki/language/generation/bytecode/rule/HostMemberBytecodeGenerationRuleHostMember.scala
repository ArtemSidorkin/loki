package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.mixin.HostMemberGenerationRuleMixin
import loki.language.parsing.LokiParser.HostMemberContext

class HostMemberBytecodeGenerationRuleHostMember(generationContext:BytecodeGenerationContext, ruleContext:HostMemberContext)
	extends BytecodeGenerationRule(generationContext, ruleContext) with HostMemberGenerationRuleMixin
{
	override protected def enterAction() =
	(
		topMethodCall
		aloadUnitMethodCallParameterHost ()
		ldc hostMemberName
		invokeVirtualUnitMethodGetMember ()
		incrementObjectCounter ()
	)
}

object HostMemberBytecodeGenerationRuleHostMember
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:HostMemberContext):Unit =
		new HostMemberBytecodeGenerationRuleHostMember(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:HostMemberContext):Unit =
		new HostMemberBytecodeGenerationRuleHostMember(generationContext, ruleContext).exit()
}