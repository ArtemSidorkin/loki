package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.{CMixinRuleGenerationMemberCall, CMixinRuleGenerationUnaryOperation}
import cloki.language.parsing.CLokiParser.UnaryOperationContext
import cloki.runtime.datatype.LUnit

private[java] object CRuleGenerationJavaUnaryOperation extends CRuleGenerationJava[UnaryOperationContext]
{
	protected class CCoreJavaUnaryOperation(generationContext:CGenerationContextJava, ruleContext:UnaryOperationContext)
		extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationUnaryOperation
	{
		override def enter() = generationContext.addPostExitRuleTask(expression, () =>
			addCode(
				s""".$UNIT__METHOD__CALL_MEMBER("$operator", null, $UNIT__METHOD__CALL__PARAMETER__CONTEXT)"""
			)
		)
	}

	override protected def getCore(generationContext:CGenerationContextJava, ruleContext:UnaryOperationContext) =
		new CCoreJavaUnaryOperation(generationContext, ruleContext)
}
