package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeContext.CTemplateContext
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationVariableOrParameter
import cloki.language.parsing.LokiParser.VariableOrParameterContext

class GenerationRuleBytecodeVariableOrParameter
(
	generationContext:CGenerationContextBytecode, ruleContext:VariableOrParameterContext
) extends GenerationRuleBytecode(generationContext, ruleContext) with CMixinRuleGenerationVariableOrParameter
{
	override def __enter() =
	(
		topMethodCall
		aloadUnitMethodCallVariableUnitContext ()
		ldc variableOrParameterName
		invokeVirtualUnitContextMethodGetVariable ()
		incrementObjectCounter ()
	)
}

object GenerationRuleBytecodeVariableOrParameter
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:VariableOrParameterContext):Unit =
		new GenerationRuleBytecodeVariableOrParameter(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:VariableOrParameterContext):Unit =
		new GenerationRuleBytecodeVariableOrParameter(generationContext, ruleContext).exit()
}