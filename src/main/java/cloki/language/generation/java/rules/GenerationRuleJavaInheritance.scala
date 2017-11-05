package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationInheritance
import cloki.language.parsing.LokiParser.InheritanceContext

class GenerationRuleJavaInheritance(generationContext:CGenerationContextJava, ruleContext:InheritanceContext)
	extends GenerationRuleJava(generationContext, ruleContext) with CMixinRuleGenerationInheritance
{
	override def __enter() =
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
