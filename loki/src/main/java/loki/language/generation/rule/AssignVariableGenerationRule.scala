package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitContextBytecodeTemplate.UnitContextBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.AssignVariableContext

private[generation] class AssignVariableGenerationRule
	(assignVariableContext:AssignVariableContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(assignVariableContext)
{
	private def variableName = assignVariableContext.IDENTIFIER.getText

	override protected def enterAction():Unit =
		topMethodCall
			.aloadUnitContextVariableOfUnitCallMethod()
			.ldc(variableName)

	override protected def exitAction():Unit = topMethodCall.invokeVirtualUnitContextSetVariableMethod()
}

private[generation] object AssignVariableGenerationRule
{
	def enter(assignVariableContext:AssignVariableContext)(implicit generationContext:GenerationContext):Unit =
		new AssignVariableGenerationRule(assignVariableContext).enter()

	def exit(assignVariableContext:AssignVariableContext)(implicit generationContext:GenerationContext):Unit =
		new AssignVariableGenerationRule(assignVariableContext).exit()
}