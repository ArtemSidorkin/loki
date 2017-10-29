package cloki.language.generation.bytecode

import cloki.language.generation.CGenerator
import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.rules._
import cloki.language.generation.java.rules.CRuleGenerationJavaOperator
import cloki.language.parsing.CLokiParser._

class CGeneratorBytecode(moduleName:String) extends CGenerator[CGenerationContextBytecode]
{
	protected implicit val generationContext = new CGenerationContextBytecode(moduleName, classLoader)

	override def enterModule(ruleContext:ModuleContext) = CRuleGenerationBytecodeModule.enter(ruleContext)
	override def exitModule(ruleContext:ModuleContext) = CRuleGenerationBytecodeModule.exit(ruleContext)

	override def enterInstruction(ruleContext:InstructionContext) = CRuleGenerationBytecodeInstruction.enter(ruleContext)
	override def exitInstruction(ruleContext:InstructionContext) = CRuleGenerationBytecodeInstruction.exit(ruleContext)

	override def enterExpressionGroup(ruleContext:ExpressionGroupContext) =
		CRuleGenerationBytecodeStub.enter(ruleContext)

	override def exitExpressionGroup(ruleContext:ExpressionGroupContext) = CRuleGenerationBytecodeStub.exit(ruleContext)

	override def enterUnit(ruleContext:UnitContext) = CRuleGenerationBytecodeUnit.enter(ruleContext)
	override def exitUnit(ruleContext:UnitContext) = CRuleGenerationBytecodeUnit.exit(ruleContext)

	override def enterArray(ruleContext:ArrayContext) = CRuleGenerationBytecodeArray.enter(ruleContext)
	override def exitArray(ruleContext:ArrayContext) = CRuleGenerationBytecodeArray.exit(ruleContext)

	override def enterIndex(ruleContext:IndexContext) = CRuleGenerationBytecodeIndex.enter(ruleContext)
	override def exitIndex(ruleContext:IndexContext) = CRuleGenerationBytecodeIndex.exit(ruleContext)

	override def enterAssignIndex(ruleContext:AssignIndexContext) = CRuleGenerationBytecodeAssignIndex.enter(ruleContext)
	override def exitAssignIndex(ruleContext:AssignIndexContext) = CRuleGenerationBytecodeAssignIndex.exit(ruleContext)

	override def enterCall(ruleContext:CallContext) = CRuleGenerationBytecodeCall.enter(ruleContext)
	override def exitCall(ruleContext:CallContext) = CRuleGenerationBytecodeCall.exit(ruleContext)

	override def enterMemberCall(ruleContext:MemberCallContext) = CRuleGenerationBytecodeMemberCall.enter(ruleContext)
	override def exitMemberCall(ruleContext:MemberCallContext) = CRuleGenerationBytecodeMemberCall.exit(ruleContext)

	override def enterVariableOrParameter(ruleContext:VariableOrParameterContext) =
		CRuleGenerationBytecodeVariableOrParameter.enter(ruleContext)

	override def exitVariableOrParameter(ruleContext:VariableOrParameterContext) =
		CRuleGenerationBytecodeVariableOrParameter.exit(ruleContext)

	override def enterSuperHostMember(ruleContext:SuperHostMemberContext) =
		CRuleGenerationBytecodeSuperHostMember.enter(ruleContext)

	override def exitSuperHostMember(ruleContext:SuperHostMemberContext) =
		CRuleGenerationBytecodeSuperHostMember.exit(ruleContext)

	override def enterHostMember(ruleContext:HostMemberContext) = CRuleGenerationBytecodeHostMember.enter(ruleContext)
	override def exitHostMember(ruleContext:HostMemberContext) = CRuleGenerationBytecodeHostMember.exit(ruleContext)

	override def enterMember(ruleContext:MemberContext) = CRuleGenerationBytecodeMember.enter(ruleContext)
	override def exitMember(ruleContext:MemberContext) = CRuleGenerationBytecodeMember.exit(ruleContext)

	override def enterAssignVariable(ruleContext:AssignVariableContext) =
		CRuleGenerationBytecodeAssignVariable.enter(ruleContext)

	override def exitAssignVariable(ruleContext:AssignVariableContext) =
		CRuleGenerationBytecodeAssignVariable.exit(ruleContext)

