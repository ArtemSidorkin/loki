package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeContext.CTemplateContext
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationAssignVariable
import cloki.language.parsing.CLokiParser.AssignVariableContext

private[bytecode] object CRuleGenerationBytecodeAssignVariable
	extends CRuleGenerationBytecode[AssignVariableContext]
{
	protected class CCoreBytecodeAssignVariable
	(
		generationContext:CGenerationContextBytecode, ruleContext:AssignVariableContext
	) extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationAssignVariable
	{
		override def enter() =
		(
			topMethodCall aloadUnitMethodCallVariableUnitContext ()
			ldc variableName
		)


		override def exit() = topMethodCall invokeVirtualUnitContextMethodSetVariable ()
	}

	override protected def getCore(generationContext:CGenerationContextBytecode, ruleContext:AssignVariableContext) =
		new CCoreBytecodeAssignVariable(generationContext, ruleContext)
}
