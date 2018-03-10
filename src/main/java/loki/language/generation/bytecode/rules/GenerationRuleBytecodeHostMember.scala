package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.rules.mixins.HostMemberGenerationRuleMixin
import loki.language.parsing.LokiParser.HostMemberContext

class GenerationRuleBytecodeHostMember(generationContext:CGenerationContextBytecode, ruleContext:HostMemberContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with HostMemberGenerationRuleMixin
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