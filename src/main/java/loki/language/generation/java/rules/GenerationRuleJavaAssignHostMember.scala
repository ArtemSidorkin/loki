package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.CGenerationJava.CGenerationContextJava
import loki.language.generation.rules.mixins.AssignHostMemberGenerationRuleMixin
import loki.language.parsing.LokiParser.AssignHostMemberContext

class GenerationRuleJavaAssignHostMember
(
	generationContext:CGenerationContextJava, ruleContext:AssignHostMemberContext
) extends GenerationRuleJava(generationContext, ruleContext) with AssignHostMemberGenerationRuleMixin
{
	override protected def enterAction() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
		s"""$UNIT__METHOD__CALL__PARAMETER__HOST.$UNIT__METHOD__SET_MEMBER("$hostMemberName", """
	)

	override protected def exitAction() = addRightParenthesis()
}

object GenerationRuleJavaAssignHostMember
{
	def enter(generationContext:CGenerationContextJava, ruleContext:AssignHostMemberContext):Unit =
		new GenerationRuleJavaAssignHostMember(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:AssignHostMemberContext):Unit =
		new GenerationRuleJavaAssignHostMember(generationContext, ruleContext).exit()
}