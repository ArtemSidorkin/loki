package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser._
import org.antlr.v4.runtime.RuleContext

private[language] trait CMixinRuleGenerationOperator extends CMixinRuleGeneration[ExpressionContext]
{
	protected val leftOperand = ruleContext getChild (classOf[RuleContext], 0)
	protected val rightOperand = ruleContext getChild (classOf[RuleContext], 1)

	protected def ruleContextAsMulDivOperator = ruleContext.asInstanceOf[MulDivContext].operator.getType
	protected def ruleContextAsAddSubOperator = ruleContext.asInstanceOf[AddSubContext].operator.getType
	protected def ruleContextAsEqNeqOperator = ruleContext.asInstanceOf[EqNeqContext].operator.getType
	protected def ruleContextAsGteLteGtLtOperator = ruleContext.asInstanceOf[GteLteGtLtContext].operator.getType
	protected def ruleContextAsAmpersandAmpersandOperator = ruleContext.asInstanceOf[AmpersandAmpersandContext].operator.getType
	protected def ruleContextAsPipePipeOperator = ruleContext.asInstanceOf[PipePipeContext].operator.getType
}
