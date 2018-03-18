package loki.language.generation.java.rule

import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rule.mixin.StringGenerationRuleMixin
import loki.language.parsing.LokiParser
import loki.runtime.datatype.LString

class StringGenerationJavaRule(javaGenerationContext:JavaGenerationContext, stringContext:LokiParser.StringContext)
	extends GenerationJavaRule(javaGenerationContext, stringContext) with StringGenerationRuleMixin
{
	override protected def enterAction()
	{
		val preparedString =
			if (isAcuteString) s""""$string""""
			else string split "\n" map (string => s""""${string.init}"""") mkString """ + "\n" + """

		(addCode _ compose tabulateIfLastCharacterIsNewLine) (s"new ${classOf[LString].getName}($preparedString)")
	}
}