package loki.language.generation.rule.mixin

import loki.language.generation.{GenerationClassLoader, GenerationContext}
import org.antlr.v4.runtime.{RuleContext, Token}
import org.antlr.v4.runtime.tree.TerminalNode

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

	protected def extractText(terminalNode:TerminalNode):Option[String] = Option(terminalNode).map(_.getText)

	protected def extractText(token: Token):Option[String] = Option(token).map(_.getText)
}
