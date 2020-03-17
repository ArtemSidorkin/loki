package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.MemberContext

private[generation] class MemberGenerationRule
	(memberContext:MemberContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(memberContext)
{
	private def memberName = memberContext.IDENTIFIER.getText

	override protected def enterAction():Unit =
		generationContext
			.addPostExitRuleTask(
				memberContext.expression,
				() =>
					topMethodCall
						.ldc(memberName)
						.invokeVirtualUnitMethodGetMember()
			)
}

private[generation] object MemberGenerationRule
{
	def enter(memberContext:MemberContext)(implicit generationContext:GenerationContext):Unit =
		new MemberGenerationRule(memberContext).enter()

	def exit(memberContext:MemberContext)(implicit generationContext:GenerationContext):Unit =
		new MemberGenerationRule(memberContext).exit()
}