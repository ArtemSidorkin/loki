package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.parsing.CLokiParser.InstructionContext

private[java] object CRuleGenerationJavaInstruction extends CRuleGenerationJava[InstructionContext]
{
	protected class CCoreJavaInstruction(generationContext:CGenerationContextJava, ruleContext:InstructionContext)
		extends CCoreJava(generationContext, ruleContext)
	{
		override def exit()
		{
			removeLastNewLineIfPresent()
			addSemicolon()
			addNewLine()
		}
	}

	override def getCore(generationContext:CGenerationContextJava, ruleContext:InstructionContext) =
		new CCoreJavaInstruction(generationContext, ruleContext)
}
