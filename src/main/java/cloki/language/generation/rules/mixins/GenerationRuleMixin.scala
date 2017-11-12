package cloki.language.generation.rules.mixins

import cloki.language.generation.{Generation, GenerationClassLoader}
import org.antlr.v4.runtime.RuleContext

private[generation] trait GenerationRuleMixin[RULE_CONTEXT <: RuleContext]
{
	protected val generationContext:Generation#GenerationContext
	protected val ruleContext:RULE_CONTEXT

	protected def classLoader:GenerationClassLoader = generationContext.classLoader

	protected def isTopFrameModule:Boolean = frameStackSize == 1
	protected def isTopFrameUnit:Boolean = frameStackSize > 1
	protected def isPreTopFrameModule:Boolean = frameStackSize == 2
	protected def isPreTopFrameUnit:Boolean = frameStackSize > 2

	protected def moduleName:String = generationContext.moduleName
	protected def frameStackSize:Int = generationContext.frameStack.size

	protected def popFrame():Unit = generationContext.frameStack.pop()

	protected def applyDeferredRules(ruleContext:RuleContext):Unit = generationContext.applyDeferredRules(ruleContext)
}
