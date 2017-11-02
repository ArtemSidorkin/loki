package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationOperator
import cloki.language.parsing.{LokiLexer, LokiParser}
import cloki.language.parsing.LokiParser.ExpressionContext
import cloki.runtime.datatype.LUnit

private[java] object CRuleGenerationJavaOperator extends CRuleGenerationJava[ExpressionContext]
{
	protected class CCoreJavaOperator(generationContext:CGenerationContextJava, ruleContext:ExpressionContext)
		extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationOperator
	{
		// -> mixin
		override def enter()
		{
			val oprtn = ruleContext match
			{
				case _ : LokiParser.MulDivContext => ruleContextAsMulDivOperator match
				{
					case LokiLexer.STAR => OPERATOR_STAR
					case LokiLexer.SLASH => OPERATOR_SLASH
				}
				case _ : LokiParser.AddSubContext => ruleContextAsAddSubOperator match
				{
					case LokiLexer.PLUS => OPERATOR_PLUS
					case LokiLexer.MINUS => OPERATOR_MINUS
				}
				case _ : LokiParser.EqNeqContext => ruleContextAsEqNeqOperator match
				{
					case LokiLexer.EQUALS_EQUALS => OPERATOR_EQUALS_EQUALS
					case LokiLexer.BANG_EQUALS => OPERATOR_BANG_EQUALS
				}
				case _ : LokiParser.GteLteGtLtContext => ruleContextAsGteLteGtLtOperator match
				{
					case LokiLexer.GREATER_THAN_EQUALS => OPERATOR_GREATER_THAN_EQUALS
					case LokiLexer.GREATER_THAN => OPERATOR_GREATER_THAN
					case LokiLexer.LESS_THAN_EQUALS => OPERATOR_LESS_THAN_EQUALS
					case LokiLexer.LESS_THAN => OPERATOR_LESS_THAN
				}
				case _ : LokiParser.AmpersandAmpersandContext => ruleContextAsAmpersandAmpersandOperator match
				{
					case LokiLexer.AMPERSAND_AMPERSAND => OPERATOR_AMPERSAND_AMPERSAND
				}
				case _ : LokiParser.PipePipeContext => ruleContextAsPipePipeOperator match
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

	override def getCore(generationContext:CGenerationContextJava, ruleContext:ExpressionContext) =
		new CCoreJavaOperator(generationContext, ruleContext)
}
