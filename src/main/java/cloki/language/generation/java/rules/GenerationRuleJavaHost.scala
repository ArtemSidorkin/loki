package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.parsing.LokiParser.HostContext

class GenerationRuleJavaHost(generationContext:CGenerationContextJava, ruleContext:HostContext)
	extends GenerationRuleJava(generationContext, ruleContext)
{
	override def __enter() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
		s"$UNIT__METHOD__CALL__PARAMETER__HOST"
	)
}
