package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.SuperHostMemberContext

private[generation] trait SuperHostMemberGenerationRuleMixin extends GenerationRuleMixin[SuperHostMemberContext]
{
	protected val superMemberName:String = ruleContext.IDENTIFIER.getText
}
