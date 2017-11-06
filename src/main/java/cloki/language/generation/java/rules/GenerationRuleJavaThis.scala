package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.parsing.LokiParser.ThisContext

class GenerationRuleJavaThis(generationContext:CGenerationContextJava, ruleContext:ThisContext)
	extends GenerationRuleJava(generationContext, ruleContext)
{
	override protected def enterAction() = (addCode _ compose tabulateIfLastCharacterIsNewLine) ("this")
}

object GenerationRuleJavaThis
{
	def enter(generationContext:CGenerationContextJava, ruleContext:ThisContext):Unit =
		new GenerationRuleJavaThis(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:ThisContext):Unit =
		new GenerationRuleJavaThis(generationContext, ruleContext).exit()
}