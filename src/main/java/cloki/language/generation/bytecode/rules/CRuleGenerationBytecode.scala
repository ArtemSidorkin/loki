package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode
import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.classes.{CClassModule, CClassUnit}
import cloki.language.generation.bytecode.consts.CConstBytecodeCommon
import cloki.language.generation.rules.GGenerationRule
import org.antlr.v4.runtime.RuleContext

private[bytecode] trait CRuleGenerationBytecode[RULE_CONTEXT <: RuleContext]
	extends GGenerationRule[RULE_CONTEXT]
{
	type GENERATION_CONTEXT = CGenerationContextBytecode

	protected class CCoreBytecode(generationContext:CGenerationContextBytecode, ruleContext:RULE_CONTEXT)
		extends CCore(generationContext, ruleContext)
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
		def getOuterClassFieldName(frameId:CGenerationBytecode.ID) = CConstBytecodeCommon OUTER_CLASS_FIELD_NAME frameId
		def getParametersFieldName(frameId:CGenerationBytecode.ID) = CConstBytecodeCommon PARAMETERS_FIELD_NAME frameId

		def pushModuleFrame() = generationContext.frameStack.push(new CClassModule(generationContext.moduleName))
		def pushUnitFrame() = generationContext.frameStack.push(
			id => new CClassUnit(CConstBytecodeCommon.FRAME_CLASS_NAME(generationContext.moduleName, id))
		)
	}
}
