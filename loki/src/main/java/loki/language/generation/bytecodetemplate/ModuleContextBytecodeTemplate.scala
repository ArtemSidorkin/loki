package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import assembler.methoddescriptor.MethodDescriptorResolver
import loki.runtime.compilerapi.modulecontext.ModuleContextConstructor

private[generation] object ModuleContextBytecodeTemplate
{
	implicit class ModuleContextBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def invokeInitModuleContext():methodBuilder.type =
			methodBuilder.invokeinit(MethodDescriptorResolver(classOf[ModuleContextConstructor]))
	}
}
