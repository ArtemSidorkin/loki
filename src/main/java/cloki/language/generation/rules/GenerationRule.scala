package cloki.language.generation.rules

import cloki.language.generation.Generation
import org.antlr.v4.runtime.RuleContext

private[generation] class GenerationRule[GENERATION_CONTEXT <: Generation#GenerationContext, RULE_CONTEXT <: RuleContext]
	(val core:CCore[GENERATION_CONTEXT, RULE_CONTEXT])
{
	def enter(ruleContext:RULE_CONTEXT)(implicit generationContext:GENERATION_CONTEXT):Unit =
		if (generationContext isDeferredRule ruleContext unary_!) _enter(ruleContext)
		else generationContext.setDeferredRuleActions(
			ruleContext, () => _enter(ruleContext), () => _exit(ruleContext)
		)

	def exit(ruleContext:RULE_CONTEXT)(implicit generationContext:GENERATION_CONTEXT):Unit =
		if (generationContext isDeferredRule ruleContext unary_!) _exit(ruleContext)

	private def _enter(ruleContext:RULE_CONTEXT)(implicit generationContext:GENERATION_CONTEXT)
	{
		generationContext.checkPreEnterRuleTasks(ruleContext)
		core.enter()
		generationContext.checkPostEnterRuleTasks(ruleContext)
	}

	private def _exit(ruleContext:RULE_CONTEXT)(implicit generationContext:GENERATION_CONTEXT)
	{
		generationContext.checkPreExitRuleTasks(ruleContext)
		core.exit()
		generationContext.checkPostExitRuleTasks(ruleContext)
	}
}
