package assembler.methoddescriptor

import assembler.InternalDescriptors.INIT_METHOD
import assembler.Utils.getClassInternalName

class MethodInvocationDescriptor(
	typedSignature:(Seq[Class[_]], Option[Class[_]]), name:String, static:Boolean, val ownerClassInternalName:String
)
	extends MethodDescriptor(typedSignature, name, static)
{
	def this(typedSignature:(Seq[Class[_]], Option[Class[_]]), name:String, static:Boolean, ownerClass:Class[_]) =
		this(typedSignature, name, static, getClassInternalName(ownerClass))
}

object MethodInvocationDescriptor
{
	def init(typedSignature:Seq[Class[_]], ownerClass:Class[_]):MethodInvocationDescriptor =
		new MethodInvocationDescriptor((typedSignature, None), INIT_METHOD, false, ownerClass)

	def init(typedSignature:Seq[Class[_]], ownerClassInternalName:String):MethodInvocationDescriptor =
		new MethodInvocationDescriptor((typedSignature, None), INIT_METHOD, false, ownerClassInternalName)
}
