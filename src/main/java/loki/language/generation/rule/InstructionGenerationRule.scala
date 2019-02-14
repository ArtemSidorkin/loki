package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.parsing.LokiParser.InstructionContext

class InstructionGenerationRule(generationContext:GenerationContext, ruleContext:InstructionContext)
	extends GenerationRule(generationContext, ruleContext)
{
	override protected def enterAction() = topMethodCall pushFrame ()
	override protected def exitAction() = topMethodCall popFrame ()
}

object InstructionGenerationRule
{
	def enter(generationContext:GenerationContext, ruleContext:InstructionContext):Unit =
		new InstructionGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:GenerationContext, ruleContext:InstructionContext):Unit =
		new InstructionGenerationRule(generationContext, ruleContext).exit()
}