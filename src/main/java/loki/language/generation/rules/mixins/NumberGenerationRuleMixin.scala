package loki.language.generation.rules.mixins

import loki.language.parsing.LokiParser.NumberContext

private[generation] trait NumberGenerationRuleMixin extends GenerationRuleMixin[NumberContext]
{
	protected val number:Double = java.lang.Double.parseDouble(ruleContext.getText)
}
