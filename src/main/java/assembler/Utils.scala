package assembler

import org.objectweb.asm.Type

object Utils
{
	def getClassInternalName(`class`:Class[_]):String = Type getInternalName `class`

	def getClassDescriptor(`class`:Class[_]):String = Type getDescriptor `class`

	def getClassDescriptor(internalClassName:String):String =
		if (internalClassName startsWith "[") internalClassName else s"L$internalClassName;"
}
