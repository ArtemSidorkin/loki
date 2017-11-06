package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationMemberCall
import cloki.language.parsing.LokiParser.MemberCallContext
import cloki.runtime.datatype.LUnit

class GenerationRuleJavaMemberCall(generationContext:CGenerationContextJava, ruleContext:MemberCallContext)
	extends GenerationRuleJava(generationContext, ruleContext) with CMixinRuleGenerationMemberCall
{
	override def __enter() = generationContext.addPostExitRuleTask(memberExpression, () =>
	{
		addCode(s""".$UNIT__METHOD__CALL_MEMBER("$memberName", new ${classOf[LUnit].getName}[]{""")

		if (callParameterCount > 1)
			for (i <- 1 until callParameterCount)
				generationContext.addPostExitRuleTask(getCallParameterExpression(i), () =>
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

object GenerationRuleJavaMemberCall
{
	def enter(generationContext:CGenerationContextJava, ruleContext:MemberCallContext):Unit =
		new GenerationRuleJavaMemberCall(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:MemberCallContext):Unit =
		new GenerationRuleJavaMemberCall(generationContext, ruleContext).exit()
}