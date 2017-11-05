package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeNumber.CTemplateNumber
import cloki.language.generation.rules.mixins.CMixinRuleGenerationNumber
import cloki.language.parsing.LokiParser.NumberContext

class GenerationRuleBytecodeNumber(generationContext:CGenerationContextBytecode, ruleContext:NumberContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with CMixinRuleGenerationNumber
{
	override def __enter() =
	(
		topMethodCall
		newNumber ()
		dup ()
		ldc number
		invokeInitNumber ()
		incrementObjectCounter ()
	)
}
