package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.mixin.IfElseGenerationRuleMixin
import loki.language.parsing.LokiParser.IfElseContext
import org.objectweb.asm.tree.LabelNode

class IfElseBytecodeGenerationRule(generationContext:BytecodeGenerationContext, ruleContext:IfElseContext)
	extends BytecodeGenerationRule(generationContext, ruleContext) with IfElseGenerationRuleMixin
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
}

object IfElseBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:IfElseContext):Unit =
		new IfElseBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:IfElseContext):Unit =
		new IfElseBytecodeGenerationRule(generationContext, ruleContext).exit()
}