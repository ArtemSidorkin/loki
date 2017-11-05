package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationUnaryOperation
import cloki.language.parsing.LokiParser.UnaryOperationContext

class GenerationRuleBytecodeUnaryOperation(generationContext:CGenerationContextBytecode, ruleContext:UnaryOperationContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with CMixinRuleGenerationUnaryOperation
{
	override def __enter() = generationContext.addPostExitRuleTask(expression, () =>
	(
		topMethodCall
		ldc operator
		aconstnull ()
		aloadUnitMethodCallVariableUnitContext ()
		invokeVirtualUnitMethodCallMember ()
	))
}
