package loki.language.generation.java.rule

import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rule.mixin.IfElseGenerationRuleMixin
import loki.language.parsing.LokiParser.IfElseContext
import loki.runtime.context.LUnitContext
import loki.runtime.datatype.LUnit
import loki.util.extension.StringExtension.StringExtension

class IfElseGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:IfElseContext)
	extends GenerationJavaRule(generationContext, ruleContext) with IfElseGenerationRuleMixin
{
	override protected def enterAction()
	{
		pushFrame()

		(
			addCode _ compose
			(if (isLastCharacterNewLine) tabulateLessOneLevel else tabulateLessOneLevelContinueLastCode)
		) ("new loki.runtime.helper.LIfElseHelper(")

		generationContext.addPostExitRuleTask(logicalExpression, () =>
		{
			(addCode _ compose tabulateLessOneLevelContinueLastCode) (
				s"""
					, this.unitContext, host, parameters, unitContext)
					{
						@Override
						protected ${classOf[LUnit].getName} yes(${classOf[LUnit].getName} host, ${classOf[LUnit].getName}[] parameters, ${classOf[LUnitContext].getName} unitContext)
						{
				""".withoutSideLines
			)
		})

		generationContext.addPreEnterRuleTask(lastIfExpression, () =>
		{
			(addCode _ compose tabulateIfLastCharacterIsNewLine) ("return ")
		})

		if (isElsePresent)
		{
			generationContext.addPreEnterRuleTask(lastElseExpression, () =>
			{
				(addCode _ compose tabulateIfLastCharacterIsNewLine) ("return ")
			})

			generationContext.addPreEnterRuleTask(firstElseExpression, () =>
			{
				(addCode _ compose tabulateIfLastCharacterIsNewLineLessHalfLevel) (
					s"""
						}

						@Override
						protected ${classOf[LUnit].getName} no(${classOf[LUnit].getName} host, ${classOf[LUnit].getName}[] parameters, ${classOf[LUnitContext].getName} unitContext)
						{
					""".withoutSideLines
				)
			})
		}
	}

	override protected def exitAction()
	{
		(addCode _ compose tabulateLessOneLevelBackward) (
			"""
					}
				}.call()
			""".withoutSideLines
		)
		popFrame()
	}
}

object IfElseGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:IfElseContext):Unit =
		new IfElseGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:IfElseContext):Unit =
		new IfElseGenerationJavaRule(generationContext, ruleContext).exit()
}