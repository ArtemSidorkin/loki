package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rules.mixins.AssignMemberGenerationRuleMixin
import loki.language.parsing.LokiParser.AssignMemberContext

class AssignMemberGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:AssignMemberContext)
	extends GenerationJavaRule(generationContext, ruleContext) with AssignMemberGenerationRuleMixin
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

object AssignMemberGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:AssignMemberContext):Unit =
		new AssignMemberGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:AssignMemberContext):Unit =
		new AssignMemberGenerationJavaRule(generationContext, ruleContext).exit()
}