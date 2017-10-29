package cloki.language.generation.bytecode.classes

import casm.consts.PUBLIC
import cloki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import cloki.language.generation.consts.CConstLanguageMembers
import cloki.runtime.datatype.LUnit

private[bytecode] class CClassUnit(name:String) extends CClassFrame(name, classOf[LUnit])
{
	val methodCall = addMethod(
		PUBLIC, CConstLanguageMembers.UNIT__METHOD__CALL, CConstBytecodeMethodDescriptors.UNIT__METHOD__CALL
	)
}
