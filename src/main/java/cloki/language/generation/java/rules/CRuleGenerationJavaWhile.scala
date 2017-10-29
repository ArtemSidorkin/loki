package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationWhile
import cloki.language.parsing.CLokiParser.WhileContext
import cloki.runtime.datatypes.CUnit
import cloki.runtime.unitcontexts.CUnitContext
import cloki.utils.extensions.CString.CString

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
					new cloki.runtime.helpers.CHelperWhile(this.unitContext, host, parameters, unitContext)
					{
						@Override
						protected ${classOf[CUnit].getName} condition(${classOf[CUnit].getName} host, ${classOf[CUnit].getName}[] parameters, ${classOf[CUnitContext].getName} unitContext)
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
						protected ${classOf[CUnit].getName} action(${classOf[CUnit].getName} host, ${classOf[CUnit].getName}[] parameters, ${classOf[CUnitContext].getName} unitContext)
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
