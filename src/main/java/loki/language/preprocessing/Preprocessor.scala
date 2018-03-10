package loki.language.preprocessing

import loki.language.preprocessing.commands._

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

    def apply(code:String):String = (new Preprocessor(code))()
}