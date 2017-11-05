package cloki.language.generation.bytecode

import cloki.language.generation.Generator
import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.rules._
import cloki.language.generation.rules.GenerationRule
import cloki.language.parsing.LokiParser._

class CGeneratorBytecode(moduleName:String) extends Generator[CGenerationContextBytecode]
{
	protected implicit val generationContext = new CGenerationContextBytecode(moduleName, classLoader)

	override def enterModule(ruleContext:ModuleContext) = new GenerationRule(new CCoreBytecodeModule(generationContext, ruleContext)).enter(ruleContext)
	override def exitModule(ruleContext:ModuleContext) = new GenerationRule(new CCoreBytecodeModule(generationContext, ruleContext)).exit(ruleContext)

	override def enterInstruction(ruleContext:InstructionContext) = new GenerationRule(new CCoreBytecodeInstruction(generationContext, ruleContext)).enter(ruleContext)
	override def exitInstruction(ruleContext:InstructionContext) = new GenerationRule(new CCoreBytecodeInstruction(generationContext, ruleContext)).exit(ruleContext)

	override def enterExpressionGroup(ruleContext:ExpressionGroupContext) = ()
	override def exitExpressionGroup(ruleContext:ExpressionGroupContext) = ()

	override def enterUnit(ruleContext:UnitContext) = new GenerationRule(new CCoreBytecodeUnit(generationContext, ruleContext)).enter(ruleContext)
	override def exitUnit(ruleContext:UnitContext) = new GenerationRule(new CCoreBytecodeUnit(generationContext, ruleContext)).exit(ruleContext)

	override def enterArray(ruleContext:ArrayContext) = new GenerationRule(new CCoreBytecodeArray(generationContext, ruleContext)).enter(ruleContext)
	override def exitArray(ruleContext:ArrayContext) = new GenerationRule(new CCoreBytecodeArray(generationContext, ruleContext)).exit(ruleContext)

	override def enterIndex(ruleContext:IndexContext) = new GenerationRule(new CCoreBytecodeIndex(generationContext, ruleContext)).enter(ruleContext)
	override def exitIndex(ruleContext:IndexContext) = new GenerationRule(new CCoreBytecodeIndex(generationContext, ruleContext)).exit(ruleContext)

	override def enterAssignIndex(ruleContext:AssignIndexContext) = new GenerationRule(new CCoreBytecodeAssignIndex(generationContext, ruleContext)).enter(ruleContext)
	override def exitAssignIndex(ruleContext:AssignIndexContext) = new GenerationRule(new CCoreBytecodeAssignIndex(generationContext, ruleContext)).exit(ruleContext)

	override def enterCall(ruleContext:CallContext) = new GenerationRule(new CCoreBytecodeCall(generationContext, ruleContext)).enter(ruleContext)
	override def exitCall(ruleContext:CallContext) = new GenerationRule(new CCoreBytecodeCall(generationContext, ruleContext)).exit(ruleContext)

	override def enterMemberCall(ruleContext:MemberCallContext) = new GenerationRule(new CCoreBytecodeMemberCall(generationContext, ruleContext)).enter(ruleContext)
	override def exitMemberCall(ruleContext:MemberCallContext) = new GenerationRule(new CCoreBytecodeMemberCall(generationContext, ruleContext)).exit(ruleContext)

	override def enterVariableOrParameter(ruleContext:VariableOrParameterContext) =
		new GenerationRule(new CCoreBytecodeVariableOrParameter(generationContext, ruleContext)).enter(ruleContext)

	override def exitVariableOrParameter(ruleContext:VariableOrParameterContext) =
		new GenerationRule(new CCoreBytecodeVariableOrParameter(generationContext, ruleContext)).exit(ruleContext)

	override def enterSuperHostMember(ruleContext:SuperHostMemberContext) =
		new GenerationRule(new CCoreBytecodeSuperHostMember(generationContext, ruleContext)).enter(ruleContext)

	override def exitSuperHostMember(ruleContext:SuperHostMemberContext) =
		new GenerationRule(new CCoreBytecodeSuperHostMember(generationContext, ruleContext)).exit(ruleContext)

	override def enterHostMember(ruleContext:HostMemberContext) = new GenerationRule(new CCoreBytecodeHostMember(generationContext, ruleContext)).enter(ruleContext)
	override def exitHostMember(ruleContext:HostMemberContext) = new GenerationRule(new CCoreBytecodeHostMember(generationContext, ruleContext)).exit(ruleContext)

	override def enterMember(ruleContext:MemberContext) = new GenerationRule(new CCoreBytecodeMember(generationContext, ruleContext)).enter(ruleContext)
	override def exitMember(ruleContext:MemberContext) = new GenerationRule(new CCoreBytecodeMember(generationContext, ruleContext)).exit(ruleContext)

	override def enterAssignVariable(ruleContext:AssignVariableContext) =
		new GenerationRule(new CCoreBytecodeAssignVariable(generationContext, ruleContext)).enter(ruleContext)

	override def exitAssignVariable(ruleContext:AssignVariableContext) =
		new GenerationRule(new CCoreBytecodeAssignVariable(generationContext, ruleContext)).exit(ruleContext)

	override def enterAssignHostMember(ruleContext:AssignHostMemberContext) =
		new GenerationRule(new CCoreBytecodeAssignHostMember(generationContext, ruleContext)).enter(ruleContext)

