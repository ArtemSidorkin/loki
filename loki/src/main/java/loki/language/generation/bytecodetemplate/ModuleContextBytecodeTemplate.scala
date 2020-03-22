package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import assembler.methoddescriptor.MethodDescriptorResolver
import loki.runtime.compilerapi.modulecontext.ModuleContextConstructor
import loki.runtime.context.LModuleContext

private[generation] object ModuleContextBytecodeTemplate
{
	implicit class ModuleContextBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def invokeInitModuleContext():methodBuilder.type =
			methodBuilder
				.invokeinit(classOf[LModuleContext], MethodDescriptorResolver.apply(classOf[ModuleContextConstructor]))
	}
}
