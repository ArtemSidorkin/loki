package loki.language.generation.bytecodetemplate

import assembler.builder.MethodBuilder
import loki.language.generation.constant.{BytecodeLocalVariablesOrParameters, BytecodeMethodDescriptors}
import loki.language.generation.constant.LanguageMembers
import loki.runtime.context.LUnitContext
import loki.runtime.datatype.unit.LUnit

object UnitBytecodeTemplate
{
	implicit class CTemplateUnit(method:MethodBuilder)
	{
		def aloadUnitMethodCallParameterHost() =
			method aload BytecodeLocalVariablesOrParameters.UNIT__METHOD__CALL__PARAMETER__HOST

		def aloadUnitMethodCallParameterParameters() =
			method aload BytecodeLocalVariablesOrParameters.UNIT__METHOD__CALL__PARAMETER__PARAMETERS

		def aloadUnitMethodCallVariableUnitContext() =
			method aload BytecodeLocalVariablesOrParameters.UNIT__METHOD__CALL__VARIABLE__UNIT_CONTEXT

		def astoreUnitMethodCallVariableUnitContext() =
			method astore BytecodeLocalVariablesOrParameters.UNIT__METHOD__CALL__VARIABLE__UNIT_CONTEXT

		def aloadUnitHeirMethodInitParameterType() =
			method aload BytecodeLocalVariablesOrParameters.UNIT_HEIR__METHOD__INIT__PARAMETER__TYPE

		def aloadUnitHeirMethodInitParameterUnitContext() =
			method aload BytecodeLocalVariablesOrParameters.UNIT_HEIR__METHOD__INIT__PARAMETER__UNIT_CONTEXT

		def aloadUnitHeirMethodInitParameterParameters() =
			method aload BytecodeLocalVariablesOrParameters.UNIT_HEIR__METHOD__INIT__PARAMETER__PARAMETERS

		def invokeVirtualUnitMethodGetCapturedOnCreationUnitContext(classInternalName:String) = method invokevirtual
		(
			classInternalName,
			LanguageMembers.UNIT__METHOD__GET_CAPTURED_ON_CREATION_UNIT_CONTEXT,
			BytecodeMethodDescriptors.UNIT__METHOD__GET_CAPTURED_ON_CREATION_UNIT_CONTEXT
		)

		def invokeVirtualUnitMethodAddParents() = method invokevirtual
		(
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__ADD_PARENTS,
			BytecodeMethodDescriptors.UNIT__METHOD__ADD_PARENTS
		)

		def invokeVirtualUnitMethodGetSuperMember() = method invokevirtual
		(
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__GET_SUPER_MEMBER,
			BytecodeMethodDescriptors.UNIT__METHOD__GET_SUPER_MEMBER
		)

		def invokeVirtualUnitMethodGetMember() = method invokevirtual
		(
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__GET_MEMBER,
			BytecodeMethodDescriptors.UNIT__METHOD__GET_MEMBER
		)

		def invokeVirtualUnitMethodSetMember() = method invokevirtual
		(
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__SET_MEMBER,
			BytecodeMethodDescriptors.UNIT__METHOD__SET_MEMBER
		)

		def invokeVirtualUnitMethodGetIndexedItem() = method invokevirtual
		(
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__GET_INDEXED_ITEM,
			BytecodeMethodDescriptors.UNIT__METHOD__GET_INDEXED_ITEM
		)

		def invokeVirtualUnitMethodSetIndexedItem() = method invokevirtual
		(
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__SET_INDEXED_ITEM,
			BytecodeMethodDescriptors.UNIT__METHOD__SET_INDEXED_ITEM
		)

		def invokeVirtualUnitMethodSetParameterNames() = method invokevirtual
		(
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__SET_PARAMETER_NAMES,
			BytecodeMethodDescriptors.UNIT__METHOD__SET_PARAMETER_NAMES
		)

		def invokeVirtualUnitMethodCall() = method invokevirtual
		(
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__CALL,
			BytecodeMethodDescriptors.UNIT__METHOD__CALL
		)

		def invokeVirtualUnitMethodCallMember() = method invokevirtual
		(
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__CALL_MEMBER,
			BytecodeMethodDescriptors.UNIT__METHOD__CALL_MEMBER
		)

		def invokeVirtualUnitMethodToBoolean() = method invokevirtual
		(
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__TO_BOOLEAN,
			BytecodeMethodDescriptors.UNIT__METHOD__TO_BOOLEAN
		)

		def invokeVirtualUnitMethodToString() = method invokevirtual
		(
			classOf[LUnit],
			LanguageMembers.UNIT__METHOD__TO_STRING,
			BytecodeMethodDescriptors.UNIT__METHOD__TO_STRING
		)

		def invokeInitUnit() = method invokeinit
		(
			classOf[LUnit], BytecodeMethodDescriptors.UNIT__METHOD__INIT
		)

		def invokeInit1UnitHeir(initOwnerClassInternalName:String) = method invokeinit
		(
			initOwnerClassInternalName,
			BytecodeMethodDescriptors UNIT_HEIR__METHOD__INIT_1
		)

		def invokeInit2UnitHeir(initOwnerClassInternalName:String) = method invokeinit
		(
			initOwnerClassInternalName,
			BytecodeMethodDescriptors UNIT_HEIR__METHOD__INIT_2
		)
	}
}
