package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CommonBytecodeTemplate
import loki.language.generation.bytecodetemplate.NumberBytecodeTemplate.NumberBytecodeTemplate
import loki.language.parsing.LokiParser.NumberContext


private[generation] class NumberGenerationRule(generationContext:GenerationContext, numberContext:NumberContext)
	extends GenerationRule(generationContext, numberContext)
{
	private def number:Double = java.lang.Double.parseDouble(numberContext.getText)

	override protected def enterAction():Unit = (
		topMethodCall
			newNumber ()
			dup ()
			ldc number
			invokeInitNumber ()
			incrementObjectCounter ()
	)
}

private[generation] object NumberGenerationRule
{
	def enter(generationContext:GenerationContext, numberContext:NumberContext):Unit =
		new NumberGenerationRule(generationContext, numberContext).enter()

	def exit(generationContext:GenerationContext, numberContext:NumberContext):Unit =
		new NumberGenerationRule(generationContext, numberContext).exit()
}