package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.parsing.CLokiParser.ThisContext

private[bytecode] object CRuleGenerationBytecodeThis extends CRuleGenerationBytecode[ThisContext]
{
	protected class CCoreBytecodeThis(generationContext:CGenerationContextBytecode, ruleContext:ThisContext)
		extends CCoreBytecode(generationContext, ruleContext)
	{
		override def enter() =
		(
			topMethodCall aloadthis ()
			incrementObjectCounter ()
		)
	}

	override protected def getCore(generationContext:CGenerationContextBytecode, ruleContext:ThisContext) =
		new CCoreBytecodeThis(generationContext, ruleContext)
}
