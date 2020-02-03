package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.MemberAccessorContext

private[generation] class MemberAccessorGenerationRule
	(memberAccessorContext:MemberAccessorContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(memberAccessorContext)
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
	def enter(memberAccessorContext:MemberAccessorContext)(implicit generationContext:GenerationContext):Unit =
		new MemberAccessorGenerationRule(memberAccessorContext).enter()

	def exit(memberAccessorContext:MemberAccessorContext)(implicit generationContext:GenerationContext):Unit =
		new MemberAccessorGenerationRule(memberAccessorContext).exit()
}