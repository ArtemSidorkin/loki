package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationUnaryOperation
import cloki.language.parsing.LokiParser.UnaryOperationContext

class GenerationRuleBytecodeUnaryOperation(generationContext:CGenerationContextBytecode, ruleContext:UnaryOperationContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with CMixinRuleGenerationUnaryOperation
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

object GenerationRuleBytecodeUnaryOperation
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:UnaryOperationContext):Unit =
		new GenerationRuleBytecodeUnaryOperation(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:UnaryOperationContext):Unit =
		new GenerationRuleBytecodeUnaryOperation(generationContext, ruleContext).exit()
}