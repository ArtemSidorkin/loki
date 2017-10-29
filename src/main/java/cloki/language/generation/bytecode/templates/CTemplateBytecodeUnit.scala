package cloki.language.generation.bytecode.templates

import casm.entities.CAMethod
import cloki.language.generation.bytecode.consts.{CConstBytecodeLocalVariablesOrParameters, CConstBytecodeMethodDescriptors}
import cloki.language.generation.consts.CConstLanguageMembers
import cloki.runtime.datatype.LUnit
import cloki.runtime.context.LUnitContext

private[bytecode] object CTemplateBytecodeUnit
{
	implicit class CTemplateUnit(method:CAMethod)
	{
		def aloadUnitMethodCallParameterHost() =
			method aload CConstBytecodeLocalVariablesOrParameters.UNIT__METHOD__CALL__PARAMETER__HOST

		def aloadUnitMethodCallParameterParameters() =
			method aload CConstBytecodeLocalVariablesOrParameters.UNIT__METHOD__CALL__PARAMETER__PARAMETERS

		def aloadUnitMethodCallVariableUnitContext() =
			method aload CConstBytecodeLocalVariablesOrParameters.UNIT__METHOD__CALL__VARIABLE__UNIT_CONTEXT

		def astoreUnitMethodCallVariableUnitContext() =
			method astore CConstBytecodeLocalVariablesOrParameters.UNIT__METHOD__CALL__VARIABLE__UNIT_CONTEXT

		def aloadUnitHeirMethodInitParameterType() =
			method aload CConstBytecodeLocalVariablesOrParameters.UNIT_HEIR__METHOD__INIT__PARAMETER__TYPE

		def aloadUnitHeirMethodInitParameterUnitContext() =
			method aload CConstBytecodeLocalVariablesOrParameters.UNIT_HEIR__METHOD__INIT__PARAMETER__UNIT_CONTEXT

		def aloadUnitHeirMethodInitParameterParameters() =
			method aload CConstBytecodeLocalVariablesOrParameters.UNIT_HEIR__METHOD__INIT__PARAMETER__PARAMETERS

		def getUnitFieldUnitContext(classInternalName:String) = method getfield
		(
			classInternalName,
			CConstLanguageMembers.UNIT__FIELD__UNIT_CONTEXT,
			classOf[LUnitContext]
		)

		def invokeVirtualUnitMethodAddParent() = method invokevirtual
		(
			classOf[LUnit],
			CConstLanguageMembers.UNIT__METHOD__ADD_PARENT,
			CConstBytecodeMethodDescriptors.UNIT__METHOD__ADD_PARENT
		)

		def invokeVirtualUnitMethodGetSuperMember() = method invokevirtual
		(
			classOf[LUnit],
			CConstLanguageMembers.UNIT__METHOD__GET_SUPER_MEMBER,
			CConstBytecodeMethodDescriptors.UNIT__METHOD__GET_SUPER_MEMBER
		)

		def invokeVirtualUnitMethodGetMember() = method invokevirtual
		(
			classOf[LUnit],
			CConstLanguageMembers.UNIT__METHOD__GET_MEMBER,
			CConstBytecodeMethodDescriptors.UNIT__METHOD__GET_MEMBER
		)

		def invokeVirtualUnitMethodSetMember() = method invokevirtual
		(
			classOf[LUnit],
			CConstLanguageMembers.UNIT__METHOD__SET_MEMBER,
			CConstBytecodeMethodDescriptors.UNIT__METHOD__SET_MEMBER
		)

		def invokeVirtualUnitMethodGetIndexedItem() = method invokevirtual
		(
			classOf[LUnit],
			CConstLanguageMembers.UNIT__METHOD__GET_INDEXED_ITEM,
			CConstBytecodeMethodDescriptors.UNIT__METHOD__GET_INDEXED_ITEM
		)

		def invokeVirtualUnitMethodSetIndexedItem() = method invokevirtual
		(
			classOf[LUnit],
			CConstLanguageMembers.UNIT__METHOD__SET_INDEXED_ITEM,
			CConstBytecodeMethodDescriptors.UNIT__METHOD__SET_INDEXED_ITEM
		)

		def invokeVirtualUnitMethodSetParameterNames() = method invokevirtual
		(
			classOf[LUnit],
			CConstLanguageMembers.UNIT__METHOD__SET_PARAMETER_NAMES,
			CConstBytecodeMethodDescriptors.UNIT__METHOD__SET_PARAMETER_NAMES
		)

		def invokeVirtualUnitMethodCall() = method invokevirtual
		(
			classOf[LUnit],
			CConstLanguageMembers.UNIT__METHOD__CALL,
			CConstBytecodeMethodDescriptors.UNIT__METHOD__CALL
		)

		def invokeVirtualUnitMethodCallMember() = method invokevirtual
		(
			classOf[LUnit],
			CConstLanguageMembers.UNIT__METHOD__CALL_MEMBER,
			CConstBytecodeMethodDescriptors.UNIT__METHOD__CALL_MEMBER
		)

		def invokeVirtualUnitMethodCheckCallParameter() = method invokevirtual //unused
		(
			classOf[LUnit],
			CConstLanguageMembers.UNIT__METHOD__CHECK_CALL_PARAMETER,
			CConstBytecodeMethodDescriptors.UNIT__METHOD__CHECK_CALL_PARAMETER
		)

		def invokeVirtualUnitMethodToBoolean() = method invokevirtual
		(
			classOf[LUnit],
			CConstLanguageMembers.UNIT__METHOD__TO_BOOLEAN,
			CConstBytecodeMethodDescriptors.UNIT__METHOD__TO_BOOLEAN
		)

		def invokeInitUnit() = method invokeinit
		(
			classOf[LUnit], CConstBytecodeMethodDescriptors.UNIT__METHOD__INIT
		)

		def invokeInit1UnitHeir(initOwnerClassInternalName:String, outerClassDescriptor:String) = method invokeinit
		(
			initOwnerClassInternalName,
			CConstBytecodeMethodDescriptors UNIT_HEIR__METHOD__INIT_1 outerClassDescriptor
		)

		def invokeInit2UnitHeir(initOwnerClassInternalName:String, outerClassDescriptor:String) = method invokeinit
		(
			initOwnerClassInternalName,
			CConstBytecodeMethodDescriptors UNIT_HEIR__METHOD__INIT_2 outerClassDescriptor
		)
	}
}
