package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.classbuilder.{ModuleFrameClassBuilder, UnitFrameClassBuilder}
import loki.language.generation.constant.BytecodeCommon
import loki.language.generation.rule.mixin.GenerationRuleMixin
import org.antlr.v4.runtime.RuleContext


class GenerationRule[RULE_CONTEXT <: RuleContext](protected val generationContext:GenerationContext, protected val ruleContext:RULE_CONTEXT)
	extends GenerationRuleMixin[RULE_CONTEXT]
{
	protected def enterAction():Unit = ()
	protected def exitAction():Unit = ()

	def enter()
	{
		generationContext.checkPreEnterRuleTasks(ruleContext)
		enterAction()
		generationContext.checkPostEnterRuleTasks(ruleContext)
	}

	def exit()
	{
		generationContext.checkPreExitRuleTasks(ruleContext)
		exitAction()
		generationContext.checkPostExitRuleTasks(ruleContext)
	}

	protected def topFrameId = generationContext.frameStack.top.id
	protected def preTopFrameId = generationContext.frameStack.preTop.id
	protected def topClassFrame = generationContext.frameStack.top.classFrame
	protected def preTopClassFrame = generationContext.frameStack.preTop.classFrame
	protected def topMethodCall = topClassFrame.methodCall
	protected def preTopMethodCall = preTopClassFrame.methodCall
	protected def topOuterClassFieldName = BytecodeCommon OUTER_CLASS_FIELD_NAME topFrameId
	protected def topParametersFieldName = BytecodeCommon PARAMETERS_FIELD_NAME topFrameId

	protected def getFrameClass(frameIndex:Int) = generationContext frameStack frameIndex classFrame
	protected def getFrameId(frameIndex:Int) = generationContext frameStack frameIndex id
	protected def getOuterClassFieldName(frameId:Long) = BytecodeCommon OUTER_CLASS_FIELD_NAME frameId
	protected def getParametersFieldName(frameId:Long) = BytecodeCommon PARAMETERS_FIELD_NAME frameId

	protected def pushModuleFrame() = generationContext.frameStack.push(new ModuleFrameClassBuilder(generationContext.moduleName))
	protected def pushUnitFrame() = generationContext.frameStack.push(
		id => new UnitFrameClassBuilder(BytecodeCommon.FRAME_CLASS_NAME(generationContext.moduleName, id))
	)
}

object GenerationRule
{
	def enter[RULE_CONTEXT <: RuleContext](generationContext:GenerationContext, ruleContext:RULE_CONTEXT):Unit =
		new GenerationRule(generationContext, ruleContext).enter()

	def exit[RULE_CONTEXT <: RuleContext](generationContext:GenerationContext, ruleContext:RULE_CONTEXT):Unit =
		new GenerationRule(generationContext, ruleContext).exit()
}