package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.parsing.LokiParser.ThisContext

class GenerationRuleBytecodeThis(generationContext:CGenerationContextBytecode, ruleContext:ThisContext)
	extends GenerationRuleBytecode(generationContext, ruleContext)
{
	override def __enter() =
	(
		topMethodCall aloadthis ()
		incrementObjectCounter ()
	)
}
