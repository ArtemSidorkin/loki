package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.WhileGenerationRule.Labels
import loki.language.parsing.LokiParser.{ExpressionContext, WhileContext}
import org.objectweb.asm.tree.LabelNode

private[generation] class WhileGenerationRule(generationContext:GenerationContext, whileContext:WhileContext)
	extends GenerationRule(generationContext, whileContext)
{
	private def logicalExpressionContext:ExpressionContext = whileContext expression

	override protected def enterAction()
	{
		val labels = generationContext.setRuleContextVariable(whileContext, Labels(new LabelNode, new LabelNode))

		PutBeginLabelBeforeEnterLogicalExpressionContext()
		ConvertLogicalExpressionToBooleanAndConditionallyGoToEndLabelAfterExistLogicalExpressionContext()

		object PutBeginLabelBeforeEnterLogicalExpressionContext
		{
			def apply():Unit =
				generationContext.addPreEnterRuleTask(logicalExpressionContext, putBeginLabel)

			private def putBeginLabel():Unit = topMethodCall label labels.begin
		}

		object ConvertLogicalExpressionToBooleanAndConditionallyGoToEndLabelAfterExistLogicalExpressionContext
		{
			def apply():Unit =
				generationContext
					.addPostExitRuleTask(
						logicalExpressionContext, convertLogicalExpressionToBooleanAndConditionallyGoToEndLabel
					)

			private def convertLogicalExpressionToBooleanAndConditionallyGoToEndLabel():Unit = (
				topMethodCall
					invokeVirtualUnitMethodToBoolean()
					decrementObjectCounter ()
					ifeq labels.end
			)
		}
	}

	override def exit():Unit =
	{
		val labels:Labels = generationContext getRuleContextVariable whileContext

		GoToBeginLabelAndPutEndLabel()

		object GoToBeginLabelAndPutEndLabel
		{
			def apply():Unit = (
				topMethodCall
					goto labels.begin
					label labels.end
					void ()
					incrementObjectCounter ()
			)
		}
	}
}

private[generation] object WhileGenerationRule
{
	def enter(generationContext:GenerationContext, whileContext:WhileContext):Unit =
		new WhileGenerationRule(generationContext, whileContext).enter()

	def exit(generationContext:GenerationContext, whileContext:WhileContext):Unit =
		new WhileGenerationRule(generationContext, whileContext).exit()

	private case class Labels(begin:LabelNode, end:LabelNode)
}