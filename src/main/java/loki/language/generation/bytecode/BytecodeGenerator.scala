package loki.language.generation.bytecode

import loki.language.generation.Generator
import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.rule._
import loki.language.parsing.LokiParser._

class BytecodeGenerator(moduleName:String) extends Generator[BytecodeGenerationContext]
{
	private implicit val bytecodeGenerationContext = new BytecodeGenerationContext(moduleName, classLoader)

	override def enterModule(ruleContext:ModuleContext):Unit =
		ModuleBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitModule(ruleContext:ModuleContext):Unit =
		ModuleBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterInstruction(ruleContext:InstructionContext):Unit =
		InstructionBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitInstruction(ruleContext:InstructionContext):Unit =
		InstructionBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterExpressionGroup(ruleContext:ExpressionGroupContext):Unit =
		new BytecodeGenerationRule[ExpressionGroupContext](bytecodeGenerationContext, ruleContext).enter()

	override def exitExpressionGroup(ruleContext:ExpressionGroupContext):Unit =
		new BytecodeGenerationRule[ExpressionGroupContext](bytecodeGenerationContext, ruleContext).exit()


	override def enterUnit(ruleContext:UnitContext):Unit =
		UnitBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitUnit(ruleContext:UnitContext):Unit =
		UnitBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterArray(ruleContext:ArrayContext):Unit =
		ArrayBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitArray(ruleContext:ArrayContext):Unit =
		ArrayBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterMap(ruleContext:MapContext):Unit =
		MapBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitMap(ruleContext:MapContext):Unit =
		MapBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterIndex(ruleContext:IndexContext):Unit =
		IndexBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitIndex(ruleContext:IndexContext):Unit =
		IndexBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterAssignIndex(ruleContext:AssignIndexContext):Unit =
		AssignIndexBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitAssignIndex(ruleContext:AssignIndexContext):Unit =
		AssignIndexBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterCall(ruleContext:CallContext):Unit =
		CallBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitCall(ruleContext:CallContext):Unit =
		CallBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterMemberCall(ruleContext:MemberCallContext):Unit =
		MemberCallBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitMemberCall(ruleContext:MemberCallContext):Unit =
		MemberCallBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterVariableOrParameter(ruleContext:VariableOrParameterContext):Unit =
		VariableOrParameterBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitVariableOrParameter(ruleContext:VariableOrParameterContext):Unit =
		VariableOrParameterBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterSuperHostMember(ruleContext:SuperHostMemberContext):Unit =
		SuperHostMemberBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitSuperHostMember(ruleContext:SuperHostMemberContext):Unit =
		SuperHostMemberBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterHostMember(ruleContext:HostMemberContext):Unit =
		HostMemberBytecodeGenerationRuleHostMember.enter(bytecodeGenerationContext, ruleContext)

	override def exitHostMember(ruleContext:HostMemberContext):Unit =
		HostMemberBytecodeGenerationRuleHostMember.exit(bytecodeGenerationContext, ruleContext)


	override def enterMember(ruleContext:MemberContext):Unit =
		MemberBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitMember(ruleContext:MemberContext):Unit =
		MemberBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterAssignVariable(ruleContext:AssignVariableContext):Unit =
		AssignVariableBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitAssignVariable(ruleContext:AssignVariableContext):Unit =
		AssignVariableBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterAssignHostMember(ruleContext:AssignHostMemberContext):Unit =
		AssignHostMemberBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitAssignHostMember(ruleContext:AssignHostMemberContext):Unit =
		AssignHostMemberBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterAssignMember(ruleContext:AssignMemberContext):Unit =
		AssignMemberBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitAssignMember(ruleContext:AssignMemberContext):Unit =
		AssignMemberBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterHost(ruleContext:HostContext):Unit =
		HostBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitHost(ruleContext:HostContext):Unit =
		HostBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterThis(ruleContext:ThisContext):Unit =
		ThisBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitThis(ruleContext:ThisContext):Unit =
		ThisBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)


	override def enterString(ruleContext:StringContext):Unit =
		StringBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitString(ruleContext:StringContext):Unit =
		StringBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterNumber(ruleContext:NumberContext):Unit =
		NumberBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitNumber(ruleContext:NumberContext):Unit =
		NumberBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterUnaryOperation(ruleContext:UnaryOperationContext):Unit =
		UnaryOperationBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitUnaryOperation(ruleContext:UnaryOperationContext):Unit =
		UnaryOperationBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterMulDiv(ruleContext:MulDivContext):Unit =
		OperatorBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitMulDiv(ruleContext:MulDivContext):Unit =
		OperatorBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterAddSub(ruleContext:AddSubContext):Unit =
		OperatorBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)
	
	override def exitAddSub(ruleContext:AddSubContext):Unit =
		OperatorBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterEqNeq(ruleContext:EqNeqContext):Unit = 
		OperatorBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)
	
	override def exitEqNeq(ruleContext:EqNeqContext):Unit = 
		OperatorBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterGteLteGtLt(ruleContext:GteLteGtLtContext):Unit = 
		OperatorBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)
	
	override def exitGteLteGtLt(ruleContext:GteLteGtLtContext):Unit = 
		OperatorBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterAmpersandAmpersand(ruleContext:AmpersandAmpersandContext):Unit = 
		OperatorBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)
	
	override def exitAmpersandAmpersand(ruleContext:AmpersandAmpersandContext):Unit = 
		OperatorBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterPipePipe(ruleContext:PipePipeContext):Unit = 
		OperatorBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)
	
	override def exitPipePipe(ruleContext:PipePipeContext):Unit = 
		OperatorBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterIfElse(ruleContext:IfElseContext):Unit = 
		IfElseBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)
	
	override def exitIfElse(ruleContext:IfElseContext):Unit = 
		IfElseBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterWhile(ruleContext:WhileContext):Unit = 
		WhileBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)
	
	override def exitWhile(ruleContext:WhileContext):Unit =
		WhileBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)


	override def enterInheritance(ruleContext:InheritanceContext):Unit =
		InheritanceBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitInheritance(ruleContext:InheritanceContext):Unit = 
		InheritanceBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)
}