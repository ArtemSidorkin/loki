package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.MemberContext

class MemberGenerationRule(generationContext:GenerationContext, ruleContext:MemberContext)
	extends GenerationRule(generationContext, ruleContext)
{
	private val memberName = ruleContext.IDENTIFIER.getText

	override protected def enterAction():Unit = generationContext.addPostExitRuleTask(ruleContext.expression, () =>
	(
		topMethodCall
		ldc memberName
		invokeVirtualUnitMethodGetMember ()
	))
}

object MemberGenerationRule
{
	def enter(generationContext:GenerationContext, ruleContext:MemberContext):Unit =
		new MemberGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:GenerationContext, ruleContext:MemberContext):Unit =
		new MemberGenerationRule(generationContext, ruleContext).exit()
}