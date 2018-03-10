package loki.language.generation.rules.mixins

import loki.language.parsing.LokiParser.VariableOrParameterContext


private[generation] trait VariableOrParameterGenerationRuleMixin extends GenerationRuleMixin[VariableOrParameterContext]
{
	protected val variableOrParameterName:String = ruleContext.IDENTIFIER.getText
}
