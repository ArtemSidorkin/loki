package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.StringGenerationRuleMixin
import cloki.language.parsing.LokiParser
import cloki.runtime.datatype.LString

class GenerationRuleJavaString(generationContext:CGenerationContextJava, ruleContext:LokiParser.StringContext)
	extends GenerationRuleJava(generationContext, ruleContext) with StringGenerationRuleMixin
{
	override protected def enterAction() =
	{
		val prprdStr = string split "\n" map (str => s""""${str.init}"""") mkString """ + "\n" + """
		(addCode _ compose tabulateIfLastCharacterIsNewLine) (s"new ${classOf[LString].getName}($prprdStr)")
	}
}

object GenerationRuleJavaString
{
	def enter(generationContext:CGenerationContextJava, ruleContext:LokiParser.StringContext):Unit =
		new GenerationRuleJavaString(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:LokiParser.StringContext):Unit =
		new GenerationRuleJavaString(generationContext, ruleContext).exit()
}