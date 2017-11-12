package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.OperatorGenerationRuleMixin
import cloki.language.parsing.LokiParser.ExpressionContext
import cloki.language.parsing.{LokiLexer, LokiParser}
import cloki.runtime.datatype.LUnit

class GenerationRuleJavaOperator(generationContext:CGenerationContextJava, ruleContext:ExpressionContext)
	extends GenerationRuleJava(generationContext, ruleContext) with OperatorGenerationRuleMixin
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

object GenerationRuleJavaOperator
{
	def enter(generationContext:CGenerationContextJava, ruleContext:ExpressionContext):Unit =
		new GenerationRuleJavaOperator(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:ExpressionContext):Unit =
		new GenerationRuleJavaOperator(generationContext, ruleContext).exit()
}