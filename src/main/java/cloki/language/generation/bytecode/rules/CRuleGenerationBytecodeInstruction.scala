package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.parsing.LokiParser.InstructionContext

private[bytecode] object CRuleGenerationBytecodeInstruction extends CRuleGenerationBytecode[InstructionContext]
{
	protected class CCoreBytecodeInstruction(generationContext:CGenerationContextBytecode, ruleContext:InstructionContext)
		extends CCoreBytecode(generationContext, ruleContext)
	{
		override def enter() = topMethodCall pushFrame ()
		override def exit() = topMethodCall popFrame ()
	}

	override protected def getCore(generationContext:CGenerationContextBytecode, ruleContext:InstructionContext) =
		new CCoreBytecodeInstruction(generationContext, ruleContext)
}
