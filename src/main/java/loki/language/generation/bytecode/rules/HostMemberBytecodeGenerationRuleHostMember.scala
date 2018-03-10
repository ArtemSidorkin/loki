package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.rules.mixins.HostMemberGenerationRuleMixin
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