package loki.language.generation.rules.mixins

import loki.language.parsing.LokiParser.SuperHostMemberContext

private[generation] trait SuperHostMemberGenerationRuleMixin extends GenerationRuleMixin[SuperHostMemberContext]
{
	protected val superMemberName:String = ruleContext.IDENTIFIER.getText
}
