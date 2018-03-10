package loki.language.generation.java.rule

import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.parsing.LokiParser.InstructionContext

class InstructionGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:InstructionContext)
	extends GenerationJavaRule(generationContext, ruleContext)
{
	override protected def exitAction()
	{
		removeLastNewLineIfPresent()
		addSemicolon()
		addNewLine()
	}
}

object InstructionGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:InstructionContext):Unit =
		new InstructionGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:InstructionContext):Unit =
		new InstructionGenerationJavaRule(generationContext, ruleContext).exit()
}