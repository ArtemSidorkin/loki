package cloki.language.generation

import _root_.java.util.concurrent.ConcurrentHashMap

import scala.collection.JavaConversions._

private[generation] class CClassLoader extends ClassLoader
{
	private val classCodes:collection.mutable.Map[String, Array[Byte]] = new ConcurrentHashMap[String, Array[Byte]]()

	def getClass(className:String) = findClass(className)
	def setClassCode(className:String, classCode:Array[Byte]):Unit = classCodes += className -> classCode

	override protected def findClass(className:String):Class[_] =
	(
		classCodes
		get className
		map (clsCd => defineClass(className, clsCd, 0, clsCd.length))
		getOrElse (super.findClass(className))
	)
}
