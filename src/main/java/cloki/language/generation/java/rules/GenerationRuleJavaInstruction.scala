package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.parsing.LokiParser.InstructionContext

class GenerationRuleJavaInstruction(generationContext:CGenerationContextJava, ruleContext:InstructionContext)
	extends GenerationRuleJava(generationContext, ruleContext)
{
	override def __exit()
	{
		removeLastNewLineIfPresent()
		addSemicolon()
		addNewLine()
	}
}
