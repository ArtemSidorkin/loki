package loki.language.generation.rule.mixin

import loki.language.parsing.LokiParser.VariableOrParameterContext


private[generation] trait VariableOrParameterGenerationRuleMixin extends GenerationRuleMixin[VariableOrParameterContext]
{
	protected val variableOrParameterName:String = ruleContext.IDENTIFIER.getText
}
