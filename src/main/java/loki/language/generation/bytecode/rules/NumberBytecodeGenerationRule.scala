package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import loki.language.generation.bytecode.templates.CTemplateBytecodeNumber.CTemplateNumber
import loki.language.generation.rules.mixins.NumberGenerationRuleMixin
import loki.language.parsing.LokiParser.NumberContext

class NumberBytecodeGenerationRule(generationContext:BytecodeGenerationContext, ruleContext:NumberContext)
	extends BytecodeGenerationRule(generationContext, ruleContext) with NumberGenerationRuleMixin
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

object NumberBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:NumberContext):Unit =
		new NumberBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:NumberContext):Unit =
		new NumberBytecodeGenerationRule(generationContext, ruleContext).exit()
}