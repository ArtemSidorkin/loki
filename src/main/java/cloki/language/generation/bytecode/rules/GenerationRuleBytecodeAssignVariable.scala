package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeContext.CTemplateContext
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationAssignVariable
import cloki.language.parsing.LokiParser.AssignVariableContext

class GenerationRuleBytecodeAssignVariable
(
	generationContext:CGenerationContextBytecode, ruleContext:AssignVariableContext
) extends GenerationRuleBytecode(generationContext, ruleContext) with CMixinRuleGenerationAssignVariable
{
	override def __enter() =
	(
		topMethodCall aloadUnitMethodCallVariableUnitContext ()
		ldc variableName
	)


	override def __exit() = topMethodCall invokeVirtualUnitContextMethodSetVariable ()
}
