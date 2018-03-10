package loki.language.generation.java.rule

import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rule.mixin.StringGenerationRuleMixin
import loki.language.parsing.LokiParser
import loki.runtime.datatype.LString

class StringGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:LokiParser.StringContext)
	extends GenerationJavaRule(generationContext, ruleContext) with StringGenerationRuleMixin
{
	override protected def enterAction() =
	{
		val prprdStr = string split "\n" map (str => s""""${str.init}"""") mkString """ + "\n" + """
		(addCode _ compose tabulateIfLastCharacterIsNewLine) (s"new ${classOf[LString].getName}($prprdStr)")
	}
}

object StringGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:LokiParser.StringContext):Unit =
		new StringGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:LokiParser.StringContext):Unit =
		new StringGenerationJavaRule(generationContext, ruleContext).exit()
}