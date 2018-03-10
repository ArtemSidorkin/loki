package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.CGenerationJava.CGenerationContextJava
import loki.language.generation.rules.mixins.VariableOrParameterGenerationRuleMixin
import loki.language.parsing.LokiParser.VariableOrParameterContext

class GenerationRuleJavaVariableOrParameter
(
	generationContext:CGenerationContextJava, ruleContext:VariableOrParameterContext
) extends GenerationRuleJava(generationContext, ruleContext) with VariableOrParameterGenerationRuleMixin
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

