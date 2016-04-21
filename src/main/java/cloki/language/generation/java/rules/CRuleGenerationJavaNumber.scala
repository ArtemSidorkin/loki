package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationNumber
import cloki.language.parsing.CLokiParser.NumberContext
import cloki.runtime.datatypes.CNumber

private[java] object CRuleGenerationJavaNumber extends CRuleGenerationJava[NumberContext]
{
	protected class CCoreJavaNumber(generationContext:CGenerationContextJava, ruleContext:NumberContext)
		extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationNumber
	{
		override def enter() =
			(addCode _ compose tabulateIfLastCharacterIsNewLine) (s"new ${classOf[CNumber].getName}($number)")
	}

	override def getCore(generationContext:CGenerationContextJava, ruleContext:NumberContext) =
		new CCoreJavaNumber(generationContext, ruleContext)
}
