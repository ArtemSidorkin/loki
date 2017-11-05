package cloki.language.generation.rules

import cloki.language.generation.Generation
import cloki.language.generation.rules.mixins.CMixinRuleGeneration
import org.antlr.v4.runtime.RuleContext

class CCore[GENERATION_CONTEXT<: Generation#GenerationContext, RULE_CONTEXT <: RuleContext]
	(protected val generationContext:GENERATION_CONTEXT, protected val ruleContext:RULE_CONTEXT)
		extends CMixinRuleGeneration[RULE_CONTEXT]
{
	def enter() = ()
	def exit() = ()
}