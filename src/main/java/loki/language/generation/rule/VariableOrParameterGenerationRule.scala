package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.ContextBytecodeTemplate.ContextBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.VariableOrParameterContext


private[generation] class VariableOrParameterGenerationRule(
   generationContext:GenerationContext, variableOrParameterContext:VariableOrParameterContext
)
	extends GenerationRule(generationContext, variableOrParameterContext)
{
	private def variableOrParameterName:String = variableOrParameterContext.IDENTIFIER.getText

	override protected def enterAction():Unit = (
		topMethodCall
			aloadUnitMethodCallVariableUnitContext ()
			ldc variableOrParameterName
			invokeVirtualUnitContextMethodGetVariable ()
			incrementObjectCounter ()
	)
}

private[generation] object VariableOrParameterGenerationRule
{
	def enter(generationContext:GenerationContext, variableOrParameterContext:VariableOrParameterContext):Unit =
		new VariableOrParameterGenerationRule(generationContext, variableOrParameterContext).enter()

	def exit(generationContext:GenerationContext, variableOrParameterContext:VariableOrParameterContext):Unit =
		new VariableOrParameterGenerationRule(generationContext, variableOrParameterContext).exit()
}