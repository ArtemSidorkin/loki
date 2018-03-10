package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.mixin.IndexGenerationRuleMixin
import loki.language.parsing.LokiParser.IndexContext

class IndexBytecodeGenerationRule(generationContext:BytecodeGenerationContext, ruleContext:IndexContext)
	extends BytecodeGenerationRule(generationContext, ruleContext) with IndexGenerationRuleMixin
{
	override protected def enterAction()
	{
		generateIndexArray()
		generateIndexes()

		def generateIndexArray():Unit =	generationContext.addPostExitRuleTask(hostExpression, () =>
		(
			topMethodCall
			ldc indexExpressionCount
			anewarrayUnit ()
		))

		def generateIndexes():Unit = for (i <- 0 to indexExpressionCount)
		{
			generationContext.addPreEnterRuleTask(getIndexExpression(i), () =>
				topMethodCall
				dup ()
				ldc i
				decrementObjectCounter ()
			)
			generationContext.addPostExitRuleTask(getIndexExpression(i), () => topMethodCall aastore ())
		}
	}

	override protected def exitAction() =
	(
		topMethodCall
		invokeVirtualUnitMethodGetIndexedItem ()
	)
}

object IndexBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:IndexContext):Unit =
		new IndexBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:IndexContext):Unit =
		new IndexBytecodeGenerationRule(generationContext, ruleContext).exit()
}