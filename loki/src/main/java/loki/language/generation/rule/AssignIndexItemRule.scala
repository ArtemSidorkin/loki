package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.AssignIndexItemContext

private[generation] class AssignIndexItemRule(
	assignIndexContext:AssignIndexItemContext
)(
	implicit generationContext:GenerationContext
)
	extends GenerationRule(assignIndexContext)
{
	override protected def exitAction():Unit = topMethodCall.invokeVirtualUnitSetIndexedItemMethod()
}