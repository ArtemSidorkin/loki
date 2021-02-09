package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import assembler.methoddescriptor.MethodDescriptorResolver
import loki.runtime.marker.compilerapi.unitcontext.{UnitContextConstructor, UnitContextGetAnonymousParameter, UnitContextGetVariable, UnitContextSetVariable}

private[generation] object UnitContextBytecodeTemplate
{
	implicit class UnitContextBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def invokeVirtualUnitContextMethodGetAnonymousParameter():methodBuilder.type =
			methodBuilder
				.invokevirtual(MethodDescriptorResolver(classOf[UnitContextGetAnonymousParameter]))

		def invokeInitUnitContext():methodBuilder.type =
			methodBuilder.invokeinit(MethodDescriptorResolver(classOf[UnitContextConstructor]))

		def invokeVirtualUnitContextGetVariableMethod():methodBuilder.type =
			methodBuilder
				.invokevirtual(MethodDescriptorResolver(classOf[UnitContextGetVariable]))

		def invokeVirtualUnitContextSetVariableMethod():methodBuilder.type =
			methodBuilder
				.invokevirtual(MethodDescriptorResolver(classOf[UnitContextSetVariable]))
	}
}
