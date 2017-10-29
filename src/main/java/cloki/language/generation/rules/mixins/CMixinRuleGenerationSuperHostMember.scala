package cloki.language.generation.rules.mixins

import cloki.language.parsing.CLokiParser.SuperHostMemberContext

private[language] trait CMixinRuleGenerationSuperHostMember extends CMixinRuleGeneration[SuperHostMemberContext]
{
	protected val superMemberName = ruleContext.IDENTIFIER.getText
}
