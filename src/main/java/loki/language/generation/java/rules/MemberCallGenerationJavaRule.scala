package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rules.mixins.MemberCallGenerationRuleMixin
import loki.language.parsing.LokiParser.MemberCallContext
import loki.runtime.datatype.LUnit

class MemberCallGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:MemberCallContext)
	extends GenerationJavaRule(generationContext, ruleContext) with MemberCallGenerationRuleMixin
{
	override protected def enterAction() = generationContext.addPostExitRuleTask(memberExpression, () =>
	{
		addCode(s""".$UNIT__METHOD__CALL_MEMBER("$memberName", new ${classOf[LUnit].getName}[]{""")

		if (callParameterCount > 1)
			for (i <- 1 until callParameterCount)
				generationContext.addPostExitRuleTask(getCallParameterExpression(i), () =>
				{
					addComa()
					addSpace()
				})
	})

	override protected def exitAction()
	{
		removeLastNewLineIfPresent()
		addCode(s"}, $UNIT__METHOD__CALL__PARAMETER__CONTEXT)")
	}
}

object MemberCallGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:MemberCallContext):Unit =
		new MemberCallGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:MemberCallContext):Unit =
		new MemberCallGenerationJavaRule(generationContext, ruleContext).exit()
}