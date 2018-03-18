package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.MemberAccessorContext

class MemberAccessorBytecodeGenerationRule(
	bytecodeGenerationContext:BytecodeGenerationContext, memberAccessorContext:MemberAccessorContext
)
	extends BytecodeGenerationRule(bytecodeGenerationContext, memberAccessorContext)
{
	override protected def enterAction():Unit = ()

	override protected def exitAction():Unit = (
			topMethodCall
				invokeVirtualUnitMethodToString ()
				invokeVirtualUnitMethodGetMember ()
				decrementObjectCounter ()
	)
}