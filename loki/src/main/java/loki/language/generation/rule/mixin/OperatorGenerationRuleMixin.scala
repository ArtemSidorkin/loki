package loki.language.generation.rule.mixin

import loki.language.generation.rule.mixin.template.MemberCallGenerationRuleMixinTemplate
import loki.language.parsing.LokiParser._

private[generation] trait OperatorGenerationRuleMixin
	extends GenerationRuleMixin[ExpressionContext] with MemberCallGenerationRuleMixinTemplate
{
	override protected val memberName:String = ruleContext match
		{
			case mulDivContext:MulDivContext => mulDivContext.operator.getText
			case addSubContext:AddSubContext => addSubContext.operator.getText
			case eqNeqContext:EqNeqContext => eqNeqContext.operator.getText
			case gteLteGtLtContext:GteLteGtLtContext => gteLteGtLtContext.operator.getText
			case ampersandAmpersandContext:AmpersandAmpersandContext => ampersandAmpersandContext.operator.getText
			case pipeContext:PipePipeContext => pipeContext.operator.getText
		}

	override protected val hostExpressionContext:ExpressionContext =
		ruleContext getChild (classOf[ExpressionContext], 0)

	override protected val callParameterExpressionContexts:Seq[ExpressionContext] =
		(ruleContext getChild (classOf[ExpressionContext], 1)) :: Nil
}
