package cloki.language.generation.rules.mixins

import cloki.language.parsing.CLokiParser

private[language] trait CMixinRuleGenerationString extends CMixinRuleGeneration[CLokiParser.StringContext]
{
	protected val string = ruleContext.getText substring (1, ruleContext.getText.length)
}
