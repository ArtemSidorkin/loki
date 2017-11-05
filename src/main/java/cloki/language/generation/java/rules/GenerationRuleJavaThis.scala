package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.parsing.LokiParser.ThisContext

class GenerationRuleJavaThis(generationContext:CGenerationContextJava, ruleContext:ThisContext)
	extends GenerationRuleJava(generationContext, ruleContext)
{
	override def __enter() = (addCode _ compose tabulateIfLastCharacterIsNewLine) ("this")
}
