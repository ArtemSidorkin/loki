package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationIndex
import cloki.language.parsing.LokiParser.IndexContext
import cloki.runtime.datatype.LUnit

class GenerationRuleJavaIndex(generationContext:CGenerationContextJava, ruleContext:IndexContext)
	extends GenerationRuleJava(generationContext, ruleContext) with CMixinRuleGenerationIndex
{
	override def __enter()
	{
		generationContext.addPostExitRuleTask(hostExpression, () =>
		{
			addCode(s".$UNIT__METHOD__GET_INDEXED_ITEM(")

			if (indexExpressionCount > 0) addCode(s"new ${classOf[LUnit].getName}[]{")
			else addCode("null");
		})

		for (i <- 0 until indexExpressionCount - 1) generationContext.addPostExitRuleTask(getIndexExpression(i), () =>
		{
			addColon()
			addSpace()
		})
	}

	override def __exit()
	{
		if (indexExpressionCount > 0) addRightCurlyBrace()
		addRightParenthesis()
	}
}
