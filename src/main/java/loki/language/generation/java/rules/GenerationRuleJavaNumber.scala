package loki.language.generation.java.rules

import loki.language.generation.java.CGenerationJava.CGenerationContextJava
import loki.language.generation.rules.mixins.NumberGenerationRuleMixin
import loki.language.parsing.LokiParser.NumberContext
import loki.runtime.datatype.number.LNumber

class GenerationRuleJavaNumber(generationContext:CGenerationContextJava, ruleContext:NumberContext)
	extends GenerationRuleJava(generationContext, ruleContext) with NumberGenerationRuleMixin
{
	override protected def enterAction() =
		(addCode _ compose tabulateIfLastCharacterIsNewLine) (s"new ${classOf[LNumber].getName}($number)")
}

object GenerationRuleJavaNumber
{
	def enter(generationContext:CGenerationContextJava, ruleContext:NumberContext):Unit =
		new GenerationRuleJavaNumber(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:NumberContext):Unit =
		new GenerationRuleJavaNumber(generationContext, ruleContext).exit()
}