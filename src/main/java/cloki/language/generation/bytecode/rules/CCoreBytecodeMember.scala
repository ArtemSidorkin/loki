package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationMember
import cloki.language.parsing.LokiParser.MemberContext

class CCoreBytecodeMember(generationContext:CGenerationContextBytecode, ruleContext:MemberContext)
	extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationMember
{
	override def enter() = generationContext.addPostExitRuleTask(ruleContext.expression, () =>
	(
		topMethodCall
		ldc memberName
		invokeVirtualUnitMethodGetMember ()
	))
}
