package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.HostContext

private[generation] class HostGenerationRule(generationContext:GenerationContext, hostContext:HostContext)
	extends GenerationRule(generationContext, hostContext)
{
	override protected def enterAction():Unit = (
		topMethodCall
			aloadUnitMethodCallParameterHost ()
			incrementObjectCounter ()
	)
}

private[generation] object HostGenerationRule
{
	def enter(generationContext:GenerationContext, hostContext:HostContext):Unit =
		new HostGenerationRule(generationContext, hostContext).enter()

	def exit(generationContext:GenerationContext, hostContext:HostContext):Unit =
		new HostGenerationRule(generationContext, hostContext).exit()
}