package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.rules.mixins.AssignIndexGenerationRuleMixin
import loki.language.parsing.LokiParser.AssignIndexContext

class AssignIndexBytecodeGenerationRule(generationContext:BytecodeGenerationContext, ruleContext:AssignIndexContext)
	extends BytecodeGenerationRule(generationContext, ruleContext) with AssignIndexGenerationRuleMixin
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

object AssignIndexBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:AssignIndexContext):Unit =
		new AssignIndexBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:AssignIndexContext):Unit =
		new AssignIndexBytecodeGenerationRule(generationContext, ruleContext).exit()
}