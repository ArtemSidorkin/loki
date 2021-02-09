package loki.language.generation.constant

import assembler.methoddescriptor.MethodDescriptors
import assembler.methoddescriptor.MethodDescriptors.{initMethodDescriptor, initMethodInvocationDescriptor, methodInvocationDescriptor}
import loki.runtime.context.LUnitContext
import loki.runtime.unit.unit.LUnit

object DynamicallyUnresolvableMethodDescriptors
{
	final val SUBMODULE_INIT_METHOD_DESCRIPTOR = initMethodDescriptor(Nil -> None)

	final val SUBUNIT_INIT_METHOD_DESCRIPTOR =
		initMethodDescriptor((classOf[LUnitContext] :: classOf[Array[LUnit]] :: Nil) -> None)

	final val SUBUNIT_INIT_METHOD_INVOCATION_DESCRIPTOR = methodInvocationDescriptor(SUBUNIT_INIT_METHOD_DESCRIPTOR)

	final val CONTAINER_INIT_METHOD_INVOCATION_DESCRIPTOR =
		initMethodInvocationDescriptor((classOf[Array[LUnit]] :: Nil) -> None, _:Either[String, Class[_]])

	final val JAVA_OBJECT_GET_CLASS_INVOCATION_METHOD_DESCRIPTOR =
		MethodDescriptors.methodInvocationDescriptor(Nil -> Some(classOf[Class[_]]), "getClass", Right(classOf[Object]))
}
