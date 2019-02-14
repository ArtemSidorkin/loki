package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecodetemplate.NumberBytecodeTemplate.CTemplateNumber
import loki.language.parsing.LokiParser.NumberContext

class NumberGenerationRule(generationContext:GenerationContext, ruleContext:NumberContext)
	extends GenerationRule(generationContext, ruleContext)
{
	private val number:Double = java.lang.Double.parseDouble(ruleContext.getText)

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

object NumberGenerationRule
{
	def enter(generationContext:GenerationContext, ruleContext:NumberContext):Unit =
		new NumberGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:GenerationContext, ruleContext:NumberContext):Unit =
		new NumberGenerationRule(generationContext, ruleContext).exit()
}