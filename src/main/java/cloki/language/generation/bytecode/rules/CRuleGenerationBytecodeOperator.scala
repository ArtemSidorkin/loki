package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.rules.mixins.CMixinRuleGenerationOperator
import cloki.language.parsing.CLokiLexer
import cloki.language.parsing.CLokiParser
import cloki.language.parsing.CLokiParser.ExpressionContext

private[bytecode] object CRuleGenerationBytecodeOperator extends CRuleGenerationBytecode[ExpressionContext]
{
	protected class CCoreBytecodeOperator(generationContext:CGenerationContextBytecode, ruleContext:ExpressionContext)
		extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationOperator
	{
		override def enter()
		{
			// -> mixin
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

			generationContext.addPostExitRuleTask(leftOperand, () =>
				topMethodCall
				ldc oprtn
				ldc 1
				anewarrayUnit ()
				dup ()
				ldc 0
			)

			generationContext.addPostExitRuleTask(rightOperand, () =>
				topMethodCall
				aastore ()
				aloadUnitMethodCallVariableUnitContext ()
				invokeVirtualUnitMethodCallMember ()
			)

			topMethodCall decrementObjectCounter ()
		}
	}

	override protected def getCore(generationContext:CGenerationContextBytecode, ruleContext:ExpressionContext) =
		new CCoreBytecodeOperator(generationContext, ruleContext)
}
