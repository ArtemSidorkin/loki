package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.{ExpressionContext, InstructionContext, WhileContext}
import org.objectweb.asm.tree.LabelNode

class WhileGenerationRule(generationContext:GenerationContext, ruleContext:WhileContext)
	extends GenerationRule(generationContext, ruleContext)
{
	override protected def enterAction()
	{
		val lblNdWhlBgn = new LabelNode
		val lblNdWhlEnd = new LabelNode

		generationContext.addPreEnterRuleTask(logicalExpression, () =>
		{
			(
				topMethodCall
				label lblNdWhlBgn
			)
		})

		generationContext.addPostExitRuleTask(logicalExpression, () => {
			(
				topMethodCall
				invokeVirtualUnitMethodToBoolean()
				decrementObjectCounter ()
				ifeq (lblNdWhlEnd)
			)
		})

		generationContext.addPostExitRuleTask(lastInstruction, () =>
		{
			(
				topMethodCall
				goto lblNdWhlBgn
				label lblNdWhlEnd
				void ()
				incrementObjectCounter ()
			)
		})

	}

	private def logicalExpression:ExpressionContext = ruleContext expression
	private def lastExpression:ExpressionContext = ruleContext instruction ruleContext.instruction.size - 1 expression
	private def lastInstruction:InstructionContext = ruleContext instruction ruleContext.instruction.size - 1
}

object WhileGenerationRule
{
	def enter(generationContext:GenerationContext, ruleContext:WhileContext):Unit =
		new WhileGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:GenerationContext, ruleContext:WhileContext):Unit =
		new WhileGenerationRule(generationContext, ruleContext).exit()
}