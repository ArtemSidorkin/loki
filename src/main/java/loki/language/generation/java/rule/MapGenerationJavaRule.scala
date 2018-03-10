package loki.language.generation.java.rule

import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rule.mixin.MapGenerationRuleMixin
import loki.language.parsing.LokiParser.MapContext
import loki.runtime.datatype.{LMap, LUnit}

class MapGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:MapContext)
	extends GenerationJavaRule(generationContext, ruleContext) with MapGenerationRuleMixin
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

object MapGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:MapContext):Unit =
		new MapGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:MapContext):Unit =
		new MapGenerationJavaRule(generationContext, ruleContext).exit()
}

