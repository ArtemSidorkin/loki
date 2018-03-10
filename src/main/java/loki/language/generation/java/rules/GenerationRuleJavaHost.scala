package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.CGenerationJava.CGenerationContextJava
import loki.language.parsing.LokiParser.HostContext

class GenerationRuleJavaHost(generationContext:CGenerationContextJava, ruleContext:HostContext)
	extends GenerationRuleJava(generationContext, ruleContext)
{
	override protected def enterAction() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
		s"$UNIT__METHOD__CALL__PARAMETER__HOST"
	)
}

object GenerationRuleJavaHost
{
	def enter(generationContext:CGenerationContextJava, ruleContext:HostContext):Unit =
		new GenerationRuleJavaHost(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:HostContext):Unit =
		new GenerationRuleJavaHost(generationContext, ruleContext).exit()
}