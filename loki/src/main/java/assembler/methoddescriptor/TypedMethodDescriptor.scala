package assembler.methoddescriptor

import assembler.constant.InternalDescriptors
import org.objectweb.asm.Type

case class TypedMethodDescriptor(typedDescriptor:(Seq[Class[_]], Option[Class[_]]), _name:Option[String] = None) extends MethodDescriptor
{
	override val methodName:Option[String] = _name

	override private[assembler] val untypedDescriptor:String =
		"(" +
			typedDescriptor._1.foldLeft("")((descriptor, `class`) => s"$descriptor${Type getDescriptor `class`}") +
		")" +
		typedDescriptor._2.foldLeft(InternalDescriptors.VOID)((_, `class`) => Type getDescriptor `class`)
}
