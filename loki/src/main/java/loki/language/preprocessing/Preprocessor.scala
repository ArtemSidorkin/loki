package loki.language.preprocessing

import loki.language.preprocessing.constant.ControlCharacters
import loki.language.preprocessing.reasoner._
import loki.system.SystemSettings

object Preprocessor
{
    def apply(code:String):String =
	{
		val preprocessedCode =
			SemicolonReasoner(CodeBlockReasoner(CodeLineReasoner(code))).mkString(ControlCharacters.NEW_LINE.toString)

		if (SystemSettings.TRACE_PREPROCESSED_CODE) println(preprocessedCode)

		preprocessedCode
	}
}