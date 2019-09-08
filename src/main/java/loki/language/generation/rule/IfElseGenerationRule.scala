package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.IfElseContext
import org.objectweb.asm.tree.LabelNode

class IfElseGenerationRule(generationContext:GenerationContext, ifElseContext:IfElseContext)
	extends GenerationRule(generationContext, ifElseContext)
{
	private def logicalExpression = ruleContext expression
	private def lastIfExpression = lastIfInstruction expression
	private def lastIfInstruction = ruleContext instruction ruleContext.instruction.size - 1
	private def isElsePresent = Option(ruleContext.else_) isDefined
	private def firstElseExpression = ruleContext.else_ instruction 0 expression
	private def lastElseExpression = lastElseInstruction expression
	private def lastElseInstruction = ruleContext.else_ instruction (ruleContext.else_.instruction.size - 1)

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
					logicalExpression,
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
					lastIfExpression,
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
				generationContext.addPreExitRuleTask(lastIfInstruction, () => topMethodCall decrementObjectCounter ())
		}

		def handleElseBranchIfPresent()
		{
			if (isElsePresent)
			{
				placeFalseConditionLabel()
				placeTrueConditionLabel()
				saveLastElseValue()
			}

			def placeTrueConditionLabel():Unit =
				generationContext
					.addPostExitRuleTask(lastElseExpression, () => topMethodCall label trueConditionLabelNode)

			def placeFalseConditionLabel():Unit =
				generationContext
					.addPreEnterRuleTask(firstElseExpression, () => topMethodCall label falseConditionLabelNode)

			def saveLastElseValue():Unit =
				generationContext.addPreExitRuleTask(lastElseInstruction, () => topMethodCall decrementObjectCounter ())
		}

		def unsaveConditionResult():Unit = topMethodCall incrementObjectCounter ()
	}
}

object IfElseGenerationRule
{
	def enter(generationContext:GenerationContext, ifElseContext:IfElseContext):Unit =
		new IfElseGenerationRule(generationContext, ifElseContext).enter()

	def exit(generationContext:GenerationContext, ifElseContext:IfElseContext):Unit =
		new IfElseGenerationRule(generationContext, ifElseContext).exit()
}