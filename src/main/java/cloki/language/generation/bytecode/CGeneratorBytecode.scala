package cloki.language.generation.bytecode

import cloki.language.generation.Generator
import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.rules._
import cloki.language.generation.rules.GenerationRule
import cloki.language.parsing.LokiParser._

class CGeneratorBytecode(moduleName:String) extends Generator[CGenerationContextBytecode]
{
	protected implicit val generationContext = new CGenerationContextBytecode(moduleName, classLoader)

	override def enterModule(ruleContext:ModuleContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeModule(generationContext, ruleContext)).enter()
	override def exitModule(ruleContext:ModuleContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeModule(generationContext, ruleContext)).exit()

	override def enterInstruction(ruleContext:InstructionContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeInstruction(generationContext, ruleContext)).enter()
	override def exitInstruction(ruleContext:InstructionContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeInstruction(generationContext, ruleContext)).exit()

	override def enterExpressionGroup(ruleContext:ExpressionGroupContext) = ()
	override def exitExpressionGroup(ruleContext:ExpressionGroupContext) = ()

	override def enterUnit(ruleContext:UnitContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeUnit(generationContext, ruleContext)).enter() 
	override def exitUnit(ruleContext:UnitContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeUnit(generationContext, ruleContext)).exit() 

	override def enterArray(ruleContext:ArrayContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeArray(generationContext, ruleContext)).enter() 
	override def exitArray(ruleContext:ArrayContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeArray(generationContext, ruleContext)).exit() 

	override def enterIndex(ruleContext:IndexContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeIndex(generationContext, ruleContext)).enter() 
	override def exitIndex(ruleContext:IndexContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeIndex(generationContext, ruleContext)).exit() 

	override def enterAssignIndex(ruleContext:AssignIndexContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeAssignIndex(generationContext, ruleContext)).enter() 
	override def exitAssignIndex(ruleContext:AssignIndexContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeAssignIndex(generationContext, ruleContext)).exit() 

	override def enterCall(ruleContext:CallContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeCall(generationContext, ruleContext)).enter() 
	override def exitCall(ruleContext:CallContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeCall(generationContext, ruleContext)).exit() 

	override def enterMemberCall(ruleContext:MemberCallContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeMemberCall(generationContext, ruleContext)).enter() 
	override def exitMemberCall(ruleContext:MemberCallContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeMemberCall(generationContext, ruleContext)).exit() 

	override def enterVariableOrParameter(ruleContext:VariableOrParameterContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreBytecodeVariableOrParameter(generationContext, ruleContext)).enter() 

	override def exitVariableOrParameter(ruleContext:VariableOrParameterContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreBytecodeVariableOrParameter(generationContext, ruleContext)).exit() 

	override def enterSuperHostMember(ruleContext:SuperHostMemberContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreBytecodeSuperHostMember(generationContext, ruleContext)).enter() 

	override def exitSuperHostMember(ruleContext:SuperHostMemberContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreBytecodeSuperHostMember(generationContext, ruleContext)).exit() 

	override def enterHostMember(ruleContext:HostMemberContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeHostMember(generationContext, ruleContext)).enter() 
	override def exitHostMember(ruleContext:HostMemberContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeHostMember(generationContext, ruleContext)).exit() 

	override def enterMember(ruleContext:MemberContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeMember(generationContext, ruleContext)).enter() 
	override def exitMember(ruleContext:MemberContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeMember(generationContext, ruleContext)).exit() 

	override def enterAssignVariable(ruleContext:AssignVariableContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreBytecodeAssignVariable(generationContext, ruleContext)).enter() 

	override def exitAssignVariable(ruleContext:AssignVariableContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreBytecodeAssignVariable(generationContext, ruleContext)).exit() 

	override def enterAssignHostMember(ruleContext:AssignHostMemberContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreBytecodeAssignHostMember(generationContext, ruleContext)).enter() 

	override def exitAssignHostMember(ruleContext:AssignHostMemberContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreBytecodeAssignHostMember(generationContext, ruleContext)).exit() 

	override def enterAssignMember(ruleContext:AssignMemberContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreBytecodeAssignMember(generationContext, ruleContext)).enter() 

	override def exitAssignMember(ruleContext:AssignMemberContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreBytecodeAssignMember(generationContext, ruleContext)).exit() 

	override def enterHost(ruleContext:HostContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeHost(generationContext, ruleContext)).enter() 
	override def exitHost(ruleContext:HostContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeHost(generationContext, ruleContext)).exit() 

	override def enterThis(ruleContext:ThisContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeThis(generationContext, ruleContext)).enter() 
	override def exitThis(ruleContext:ThisContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeThis(generationContext, ruleContext)).enter() 

	override def enterString(ruleContext:StringContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeString(generationContext, ruleContext)).enter() 
	override def exitString(ruleContext:StringContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeString(generationContext, ruleContext)).exit() 

	override def enterNumber(ruleContext:NumberContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeNumber(generationContext, ruleContext)).enter() 
	override def exitNumber(ruleContext:NumberContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeNumber(generationContext, ruleContext)).exit() 

	override def enterUnaryOperation(ruleContext:UnaryOperationContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreBytecodeUnaryOperation(generationContext, ruleContext)).enter() 

	override def exitUnaryOperation(ruleContext:UnaryOperationContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreBytecodeUnaryOperation(generationContext, ruleContext)).exit() 

	override def enterMulDiv(ruleContext:MulDivContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeOperator(generationContext, ruleContext)).enter() 
	override def exitMulDiv(ruleContext:MulDivContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeOperator(generationContext, ruleContext)).exit() 

	override def enterAddSub(ruleContext:AddSubContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeOperator(generationContext, ruleContext)).enter() 
	override def exitAddSub(ruleContext:AddSubContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeOperator(generationContext, ruleContext)).exit() 

	override def enterEqNeq(ruleContext:EqNeqContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeOperator(generationContext, ruleContext)).enter() 
	override def exitEqNeq(ruleContext:EqNeqContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeOperator(generationContext, ruleContext)).exit() 

	override def enterGteLteGtLt(ruleContext:GteLteGtLtContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeOperator(generationContext, ruleContext)).enter() 
	override def exitGteLteGtLt(ruleContext:GteLteGtLtContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeOperator(generationContext, ruleContext)).exit() 

	override def enterAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeOperator(generationContext, ruleContext)).enter() 
	override def exitAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeOperator(generationContext, ruleContext)).exit() 

	override def enterPipePipe(ruleContext:PipePipeContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeOperator(generationContext, ruleContext)).enter() 
	override def exitPipePipe(ruleContext:PipePipeContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeOperator(generationContext, ruleContext)).exit() 

	override def enterIfElse(ruleContext:IfElseContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeIfElse(generationContext, ruleContext)).enter() 
	override def exitIfElse(ruleContext:IfElseContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeIfElse(generationContext, ruleContext)).exit() 

	override def enterWhile(ruleContext:WhileContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeWhile(generationContext, ruleContext)).enter() 
	override def exitWhile(ruleContext:WhileContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeWhile(generationContext, ruleContext)).exit() 

	override def enterInheritance(ruleContext:InheritanceContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreBytecodeInheritance(generationContext, ruleContext)).enter() 

	override def exitInheritance(ruleContext:InheritanceContext) = new GenerationRule(generationContext, ruleContext, new CCoreBytecodeInheritance(generationContext, ruleContext)).exit() 
}