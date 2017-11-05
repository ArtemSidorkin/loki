package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.parsing.LokiParser.ThisContext

class CCoreJavaThis(generationContext:CGenerationContextJava, ruleContext:ThisContext)
	extends CCoreJava(generationContext, ruleContext)
{
	override def enter() = (addCode _ compose tabulateIfLastCharacterIsNewLine) ("this")
}
