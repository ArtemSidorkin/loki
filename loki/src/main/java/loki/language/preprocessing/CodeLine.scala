package loki.language.preprocessing

import loki.language.preprocessing.constant.ControlCharacters

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class CodeLine(val raw:String = "")
{
	var semicolon:Boolean = false

	val inferredLines:mutable.Buffer[CodeLine] = ArrayBuffer()

	val trimmedRight:String = raw.reverse.dropWhile(ControlCharacters.VALUES.contains).reverse

	val cleanedUp:String = raw.filter(!ControlCharacters.VALUES.contains(_))

	val indentCount:Int = raw.takeWhile(_ == ControlCharacters.TAB).length

	val isEmpty:Boolean = trimmedRight.isEmpty

	def mergeWithInferredLines:collection.Seq[CodeLine] = this :: inferredLines.toList
}