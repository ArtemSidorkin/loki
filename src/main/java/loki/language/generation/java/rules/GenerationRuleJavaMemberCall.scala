package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.CGenerationJava.CGenerationContextJava
import loki.language.generation.rules.mixins.MemberCallGenerationRuleMixin
import loki.language.parsing.LokiParser.MemberCallContext
import loki.runtime.datatype.LUnit

class GenerationRuleJavaMemberCall(generationContext:CGenerationContextJava, ruleContext:MemberCallContext)
	extends GenerationRuleJava(generationContext, ruleContext) with MemberCallGenerationRuleMixin
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

object GenerationRuleJavaMemberCall
{
	def enter(generationContext:CGenerationContextJava, ruleContext:MemberCallContext):Unit =
		new GenerationRuleJavaMemberCall(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:MemberCallContext):Unit =
		new GenerationRuleJavaMemberCall(generationContext, ruleContext).exit()
}