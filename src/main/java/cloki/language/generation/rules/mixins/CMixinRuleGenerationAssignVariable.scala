package cloki.language.generation.rules.mixins

import cloki.language.parsing.CLokiParser.AssignVariableContext

private[language] trait CMixinRuleGenerationAssignVariable extends CMixinRuleGeneration[AssignVariableContext]
{
	protected val variableName = ruleContext.IDENTIFIER.getText
}
