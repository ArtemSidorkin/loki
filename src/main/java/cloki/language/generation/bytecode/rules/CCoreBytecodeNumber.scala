package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeNumber.CTemplateNumber
import cloki.language.generation.rules.mixins.CMixinRuleGenerationNumber
import cloki.language.parsing.LokiParser.NumberContext

class CCoreBytecodeNumber(generationContext:CGenerationContextBytecode, ruleContext:NumberContext)
	extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationNumber
{
	override def enter() =
	(
		topMethodCall
		newNumber ()
		dup ()
		ldc number
		invokeInitNumber ()
		incrementObjectCounter ()
	)
}
