package cloki.language.generation.bytecode.classes

import assembler.const.PUBLIC
import assembler.builder.{ClassBuilder, MethodBuilder}
import cloki.language.generation.bytecode.consts.CConstBytecodeCommon

private[bytecode] abstract class CClassFrame(name:String, parentClass:Class[_])
	extends ClassBuilder(CConstBytecodeCommon.JAVA_VERSION, PUBLIC, name, parentClass)
{
	val methodCall:MethodBuilder
}
