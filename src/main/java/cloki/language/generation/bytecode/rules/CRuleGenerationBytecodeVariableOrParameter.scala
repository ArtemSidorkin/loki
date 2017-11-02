package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeContext.CTemplateContext
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationVariableOrParameter
import cloki.language.parsing.LokiParser.VariableOrParameterContext

private[bytecode] object CRuleGenerationBytecodeVariableOrParameter
	extends CRuleGenerationBytecode[VariableOrParameterContext]
{
	protected class CCoreBytecodeVariableOrParameter
	(
		generationContext:CGenerationContextBytecode, ruleContext:VariableOrParameterContext
	) extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationVariableOrParameter
	{
		override def enter() =
		(
			topMethodCall
			aloadUnitMethodCallVariableUnitContext ()
			ldc variableOrParameterName
			invokeVirtualUnitContextMethodGetVariable ()
			incrementObjectCounter ()
		)
	}

	override protected def getCore
	(
		generationContext:CGenerationContextBytecode, ruleContext:VariableOrParameterContext
	) = new CCoreBytecodeVariableOrParameter(generationContext, ruleContext)
}
