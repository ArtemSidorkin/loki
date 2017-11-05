package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationNumber
import cloki.language.parsing.LokiParser.NumberContext
import cloki.runtime.datatype.LNumber

class GenerationRuleJavaNumber(generationContext:CGenerationContextJava, ruleContext:NumberContext)
	extends GenerationRuleJava(generationContext, ruleContext) with CMixinRuleGenerationNumber
{
	override def __enter() =
		(addCode _ compose tabulateIfLastCharacterIsNewLine) (s"new ${classOf[LNumber].getName}($number)")
}
