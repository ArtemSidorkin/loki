package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CommonBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.{ExpressionContext, InheritanceContext}

private[generation] class InheritanceGenerationRule
	(inheritanceContext:InheritanceContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(inheritanceContext)
{
	private def parentCount:Int = inheritanceContext.expression.size

	override protected def enterAction()
	{
		loadThisAndCreateParentArray()
		storeParentsInParentArray()

		def loadThisAndCreateParentArray():Unit = (
			topMethodCall
				aloadthis()
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

	override protected def exitAction():Unit = topMethodCall invokeVirtualUnitMethodAddParents ()

	private def getParentExpression(parentIndex:Int) = inheritanceContext expression parentIndex
}

private[generation] object InheritanceGenerationRule
{
	def enter(inheritanceContext:InheritanceContext)(implicit generationContext:GenerationContext):Unit =
		new InheritanceGenerationRule(inheritanceContext).enter()

	def exit(inheritanceContext:InheritanceContext)(implicit generationContext:GenerationContext):Unit =
		new InheritanceGenerationRule(inheritanceContext).exit()
}