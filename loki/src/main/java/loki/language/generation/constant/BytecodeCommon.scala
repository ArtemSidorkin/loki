package loki.language.generation.constant

object BytecodeCommon
{
	def FRAME_CLASS_NAME(moduleName:String, id:Long) = s"$moduleName$$$id"
}
