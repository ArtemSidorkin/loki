package cloki.language.generation.java

import cloki.language.generation.Generator
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.java.rules._
import cloki.language.generation.rules.GenerationRule
import cloki.language.parsing.LokiParser._

class CGeneratorJava(moduleName:String) extends Generator[CGenerationContextJava]
{
	protected implicit val generationContext = new CGenerationContextJava(moduleName, classLoader)

	override def enterModule(ruleContext:ModuleContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaModule(generationContext, ruleContext)).enter()
	override def exitModule(ruleContext:ModuleContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaModule(generationContext, ruleContext)).exit()

	override def enterInstruction(ruleContext:InstructionContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaInstruction(generationContext, ruleContext)).enter()
	override def exitInstruction(ruleContext:InstructionContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaInstruction(generationContext, ruleContext)).exit()

	override def enterExpressionGroup(ruleContext:ExpressionGroupContext) = ()
	override def exitExpressionGroup(ruleContext:ExpressionGroupContext) = ()

	override def enterUnit(ruleContext:UnitContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaUnit(generationContext, ruleContext)).enter()
	override def exitUnit(ruleContext:UnitContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaUnit(generationContext, ruleContext)).exit()

	override def enterArray(ruleContext:ArrayContext) = new GenerationRule(generationContext, ruleContext, new CCoreGenerationJavaArray(generationContext, ruleContext)).enter()
	override def exitArray(ruleContext:ArrayContext) = new GenerationRule(generationContext, ruleContext, new CCoreGenerationJavaArray(generationContext, ruleContext)).exit()

	override def enterIndex(ruleContext:IndexContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaIndex(generationContext, ruleContext)).enter()
	override def exitIndex(ruleContext:IndexContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaIndex(generationContext, ruleContext)).exit()

	override def enterAssignIndex(ruleContext:AssignIndexContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaAssignIndex(generationContext, ruleContext)).enter()
	override def exitAssignIndex(ruleContext:AssignIndexContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaAssignIndex(generationContext, ruleContext)).exit()

	override def enterCall(ruleContext:CallContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaCall(generationContext, ruleContext)).enter()
	override def exitCall(ruleContext:CallContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaCall(generationContext, ruleContext)).exit()

	override def enterMemberCall(ruleContext:MemberCallContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaMemberCall(generationContext, ruleContext)).enter()
	override def exitMemberCall(ruleContext:MemberCallContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaMemberCall(generationContext, ruleContext)).exit()

	override def enterVariableOrParameter(ruleContext:VariableOrParameterContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreJavaVariableOrParameter(generationContext, ruleContext)).enter()

	override def exitVariableOrParameter(ruleContext:VariableOrParameterContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreJavaVariableOrParameter(generationContext, ruleContext)).exit()

	override def enterSuperHostMember(ruleContext:SuperHostMemberContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreJavaSuperHostMember(generationContext, ruleContext)).enter()

	override def exitSuperHostMember(ruleContext:SuperHostMemberContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreJavaSuperHostMember(generationContext, ruleContext)).exit()

	override def enterHostMember(ruleContext:HostMemberContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaHostMember(generationContext, ruleContext)).enter()
	override def exitHostMember(ruleContext:HostMemberContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaHostMember(generationContext, ruleContext)).exit()

	override def enterMember(ruleContext:MemberContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaMember(generationContext, ruleContext)).enter()
	override def exitMember(ruleContext:MemberContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaMember(generationContext, ruleContext)).exit()

	override def enterAssignVariable(ruleContext:AssignVariableContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreJavaAssignVariable(generationContext, ruleContext)).enter()

	override def exitAssignVariable(ruleContext:AssignVariableContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreJavaAssignVariable(generationContext, ruleContext)).exit()

	override def enterAssignHostMember(ruleContext:AssignHostMemberContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreJavaAssignHostMember(generationContext, ruleContext)).enter()

	override def exitAssignHostMember(ruleContext:AssignHostMemberContext) =
		new GenerationRule(generationContext, ruleContext, new CCoreJavaAssignHostMember(generationContext, ruleContext)).exit()

	override def enterAssignMember(ruleContext:AssignMemberContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaAssignMember(generationContext, ruleContext)).enter()
	override def exitAssignMember(ruleContext:AssignMemberContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaAssignMember(generationContext, ruleContext)).exit()

	override def enterHost(ruleContext:HostContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaHost(generationContext, ruleContext)).enter()
	override def exitHost(ruleContext:HostContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaHost(generationContext, ruleContext)).exit()

	override def enterThis(ruleContext:ThisContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaThis(generationContext, ruleContext)).enter()
	override def exitThis(ruleContext:ThisContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaThis(generationContext, ruleContext)).exit()

	override def enterString(ruleContext:StringContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaString(generationContext, ruleContext)).enter()
	override def exitString(ruleContext:StringContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaString(generationContext, ruleContext)).exit()

	override def enterNumber(ruleContext:NumberContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaNumber(generationContext, ruleContext)).enter()
	override def exitNumber(ruleContext:NumberContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaNumber(generationContext, ruleContext)).exit()

	override def enterUnaryOperation(ruleContext:UnaryOperationContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaUnaryOperation(generationContext, ruleContext)).enter()
	override def exitUnaryOperation(ruleContext:UnaryOperationContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaUnaryOperation(generationContext, ruleContext)).exit()

	override def enterMulDiv(ruleContext:MulDivContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaOperator(generationContext, ruleContext)).enter()
	override def exitMulDiv(ruleContext:MulDivContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaOperator(generationContext, ruleContext)).exit()

	override def enterAddSub(ruleContext:AddSubContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaOperator(generationContext, ruleContext)).enter()
	override def exitAddSub(ruleContext:AddSubContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaOperator(generationContext, ruleContext)).exit()

	override def enterEqNeq(ruleContext:EqNeqContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaOperator(generationContext, ruleContext)).enter()
	override def exitEqNeq(ruleContext:EqNeqContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaOperator(generationContext, ruleContext)).exit()

	override def enterGteLteGtLt(ruleContext:GteLteGtLtContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaOperator(generationContext, ruleContext)).enter()
	override def exitGteLteGtLt(ruleContext:GteLteGtLtContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaOperator(generationContext, ruleContext)).exit()

	override def enterAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaOperator(generationContext, ruleContext)).enter()
	override def exitAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaOperator(generationContext, ruleContext)).exit()

	override def enterPipePipe(ruleContext:PipePipeContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaOperator(generationContext, ruleContext)).enter()
	override def exitPipePipe(ruleContext:PipePipeContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaOperator(generationContext, ruleContext)).exit()

	override def enterIfElse(ruleContext:IfElseContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaIfElse(generationContext, ruleContext)).enter()
	override def exitIfElse(ruleContext:IfElseContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaIfElse(generationContext, ruleContext)).exit()

	override def enterWhile(ruleContext:WhileContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaWhile(generationContext, ruleContext)).enter()
	override def exitWhile(ruleContext:WhileContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaWhile(generationContext, ruleContext)).exit()

	override def enterInheritance(ruleContext:InheritanceContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaInheritance(generationContext, ruleContext)).enter()
	override def exitInheritance(ruleContext:InheritanceContext) = new GenerationRule(generationContext, ruleContext, new CCoreJavaInheritance(generationContext, ruleContext)).exit()
}