package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.mixin.InheritanceGenerationRuleMixin
import loki.language.parsing.LokiParser.InheritanceContext
import loki.runtime.datatype.unit.LUnit
import loki.runtime.datatype.unit.member.LAddParent

class InheritanceBytecodeGenerationRule
(
	generationContext:BytecodeGenerationContext, ruleContext:InheritanceContext
) extends BytecodeGenerationRule(generationContext, ruleContext) with InheritanceGenerationRuleMixin
{
	override protected def enterAction() =
	{
		topMethodCall.aloadthis().ldc("addParent").ldc(parentCount).anewarray(classOf[LUnit])

		for (i <- 0 until parentCount)
		{
			generationContext.addPreEnterRuleTask(getParentExpression(i), () => topMethodCall.dup().ldc(i).decrementObjectCounter())

			generationContext.addPostExitRuleTask(
				getParentExpression(i),
				() => topMethodCall.aastore()

			)
		}
	}

	override protected def exitAction(): Unit = topMethodCall.aloadUnitMethodCallVariableUnitContext().invokeVirtualUnitMethodCallMember()
}

object InheritanceBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:InheritanceContext):Unit =
		new InheritanceBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:InheritanceContext):Unit =
		new InheritanceBytecodeGenerationRule(generationContext, ruleContext).exit()
}