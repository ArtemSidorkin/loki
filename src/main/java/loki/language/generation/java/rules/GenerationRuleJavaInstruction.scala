package loki.language.generation.java.rules

import loki.language.generation.java.CGenerationJava.CGenerationContextJava
import loki.language.parsing.LokiParser.InstructionContext

class GenerationRuleJavaInstruction(generationContext:CGenerationContextJava, ruleContext:InstructionContext)
	extends GenerationRuleJava(generationContext, ruleContext)
{
	override protected def exitAction()
	{
		removeLastNewLineIfPresent()
		addSemicolon()
		addNewLine()
	}
}

object GenerationRuleJavaInstruction
{
	def enter(generationContext:CGenerationContextJava, ruleContext:InstructionContext):Unit =
		new GenerationRuleJavaInstruction(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:InstructionContext):Unit =
		new GenerationRuleJavaInstruction(generationContext, ruleContext).exit()
}