package loki.language.generation.java.rule

import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rule.mixin.ArrayGenerationRuleMixin
import loki.language.parsing.LokiParser.ArrayContext
import loki.runtime.datatype.{LArray, LUnit}

class ArrayGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:ArrayContext)
	extends GenerationJavaRule(generationContext, ruleContext) with ArrayGenerationRuleMixin
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

object ArrayGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:ArrayContext):Unit =
		new ArrayGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:ArrayContext):Unit =
		new ArrayGenerationJavaRule(generationContext, ruleContext).exit()
}
