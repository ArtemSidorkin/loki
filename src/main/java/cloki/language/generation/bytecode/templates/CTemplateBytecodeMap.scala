package cloki.language.generation.bytecode.templates

import assembler.builder.MethodBuilder
import cloki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import cloki.runtime.datatype.LMap

private[bytecode] object CTemplateBytecodeMap
{
	implicit class CTemplateMap(method:MethodBuilder)
	{
		def invokeInitMap():MethodBuilder =
			method invokeinit (classOf[LMap], CConstBytecodeMethodDescriptors.MAP__METHOD__INIT)
	}
}
