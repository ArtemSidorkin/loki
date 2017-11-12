package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CallGenerationRuleMixin
import cloki.language.parsing.LokiParser.CallContext
import cloki.runtime.datatype.LUnit

class GenerationRuleJavaCall(generationContext:CGenerationContextJava, ruleContext:CallContext)
	extends GenerationRuleJava(generationContext, ruleContext) with CallGenerationRuleMixin
{
	override protected def enterAction() = generationContext.addPostExitRuleTask(callExpression, () =>
	{
		removeLastNewLineIfPresent()
		addCode(s".$UNIT__METHOD__CALL($UNIT__METHOD__CALL__PARAMETER__HOST, new ${classOf[LUnit].getName}[]{")

		if (callParameterCount > 1)
			for (i <- 1 until callParameterCount)
				generationContext.addPostExitRuleTask(getCallParameterExpression(i), () =>
				{
					addColon()
					addSpace()
				})
	})

	override protected def exitAction()
	{
		removeLastNewLineIfPresent()
		addCode(s"}, $UNIT__METHOD__CALL__PARAMETER__CONTEXT)")
	}
}

object GenerationRuleJavaCall
{
	def enter(generationContext:CGenerationContextJava, ruleContext:CallContext):Unit =
		new GenerationRuleJavaCall(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:CallContext):Unit =
		new GenerationRuleJavaCall(generationContext, ruleContext).exit()
}