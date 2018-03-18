package loki.language.generation.bytecode.template

import assembler.builder.MethodBuilder
import loki.language.generation.bytecode.constant.BytecodeMethodDescriptors
import loki.runtime.datatype.LObject

private[bytecode] object ObjectBytecodeTemplate
{
	implicit class TemplateObject(method:MethodBuilder)
	{
		def invokeInitObject():MethodBuilder =
			method invokeinit (classOf[LObject], BytecodeMethodDescriptors.OBJECT__METHOD__INIT)
	}
}
