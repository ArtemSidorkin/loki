package loki.language.preprocessing

import loki.language.preprocessing.command._
import loki.system.SystemSettings

object Preprocessor
{
    def apply(code:String):String =
	{
		val _code = new StringBuilder()

		val codeLines = SemicolonReasoner(CodeBlockReasoner(code.split("\n").map(new CodeLine(_))))

		codeLines.foreach(cl =>
		{
			_code ++= cl.raw

			if (cl.semicolon) _code ++= ";"

			cl.inferredLines.foreach(al1 =>
			{
				_code ++= al1.raw

				if (al1.semicolon) _code ++= ";"
			})

			_code ++= "\n"
		})

		if (SystemSettings.TRACE_PREPROCESSED_CODE) println(_code)

		_code.toString
	}
}