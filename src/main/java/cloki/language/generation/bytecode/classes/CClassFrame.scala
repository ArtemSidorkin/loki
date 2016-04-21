package cloki.language.generation.bytecode.classes

import casm.consts.PUBLIC
import casm.entities.{CAClass, CAMethod}
import cloki.language.generation.bytecode.consts.CConstBytecodeCommon

private[bytecode] abstract class CClassFrame(name:String, parentClass:Class[_])
	extends CAClass(CConstBytecodeCommon.JAVA_VERSION, PUBLIC, name, parentClass)
{
	val methodCall:CAMethod
}
