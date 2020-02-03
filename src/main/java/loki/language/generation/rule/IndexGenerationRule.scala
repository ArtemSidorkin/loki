package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.IndexContext

private[generation] class IndexGenerationRule(generationContext:GenerationContext, indexContext:IndexContext)
	extends GenerationRule(generationContext, indexContext)
{
	override protected def exitAction():Unit = topMethodCall invokeVirtualUnitMethodGetIndexedItem()
}

private[generation] object IndexGenerationRule
{
	def enter(generationContext:GenerationContext, indexContext:IndexContext):Unit =
		new IndexGenerationRule(generationContext, indexContext).enter()

	def exit(generationContext:GenerationContext, indexContext:IndexContext):Unit =
		new IndexGenerationRule(generationContext, indexContext).exit()
}