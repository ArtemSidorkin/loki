package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationIndex
import cloki.language.parsing.CLokiParser.IndexContext

private[bytecode] object CRuleGenerationBytecodeIndex extends CRuleGenerationBytecode[IndexContext]
{
	protected class CCoreBytecodeIndex(generationContext:CGenerationContextBytecode, ruleContext:IndexContext)
		extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationIndex
	{
		override def enter()
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

		override def exit() =
		(
			topMethodCall
			invokeVirtualUnitMethodGetIndexedItem ()
		)
	}

	override def getCore(generationContext:CGenerationContextBytecode, ruleContext:IndexContext) =
		new CCoreBytecodeIndex(generationContext, ruleContext)
}
