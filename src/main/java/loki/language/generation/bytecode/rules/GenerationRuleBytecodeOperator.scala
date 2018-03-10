package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import loki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.rules.mixins.OperatorGenerationRuleMixin
import loki.language.parsing.LokiParser.ExpressionContext
import loki.language.parsing.{LokiLexer, LokiParser}

class GenerationRuleBytecodeOperator(generationContext:CGenerationContextBytecode, ruleContext:ExpressionContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with OperatorGenerationRuleMixin
{
	override protected def enterAction()
	{
		// -> mixin
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

object GenerationRuleBytecodeOperator
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:ExpressionContext):Unit =
		new GenerationRuleBytecodeOperator(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:ExpressionContext):Unit =
		new GenerationRuleBytecodeOperator(generationContext, ruleContext).exit()
}
