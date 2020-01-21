package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.constant.LanguageMembers
import loki.language.parsing.LokiParser.{ExpressionContext, InheritanceContext}

private[generation] class InheritanceGenerationRule(
	generationContext:GenerationContext, inheritanceContext:InheritanceContext
)
	extends GenerationRule(generationContext, inheritanceContext)
{
	private def parentCount:Int = inheritanceContext.expression.size

	override protected def enterAction()
	{
		loadThisAndCreateParentArray()
		storeParentsInParentArray()

		def loadThisAndCreateParentArray():Unit = (
			topMethodCall
				aloadthis()
				ldc LanguageMembers.UNIT__METHOD__ADD_PARENT
				anewarrayUnit parentCount
		)

		def storeParentsInParentArray():Unit =
			for (parentIndex <- 0 until parentCount)
			{
				generationContext
					.addPreEnterRuleTask(
						getParentExpression(parentIndex),
						() =>
							topMethodCall
								dup ()
								ldc parentIndex
								decrementObjectCounter ()
					)

				generationContext
					.addPostExitRuleTask(getParentExpression(parentIndex), () => topMethodCall aastore ())
			}
	}

	override protected def exitAction():Unit = topMethodCall invokeVirtualUnitMethodCallMember ()

	private def getParentExpression(parentIndex:Int):ExpressionContext = inheritanceContext expression parentIndex
}

private[generation] object InheritanceGenerationRule
{
	def enter(generationContext:GenerationContext, inheritanceContext:InheritanceContext):Unit =
		new InheritanceGenerationRule(generationContext, inheritanceContext).enter()

	def exit(generationContext:GenerationContext, inheritanceContext:InheritanceContext):Unit =
		new InheritanceGenerationRule(generationContext, inheritanceContext).exit()
}