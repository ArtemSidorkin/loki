package loki.language.generation.bytecode.template

import assembler.builder.MethodBuilder
import loki.language.generation.bytecode.constant.BytecodeMethodDescriptors
import loki.runtime.datatype.LArray

private[bytecode] object ArrayBytecodeTemplate
{
	implicit class CTemplateArray(method:MethodBuilder)
	{
		def invokeInitArray() = method invokeinit
		(
			classOf[LArray], BytecodeMethodDescriptors.ARRAY__METHOD__INIT
		)
	}
}
