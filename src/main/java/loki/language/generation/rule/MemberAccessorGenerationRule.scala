package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.MemberAccessorContext


private[generation] class MemberAccessorGenerationRule(
	generationContext:GenerationContext, memberAccessorContext:MemberAccessorContext
)
	extends GenerationRule(generationContext, memberAccessorContext)
{
	override protected def enterAction():Unit = ()

	override protected def exitAction():Unit = (
		topMethodCall
			invokeVirtualUnitMethodToString ()
			invokeVirtualUnitMethodGetMember ()
			decrementObjectCounter ()
	)
}

private[generation] object MemberAccessorGenerationRule
{
	def enter(generationContext:GenerationContext, memberAccessorContext:MemberAccessorContext):Unit =
		new MemberAccessorGenerationRule(generationContext, memberAccessorContext).enter()

	def exit(generationContext:GenerationContext, memberAccessorContext:MemberAccessorContext):Unit =
		new MemberAccessorGenerationRule(generationContext, memberAccessorContext).exit()
}