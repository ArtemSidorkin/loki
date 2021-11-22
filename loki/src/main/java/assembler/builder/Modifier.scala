package assembler.builder

import org.objectweb.asm.Opcodes

sealed class Modifier(private[builder] val code:Int)
{
	def & (modifier:Modifier) = new Modifier(code | modifier.code)
}

object SYNTHETIC extends Modifier(Opcodes.ACC_SYNTHETIC)
object FINAL extends Modifier(Opcodes.ACC_FINAL)
object PUBLIC extends Modifier(Opcodes.ACC_PUBLIC)
object PROTECTED extends Modifier(Opcodes.ACC_PROTECTED)
object PRIVATE extends Modifier(Opcodes.ACC_PRIVATE)



