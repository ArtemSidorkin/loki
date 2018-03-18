package loki.language.generation.java.rule

import loki.language.generation.constant.LanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.parsing.LokiParser.MemberAccessorContext

class MemberAccessorGenerationJavaRule(
	javaGenerationContext:JavaGenerationContext, memberAccessorContext:MemberAccessorContext
)
	extends GenerationJavaRule(javaGenerationContext, memberAccessorContext)
{
	override protected def enterAction()
	{
		val hostExpression = ruleContext expression 0
		javaGenerationContext.addPostExitRuleTask(hostExpression, () =>	addCode(s".$UNIT__METHOD__GET_MEMBER("))
	}

	override protected def exitAction():Unit = addCode(s".$UNIT__METHOD__TO_STRING()")
}