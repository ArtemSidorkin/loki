package loki.language.generation.java.rule

import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rule.mixin.ObjectGenerationRuleMixin
import loki.language.parsing.LokiParser.ObjectContext
import loki.runtime.datatype.{LObject, LUnit}

class ObjectGenerationJavaRule(javaGenerationContext:JavaGenerationContext, objectContext:ObjectContext)
	extends GenerationJavaRule(javaGenerationContext, objectContext) with ObjectGenerationRuleMixin
{
	override protected def enterAction()
	{
		(addCode _ compose tabulateIfLastCharacterIsNewLine) (s"new ${classOf[LObject].getName}(")

		if (memberNameValueCount != 0) addCode(s"new ${classOf[LUnit].getName}[]{")
		else addCode("null")

		for (i <- 0 until memberNameValueCount - 1)
			javaGenerationContext
				.addPostExitRuleTask(
					getMemberNameValueExpression(i),
					() =>
					{
						addComa()
						addSpace()
					}
				)
	}

	override protected def exitAction()
	{
		removeLastNewLineIfPresent()
		if (memberNameValueCount != 0) addRightBrace()
		addRightParenthesis()
	}
}