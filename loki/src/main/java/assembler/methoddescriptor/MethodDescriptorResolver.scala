package assembler.methoddescriptor

import java.lang.annotation.Annotation
import java.lang.reflect.Method
import java.util.concurrent.ConcurrentHashMap

import scala.jdk.CollectionConverters._

object MethodDescriptorResolver
{
	private val methodDescriptors:collection.concurrent.Map[(Class[_], Class[_]), MethodDescriptor] =
		new ConcurrentHashMap[(Class[_], Class[_]), MethodDescriptor]().asScala

	def apply(describingMethodAnnotationClass:Class[_ <: Annotation]):MethodDescriptor =
	{
		val describingMethodClass = getDescribingMethodClass(describingMethodAnnotationClass)

		methodDescriptors
			.getOrElseUpdate(
				(describingMethodClass, describingMethodAnnotationClass),
				createMethodDescriptor(describingMethodClass, describingMethodAnnotationClass)
			)
	}

	private def getDescribingMethodClass(describingMethodAnnotationClass:Class[_ <: Annotation]):Class[_] =
	{
		if (!describingMethodAnnotationClass.isAnnotationPresent(classOf[DescribingMethodClass]))
			throw new IllegalArgumentException(
				s"Describing method annotation class must contain ${classOf[DescribingMethodClass]}"
			)

		describingMethodAnnotationClass.getAnnotation(classOf[DescribingMethodClass]).value()
	}

	private def createMethodDescriptor(
		describingMethodClass:Class[_], describingMethodAnnotationClass:Class[_ <: Annotation]
	):MethodDescriptor =
	{
		val suitableExecutables =
			(describingMethodClass.getConstructors ++ describingMethodClass.getMethods)
				.filter(_.isAnnotationPresent(describingMethodAnnotationClass))
				.toSeq

		if (suitableExecutables.isEmpty) throw new IllegalArgumentException("Suitable executables are not found")
		if (suitableExecutables.size > 1) throw new IllegalArgumentException("Suitable executable must be only one")

		val suitableExecutable = suitableExecutables.head

		val parameterClasses = suitableExecutable.getParameters.map(_.getType)

		val returnClass =
			Some(suitableExecutable).filter(_.isInstanceOf[Method]).map(_.asInstanceOf[Method].getReturnType)

		MethodDescriptor(
			parameterClasses.toSeq -> returnClass, Some(Right(describingMethodClass)), Some(suitableExecutable.getName)
		)
	}
}
