package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rules.mixins.OperatorGenerationRuleMixin
import loki.language.parsing.LokiParser.ExpressionContext
import loki.language.parsing.{LokiLexer, LokiParser}
import loki.runtime.datatype.LUnit

class OperatorGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:ExpressionContext)
	extends GenerationJavaRule(generationContext, ruleContext) with OperatorGenerationRuleMixin
{
	// -> mixin
	override protected def enterAction()
	{
		val oprtn = ruleContext match
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

		generationContext.addPostExitRuleTask(
			leftOperand,
			() => addCode(s""".$UNIT__METHOD__CALL_MEMBER("$oprtn", new ${classOf[LUnit].getName}[]{""")
		)

		generationContext.addPostExitRuleTask(rightOperand, () =>
		{
			removeLastNewLineIfPresent()
			addCode(s"}, $UNIT__METHOD__CALL__PARAMETER__CONTEXT)")
		})
	}
}

object OperatorGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:ExpressionContext):Unit =
		new OperatorGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:ExpressionContext):Unit =
		new OperatorGenerationJavaRule(generationContext, ruleContext).exit()
}