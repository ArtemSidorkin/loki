package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.NumberContext

private[generation] trait NumberGenerationRuleMixin extends GenerationRuleMixin[NumberContext]
{
	protected val number:Double = java.lang.Double.parseDouble(ruleContext.getText)
}
