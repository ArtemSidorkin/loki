package loki.language.generation.bytecode.template

import assembler.builder.MethodBuilder
import loki.language.generation.bytecode.constant.BytecodeMethodDescriptors
import loki.runtime.datatype.LMap

private[bytecode] object MapBytecodeTemplate
{
	implicit class CTemplateMap(method:MethodBuilder)
	{
		def invokeInitMap():MethodBuilder =
			method invokeinit (classOf[LMap], BytecodeMethodDescriptors.MAP__METHOD__INIT)
	}
}
