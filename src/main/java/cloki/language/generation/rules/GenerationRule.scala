package cloki.language.generation.rules

import cloki.language.generation.Generation
import cloki.language.generation.rules.mixins.CMixinRuleGeneration
import org.antlr.v4.runtime.RuleContext

private[generation] class GenerationRule[
	GENERATION_CONTEXT <: Generation#GenerationContext, RULE_CONTEXT <: RuleContext
] (
	protected val generationContext:GENERATION_CONTEXT, protected val ruleContext:RULE_CONTEXT
)
	extends CMixinRuleGeneration[RULE_CONTEXT]
{

	def enter():Unit =
		if (generationContext isDeferredRule ruleContext unary_!) enterAndCheckTasks()
		else
			generationContext.setDeferredRuleActions(ruleContext, () => enterAndCheckTasks(), () => exitAndCheckTasks())

	def exit():Unit = if (generationContext isDeferredRule ruleContext unary_!) exitAndCheckTasks()

	protected def enterAction():Unit = ()
	protected def exitAction():Unit = ()

	private def enterAndCheckTasks()
	{
		generationContext.checkPreEnterRuleTasks(ruleContext)
		enterAction()
		generationContext.checkPostEnterRuleTasks(ruleContext)
	}

	private def exitAndCheckTasks()
	{
		generationContext.checkPreExitRuleTasks(ruleContext)
		exitAction()
		generationContext.checkPostExitRuleTasks(ruleContext)
	}
}
