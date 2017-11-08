package assembler.const

import org.objectweb.asm.Opcodes

sealed class Modifier(private[assembler] val code:Int)
{
	def & (modifier:Modifier) = new Modifier(this.code | modifier.code)
}

object SYNTHETIC extends Modifier(Opcodes.ACC_SYNTHETIC)
object PUBLIC extends Modifier(Opcodes.ACC_PUBLIC)
object PROTECTED extends Modifier(Opcodes.ACC_PROTECTED)
object PRIVATE extends Modifier(Opcodes.ACC_PRIVATE)
object FINAL extends Modifier(Opcodes.ACC_FINAL)



