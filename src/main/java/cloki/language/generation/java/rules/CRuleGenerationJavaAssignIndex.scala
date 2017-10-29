package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationAssignIndex
import cloki.language.parsing.CLokiParser.AssignIndexContext
import cloki.runtime.datatype.{LUnit, LArray}

private[java] object CRuleGenerationJavaAssignIndex extends CRuleGenerationJava[AssignIndexContext]
{
	protected class CCoreJavaAssignIndex(generationContext:CGenerationContextJava, ruleContext:AssignIndexContext)
		extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationAssignIndex
	{
		override def enter()
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

		override def exit()
		{
			if (parametersCount > 0) addRightCurlyBrace()
			addRightParenthesis()
		}
	}

	override def getCore(generationContext:CGenerationContextJava, ruleContext:AssignIndexContext) =
		new CCoreJavaAssignIndex(generationContext, ruleContext)
}
