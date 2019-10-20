package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.HostMemberContext


private[generation] class HostMemberGenerationRule(
	generationContext:GenerationContext, hostMemberContext:HostMemberContext
)
	extends GenerationRule(generationContext, hostMemberContext)
{
	private def hostMemberName = ruleContext.IDENTIFIER.getText

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
	def enter(generationContext:GenerationContext, hostMemberContext:HostMemberContext):Unit =
		new HostMemberGenerationRule(generationContext, hostMemberContext).enter()

	def exit(generationContext:GenerationContext, hostMemberContext:HostMemberContext):Unit =
		new HostMemberGenerationRule(generationContext, hostMemberContext).exit()
}