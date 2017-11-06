package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationMember
import cloki.language.parsing.LokiParser.MemberContext

class GenerationRuleBytecodeMember(generationContext:CGenerationContextBytecode, ruleContext:MemberContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with CMixinRuleGenerationMember
{
	override def __enter() = generationContext.addPostExitRuleTask(ruleContext.expression, () =>
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