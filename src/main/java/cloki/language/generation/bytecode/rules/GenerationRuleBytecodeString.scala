package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeString.CTemplateNumber
import cloki.language.generation.rules.mixins.CMixinRuleGenerationString
import cloki.language.parsing.LokiParser

class GenerationRuleBytecodeString
(
	generationContext:CGenerationContextBytecode, ruleContext:LokiParser.StringContext
) extends GenerationRuleBytecode(generationContext, ruleContext) with CMixinRuleGenerationString
{
	override def __enter() =
	{
		val prprdStr = string split "\n" map (str => s"""${str.init}""") mkString "\n"

		(
			topMethodCall
			newString ()
			dup ()
			ldc prprdStr
			invokeInitString ()
			incrementObjectCounter ()
		)
	}

}
