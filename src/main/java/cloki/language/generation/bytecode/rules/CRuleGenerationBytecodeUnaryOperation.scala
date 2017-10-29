package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationUnaryOperation
import cloki.language.parsing.CLokiParser.UnaryOperationContext

private[bytecode] object CRuleGenerationBytecodeUnaryOperation extends CRuleGenerationBytecode[UnaryOperationContext]
{
	protected class CCoreBytecodeUnaryOperation(generationContext:CGenerationContextBytecode, ruleContext:UnaryOperationContext)
		extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationUnaryOperation
	{
		override def enter() = generationContext.addPostExitRuleTask(expression, () =>
		(
			topMethodCall
			ldc operator
			aconstnull ()
			aloadUnitMethodCallVariableUnitContext ()
			invokeVirtualUnitMethodCallMember ()
		))
	}

	override def getCore(generationContext:CGenerationContextBytecode, ruleContext:UnaryOperationContext) =
		new CCoreBytecodeUnaryOperation(generationContext, ruleContext)
}
