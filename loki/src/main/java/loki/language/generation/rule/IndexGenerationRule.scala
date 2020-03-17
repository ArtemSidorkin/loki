package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.IndexContext

private[generation] class IndexGenerationRule(indexContext:IndexContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(indexContext)
{
	override protected def exitAction():Unit = topMethodCall.invokeVirtualUnitMethodGetIndexedItem()
}

private[generation] object IndexGenerationRule
{
	def enter(indexContext:IndexContext)(implicit generationContext:GenerationContext):Unit =
		new IndexGenerationRule(indexContext).enter()

	def exit(indexContext:IndexContext)(implicit generationContext:GenerationContext):Unit =
		new IndexGenerationRule(indexContext).exit()
}