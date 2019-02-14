package loki.language.generation.classbuilder

import assembler.builder.{ClassBuilder, MethodBuilder}
import assembler.constant.PUBLIC
import loki.language.generation.constant.BytecodeCommon

abstract class FrameClassBuilder(name:String, parentClass:Class[_])
	extends ClassBuilder(BytecodeCommon.JAVA_VERSION, PUBLIC, name, parentClass)
{
	val methodCall:MethodBuilder
}
