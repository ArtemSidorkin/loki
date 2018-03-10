package loki.language.generation.bytecode

import loki.language.generation.Generator
import loki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import loki.language.generation.bytecode.rules._
import loki.language.parsing.LokiParser._

class CGeneratorBytecode(moduleName:String) extends Generator[CGenerationContextBytecode]
{
	protected implicit val generationContext = new CGenerationContextBytecode(moduleName, classLoader)

	override def enterModule(ruleContext:ModuleContext) = GenerationRuleBytecodeModule.enter(generationContext, ruleContext)
	override def exitModule(ruleContext:ModuleContext) = GenerationRuleBytecodeModule.exit(generationContext, ruleContext)

	override def enterInstruction(ruleContext:InstructionContext) = GenerationRuleBytecodeInstruction.enter(generationContext, ruleContext)
	override def exitInstruction(ruleContext:InstructionContext) = GenerationRuleBytecodeInstruction.exit(generationContext, ruleContext)

	override def enterExpressionGroup(ruleContext:ExpressionGroupContext) = new GenerationRuleBytecode[ExpressionGroupContext](generationContext, ruleContext).enter()
	override def exitExpressionGroup(ruleContext:ExpressionGroupContext) = new GenerationRuleBytecode[ExpressionGroupContext](generationContext, ruleContext).exit()

	override def enterUnit(ruleContext:UnitContext) = GenerationRuleBytecodeUnit.enter(generationContext, ruleContext)
	override def exitUnit(ruleContext:UnitContext) = GenerationRuleBytecodeUnit.exit(generationContext, ruleContext)

	override def enterArray(ruleContext:ArrayContext) = GenerationRuleBytecodeArray.enter(generationContext, ruleContext)
	override def exitArray(ruleContext:ArrayContext) = GenerationRuleBytecodeArray.exit(generationContext, ruleContext)

	override def enterMap(ruleContext:MapContext) = GenerationRuleBytecodeMap.enter(generationContext, ruleContext)
	override def exitMap(ruleContext:MapContext) = GenerationRuleBytecodeMap.exit(generationContext, ruleContext)

	override def enterIndex(ruleContext:IndexContext) = GenerationRuleBytecodeIndex.enter(generationContext, ruleContext)
	override def exitIndex(ruleContext:IndexContext) = GenerationRuleBytecodeIndex.exit(generationContext, ruleContext)

	override def enterAssignIndex(ruleContext:AssignIndexContext) = GenerationRuleBytecodeAssignIndex.enter(generationContext, ruleContext)
	override def exitAssignIndex(ruleContext:AssignIndexContext) = GenerationRuleBytecodeAssignIndex.exit(generationContext, ruleContext)

	override def enterCall(ruleContext:CallContext) = GenerationRuleBytecodeCall.enter(generationContext, ruleContext)
	override def exitCall(ruleContext:CallContext) = GenerationRuleBytecodeCall.exit(generationContext, ruleContext)

	override def enterMemberCall(ruleContext:MemberCallContext) = GenerationRuleBytecodeMemberCall.enter(generationContext, ruleContext)
	override def exitMemberCall(ruleContext:MemberCallContext) = GenerationRuleBytecodeMemberCall.exit(generationContext, ruleContext)

	override def enterVariableOrParameter(ruleContext:VariableOrParameterContext) =
		GenerationRuleBytecodeVariableOrParameter.enter(generationContext, ruleContext)

	override def exitVariableOrParameter(ruleContext:VariableOrParameterContext) =
		GenerationRuleBytecodeVariableOrParameter.exit(generationContext, ruleContext)

	override def enterSuperHostMember(ruleContext:SuperHostMemberContext) =
		GenerationRuleBytecodeSuperHostMember.enter(generationContext, ruleContext)

	override def exitSuperHostMember(ruleContext:SuperHostMemberContext) =
		GenerationRuleBytecodeSuperHostMember.exit(generationContext, ruleContext)

	override def enterHostMember(ruleContext:HostMemberContext) = GenerationRuleBytecodeHostMember.enter(generationContext, ruleContext)
	override def exitHostMember(ruleContext:HostMemberContext) = GenerationRuleBytecodeHostMember.exit(generationContext, ruleContext)

	override def enterMember(ruleContext:MemberContext) = GenerationRuleBytecodeMember.enter(generationContext, ruleContext)
	override def exitMember(ruleContext:MemberContext) = GenerationRuleBytecodeMember.exit(generationContext, ruleContext)

	override def enterAssignVariable(ruleContext:AssignVariableContext) =
		GenerationRuleBytecodeAssignVariable.enter(generationContext, ruleContext)

