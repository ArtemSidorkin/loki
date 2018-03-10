package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import loki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.rules.mixins.AssignIndexGenerationRuleMixin
import loki.language.parsing.LokiParser.AssignIndexContext

class GenerationRuleBytecodeAssignIndex(generationContext:CGenerationContextBytecode, ruleContext:AssignIndexContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with AssignIndexGenerationRuleMixin
{
	override protected def enterAction()
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

	override protected def exitAction() =
	(
		topMethodCall
		invokeVirtualUnitMethodSetIndexedItem ()
	)
}

object GenerationRuleBytecodeAssignIndex
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:AssignIndexContext):Unit =
		new GenerationRuleBytecodeAssignIndex(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:AssignIndexContext):Unit =
		new GenerationRuleBytecodeAssignIndex(generationContext, ruleContext).exit()
}