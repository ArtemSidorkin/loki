package loki.language.generation.rule.mixin

import loki.language.generation.constant.LanguageMembers._
import loki.language.generation.rule.mixin.template.MemberCallGenerationRuleMixinTemplate
import loki.language.parsing.{LokiLexer, LokiParser}
import loki.language.parsing.LokiParser._

private[generation] trait OperatorGenerationRuleMixin
	extends GenerationRuleMixin[ExpressionContext] with MemberCallGenerationRuleMixinTemplate
{
	override protected val memberName:String = ruleContext match
		{
			case _ : LokiParser.MulDivContext => ruleContextAsMulDivOperatorCode match
			{
				case LokiLexer.STAR => OPERATOR_STAR
				case LokiLexer.SLASH => OPERATOR_SLASH
			}
			case _ : LokiParser.AddSubContext => ruleContextAsAddSubOperatorCode match
			{
				case LokiLexer.PLUS => OPERATOR_PLUS
				case LokiLexer.MINUS => OPERATOR_MINUS
			}
			case _ : LokiParser.EqNeqContext => ruleContextAsEqNeqOperatorCode match
			{
				case LokiLexer.EQUALS_EQUALS => OPERATOR_EQUALS_EQUALS
				case LokiLexer.BANG_EQUALS => OPERATOR_BANG_EQUALS
			}
			case _ : LokiParser.GteLteGtLtContext => ruleContextAsGteLteGtLtOperatorCode match
			{
				case LokiLexer.GREATER_THAN_EQUALS => OPERATOR_GREATER_THAN_EQUALS
				case LokiLexer.GREATER_THAN => OPERATOR_GREATER_THAN
				case LokiLexer.LESS_THAN_EQUALS => OPERATOR_LESS_THAN_EQUALS
				case LokiLexer.LESS_THAN => OPERATOR_LESS_THAN
			}
			case _ : LokiParser.AmpersandAmpersandContext => ruleContextAsAmpersandAmpersandOperatorCode match
			{
				case LokiLexer.AMPERSAND_AMPERSAND => OPERATOR_AMPERSAND_AMPERSAND
			}
			case _ : LokiParser.PipePipeContext => ruleContextAsPipePipeOperatorCode match
			{
				case LokiLexer.PIPE_PIPE => OPERATOR_PIPE_PIPE
			}
		}



	override protected val hostExpressionContext:ExpressionContext =
		ruleContext getChild (classOf[ExpressionContext], 0)

	override protected val callParameterExpressionContexts:Seq[ExpressionContext] =
		(ruleContext getChild (classOf[ExpressionContext], 1)) :: Nil

	private def ruleContextAsMulDivOperatorCode:Int = ruleContext.asInstanceOf[MulDivContext].operator.getType

	private def ruleContextAsAddSubOperatorCode:Int = ruleContext.asInstanceOf[AddSubContext].operator.getType

	private def ruleContextAsEqNeqOperatorCode:Int = ruleContext.asInstanceOf[EqNeqContext].operator.getType

	private def ruleContextAsGteLteGtLtOperatorCode:Int = ruleContext.asInstanceOf[GteLteGtLtContext].operator.getType

	private def ruleContextAsAmpersandAmpersandOperatorCode:Int =
		ruleContext.asInstanceOf[AmpersandAmpersandContext].operator.getType

	private def ruleContextAsPipePipeOperatorCode:Int = ruleContext.asInstanceOf[PipePipeContext].operator.getType
}
