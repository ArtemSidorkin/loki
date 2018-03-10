package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rules.mixins.InheritanceGenerationRuleMixin
import loki.language.parsing.LokiParser.InheritanceContext

class InheritanceGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:InheritanceContext)
	extends GenerationJavaRule(generationContext, ruleContext) with InheritanceGenerationRuleMixin
{
	override protected def enterAction() =
	{
		for (i <- 0 until parentCount - 1) generationContext.addPostExitRuleTask(
			getParentExpression(i), () => addCode(s").$UNIT__METHOD__ADD_PARENT(")
		)

		generationContext
			.addPostExitRuleTask(
				getParentExpression(parentCount - 1),
				() =>
				{
					addRightParenthesis
					addSemicolon()
					addNewLine()
				}
			)

		removeLastNewLineIfPresent()
		addNewLine()
		(addCode _ compose tabulateIfLastCharacterIsNewLine) (s"$UNIT__METHOD__ADD_PARENT(")
	}
}

object InheritanceGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:InheritanceContext):Unit =
		new InheritanceGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:InheritanceContext):Unit =
		new InheritanceGenerationJavaRule(generationContext, ruleContext).exit()
}