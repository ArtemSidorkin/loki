package cloki.language.generation.bytecode.templates

import assembler.builder.MethodBuilder
import cloki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import cloki.runtime.datatype.LArray

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
