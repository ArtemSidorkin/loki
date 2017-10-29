package casm.consts

import org.objectweb.asm.Opcodes

private[casm] sealed class CAConstJavaVersion(private[casm] val javaVersionCode:Int)

object JAVA1 extends CAConstJavaVersion(Opcodes.V1_1)
object JAVA2 extends CAConstJavaVersion(Opcodes.V1_2)
object JAVA3 extends CAConstJavaVersion(Opcodes.V1_3)
object JAVA4 extends CAConstJavaVersion(Opcodes.V1_4)
object JAVA5 extends CAConstJavaVersion(Opcodes.V1_5)
object JAVA6 extends CAConstJavaVersion(Opcodes.V1_6)
object JAVA7 extends CAConstJavaVersion(Opcodes.V1_7)
object JAVA8 extends CAConstJavaVersion(Opcodes.V1_8)
