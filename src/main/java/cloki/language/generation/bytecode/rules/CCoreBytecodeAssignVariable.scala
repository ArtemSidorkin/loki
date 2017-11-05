package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeContext.CTemplateContext
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationAssignVariable
import cloki.language.parsing.LokiParser.AssignVariableContext

class CCoreBytecodeAssignVariable
(
	generationContext:CGenerationContextBytecode, ruleContext:AssignVariableContext
) extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationAssignVariable
{
	override def enter() =
	(
		topMethodCall aloadUnitMethodCallVariableUnitContext ()
		ldc variableName
	)


	override def exit() = topMethodCall invokeVirtualUnitContextMethodSetVariable ()
}
