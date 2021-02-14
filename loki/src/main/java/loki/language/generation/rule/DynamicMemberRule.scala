package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.DynamicMemberContext

private[generation] class DynamicMemberRule(
	dynamicMemberContext:DynamicMemberContext
)(
	implicit generationContext:GenerationContext
)
	extends GenerationRule(dynamicMemberContext)
{
	override protected def exitAction():Unit =
		topMethodCall
			.invokeVirtualUnitToStringMethod()
			.invokeVirtualUnitMethodGetMember()
}