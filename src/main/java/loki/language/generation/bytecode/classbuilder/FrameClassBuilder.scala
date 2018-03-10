package loki.language.generation.bytecode.classbuilder

import assembler.builder.{ClassBuilder, MethodBuilder}
import assembler.const.PUBLIC
import loki.language.generation.bytecode.constant.BytecodeCommon

private[bytecode] abstract class FrameClassBuilder(name:String, parentClass:Class[_])
	extends ClassBuilder(BytecodeCommon.JAVA_VERSION, PUBLIC, name, parentClass)
{
	val methodCall:MethodBuilder
}
