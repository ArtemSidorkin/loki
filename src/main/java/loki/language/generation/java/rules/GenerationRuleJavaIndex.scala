package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.CGenerationJava.CGenerationContextJava
import loki.language.generation.rules.mixins.IndexGenerationRuleMixin
import loki.language.parsing.LokiParser.IndexContext
import loki.runtime.datatype.LUnit

class GenerationRuleJavaIndex(generationContext:CGenerationContextJava, ruleContext:IndexContext)
	extends GenerationRuleJava(generationContext, ruleContext) with IndexGenerationRuleMixin
{
	override protected def enterAction()
	{
		generationContext.addPostExitRuleTask(hostExpression, () =>
		{
			addCode(s".$UNIT__METHOD__GET_INDEXED_ITEM(")

			if (indexExpressionCount > 0) addCode(s"new ${classOf[LUnit].getName}[]{")
			else addCode("null")
		})

		for (i <- 0 until indexExpressionCount - 1) generationContext.addPostExitRuleTask(getIndexExpression(i), () =>
		{
			addComa()
			addSpace()
		})
	}

	override protected def exitAction()
	{
		if (indexExpressionCount > 0) addRightBrace()
		addRightParenthesis()
	}
}

object GenerationRuleJavaIndex
{
	def enter(generationContext:CGenerationContextJava, ruleContext:IndexContext):Unit =
		new GenerationRuleJavaIndex(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:IndexContext):Unit =
		new GenerationRuleJavaIndex(generationContext, ruleContext).exit()
}