package loki.language.generation.java.rule

import loki.language.generation.constant.LanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rule.mixin.HostMemberGenerationRuleMixin
import loki.language.parsing.LokiParser.HostMemberContext

class HostMemberGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:HostMemberContext)
	extends GenerationJavaRule(generationContext, ruleContext) with HostMemberGenerationRuleMixin
{
	override protected def enterAction() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
		s"""$UNIT__METHOD__CALL__PARAMETER__HOST.$UNIT__METHOD__GET_MEMBER("$hostMemberName")"""
	)
}

object HostMemberGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:HostMemberContext):Unit =
		new HostMemberGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:HostMemberContext):Unit =
		new HostMemberGenerationJavaRule(generationContext, ruleContext).exit()
}