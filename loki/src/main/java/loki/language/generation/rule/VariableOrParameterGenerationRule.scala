package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.ContextBytecodeTemplate.ContextBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.VariableOrParameterContext

private[generation] class VariableOrParameterGenerationRule
	(variableOrParameterContext:VariableOrParameterContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(variableOrParameterContext)
{
	private def variableOrParameterName:String = variableOrParameterContext.IDENTIFIER.getText

	override protected def enterAction():Unit =
		topMethodCall
			.aloadUnitMethodCallVariableUnitContext()
			.ldc(variableOrParameterName)
			.invokeVirtualUnitContextMethodGetVariable()
			.incrementObjectCounter()
}

private[generation] object VariableOrParameterGenerationRule
{
	def enter
		(variableOrParameterContext:VariableOrParameterContext)(implicit generationContext:GenerationContext):Unit =
		new VariableOrParameterGenerationRule(variableOrParameterContext).enter()

	def exit(variableOrParameterContext:VariableOrParameterContext)(implicit generationContext:GenerationContext):Unit =
		new VariableOrParameterGenerationRule(variableOrParameterContext).exit()
}