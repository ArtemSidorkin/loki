package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationIfElse
import cloki.language.parsing.CLokiParser.IfElseContext
import cloki.runtime.datatypes.CUnit
import cloki.utils.extensions.CString.CString
import cloki.runtime.unitcontexts.CUnitContext

private[java] object CRuleGenerationJavaIfElse extends CRuleGenerationJava[IfElseContext]
{
	protected class CCoreJavaIfElse(generationContext:CGenerationContextJava, ruleContext:IfElseContext)
		extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationIfElse
	{
		override def enter()
		{
			pushFrame()

			(
				addCode _ compose
				(if (isLastCharacterNewLine) tabulateLessOneLevel else tabulateLessOneLevelContinueLastCode)
			) ("new cloki.runtime.helpers.CHelperIfElse(")

			generationContext.addPostExitRuleTask(logicalExpression, () =>
			{
				(addCode _ compose tabulateLessOneLevelContinueLastCode) (
					s"""
						, this.unitContext, host, parameters, unitContext)
						{
							@Override
							protected ${classOf[CUnit].getName} yes(${classOf[CUnit].getName} host, ${classOf[CUnit].getName}[] parameters, ${classOf[CUnitContext].getName} unitContext)
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
							protected ${classOf[CUnit].getName} no(${classOf[CUnit].getName} host, ${classOf[CUnit].getName}[] parameters, ${classOf[CUnitContext].getName} unitContext)
							{
						""".withoutSideLines
					)
				})
			}
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

	override protected def getCore(generationContext:CGenerationContextJava, ruleContext:IfElseContext) =
		new CCoreJavaIfElse(generationContext, ruleContext)
}
