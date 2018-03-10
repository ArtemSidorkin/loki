package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.rules.mixins.SuperHostMemberGenerationRuleMixin
import loki.language.parsing.LokiParser.SuperHostMemberContext

class GenerationRuleBytecodeSuperHostMember
(
	generationContext:CGenerationContextBytecode, ruleContext:SuperHostMemberContext
) extends GenerationRuleBytecode(generationContext, ruleContext) with SuperHostMemberGenerationRuleMixin
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