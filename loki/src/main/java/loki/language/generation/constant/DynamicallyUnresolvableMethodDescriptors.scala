package loki.language.generation.constant

import assembler.methoddescriptor.{MethodDescriptor, MethodInvocationDescriptor}
import loki.runtime.context.LUnitContext
import loki.runtime.unit.unit.LUnit

object DynamicallyUnresolvableMethodDescriptors
{
	final val SUBMODULE_INIT_METHOD_DESCRIPTOR = MethodDescriptor.init(Nil -> None)

	final val SUBUNIT_INIT_METHOD_DESCRIPTOR =
		MethodDescriptor.init((classOf[LUnitContext] :: classOf[Array[LUnit]] :: Nil) -> None)

	final val SUBUNIT_INIT_METHOD_INVOCATION_DESCRIPTOR =
		MethodInvocationDescriptor.init(SUBUNIT_INIT_METHOD_DESCRIPTOR.typedSignature, _:Either[String, Class[_]])

	final val CONTAINER_INIT_METHOD_INVOCATION_DESCRIPTOR =
		MethodInvocationDescriptor.init((classOf[Array[LUnit]] :: Nil) -> None, _:Either[String, Class[_]])

	final val JAVA_OBJECT_GET_CLASS_INVOCATION_METHOD_DESCRIPTOR =
		new MethodInvocationDescriptor(Nil -> Some(classOf[Class[_]]), "getClass", false, Right(classOf[Object]))
}
