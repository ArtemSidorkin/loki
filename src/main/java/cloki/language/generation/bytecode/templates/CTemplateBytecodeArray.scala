package cloki.language.generation.bytecode.templates

import casm.entities.CAMethod
import cloki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import cloki.runtime.datatype.{LArray, LString}

private[bytecode] object CTemplateBytecodeArray
{
	implicit class CTemplateArray(method:CAMethod)
	{
		def invokeInitArray() = method invokeinit
		(
			classOf[LArray], CConstBytecodeMethodDescriptors.ARRAY__METHOD__INIT
		)
	}
}
