package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationAssignMember
import cloki.language.parsing.LokiParser.AssignMemberContext

class GenerationRuleJavaAssignMember(generationContext:CGenerationContextJava, ruleContext:AssignMemberContext)
	extends GenerationRuleJava(generationContext, ruleContext) with CMixinRuleGenerationAssignMember
{
	override def __enter() = generationContext.addPostExitRuleTask(expressionToAssign, () =>
		addCode(s""".$UNIT__METHOD__SET_MEMBER("$memberName", """)
	)

	override def __exit()
	{
		removeLastNewLineIfPresent()
		addRightParenthesis()
	}
}
