package loki.language.generation.java.rule

import loki.language.generation.constant.LanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rule.mixin.UnaryOperationGenerationRuleMixin
import loki.language.parsing.LokiParser.UnaryOperationContext

class UnaryOperationGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:UnaryOperationContext)
	extends GenerationJavaRule(generationContext, ruleContext) with UnaryOperationGenerationRuleMixin
{
	override protected def enterAction() = generationContext.addPostExitRuleTask(expression, () =>
		addCode(
			s""".$UNIT__METHOD__CALL_MEMBER("$operator", null, $UNIT__METHOD__CALL__PARAMETER__CONTEXT)"""
		)
	)
}

object UnaryOperationGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:UnaryOperationContext):Unit =
		new UnaryOperationGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:UnaryOperationContext):Unit =
		new UnaryOperationGenerationJavaRule(generationContext, ruleContext).exit()
}