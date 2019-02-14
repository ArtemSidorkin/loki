package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.parsing.LokiParser.ThisContext

class ThisGenerationRule(generationContext:GenerationContext, ruleContext:ThisContext)
	extends GenerationRule(generationContext, ruleContext)
{
	override protected def enterAction() =
	(
		topMethodCall aloadthis ()
		incrementObjectCounter ()
	)
}

object ThisGenerationRule
{
	def enter(generationContext:GenerationContext, ruleContext:ThisContext):Unit =
		new ThisGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:GenerationContext, ruleContext:ThisContext):Unit =
		new ThisGenerationRule(generationContext, ruleContext).exit()
}