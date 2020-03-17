package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.parsing.LokiParser.InstructionContext

private[generation] class InstructionGenerationRule
	(instructionContext:InstructionContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(instructionContext)
{
	override protected def enterAction():Unit = topMethodCall.pushFrame()
	override protected def exitAction():Unit = topMethodCall.popFrame()
}

private[generation] object InstructionGenerationRule
{
	def enter(instructionContext:InstructionContext)(implicit generationContext:GenerationContext):Unit =
		new InstructionGenerationRule(instructionContext).enter()

	def exit(instructionContext:InstructionContext)(implicit generationContext:GenerationContext):Unit =
		new InstructionGenerationRule(instructionContext).exit()
}