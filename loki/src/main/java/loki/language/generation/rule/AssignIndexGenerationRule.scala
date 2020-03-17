package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.AssignIndexContext

private[generation] class AssignIndexGenerationRule
	(assignIndexContext:AssignIndexContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(assignIndexContext)
{
	override protected def exitAction():Unit = topMethodCall.invokeVirtualUnitMethodSetIndexedItem()
}

private[generation] object AssignIndexGenerationRule
{
	def enter(assignIndexContext:AssignIndexContext)(implicit generationContext:GenerationContext):Unit =
		new AssignIndexGenerationRule(assignIndexContext).enter()

	def exit(assignIndexContext:AssignIndexContext)(implicit generationContext:GenerationContext):Unit =
		new AssignIndexGenerationRule(assignIndexContext).exit()
}