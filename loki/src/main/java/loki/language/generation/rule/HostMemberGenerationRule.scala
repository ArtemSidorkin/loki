package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.HostMemberContext

private[generation] class HostMemberGenerationRule
	(hostMemberContext:HostMemberContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(hostMemberContext)
{
	private val hostMemberName = hostMemberContext.IDENTIFIER.getText

	override protected def enterAction():Unit =
	(
		topMethodCall
			.aloadHostParameterOfUnitCallMethod()
			.ldc(hostMemberName)
			.invokeVirtualUnitMethodGetMember()
			.incrementObjectStackCounter()
	)
}

private[generation] object HostMemberGenerationRule
{
	def enter(hostMemberContext:HostMemberContext)(implicit generationContext:GenerationContext):Unit =
		new HostMemberGenerationRule(hostMemberContext).enter()

	def exit(hostMemberContext:HostMemberContext)(implicit generationContext:GenerationContext):Unit =
		new HostMemberGenerationRule(hostMemberContext).exit()
}