package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.HostContext

private[generation] class HostGenerationRule(hostContext:HostContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(hostContext)
{
	override protected def enterAction():Unit =
		topMethodCall
			.aloadUnitMethodCallParameterHost()
			.incrementObjectStackCounter()
}

private[generation] object HostGenerationRule
{
	def enter(hostContext:HostContext)(implicit generationContext:GenerationContext):Unit =
		new HostGenerationRule(hostContext).enter()

	def exit(hostContext:HostContext)(implicit generationContext:GenerationContext):Unit =
		new HostGenerationRule(hostContext).exit()
}