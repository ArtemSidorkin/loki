package cloki.language.generation.bytecode.consts

import casm.consts.CAConstInternalDescriptors
import casm.methoddescriptors.{CAMethodDescriptorMixed, CAMethodDescriptorTyped}
import cloki.runtime.datatype.{LType, LUnit}
import cloki.runtime.context.LUnitContext

//Split to different files
private[bytecode] object CConstBytecodeMethodDescriptors
{
	val TYPE__METHOD__INIT = 
		CAMethodDescriptorTyped((classOf[String] :: Nil) -> None)
	val TYPE__METHOD__CREATE_ANONYMOUS = 
		CAMethodDescriptorTyped(Nil -> Some(classOf[LType]))

	val UNIT_CONTEXT__METHOD__INIT =
		CAMethodDescriptorTyped(
			(classOf[LUnit] :: classOf[LUnit] :: classOf[LUnitContext] :: classOf[Array[LUnit]] :: Nil) -> None
		)
	val UNIT_CONTEXT__METHOD__GET_VARIABLE =
		CAMethodDescriptorTyped((classOf[String] :: Nil) -> Some(classOf[LUnit]))
	val UNIT_CONTEXT__METHOD__SET_VARIABLE =
		CAMethodDescriptorTyped((classOf[String] :: classOf[LUnit] :: Nil) -> Some(classOf[LUnit]))

	val MODULE_CONTEXT__METHOD__INIT =
		CAMethodDescriptorTyped(
			(classOf[LUnit] :: classOf[LUnit] :: classOf[Array[LUnit]] :: classOf[LUnitContext] :: Nil) -> None
		)

	val MODULE__METHOD__INIT =
		CAMethodDescriptorTyped((classOf[String] :: classOf[LUnitContext] :: Nil) -> None)

	val MODULE_HEIR__METHOD__INIT =
		CAMethodDescriptorTyped((classOf[LUnitContext] :: Nil) -> None)

	val UNIT__METHOD__INIT =
		CAMethodDescriptorTyped((classOf[LType] :: classOf[LUnitContext] :: Nil) -> None)

	def UNIT_HEIR__METHOD__INIT_1(outerClassDescriptor:String) =
		CAMethodDescriptorMixed(
			(
				Right(outerClassDescriptor) ::
				Left(classOf[LType]) ::
				Left(classOf[LUnitContext]) ::
				Nil
			) -> None
		)
	def UNIT_HEIR__METHOD__INIT_2(outerClassDescriptor:String) =
		CAMethodDescriptorMixed(
			(
				Right(outerClassDescriptor) ::
				Left(classOf[LType]) ::
				Left(classOf[LUnitContext]) ::
				Left(classOf[Array[LUnit]]) ::
				Nil
			) -> None
		)
	val UNIT__METHOD__ADD_PARENT =
		CAMethodDescriptorTyped((classOf[LUnit] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__GET_SUPER_MEMBER =
		CAMethodDescriptorTyped((classOf[String] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__GET_MEMBER =
		CAMethodDescriptorTyped((classOf[String] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__SET_MEMBER =
		CAMethodDescriptorTyped((classOf[String] :: classOf[LUnit] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__GET_INDEXED_ITEM =
		CAMethodDescriptorTyped((classOf[Array[LUnit]] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__SET_INDEXED_ITEM =
		CAMethodDescriptorTyped((classOf[Array[LUnit]] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__SET_PARAMETER_NAMES =
		CAMethodDescriptorTyped((classOf[Array[String]] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__CALL =
		CAMethodDescriptorTyped((classOf[LUnit] :: classOf[Array[LUnit]] :: classOf[LUnitContext] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__CALL_MEMBER =
		CAMethodDescriptorTyped((classOf[String] :: classOf[Array[LUnit]] :: classOf[LUnitContext] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__CHECK_CALL_PARAMETER =
		CAMethodDescriptorMixed(
			(
				Left(classOf[Array[LUnit]]) ::
				Right(CAConstInternalDescriptors.PRIMITIVE_INT) :: Nil
			) -> Some(Left(classOf[LUnit]))
		)

	val UNIT__METHOD__TO_BOOLEAN =
		CAMethodDescriptorMixed(Nil -> Some(Right(CAConstInternalDescriptors.PRIMITIVE_BOOLEAN)))

	val NUMBER__METHOD__INIT =
		CAMethodDescriptorMixed((Right(CAConstInternalDescriptors.PRIMITIVE_DOUBLE) :: Nil) -> None)

	val STRING__METHOD__INIT =
		CAMethodDescriptorTyped((classOf[String] :: Nil) -> None)

	val ARRAY__METHOD__INIT =
		CAMethodDescriptorTyped((classOf[Array[LUnit]] :: Nil) -> None)
}
