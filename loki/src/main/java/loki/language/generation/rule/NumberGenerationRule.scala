package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CommonBytecodeTemplate
import loki.language.generation.bytecodetemplate.NumberBytecodeTemplate.NumberBytecodeTemplate
import loki.language.parsing.LokiParser.NumberContext

private[generation] class NumberGenerationRule
	(numberContext:NumberContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(numberContext)
{
	private def number:Double = java.lang.Double.parseDouble(numberContext.getText)

	override protected def enterAction():Unit = (
		topMethodCall
			.newNumber()
			.dup()
			.ldc(number)
			.invokeInitNumber()
			.incrementObjectStackCounter()
	)
}

private[generation] object NumberGenerationRule
{
	def enter(numberContext:NumberContext)(implicit generationContext:GenerationContext):Unit =
		new NumberGenerationRule(numberContext).enter()

	def exit(numberContext:NumberContext)(implicit generationContext:GenerationContext):Unit =
		new NumberGenerationRule(numberContext).exit()
}