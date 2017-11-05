package cloki.language.generation.rules

import cloki.language.generation.Generation
import cloki.language.generation.rules.mixins.CMixinRuleGeneration
import org.antlr.v4.runtime.RuleContext

private[generation] class GenerationRule[GENERATION_CONTEXT <: Generation#GenerationContext, RULE_CONTEXT <: RuleContext]
	(protected val generationContext:GENERATION_CONTEXT, protected val ruleContext:RULE_CONTEXT)
	extends CMixinRuleGeneration[RULE_CONTEXT]
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
		__enter()
		generationContext.checkPostEnterRuleTasks(ruleContext)
	}

	private def _exit()
	{
		generationContext.checkPreExitRuleTasks(ruleContext)
		__exit()
		generationContext.checkPostExitRuleTasks(ruleContext)
	}

	def __enter():Unit = ()
	def __exit():Unit = ()
}
