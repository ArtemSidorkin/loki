package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.AssignHostMemberContext

private[generation] class AssignHostMemberRule(
	assignHostMemberContext:AssignHostMemberContext
)(
	implicit generationContext:GenerationContext
)
	extends GenerationRule(assignHostMemberContext
)
{
	private val hostMemberName = assignHostMemberContext.IDENTIFIER.getText

	override protected def enterAction():Unit =
		topMethodCall
			.aloadHostParameterOfUnitCallMethod()
			.ldc(hostMemberName)

	override protected def exitAction():Unit = topMethodCall.invokeVirtualUnitSetMemberMethod()
}