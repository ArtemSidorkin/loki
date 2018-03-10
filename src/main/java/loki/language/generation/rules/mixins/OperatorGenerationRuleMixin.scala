package loki.language.generation.rules.mixins

import loki.language.parsing.LokiParser._
import org.antlr.v4.runtime.RuleContext

private[generation] trait OperatorGenerationRuleMixin extends GenerationRuleMixin[ExpressionContext]
{
	protected val leftOperand:RuleContext = ruleContext getChild (classOf[RuleContext], 0)
	protected val rightOperand:RuleContext = ruleContext getChild (classOf[RuleContext], 1)

	protected def ruleContextAsMulDivOperatorCode:Int = ruleContext.asInstanceOf[MulDivContext].operator.getType

	protected def ruleContextAsAddSubOperatorCode:Int = ruleContext.asInstanceOf[AddSubContext].operator.getType

	protected def ruleContextAsEqNeqOperatorCode:Int = ruleContext.asInstanceOf[EqNeqContext].operator.getType

	protected def ruleContextAsGteLteGtLtOperatorCode:Int = ruleContext.asInstanceOf[GteLteGtLtContext].operator.getType

	protected def ruleContextAsAmpersandAmpersandOperatorCode:Int =
		ruleContext.asInstanceOf[AmpersandAmpersandContext].operator.getType

	protected def ruleContextAsPipePipeOperatorCode:Int = ruleContext.asInstanceOf[PipePipeContext].operator.getType
}
