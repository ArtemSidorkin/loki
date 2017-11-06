package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.parsing.LokiParser.InstructionContext

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