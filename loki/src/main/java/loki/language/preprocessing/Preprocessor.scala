package loki.language.preprocessing

import loki.language.preprocessing.command._
import loki.language.preprocessing.constant.ControlCharacters
import loki.system.SystemSettings

object Preprocessor
{
    def apply(code:String):String =
	{
		val preprocessedCode =
			SemicolonReasoner(CodeBlockReasoner(code.split(ControlCharacters.NEW_LINE).map(new CodeLine(_))))
				.mkString(ControlCharacters.NEW_LINE.toString)

		if (SystemSettings.TRACE_PREPROCESSED_CODE) println(preprocessedCode)

		preprocessedCode
	}
}