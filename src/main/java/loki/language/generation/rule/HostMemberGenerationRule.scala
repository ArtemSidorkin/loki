package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.HostMemberContext

private[generation] class HostMemberGenerationRule(generationContext:GenerationContext, ruleContext:HostMemberContext)
	extends GenerationRule(generationContext, ruleContext)
{
	private val hostMemberName = ruleContext.IDENTIFIER.getText

	override protected def enterAction():Unit =
	(
		topMethodCall
			aloadUnitMethodCallParameterHost ()
			ldc hostMemberName
			invokeVirtualUnitMethodGetMember ()
			incrementObjectCounter ()
	)
}

private[generation] object HostMemberGenerationRule
{
	def enter(generationContext:GenerationContext, ruleContext:HostMemberContext):Unit =
		new HostMemberGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:GenerationContext, ruleContext:HostMemberContext):Unit =
		new HostMemberGenerationRule(generationContext, ruleContext).exit()
}