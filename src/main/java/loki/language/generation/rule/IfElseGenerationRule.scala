package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.{ExpressionContext, IfElseContext, InstructionContext}
import org.objectweb.asm.tree.LabelNode

class IfElseGenerationRule(generationContext:GenerationContext, ruleContext:IfElseContext)
	extends GenerationRule(generationContext, ruleContext)
{
	override protected def enterAction()
	{
		val ifLblNd = new LabelNode
		val elsLblNd = new LabelNode

		generationContext.addPostExitRuleTask(logicalExpression, () =>
		{
			(
				topMethodCall
//					incrementObjectCounter ()
				invokeVirtualUnitMethodToBoolean ()
				ifeq (elsLblNd)
//					pushFrame ()
			)
		})

		generationContext.addPostExitRuleTask(lastIfExpression, () =>
		{
			(
				topMethodCall
				goto ifLblNd
			)

			if (!isElsePresent)
			(
				topMethodCall
				goto ifLblNd
				label elsLblNd
				void ()
				label ifLblNd
			)
		})

		generationContext.addPreExitRuleTask(lastIfInstruction, () => topMethodCall.decrementObjectCounter())

		if (isElsePresent)
		{
			generationContext.addPreEnterRuleTask(firstElseExpression, () =>
			(
				topMethodCall
				label elsLblNd
			))

			generationContext.addPostExitRuleTask(lastElseExpression, () =>
			(
				topMethodCall
				label ifLblNd
			))

			generationContext.addPreExitRuleTask(lastElseInstruction, () => topMethodCall.decrementObjectCounter())
		}
	}

	private def logicalExpression:ExpressionContext = ruleContext expression

	private def lastIfExpression:ExpressionContext =
		ruleContext instruction ruleContext.instruction.size - 1 expression

	private def lastIfInstruction:InstructionContext = ruleContext instruction ruleContext.instruction.size - 1

	private def isElsePresent:Boolean = ruleContext.else_ != null

	private def firstElseExpression:ExpressionContext = ruleContext.else_ instruction 0 expression

	private def lastElseExpression:ExpressionContext =
		ruleContext.else_ instruction (ruleContext.else_.instruction.size - 1) expression

	private def lastElseInstruction:InstructionContext =
		ruleContext.else_ instruction (ruleContext.else_.instruction.size - 1)
}

object IfElseGenerationRule
{
	def enter(generationContext:GenerationContext, ruleContext:IfElseContext):Unit =
		new IfElseGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:GenerationContext, ruleContext:IfElseContext):Unit =
		new IfElseGenerationRule(generationContext, ruleContext).exit()
}