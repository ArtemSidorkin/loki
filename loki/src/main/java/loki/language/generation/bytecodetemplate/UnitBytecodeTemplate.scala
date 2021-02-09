package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import assembler.methoddescriptor.MethodDescriptorResolver
import loki.language.generation.constant.DynamicallyUnresolvableMethodDescriptors.SUBUNIT_INIT_METHOD_INVOCATION_DESCRIPTOR
import loki.language.generation.constant.{BytecodeLocalVariablesOrParameters, DynamicallyUnresolvableMethodDescriptors}
import loki.runtime.marker.compilerapi.unit._
import loki.runtime.unit.unit.LUnit

private[generation] object UnitBytecodeTemplate
{
	implicit class UnitBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def emptyUnitArray():methodBuilder.type =
			methodBuilder.getstatic (classOf[LUnit], "EMPTY_UNIT_ARRAY", classOf[Array[LUnit]])

		def aloadHostParameterOfUnitCallMethod():methodBuilder.type =
			methodBuilder.aload(BytecodeLocalVariablesOrParameters.UNIT__METHOD__CALL__PARAMETER__HOST)

		def aloadParametersParameterOfUnitCallMethod():methodBuilder.type =
			methodBuilder.aload(BytecodeLocalVariablesOrParameters.UNIT__METHOD__CALL__PARAMETER__PARAMETERS)

		def aloadUnitContextVariableOfUnitCallMethod():methodBuilder.type =
			methodBuilder.aload(BytecodeLocalVariablesOrParameters.UNIT__METHOD__CALL__VARIABLE__UNIT_CONTEXT)

		def astoreUnitContextVariableOfUnitCallMethod():methodBuilder.type =
			methodBuilder.astore(BytecodeLocalVariablesOrParameters.UNIT__METHOD__CALL__VARIABLE__UNIT_CONTEXT)

		def aloadUnitContextParameterOfSubunitInitMethod():methodBuilder.type =
			methodBuilder.aload(BytecodeLocalVariablesOrParameters.UNIT_HEIR__METHOD__INIT__PARAMETER__UNIT_CONTEXT)

		def aloadUnitHeirMethodInitParameterParameters():methodBuilder.type =
			methodBuilder.aload(BytecodeLocalVariablesOrParameters.UNIT_HEIR__METHOD__INIT__PARAMETER__PARAMETERS)

		def invokeVirtualUnitMethodGetCapturedUnitContext(classInternalName:String):methodBuilder.type =
			methodBuilder
				.invokevirtual(MethodDescriptorResolver(classOf[UnitGetCapturedUnitContext]))

		def invokeVirtualUnitSetTypeMethod():methodBuilder.type =
			methodBuilder.invokevirtual(MethodDescriptorResolver(classOf[UnitSetType]))

		def invokeVirtualUnitMethodAddParents():methodBuilder.type =
			methodBuilder.invokevirtual(MethodDescriptorResolver(classOf[UnitAddParents]))

		def invokeVirtualUnitGetSuperMemberMethod():methodBuilder.type =
			methodBuilder.invokevirtual(MethodDescriptorResolver(classOf[UnitGetSuperMember]))

		def invokeVirtualUnitMethodGetMember():methodBuilder.type =
			methodBuilder.invokevirtual(MethodDescriptorResolver(classOf[UnitGetMember]))

		def invokeVirtualUnitSetMemberMethod():methodBuilder.type =
			methodBuilder.invokevirtual(MethodDescriptorResolver(classOf[UnitSetMember]))

		def invokeVirtualUnitMethodGetIndexedItem():methodBuilder.type =
			methodBuilder.invokevirtual(MethodDescriptorResolver(classOf[UnitGetIndexedItem]))

		def invokeVirtualUnitSetIndexedItemMethod():methodBuilder.type =
			methodBuilder.invokevirtual(MethodDescriptorResolver(classOf[UnitSetIndexedItem]))

		def invokeVirtualUnitSetParameterNamesMethod():methodBuilder.type =
			methodBuilder.invokevirtual(MethodDescriptorResolver(classOf[UnitSetParameterNames]))

		def invokeVirtualUnitSetParameterDefaultValueMethod():methodBuilder.type =
			methodBuilder.invokevirtual(MethodDescriptorResolver(classOf[UnitSetParameterDefaultValue]))

		def invokeVirtualUnitMethodCall():methodBuilder.type =
			methodBuilder.invokevirtual(MethodDescriptorResolver(classOf[UnitCall]))

		def invokeVirtualUnitMethodCallMember():methodBuilder.type =
			methodBuilder.invokevirtual(MethodDescriptorResolver(classOf[UnitCallMember]))

		def invokeVirtualUnitMethodToBoolean():methodBuilder.type =
			methodBuilder.invokevirtual(MethodDescriptorResolver(classOf[UnitToBoolean]))

		def invokeVirtualUnitToStringMethod():methodBuilder.type =
			methodBuilder.invokevirtual(MethodDescriptorResolver(classOf[UnitToString]))

		def invokeInitUnit():methodBuilder.type =
			methodBuilder.invokeinit(MethodDescriptorResolver(classOf[UnitConstructor]))

		def invokeInitSubunit(initOwnerClassInternalName:String):methodBuilder.type =
			methodBuilder
				.invokeinit(SUBUNIT_INIT_METHOD_INVOCATION_DESCRIPTOR(Left(initOwnerClassInternalName)))
	}
}
