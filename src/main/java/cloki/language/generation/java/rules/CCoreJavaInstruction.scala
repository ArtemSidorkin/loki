package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.parsing.LokiParser.InstructionContext

class CCoreJavaInstruction(generationContext:CGenerationContextJava, ruleContext:InstructionContext)
	extends CCoreJava(generationContext, ruleContext)
{
	override def exit()
	{
		removeLastNewLineIfPresent()
		addSemicolon()
		addNewLine()
	}
}
