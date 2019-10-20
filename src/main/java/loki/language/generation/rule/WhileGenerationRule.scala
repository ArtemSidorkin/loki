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
	private def conditionalExpressionContext:ExpressionContext = ruleContext.expression

	override protected def enterAction()
	{
		val labels = generationContext.setRuleContextVariable(ruleContext, Labels(new LabelNode, new LabelNode))

		placeBeginLabel()
		handleCondition()

		def placeBeginLabel():Unit =
				generationContext
					.addPreEnterRuleTask(conditionalExpressionContext, () => topMethodCall label labels.begin)

		def handleCondition():Unit =
			generationContext
				.addPostExitRuleTask(
					conditionalExpressionContext,
					() => (
						topMethodCall
							invokeVirtualUnitMethodToBoolean ()
							decrementObjectCounter ()
							ifeq labels.end
					)
				)
	}

	override def exit():Unit =
	{
		encloseLoop(generationContext getRuleContextVariable ruleContext)
		prepareResult()

		def encloseLoop(labels:Labels) = (
			topMethodCall
				goto labels.begin
				label labels.end
		)

		def prepareResult():Unit = (
			topMethodCall
				void ()
				incrementObjectCounter ()
		)
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