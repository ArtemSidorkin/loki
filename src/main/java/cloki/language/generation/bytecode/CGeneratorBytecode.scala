package cloki.language.generation.bytecode

import cloki.language.generation.Generator
import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.rules._
import cloki.language.parsing.LokiParser._

class CGeneratorBytecode(moduleName:String) extends Generator[CGenerationContextBytecode]
{
	protected implicit val generationContext = new CGenerationContextBytecode(moduleName, classLoader)

	override def enterModule(ruleContext:ModuleContext) = new GenerationRuleBytecodeModule(generationContext, ruleContext).enter()
	override def exitModule(ruleContext:ModuleContext) = new GenerationRuleBytecodeModule(generationContext, ruleContext).exit()

	override def enterInstruction(ruleContext:InstructionContext) = new GenerationRuleBytecodeInstruction(generationContext, ruleContext).enter()
	override def exitInstruction(ruleContext:InstructionContext) = new GenerationRuleBytecodeInstruction(generationContext, ruleContext).exit()

	override def enterExpressionGroup(ruleContext:ExpressionGroupContext) = ()
	override def exitExpressionGroup(ruleContext:ExpressionGroupContext) = ()

	override def enterUnit(ruleContext:UnitContext) = new GenerationRuleBytecodeUnit(generationContext, ruleContext).enter()
	override def exitUnit(ruleContext:UnitContext) = new GenerationRuleBytecodeUnit(generationContext, ruleContext).exit()

	override def enterArray(ruleContext:ArrayContext) = new GenerationRuleBytecodeArray(generationContext, ruleContext).enter()
	override def exitArray(ruleContext:ArrayContext) = new GenerationRuleBytecodeArray(generationContext, ruleContext).exit()

	override def enterIndex(ruleContext:IndexContext) = new GenerationRuleBytecodeIndex(generationContext, ruleContext).enter()
	override def exitIndex(ruleContext:IndexContext) = new GenerationRuleBytecodeIndex(generationContext, ruleContext).exit()

	override def enterAssignIndex(ruleContext:AssignIndexContext) = new GenerationRuleBytecodeAssignIndex(generationContext, ruleContext).enter()
	override def exitAssignIndex(ruleContext:AssignIndexContext) = new GenerationRuleBytecodeAssignIndex(generationContext, ruleContext).exit()

	override def enterCall(ruleContext:CallContext) = new GenerationRuleBytecodeCall(generationContext, ruleContext).enter()
	override def exitCall(ruleContext:CallContext) = new GenerationRuleBytecodeCall(generationContext, ruleContext).exit()

	override def enterMemberCall(ruleContext:MemberCallContext) = new GenerationRuleBytecodeMemberCall(generationContext, ruleContext).enter()
	override def exitMemberCall(ruleContext:MemberCallContext) = new GenerationRuleBytecodeMemberCall(generationContext, ruleContext).exit()

	override def enterVariableOrParameter(ruleContext:VariableOrParameterContext) =
		new GenerationRuleBytecodeVariableOrParameter(generationContext, ruleContext).enter()

	override def exitVariableOrParameter(ruleContext:VariableOrParameterContext) =
		new GenerationRuleBytecodeVariableOrParameter(generationContext, ruleContext).exit()

	override def enterSuperHostMember(ruleContext:SuperHostMemberContext) =
		new GenerationRuleBytecodeSuperHostMember(generationContext, ruleContext).enter()

	override def exitSuperHostMember(ruleContext:SuperHostMemberContext) =
		new GenerationRuleBytecodeSuperHostMember(generationContext, ruleContext).exit()

	override def enterHostMember(ruleContext:HostMemberContext) = new GenerationRuleBytecodeHostMember(generationContext, ruleContext).enter()
	override def exitHostMember(ruleContext:HostMemberContext) = new GenerationRuleBytecodeHostMember(generationContext, ruleContext).exit()

	override def enterMember(ruleContext:MemberContext) = new GenerationRuleBytecodeMember(generationContext, ruleContext).enter()
	override def exitMember(ruleContext:MemberContext) = new GenerationRuleBytecodeMember(generationContext, ruleContext).exit()

	override def enterAssignVariable(ruleContext:AssignVariableContext) =
		new GenerationRuleBytecodeAssignVariable(generationContext, ruleContext).enter()

	override def exitAssignVariable(ruleContext:AssignVariableContext) =
		new GenerationRuleBytecodeAssignVariable(generationContext, ruleContext).exit()

