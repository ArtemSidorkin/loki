package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.NumberGenerationRuleMixin
import cloki.language.parsing.LokiParser.NumberContext
import cloki.runtime.datatype.number.LNumber

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