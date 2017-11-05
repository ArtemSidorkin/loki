package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationAssignHostMember
import cloki.language.parsing.LokiParser.AssignHostMemberContext

class CCoreJavaAssignHostMember
(
	generationContext:CGenerationContextJava, ruleContext:AssignHostMemberContext
) extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationAssignHostMember
{
	override def enter() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
		s"""$UNIT__METHOD__CALL__PARAMETER__HOST.$UNIT__METHOD__SET_MEMBER("$hostMemberName", """
	)

	override def exit() = addRightParenthesis()
}
