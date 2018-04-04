package loki.language.generation.java.rule.template

import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.java.rule.GenerationJavaRule
import loki.language.parsing.LokiParser.ExpressionContext
import loki.runtime.datatype.LUnit
import org.antlr.v4.runtime.RuleContext

class ContainerGenerationJavaRuleTemplate[RULE_CONTEXT <: RuleContext](
	javaGenerationContext:JavaGenerationContext, ruleContext:RULE_CONTEXT
)
	extends GenerationJavaRule[RULE_CONTEXT](javaGenerationContext, ruleContext)
{
	def enter(containerClassName:String, containerItemCount:Int, containerItemExpressionContexts:Seq[ExpressionContext])
	{
		(addCode _ compose tabulateIfLastCharacterIsNewLine) (s"new $containerClassName(")

		if (containerItemCount != 0) addCode(s"new ${classOf[LUnit].getName}[]{")
		else addCode("null")

		for (i <- 0 until containerItemCount - 1)
			generationContext
				.addPostExitRuleTask(
					containerItemExpressionContexts(i),
					() =>
					{
						addComa()
						addSpace()
					}
				)
	}

	def exit(containerItemCount:Int)
	{
		removeLastNewLineIfPresent()
		if (containerItemCount != 0) addRightBrace()
		addRightParenthesis()
	}
}
