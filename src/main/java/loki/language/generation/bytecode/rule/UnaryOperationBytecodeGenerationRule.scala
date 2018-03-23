package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.mixin.UnaryOperationGenerationRuleMixin
import loki.language.parsing.LokiParser.UnaryOperationContext

class UnaryOperationBytecodeGenerationRule(generationContext:BytecodeGenerationContext, ruleContext:UnaryOperationContext)
	extends BytecodeGenerationRule(generationContext, ruleContext) with UnaryOperationGenerationRuleMixin
{
	override protected def enterAction() = generationContext.addPostExitRuleTask(expression, () =>
	(
		topMethodCall
		ldc operator
		aconstnull ()
		aloadUnitMethodCallVariableUnitContext ()
		invokeVirtualUnitMethodCallMember ()
	))
}

object UnaryOperationBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:UnaryOperationContext):Unit =
		new UnaryOperationBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:UnaryOperationContext):Unit =
		new UnaryOperationBytecodeGenerationRule(generationContext, ruleContext).exit()
}