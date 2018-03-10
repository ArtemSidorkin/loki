package loki.language.generation.java.rule

import loki.language.generation.constant.LanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rule.mixin.AssignHostMemberGenerationRuleMixin
import loki.language.parsing.LokiParser.AssignHostMemberContext

class AssignHostMemberGenerationJavaRule
(
	generationContext:JavaGenerationContext, ruleContext:AssignHostMemberContext
) extends GenerationJavaRule(generationContext, ruleContext) with AssignHostMemberGenerationRuleMixin
{
	override protected def enterAction() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
		s"""$UNIT__METHOD__CALL__PARAMETER__HOST.$UNIT__METHOD__SET_MEMBER("$hostMemberName", """
	)

	override protected def exitAction() = addRightParenthesis()
}

object AssignHostMemberGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:AssignHostMemberContext):Unit =
		new AssignHostMemberGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:AssignHostMemberContext):Unit =
		new AssignHostMemberGenerationJavaRule(generationContext, ruleContext).exit()
}