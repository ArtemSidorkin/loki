package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.ModuleContext

private[language] trait CMixinRuleGenerationModule extends CMixinRuleGeneration[ModuleContext]
{
	protected def unitParametersIndex = frameStackSize - 1
}
