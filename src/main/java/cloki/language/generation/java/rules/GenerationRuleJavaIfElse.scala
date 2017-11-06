package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationIfElse
import cloki.language.parsing.LokiParser.IfElseContext
import cloki.runtime.context.LUnitContext
import cloki.runtime.datatype.LUnit
import cloki.util.extension.StringExtensions.StringExtensions

class GenerationRuleJavaIfElse(generationContext:CGenerationContextJava, ruleContext:IfElseContext)
	extends GenerationRuleJava(generationContext, ruleContext) with CMixinRuleGenerationIfElse
{
	override def __enter()
	{
		pushFrame()

		(
			addCode _ compose
			(if (isLastCharacterNewLine) tabulateLessOneLevel else tabulateLessOneLevelContinueLastCode)
		) ("new cloki.runtime.helpers.LIfElseHelper(")

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

	override def __exit()
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