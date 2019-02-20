package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.parsing.LokiParser.InstructionContext

private[generation] class InstructionGenerationRule(
	generationContext:GenerationContext, instructionContext:InstructionContext
)
	extends GenerationRule(generationContext, instructionContext)
{
	override protected def enterAction():Unit = topMethodCall pushFrame ()
	override protected def exitAction():Unit = topMethodCall popFrame ()
}

private[generation] object InstructionGenerationRule
{
	def enter(generationContext:GenerationContext, instructionContext:InstructionContext):Unit =
		new InstructionGenerationRule(generationContext, instructionContext).enter()

	def exit(generationContext:GenerationContext, instructionContext:InstructionContext):Unit =
		new InstructionGenerationRule(generationContext, instructionContext).exit()
}