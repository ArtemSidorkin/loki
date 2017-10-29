package cloki.language.generation.rules.mixins

import cloki.language.generation.CGeneration
import org.antlr.v4.runtime.RuleContext

private[generation] trait CMixinRuleGeneration[RULE_CONTEXT <: RuleContext]
{
	protected val generationContext:CGeneration#CGenerationContext
	protected val ruleContext:RULE_CONTEXT

	protected def classLoader = generationContext.classLoader

	protected def isTopFrameModule = frameStackSize == 1
	protected def isTopFrameUnit = frameStackSize > 1
	protected def isPreTopFrameModule = frameStackSize == 2
	protected def isPreTopFrameUnit = frameStackSize > 2

	protected def moduleName = generationContext.moduleName
	protected def frameStackSize = generationContext.frameStack.size

	protected def popFrame() = generationContext.frameStack.pop()

	protected def checkDeferredRules(ruleContext:RuleContext) = generationContext.checkDeferredRules(ruleContext)
}
