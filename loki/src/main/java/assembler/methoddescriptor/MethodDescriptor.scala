package assembler.methoddescriptor

import assembler.InternalDescriptors.{INIT_METHOD, VOID}
import org.objectweb.asm.Type

class MethodDescriptor(val typedSignature:(Seq[Class[_]], Option[Class[_]]), val name:String, val static:Boolean)
{
	val untypedSignature:String =
		"(" +
			typedSignature._1.foldLeft("")((descriptor, `class`) => s"$descriptor${Type getDescriptor `class`}") +
		")" +
		typedSignature._2.foldLeft(VOID)((_, `class`) => Type.getDescriptor(`class`))

	val consumedStackOperandCount:Int =
		(if (!static) 1 else 0) + typedSignature._1.size - typedSignature._2.map(_ => 1).getOrElse(0)
}

object MethodDescriptor
{
	def initMethodDescriptor(typedSignature:Seq[Class[_]]):MethodDescriptor =
		new MethodDescriptor((typedSignature, None), INIT_METHOD, false)
}