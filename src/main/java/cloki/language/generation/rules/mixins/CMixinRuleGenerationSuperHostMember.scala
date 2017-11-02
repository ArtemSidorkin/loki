package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.SuperHostMemberContext

private[language] trait CMixinRuleGenerationSuperHostMember extends CMixinRuleGeneration[SuperHostMemberContext]
{
	protected val superMemberName = ruleContext.IDENTIFIER.getText
}
