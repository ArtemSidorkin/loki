package loki.language.generation.bytecode.classes

import assembler.const.PUBLIC
import loki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import loki.language.generation.consts.CConstLanguageMembers
import loki.runtime.datatype.LUnit

private[bytecode] class CClassUnit(name:String) extends CClassFrame(name, classOf[LUnit])
{
	val methodCall = addMethod(
		PUBLIC, CConstLanguageMembers.UNIT__METHOD__CALL, CConstBytecodeMethodDescriptors.UNIT__METHOD__CALL
	)
}
