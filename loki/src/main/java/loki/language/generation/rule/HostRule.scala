package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.HostContext

private[generation] class HostRule(hostContext:HostContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(hostContext)
{
	override protected def enterAction():Unit =
		topMethodCall
			.aloadHostParameterOfUnitCallMethod()
			.incrementObjectStackCounter()
}