package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.AssignVariableGenerationRuleMixin
import cloki.language.parsing.LokiParser.AssignVariableContext

class GenerationRuleJavaAssignVariable(generationContext:CGenerationContextJava, ruleContext:AssignVariableContext)
	extends GenerationRuleJava(generationContext, ruleContext) with AssignVariableGenerationRuleMixin
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

object GenerationRuleJavaAssignVariable
{
	def enter(generationContext:CGenerationContextJava, ruleContext:AssignVariableContext):Unit =
		new GenerationRuleJavaAssignVariable(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:AssignVariableContext):Unit =
		new GenerationRuleJavaAssignVariable(generationContext, ruleContext).exit()
}