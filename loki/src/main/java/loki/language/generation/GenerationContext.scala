package loki.language.generation

import org.antlr.v4.runtime.RuleContext

import scala.collection.mutable

class GenerationContext(val moduleName:String, val classLoader:GenerationClassLoader)
{
	private type RULE_TASKS = mutable.Map[RuleContext, mutable.Stack[RULE_TASK]]
	private type RULE_TASK = ()=>Unit

	val frameStack:BytecodeFrameStack = new BytecodeFrameStack

	private val ruleContextVariables:collection.mutable.Map[RuleContext, Any] = mutable.HashMap()

	private val preEnterRuleTasks = createRuleTasks
	private val postEnterRuleTasks = createRuleTasks
	private val preExitRuleTasks = createRuleTasks
	private val postExitRuleTasks = createRuleTasks

	def getRuleContextVariable[VARIABLE](ruleContext:RuleContext):VARIABLE =
		ruleContextVariables(ruleContext).asInstanceOf[VARIABLE]

	def setRuleContextVariable[VARIABLE](ruleContext:RuleContext, ruleContextVariable:VARIABLE):VARIABLE =
	{
		ruleContextVariables += (ruleContext -> ruleContextVariable)
		ruleContextVariable
	}

	def addPreEnterRuleTask:(RuleContext, RULE_TASK) => Unit =
		addRuleTask(preEnterRuleTasks, _:RuleContext, _:RULE_TASK)

	def checkPreEnterRuleTasks:RuleContext => Unit = applyRuleTasks(preEnterRuleTasks, _:RuleContext)

	def addPostEnterRuleTask:(RuleContext, RULE_TASK) => Unit =
		addRuleTask(postEnterRuleTasks, _:RuleContext, _:RULE_TASK)

	def checkPostEnterRuleTasks:RuleContext => Unit = applyRuleTasks(postEnterRuleTasks, _:RuleContext)

	def addPreExitRuleTask:(RuleContext, RULE_TASK) => Unit =
		addRuleTask(preExitRuleTasks, _:RuleContext, _:RULE_TASK)

	def checkPreExitRuleTasks:RuleContext => Unit = applyRuleTasks(preExitRuleTasks, _:RuleContext)

	def addPostExitRuleTask:(RuleContext, RULE_TASK) => Unit =
		addRuleTask(postExitRuleTasks, _:RuleContext, _:RULE_TASK)

	def checkPostExitRuleTasks: RuleContext => Unit = applyRuleTasks(postExitRuleTasks, _:RuleContext)

	private def addRuleTask(tasks:RULE_TASKS, ruleContext:RuleContext, ruleTask:RULE_TASK):Unit =
		tasks.getOrElseUpdate(ruleContext, mutable.Stack()) += ruleTask

	private def applyRuleTasks(ruleTasks:RULE_TASKS, ruleContext:RuleContext):Unit = (
		ruleTasks
			get ruleContext
			foreach (tasks =>
			{
				while(tasks.nonEmpty) tasks.pop()()

				ruleTasks -= ruleContext
			})
	)

	private def createRuleTasks = mutable.HashMap[RuleContext, mutable.Stack[()=>Unit]]()
}
