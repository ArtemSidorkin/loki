package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitContextBytecodeTemplate.UnitContextBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.VariableOrParameterContext
import loki.runtime.context.LUnitContext

private[generation] class VariableOrParameterGenerationRule
	(variableOrParameterContext:VariableOrParameterContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(variableOrParameterContext)
{
	private def variableOrParameterName:String =
		Option(variableOrParameterContext.IDENTIFIER).map(_.getText).getOrElse(LUnitContext.ANONYMOUS_PARAMETER_NAME)

	override protected def enterAction():Unit =
		topMethodCall
			.aloadUnitMethodCallVariableUnitContext()
			.ldc(variableOrParameterName)
			.invokeVirtualUnitContextMethodGetVariable()
			.incrementObjectStackCounter()
}

private[generation] object VariableOrParameterGenerationRule
{
	def enter
		(variableOrParameterContext:VariableOrParameterContext)(implicit generationContext:GenerationContext):Unit =
		new VariableOrParameterGenerationRule(variableOrParameterContext).enter()

	def exit(variableOrParameterContext:VariableOrParameterContext)(implicit generationContext:GenerationContext):Unit =
		new VariableOrParameterGenerationRule(variableOrParameterContext).exit()
}