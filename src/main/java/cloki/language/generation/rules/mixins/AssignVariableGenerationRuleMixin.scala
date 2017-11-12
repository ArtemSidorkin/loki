package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.AssignVariableContext

private[generation] trait AssignVariableGenerationRuleMixin extends GenerationRuleMixin[AssignVariableContext]
{
	protected val variableName:String = ruleContext.IDENTIFIER.getText
}
