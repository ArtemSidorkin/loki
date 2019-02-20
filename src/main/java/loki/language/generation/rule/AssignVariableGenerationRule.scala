package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.ContextBytecodeTemplate.CTemplateContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.AssignVariableContext

private[generation] class AssignVariableGenerationRule(
	generationContext:GenerationContext, assignVariableContext:AssignVariableContext
)
	extends GenerationRule(generationContext, assignVariableContext)
{
	private val variableName = assignVariableContext.IDENTIFIER.getText

	override protected def enterAction():Unit =	(
		topMethodCall
			aloadUnitMethodCallVariableUnitContext ()
			ldc variableName
	)

	override protected def exitAction():Unit = topMethodCall invokeVirtualUnitContextMethodSetVariable ()
}

private[generation] object AssignVariableGenerationRule
{
	def enter(generationContext:GenerationContext, assignVariableContext:AssignVariableContext):Unit =
		new AssignVariableGenerationRule(generationContext, assignVariableContext).enter()

	def exit(generationContext:GenerationContext, assignVariableContext:AssignVariableContext):Unit =
		new AssignVariableGenerationRule(generationContext, assignVariableContext).exit()
}