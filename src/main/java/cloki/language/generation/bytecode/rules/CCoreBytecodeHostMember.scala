package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationHostMember
import cloki.language.parsing.LokiParser.HostMemberContext

class CCoreBytecodeHostMember(generationContext:CGenerationContextBytecode, ruleContext:HostMemberContext)
	extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationHostMember
{
	override def enter() =
	(
		topMethodCall
		aloadUnitMethodCallParameterHost ()
		ldc hostMemberName
		invokeVirtualUnitMethodGetMember ()
		incrementObjectCounter ()
	)
}
