package loki.language.generation.rule.mixin

import loki.language.parsing.LokiParser.SuperHostMemberContext

private[generation] trait SuperHostMemberGenerationRuleMixin extends GenerationRuleMixin[SuperHostMemberContext]
{
	protected val superMemberName:String = ruleContext.IDENTIFIER.getText
}
