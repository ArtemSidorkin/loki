package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import loki.language.parsing.LokiParser.ThisContext

class GenerationRuleBytecodeThis(generationContext:CGenerationContextBytecode, ruleContext:ThisContext)
	extends GenerationRuleBytecode(generationContext, ruleContext)
{
	override protected def enterAction() =
	(
		topMethodCall aloadthis ()
		incrementObjectCounter ()
	)
}

object GenerationRuleBytecodeThis
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:ThisContext):Unit =
		new GenerationRuleBytecodeThis(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:ThisContext):Unit =
		new GenerationRuleBytecodeThis(generationContext, ruleContext).exit()
}