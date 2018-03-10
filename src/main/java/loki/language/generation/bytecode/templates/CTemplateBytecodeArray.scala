package loki.language.generation.bytecode.templates

import assembler.builder.MethodBuilder
import loki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import loki.runtime.datatype.LArray

private[bytecode] object CTemplateBytecodeArray
{
	implicit class CTemplateArray(method:MethodBuilder)
	{
		def invokeInitArray() = method invokeinit
		(
			classOf[LArray], CConstBytecodeMethodDescriptors.ARRAY__METHOD__INIT
		)
	}
}
