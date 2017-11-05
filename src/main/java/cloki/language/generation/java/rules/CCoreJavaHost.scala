package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.parsing.LokiParser.HostContext

class CCoreJavaHost(generationContext:CGenerationContextJava, ruleContext:HostContext)
	extends CCoreJava(generationContext, ruleContext)
{
	override def enter() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
		s"$UNIT__METHOD__CALL__PARAMETER__HOST"
	)
}
