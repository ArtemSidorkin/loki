package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.{AssignMemberContext, ExpressionContext}

private[generation] class AssignMemberRule(
	assignMemberContext:AssignMemberContext
)(
	implicit generationContext:GenerationContext
)
	extends GenerationRule(assignMemberContext)
{
	private val memberName:String = assignMemberContext.IDENTIFIER.getText
	private val assignExpressionContext:ExpressionContext = assignMemberContext expression 0

	override protected def enterAction():Unit =
		generationContext.addPostExitRuleTask(assignExpressionContext, () => topMethodCall.ldc(memberName))

	override protected def exitAction():Unit =
		topMethodCall
			.invokeVirtualUnitSetMemberMethod()
			.decrementObjectStackCounter()
}