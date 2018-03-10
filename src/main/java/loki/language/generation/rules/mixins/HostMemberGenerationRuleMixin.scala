package loki.language.generation.rules.mixins

import loki.language.parsing.LokiParser.HostMemberContext

private[generation] trait HostMemberGenerationRuleMixin extends GenerationRuleMixin[HostMemberContext]
{
	protected val hostMemberName:String = ruleContext.IDENTIFIER.getText
}
