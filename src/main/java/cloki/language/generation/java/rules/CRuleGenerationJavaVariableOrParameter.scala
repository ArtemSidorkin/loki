package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationVariableOrParameter
import cloki.language.parsing.LokiParser.VariableOrParameterContext

private[java] object CRuleGenerationJavaVariableOrParameter
	extends CRuleGenerationJava[VariableOrParameterContext]
{
	protected class CCoreJavaVariableOrParameter
	(
		generationContext:CGenerationContextJava, ruleContext:VariableOrParameterContext
	) extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationVariableOrParameter
	{
		override def enter() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
			s"""$UNIT__METHOD__CALL__PARAMETER__CONTEXT.$UNIT_CONTEXT__METHOD__GET_VARIABLE("$variableOrParameterName")"""
		)
	}

	override def getCore(generationContext:CGenerationContextJava, ruleContext:VariableOrParameterContext) =
		new CCoreJavaVariableOrParameter(generationContext, ruleContext)
}
