package assembler.methoddescriptor

import assembler.Utils

class MethodInvocationDescriptor private[methoddescriptor](
	typedSignature:(Seq[Class[_]], Option[Class[_]]),
	name:String,
	private[assembler] val ownerClassOrOwnerClassInternalName:Either[String, Class[_]]
)
	extends MethodDescriptor(typedSignature, name)
{
	val ownerClassInternalName:String =
		ownerClassOrOwnerClassInternalName match
		{
			case Right(ownerClass) => Utils.getClassInternalName(ownerClass)
			case Left(ownerClassInternalName) => ownerClassInternalName
		}
}
