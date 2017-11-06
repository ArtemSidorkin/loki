package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationVariableOrParameter
import cloki.language.parsing.LokiParser.VariableOrParameterContext

class GenerationRuleJavaVariableOrParameter
(
	generationContext:CGenerationContextJava, ruleContext:VariableOrParameterContext
) extends GenerationRuleJava(generationContext, ruleContext) with CMixinRuleGenerationVariableOrParameter
{
	override protected def enterAction() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
		s"""$UNIT__METHOD__CALL__PARAMETER__CONTEXT.$UNIT_CONTEXT__METHOD__GET_VARIABLE("$variableOrParameterName")"""
	)
}

object GenerationRuleJavaVariableOrParameter
{
	def enter(generationContext:CGenerationContextJava, ruleContext:VariableOrParameterContext):Unit =
		new GenerationRuleJavaVariableOrParameter(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:VariableOrParameterContext):Unit =
		new GenerationRuleJavaVariableOrParameter(generationContext, ruleContext).exit()
}

