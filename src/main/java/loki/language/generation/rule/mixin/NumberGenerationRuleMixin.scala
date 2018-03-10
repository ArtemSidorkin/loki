package loki.language.generation.rule.mixin

import loki.language.parsing.LokiParser.NumberContext

private[generation] trait NumberGenerationRuleMixin extends GenerationRuleMixin[NumberContext]
{
	protected val number:Double = java.lang.Double.parseDouble(ruleContext.getText)
}
