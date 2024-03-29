package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import assembler.methoddescriptor.MethodDescriptorResolver
import loki.language.generation.constant.DynamicallyUnresolvableMethodDescriptors
import loki.runtime.LUnitType
import loki.runtime.marker.compilerapi.common.VoidGetInstance
import loki.runtime.context.{LModuleContext, LUnitContext}
import loki.runtime.unit.data.array.LArray
import loki.runtime.unit.data.number.LNumber
import loki.runtime.unit.data.{LMap, LObject, LString}
import loki.runtime.unit.unit.LUnit

private[generation] object CommonBytecodeTemplate
{
	implicit class CommonBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def anewarrayJavaString():methodBuilder.type = methodBuilder anewarray classOf[String]

		def newUnitContext():methodBuilder.type = methodBuilder `new` classOf[LUnitContext]

		def newModuleContext():methodBuilder.type = methodBuilder `new` classOf[LModuleContext]

		def newType():methodBuilder.type = methodBuilder `new` classOf[LUnitType]

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

		def void():methodBuilder.type = methodBuilder.invokestatic(MethodDescriptorResolver(classOf[VoidGetInstance]))

		def invokeVirtualJavaObjectGetClassMethod():methodBuilder.type =
			methodBuilder.invokevirtual(DynamicallyUnresolvableMethodDescriptors.JAVA_OBJECT_GET_CLASS_INVOCATION_METHOD_DESCRIPTOR)
	}
}
