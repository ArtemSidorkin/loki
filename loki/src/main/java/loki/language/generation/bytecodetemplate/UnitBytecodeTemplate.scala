package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import loki.language.generation.constant.{BytecodeLocalVariablesOrParameters, BytecodeMethodDescriptors, LanguageMembers}
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
			methodBuilder invokevirtual (
				classInternalName,
				LanguageMembers.UNIT__METHOD__GET_CAPTURED_UNIT_CONTEXT,
				BytecodeMethodDescriptors.UNIT__METHOD__GET_CAPTURED_ON_CREATION_UNIT_CONTEXT
			)

		def invokeVirtualUnitMethodSetType():methodBuilder.type = methodBuilder invokevirtual (
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__SET_TYPE,
			BytecodeMethodDescriptors.UNIT__METHOD__SET_TYPE
		)

		def invokeVirtualUnitMethodAddParents():methodBuilder.type = methodBuilder invokevirtual (
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__ADD_PARENTS,
			BytecodeMethodDescriptors.UNIT__METHOD__ADD_PARENTS
		)

		def invokeVirtualUnitMethodGetSuperMember():methodBuilder.type = methodBuilder invokevirtual (
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__GET_SUPER_MEMBER,
			BytecodeMethodDescriptors.UNIT__METHOD__GET_SUPER_MEMBER
		)

		def invokeVirtualUnitMethodGetMember():methodBuilder.type = methodBuilder invokevirtual (
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__GET_MEMBER,
			BytecodeMethodDescriptors.UNIT__METHOD__GET_MEMBER
		)

		def invokeVirtualUnitMethodSetMember():methodBuilder.type = methodBuilder invokevirtual (
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__SET_MEMBER,
			BytecodeMethodDescriptors.UNIT__METHOD__SET_MEMBER
		)

		def invokeVirtualUnitMethodGetIndexedItem():methodBuilder.type = methodBuilder invokevirtual (
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__GET_INDEXED_ITEM,
			BytecodeMethodDescriptors.UNIT__METHOD__GET_INDEXED_ITEM
		)

		def invokeVirtualUnitMethodSetIndexedItem():methodBuilder.type = methodBuilder invokevirtual (
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__SET_INDEXED_ITEM,
			BytecodeMethodDescriptors.UNIT__METHOD__SET_INDEXED_ITEM
		)

		def invokeVirtualUnitMethodSetParameterNames():methodBuilder.type = methodBuilder invokevirtual (
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__SET_PARAMETER_NAMES,
			BytecodeMethodDescriptors.UNIT__METHOD__SET_PARAMETER_NAMES
		)

		def invokeVirtualUnitMethodCall():methodBuilder.type = methodBuilder invokevirtual (
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__CALL,
			BytecodeMethodDescriptors.UNIT__METHOD__CALL
		)

		def invokeVirtualUnitMethodCallMember():methodBuilder.type = methodBuilder invokevirtual (
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__CALL_MEMBER,
			BytecodeMethodDescriptors.UNIT__METHOD__CALL_MEMBER
		)

		def invokeVirtualUnitMethodToBoolean():methodBuilder.type = methodBuilder invokevirtual (
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__TO_BOOLEAN,
			BytecodeMethodDescriptors.UNIT__METHOD__TO_BOOLEAN
		)

		def invokeVirtualUnitMethodToString():methodBuilder.type = methodBuilder invokevirtual (
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__TO_STRING,
			BytecodeMethodDescriptors.UNIT__METHOD__TO_STRING
		)

		def invokeInitUnit():methodBuilder.type = methodBuilder invokeinit (
			classOf[LUnit], BytecodeMethodDescriptors.UNIT__METHOD__INIT
		)

		def invokeInit2UnitHeir(initOwnerClassInternalName:String):methodBuilder.type = methodBuilder invokeinit (
			initOwnerClassInternalName,
			BytecodeMethodDescriptors.UNIT_HEIR__METHOD__INIT_2
		)
	}
}
