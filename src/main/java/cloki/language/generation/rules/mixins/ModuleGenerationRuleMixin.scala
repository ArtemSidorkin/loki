package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiParser.ModuleContext

private[generation] trait ModuleGenerationRuleMixin extends GenerationRuleMixin[ModuleContext]
{
	protected def unitParametersIndex:Int = frameStackSize - 1
}
