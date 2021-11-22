package loki.language.generation.classbuilder

import assembler.builder.{ClassBuilder, MethodBuilder, PUBLIC}

abstract class FrameClassBuilder(name:String, parentClass:Class[_]) extends ClassBuilder(PUBLIC, name, parentClass)
{
	val methodCall:MethodBuilder
}
