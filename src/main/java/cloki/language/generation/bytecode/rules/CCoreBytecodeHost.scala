package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.parsing.LokiParser.HostContext

class CCoreBytecodeHost(generationContext:CGenerationContextBytecode, ruleContext:HostContext)
	extends CCoreBytecode(generationContext, ruleContext)
{
	override def enter() =
	(
		topMethodCall aloadUnitMethodCallParameterHost ()
		incrementObjectCounter ()
	)
}
