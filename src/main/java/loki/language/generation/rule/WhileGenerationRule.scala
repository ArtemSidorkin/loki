package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.WhileGenerationRule.Labels
import loki.language.parsing.LokiParser.{ExpressionContext, InstructionContext, WhileContext}
import org.objectweb.asm.tree.LabelNode

private[generation] class WhileGenerationRule(generationContext:GenerationContext, whileContext:WhileContext)
	extends GenerationRule(generationContext, whileContext)
{
	private def logicalExpressionContext:ExpressionContext = whileContext expression

	override protected def enterAction()
	{
		val labels = Labels(new LabelNode, new LabelNode)

		generationContext
			.addPreEnterRuleTask(logicalExpressionContext, () => topMethodCall label labels.beginWhileLabelNode)

		generationContext
			.addPostExitRuleTask(
				logicalExpressionContext,
				() => (
					topMethodCall
						invokeVirtualUnitMethodToBoolean()
						decrementObjectCounter ()
						ifeq labels.endWhileLabelNode
				)
			)

		generationContext.setRuleContextVariable(whileContext, labels)
	}

	override def exit():Unit = {
		val labelNodes:Labels = generationContext getRuleContextVariable whileContext

		(topMethodCall
				goto labelNodes.beginWhileLabelNode
				label labelNodes.endWhileLabelNode
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

	private case class Labels(beginWhileLabelNode:LabelNode, endWhileLabelNode:LabelNode)
}