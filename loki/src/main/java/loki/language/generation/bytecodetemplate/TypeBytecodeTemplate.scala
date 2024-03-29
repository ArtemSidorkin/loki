package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import assembler.methoddescriptor.MethodDescriptorResolver
import loki.runtime.LUnitType
import loki.runtime.marker.compilerapi.`type`.TypeConstructor

private[generation] object TypeBytecodeTemplate
{
	implicit class TypeBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def invokeInitType():methodBuilder.type =
			methodBuilder.invokeinit(MethodDescriptorResolver(classOf[TypeConstructor]))
	}
}
