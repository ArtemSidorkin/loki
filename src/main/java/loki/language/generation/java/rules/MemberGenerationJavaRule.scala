package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rules.mixins.MemberGenerationRuleMixin
import loki.language.parsing.LokiParser.MemberContext

class MemberGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:MemberContext)
	extends GenerationJavaRule(generationContext, ruleContext) with MemberGenerationRuleMixin
{
	override protected def enterAction() = generationContext.addPostExitRuleTask(
		ruleContext.expression, () => addCode(s""".$UNIT__METHOD__GET_MEMBER("$memberName")""")
	)
}

object MemberGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:MemberContext):Unit =
		new MemberGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:MemberContext):Unit =
		new MemberGenerationJavaRule(generationContext, ruleContext).exit()
}