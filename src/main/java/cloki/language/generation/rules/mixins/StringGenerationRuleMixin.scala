package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser

private[generation] trait StringGenerationRuleMixin extends GenerationRuleMixin[LokiParser.StringContext]
{
	protected val string:String = ruleContext.getText substring (1, ruleContext.getText.length)
}