	override def enterAssignHostMember(ruleContext:AssignHostMemberContext) =
		CRuleGenerationBytecodeAssignHostMember.enter(ruleContext)

	override def exitAssignHostMember(ruleContext:AssignHostMemberContext) =
		CRuleGenerationBytecodeAssignHostMember.exit(ruleContext)

	override def enterAssignMember(ruleContext:AssignMemberContext) =
		CRuleGenerationBytecodeAssignMember.enter(ruleContext)

	override def exitAssignMember(ruleContext:AssignMemberContext) =
		CRuleGenerationBytecodeAssignMember.exit(ruleContext)

	override def enterHost(ruleContext:HostContext) = CRuleGenerationBytecodeHost.enter(ruleContext)
	override def exitHost(ruleContext:HostContext) = CRuleGenerationBytecodeHost.exit(ruleContext)

	override def enterThis(ruleContext:ThisContext) = CRuleGenerationBytecodeThis.enter(ruleContext)
	override def exitThis(ruleContext:ThisContext) = CRuleGenerationBytecodeThis.exit(ruleContext)

	override def enterString(ruleContext:StringContext) = CRuleGenerationBytecodeString.enter(ruleContext)
	override def exitString(ruleContext:StringContext) = CRuleGenerationBytecodeString.exit(ruleContext)

	override def enterNumber(ruleContext:NumberContext) = CRuleGenerationBytecodeNumber.enter(ruleContext)
	override def exitNumber(ruleContext:NumberContext) = CRuleGenerationBytecodeNumber.exit(ruleContext)

	override def enterUnaryOperation(ruleContext:UnaryOperationContext) =
		CRuleGenerationBytecodeUnaryOperation.enter(ruleContext)
	override def exitUnaryOperation(ruleContext:UnaryOperationContext) =
		CRuleGenerationBytecodeUnaryOperation.exit(ruleContext)

	override def enterMulDiv(ruleContext:MulDivContext) = CRuleGenerationBytecodeOperator.enter(ruleContext)
	override def exitMulDiv(ruleContext:MulDivContext) = CRuleGenerationBytecodeOperator.exit(ruleContext)

	override def enterAddSub(ruleContext:AddSubContext) = CRuleGenerationBytecodeOperator.enter(ruleContext)
	override def exitAddSub(ruleContext:AddSubContext) = CRuleGenerationBytecodeOperator.exit(ruleContext)

	override def enterEqNeq(ruleContext:EqNeqContext) = CRuleGenerationBytecodeOperator.enter(ruleContext)
	override def exitEqNeq(ruleContext:EqNeqContext) = CRuleGenerationBytecodeOperator.exit(ruleContext)

	override def enterGteLteGtLt(ruleContext:GteLteGtLtContext) = CRuleGenerationBytecodeOperator.enter(ruleContext)
	override def exitGteLteGtLt(ruleContext:GteLteGtLtContext) = CRuleGenerationBytecodeOperator.exit(ruleContext)

	override def enterAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = CRuleGenerationBytecodeOperator.enter(ruleContext)
	override def exitAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = CRuleGenerationBytecodeOperator.exit(ruleContext)

	override def enterPipePipe(ruleContext:PipePipeContext) = CRuleGenerationBytecodeOperator.enter(ruleContext)
	override def exitPipePipe(ruleContext:PipePipeContext) = CRuleGenerationBytecodeOperator.exit(ruleContext)

	override def enterIfElse(ruleContext:IfElseContext) = CRuleGenerationBytecodeIfElse.enter(ruleContext)
	override def exitIfElse(ruleContext:IfElseContext) = CRuleGenerationBytecodeIfElse.exit(ruleContext)

	override def enterWhile(ruleContext:WhileContext) = CRuleGenerationBytecodeWhile.enter(ruleContext)
	override def exitWhile(ruleContext:WhileContext) = CRuleGenerationBytecodeWhile.exit(ruleContext)

	override def enterInheritance(ruleContext:InheritanceContext) =
		CRuleGenerationBytecodeInheritance.enter(ruleContext)
	override def exitInheritance(ruleContext:InheritanceContext) = CRuleGenerationBytecodeInheritance.exit(ruleContext)
}