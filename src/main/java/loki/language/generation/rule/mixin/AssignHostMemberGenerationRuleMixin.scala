package loki.language.generation.rule.mixin

import loki.language.parsing.LokiParser.AssignHostMemberContext

private[generation] trait AssignHostMemberGenerationRuleMixin extends GenerationRuleMixin[AssignHostMemberContext]
{
	protected val hostMemberName = ruleContext.IDENTIFIER.getText
}
