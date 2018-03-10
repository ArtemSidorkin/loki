package loki.language.generation.java.rules

import loki.language.generation.java.CGenerationJava.CGenerationContextJava
import loki.language.generation.rules.mixins.IfElseGenerationRuleMixin
import loki.language.parsing.LokiParser.IfElseContext
import loki.runtime.context.LUnitContext
import loki.runtime.datatype.LUnit
import loki.util.extension.StringExtensions.StringExtensions

class GenerationRuleJavaIfElse(generationContext:CGenerationContextJava, ruleContext:IfElseContext)
	extends GenerationRuleJava(generationContext, ruleContext) with IfElseGenerationRuleMixin
{
	override protected def enterAction()
	{
		pushFrame()

		(
			addCode _ compose
			(if (isLastCharacterNewLine) tabulateLessOneLevel else tabulateLessOneLevelContinueLastCode)
		) ("new loki.runtime.helpers.LIfElseHelper(")

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

object GenerationRuleJavaIfElse
{
	def enter(generationContext:CGenerationContextJava, ruleContext:IfElseContext):Unit =
		new GenerationRuleJavaIfElse(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:IfElseContext):Unit =
		new GenerationRuleJavaIfElse(generationContext, ruleContext).exit()
}