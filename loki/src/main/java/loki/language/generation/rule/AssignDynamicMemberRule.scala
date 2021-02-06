package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.{AssignDynamicMemberContext, ExpressionContext}

private[generation] class AssignDynamicMemberRule
(
	assignDynamicMemberContext:AssignDynamicMemberContext
)(
	implicit generationContext:GenerationContext
)
	extends GenerationRule(assignDynamicMemberContext)
{
	private val memberNameExpressionContext:ExpressionContext = assignDynamicMemberContext expression 1

	override protected def enterAction():Unit =
		generationContext
			.addPostExitRuleTask(memberNameExpressionContext, () => topMethodCall.invokeVirtualUnitToStringMethod())

	override protected def exitAction():Unit =
		topMethodCall
			.invokeVirtualUnitSetMemberMethod()
			.decreaseObjectStackCounter(2)
}