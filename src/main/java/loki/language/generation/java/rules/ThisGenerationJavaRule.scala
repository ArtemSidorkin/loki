package loki.language.generation.java.rules

import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.parsing.LokiParser.ThisContext

class ThisGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:ThisContext)
	extends GenerationJavaRule(generationContext, ruleContext)
{
	override protected def enterAction() = (addCode _ compose tabulateIfLastCharacterIsNewLine) ("this")
}

object ThisGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:ThisContext):Unit =
		new ThisGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:ThisContext):Unit =
		new ThisGenerationJavaRule(generationContext, ruleContext).exit()
}