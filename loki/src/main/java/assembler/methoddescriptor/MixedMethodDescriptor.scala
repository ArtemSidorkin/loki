package assembler.methoddescriptor

import assembler.constant.InternalDescriptors
import org.objectweb.asm.Type

case class MixedMethodDescriptor(mixedDescriptor:(Seq[Either[Class[_], String]], Option[Either[Class[_], String]]))
	extends MethodDescriptor
{
	override val methodName: Option[String] = None

	override private[assembler] val untypedDescriptor:String =
		mixedDescriptor
			._1
			.foldLeft("(")((descriptor, classOrClassDescriptor) =>
				if (classOrClassDescriptor.isLeft) s"$descriptor${Type getDescriptor classOrClassDescriptor.left.toOption.get}"
				else s"$descriptor${classOrClassDescriptor.toOption.get}"
			) +
		")" +
		mixedDescriptor
			._2
			.foldLeft(InternalDescriptors.VOID)((_, classOrClassDescriptor) =>
				if (classOrClassDescriptor.isLeft) Type getDescriptor classOrClassDescriptor.left.toOption.get
				else classOrClassDescriptor.toOption.get
			)
}
