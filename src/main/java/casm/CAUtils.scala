package casm

import org.objectweb.asm.Type

object CAUtils
{
	def getClassInternalName(`class`:Class[_]) = Type getInternalName `class`

	def getClassDescriptor(`class`:Class[_]) = Type getDescriptor `class`

	def getClassDescriptor(classInternalName:String) =
		if (classInternalName startsWith "[") classInternalName else s"L$classInternalName;"
}
