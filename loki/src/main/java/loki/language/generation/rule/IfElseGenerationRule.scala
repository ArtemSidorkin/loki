package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CommonBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.IfElseContext
import org.objectweb.asm.tree.LabelNode

private[generation] class IfElseGenerationRule
	(ifElseContext:IfElseContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(ifElseContext)
{
	private def conditionalExpressionContext = ifElseContext expression
	private def lastIfExpressionContext = lastIfInstructionContext expression
	private def lastIfInstructionContext = ifElseContext instruction ifElseContext.instruction.size - 1
	private def isElsePresent = Option(ifElseContext.else_) isDefined
	private def firstElseExpressionContext = ifElseContext.else_ instruction 0 expression
	private def lastElseExpressionContext = lastElseInstructionContext expression
	private def lastElseInstructionContext = ifElseContext.else_ instruction (ifElseContext.else_.instruction.size - 1)

	override protected def enterAction()
	{
		val trueConditionLabelNode = new LabelNode
		val falseConditionLabelNode = new LabelNode

		handleCondition()
		handleIfBranch()
		handleElseBranchIfPresent()
		unsaveConditionResult()

		def handleCondition():Unit =
			generationContext
				.addPostExitRuleTask(
					conditionalExpressionContext,
					() => (
						topMethodCall
							invokeVirtualUnitMethodToBoolean ()
							ifeq falseConditionLabelNode
							decrementObjectCounter ()
					)
				)

		def handleIfBranch():Unit =
		{
			generationContext
				.addPostExitRuleTask(
					lastIfExpressionContext,
					() =>
					{
						gotoTrueConditionLabel()
						placeLabelsIfElseBranchIsNotPresent()
					})

			saveLastIfValue()

			def gotoTrueConditionLabel():Unit = topMethodCall goto trueConditionLabelNode

			def placeLabelsIfElseBranchIsNotPresent():Unit =
				if (!isElsePresent) (
					topMethodCall
						label falseConditionLabelNode
						void ()
						label trueConditionLabelNode
				)

			def saveLastIfValue():Unit =
				generationContext
					.addPreExitRuleTask(lastIfInstructionContext, () => topMethodCall decrementObjectCounter ())
		}

		def handleElseBranchIfPresent()
		{
			if (isElsePresent)
			{
				placeFalseConditionLabel()
				placeTrueConditionLabel()
				saveLastElseValue()
			}

			def placeFalseConditionLabel():Unit =
				generationContext
					.addPreEnterRuleTask(firstElseExpressionContext, () => topMethodCall label falseConditionLabelNode)

			def placeTrueConditionLabel():Unit =
				generationContext
					.addPostExitRuleTask(lastElseExpressionContext, () => topMethodCall label trueConditionLabelNode)

			def saveLastElseValue():Unit =
				generationContext
					.addPreExitRuleTask(lastElseInstructionContext, () => topMethodCall decrementObjectCounter ())
		}

		def unsaveConditionResult():Unit = topMethodCall incrementObjectCounter ()
	}
}

private[generation] object IfElseGenerationRule
{
	def enter(ifElseContext:IfElseContext)(implicit generationContext:GenerationContext):Unit =
		new IfElseGenerationRule(ifElseContext).enter()

	def exit(ifElseContext:IfElseContext)(implicit generationContext:GenerationContext):Unit =
		new IfElseGenerationRule(ifElseContext).exit()
}