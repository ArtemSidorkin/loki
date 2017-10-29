package cloki.language.generation.bytecode.templates

import casm.entities.CAMethod
import cloki.runtime.datatypes._
import cloki.runtime.unitcontexts.{CModuleContext, CUnitContext}

private[bytecode] object CTemplateBytecodeCommon
{
	implicit class CTemplateCommon(method:CAMethod)
	{
		def anewarrayJavaString() = method anewarray classOf[String]
		def newUnitContext() = method `new` classOf[CUnitContext]
		def newModuleContext() = method `new` classOf[CModuleContext]
		def newType() = method `new` classOf[CType]
		def newNumber() = method `new` classOf[CNumber]
		def newString() = method `new` classOf[CString]
		def newArray() = method `new` classOf[CArray]
		def anewarrayUnit() = method anewarray classOf[CUnit]
		def void() = method getstatic (classOf[CVoid], "instance", classOf[CVoid])
	}
}
