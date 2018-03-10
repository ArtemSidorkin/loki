package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.templates.CTemplateBytecodeArray.CTemplateArray
import loki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import loki.language.generation.rules.mixins.ArrayGenerationRuleMixin
import loki.language.parsing.LokiParser.ArrayContext

class ArrayBytecodeGenerationRule(generationContext:BytecodeGenerationContext, ruleContext:ArrayContext)
	extends BytecodeGenerationRule(generationContext, ruleContext) with ArrayGenerationRuleMixin
{
	override protected def enterAction()
	{
		generateArray()
		generateArrayItems()

		def generateArray()
		{
			(
				topMethodCall
				newArray ()
				dup ()
				incrementObjectCounter ()
			)

			if (arrayItemCount != 0) (
				topMethodCall
				ldc arrayItemCount
				anewarrayUnit ()
			) else topMethodCall aconstnull ()
		}

		def generateArrayItems():Unit = for (i <- 0 until arrayItemCount)
		{
			generationContext.addPreEnterRuleTask(getArrayItemExpression(i), () =>
				topMethodCall
				dup ()
				ldc i
				decrementObjectCounter ()
			)
			generationContext.addPostExitRuleTask(getArrayItemExpression(i), () => topMethodCall aastore ())
		}
	}

	override protected def exitAction() = topMethodCall invokeInitArray ()
}

object ArrayBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:ArrayContext):Unit =
		new ArrayBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:ArrayContext):Unit =
		new ArrayBytecodeGenerationRule(generationContext, ruleContext).exit()
}