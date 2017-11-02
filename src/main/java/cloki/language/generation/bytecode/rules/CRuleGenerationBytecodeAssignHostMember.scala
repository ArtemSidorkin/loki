package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationAssignHostMember
import cloki.language.parsing.LokiParser.AssignHostMemberContext

private[bytecode] object CRuleGenerationBytecodeAssignHostMember
	extends CRuleGenerationBytecode[AssignHostMemberContext]
{
	protected class CCoreBytecodeAssignHostMember
	(
		generationContext:CGenerationContextBytecode, ruleContext:AssignHostMemberContext
	) extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationAssignHostMember
	{
		override def enter() =
		(
			topMethodCall aloadUnitMethodCallParameterHost ()
			ldc hostMemberName
		)

		override def exit() = topMethodCall invokeVirtualUnitMethodSetMember ()
	}

	override protected def getCore(
		generationContext:CGenerationContextBytecode, ruleContext:AssignHostMemberContext
	) = new CCoreBytecodeAssignHostMember(generationContext, ruleContext)
}
