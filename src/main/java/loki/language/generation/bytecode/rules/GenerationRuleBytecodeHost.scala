package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.parsing.LokiParser.HostContext

class GenerationRuleBytecodeHost(generationContext:CGenerationContextBytecode, ruleContext:HostContext)
	extends GenerationRuleBytecode(generationContext, ruleContext)
{
	override protected def enterAction() =
	(
		topMethodCall aloadUnitMethodCallParameterHost ()
		incrementObjectCounter ()
	)
}

object GenerationRuleBytecodeHost
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:HostContext):Unit =
		new GenerationRuleBytecodeHost(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:HostContext):Unit =
		new GenerationRuleBytecodeHost(generationContext, ruleContext).exit()
}