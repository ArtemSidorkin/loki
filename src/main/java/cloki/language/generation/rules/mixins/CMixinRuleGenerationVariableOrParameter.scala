package cloki.language.generation.rules.mixins

import cloki.language.parsing.CLokiParser.VariableOrParameterContext


private[language] trait CMixinRuleGenerationVariableOrParameter extends CMixinRuleGeneration[VariableOrParameterContext]
{
	protected val variableOrParameterName = ruleContext.IDENTIFIER.getText
}
