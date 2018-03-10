package loki.language.generation.bytecode.constant

import assembler.constant.JAVA8

private[bytecode] object BytecodeCommon
{
	val JAVA_VERSION = JAVA8

	def FRAME_CLASS_NAME(moduleName:String, id:Long) = s"$moduleName$$$id"
	def OUTER_CLASS_FIELD_NAME(id:Long) = s"this$$$id"
	def PARAMETERS_FIELD_NAME(id:Long) = s"val$$parameters$id"
}
