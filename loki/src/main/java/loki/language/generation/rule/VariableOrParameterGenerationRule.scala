package loki.language.generation.rule

import assembler.builder.MethodBuilder
import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitContextBytecodeTemplate.UnitContextBytecodeTemplate
import loki.language.parsing.LokiParser.VariableOrParameterContext

private[generation] class VariableOrParameterGenerationRule
	(variableOrParameterContext:VariableOrParameterContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(variableOrParameterContext)
{
	private def variableOrParameterName:Option[String] = Option(variableOrParameterContext.IDENTIFIER).map(_.getText)

	override protected def enterAction():Unit =
		topMethodCall
			.aloadUnitContextVariableOfUnitCallMethod()
			.loadVariableOrParameter()

	private implicit class LocalVariableOrParameterBuilder(val methodBuilder:MethodBuilder)
	{
		def loadVariableOrParameter():methodBuilder.type =
		{
			if (variableOrParameterName.isDefined)
				topMethodCall
					.ldc(variableOrParameterName.get)
					.invokeVirtualUnitContextGetVariableMethod()
			else topMethodCall.invokeVirtualUnitContextMethodGetAnonymousParameter()

			methodBuilder
		}
	}
}

private[generation] object VariableOrParameterGenerationRule
{
	def enter
		(variableOrParameterContext:VariableOrParameterContext)(implicit generationContext:GenerationContext):Unit =
		new VariableOrParameterGenerationRule(variableOrParameterContext).enter()

	def exit(variableOrParameterContext:VariableOrParameterContext)(implicit generationContext:GenerationContext):Unit =
		new VariableOrParameterGenerationRule(variableOrParameterContext).exit()
}