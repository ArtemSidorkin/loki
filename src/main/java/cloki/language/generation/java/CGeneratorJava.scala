package cloki.language.generation.java

import cloki.language.generation.Generator
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.java.rules._
import cloki.language.generation.rules.GenerationRule
import cloki.language.parsing.LokiParser._

class CGeneratorJava(moduleName:String) extends Generator[CGenerationContextJava]
{
	protected implicit val generationContext = new CGenerationContextJava(moduleName, classLoader)

	override def enterModule(ruleContext:ModuleContext) = new GenerationRule(new CCoreJavaModule(generationContext, ruleContext)).enter(ruleContext)
	override def exitModule(ruleContext:ModuleContext) = new GenerationRule(new CCoreJavaModule(generationContext, ruleContext)).exit(ruleContext)

	override def enterInstruction(ruleContext:InstructionContext) = new GenerationRule(new CCoreJavaInstruction(generationContext, ruleContext)).enter(ruleContext)
	override def exitInstruction(ruleContext:InstructionContext) = new GenerationRule(new CCoreJavaInstruction(generationContext, ruleContext)).exit(ruleContext)

	override def enterExpressionGroup(ruleContext:ExpressionGroupContext) = ()
	override def exitExpressionGroup(ruleContext:ExpressionGroupContext) = ()

	override def enterUnit(ruleContext:UnitContext) = new GenerationRule(new CCoreJavaUnit(generationContext, ruleContext)).enter(ruleContext)
	override def exitUnit(ruleContext:UnitContext) = new GenerationRule(new CCoreJavaUnit(generationContext, ruleContext)).exit(ruleContext)

	override def enterArray(ruleContext:ArrayContext) = new GenerationRule(new CCoreGenerationJavaArray(generationContext, ruleContext)).enter(ruleContext)
	override def exitArray(ruleContext:ArrayContext) = new GenerationRule(new CCoreGenerationJavaArray(generationContext, ruleContext)).exit(ruleContext)

	override def enterIndex(ruleContext:IndexContext) = new GenerationRule(new CCoreJavaIndex(generationContext, ruleContext)).enter(ruleContext)
	override def exitIndex(ruleContext:IndexContext) = new GenerationRule(new CCoreJavaIndex(generationContext, ruleContext)).exit(ruleContext)

	override def enterAssignIndex(ruleContext:AssignIndexContext) = new GenerationRule(new CCoreJavaAssignIndex(generationContext, ruleContext)).enter(ruleContext)
	override def exitAssignIndex(ruleContext:AssignIndexContext) = new GenerationRule(new CCoreJavaAssignIndex(generationContext, ruleContext)).exit(ruleContext)

	override def enterCall(ruleContext:CallContext) = new GenerationRule(new CCoreJavaCall(generationContext, ruleContext)).enter(ruleContext)
	override def exitCall(ruleContext:CallContext) = new GenerationRule(new CCoreJavaCall(generationContext, ruleContext)).exit(ruleContext)

	override def enterMemberCall(ruleContext:MemberCallContext) = new GenerationRule(new CCoreJavaMemberCall(generationContext, ruleContext)).enter(ruleContext)
	override def exitMemberCall(ruleContext:MemberCallContext) = new GenerationRule(new CCoreJavaMemberCall(generationContext, ruleContext)).exit(ruleContext)

	override def enterVariableOrParameter(ruleContext:VariableOrParameterContext) =
		new GenerationRule(new CCoreJavaVariableOrParameter(generationContext, ruleContext)).enter(ruleContext)

	override def exitVariableOrParameter(ruleContext:VariableOrParameterContext) =
		new GenerationRule(new CCoreJavaVariableOrParameter(generationContext, ruleContext)).exit(ruleContext)

	override def enterSuperHostMember(ruleContext:SuperHostMemberContext) =
		new GenerationRule(new CCoreJavaSuperHostMember(generationContext, ruleContext)).enter(ruleContext)

	override def exitSuperHostMember(ruleContext:SuperHostMemberContext) =
		new GenerationRule(new CCoreJavaSuperHostMember(generationContext, ruleContext)).exit(ruleContext)

	override def enterHostMember(ruleContext:HostMemberContext) = new GenerationRule(new CCoreJavaHostMember(generationContext, ruleContext)).enter(ruleContext)
	override def exitHostMember(ruleContext:HostMemberContext) = new GenerationRule(new CCoreJavaHostMember(generationContext, ruleContext)).exit(ruleContext)

	override def enterMember(ruleContext:MemberContext) = new GenerationRule(new CCoreJavaMember(generationContext, ruleContext)).enter(ruleContext)
	override def exitMember(ruleContext:MemberContext) = new GenerationRule(new CCoreJavaMember(generationContext, ruleContext)).exit(ruleContext)

	override def enterAssignVariable(ruleContext:AssignVariableContext) =
		new GenerationRule(new CCoreJavaAssignVariable(generationContext, ruleContext)).enter(ruleContext)

	override def exitAssignVariable(ruleContext:AssignVariableContext) =
		new GenerationRule(new CCoreJavaAssignVariable(generationContext, ruleContext)).exit(ruleContext)

	override def enterAssignHostMember(ruleContext:AssignHostMemberContext) =
		new GenerationRule(new CCoreJavaAssignHostMember(generationContext, ruleContext)).enter(ruleContext)

