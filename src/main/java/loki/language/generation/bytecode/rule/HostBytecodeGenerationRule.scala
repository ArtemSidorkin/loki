package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
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