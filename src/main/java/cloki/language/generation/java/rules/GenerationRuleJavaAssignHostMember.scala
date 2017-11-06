package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationAssignHostMember
import cloki.language.parsing.LokiParser.AssignHostMemberContext

class GenerationRuleJavaAssignHostMember
(
	generationContext:CGenerationContextJava, ruleContext:AssignHostMemberContext
) extends GenerationRuleJava(generationContext, ruleContext) with CMixinRuleGenerationAssignHostMember
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