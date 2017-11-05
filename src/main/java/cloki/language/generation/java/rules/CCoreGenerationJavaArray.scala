package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationArray
import cloki.language.parsing.LokiParser.ArrayContext
import cloki.runtime.datatype.{LArray, LUnit}

class CCoreGenerationJavaArray(generationContext:CGenerationContextJava, ruleContext:ArrayContext)
	extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationArray
{
	override def enter()
	{
		(addCode _ compose tabulateIfLastCharacterIsNewLine) (
			s"new ${classOf[LArray].getName}("
		)

		if (arrayItemCount != 0) addCode(s"new ${classOf[LUnit].getName}[]{")
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