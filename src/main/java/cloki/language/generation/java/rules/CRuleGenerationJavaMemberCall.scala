package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationMemberCall
import cloki.language.parsing.CLokiParser.MemberCallContext
import cloki.runtime.datatype.LUnit

private[java] object CRuleGenerationJavaMemberCall extends CRuleGenerationJava[MemberCallContext]
{
	protected class CCoreJavaMemberCall(generationContext:CGenerationContextJava, ruleContext:MemberCallContext)
		extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationMemberCall
	{
		override def enter() = generationContext.addPostExitRuleTask(memberExpression, () =>
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

		override def exit()
		{
			removeLastNewLineIfPresent()
			addCode(s"}, $UNIT__METHOD__CALL__PARAMETER__CONTEXT)")
		}
	}

	override protected def getCore(generationContext:CGenerationContextJava, ruleContext:MemberCallContext) =
		new CCoreJavaMemberCall(generationContext, ruleContext)
}
