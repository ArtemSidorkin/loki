package cloki.language.generation.rules.mixins

import cloki.language.parsing.CLokiParser.ModuleContext

private[language] trait CMixinRuleGenerationModule extends CMixinRuleGeneration[ModuleContext]
{
	protected def unitParametersIndex = frameStackSize - 1
}
