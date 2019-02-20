package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.parsing.LokiParser.ThisContext

private[generation] class ThisGenerationRule(generationContext:GenerationContext, ruleContext:ThisContext)
	extends GenerationRule(generationContext, ruleContext)
{
	override protected def enterAction():Unit = (
		topMethodCall
			aloadthis ()
			incrementObjectCounter ()
	)
}

private[generation] object ThisGenerationRule
{
	def enter(generationContext:GenerationContext, thisContext:ThisContext):Unit =
		new ThisGenerationRule(generationContext, thisContext).enter()

	def exit(generationContext:GenerationContext, thisContext:ThisContext):Unit =
		new ThisGenerationRule(generationContext, thisContext).exit()
}