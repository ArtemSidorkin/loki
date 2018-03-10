package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import loki.language.generation.bytecode.templates.CTemplateBytecodeContext.CTemplateContext
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.rules.mixins.AssignVariableGenerationRuleMixin
import loki.language.parsing.LokiParser.AssignVariableContext

class GenerationRuleBytecodeAssignVariable
(
	generationContext:CGenerationContextBytecode, ruleContext:AssignVariableContext
) extends GenerationRuleBytecode(generationContext, ruleContext) with AssignVariableGenerationRuleMixin
{
	override protected def enterAction() =
	(
		topMethodCall aloadUnitMethodCallVariableUnitContext ()
		ldc variableName
	)


	override protected def exitAction() = topMethodCall invokeVirtualUnitContextMethodSetVariable ()
}

object GenerationRuleBytecodeAssignVariable
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:AssignVariableContext):Unit =
		new GenerationRuleBytecodeAssignVariable(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:AssignVariableContext):Unit =
		new GenerationRuleBytecodeAssignVariable(generationContext, ruleContext).exit()
}