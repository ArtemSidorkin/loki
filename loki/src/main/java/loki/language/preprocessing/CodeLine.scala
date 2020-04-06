package loki.language.preprocessing

import scala.collection.mutable.ArrayBuffer

class CodeLine(val raw:String, val trimmed:String, val ignore:Boolean, val additionalLines:ArrayBuffer[CodeLine], var semicolon:Boolean = false)