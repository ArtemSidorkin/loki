package loki.language.generation.bytecode.template

import assembler.builder.MethodBuilder
import loki.runtime.context.{LModuleContext, LUnitContext}
import loki.runtime.datatype._
import loki.runtime.datatype.`type`.LType
import loki.runtime.datatype.number.LNumber
import loki.runtime.datatype.unit.LUnit

private[bytecode] object CommonBytecodeTemplate
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
		def newObject() = method `new` classOf[LObject]
		def anewarrayUnit() = method anewarray classOf[LUnit]
		def void() = method getstatic (classOf[LVoid], "instance", classOf[LVoid])
	}
}
