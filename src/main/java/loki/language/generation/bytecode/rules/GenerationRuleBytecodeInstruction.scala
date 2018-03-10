package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import loki.language.parsing.LokiParser.InstructionContext

class GenerationRuleBytecodeInstruction(generationContext:CGenerationContextBytecode, ruleContext:InstructionContext)
	extends GenerationRuleBytecode(generationContext, ruleContext)
{
	override protected def enterAction() = topMethodCall pushFrame ()
	override protected def exitAction() = topMethodCall popFrame ()
}

object GenerationRuleBytecodeInstruction
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:InstructionContext):Unit =
		new GenerationRuleBytecodeInstruction(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:InstructionContext):Unit =
		new GenerationRuleBytecodeInstruction(generationContext, ruleContext).exit()
}