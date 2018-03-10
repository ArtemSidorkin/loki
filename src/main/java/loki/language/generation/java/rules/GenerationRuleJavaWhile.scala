package loki.language.generation.java.rules

import loki.language.generation.java.CGenerationJava.CGenerationContextJava
import loki.language.generation.rules.mixins.GenerationRuleMixinWhile
import loki.language.parsing.LokiParser.WhileContext
import loki.runtime.context.LUnitContext
import loki.runtime.datatype.LUnit
import loki.util.extension.StringExtensions.StringExtensions

class GenerationRuleJavaWhile(generationContext:CGenerationContextJava, ruleContext:WhileContext)
	extends GenerationRuleJava(generationContext, ruleContext) with GenerationRuleMixinWhile
{
	override protected def enterAction()
	{
		pushFrame()

		(
			addCode _ compose
			(if (isLastCharacterNewLine) tabulateLessOneLevel else tabulateLessOneLevelContinueLastCode)
		) (
			s"""
				new loki.runtime.helpers.LWhileHelper(this.unitContext, host, parameters, unitContext)
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

object GenerationRuleJavaWhile
{
	def enter(generationContext:CGenerationContextJava, ruleContext:WhileContext):Unit =
		new GenerationRuleJavaWhile(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:WhileContext):Unit =
		new GenerationRuleJavaWhile(generationContext, ruleContext).exit()
}