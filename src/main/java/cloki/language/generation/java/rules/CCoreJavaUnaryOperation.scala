package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationUnaryOperation
import cloki.language.parsing.LokiParser.UnaryOperationContext

class CCoreJavaUnaryOperation(generationContext:CGenerationContextJava, ruleContext:UnaryOperationContext)
	extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationUnaryOperation
{
	override def enter() = generationContext.addPostExitRuleTask(expression, () =>
		addCode(
			s""".$UNIT__METHOD__CALL_MEMBER("$operator", null, $UNIT__METHOD__CALL__PARAMETER__CONTEXT)"""
		)
	)
}
