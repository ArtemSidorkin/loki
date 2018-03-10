package loki.language.generation.java.rule

import loki.language.generation.constant.LanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rule.mixin.AssignVariableGenerationRuleMixin
import loki.language.parsing.LokiParser.AssignVariableContext

class AssignVariableGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:AssignVariableContext)
	extends GenerationJavaRule(generationContext, ruleContext) with AssignVariableGenerationRuleMixin
{
	override protected def enterAction() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
		s"""$UNIT__METHOD__CALL__PARAMETER__CONTEXT.$UNIT_CONTEXT__METHOD__SET_VARIABLE("$variableName", """
	)

	override protected def exitAction()
	{
		removeLastNewLineIfPresent()
		addRightParenthesis()
	}
}

object AssignVariableGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:AssignVariableContext):Unit =
		new AssignVariableGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:AssignVariableContext):Unit =
		new AssignVariableGenerationJavaRule(generationContext, ruleContext).exit()
}