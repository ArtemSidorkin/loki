package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationCall
import cloki.language.parsing.LokiParser.CallContext
import cloki.runtime.datatype.LUnit

class GenerationRuleJavaCall(generationContext:CGenerationContextJava, ruleContext:CallContext)
	extends GenerationRuleJava(generationContext, ruleContext) with CMixinRuleGenerationCall
{
	override def __enter() = generationContext.addPostExitRuleTask(callExpression, () =>
	{
		removeLastNewLineIfPresent()
		addCode(s".$UNIT__METHOD__CALL($UNIT__METHOD__CALL__PARAMETER__HOST, new ${classOf[LUnit].getName}[]{")

		if (callParameterCount > 1)
			for (i <- 1 until callParameterCount)
				generationContext.addPostExitRuleTask(getCalledParameterExpression(i), () =>
				{
					addColon()
					addSpace()
				})
	})

	override def __exit()
	{
		removeLastNewLineIfPresent()
		addCode(s"}, $UNIT__METHOD__CALL__PARAMETER__CONTEXT)")
	}
}
