package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rules.mixins.VariableOrParameterGenerationRuleMixin
import loki.language.parsing.LokiParser.VariableOrParameterContext

class VariableOrParameterGenerationJavaRule
(
	generationContext:JavaGenerationContext, ruleContext:VariableOrParameterContext
) extends GenerationJavaRule(generationContext, ruleContext) with VariableOrParameterGenerationRuleMixin
{
	override protected def enterAction() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
		s"""$UNIT__METHOD__CALL__PARAMETER__CONTEXT.$UNIT_CONTEXT__METHOD__GET_VARIABLE("$variableOrParameterName")"""
	)
}

object VariableOrParameterGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:VariableOrParameterContext):Unit =
		new VariableOrParameterGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:VariableOrParameterContext):Unit =
		new VariableOrParameterGenerationJavaRule(generationContext, ruleContext).exit()
}

