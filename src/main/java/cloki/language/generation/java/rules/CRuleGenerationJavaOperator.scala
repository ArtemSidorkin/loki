package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationOperator
import cloki.language.parsing.CLokiLexer
import cloki.language.parsing.CLokiParser
import cloki.language.parsing.CLokiParser.ExpressionContext
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
				case _ : CLokiParser.MulDivContext => ruleContextAsMulDivOperator match
				{
					case CLokiLexer.STAR => OPERATOR_STAR
					case CLokiLexer.SLASH => OPERATOR_SLASH
				}
				case _ : CLokiParser.AddSubContext => ruleContextAsAddSubOperator match
				{
					case CLokiLexer.PLUS => OPERATOR_PLUS
					case CLokiLexer.MINUS => OPERATOR_MINUS
				}
				case _ : CLokiParser.EqNeqContext => ruleContextAsEqNeqOperator match
				{
					case CLokiLexer.EQUALS_EQUALS => OPERATOR_EQUALS_EQUALS
					case CLokiLexer.BANG_EQUALS => OPERATOR_BANG_EQUALS
				}
				case _ : CLokiParser.GteLteGtLtContext => ruleContextAsGteLteGtLtOperator match
				{
					case CLokiLexer.GREATER_THAN_EQUALS => OPERATOR_GREATER_THAN_EQUALS
					case CLokiLexer.GREATER_THAN => OPERATOR_GREATER_THAN
					case CLokiLexer.LESS_THAN_EQUALS => OPERATOR_LESS_THAN_EQUALS
					case CLokiLexer.LESS_THAN => OPERATOR_LESS_THAN
				}
				case _ : CLokiParser.AmpersandAmpersandContext => ruleContextAsAmpersandAmpersandOperator match
				{
					case CLokiLexer.AMPERSAND_AMPERSAND => OPERATOR_AMPERSAND_AMPERSAND
				}
				case _ : CLokiParser.PipePipeContext => ruleContextAsPipePipeOperator match
				{
					case CLokiLexer.PIPE_PIPE => OPERATOR_PIPE_PIPE
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
