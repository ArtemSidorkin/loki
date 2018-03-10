package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.ContextBytecodeTemplate.CTemplateContext
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.mixin.AssignVariableGenerationRuleMixin
import loki.language.parsing.LokiParser.AssignVariableContext

class AssignVariableBytecodeGenerationRule
(
	generationContext:BytecodeGenerationContext, ruleContext:AssignVariableContext
) extends BytecodeGenerationRule(generationContext, ruleContext) with AssignVariableGenerationRuleMixin
{
	override protected def enterAction() =
	(
		topMethodCall aloadUnitMethodCallVariableUnitContext ()
		ldc variableName
	)


	override protected def exitAction() = topMethodCall invokeVirtualUnitContextMethodSetVariable ()
}

object AssignVariableBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:AssignVariableContext):Unit =
		new AssignVariableBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:AssignVariableContext):Unit =
		new AssignVariableBytecodeGenerationRule(generationContext, ruleContext).exit()
}