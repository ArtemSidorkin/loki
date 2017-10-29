package cloki.language.generation.rules.mixins

import cloki.language.parsing.CLokiParser.MemberContext

private[language] trait CMixinRuleGenerationMember extends CMixinRuleGeneration[MemberContext]
{
	protected val memberName = ruleContext.IDENTIFIER.getText
}
