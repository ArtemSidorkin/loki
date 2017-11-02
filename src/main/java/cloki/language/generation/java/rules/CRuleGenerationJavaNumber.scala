package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationNumber
import cloki.language.parsing.LokiParser.NumberContext
import cloki.runtime.datatype.LNumber

private[java] object CRuleGenerationJavaNumber extends CRuleGenerationJava[NumberContext]
{
	protected class CCoreJavaNumber(generationContext:CGenerationContextJava, ruleContext:NumberContext)
		extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationNumber
	{
		override def enter() =
			(addCode _ compose tabulateIfLastCharacterIsNewLine) (s"new ${classOf[LNumber].getName}($number)")
	}

	override def getCore(generationContext:CGenerationContextJava, ruleContext:NumberContext) =
		new CCoreJavaNumber(generationContext, ruleContext)
}
