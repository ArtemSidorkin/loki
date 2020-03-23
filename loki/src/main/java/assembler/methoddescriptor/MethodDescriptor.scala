package assembler.methoddescriptor

import assembler.Utils
import assembler.constant.InternalDescriptors
import org.objectweb.asm.Type

case class MethodDescriptor(
	typedSignature:(Seq[Class[_]], Option[Class[_]]),
	ownerClassOrOwnerClassInternalName:Option[Either[String, Class[_]]] = None,
	name:Option[String] = None
)
{
	private[assembler] val untypedSignature:String =
		"(" +
			typedSignature._1.foldLeft("")((descriptor, `class`) => s"$descriptor${Type getDescriptor `class`}") +
		")" +
		typedSignature._2.foldLeft(InternalDescriptors.VOID)((_, `class`) => Type getDescriptor `class`)

	val ownerClassInternalName:Option[String] =
		ownerClassOrOwnerClassInternalName map
		{
			case Right(ownerClass) => Utils.getClassInternalName(ownerClass)
			case Left(ownerClassInternalName) => ownerClassInternalName
		}
}
