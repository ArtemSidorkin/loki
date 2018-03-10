package loki.language.generation.rules.mixins

import loki.language.parsing.LokiParser.AssignHostMemberContext

private[generation] trait AssignHostMemberGenerationRuleMixin extends GenerationRuleMixin[AssignHostMemberContext]
{
	protected val hostMemberName = ruleContext.IDENTIFIER.getText
}
