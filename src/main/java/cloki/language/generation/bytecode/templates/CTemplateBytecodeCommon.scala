package cloki.language.generation.bytecode.templates

import assembler.builder.MethodBuilder
import cloki.runtime.context.{LModuleContext, LUnitContext}
import cloki.runtime.datatype._
import cloki.runtime.datatype.number.LNumber

private[bytecode] object CTemplateBytecodeCommon
{
	implicit class CTemplateCommon(method:MethodBuilder)
	{
		def anewarrayJavaString() = method anewarray classOf[String]
		def newUnitContext() = method `new` classOf[LUnitContext]
		def newModuleContext() = method `new` classOf[LModuleContext]
		def newType() = method `new` classOf[LType]
		def newNumber() = method `new` classOf[LNumber]
		def newString() = method `new` classOf[LString]
		def newArray() = method `new` classOf[LArray]
		def newMap() = method `new` classOf[LMap]
		def anewarrayUnit() = method anewarray classOf[LUnit]
		def void() = method getstatic (classOf[LVoid], "instance", classOf[LVoid])
	}
}
