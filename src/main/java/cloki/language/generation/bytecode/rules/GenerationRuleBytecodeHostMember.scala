package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationHostMember
import cloki.language.parsing.LokiParser.HostMemberContext

class GenerationRuleBytecodeHostMember(generationContext:CGenerationContextBytecode, ruleContext:HostMemberContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with CMixinRuleGenerationHostMember
{
	override protected def enterAction() =
	(
		topMethodCall
		aloadUnitMethodCallParameterHost ()
		ldc hostMemberName
		invokeVirtualUnitMethodGetMember ()
		incrementObjectCounter ()
	)
}

object GenerationRuleBytecodeHostMember
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:HostMemberContext):Unit =
		new GenerationRuleBytecodeHostMember(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:HostMemberContext):Unit =
		new GenerationRuleBytecodeHostMember(generationContext, ruleContext).exit()
}