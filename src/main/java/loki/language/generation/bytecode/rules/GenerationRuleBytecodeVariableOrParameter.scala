package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import loki.language.generation.bytecode.templates.CTemplateBytecodeContext.CTemplateContext
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.rules.mixins.VariableOrParameterGenerationRuleMixin
import loki.language.parsing.LokiParser.VariableOrParameterContext

class GenerationRuleBytecodeVariableOrParameter
(
	generationContext:CGenerationContextBytecode, ruleContext:VariableOrParameterContext
) extends GenerationRuleBytecode(generationContext, ruleContext) with VariableOrParameterGenerationRuleMixin
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

object GenerationRuleBytecodeVariableOrParameter
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:VariableOrParameterContext):Unit =
		new GenerationRuleBytecodeVariableOrParameter(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:VariableOrParameterContext):Unit =
		new GenerationRuleBytecodeVariableOrParameter(generationContext, ruleContext).exit()
}