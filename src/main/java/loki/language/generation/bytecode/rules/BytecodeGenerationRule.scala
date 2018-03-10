package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.BytecodeGeneration
import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.classes.{CClassModule, CClassUnit}
import loki.language.generation.bytecode.consts.CConstBytecodeCommon
import loki.language.generation.rules.GenerationRule
import org.antlr.v4.runtime.RuleContext


class BytecodeGenerationRule[RULE_CONTEXT <: RuleContext](generationContext:BytecodeGenerationContext, ruleContext:RULE_CONTEXT)
	extends GenerationRule(generationContext, ruleContext)
{
	def topFrameId = generationContext.frameStack.top.id
	def preTopFrameId = generationContext.frameStack.preTop.id
	def topClassFrame = generationContext.frameStack.top.classFrame
	def preTopClassFrame = generationContext.frameStack.preTop.classFrame
	def topMethodCall = topClassFrame.methodCall
	def preTopMethodCall = preTopClassFrame.methodCall
	def topOuterClassFieldName = CConstBytecodeCommon OUTER_CLASS_FIELD_NAME topFrameId
	def topParametersFieldName = CConstBytecodeCommon PARAMETERS_FIELD_NAME topFrameId

	def getFrameClass(frameIndex:Int) = generationContext frameStack frameIndex classFrame
	def getFrameId(frameIndex:Int) = generationContext frameStack frameIndex id
	def getOuterClassFieldName(frameId:BytecodeGeneration.ID) = CConstBytecodeCommon OUTER_CLASS_FIELD_NAME frameId
	def getParametersFieldName(frameId:BytecodeGeneration.ID) = CConstBytecodeCommon PARAMETERS_FIELD_NAME frameId

	def pushModuleFrame() = generationContext.frameStack.push(new CClassModule(generationContext.moduleName))
	def pushUnitFrame() = generationContext.frameStack.push(
		id => new CClassUnit(CConstBytecodeCommon.FRAME_CLASS_NAME(generationContext.moduleName, id))
	)
}
