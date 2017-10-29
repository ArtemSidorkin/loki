package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationAssignHostMember
import cloki.language.parsing.CLokiParser.AssignHostMemberContext

private[java] object CRuleGenerationJavaAssignHostMember extends CRuleGenerationJava[AssignHostMemberContext]
{
	protected class CCoreJavaAssignHostMember
	(
		generationContext:CGenerationContextJava, ruleContext:AssignHostMemberContext
	) extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationAssignHostMember
	{
		override def enter() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
			s"""$UNIT__METHOD__CALL__PARAMETER__HOST.$UNIT__METHOD__SET_MEMBER("$hostMemberName", """
		)

		override def exit() = addRightParenthesis()
	}

	override protected def getCore(generationContext:CGenerationContextJava, ruleContext:AssignHostMemberContext) =
		new CCoreJavaAssignHostMember(generationContext, ruleContext)
}

