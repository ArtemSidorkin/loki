package cloki.language.generation.bytecode.templates

import casm.entities.CAMethod
import cloki.runtime.datatype._
import cloki.runtime.context.{LModuleContext, LUnitContext}

private[bytecode] object CTemplateBytecodeCommon
{
	implicit class CTemplateCommon(method:CAMethod)
	{
		def anewarrayJavaString() = method anewarray classOf[String]
		def newUnitContext() = method `new` classOf[LUnitContext]
		def newModuleContext() = method `new` classOf[LModuleContext]
		def newType() = method `new` classOf[LType]
		def newNumber() = method `new` classOf[LNumber]
		def newString() = method `new` classOf[LString]
		def newArray() = method `new` classOf[LArray]
		def anewarrayUnit() = method anewarray classOf[LUnit]
		def void() = method getstatic (classOf[LVoid], "instance", classOf[LVoid])
	}
}
