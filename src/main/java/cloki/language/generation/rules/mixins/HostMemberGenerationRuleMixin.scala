package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.HostMemberContext

private[generation] trait HostMemberGenerationRuleMixin extends GenerationRuleMixin[HostMemberContext]
{
	protected val hostMemberName:String = ruleContext.IDENTIFIER.getText
}
