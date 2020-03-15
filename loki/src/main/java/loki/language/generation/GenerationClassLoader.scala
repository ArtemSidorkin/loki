package loki.language.generation

import _root_.java.util.concurrent.ConcurrentHashMap

import scala.collection.JavaConverters._

private[generation] class GenerationClassLoader extends ClassLoader
{
	private val classBytecodes:collection.mutable.Map[String, Array[Byte]] =
		new ConcurrentHashMap[String, Array[Byte]]() asScala

	def getClass(className:String):Class[_] = findClass(className)
	def setClassCode(className:String, classBytecode:Array[Byte]):Unit = classBytecodes += className -> classBytecode

	override protected def findClass(className:String):Class[_] = (
		classBytecodes
		get className
		map (classCode => defineClass(className, classCode, 0, classCode.length))
		getOrElse super.findClass(className)
	)
}
