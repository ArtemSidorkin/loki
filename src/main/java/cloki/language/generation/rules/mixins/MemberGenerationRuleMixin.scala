package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.MemberContext

private[generation] trait MemberGenerationRuleMixin extends GenerationRuleMixin[MemberContext]
{
	protected val memberName:String = ruleContext.IDENTIFIER.getText
}
