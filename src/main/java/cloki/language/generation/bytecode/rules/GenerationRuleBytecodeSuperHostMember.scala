package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationSuperHostMember
import cloki.language.parsing.LokiParser.SuperHostMemberContext

class GenerationRuleBytecodeSuperHostMember
(
	generationContext:CGenerationContextBytecode, ruleContext:SuperHostMemberContext
) extends GenerationRuleBytecode(generationContext, ruleContext) with CMixinRuleGenerationSuperHostMember
{
	override def __enter() =
	(
		topMethodCall
		aloadUnitMethodCallParameterHost ()
		ldc superMemberName
		invokeVirtualUnitMethodGetSuperMember ()
		incrementObjectCounter ()
	)
}
