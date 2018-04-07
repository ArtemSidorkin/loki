package loki.language.generation.java.rule.template

import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.java.rule.GenerationJavaRule
import loki.language.generation.rule.mixin.template.ContainerGenerationRuleMixinTemplate
import loki.runtime.datatype.unit.LUnit
import org.antlr.v4.runtime.RuleContext

abstract class ContainerGenerationJavaRuleTemplate[RULE_CONTEXT <: RuleContext](
	javaGenerationContext:JavaGenerationContext, ruleContext:RULE_CONTEXT
)
	extends GenerationJavaRule[RULE_CONTEXT](javaGenerationContext, ruleContext)
		with ContainerGenerationRuleMixinTemplate
{
	override protected def enterAction()
	{
		(addCode _ compose tabulateIfLastCharacterIsNewLine) (s"new ${containerClass.getName}(")

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

	override protected def exitAction()
	{
		removeLastNewLineIfPresent()
		if (containerItemCount != 0) addRightBrace()
		addRightParenthesis()
	}
}
