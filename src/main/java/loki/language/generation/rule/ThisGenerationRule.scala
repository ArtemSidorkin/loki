package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.parsing.LokiParser.ThisContext

private[generation] class ThisGenerationRule(thisContext:ThisContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(thisContext)
{
	override protected def enterAction():Unit = (
		topMethodCall
			aloadthis ()
			incrementObjectCounter ()
	)
}

private[generation] object ThisGenerationRule
{
	def enter(thisContext:ThisContext)(implicit generationContext:GenerationContext):Unit =
		new ThisGenerationRule(thisContext).enter()

	def exit(thisContext:ThisContext)(implicit generationContext:GenerationContext):Unit =
		new ThisGenerationRule(thisContext).exit()
}