package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationWhile
import cloki.language.parsing.CLokiParser.WhileContext
import cloki.runtime.datatype.LUnit
import cloki.runtime.context.LUnitContext
import cloki.util.extensions.StringExtensions.StringExtensions

private[java] object CRuleGenerationJavaWhile extends CRuleGenerationJava[WhileContext]
{
	protected class CCoreJavaWhile(generationContext:CGenerationContextJava, ruleContext:WhileContext)
		extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationWhile
	{
		override def enter()
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

		override def exit()
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

	override protected def getCore(generationContext:CGenerationContextJava, ruleContext:WhileContext) =
		new CCoreJavaWhile(generationContext, ruleContext)
}
