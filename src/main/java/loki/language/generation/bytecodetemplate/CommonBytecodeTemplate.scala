package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import loki.runtime.context.{LModuleContext, LUnitContext}
import loki.runtime.datatype._
import loki.runtime.datatype.`type`.LType
import loki.runtime.datatype.number.LNumber
import loki.runtime.datatype.unit.LUnit

object CommonBytecodeTemplate
{
	implicit class CTemplateCommon(method:MethodBuilder)
	{
		def anewarrayJavaString():method.type = method anewarray classOf[String]
		def newUnitContext():method.type = method `new` classOf[LUnitContext]
		def newModuleContext():method.type = method `new` classOf[LModuleContext]
		def newType():method.type = method `new` classOf[LType]
		def newNumber():method.type = method `new` classOf[LNumber]
		def newString():method.type = method `new` classOf[LString]
		def newArray():method.type = method `new` classOf[LArray]
		def newMap():method.type = method `new` classOf[LMap]
		def newObject():method.type = method `new` classOf[LObject]
		def anewarrayUnit():method.type = method anewarray classOf[LUnit]
		def void():method.type = method getstatic (classOf[LVoid], "instance", classOf[LVoid])
	}
}