	override def exitAssignVariable(ruleContext:AssignVariableContext) =
		GenerationRuleBytecodeAssignVariable.exit(generationContext, ruleContext)

	override def enterAssignHostMember(ruleContext:AssignHostMemberContext) =
		GenerationRuleBytecodeAssignHostMember.enter(generationContext, ruleContext)

	override def exitAssignHostMember(ruleContext:AssignHostMemberContext) =
		GenerationRuleBytecodeAssignHostMember.exit(generationContext, ruleContext)

	override def enterAssignMember(ruleContext:AssignMemberContext) =
		GenerationRuleBytecodeAssignMember.enter(generationContext, ruleContext)

	override def exitAssignMember(ruleContext:AssignMemberContext) =
		GenerationRuleBytecodeAssignMember.exit(generationContext, ruleContext)

	override def enterHost(ruleContext:HostContext) = GenerationRuleBytecodeHost.enter(generationContext, ruleContext)
	override def exitHost(ruleContext:HostContext) = GenerationRuleBytecodeHost.exit(generationContext, ruleContext)

	override def enterThis(ruleContext:ThisContext) = GenerationRuleBytecodeThis.enter(generationContext, ruleContext)
	override def exitThis(ruleContext:ThisContext) = GenerationRuleBytecodeThis.enter(generationContext, ruleContext)

	override def enterString(ruleContext:StringContext) = GenerationRuleBytecodeString.enter(generationContext, ruleContext)
	override def exitString(ruleContext:StringContext) = GenerationRuleBytecodeString.exit(generationContext, ruleContext)

	override def enterNumber(ruleContext:NumberContext) = GenerationRuleBytecodeNumber.enter(generationContext, ruleContext)
	override def exitNumber(ruleContext:NumberContext) = GenerationRuleBytecodeNumber.exit(generationContext, ruleContext)

	override def enterUnaryOperation(ruleContext:UnaryOperationContext) =
		GenerationRuleBytecodeUnaryOperation.enter(generationContext, ruleContext)

	override def exitUnaryOperation(ruleContext:UnaryOperationContext) =
		GenerationRuleBytecodeUnaryOperation.exit(generationContext, ruleContext)

	override def enterMulDiv(ruleContext:MulDivContext) = GenerationRuleBytecodeOperator.enter(generationContext, ruleContext)
	override def exitMulDiv(ruleContext:MulDivContext) = GenerationRuleBytecodeOperator.exit(generationContext, ruleContext)

	override def enterAddSub(ruleContext:AddSubContext) = GenerationRuleBytecodeOperator.enter(generationContext, ruleContext)
	override def exitAddSub(ruleContext:AddSubContext) = GenerationRuleBytecodeOperator.exit(generationContext, ruleContext)

	override def enterEqNeq(ruleContext:EqNeqContext) = GenerationRuleBytecodeOperator.enter(generationContext, ruleContext)
	override def exitEqNeq(ruleContext:EqNeqContext) = GenerationRuleBytecodeOperator.exit(generationContext, ruleContext)

	override def enterGteLteGtLt(ruleContext:GteLteGtLtContext) = GenerationRuleBytecodeOperator.enter(generationContext, ruleContext)
	override def exitGteLteGtLt(ruleContext:GteLteGtLtContext) = GenerationRuleBytecodeOperator.exit(generationContext, ruleContext)

	override def enterAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = GenerationRuleBytecodeOperator.enter(generationContext, ruleContext)
	override def exitAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = GenerationRuleBytecodeOperator.exit(generationContext, ruleContext)

	override def enterPipePipe(ruleContext:PipePipeContext) = GenerationRuleBytecodeOperator.enter(generationContext, ruleContext)
	override def exitPipePipe(ruleContext:PipePipeContext) = GenerationRuleBytecodeOperator.exit(generationContext, ruleContext)

	override def enterIfElse(ruleContext:IfElseContext) = GenerationRuleBytecodeIfElse.enter(generationContext, ruleContext)
	override def exitIfElse(ruleContext:IfElseContext) = GenerationRuleBytecodeIfElse.exit(generationContext, ruleContext)

	override def enterWhile(ruleContext:WhileContext) = GenerationRuleBytecodeWhile.enter(generationContext, ruleContext)
	override def exitWhile(ruleContext:WhileContext) = GenerationRuleBytecodeWhile.exit(generationContext, ruleContext)

	override def enterInheritance(ruleContext:InheritanceContext) =
		GenerationRuleBytecodeInheritance.enter(generationContext, ruleContext)

	override def exitInheritance(ruleContext:InheritanceContext) = GenerationRuleBytecodeInheritance.exit(generationContext, ruleContext)
}