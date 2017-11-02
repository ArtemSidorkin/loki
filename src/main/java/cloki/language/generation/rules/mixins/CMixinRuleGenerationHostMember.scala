package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.HostMemberContext

private[language] trait CMixinRuleGenerationHostMember extends CMixinRuleGeneration[HostMemberContext]
{
	protected val hostMemberName = ruleContext.IDENTIFIER.getText
}
