package cloki.language.generation.bytecode.consts

import casm.consts.CAConstInternalDescriptors
import casm.methoddescriptors.{CAMethodDescriptorMixed, CAMethodDescriptorTyped}
import cloki.runtime.datatypes.{CType, CUnit}
import cloki.runtime.unitcontexts.CUnitContext

//Split to different files
private[bytecode] object CConstBytecodeMethodDescriptors
{
	val TYPE__METHOD__INIT = 
		CAMethodDescriptorTyped((classOf[String] :: Nil) -> None)
	val TYPE__METHOD__CREATE_ANONYMOUS = 
		CAMethodDescriptorTyped(Nil -> Some(classOf[CType]))

	val UNIT_CONTEXT__METHOD__INIT =
		CAMethodDescriptorTyped(
			(classOf[CUnit] :: classOf[CUnit] :: classOf[CUnitContext] :: classOf[Array[CUnit]] :: Nil) -> None
		)
	val UNIT_CONTEXT__METHOD__GET_VARIABLE =
		CAMethodDescriptorTyped((classOf[String] :: Nil) -> Some(classOf[CUnit]))
	val UNIT_CONTEXT__METHOD__SET_VARIABLE =
		CAMethodDescriptorTyped((classOf[String] :: classOf[CUnit] :: Nil) -> Some(classOf[CUnit]))

	val MODULE_CONTEXT__METHOD__INIT =
		CAMethodDescriptorTyped(
			(classOf[CUnit] :: classOf[CUnit] :: classOf[Array[CUnit]] :: classOf[CUnitContext] :: Nil) -> None
		)

	val MODULE__METHOD__INIT =
		CAMethodDescriptorTyped((classOf[String] :: classOf[CUnitContext] :: Nil) -> None)

	val MODULE_HEIR__METHOD__INIT =
		CAMethodDescriptorTyped((classOf[CUnitContext] :: Nil) -> None)

	val UNIT__METHOD__INIT =
		CAMethodDescriptorTyped((classOf[CType] :: classOf[CUnitContext] :: Nil) -> None)

	def UNIT_HEIR__METHOD__INIT_1(outerClassDescriptor:String) =
		CAMethodDescriptorMixed(
			(
				Right(outerClassDescriptor) ::
				Left(classOf[CType]) ::
				Left(classOf[CUnitContext]) ::
				Nil
			) -> None
		)
	def UNIT_HEIR__METHOD__INIT_2(outerClassDescriptor:String) =
		CAMethodDescriptorMixed(
			(
				Right(outerClassDescriptor) ::
				Left(classOf[CType]) ::
				Left(classOf[CUnitContext]) ::
				Left(classOf[Array[CUnit]]) ::
				Nil
			) -> None
		)
	val UNIT__METHOD__ADD_PARENT =
		CAMethodDescriptorTyped((classOf[CUnit] :: Nil) -> Some(classOf[CUnit]))
	val UNIT__METHOD__GET_SUPER_MEMBER =
		CAMethodDescriptorTyped((classOf[String] :: Nil) -> Some(classOf[CUnit]))
	val UNIT__METHOD__GET_MEMBER =
		CAMethodDescriptorTyped((classOf[String] :: Nil) -> Some(classOf[CUnit]))
	val UNIT__METHOD__SET_MEMBER =
		CAMethodDescriptorTyped((classOf[String] :: classOf[CUnit] :: Nil) -> Some(classOf[CUnit]))
	val UNIT__METHOD__GET_INDEXED_ITEM =
		CAMethodDescriptorTyped((classOf[Array[CUnit]] :: Nil) -> Some(classOf[CUnit]))
	val UNIT__METHOD__SET_INDEXED_ITEM =
		CAMethodDescriptorTyped((classOf[Array[CUnit]] :: Nil) -> Some(classOf[CUnit]))
	val UNIT__METHOD__SET_PARAMETER_NAMES =
		CAMethodDescriptorTyped((classOf[Array[String]] :: Nil) -> Some(classOf[CUnit]))
	val UNIT__METHOD__CALL =
		CAMethodDescriptorTyped((classOf[CUnit] :: classOf[Array[CUnit]] :: classOf[CUnitContext] :: Nil) -> Some(classOf[CUnit]))
	val UNIT__METHOD__CALL_MEMBER =
		CAMethodDescriptorTyped((classOf[String] :: classOf[Array[CUnit]] :: classOf[CUnitContext] :: Nil) -> Some(classOf[CUnit]))
	val UNIT__METHOD__CHECK_CALL_PARAMETER =
		CAMethodDescriptorMixed(
			(
				Left(classOf[Array[CUnit]]) ::
				Right(CAConstInternalDescriptors.PRIMITIVE_INT) :: Nil
			) -> Some(Left(classOf[CUnit]))
		)

	val UNIT__METHOD__TO_BOOLEAN =
		CAMethodDescriptorMixed(Nil -> Some(Right(CAConstInternalDescriptors.PRIMITIVE_BOOLEAN)))

	val NUMBER__METHOD__INIT =
		CAMethodDescriptorMixed((Right(CAConstInternalDescriptors.PRIMITIVE_DOUBLE) :: Nil) -> None)

	val STRING__METHOD__INIT =
		CAMethodDescriptorTyped((classOf[String] :: Nil) -> None)

	val ARRAY__METHOD__INIT =
		CAMethodDescriptorTyped((classOf[Array[CUnit]] :: Nil) -> None)
}