	override def enterAssignHostMember(ruleContext:AssignHostMemberContext) =
		new GenerationRuleBytecodeAssignHostMember(generationContext, ruleContext).enter()

	override def exitAssignHostMember(ruleContext:AssignHostMemberContext) =
		new GenerationRuleBytecodeAssignHostMember(generationContext, ruleContext).exit()

	override def enterAssignMember(ruleContext:AssignMemberContext) =
		new GenerationRuleBytecodeAssignMember(generationContext, ruleContext).enter()

	override def exitAssignMember(ruleContext:AssignMemberContext) =
		new GenerationRuleBytecodeAssignMember(generationContext, ruleContext).exit()

	override def enterHost(ruleContext:HostContext) = new GenerationRuleBytecodeHost(generationContext, ruleContext).enter()
	override def exitHost(ruleContext:HostContext) = new GenerationRuleBytecodeHost(generationContext, ruleContext).exit()

	override def enterThis(ruleContext:ThisContext) = new GenerationRuleBytecodeThis(generationContext, ruleContext).enter()
	override def exitThis(ruleContext:ThisContext) = new GenerationRuleBytecodeThis(generationContext, ruleContext).enter()

	override def enterString(ruleContext:StringContext) = new GenerationRuleBytecodeString(generationContext, ruleContext).enter()
	override def exitString(ruleContext:StringContext) = new GenerationRuleBytecodeString(generationContext, ruleContext).exit()

	override def enterNumber(ruleContext:NumberContext) = new GenerationRuleBytecodeNumber(generationContext, ruleContext).enter()
	override def exitNumber(ruleContext:NumberContext) = new GenerationRuleBytecodeNumber(generationContext, ruleContext).exit()

	override def enterUnaryOperation(ruleContext:UnaryOperationContext) =
		new GenerationRuleBytecodeUnaryOperation(generationContext, ruleContext).enter()

	override def exitUnaryOperation(ruleContext:UnaryOperationContext) =
		new GenerationRuleBytecodeUnaryOperation(generationContext, ruleContext).exit()

	override def enterMulDiv(ruleContext:MulDivContext) = new GenerationRuleBytecodeOperator(generationContext, ruleContext).enter()
	override def exitMulDiv(ruleContext:MulDivContext) = new GenerationRuleBytecodeOperator(generationContext, ruleContext).exit()

	override def enterAddSub(ruleContext:AddSubContext) = new GenerationRuleBytecodeOperator(generationContext, ruleContext).enter()
	override def exitAddSub(ruleContext:AddSubContext) = new GenerationRuleBytecodeOperator(generationContext, ruleContext).exit()

	override def enterEqNeq(ruleContext:EqNeqContext) = new GenerationRuleBytecodeOperator(generationContext, ruleContext).enter()
	override def exitEqNeq(ruleContext:EqNeqContext) = new GenerationRuleBytecodeOperator(generationContext, ruleContext).exit()

	override def enterGteLteGtLt(ruleContext:GteLteGtLtContext) = new GenerationRuleBytecodeOperator(generationContext, ruleContext).enter()
	override def exitGteLteGtLt(ruleContext:GteLteGtLtContext) = new GenerationRuleBytecodeOperator(generationContext, ruleContext).exit()

	override def enterAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = new GenerationRuleBytecodeOperator(generationContext, ruleContext).enter()
	override def exitAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = new GenerationRuleBytecodeOperator(generationContext, ruleContext).exit()

	override def enterPipePipe(ruleContext:PipePipeContext) = new GenerationRuleBytecodeOperator(generationContext, ruleContext).enter()
	override def exitPipePipe(ruleContext:PipePipeContext) = new GenerationRuleBytecodeOperator(generationContext, ruleContext).exit()

	override def enterIfElse(ruleContext:IfElseContext) = new GenerationRuleBytecodeIfElse(generationContext, ruleContext).enter()
	override def exitIfElse(ruleContext:IfElseContext) = new GenerationRuleBytecodeIfElse(generationContext, ruleContext).exit()

	override def enterWhile(ruleContext:WhileContext) = new GenerationRuleBytecodeWhile(generationContext, ruleContext).enter()
	override def exitWhile(ruleContext:WhileContext) = new GenerationRuleBytecodeWhile(generationContext, ruleContext).exit()

	override def enterInheritance(ruleContext:InheritanceContext) =
		new GenerationRuleBytecodeInheritance(generationContext, ruleContext).enter()

	override def exitInheritance(ruleContext:InheritanceContext) = new GenerationRuleBytecodeInheritance(generationContext, ruleContext).exit()
}