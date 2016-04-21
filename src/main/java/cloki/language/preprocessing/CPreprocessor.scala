package cloki.language.preprocessing

import cloki.language.preprocessing.commands._

private class CPreprocessor(code:String)
{
	private val _code = new StringBuilder(code)

	def apply():String =
	{
		CCommandPreprocessingRemoveIgnorableCharacters(_code)
		CCommandPreprocessingReplaceTabsToBeginAndEnd(_code)
		CCommandPreprocessingInferSemicolons(_code)
		_code.toString
	}
}

object CPreprocessor
{
    def apply(code:String):String = (new CPreprocessor(code))()
}