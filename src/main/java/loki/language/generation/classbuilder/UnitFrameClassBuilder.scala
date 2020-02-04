package loki.language.generation.classbuilder

import assembler.constant.PUBLIC
import loki.language.generation.constant.BytecodeMethodDescriptors
import loki.language.generation.constant.LanguageMembers
import loki.runtime.unit.unit.LUnit

class UnitFrameClassBuilder(name:String) extends FrameClassBuilder(name, classOf[LUnit])
{
	val methodCall = addMethod(
		PUBLIC, LanguageMembers.UNIT__METHOD__CALL, BytecodeMethodDescriptors.UNIT__METHOD__CALL
	)
}
