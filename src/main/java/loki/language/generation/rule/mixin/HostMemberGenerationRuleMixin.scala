package loki.language.generation.rule.mixin

import loki.language.parsing.LokiParser.HostMemberContext

private[generation] trait HostMemberGenerationRuleMixin extends GenerationRuleMixin[HostMemberContext]
{
	protected val hostMemberName:String = ruleContext.IDENTIFIER.getText
}
