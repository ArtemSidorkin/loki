package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.VariableOrParameterContext


private[generation] trait VariableOrParameterGenerationRuleMixin extends GenerationRuleMixin[VariableOrParameterContext]
{
	protected val variableOrParameterName:String = ruleContext.IDENTIFIER.getText
}
