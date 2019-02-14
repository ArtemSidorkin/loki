package loki.language.generation.rule.mixin

import loki.language.generation.{GenerationContext, GenerationClassLoader}
import org.antlr.v4.runtime.RuleContext

trait GenerationRuleMixin[RULE_CONTEXT <: RuleContext]
{
	protected val generationContext:GenerationContext
	protected val ruleContext:RULE_CONTEXT

	protected def classLoader:GenerationClassLoader = generationContext.classLoader

	protected def isTopFrameModule:Boolean = frameStackSize == 1
	protected def isTopFrameUnit:Boolean = frameStackSize > 1
	protected def isPreTopFrameModule:Boolean = frameStackSize == 2
	protected def isPreTopFrameUnit:Boolean = frameStackSize > 2

	protected def moduleName:String = generationContext.moduleName
	protected def frameStackSize:Int = generationContext.frameStack.size

	protected def popFrame():Unit = generationContext.frameStack.pop()
}
