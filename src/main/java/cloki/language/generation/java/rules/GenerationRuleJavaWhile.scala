package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationWhile
import cloki.language.parsing.LokiParser.WhileContext
import cloki.runtime.context.LUnitContext
import cloki.runtime.datatype.LUnit
import cloki.util.extension.StringExtensions.StringExtensions

class GenerationRuleJavaWhile(generationContext:CGenerationContextJava, ruleContext:WhileContext)
	extends GenerationRuleJava(generationContext, ruleContext) with CMixinRuleGenerationWhile
{
	override def __enter()
	{
		pushFrame()

		(
			addCode _ compose
			(if (isLastCharacterNewLine) tabulateLessOneLevel else tabulateLessOneLevelContinueLastCode)
		) (
			s"""
				new cloki.runtime.helpers.LWhileHelper(this.unitContext, host, parameters, unitContext)
				{
					@Override
					protected ${classOf[LUnit].getName} condition(${classOf[LUnit].getName} host, ${classOf[LUnit].getName}[] parameters, ${classOf[LUnitContext].getName} unitContext)
					{
			""".withoutSideLines
		)

		generationContext.addPostExitRuleTask(logicalExpression, () =>
		{
			addSemicolon()
			addNewLine()

			(addCode _ compose tabulateIfLastCharacterIsNewLineLessHalfLevel) (
				s"""
					}

					@Override
					protected ${classOf[LUnit].getName} action(${classOf[LUnit].getName} host, ${classOf[LUnit].getName}[] parameters, ${classOf[LUnitContext].getName} unitContext)
					{
				""".withoutSideLines
			)
		})

		generationContext.addPreEnterRuleTask(lastExpression, () =>
		{
			(addCode _ compose tabulateIfLastCharacterIsNewLine) ("return ")
		})

		generationContext.addPreEnterRuleTask(logicalExpression, () =>
		{
			(addCode _ compose tabulateIfLastCharacterIsNewLine) ("return ")
		})
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

object GenerationRuleJavaWhile
{
	def enter(generationContext:CGenerationContextJava, ruleContext:WhileContext):Unit =
		new GenerationRuleJavaWhile(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:WhileContext):Unit =
		new GenerationRuleJavaWhile(generationContext, ruleContext).exit()
}