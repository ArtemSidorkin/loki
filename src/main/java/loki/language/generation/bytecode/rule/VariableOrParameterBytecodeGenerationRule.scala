package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.ContextBytecodeTemplate.CTemplateContext
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.mixin.VariableOrParameterGenerationRuleMixin
import loki.language.parsing.LokiParser.VariableOrParameterContext

class VariableOrParameterBytecodeGenerationRule
(
	generationContext:BytecodeGenerationContext, ruleContext:VariableOrParameterContext
) extends BytecodeGenerationRule(generationContext, ruleContext) with VariableOrParameterGenerationRuleMixin
{
	override protected def enterAction() =
	(
		topMethodCall
		aloadUnitMethodCallVariableUnitContext ()
		ldc variableOrParameterName
		invokeVirtualUnitContextMethodGetVariable ()
		incrementObjectCounter ()
	)
}

object VariableOrParameterBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:VariableOrParameterContext):Unit =
		new VariableOrParameterBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:VariableOrParameterContext):Unit =
		new VariableOrParameterBytecodeGenerationRule(generationContext, ruleContext).exit()
}