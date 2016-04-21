package cloki.language.generation.rules.mixins

import cloki.language.parsing.CLokiParser.NumberContext

private[language] trait CMixinRuleGenerationNumber extends CMixinRuleGeneration[NumberContext]
{
	protected val number =
	{
		val nmbr = java.lang.Double.parseDouble(ruleContext.getText)

		if (nmbr == Double.PositiveInfinity)
			Double.MaxValue
		else if (nmbr == Double.NegativeInfinity)
			Double.MinValue
		else
			nmbr
	}
}
