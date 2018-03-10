package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.CGenerationJava.CGenerationContextJava
import loki.language.generation.rules.mixins.UnaryOperationGenerationRuleMixin
import loki.language.parsing.LokiParser.UnaryOperationContext

class GenerationRuleJavaUnaryOperation(generationContext:CGenerationContextJava, ruleContext:UnaryOperationContext)
	extends GenerationRuleJava(generationContext, ruleContext) with UnaryOperationGenerationRuleMixin
{
	override protected def enterAction() = generationContext.addPostExitRuleTask(expression, () =>
		addCode(
			s""".$UNIT__METHOD__CALL_MEMBER("$operator", null, $UNIT__METHOD__CALL__PARAMETER__CONTEXT)"""
		)
	)
}

object GenerationRuleJavaUnaryOperation
{
	def enter(generationContext:CGenerationContextJava, ruleContext:UnaryOperationContext):Unit =
		new GenerationRuleJavaUnaryOperation(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:UnaryOperationContext):Unit =
		new GenerationRuleJavaUnaryOperation(generationContext, ruleContext).exit()
}