package cloki.language.generation.rules

import cloki.language.generation.Generation
import cloki.language.generation.rules.mixins.CMixinRuleGeneration
import org.antlr.v4.runtime.RuleContext

private[generation] trait GGenerationRule[RULE_CONTEXT <: RuleContext]
{
	type GENERATION_CONTEXT <: Generation#GenerationContext

	protected class CCore(protected val generationContext:GENERATION_CONTEXT, protected val ruleContext:RULE_CONTEXT)
		extends CMixinRuleGeneration[RULE_CONTEXT]
	{
		def enter() = ()
		def exit() = ()
	}

	private val STUB_CORE = new CCore(null.asInstanceOf[GENERATION_CONTEXT], null.asInstanceOf[RULE_CONTEXT]) {}

	protected def getCore(generationContext:GENERATION_CONTEXT, ruleContext:RULE_CONTEXT):CCore = STUB_CORE

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
		getCore(generationContext:GENERATION_CONTEXT, ruleContext:RULE_CONTEXT).enter()
		generationContext.checkPostEnterRuleTasks(ruleContext)
	}

	private def _exit(ruleContext:RULE_CONTEXT)(implicit generationContext:GENERATION_CONTEXT)
	{
		generationContext.checkPreExitRuleTasks(ruleContext)
		getCore(generationContext:GENERATION_CONTEXT, ruleContext:RULE_CONTEXT).exit()
		generationContext.checkPostExitRuleTasks(ruleContext)
	}
}
