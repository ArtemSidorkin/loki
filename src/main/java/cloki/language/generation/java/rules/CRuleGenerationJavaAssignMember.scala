package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationAssignMember
import cloki.language.parsing.LokiParser.AssignMemberContext

private[java] object CRuleGenerationJavaAssignMember extends CRuleGenerationJava[AssignMemberContext]
{
	protected class CCoreJavaAssignMember(generationContext:CGenerationContextJava, ruleContext:AssignMemberContext)
		extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationAssignMember
	{
		override def enter() = generationContext.addPostExitRuleTask(expressionToAssign, () =>
			addCode(s""".$UNIT__METHOD__SET_MEMBER("$memberName", """)
		)

		override def exit()
		{
			removeLastNewLineIfPresent()
			addRightParenthesis()
		}
	}

	override protected def getCore(generationContext:CGenerationContextJava, ruleContext:AssignMemberContext) =
		new CCoreJavaAssignMember(generationContext, ruleContext)
}
