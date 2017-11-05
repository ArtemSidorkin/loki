package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationUnaryOperation
import cloki.language.parsing.LokiParser.UnaryOperationContext

class CCoreBytecodeUnaryOperation(generationContext:CGenerationContextBytecode, ruleContext:UnaryOperationContext)
	extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationUnaryOperation
{
	override def enter() = generationContext.addPostExitRuleTask(expression, () =>
	(
		topMethodCall
		ldc operator
		aconstnull ()
		aloadUnitMethodCallVariableUnitContext ()
		invokeVirtualUnitMethodCallMember ()
	))
}
