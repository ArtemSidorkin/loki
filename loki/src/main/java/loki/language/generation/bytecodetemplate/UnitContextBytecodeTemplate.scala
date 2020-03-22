package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import assembler.methoddescriptor.MethodDescriptorResolver
import loki.runtime.compilerapi.unitcontext.{UnitContextConstructor, UnitContextGetVariable, UnitContextSetVariable}
import loki.runtime.context.LUnitContext

private[generation] object UnitContextBytecodeTemplate
{
	implicit class UnitContextBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def invokeVirtualUnitContextMethodGetVariable():methodBuilder.type =
			methodBuilder
				.invokevirtual(classOf[LUnitContext], MethodDescriptorResolver(classOf[UnitContextGetVariable]))

		def invokeVirtualUnitContextMethodSetVariable():methodBuilder.type =
			methodBuilder
				.invokevirtual(classOf[LUnitContext], MethodDescriptorResolver(classOf[UnitContextSetVariable]))

		def invokeInitUnitContext():methodBuilder.type =
			methodBuilder.invokeinit(classOf[LUnitContext], MethodDescriptorResolver(classOf[UnitContextConstructor]))
	}
}
