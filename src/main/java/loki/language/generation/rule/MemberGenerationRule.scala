package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.MemberContext


private[generation] class MemberGenerationRule(generationContext:GenerationContext, memberContext:MemberContext)
	extends GenerationRule(generationContext, memberContext)
{
	private def memberName = memberContext.IDENTIFIER.getText

	override protected def enterAction():Unit =
		generationContext
			.addPostExitRuleTask(
				memberContext.expression,
				() => (
					topMethodCall
						ldc memberName
						invokeVirtualUnitMethodGetMember ()
				)
			)
}

private[generation] object MemberGenerationRule
{
	def enter(generationContext:GenerationContext, memberContext:MemberContext):Unit =
		new MemberGenerationRule(generationContext, memberContext).enter()

	def exit(generationContext:GenerationContext, memberContext:MemberContext):Unit =
		new MemberGenerationRule(generationContext, memberContext).exit()
}