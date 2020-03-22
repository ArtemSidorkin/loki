package loki.language.generation.classbuilder

import assembler.builder.MethodBuilder
import assembler.constant.PUBLIC
import assembler.methoddescriptor.MethodDescriptorResolver
import loki.runtime.compilerapi.unit.UnitCall
import loki.runtime.unit.unit.LUnit

class UnitFrameClassBuilder(name:String) extends FrameClassBuilder(name, classOf[LUnit])
{
	val methodCall:MethodBuilder = addMethod(PUBLIC, MethodDescriptorResolver(classOf[UnitCall]))
}
