package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.parsing.LokiParser.ThisContext

class CCoreBytecodeThis(generationContext:CGenerationContextBytecode, ruleContext:ThisContext)
	extends CCoreBytecode(generationContext, ruleContext)
{
	override def enter() =
	(
		topMethodCall aloadthis ()
		incrementObjectCounter ()
	)
}
