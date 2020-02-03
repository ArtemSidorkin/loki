package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.ContextBytecodeTemplate.ContextBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.AssignVariableContext


private[generation] class AssignVariableGenerationRule(
	generationContext:GenerationContext, assignVariableContext:AssignVariableContext
)
	extends GenerationRule(generationContext, assignVariableContext)
{
	private def variableName = ruleContext.IDENTIFIER.getText

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