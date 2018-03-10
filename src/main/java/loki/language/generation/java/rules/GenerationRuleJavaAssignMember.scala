package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.CGenerationJava.CGenerationContextJava
import loki.language.generation.rules.mixins.AssignMemberGenerationRuleMixin
import loki.language.parsing.LokiParser.AssignMemberContext

class GenerationRuleJavaAssignMember(generationContext:CGenerationContextJava, ruleContext:AssignMemberContext)
	extends GenerationRuleJava(generationContext, ruleContext) with AssignMemberGenerationRuleMixin
{
	override protected def enterAction() = generationContext.addPostExitRuleTask(expressionToAssign, () =>
		addCode(s""".$UNIT__METHOD__SET_MEMBER("$memberName", """)
	)

	override protected def exitAction()
	{
		removeLastNewLineIfPresent()
		addRightParenthesis()
	}
}

object GenerationRuleJavaAssignMember
{
	def enter(generationContext:CGenerationContextJava, ruleContext:AssignMemberContext):Unit =
		new GenerationRuleJavaAssignMember(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:AssignMemberContext):Unit =
		new GenerationRuleJavaAssignMember(generationContext, ruleContext).exit()
}