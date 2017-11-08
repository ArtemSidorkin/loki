package cloki.language.generation.bytecode.classes

import assembler.const.PUBLIC
import cloki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import cloki.language.generation.consts.CConstLanguageMembers
import cloki.runtime.datatype.LModule

private[bytecode] class CClassModule(name:String) extends CClassFrame(name, classOf[LModule])
{
	val methodCall = addMethod(
		PUBLIC, CConstLanguageMembers.UNIT__METHOD__CALL, CConstBytecodeMethodDescriptors.UNIT__METHOD__CALL
	)
}
