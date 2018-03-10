package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.parsing.LokiParser.ThisContext

class ThisBytecodeGenerationRule(generationContext:BytecodeGenerationContext, ruleContext:ThisContext)
	extends BytecodeGenerationRule(generationContext, ruleContext)
{
	override protected def enterAction() =
	(
		topMethodCall aloadthis ()
		incrementObjectCounter ()
	)
}

object ThisBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:ThisContext):Unit =
		new ThisBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:ThisContext):Unit =
		new ThisBytecodeGenerationRule(generationContext, ruleContext).exit()
}