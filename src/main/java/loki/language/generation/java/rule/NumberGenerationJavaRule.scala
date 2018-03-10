package loki.language.generation.java.rule

import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rule.mixin.NumberGenerationRuleMixin
import loki.language.parsing.LokiParser.NumberContext
import loki.runtime.datatype.number.LNumber

class NumberGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:NumberContext)
	extends GenerationJavaRule(generationContext, ruleContext) with NumberGenerationRuleMixin
{
	override protected def enterAction() =
		(addCode _ compose tabulateIfLastCharacterIsNewLine) (s"new ${classOf[LNumber].getName}($number)")
}

object NumberGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:NumberContext):Unit =
		new NumberGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:NumberContext):Unit =
		new NumberGenerationJavaRule(generationContext, ruleContext).exit()
}