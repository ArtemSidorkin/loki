package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.rules.mixins.MemberGenerationRuleMixin
import loki.language.parsing.LokiParser.MemberContext

class MemberBytecodeGenerationRule(generationContext:BytecodeGenerationContext, ruleContext:MemberContext)
	extends BytecodeGenerationRule(generationContext, ruleContext) with MemberGenerationRuleMixin
{
	override protected def enterAction() = generationContext.addPostExitRuleTask(ruleContext.expression, () =>
	(
		topMethodCall
		ldc memberName
		invokeVirtualUnitMethodGetMember ()
	))
}

object MemberBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:MemberContext):Unit =
		new MemberBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:MemberContext):Unit =
		new MemberBytecodeGenerationRule(generationContext, ruleContext).exit()
}