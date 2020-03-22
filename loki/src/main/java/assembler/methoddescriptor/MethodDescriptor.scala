package assembler.methoddescriptor

import assembler.constant.InternalDescriptors
import org.objectweb.asm.Type

case class MethodDescriptor(typedSignature:(Seq[Class[_]], Option[Class[_]]), name:Option[String] = None)
{
	private[assembler] val untypedSignature:String =
		"(" +
			typedSignature._1.foldLeft("")((descriptor, `class`) => s"$descriptor${Type getDescriptor `class`}") +
		")" +
		typedSignature._2.foldLeft(InternalDescriptors.VOID)((_, `class`) => Type getDescriptor `class`)
}
