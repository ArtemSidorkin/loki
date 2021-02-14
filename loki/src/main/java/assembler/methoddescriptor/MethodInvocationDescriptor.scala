package assembler.methoddescriptor

import assembler.Utils
import assembler.constant.InternalDescriptors

class MethodInvocationDescriptor(
	typedSignature:(Seq[Class[_]], Option[Class[_]]),
	name:String,
	static:Boolean,
	val ownerClassOrOwnerClassInternalName:Either[String, Class[_]]
)
	extends MethodDescriptor(typedSignature, name, static)
{
	val ownerClassInternalName:String =
		ownerClassOrOwnerClassInternalName match
		{
			case Right(ownerClass) => Utils.getClassInternalName(ownerClass)
			case Left(ownerClassInternalName) => ownerClassInternalName
		}
}

object MethodInvocationDescriptor
{
	def init(
		typedSignature:(Seq[Class[_]], Option[Class[_]]), ownerClassOrOwnerClassInternalName:Either[String, Class[_]]
	):MethodInvocationDescriptor =
		new MethodInvocationDescriptor(
			typedSignature, InternalDescriptors.INIT_METHOD, false, ownerClassOrOwnerClassInternalName
		)
}
