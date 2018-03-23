package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.mixin.InheritanceGenerationRuleMixin
import loki.language.parsing.LokiParser.InheritanceContext

class InheritanceBytecodeGenerationRule
(
	generationContext:BytecodeGenerationContext, ruleContext:InheritanceContext
) extends BytecodeGenerationRule(generationContext, ruleContext) with InheritanceGenerationRuleMixin
{
	override protected def enterAction() =
	{
		for (i <- 0 until parentCount)
		{
			generationContext.addPreEnterRuleTask(getParentExpression(i), () => topMethodCall.aloadthis())

			generationContext.addPostExitRuleTask(
				getParentExpression(i),
				() => (
					topMethodCall
						invokeVirtualUnitMethodAddParent()
						decrementObjectCounter()
				)
			)
		}
	}
}

object InheritanceBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:InheritanceContext):Unit =
		new InheritanceBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:InheritanceContext):Unit =
		new InheritanceBytecodeGenerationRule(generationContext, ruleContext).exit()
}