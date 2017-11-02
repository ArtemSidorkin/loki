package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationAssignIndex
import cloki.language.parsing.LokiParser.AssignIndexContext

private[bytecode] object CRuleGenerationBytecodeAssignIndex extends CRuleGenerationBytecode[AssignIndexContext]
{
	protected class CCoreBytecodeAssignIndex(generationContext:CGenerationContextBytecode, ruleContext:AssignIndexContext)
		extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationAssignIndex
	{
		override def enter()
		{
			generateParameterArray()
			generateParameters()

			def generateParameterArray():Unit =	generationContext.addPostExitRuleTask(hostExpression, () =>
			(
				topMethodCall
				ldc parametersCount
				anewarrayUnit ()
			))

			def generateParameters():Unit = for (i <- 0 to parametersCount)
			{
				generationContext.addPreEnterRuleTask(getParameterExpression(i), () =>
					topMethodCall
					dup ()
					ldc i
					decrementObjectCounter ()
				)
				generationContext.addPostExitRuleTask(getParameterExpression(i), () => topMethodCall aastore ())
			}
		}

		override def exit() =
		(
			topMethodCall
			invokeVirtualUnitMethodSetIndexedItem ()
		)
	}

	override def getCore(generationContext:CGenerationContextBytecode, ruleContext:AssignIndexContext) =
		new CCoreBytecodeAssignIndex(generationContext, ruleContext)
}
