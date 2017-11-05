package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.parsing.LokiParser.InstructionContext

class GenerationRuleBytecodeInstruction(generationContext:CGenerationContextBytecode, ruleContext:InstructionContext)
	extends GenerationRuleBytecode(generationContext, ruleContext)
{
	override def __enter() = topMethodCall pushFrame ()
	override def __exit() = topMethodCall popFrame ()
}
