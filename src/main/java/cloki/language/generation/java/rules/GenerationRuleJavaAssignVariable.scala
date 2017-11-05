package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationAssignVariable
import cloki.language.parsing.LokiParser.AssignVariableContext

class GenerationRuleJavaAssignVariable(generationContext:CGenerationContextJava, ruleContext:AssignVariableContext)
	extends GenerationRuleJava(generationContext, ruleContext) with CMixinRuleGenerationAssignVariable
{
	override def __enter() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
		s"""$UNIT__METHOD__CALL__PARAMETER__CONTEXT.$UNIT_CONTEXT__METHOD__SET_VARIABLE("$variableName", """
	)

	override def __exit()
	{
		removeLastNewLineIfPresent()
		addRightParenthesis()
	}
}
