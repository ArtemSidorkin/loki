package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import loki.language.generation.bytecode.templates.CTemplateBytecodeString.CTemplateNumber
import loki.language.generation.rules.mixins.StringGenerationRuleMixin
import loki.language.parsing.LokiParser

class StringBytecodeGenerationRule
(
	generationContext:BytecodeGenerationContext, ruleContext:LokiParser.StringContext
) extends BytecodeGenerationRule(generationContext, ruleContext) with StringGenerationRuleMixin
{
	override protected def enterAction() =
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

object StringBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:LokiParser.StringContext):Unit =
		new StringBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:LokiParser.StringContext):Unit =
		new StringBytecodeGenerationRule(generationContext, ruleContext).exit()
}