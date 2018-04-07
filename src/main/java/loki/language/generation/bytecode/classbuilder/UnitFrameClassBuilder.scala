package loki.language.generation.bytecode.classbuilder

import assembler.constant.PUBLIC
import loki.language.generation.bytecode.constant.BytecodeMethodDescriptors
import loki.language.generation.constant.LanguageMembers
import loki.runtime.datatype.unit.LUnit

private[bytecode] class UnitFrameClassBuilder(name:String) extends FrameClassBuilder(name, classOf[LUnit])
{
	val methodCall = addMethod(
		PUBLIC, LanguageMembers.UNIT__METHOD__CALL, BytecodeMethodDescriptors.UNIT__METHOD__CALL
	)
}
