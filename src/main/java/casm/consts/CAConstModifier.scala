package casm.consts

import org.objectweb.asm.Opcodes

sealed class CAConstModifier(private[casm] val modifierCode:Int)
{
	def & (modifier:CAConstModifier) = new CAConstModifier(this.modifierCode | modifier.modifierCode)
}

object SYNTHETIC extends CAConstModifier(Opcodes.ACC_SYNTHETIC)
object PUBLIC extends CAConstModifier(Opcodes.ACC_PUBLIC)
object PROTECTED extends CAConstModifier(Opcodes.ACC_PROTECTED)
object PRIVATE extends CAConstModifier(Opcodes.ACC_PRIVATE)
object FINAL extends CAConstModifier(Opcodes.ACC_FINAL)



