package loki.language.generation.classbuilder

import assembler.builder.MethodBuilder
import assembler.constant.PUBLIC
import assembler.methoddescriptor.MethodDescriptorResolver
import loki.runtime.compilerapi.unit.UnitCall
import loki.runtime.unit.LModule

class ModuleFrameClassBuilder(name:String) extends FrameClassBuilder(name, classOf[LModule])
{
	val methodCall:MethodBuilder =
		addMethod(
			PUBLIC,
			MethodDescriptorResolver(classOf[UnitCall]).methodName.get, MethodDescriptorResolver(classOf[UnitCall])
		)
}