	override def exitAssignHostMember(ruleContext:AssignHostMemberContext) =
		new GenerationRule(new CCoreJavaAssignHostMember(generationContext, ruleContext)).exit(ruleContext)

	override def enterAssignMember(ruleContext:AssignMemberContext) = new GenerationRule(new CCoreJavaAssignMember(generationContext, ruleContext)).enter(ruleContext)
	override def exitAssignMember(ruleContext:AssignMemberContext) = new GenerationRule(new CCoreJavaAssignMember(generationContext, ruleContext)).exit(ruleContext)

	override def enterHost(ruleContext:HostContext) = new GenerationRule(new CCoreJavaHost(generationContext, ruleContext)).enter(ruleContext)
	override def exitHost(ruleContext:HostContext) = new GenerationRule(new CCoreJavaHost(generationContext, ruleContext)).exit(ruleContext)

	override def enterThis(ruleContext:ThisContext) = new GenerationRule(new CCoreJavaThis(generationContext, ruleContext)).enter(ruleContext)
	override def exitThis(ruleContext:ThisContext) = new GenerationRule(new CCoreJavaThis(generationContext, ruleContext)).exit(ruleContext)

	override def enterString(ruleContext:StringContext) = new GenerationRule(new CCoreJavaString(generationContext, ruleContext)).enter(ruleContext)
	override def exitString(ruleContext:StringContext) = new GenerationRule(new CCoreJavaString(generationContext, ruleContext)).exit(ruleContext)

	override def enterNumber(ruleContext:NumberContext) = new GenerationRule(new CCoreJavaNumber(generationContext, ruleContext)).enter(ruleContext)
	override def exitNumber(ruleContext:NumberContext) = new GenerationRule(new CCoreJavaNumber(generationContext, ruleContext)).exit(ruleContext)

	override def enterUnaryOperation(ruleContext:UnaryOperationContext) = new GenerationRule(new CCoreJavaUnaryOperation(generationContext, ruleContext)).enter(ruleContext)
	override def exitUnaryOperation(ruleContext:UnaryOperationContext) = new GenerationRule(new CCoreJavaUnaryOperation(generationContext, ruleContext)).exit(ruleContext)

	override def enterMulDiv(ruleContext:MulDivContext) = new GenerationRule(new CCoreJavaOperator(generationContext, ruleContext)).enter(ruleContext)
	override def exitMulDiv(ruleContext:MulDivContext) = new GenerationRule(new CCoreJavaOperator(generationContext, ruleContext)).exit(ruleContext)

	override def enterAddSub(ruleContext:AddSubContext) = new GenerationRule(new CCoreJavaOperator(generationContext, ruleContext)).enter(ruleContext)
	override def exitAddSub(ruleContext:AddSubContext) = new GenerationRule(new CCoreJavaOperator(generationContext, ruleContext)).exit(ruleContext)

	override def enterEqNeq(ruleContext:EqNeqContext) = new GenerationRule(new CCoreJavaOperator(generationContext, ruleContext)).enter(ruleContext)
	override def exitEqNeq(ruleContext:EqNeqContext) = new GenerationRule(new CCoreJavaOperator(generationContext, ruleContext)).exit(ruleContext)

	override def enterGteLteGtLt(ruleContext:GteLteGtLtContext) = new GenerationRule(new CCoreJavaOperator(generationContext, ruleContext)).enter(ruleContext)
	override def exitGteLteGtLt(ruleContext:GteLteGtLtContext) = new GenerationRule(new CCoreJavaOperator(generationContext, ruleContext)).exit(ruleContext)

	override def enterAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = new GenerationRule(new CCoreJavaOperator(generationContext, ruleContext)).enter(ruleContext)
	override def exitAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = new GenerationRule(new CCoreJavaOperator(generationContext, ruleContext)).exit(ruleContext)

	override def enterPipePipe(ruleContext:PipePipeContext) = new GenerationRule(new CCoreJavaOperator(generationContext, ruleContext)).enter(ruleContext)
	override def exitPipePipe(ruleContext:PipePipeContext) = new GenerationRule(new CCoreJavaOperator(generationContext, ruleContext)).exit(ruleContext)

	override def enterIfElse(ruleContext:IfElseContext) = new GenerationRule(new CCoreJavaIfElse(generationContext, ruleContext)).enter(ruleContext)
	override def exitIfElse(ruleContext:IfElseContext) = new GenerationRule(new CCoreJavaIfElse(generationContext, ruleContext)).exit(ruleContext)

	override def enterWhile(ruleContext:WhileContext) = new GenerationRule(new CCoreJavaWhile(generationContext, ruleContext)).enter(ruleContext)
	override def exitWhile(ruleContext:WhileContext) = new GenerationRule(new CCoreJavaWhile(generationContext, ruleContext)).exit(ruleContext)

	override def enterInheritance(ruleContext:InheritanceContext) = new GenerationRule(new CCoreJavaInheritance(generationContext, ruleContext)).enter(ruleContext)
	override def exitInheritance(ruleContext:InheritanceContext) = new GenerationRule(new CCoreJavaInheritance(generationContext, ruleContext)).exit(ruleContext)
}