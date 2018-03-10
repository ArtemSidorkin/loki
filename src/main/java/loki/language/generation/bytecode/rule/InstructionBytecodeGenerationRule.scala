package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.parsing.LokiParser.InstructionContext

class InstructionBytecodeGenerationRule(generationContext:BytecodeGenerationContext, ruleContext:InstructionContext)
	extends BytecodeGenerationRule(generationContext, ruleContext)
{
	override protected def enterAction() = topMethodCall pushFrame ()
	override protected def exitAction() = topMethodCall popFrame ()
}

object InstructionBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:InstructionContext):Unit =
		new InstructionBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:InstructionContext):Unit =
		new InstructionBytecodeGenerationRule(generationContext, ruleContext).exit()
}