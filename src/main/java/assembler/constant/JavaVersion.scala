package assembler.constant

import org.objectweb.asm.Opcodes

private[assembler] sealed class JavaVersion(private[assembler] val javaVersionCode:Int)

object JAVA1 extends JavaVersion(Opcodes.V1_1)
object JAVA2 extends JavaVersion(Opcodes.V1_2)
object JAVA3 extends JavaVersion(Opcodes.V1_3)
object JAVA4 extends JavaVersion(Opcodes.V1_4)
object JAVA5 extends JavaVersion(Opcodes.V1_5)
object JAVA6 extends JavaVersion(Opcodes.V1_6)
object JAVA7 extends JavaVersion(Opcodes.V1_7)
object JAVA8 extends JavaVersion(Opcodes.V1_8)
