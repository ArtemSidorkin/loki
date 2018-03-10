package loki.language.generation.java.rules

import loki.language.generation.java.CGenerationJava.CGenerationContextJava
import loki.language.generation.rules.mixins.MapGenerationRuleMixin
import loki.language.parsing.LokiParser.MapContext
import loki.runtime.datatype.{LMap, LUnit}

class GenerationRuleJavaMap(generationContext:CGenerationContextJava, ruleContext:MapContext)
	extends GenerationRuleJava(generationContext, ruleContext) with MapGenerationRuleMixin
{
	override protected def enterAction()
	{
		(addCode _ compose tabulateIfLastCharacterIsNewLine) (s"new ${classOf[LMap].getName}(")

		if (itemCount != 0) addCode(s"new ${classOf[LUnit].getName}[]{")
		else addCode("null")

		for (i <- 0 until itemCount - 1)
			generationContext
				.addPostExitRuleTask(
					getItemExpression(i),
					() =>
					{
						addComa()
						addSpace()
					}
				)
	}

	override protected def exitAction()
	{
		if (itemCount != 0) addRightBrace()

		addRightParenthesis()
	}
}

object GenerationRuleJavaMap
{
	def enter(generationContext:CGenerationContextJava, ruleContext:MapContext):Unit =
		new GenerationRuleJavaMap(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:MapContext):Unit =
		new GenerationRuleJavaMap(generationContext, ruleContext).exit()
}

