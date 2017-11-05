package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.parsing.LokiParser.InstructionContext

class CCoreBytecodeInstruction(generationContext:CGenerationContextBytecode, ruleContext:InstructionContext)
	extends CCoreBytecode(generationContext, ruleContext)
{
	override def enter() = topMethodCall pushFrame ()
	override def exit() = topMethodCall popFrame ()
}
