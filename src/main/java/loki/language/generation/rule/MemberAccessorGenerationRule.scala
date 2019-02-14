package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.MemberAccessorContext

class MemberAccessorGenerationRule(
											  bytecodeGenerationContext:GenerationContext, memberAccessorContext:MemberAccessorContext
)
	extends GenerationRule(bytecodeGenerationContext, memberAccessorContext)
{
	override protected def enterAction():Unit = ()

	override protected def exitAction():Unit = (
			topMethodCall
				invokeVirtualUnitMethodToString ()
				invokeVirtualUnitMethodGetMember ()
				decrementObjectCounter ()
	)
}

object MemberAccessorGenerationRule
{
	def enter(bytecodeGenerationContext:GenerationContext, memberAccessorContext:MemberAccessorContext):Unit =
		new MemberAccessorGenerationRule(bytecodeGenerationContext, memberAccessorContext).enter()

	def exit(bytecodeGenerationContext:GenerationContext, memberAccessorContext:MemberAccessorContext):Unit =
		new MemberAccessorGenerationRule(bytecodeGenerationContext, memberAccessorContext).exit()
}