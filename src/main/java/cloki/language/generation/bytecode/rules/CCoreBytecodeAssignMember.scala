package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationAssignMember
import cloki.language.parsing.LokiParser.AssignMemberContext

class CCoreBytecodeAssignMember
(
	generationContext:CGenerationContextBytecode, ruleContext:AssignMemberContext
) extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationAssignMember
{
	override def enter() =
		generationContext.addPostExitRuleTask(expressionToAssign, () => topMethodCall ldc memberName)

	override def exit() =
	(
		topMethodCall invokeVirtualUnitMethodSetMember ()
		decrementObjectCounter ()
	)
}
