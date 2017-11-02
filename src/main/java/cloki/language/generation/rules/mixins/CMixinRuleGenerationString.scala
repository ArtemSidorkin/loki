package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser

private[language] trait CMixinRuleGenerationString extends CMixinRuleGeneration[LokiParser.StringContext]
{
	protected val string = ruleContext.getText substring (1, ruleContext.getText.length)
}
