package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rules.mixins.AssignIndexGenerationRuleMixin
import loki.language.parsing.LokiParser.AssignIndexContext
import loki.runtime.datatype.LUnit

class AssignIndexGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:AssignIndexContext)
	extends GenerationJavaRule(generationContext, ruleContext) with AssignIndexGenerationRuleMixin
{
	override protected def enterAction()
	{
		generationContext.addPostExitRuleTask(hostExpression, () =>
		{
			addCode(s".$UNIT__METHOD__SET_INDEXED_ITEM(")

			if (parametersCount > 0) addCode(s"new ${classOf[LUnit].getName}[]{")
			else addCode("null");
		})

		for (i <- 0 until parametersCount - 1) generationContext.addPostExitRuleTask(getParameterExpression(i), () =>
		{
			addComa()
			addSpace()
		})
	}

	override protected def exitAction()
	{
		if (parametersCount > 0) addRightBrace()
		addRightParenthesis()
	}
}

object AssignIndexGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:AssignIndexContext):Unit =
		new AssignIndexGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:AssignIndexContext):Unit =
		new AssignIndexGenerationJavaRule(generationContext, ruleContext).exit()
}