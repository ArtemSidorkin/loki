package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationString
import cloki.language.parsing.CLokiParser
import cloki.runtime.datatype.LString

object CRuleGenerationJavaString extends CRuleGenerationJava[CLokiParser.StringContext]
{
	protected class CCoreJavaString(generationContext:CGenerationContextJava, ruleContext:CLokiParser.StringContext)
		extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationString
	{
		override def enter() =
		{
			val prprdStr = string split "\n" map (str => s""""${str.init}"""") mkString """ + "\n" + """
			(addCode _ compose tabulateIfLastCharacterIsNewLine) (s"new ${classOf[LString].getName}($prprdStr)")
		}
	}

	override def getCore(generationContext:CGenerationContextJava, ruleContext:CLokiParser.StringContext) =
		new CCoreJavaString(generationContext, ruleContext)
}
