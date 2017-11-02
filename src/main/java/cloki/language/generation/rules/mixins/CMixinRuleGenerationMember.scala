package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.MemberContext

private[language] trait CMixinRuleGenerationMember extends CMixinRuleGeneration[MemberContext]
{
	protected val memberName = ruleContext.IDENTIFIER.getText
}
