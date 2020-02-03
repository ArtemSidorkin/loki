package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.AssignIndexContext

private[generation] class AssignIndexGenerationRule(generationContext:GenerationContext, assignIndexContext:AssignIndexContext)
	extends GenerationRule(generationContext, assignIndexContext)
{
	override protected def exitAction():Unit = topMethodCall invokeVirtualUnitMethodSetIndexedItem()
}

private[generation] object AssignIndexGenerationRule
{
	def enter(generationContext:GenerationContext, assignIndexContext:AssignIndexContext):Unit =
		new AssignIndexGenerationRule(generationContext, assignIndexContext).enter()

	def exit(generationContext:GenerationContext, assignIndexContext:AssignIndexContext):Unit =
		new AssignIndexGenerationRule(generationContext, assignIndexContext).exit()
}