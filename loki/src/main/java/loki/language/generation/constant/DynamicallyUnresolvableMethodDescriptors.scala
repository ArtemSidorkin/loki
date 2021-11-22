package loki.language.generation.constant

import assembler.methoddescriptor.MethodDescriptor.initMethodDescriptor
import assembler.methoddescriptor.MethodInvocationDescriptor
import loki.runtime.context.LUnitContext
import loki.runtime.unit.unit.LUnit

object DynamicallyUnresolvableMethodDescriptors
{
	final val SUBMODULE_INIT_METHOD_DESCRIPTOR = initMethodDescriptor(Nil)

	final val SUBUNIT_INIT_METHOD_DESCRIPTOR =
		initMethodDescriptor(classOf[LUnitContext] :: classOf[Array[LUnit]] :: Nil)

	final val SUBUNIT_INIT_METHOD_INVOCATION_DESCRIPTOR =
		MethodInvocationDescriptor.init(SUBUNIT_INIT_METHOD_DESCRIPTOR.typedSignature._1, _:String)

	final val CONTAINER_INIT_METHOD_INVOCATION_DESCRIPTOR =
		MethodInvocationDescriptor.init(classOf[Array[LUnit]] :: Nil, _:Class[_])

	final val JAVA_OBJECT_GET_CLASS_INVOCATION_METHOD_DESCRIPTOR =
		new MethodInvocationDescriptor(Nil -> Some(classOf[Class[_]]), "getClass", false, classOf[Object])
}
