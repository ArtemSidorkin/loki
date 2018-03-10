package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import loki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.rules.mixins.IndexGenerationRuleMixin
import loki.language.parsing.LokiParser.IndexContext

class GenerationRuleBytecodeIndex(generationContext:CGenerationContextBytecode, ruleContext:IndexContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with IndexGenerationRuleMixin
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

object GenerationRuleBytecodeIndex
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:IndexContext):Unit =
		new GenerationRuleBytecodeIndex(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:IndexContext):Unit =
		new GenerationRuleBytecodeIndex(generationContext, ruleContext).exit()
}