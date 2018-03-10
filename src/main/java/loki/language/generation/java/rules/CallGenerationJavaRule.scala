package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rules.mixins.CallGenerationRuleMixin
import loki.language.parsing.LokiParser.CallContext
import loki.runtime.datatype.LUnit

class CallGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:CallContext)
	extends GenerationJavaRule(generationContext, ruleContext) with CallGenerationRuleMixin
{
	override protected def enterAction() = generationContext.addPostExitRuleTask(callExpression, () =>
	{
		removeLastNewLineIfPresent()
		addCode(s".$UNIT__METHOD__CALL($UNIT__METHOD__CALL__PARAMETER__HOST, new ${classOf[LUnit].getName}[]{")

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

object CallGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:CallContext):Unit =
		new CallGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:CallContext):Unit =
		new CallGenerationJavaRule(generationContext, ruleContext).exit()
}