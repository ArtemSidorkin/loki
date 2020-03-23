package loki.language.generation.constant

import assembler.methoddescriptor.MethodDescriptor
import loki.runtime.context.LUnitContext
import loki.runtime.unit.unit.LUnit

object DynamicallyUnresolvableMethodDescriptors
{
	final val SUBMODULE_CONSTRUCTOR = MethodDescriptor(Nil -> None)

	final val SUBUNIT_CONSTRUCTOR =
		MethodDescriptor(
			(classOf[LUnitContext] :: classOf[Array[LUnit]] :: Nil) -> None, _:Option[Either[String, Class[_]]]
		)

	final val CONTAINER_CONSTRUCTOR =
		MethodDescriptor((classOf[Array[LUnit]] :: Nil) -> None, _:Option[Either[String, Class[_]]])

	final val JAVA_OBJECT_GET_CLASS =
		MethodDescriptor(Nil -> Some(classOf[Class[_]]), Some(Right(classOf[Object])), Some("getClass"))
}
