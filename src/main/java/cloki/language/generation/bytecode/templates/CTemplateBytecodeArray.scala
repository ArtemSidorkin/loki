package cloki.language.generation.bytecode.templates

import casm.entities.CAMethod
import cloki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import cloki.runtime.datatypes.{CArray, CString}

private[bytecode] object CTemplateBytecodeArray
{
	implicit class CTemplateArray(method:CAMethod)
	{
		def invokeInitArray() = method invokeinit
		(
			classOf[CArray], CConstBytecodeMethodDescriptors.ARRAY__METHOD__INIT
		)
	}
}
