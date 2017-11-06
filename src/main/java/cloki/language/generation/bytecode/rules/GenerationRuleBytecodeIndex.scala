package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationIndex
import cloki.language.parsing.LokiParser.IndexContext

class GenerationRuleBytecodeIndex(generationContext:CGenerationContextBytecode, ruleContext:IndexContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with CMixinRuleGenerationIndex
{
	override def __enter()
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

	override def __exit() =
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