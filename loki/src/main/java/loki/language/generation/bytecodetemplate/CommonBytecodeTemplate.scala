package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import assembler.methoddescriptor.TypedMethodDescriptor
import loki.language.generation.constant.{BytecodeMethodDescriptors, LanguageMembers}
import loki.runtime.LType
import loki.runtime.context.{LModuleContext, LUnitContext}
import loki.runtime.unit.data.number.LNumber
import loki.runtime.unit.data.{LArray, LMap, LObject, LString}
import loki.runtime.unit.data.singleton.LVoid
import loki.runtime.unit.unit.LUnit

private[generation] object CommonBytecodeTemplate
{
	implicit class CommonBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def anewarrayJavaString():methodBuilder.type = methodBuilder anewarray classOf[String]

		def newUnitContext():methodBuilder.type = methodBuilder `new` classOf[LUnitContext]

		def newModuleContext():methodBuilder.type = methodBuilder `new` classOf[LModuleContext]

		def newType():methodBuilder.type = methodBuilder `new` classOf[LType]

		def newNumber():methodBuilder.type = methodBuilder `new` classOf[LNumber]

		def newString():methodBuilder.type = methodBuilder `new` classOf[LString]

		def newArray():methodBuilder.type = methodBuilder `new` classOf[LArray]

		def newMap():methodBuilder.type = methodBuilder `new` classOf[LMap]

		def newObject():methodBuilder.type = methodBuilder `new` classOf[LObject]

		//TODO: find and check array creators which do not use approach like this (arraySize as parameter)
		def anewarrayUnit(arraySize:Int):methodBuilder.type = (
			methodBuilder
				ldc arraySize
				anewarray classOf[LUnit]
		)

		def anewarrayUnit():methodBuilder.type = methodBuilder anewarray classOf[LUnit]

//		//TODO: move instance to constants
		def void():methodBuilder.type = (
			methodBuilder
				invokestatic
				(classOf[LVoid], "getInstance", TypedMethodDescriptor(Nil -> Some(classOf[LVoid])))
		)

		def invokeVirtualJavaObjectMethodGetClass():methodBuilder.type = methodBuilder invokevirtual (
			classOf[Object],
			LanguageMembers.JAVA_OBJECT__METHOD__GET_CLASS,
			BytecodeMethodDescriptors.JAVA_OBJECT__METHOD__GET_CLASS
		)
	}
}
