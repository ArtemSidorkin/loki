package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.CGenerationJava.CGenerationContextJava
import loki.language.generation.rules.mixins.InheritanceGenerationRuleMixin
import loki.language.parsing.LokiParser.InheritanceContext

class GenerationRuleJavaInheritance(generationContext:CGenerationContextJava, ruleContext:InheritanceContext)
	extends GenerationRuleJava(generationContext, ruleContext) with InheritanceGenerationRuleMixin
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

object GenerationRuleJavaInheritance
{
	def enter(generationContext:CGenerationContextJava, ruleContext:InheritanceContext):Unit =
		new GenerationRuleJavaInheritance(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:InheritanceContext):Unit =
		new GenerationRuleJavaInheritance(generationContext, ruleContext).exit()
}