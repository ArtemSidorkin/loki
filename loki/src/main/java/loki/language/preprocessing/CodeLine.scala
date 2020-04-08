package loki.language.preprocessing

import loki.language.preprocessing.constant.IgnoredCharacters

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class CodeLine(val raw:String = "")
{
	var semicolon:Boolean = false

	val additionalLines:mutable.Buffer[CodeLine] = ArrayBuffer()

	val trimmed:String = raw.reverse.dropWhile(IgnoredCharacters.VALUES.contains).reverse

	val cleanedUp:String = raw.filter(!IgnoredCharacters.VALUES.contains(_))

	val indentCount:Int = raw.takeWhile(_ == IgnoredCharacters.TAB).length

	val isEmpty:Boolean = trimmed.isEmpty
}