package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.rules.mixins.MemberGenerationRuleMixin
import loki.language.parsing.LokiParser.MemberContext

class GenerationRuleBytecodeMember(generationContext:CGenerationContextBytecode, ruleContext:MemberContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with MemberGenerationRuleMixin
{
	override protected def enterAction() = generationContext.addPostExitRuleTask(ruleContext.expression, () =>
	(
		topMethodCall
		ldc memberName
		invokeVirtualUnitMethodGetMember ()
	))
}

object GenerationRuleBytecodeMember
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:MemberContext):Unit =
		new GenerationRuleBytecodeMember(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:MemberContext):Unit =
		new GenerationRuleBytecodeMember(generationContext, ruleContext).exit()
}