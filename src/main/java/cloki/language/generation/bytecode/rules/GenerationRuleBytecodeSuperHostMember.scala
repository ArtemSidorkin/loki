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
	override protected def enterAction() =
	(
		topMethodCall
		aloadUnitMethodCallParameterHost ()
		ldc superMemberName
		invokeVirtualUnitMethodGetSuperMember ()
		incrementObjectCounter ()
	)
}

object GenerationRuleBytecodeSuperHostMember
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:SuperHostMemberContext):Unit =
		new GenerationRuleBytecodeSuperHostMember(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:SuperHostMemberContext):Unit =
		new GenerationRuleBytecodeSuperHostMember(generationContext, ruleContext).exit()
}