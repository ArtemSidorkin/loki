package loki.language.generation.rule.mixin

import loki.language.generation.rule.mixin.template.MemberCallGenerationRuleMixinTemplate
import loki.language.parsing.LokiParser._

private[generation] trait OperatorGenerationRuleMixin
	extends GenerationRuleMixin[BinaryOperationContext] with MemberCallGenerationRuleMixinTemplate
{
	override protected val memberName:String = ruleContext.operator.getText

	override protected val hostExpressionContext:ExpressionContext =
		ruleContext getChild (classOf[ExpressionContext], 0)

	override protected val callParameterExpressionContexts:Seq[ExpressionContext] =
		(ruleContext getChild (classOf[ExpressionContext], 1)) :: Nil
}
