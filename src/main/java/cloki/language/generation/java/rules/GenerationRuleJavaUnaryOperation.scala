package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationUnaryOperation
import cloki.language.parsing.LokiParser.UnaryOperationContext

class GenerationRuleJavaUnaryOperation(generationContext:CGenerationContextJava, ruleContext:UnaryOperationContext)
	extends GenerationRuleJava(generationContext, ruleContext) with CMixinRuleGenerationUnaryOperation
{
	override def __enter() = generationContext.addPostExitRuleTask(expression, () =>
		addCode(
			s""".$UNIT__METHOD__CALL_MEMBER("$operator", null, $UNIT__METHOD__CALL__PARAMETER__CONTEXT)"""
		)
	)
}
