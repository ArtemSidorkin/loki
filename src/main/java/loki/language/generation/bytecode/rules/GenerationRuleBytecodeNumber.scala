package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import loki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import loki.language.generation.bytecode.templates.CTemplateBytecodeNumber.CTemplateNumber
import loki.language.generation.rules.mixins.NumberGenerationRuleMixin
import loki.language.parsing.LokiParser.NumberContext

class GenerationRuleBytecodeNumber(generationContext:CGenerationContextBytecode, ruleContext:NumberContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with NumberGenerationRuleMixin
{
	override protected def enterAction() =
	(
		topMethodCall
		newNumber ()
		dup ()
		ldc number
		invokeInitNumber ()
		incrementObjectCounter ()
	)
}

object GenerationRuleBytecodeNumber
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:NumberContext):Unit =
		new GenerationRuleBytecodeNumber(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:NumberContext):Unit =
		new GenerationRuleBytecodeNumber(generationContext, ruleContext).exit()
}