package loki.language.generation.java.rule

import loki.language.generation.constant.LanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rule.mixin.IndexGenerationRuleMixin
import loki.language.parsing.LokiParser.IndexContext
import loki.runtime.datatype.LUnit

class IndexGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:IndexContext)
	extends GenerationJavaRule(generationContext, ruleContext) with IndexGenerationRuleMixin
{
	override protected def enterAction()
	{
		generationContext.addPostExitRuleTask(hostExpression, () =>
		{
			addCode(s".$UNIT__METHOD__GET_INDEXED_ITEM(")

			if (indexExpressionCount > 0) addCode(s"new ${classOf[LUnit].getName}[]{")
			else addCode("null")
		})

		for (i <- 0 until indexExpressionCount - 1) generationContext.addPostExitRuleTask(getIndexExpression(i), () =>
		{
			addComa()
			addSpace()
		})
	}

	override protected def exitAction()
	{
		if (indexExpressionCount > 0) addRightBrace()
		addRightParenthesis()
	}
}

object IndexGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:IndexContext):Unit =
		new IndexGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:IndexContext):Unit =
		new IndexGenerationJavaRule(generationContext, ruleContext).exit()
}