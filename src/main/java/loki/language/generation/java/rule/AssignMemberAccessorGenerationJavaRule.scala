package loki.language.generation.java.rule

import loki.language.generation.constant.LanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rule.mixin.AssignMemberAccessorGenerationRuleMixin
import loki.language.parsing.LokiParser.AssignMemberAccessorContext

class AssignMemberAccessorGenerationJavaRule(
	javaGenerationContext:JavaGenerationContext, assignMemberAccessorContext:AssignMemberAccessorContext
)
	extends GenerationJavaRule(javaGenerationContext, assignMemberAccessorContext)
		with AssignMemberAccessorGenerationRuleMixin
{
	override protected def enterAction()
	{
		val hostExpression = ruleContext expression 0

		javaGenerationContext.addPostExitRuleTask(hostExpression, () =>	addCode(s".$UNIT__METHOD__SET_MEMBER("))

		javaGenerationContext
			.addPostExitRuleTask(memberNameExpression, () => addCode(s".$UNIT__METHOD__TO_STRING(), "))
	}

	override protected def exitAction():Unit = addRightParenthesis()
}
