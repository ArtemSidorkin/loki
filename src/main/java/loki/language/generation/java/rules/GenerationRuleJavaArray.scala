package loki.language.generation.java.rules

import loki.language.generation.java.CGenerationJava.CGenerationContextJava
import loki.language.generation.rules.mixins.ArrayGenerationRuleMixin
import loki.language.parsing.LokiParser.ArrayContext
import loki.runtime.datatype.{LArray, LUnit}

class GenerationRuleJavaArray(generationContext:CGenerationContextJava, ruleContext:ArrayContext)
	extends GenerationRuleJava(generationContext, ruleContext) with ArrayGenerationRuleMixin
{
	override protected def enterAction()
	{
		(addCode _ compose tabulateIfLastCharacterIsNewLine) (
			s"new ${classOf[LArray].getName}("
		)

		if (arrayItemCount != 0) addCode(s"new ${classOf[LUnit].getName}[]{")
		else addCode("null")

		for (i <- 0 until arrayItemCount - 1) generationContext.addPostExitRuleTask(getArrayItemExpression(i), () =>
		{
			addComa()
			addSpace()
		})
	}

	override protected def exitAction()
	{
		if (arrayItemCount != 0) addRightBrace()
		addRightParenthesis()
	}
}

object GenerationRuleJavaArray
{
	def enter(generationContext:CGenerationContextJava, ruleContext:ArrayContext):Unit =
		new GenerationRuleJavaArray(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:ArrayContext):Unit =
		new GenerationRuleJavaArray(generationContext, ruleContext).exit()
}
