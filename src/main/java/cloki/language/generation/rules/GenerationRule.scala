package cloki.language.generation.rules

import cloki.language.generation.Generation
import org.antlr.v4.runtime.RuleContext

private[generation] class GenerationRule[GENERATION_CONTEXT <: Generation#GenerationContext, RULE_CONTEXT <: RuleContext]
	(protected val generationContext:GENERATION_CONTEXT, protected val ruleContext:RULE_CONTEXT, val core:CCore[GENERATION_CONTEXT, RULE_CONTEXT])
{
	def enter():Unit =
		if (generationContext isDeferredRule ruleContext unary_!) _enter()
		else generationContext.setDeferredRuleActions(
			ruleContext, () => _enter(), () => _exit()
		)

	def exit():Unit =
		if (generationContext isDeferredRule ruleContext unary_!) _exit()

	private def _enter()
	{
		generationContext.checkPreEnterRuleTasks(ruleContext)
		core.enter()
		generationContext.checkPostEnterRuleTasks(ruleContext)
	}

	private def _exit()
	{
		generationContext.checkPreExitRuleTasks(ruleContext)
		core.exit()
		generationContext.checkPostExitRuleTasks(ruleContext)
	}
}
