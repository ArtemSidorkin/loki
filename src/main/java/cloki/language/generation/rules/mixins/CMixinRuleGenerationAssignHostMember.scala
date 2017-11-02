package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.AssignHostMemberContext

private[language] trait CMixinRuleGenerationAssignHostMember extends CMixinRuleGeneration[AssignHostMemberContext]
{
	protected val hostMemberName = ruleContext.IDENTIFIER.getText // member to assign ?
}
