package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.AssignHostMemberContext

private[generation] trait AssignHostMemberGenerationRuleMixin extends GenerationRuleMixin[AssignHostMemberContext]
{
	protected val hostMemberName = ruleContext.IDENTIFIER.getText
}
