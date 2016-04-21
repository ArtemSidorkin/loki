package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationArray
import cloki.language.parsing.CLokiParser.ArrayContext
import cloki.runtime.datatypes.{CUnit, CArray}

private[java] object CRuleGenerationJavaArray extends CRuleGenerationJava[ArrayContext]
{
	protected class CCoreJavaArray(generationContext:CGenerationContextJava, ruleContext:ArrayContext)
		extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationArray
	{
		override def enter()
		{
			(addCode _ compose tabulateIfLastCharacterIsNewLine) (
				s"new ${classOf[CArray].getName}("
			)

			if (arrayItemCount != 0) addCode(s"new ${classOf[CUnit].getName}[]{")
			else addCode("null")

			for (i <- 0 until arrayItemCount - 1) generationContext.addPostExitRuleTask(getArrayItemExpression(i), () =>
			{
				addColon()
				addSpace()
			})
		}

		override def exit()
		{
			if (arrayItemCount != 0) addRightCurlyBrace()
			addRightParenthesis()
		}
	}

	override def getCore(generationContext:CGenerationContextJava, ruleContext:ArrayContext) =
		new CCoreJavaArray(generationContext, ruleContext)
}
