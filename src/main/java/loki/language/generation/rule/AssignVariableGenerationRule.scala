package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.ContextBytecodeTemplate.CTemplateContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.AssignVariableContext

class AssignVariableGenerationRule
(
	generationContext:GenerationContext, ruleContext:AssignVariableContext
) extends GenerationRule(generationContext, ruleContext)
{
	private val variableName = ruleContext.IDENTIFIER.getText

	override protected def enterAction():Unit =
	(
		topMethodCall aloadUnitMethodCallVariableUnitContext ()
		ldc variableName
	)


	override protected def exitAction():Unit = topMethodCall invokeVirtualUnitContextMethodSetVariable ()
}

object AssignVariableGenerationRule
{
	def enter(generationContext:GenerationContext, ruleContext:AssignVariableContext):Unit =
		new AssignVariableGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:GenerationContext, ruleContext:AssignVariableContext):Unit =
		new AssignVariableGenerationRule(generationContext, ruleContext).exit()
}