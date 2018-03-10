package loki.language.generation.rule.mixin

import loki.language.parsing.LokiParser.MemberContext

private[generation] trait MemberGenerationRuleMixin extends GenerationRuleMixin[MemberContext]
{
	protected val memberName:String = ruleContext.IDENTIFIER.getText
}
