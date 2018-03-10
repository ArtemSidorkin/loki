package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.parsing.LokiParser.HostContext

class HostBytecodeGenerationRule(generationContext:BytecodeGenerationContext, ruleContext:HostContext)
	extends BytecodeGenerationRule(generationContext, ruleContext)
{
	override protected def enterAction() =
	(
		topMethodCall aloadUnitMethodCallParameterHost ()
		incrementObjectCounter ()
	)
}

object HostBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:HostContext):Unit =
		new HostBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:HostContext):Unit =
		new HostBytecodeGenerationRule(generationContext, ruleContext).exit()
}