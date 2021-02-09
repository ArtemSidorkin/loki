package assembler.methoddescriptor

import assembler.constant.InternalDescriptors

object MethodDescriptors
{
	def methodDescriptor(typedSignature:(Seq[Class[_]], Option[Class[_]]), name:String):MethodDescriptor =
		new MethodDescriptor(typedSignature, name)

	def methodInvocationDescriptor(
		methodDescriptor:MethodDescriptor
	):Either[String, Class[_]]=>MethodInvocationDescriptor =
		methodInvocationDescriptor(methodDescriptor, _:Either[String, Class[_]])

	def methodInvocationDescriptor(
		methodDescriptor:MethodDescriptor, ownerClassOrOwnerClassInternalName:Either[String, Class[_]]
	):MethodInvocationDescriptor =
		methodInvocationDescriptor(
			methodDescriptor.typedSignature, methodDescriptor.name, ownerClassOrOwnerClassInternalName
		)

	def methodInvocationDescriptor(
		typedSignature:(Seq[Class[_]], Option[Class[_]]),
		name:String,
		ownerClassOrOwnerClassInternalName:Either[String, Class[_]]
	):MethodInvocationDescriptor =
		new MethodInvocationDescriptor(typedSignature, name, ownerClassOrOwnerClassInternalName)

	def initMethodDescriptor(typedSignature:(Seq[Class[_]], Option[Class[_]])):MethodDescriptor =
		new MethodDescriptor(typedSignature, InternalDescriptors.INIT_METHOD)

	def initMethodInvocationDescriptor(
		typedSignature:(Seq[Class[_]], Option[Class[_]]),
		ownerClassOrOwnerClassInternalName:Either[String, Class[_]]
	):MethodInvocationDescriptor =
		new MethodInvocationDescriptor(
			typedSignature, InternalDescriptors.INIT_METHOD, ownerClassOrOwnerClassInternalName
		)
}