	override def exitAssignHostMember(ruleContext:AssignHostMemberContext) =
		new GenerationRule(new CCoreBytecodeAssignHostMember(generationContext, ruleContext)).exit(ruleContext)

	override def enterAssignMember(ruleContext:AssignMemberContext) =
		new GenerationRule(new CCoreBytecodeAssignMember(generationContext, ruleContext)).enter(ruleContext)

	override def exitAssignMember(ruleContext:AssignMemberContext) =
		new GenerationRule(new CCoreBytecodeAssignMember(generationContext, ruleContext)).exit(ruleContext)

	override def enterHost(ruleContext:HostContext) = new GenerationRule(new CCoreBytecodeHost(generationContext, ruleContext)).enter(ruleContext)
	override def exitHost(ruleContext:HostContext) = new GenerationRule(new CCoreBytecodeHost(generationContext, ruleContext)).exit(ruleContext)

	override def enterThis(ruleContext:ThisContext) = new GenerationRule(new CCoreBytecodeThis(generationContext, ruleContext)).enter(ruleContext)
	override def exitThis(ruleContext:ThisContext) = new GenerationRule(new CCoreBytecodeThis(generationContext, ruleContext)).enter(ruleContext)

	override def enterString(ruleContext:StringContext) = new GenerationRule(new CCoreBytecodeString(generationContext, ruleContext)).enter(ruleContext)
	override def exitString(ruleContext:StringContext) = new GenerationRule(new CCoreBytecodeString(generationContext, ruleContext)).exit(ruleContext)

	override def enterNumber(ruleContext:NumberContext) = new GenerationRule(new CCoreBytecodeNumber(generationContext, ruleContext)).enter(ruleContext)
	override def exitNumber(ruleContext:NumberContext) = new GenerationRule(new CCoreBytecodeNumber(generationContext, ruleContext)).exit(ruleContext)

	override def enterUnaryOperation(ruleContext:UnaryOperationContext) =
		new GenerationRule(new CCoreBytecodeUnaryOperation(generationContext, ruleContext)).enter(ruleContext)

	override def exitUnaryOperation(ruleContext:UnaryOperationContext) =
		new GenerationRule(new CCoreBytecodeUnaryOperation(generationContext, ruleContext)).exit(ruleContext)

	override def enterMulDiv(ruleContext:MulDivContext) = new GenerationRule(new CCoreBytecodeOperator(generationContext, ruleContext)).enter(ruleContext)
	override def exitMulDiv(ruleContext:MulDivContext) = new GenerationRule(new CCoreBytecodeOperator(generationContext, ruleContext)).exit(ruleContext)

	override def enterAddSub(ruleContext:AddSubContext) = new GenerationRule(new CCoreBytecodeOperator(generationContext, ruleContext)).enter(ruleContext)
	override def exitAddSub(ruleContext:AddSubContext) = new GenerationRule(new CCoreBytecodeOperator(generationContext, ruleContext)).exit(ruleContext)

	override def enterEqNeq(ruleContext:EqNeqContext) = new GenerationRule(new CCoreBytecodeOperator(generationContext, ruleContext)).enter(ruleContext)
	override def exitEqNeq(ruleContext:EqNeqContext) = new GenerationRule(new CCoreBytecodeOperator(generationContext, ruleContext)).exit(ruleContext)

	override def enterGteLteGtLt(ruleContext:GteLteGtLtContext) = new GenerationRule(new CCoreBytecodeOperator(generationContext, ruleContext)).enter(ruleContext)
	override def exitGteLteGtLt(ruleContext:GteLteGtLtContext) = new GenerationRule(new CCoreBytecodeOperator(generationContext, ruleContext)).exit(ruleContext)

	override def enterAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = new GenerationRule(new CCoreBytecodeOperator(generationContext, ruleContext)).enter(ruleContext)
	override def exitAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = new GenerationRule(new CCoreBytecodeOperator(generationContext, ruleContext)).exit(ruleContext)

	override def enterPipePipe(ruleContext:PipePipeContext) = new GenerationRule(new CCoreBytecodeOperator(generationContext, ruleContext)).enter(ruleContext)
	override def exitPipePipe(ruleContext:PipePipeContext) = new GenerationRule(new CCoreBytecodeOperator(generationContext, ruleContext)).exit(ruleContext)

	override def enterIfElse(ruleContext:IfElseContext) = new GenerationRule(new CCoreBytecodeIfElse(generationContext, ruleContext)).enter(ruleContext)
	override def exitIfElse(ruleContext:IfElseContext) = new GenerationRule(new CCoreBytecodeIfElse(generationContext, ruleContext)).exit(ruleContext)

	override def enterWhile(ruleContext:WhileContext) = new GenerationRule(new CCoreBytecodeWhile(generationContext, ruleContext)).enter(ruleContext)
	override def exitWhile(ruleContext:WhileContext) = new GenerationRule(new CCoreBytecodeWhile(generationContext, ruleContext)).exit(ruleContext)

	override def enterInheritance(ruleContext:InheritanceContext) =
		new GenerationRule(new CCoreBytecodeInheritance(generationContext, ruleContext)).enter(ruleContext)

	override def exitInheritance(ruleContext:InheritanceContext) = new GenerationRule(new CCoreBytecodeInheritance(generationContext, ruleContext)).exit(ruleContext)
}