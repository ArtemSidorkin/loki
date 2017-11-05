package cloki.language.generation

import org.antlr.v4.runtime.RuleContext

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

private[generation] trait Generation
{
	type GENERATION_CONTEXT <: GenerationContext
	type FRAME_STACK <: FrameStack
	type FRAME <: Frame

	abstract class GenerationContext(val moduleName:String, val classLoader:GenerationClassLoader)
	{
		private type RULE_TASKS = mutable.Map[RuleContext, mutable.ArrayStack[RULE_TASK]]
		private type RULE_TASK = ()=>Unit

		private case class DeferredRuleActions(enterAction:()=>Unit, exitAction:()=>Unit)

		val frameStack:FRAME_STACK = createFrameStack

		private val preEnterRuleTasks = createRuleTasks
		private val postEnterRuleTasks = createRuleTasks
		private val preExitRuleTasks = createRuleTasks
		private val postExitRuleTasks = createRuleTasks

		private val deferredRulesActions = mutable.HashMap[RuleContext, Option[DeferredRuleActions]]()

		private val deferredRulesByParentRule =
			mutable.HashMap[RuleContext, ArrayBuffer[RuleContext]]()
				.asInstanceOf[mutable.Map[RuleContext, mutable.Buffer[RuleContext]]]

		def createFrameStack:FRAME_STACK

		def addPreEnterRuleTask:(RuleContext, RULE_TASK) => Unit =
			addRuleTask(preEnterRuleTasks, _:RuleContext, _:RULE_TASK)

		def checkPreEnterRuleTasks:(RuleContext) => Unit = applyRuleTasks(preEnterRuleTasks, _:RuleContext)

		def addPostEnterRuleTask:(RuleContext, RULE_TASK) => Unit =
			addRuleTask(postEnterRuleTasks, _:RuleContext, _:RULE_TASK)

		def checkPostEnterRuleTasks:(RuleContext) => Unit = applyRuleTasks(postEnterRuleTasks, _:RuleContext)

		def addPreExitRuleTask:(RuleContext, RULE_TASK) => Unit =
			addRuleTask(preExitRuleTasks, _:RuleContext, _:RULE_TASK)

		def checkPreExitRuleTasks:(RuleContext) => Unit = applyRuleTasks(preExitRuleTasks, _:RuleContext)

		def addPostExitRuleTask:(RuleContext, RULE_TASK) => Unit =
			addRuleTask(postExitRuleTasks, _:RuleContext, _:RULE_TASK)

		def checkPostExitRuleTasks:(RuleContext) => Unit = applyRuleTasks(postExitRuleTasks, _:RuleContext)

		def deferRule(ruleContext:RuleContext)
		{
			deferredRulesActions(ruleContext) = None
			deferredRulesByParentRule.getOrElseUpdate(ruleContext.parent, ArrayBuffer()) += ruleContext
		}

		def setDeferredRuleActions(ruleContext:RuleContext, enterAction:()=>Unit, exitAction:()=>Unit)
		{
			deferredRulesActions(ruleContext) = Some(DeferredRuleActions(enterAction, exitAction))
			deferredRulesByParentRule.getOrElseUpdate(ruleContext.parent, ArrayBuffer()) += ruleContext
		}

		def isDeferredRule(ruleContext:RuleContext):Boolean =
			(deferredRulesActions contains ruleContext) || (deferredRulesActions contains ruleContext.parent)

		def applyDeferredRules(deferredOrParentRuleContext:RuleContext)
		{
			deferredRulesActions get deferredOrParentRuleContext foreach (_ foreach (_.enterAction()))
			deferredRulesByParentRule get deferredOrParentRuleContext foreach (_ foreach applyDeferredRules)
			deferredRulesActions get deferredOrParentRuleContext foreach (_ foreach (_.exitAction()))

			deferredRulesByParentRule -= deferredOrParentRuleContext
			deferredRulesActions -= deferredOrParentRuleContext
		}

		private def addRuleTask(tasks:RULE_TASKS, ruleContext:RuleContext, ruleTask:RULE_TASK):Unit =
			tasks.getOrElseUpdate(ruleContext, mutable.ArrayStack()) += ruleTask

		private def applyRuleTasks(ruleTasks:RULE_TASKS, ruleContext:RuleContext):Unit = (
			ruleTasks
				get ruleContext
				foreach (tasks =>
				{
					while(tasks.nonEmpty) tasks.pop()()

					ruleTasks -= ruleContext
				})
		)

		private def createRuleTasks = mutable.HashMap[RuleContext, mutable.ArrayStack[()=>Unit]]()
	}

	abstract class FrameStack
	{
		protected val frames:mutable.ArrayStack[FRAME] = mutable.ArrayStack().asInstanceOf[mutable.ArrayStack[FRAME]]

		def apply(frameIndex:Int):FRAME = frames(frameIndex)

		def size: Int = frames.size

		def pop():Unit = frames.pop()
		def top:FRAME = frames.top
		def preTop:FRAME = frames.tail.head
	}

	trait Frame
}



