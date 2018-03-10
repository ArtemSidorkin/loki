package loki.language.generation.rules

import loki.language.generation.Generation
import loki.language.generation.rules.mixins.GenerationRuleMixin
import org.antlr.v4.runtime.RuleContext

private[generation] class GenerationRule[
	GENERATION_CONTEXT <: Generation#GenerationContext, RULE_CONTEXT <: RuleContext
] (
	protected val generationContext:GENERATION_CONTEXT, protected val ruleContext:RULE_CONTEXT
)
	extends GenerationRuleMixin[RULE_CONTEXT]
{
	protected def enterAction():Unit = ()
	protected def exitAction():Unit = ()

	def enter()
	{
		generationContext.checkPreEnterRuleTasks(ruleContext)
		enterAction()
		generationContext.checkPostEnterRuleTasks(ruleContext)
	}

	def exit()
	{
		generationContext.checkPreExitRuleTasks(ruleContext)
		exitAction()
		generationContext.checkPostExitRuleTasks(ruleContext)
	}
}
