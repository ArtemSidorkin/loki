package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.HostContext

class HostGenerationRule(generationContext:GenerationContext, ruleContext:HostContext)
	extends GenerationRule(generationContext, ruleContext)
{
	override protected def enterAction() =
	(
		topMethodCall aloadUnitMethodCallParameterHost ()
		incrementObjectCounter ()
	)
}

object HostGenerationRule
{
	def enter(generationContext:GenerationContext, ruleContext:HostContext):Unit =
		new HostGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:GenerationContext, ruleContext:HostContext):Unit =
		new HostGenerationRule(generationContext, ruleContext).exit()
}