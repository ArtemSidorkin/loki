package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CommonBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.generation.rule.WhileGenerationRule.Labels
import loki.language.parsing.LokiParser.{ExpressionContext, WhileContext}
import org.objectweb.asm.tree.LabelNode

private[generation] class WhileGenerationRule(whileContext:WhileContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(whileContext)
{
	private def conditionalExpressionContext:ExpressionContext = whileContext.expression

	override protected def enterAction()
	{
		val labels = generationContext.setRuleContextVariable(whileContext, Labels(new LabelNode, new LabelNode))

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
		encloseLoop(generationContext getRuleContextVariable whileContext)
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
	def enter(whileContext:WhileContext)(implicit generationContext:GenerationContext):Unit =
		new WhileGenerationRule(whileContext).enter()

	def exit(whileContext:WhileContext)(implicit generationContext:GenerationContext):Unit =
		new WhileGenerationRule(whileContext).exit()

	private case class Labels(begin:LabelNode, end:LabelNode)
}