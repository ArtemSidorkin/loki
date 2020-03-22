package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import assembler.methoddescriptor.MethodDescriptorResolver
import loki.language.generation.constant.{BytecodeLocalVariablesOrParameters, BytecodeMethodDescriptors, LanguageMembers}
import loki.runtime.compilerapi.unit.{UnitAddParents, UnitCall, UnitCallMember, UnitConstructor, UnitGetCapturedUnitContext, UnitGetIndexedItem, UnitGetMember, UnitGetSuperMember, UnitSetIndexedItem, UnitSetMember, UnitSetParameterNames, UnitSetType, UnitToBoolean, UnitToString}
import loki.runtime.unit.unit.LUnit

private[generation] object UnitBytecodeTemplate
{
	implicit class UnitBytecodeTemplate(val methodBuilder:MethodBuilder)
	{
		def emptyUnitArray():methodBuilder.type =
			methodBuilder getstatic (classOf[LUnit], "EMPTY_UNIT_ARRAY", classOf[Array[LUnit]])

		def aloadUnitMethodCallParameterHost():methodBuilder.type =
			methodBuilder aload BytecodeLocalVariablesOrParameters.UNIT__METHOD__CALL__PARAMETER__HOST

		def aloadUnitMethodCallParameterParameters():methodBuilder.type =
			methodBuilder aload BytecodeLocalVariablesOrParameters.UNIT__METHOD__CALL__PARAMETER__PARAMETERS

		def aloadUnitMethodCallVariableUnitContext():methodBuilder.type =
			methodBuilder aload BytecodeLocalVariablesOrParameters.UNIT__METHOD__CALL__VARIABLE__UNIT_CONTEXT

		def astoreUnitMethodCallVariableUnitContext():methodBuilder.type =
			methodBuilder astore BytecodeLocalVariablesOrParameters.UNIT__METHOD__CALL__VARIABLE__UNIT_CONTEXT

		def aloadUnitHeirMethodInitParameterUnitContext():methodBuilder.type =
			methodBuilder aload BytecodeLocalVariablesOrParameters.UNIT_HEIR__METHOD__INIT__PARAMETER__UNIT_CONTEXT

		def aloadUnitHeirMethodInitParameterParameters():methodBuilder.type =
			methodBuilder aload BytecodeLocalVariablesOrParameters.UNIT_HEIR__METHOD__INIT__PARAMETER__PARAMETERS

		def invokeVirtualUnitMethodGetCapturedUnitContext(classInternalName:String):methodBuilder.type =
			methodBuilder
				.invokevirtual(classInternalName, MethodDescriptorResolver(classOf[UnitGetCapturedUnitContext]))

		def invokeVirtualUnitMethodSetType():methodBuilder.type =
			methodBuilder.invokevirtual(classOf[LUnit], MethodDescriptorResolver(classOf[UnitSetType]))

		def invokeVirtualUnitMethodAddParents():methodBuilder.type =
			methodBuilder.invokevirtual(classOf[LUnit], MethodDescriptorResolver(classOf[UnitAddParents]))

		def invokeVirtualUnitMethodGetSuperMember():methodBuilder.type =
			methodBuilder.invokevirtual(classOf[LUnit], MethodDescriptorResolver(classOf[UnitGetSuperMember]))

		def invokeVirtualUnitMethodGetMember():methodBuilder.type =
			methodBuilder.invokevirtual(classOf[LUnit], MethodDescriptorResolver(classOf[UnitGetMember]))

		def invokeVirtualUnitMethodSetMember():methodBuilder.type =
			methodBuilder.invokevirtual(classOf[LUnit], MethodDescriptorResolver(classOf[UnitSetMember]))

		def invokeVirtualUnitMethodGetIndexedItem():methodBuilder.type =
			methodBuilder.invokevirtual(classOf[LUnit],	MethodDescriptorResolver(classOf[UnitGetIndexedItem]))

		def invokeVirtualUnitMethodSetIndexedItem():methodBuilder.type =
			methodBuilder.invokevirtual(classOf[LUnit], MethodDescriptorResolver(classOf[UnitSetIndexedItem]))

		def invokeVirtualUnitMethodSetParameterNames():methodBuilder.type =
			methodBuilder.invokevirtual(classOf[LUnit], MethodDescriptorResolver(classOf[UnitSetParameterNames]))

		def invokeVirtualUnitMethodCall():methodBuilder.type =
			methodBuilder.invokevirtual(classOf[LUnit], MethodDescriptorResolver(classOf[UnitCall]))

		def invokeVirtualUnitMethodCallMember():methodBuilder.type =
			methodBuilder.invokevirtual(classOf[LUnit], MethodDescriptorResolver(classOf[UnitCallMember]))

		def invokeVirtualUnitMethodToBoolean():methodBuilder.type =
			methodBuilder.invokevirtual(classOf[LUnit], MethodDescriptorResolver(classOf[UnitToBoolean]))

		def invokeVirtualUnitMethodToString():methodBuilder.type =
			methodBuilder.invokevirtual(classOf[LUnit], MethodDescriptorResolver(classOf[UnitToString]))

		def invokeInitUnit():methodBuilder.type = methodBuilder invokeinit (
			classOf[LUnit], MethodDescriptorResolver(classOf[UnitConstructor])
		)

		def invokeInit2UnitHeir(initOwnerClassInternalName:String):methodBuilder.type = methodBuilder invokeinit (
			initOwnerClassInternalName,
			BytecodeMethodDescriptors.UNIT_HEIR__METHOD__INIT_2
		)
	}
}
