package loki.language.preprocessing

import loki.language.preprocessing.command._
import loki.system.SystemSettings

private class Preprocessor(code:String)
{
	private val _code = new StringBuilder(code)

	def apply():String =
	{
		Preprocessor.commands foreach (_(_code))
		_code.toString
	}
}

object Preprocessor
{
	private val commands:Seq[PreprocessingCommand] =
		RemoveIgnorableCharactersPreprocessingCommand ::
		ReplaceTabsToBeginAndEndPreprocessingCommand ::
		InferSemicolonsPreprocessingCommand ::
		Nil

    def apply(code:String):String =
	{
		val preprocessedCode = (new Preprocessor(code))()
		if (SystemSettings.TRACE_PREPROCESSED_CODE) println(preprocessedCode)
		preprocessedCode
	}
}