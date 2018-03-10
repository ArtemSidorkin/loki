package loki.language.generation.bytecode.classbuilder

import assembler.const.PUBLIC
import loki.language.generation.bytecode.constant.BytecodeMethodDescriptors
import loki.language.generation.constant.LanguageMembers
import loki.runtime.datatype.LModule

private[bytecode] class ModuleFrameClassBuilder(name:String) extends FrameClassBuilder(name, classOf[LModule])
{
	val methodCall = addMethod(
		PUBLIC, LanguageMembers.UNIT__METHOD__CALL, BytecodeMethodDescriptors.UNIT__METHOD__CALL
	)
}
