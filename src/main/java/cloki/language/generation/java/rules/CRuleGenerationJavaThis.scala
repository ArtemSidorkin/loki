package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.parsing.LokiParser.ThisContext

private[java] object CRuleGenerationJavaThis extends CRuleGenerationJava[ThisContext]
{
	protected class CCoreJavaThis(generationContext:CGenerationContextJava, ruleContext:ThisContext)
		extends CCoreJava(generationContext, ruleContext)
	{
		override def enter() = (addCode _ compose tabulateIfLastCharacterIsNewLine) ("this")
	}

	override def getCore(generationContext:CGenerationContextJava, ruleContext:ThisContext) =
		new CCoreJavaThis(generationContext, ruleContext)
}
