package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationSuperHostMember
import cloki.language.parsing.LokiParser.SuperHostMemberContext

class CCoreBytecodeSuperHostMember
(
	generationContext:CGenerationContextBytecode, ruleContext:SuperHostMemberContext
) extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationSuperHostMember
{
	override def enter() =
	(
		topMethodCall
		aloadUnitMethodCallParameterHost ()
		ldc superMemberName
		invokeVirtualUnitMethodGetSuperMember ()
		incrementObjectCounter ()
	)
}
