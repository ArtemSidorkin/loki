package cloki.language.generation

import org.antlr.v4.runtime.RuleContext

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

private[generation] trait CGeneration
{
	type GENERATION_CONTEXT <: CGenerationContext
	type FRAME_STACK <: CFrameStack
	type FRAME <: CFrame

	abstract class CGenerationContext(val moduleName:String, val classLoader:CClassLoader)
	{
		private type RULE_TASKS = mutable.Map[RuleContext, mutable.ArrayStack[()=>Unit]]
		private type DEFERRED_RULES = mutable.Map[RuleContext, Option[CDeferredRuleActions]]
		private type RULE_PARENT_CHILDREN = mutable.Map[RuleContext, mutable.Buffer[RuleContext]]

		private case class CDeferredRuleActions(enterAction:()=>Unit, exitAction:()=>Unit)

		val frameStack:FRAME_STACK = createFrameStack

		private val preEnterRuleTasks = createRuleTasks
		private val postEnterRuleTasks = createRuleTasks
		private val preExitRuleTasks = createRuleTasks
		private val postExitRuleTasks = createRuleTasks

		private val deferredRules = createDeferredRules
		private val deferredRuleParentChildren = createRuleParentChildren

		private def createRuleTasks = mutable.HashMap[RuleContext, mutable.ArrayStack[()=>Unit]]()
		private def createDeferredRules = mutable.HashMap[RuleContext, Option[CDeferredRuleActions]]()
		private def createRuleParentChildren = mutable.HashMap[RuleContext, ArrayBuffer[RuleContext]]().
			asInstanceOf[mutable.Map[RuleContext, mutable.Buffer[RuleContext]]]

		def createFrameStack:FRAME_STACK

		def addPreEnterRuleTask = addRuleTask(preEnterRuleTasks, _:RuleContext, _:()=>Unit)
		def checkPreEnterRuleTasks = checkRuleTasks(preEnterRuleTasks, _:RuleContext)
		def addPostEnterRuleTask = addRuleTask(postEnterRuleTasks, _:RuleContext, _:()=>Unit)
		def checkPostEnterRuleTasks = checkRuleTasks(postEnterRuleTasks, _:RuleContext)

		def addPreExitRuleTask = addRuleTask(preExitRuleTasks, _:RuleContext, _:()=>Unit)
		def checkPreExitRuleTasks = checkRuleTasks(preExitRuleTasks, _:RuleContext)
		def addPostExitRuleTask = addRuleTask(postExitRuleTasks, _:RuleContext, _:()=>Unit)
		def checkPostExitRuleTasks = checkRuleTasks(postExitRuleTasks, _:RuleContext)

		def deferRule(ruleContext:RuleContext)
		{
			deferredRules(ruleContext) = None
			deferredRuleParentChildren.getOrElseUpdate(ruleContext.parent, ArrayBuffer()) += ruleContext
		}

		def addDeferredRuleActions(ruleContext:RuleContext, enterRuleAction:()=>Unit, exitRuleAction:()=>Unit)
		{
			deferredRules(ruleContext) = Some(CDeferredRuleActions(enterRuleAction, exitRuleAction))
			deferredRuleParentChildren.getOrElseUpdate(ruleContext.parent, ArrayBuffer()) += ruleContext
		}

		def isDeferredRule(ruleContext:RuleContext) =
			(deferredRules contains ruleContext) || (deferredRules contains ruleContext.parent)

		def checkDeferredRules(ruleContext:RuleContext)
		{
			deferredRules get ruleContext foreach (_ foreach (_.enterAction()))
			deferredRuleParentChildren get ruleContext foreach (_ foreach checkDeferredRules)
			deferredRules get ruleContext foreach (_ foreach (_.exitAction()))

			deferredRuleParentChildren -= ruleContext
			deferredRules -= ruleContext
		}

		private def addRuleTask(tasks:RULE_TASKS, ruleContext:RuleContext, task:()=>Unit):Unit =
			tasks.getOrElseUpdate(ruleContext, mutable.ArrayStack()) += task

		private def checkRuleTasks(tasks:RULE_TASKS, ruleContext:RuleContext):Unit =
			tasks get ruleContext foreach (tsks =>
			{
				while(tsks.nonEmpty) tsks.pop()()
				tasks -= ruleContext
			})
	}

	abstract class CFrameStack
	{
		protected val frames:mutable.ArrayStack[FRAME] = mutable.ArrayStack().asInstanceOf[mutable.ArrayStack[FRAME]]

		def apply(frameIndex:Int) = frames(frameIndex)

		def size = frames.size

		def pop():Unit = frames.pop()
		def top = frames.top
		def preTop = frames.tail.head
	}

	trait CFrame
}



