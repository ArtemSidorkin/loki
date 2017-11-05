package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.parsing.LokiParser.HostContext

class GenerationRuleBytecodeHost(generationContext:CGenerationContextBytecode, ruleContext:HostContext)
	extends GenerationRuleBytecode(generationContext, ruleContext)
{
	override def __enter() =
	(
		topMethodCall aloadUnitMethodCallParameterHost ()
		incrementObjectCounter ()
	)
}
