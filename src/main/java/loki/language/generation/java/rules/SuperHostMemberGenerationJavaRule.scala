package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rules.mixins.SuperHostMemberGenerationRuleMixin
import loki.language.parsing.LokiParser.SuperHostMemberContext

class SuperHostMemberGenerationJavaRule
(
	generationContext:JavaGenerationContext, ruleContext:SuperHostMemberContext
) extends GenerationJavaRule(generationContext, ruleContext) with SuperHostMemberGenerationRuleMixin
{
	override protected def enterAction() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
		s"""$UNIT__METHOD__CALL__PARAMETER__HOST.$UNIT__METHOD__GET_SUPER_MEMBER("$superMemberName")"""
	)
}

object SuperHostMemberGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:SuperHostMemberContext):Unit =
		new SuperHostMemberGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:SuperHostMemberContext):Unit =
		new SuperHostMemberGenerationJavaRule(generationContext, ruleContext).exit()
}