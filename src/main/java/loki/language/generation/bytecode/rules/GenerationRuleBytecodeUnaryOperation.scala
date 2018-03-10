package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.rules.mixins.UnaryOperationGenerationRuleMixin
import loki.language.parsing.LokiParser.UnaryOperationContext

class GenerationRuleBytecodeUnaryOperation(generationContext:CGenerationContextBytecode, ruleContext:UnaryOperationContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with UnaryOperationGenerationRuleMixin
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