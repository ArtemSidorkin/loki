package loki.language.generation.constant

import assembler.constant.InternalDescriptors
import assembler.methoddescriptor.{MixedMethodDescriptor, TypedMethodDescriptor}
import loki.runtime.context.LUnitContext
import loki.runtime.datatype.`type`.LType
import loki.runtime.datatype.unit.LUnit

//Split to different files
object BytecodeMethodDescriptors
{
	val TYPE__METHOD__INIT = 
		TypedMethodDescriptor((classOf[String] :: Nil) -> None)
	val TYPE__METHOD__CREATE_ANONYMOUS = 
		TypedMethodDescriptor(Nil -> Some(classOf[LType]))

	val UNIT_CONTEXT__METHOD__INIT =
		TypedMethodDescriptor(
			(classOf[LUnit] :: classOf[LUnit] :: classOf[LUnitContext] :: classOf[Array[LUnit]] :: Nil) -> None
		)
	val UNIT_CONTEXT__METHOD__GET_VARIABLE =
		TypedMethodDescriptor((classOf[String] :: Nil) -> Some(classOf[LUnit]))
	val UNIT_CONTEXT__METHOD__SET_VARIABLE =
		TypedMethodDescriptor((classOf[String] :: classOf[LUnit] :: Nil) -> Some(classOf[LUnit]))

	val MODULE_CONTEXT__METHOD__INIT =
		TypedMethodDescriptor(
			(classOf[LUnit] :: classOf[LUnit] :: classOf[Array[LUnit]] :: classOf[LUnitContext] :: Nil) -> None
		)

	val MODULE__METHOD__INIT =
		TypedMethodDescriptor((classOf[String] :: classOf[LUnitContext] :: Nil) -> None)

	val MODULE_HEIR__METHOD__INIT =
		TypedMethodDescriptor((classOf[LUnitContext] :: Nil) -> None)

	val UNIT__METHOD__INIT =
		TypedMethodDescriptor((classOf[LType] :: classOf[LUnitContext] :: Nil) -> None)

	def UNIT_HEIR__METHOD__INIT_1 =
		TypedMethodDescriptor(
			(
				classOf[LType] ::
				classOf[LUnitContext] ::
				Nil
			) -> None
		)
	def UNIT_HEIR__METHOD__INIT_2 =
		TypedMethodDescriptor(
			(
				classOf[LType] ::
				classOf[LUnitContext] ::
				classOf[Array[LUnit]] ::
				Nil
			) -> None
		)
	val UNIT__METHOD__GET_CAPTURED_ON_CREATION_UNIT_CONTEXT =
		TypedMethodDescriptor((Nil) -> Some(classOf[LUnitContext]))
	val UNIT__METHOD__ADD_PARENTS =
		TypedMethodDescriptor((classOf[Array[LUnit]] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__GET_SUPER_MEMBER =
		TypedMethodDescriptor((classOf[String] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__GET_MEMBER =
		TypedMethodDescriptor((classOf[String] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__SET_MEMBER =
		TypedMethodDescriptor((classOf[String] :: classOf[LUnit] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__GET_INDEXED_ITEM =
		TypedMethodDescriptor((classOf[LUnit] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__SET_INDEXED_ITEM =
		TypedMethodDescriptor((classOf[LUnit] :: classOf[LUnit] :: classOf[LUnit] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__SET_PARAMETER_NAMES =
		TypedMethodDescriptor((classOf[Array[String]] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__CALL =
		TypedMethodDescriptor((classOf[LUnit] :: classOf[Array[LUnit]] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__CALL_MEMBER =
		TypedMethodDescriptor((classOf[String] :: classOf[Array[LUnit]] :: Nil) -> Some(classOf[LUnit]))
	val UNIT__METHOD__CHECK_CALL_PARAMETER =
		MixedMethodDescriptor(
			(
				Left(classOf[Array[LUnit]]) ::
				Right(InternalDescriptors.PRIMITIVE_INT) :: Nil
			) -> Some(Left(classOf[LUnit]))
		)

	val UNIT__METHOD__TO_BOOLEAN = MixedMethodDescriptor(Nil -> Some(Right(InternalDescriptors.PRIMITIVE_BOOLEAN)))

	val UNIT__METHOD__TO_STRING = TypedMethodDescriptor(Nil -> Some(classOf[String]))

	val NUMBER__METHOD__INIT =
		MixedMethodDescriptor((Right(InternalDescriptors.PRIMITIVE_DOUBLE) :: Nil) -> None)

	val STRING__METHOD__INIT =
		TypedMethodDescriptor((classOf[String] :: Nil) -> None)

	val ARRAY__METHOD__INIT =
		TypedMethodDescriptor((classOf[Array[LUnit]] :: Nil) -> None)

	val MAP__METHOD__INIT =
		TypedMethodDescriptor((classOf[Array[LUnit]] :: Nil) -> None)

	val OBJECT__METHOD__INIT =
		TypedMethodDescriptor((classOf[Array[LUnit]] :: Nil) -> None)
}
