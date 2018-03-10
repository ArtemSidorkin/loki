package loki.language.generation.java.rule

import loki.language.generation.constant.LanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.parsing.LokiParser.HostContext

class HostGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:HostContext)
	extends GenerationJavaRule(generationContext, ruleContext)
{
	override protected def enterAction() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
		s"$UNIT__METHOD__CALL__PARAMETER__HOST"
	)
}

object HostGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:HostContext):Unit =
		new HostGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:HostContext):Unit =
		new HostGenerationJavaRule(generationContext, ruleContext).exit()
}