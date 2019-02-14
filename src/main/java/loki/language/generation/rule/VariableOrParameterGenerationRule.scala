package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.ContextBytecodeTemplate.CTemplateContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.VariableOrParameterContext

class VariableOrParameterGenerationRule(
												   generationContext:GenerationContext, ruleContext:VariableOrParameterContext
)
	extends GenerationRule(generationContext, ruleContext)
{
	private val variableOrParameterName:String = ruleContext.IDENTIFIER.getText

	override protected def enterAction():Unit =
	(
		topMethodCall
		aloadUnitMethodCallVariableUnitContext ()
		ldc variableOrParameterName
		invokeVirtualUnitContextMethodGetVariable ()
		incrementObjectCounter ()
	)
}

object VariableOrParameterGenerationRule
{
	def enter(generationContext:GenerationContext, ruleContext:VariableOrParameterContext):Unit =
		new VariableOrParameterGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:GenerationContext, ruleContext:VariableOrParameterContext):Unit =
		new VariableOrParameterGenerationRule(generationContext, ruleContext).exit()
}