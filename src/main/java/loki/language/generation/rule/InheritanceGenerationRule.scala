package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.constant.LanguageMembers
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.{ExpressionContext, InheritanceContext}
import loki.runtime.datatype.unit.LUnit

class InheritanceGenerationRule(generationContext:GenerationContext, ruleContext:InheritanceContext)
	extends GenerationRule(generationContext, ruleContext)
{
	private val parentCount:Int = ruleContext.expression.size

	override protected def enterAction() =
	{
		(topMethodCall
			aloadthis()
			ldc LanguageMembers.UNIT__METHOD__ADD_PARENT
			ldc parentCount
			anewarray classOf[LUnit]
		)

		for (i <- 0 until parentCount)
		{
			generationContext
				.addPreEnterRuleTask(getParentExpression(i), () => topMethodCall dup () ldc i decrementObjectCounter ())

			generationContext.addPostExitRuleTask(getParentExpression(i), () => topMethodCall aastore ())
		}
	}

	override protected def exitAction():Unit =
		topMethodCall.aloadUnitMethodCallVariableUnitContext().invokeVirtualUnitMethodCallMember()

	private def getParentExpression(parentIndex:Int):ExpressionContext = ruleContext expression parentIndex
}

object InheritanceGenerationRule
{
	def enter(generationContext:GenerationContext, ruleContext:InheritanceContext):Unit =
		new InheritanceGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:GenerationContext, ruleContext:InheritanceContext):Unit =
		new InheritanceGenerationRule(generationContext, ruleContext).exit()
}