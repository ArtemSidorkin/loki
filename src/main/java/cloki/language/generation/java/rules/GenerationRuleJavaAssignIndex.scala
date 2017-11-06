package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationAssignIndex
import cloki.language.parsing.LokiParser.AssignIndexContext
import cloki.runtime.datatype.LUnit

class GenerationRuleJavaAssignIndex(generationContext:CGenerationContextJava, ruleContext:AssignIndexContext)
	extends GenerationRuleJava(generationContext, ruleContext) with CMixinRuleGenerationAssignIndex
{
	override def __enter()
	{
		generationContext.addPostExitRuleTask(hostExpression, () =>
		{
			addCode(s".$UNIT__METHOD__SET_INDEXED_ITEM(")

			if (parametersCount > 0) addCode(s"new ${classOf[LUnit].getName}[]{")
			else addCode("null");
		})

		for (i <- 0 until parametersCount - 1) generationContext.addPostExitRuleTask(getParameterExpression(i), () =>
		{
			addColon()
			addSpace()
		})
	}

	override def __exit()
	{
		if (parametersCount > 0) addRightCurlyBrace()
		addRightParenthesis()
	}
}

object GenerationRuleJavaAssignIndex
{
	def enter(generationContext:CGenerationContextJava, ruleContext:AssignIndexContext):Unit =
		new GenerationRuleJavaAssignIndex(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:AssignIndexContext):Unit =
		new GenerationRuleJavaAssignIndex(generationContext, ruleContext).exit()
}