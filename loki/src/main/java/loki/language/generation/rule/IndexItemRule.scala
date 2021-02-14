package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.IndexItemContext

private[generation] class IndexItemRule(indexItemContext:IndexItemContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(indexItemContext)
{
	override protected def exitAction():Unit = topMethodCall.invokeVirtualUnitMethodGetIndexedItem()
}