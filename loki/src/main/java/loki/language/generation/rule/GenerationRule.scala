package loki.language.generation.rule

import assembler.builder.MethodBuilder
import loki.language.generation.GenerationContext
import loki.language.generation.classbuilder.{FrameClassBuilder, ModuleFrameClassBuilder, UnitFrameClassBuilder}
import loki.language.generation.constant.BytecodeCommon
import loki.language.generation.rule.mixin.GenerationRuleMixin
import org.antlr.v4.runtime.RuleContext

import scala.language.postfixOps

private[generation] class GenerationRule[RULE_CONTEXT <: RuleContext]
	(protected val ruleContext:RULE_CONTEXT)(implicit protected val generationContext:GenerationContext)
	extends GenerationRuleMixin[RULE_CONTEXT]
{
	protected def topFrameId:Long = generationContext.frameStack.top.id
	protected def preTopFrameId:Long = generationContext.frameStack.preTop.id
	protected def topClassFrame:FrameClassBuilder = generationContext.frameStack.top.classFrame
	protected def preTopClassFrame:FrameClassBuilder = generationContext.frameStack.preTop.classFrame
	protected def topMethodCall:MethodBuilder = topClassFrame.methodCall
	protected def preTopMethodCall:MethodBuilder = preTopClassFrame.methodCall

	def enter():Unit =
	{
		generationContext.checkPreEnterRuleTasks(ruleContext)
		enterAction()
		generationContext.checkPostEnterRuleTasks(ruleContext)
	}

	def exit():Unit =
	{
		generationContext.checkPreExitRuleTasks(ruleContext)
		exitAction()
		generationContext.checkPostExitRuleTasks(ruleContext)
	}

	protected def enterAction():Unit = ()

	protected def exitAction():Unit = ()

	protected def getFrameClass(frameIndex:Int):FrameClassBuilder = generationContext frameStack frameIndex classFrame

	protected def getFrameId(frameIndex:Int):Long = generationContext frameStack frameIndex id

	protected def pushModuleFrame():Unit =
		generationContext.frameStack.push(new ModuleFrameClassBuilder(generationContext.moduleName))

	protected def pushUnitFrame():Unit =
		generationContext
			.frameStack
			.push(id => new UnitFrameClassBuilder(BytecodeCommon.FRAME_CLASS_NAME(generationContext.moduleName, id)))
}

private[generation] object GenerationRule
{
	def enter
		[RULE_CONTEXT <: RuleContext](ruleContext:RULE_CONTEXT)(implicit generationContext:GenerationContext):Unit =
		new GenerationRule(ruleContext).enter()

	def exit
		[RULE_CONTEXT <: RuleContext](ruleContext:RULE_CONTEXT)(implicit generationContext:GenerationContext):Unit =
		new GenerationRule(ruleContext).exit()
}